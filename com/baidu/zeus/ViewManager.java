package com.baidu.zeus;

import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsoluteLayout;
import java.util.ArrayList;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ViewManager {
    private static final int MAX_SURFACE_DIMENSION = 2048;
    private final int MAX_SURFACE_AREA;
    private boolean mHidden;
    private boolean mReadyToDraw;
    private final WebView mWebView;
    private final ArrayList<ChildView> mChildren = new ArrayList<>();
    private boolean mZoomInProgress = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class ChildView {
        int height;
        View mView;
        int width;
        int x;
        int y;

        ChildView() {
        }

        void setBounds(int i, int i2, int i3, int i4) {
            this.x = i;
            this.y = i2;
            this.width = i3;
            this.height = i4;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void attachView(int i, int i2, int i3, int i4) {
            if (this.mView != null) {
                setBounds(i, i2, i3, i4);
                ViewManager.this.mWebView.mPrivateHandler.post(new Runnable() { // from class: com.baidu.zeus.ViewManager.ChildView.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ViewManager.this.requestLayout(ChildView.this);
                        if (ChildView.this.mView.getParent() == null) {
                            ChildView.this.attachViewOnUIThread();
                        }
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void attachViewOnUIThread() {
            ViewManager.this.mWebView.addView(this.mView);
            ViewManager.this.mChildren.add(this);
            if (!ViewManager.this.mReadyToDraw) {
                this.mView.setVisibility(8);
            }
        }

        public void removeView() {
            if (this.mView != null) {
                ViewManager.this.mWebView.mPrivateHandler.post(new Runnable() { // from class: com.baidu.zeus.ViewManager.ChildView.2
                    @Override // java.lang.Runnable
                    public void run() {
                        ChildView.this.removeViewOnUIThread();
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeViewOnUIThread() {
            ViewManager.this.mWebView.removeView(this.mView);
            ViewManager.this.mChildren.remove(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewManager(WebView webView) {
        this.mWebView = webView;
        this.MAX_SURFACE_AREA = (int) (webView.getResources().getDisplayMetrics().widthPixels * webView.getResources().getDisplayMetrics().heightPixels * 2.75d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ChildView createView() {
        return new ChildView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestLayout(ChildView childView) {
        AbsoluteLayout.LayoutParams layoutParams;
        int i;
        int i2 = 2048;
        int contentToViewDimension = this.mWebView.contentToViewDimension(childView.width);
        int contentToViewDimension2 = this.mWebView.contentToViewDimension(childView.height);
        int contentToViewX = this.mWebView.contentToViewX(childView.x);
        int contentToViewY = this.mWebView.contentToViewY(childView.y);
        ViewGroup.LayoutParams layoutParams2 = childView.mView.getLayoutParams();
        if (layoutParams2 instanceof AbsoluteLayout.LayoutParams) {
            layoutParams = (AbsoluteLayout.LayoutParams) layoutParams2;
            layoutParams.width = contentToViewDimension;
            layoutParams.height = contentToViewDimension2;
            layoutParams.x = contentToViewX;
            layoutParams.y = contentToViewY;
        } else {
            layoutParams = new AbsoluteLayout.LayoutParams(contentToViewDimension, contentToViewDimension2, contentToViewX, contentToViewY);
        }
        childView.mView.setLayoutParams(layoutParams);
        if (childView.mView instanceof SurfaceView) {
            final SurfaceView surfaceView = (SurfaceView) childView.mView;
            if (!JniUtil.myIsSurfaceViewFixedSize(surfaceView) || !this.mZoomInProgress) {
                if (contentToViewDimension <= 2048 && contentToViewDimension2 <= 2048) {
                    i = contentToViewDimension2;
                    i2 = contentToViewDimension;
                } else if (childView.width > childView.height) {
                    i = (childView.height * 2048) / childView.width;
                } else {
                    i2 = (childView.width * 2048) / childView.height;
                    i = 2048;
                }
                if (i2 * i > this.MAX_SURFACE_AREA) {
                    float f = this.MAX_SURFACE_AREA;
                    if (childView.width > childView.height) {
                        i2 = (int) Math.sqrt((f * childView.width) / childView.height);
                        i = (childView.height * i2) / childView.width;
                    } else {
                        i = (int) Math.sqrt((f * childView.height) / childView.width);
                        i2 = (childView.width * i) / childView.height;
                    }
                }
                if (i2 != contentToViewDimension || i != contentToViewDimension2) {
                    surfaceView.getHolder().setFixedSize(i2, i);
                } else if (!JniUtil.myIsSurfaceViewFixedSize(surfaceView) && this.mZoomInProgress) {
                    surfaceView.getHolder().setFixedSize(surfaceView.getWidth(), surfaceView.getHeight());
                } else if (JniUtil.myIsSurfaceViewFixedSize(surfaceView) && !this.mZoomInProgress) {
                    if (surfaceView.getVisibility() == 0) {
                        surfaceView.setVisibility(4);
                        surfaceView.getHolder().setSizeFromLayout();
                        this.mWebView.mPrivateHandler.post(new Runnable() { // from class: com.baidu.zeus.ViewManager.1
                            @Override // java.lang.Runnable
                            public void run() {
                                surfaceView.setVisibility(0);
                            }
                        });
                        return;
                    }
                    surfaceView.getHolder().setSizeFromLayout();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void startZoom() {
        this.mZoomInProgress = true;
        Iterator<ChildView> it = this.mChildren.iterator();
        while (it.hasNext()) {
            requestLayout(it.next());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void removeChildView() {
        Iterator<ChildView> it = this.mChildren.iterator();
        while (it.hasNext()) {
            it.next().removeView();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void endZoom() {
        this.mZoomInProgress = false;
        Iterator<ChildView> it = this.mChildren.iterator();
        while (it.hasNext()) {
            requestLayout(it.next());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void scaleAll() {
        Iterator<ChildView> it = this.mChildren.iterator();
        while (it.hasNext()) {
            requestLayout(it.next());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void hideAll() {
        if (!this.mHidden) {
            Iterator<ChildView> it = this.mChildren.iterator();
            while (it.hasNext()) {
                it.next().mView.setVisibility(8);
            }
            this.mHidden = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void showAll() {
        if (this.mHidden) {
            Iterator<ChildView> it = this.mChildren.iterator();
            while (it.hasNext()) {
                it.next().mView.setVisibility(0);
            }
            this.mHidden = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void postResetStateAll() {
        this.mWebView.mPrivateHandler.post(new Runnable() { // from class: com.baidu.zeus.ViewManager.2
            @Override // java.lang.Runnable
            public void run() {
                ViewManager.this.mReadyToDraw = false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void postReadyToDrawAll() {
        this.mWebView.mPrivateHandler.post(new Runnable() { // from class: com.baidu.zeus.ViewManager.3
            @Override // java.lang.Runnable
            public void run() {
                ViewManager.this.mReadyToDraw = true;
                Iterator it = ViewManager.this.mChildren.iterator();
                while (it.hasNext()) {
                    ((ChildView) it.next()).mView.setVisibility(0);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ChildView hitTest(int i, int i2) {
        if (this.mHidden) {
            return null;
        }
        Iterator<ChildView> it = this.mChildren.iterator();
        while (it.hasNext()) {
            ChildView next = it.next();
            if (next.mView.getVisibility() == 0 && i >= next.x && i < next.x + next.width && i2 >= next.y && i2 < next.y + next.height) {
                return next;
            }
        }
        return null;
    }
}
