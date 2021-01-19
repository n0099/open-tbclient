package com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import java.lang.ref.WeakReference;
/* loaded from: classes10.dex */
public class d implements View.OnTouchListener, ViewTreeObserver.OnGlobalLayoutListener, com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.e, com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.c {
    private static final boolean DEBUG = Log.isLoggable("PhotoViewAttacher", 3);
    static final Interpolator sInterpolator = new AccelerateDecelerateInterpolator();
    private final Matrix mDrawMatrix;
    private GestureDetector mGestureDetector;
    private View.OnLongClickListener mLongClickListener;
    private final float[] mMatrixValues;
    private float mMaxScale;
    private float mMinScale;
    private ImageView.ScaleType mScaleType;
    private int oVb;
    private float oVc;
    private boolean oVd;
    private boolean oVe;
    private WeakReference<ImageView> oVf;
    private com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.d oVg;
    private final Matrix oVh;
    private final Matrix oVi;
    private final RectF oVj;
    private c oVk;
    private InterfaceC0968d oVl;
    private f oVm;
    private e oVn;
    private int oVo;
    private int oVp;
    private int oVq;
    private int oVr;
    private b oVs;
    private int oVt;
    private boolean oVu;

    /* loaded from: classes10.dex */
    public interface c {
        void a(RectF rectF);
    }

    /* renamed from: com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.d$d  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0968d {
        void d(View view, float f, float f2);
    }

    /* loaded from: classes10.dex */
    public interface e {
        void j(float f, float f2, float f3);
    }

    /* loaded from: classes10.dex */
    public interface f {
        void e(View view, float f, float f2);
    }

    private static void i(float f2, float f3, float f4) {
        if (f2 >= f3) {
            com.baidu.yuyinala.privatemessage.implugin.util.c.e("PhotoViewAttacher", "MinZoom has to be less than MidZoom");
        } else if (f3 >= f4) {
            com.baidu.yuyinala.privatemessage.implugin.util.c.e("PhotoViewAttacher", "MidZoom has to be less than MaxZoom");
        }
    }

    private static boolean f(ImageView imageView) {
        return (imageView == null || imageView.getDrawable() == null) ? false : true;
    }

    private static boolean c(ImageView.ScaleType scaleType) {
        if (scaleType == null) {
            return false;
        }
        switch (AnonymousClass2.$SwitchMap$android$widget$ImageView$ScaleType[scaleType.ordinal()]) {
            case 1:
                com.baidu.yuyinala.privatemessage.implugin.util.c.e("PhotoViewAttacher", scaleType.name() + " is not supported in PhotoView");
                return false;
            default:
                return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.d$2  reason: invalid class name */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$android$widget$ImageView$ScaleType = new int[ImageView.ScaleType.values().length];

        static {
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.MATRIX.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_START.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_END.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_XY.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    private static void g(ImageView imageView) {
        if (imageView != null && !(imageView instanceof com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.c) && !ImageView.ScaleType.MATRIX.equals(imageView.getScaleType())) {
            imageView.setScaleType(ImageView.ScaleType.MATRIX);
        }
    }

    public d(ImageView imageView) {
        this(imageView, true);
    }

    public d(ImageView imageView, boolean z) {
        this.oVb = 200;
        this.mMinScale = 1.0f;
        this.oVc = 1.75f;
        this.mMaxScale = 3.0f;
        this.oVd = true;
        this.oVe = false;
        this.oVh = new Matrix();
        this.mDrawMatrix = new Matrix();
        this.oVi = new Matrix();
        this.oVj = new RectF();
        this.mMatrixValues = new float[9];
        this.oVt = 2;
        this.mScaleType = ImageView.ScaleType.FIT_CENTER;
        this.oVf = new WeakReference<>(imageView);
        imageView.setDrawingCacheEnabled(true);
        imageView.setOnTouchListener(this);
        ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }
        g(imageView);
        if (!imageView.isInEditMode()) {
            this.oVg = com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.f.a(imageView.getContext(), this);
            this.mGestureDetector = new GestureDetector(imageView.getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.d.1
                @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
                public void onLongPress(MotionEvent motionEvent) {
                    if (d.this.mLongClickListener != null) {
                        d.this.mLongClickListener.onLongClick(d.this.ejg());
                    }
                }
            });
            this.mGestureDetector.setOnDoubleTapListener(new com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.b(this));
            setZoomable(z);
        }
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        if (onDoubleTapListener != null) {
            this.mGestureDetector.setOnDoubleTapListener(onDoubleTapListener);
        } else {
            this.mGestureDetector.setOnDoubleTapListener(new com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.b(this));
        }
    }

    public void setOnScaleChangeListener(e eVar) {
        this.oVn = eVar;
    }

    public void cleanup() {
        if (this.oVf != null) {
            ImageView imageView = this.oVf.get();
            if (imageView != null) {
                ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
                if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeGlobalOnLayoutListener(this);
                }
                imageView.setOnTouchListener(null);
                ejh();
            }
            if (this.mGestureDetector != null) {
                this.mGestureDetector.setOnDoubleTapListener(null);
            }
            this.oVk = null;
            this.oVl = null;
            this.oVm = null;
            this.oVf = null;
        }
    }

    public RectF getDisplayRect() {
        ejk();
        return d(getDrawMatrix());
    }

    private RectF d(Matrix matrix) {
        Drawable drawable;
        ImageView ejg = ejg();
        if (ejg == null || (drawable = ejg.getDrawable()) == null) {
            return null;
        }
        this.oVj.set(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        matrix.mapRect(this.oVj);
        return this.oVj;
    }

    public void setRotationTo(float f2) {
        this.oVi.setRotate(f2 % 360.0f);
        eji();
    }

    public void setRotationBy(float f2) {
        this.oVi.postRotate(f2 % 360.0f);
        eji();
    }

    public ImageView ejg() {
        ImageView imageView = null;
        if (this.oVf != null) {
            imageView = this.oVf.get();
        }
        if (imageView == null) {
            cleanup();
            com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.b.a.ejo().i("PhotoViewAttacher", "ImageView no longer exists. You should not use this PhotoViewAttacher any more.");
        }
        return imageView;
    }

    public float getMinimumScale() {
        return this.mMinScale;
    }

    public float getMediumScale() {
        return this.oVc;
    }

    public float getMaximumScale() {
        return this.mMaxScale;
    }

    public float getScale() {
        return (float) Math.sqrt(((float) Math.pow(a(this.oVi, 0), 2.0d)) + ((float) Math.pow(a(this.oVi, 3), 2.0d)));
    }

    public ImageView.ScaleType getScaleType() {
        return this.mScaleType;
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.e
    public void onDrag(float f2, float f3) {
        if (!this.oVg.ejn()) {
            if (DEBUG) {
                com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.b.a.ejo().d("PhotoViewAttacher", String.format("onDrag: dx: %.2f. dy: %.2f", Float.valueOf(f2), Float.valueOf(f3)));
            }
            ImageView ejg = ejg();
            this.oVi.postTranslate(f2, f3);
            eji();
            ViewParent parent = ejg.getParent();
            if (this.oVd && !this.oVg.ejn() && !this.oVe) {
                if ((this.oVt == 2 || ((this.oVt == 0 && f2 >= 1.0f) || (this.oVt == 1 && f2 <= -1.0f))) && parent != null) {
                    parent.requestDisallowInterceptTouchEvent(false);
                }
            } else if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.e
    public void i(float f2, float f3, float f4, float f5) {
        if (DEBUG) {
            com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.b.a.ejo().d("PhotoViewAttacher", "onFling. sX: " + f2 + " sY: " + f3 + " Vx: " + f4 + " Vy: " + f5);
        }
        ImageView ejg = ejg();
        this.oVs = new b(ejg.getContext());
        this.oVs.O(h(ejg), i(ejg), (int) f4, (int) f5);
        ejg.post(this.oVs);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        ImageView ejg = ejg();
        if (ejg != null) {
            if (this.oVu) {
                int top = ejg.getTop();
                int right = ejg.getRight();
                int bottom = ejg.getBottom();
                int left = ejg.getLeft();
                if (top != this.oVo || bottom != this.oVq || left != this.oVr || right != this.oVp) {
                    q(ejg.getDrawable());
                    this.oVo = top;
                    this.oVp = right;
                    this.oVq = bottom;
                    this.oVr = left;
                    return;
                }
                return;
            }
            q(ejg.getDrawable());
        }
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.e
    public void onScale(float f2, float f3, float f4) {
        if (DEBUG) {
            com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.b.a.ejo().d("PhotoViewAttacher", String.format("onScale: scale: %.2f. fX: %.2f. fY: %.2f", Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)));
        }
        if (getScale() < this.mMaxScale || f2 < 1.0f) {
            if (this.oVn != null) {
                this.oVn.j(f2, f3, f4);
            }
            this.oVi.postScale(f2, f2, f3, f4);
            eji();
        }
    }

    @Override // android.view.View.OnTouchListener
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouch(View view, MotionEvent motionEvent) {
        RectF displayRect;
        boolean z;
        boolean z2 = false;
        if (this.oVu && f((ImageView) view)) {
            ViewParent parent = view.getParent();
            switch (motionEvent.getAction()) {
                case 0:
                    if (parent != null) {
                        parent.requestDisallowInterceptTouchEvent(true);
                    } else {
                        com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.b.a.ejo().i("PhotoViewAttacher", "onTouch getParent() returned null");
                    }
                    ejh();
                    z = false;
                    break;
                case 1:
                case 3:
                    if (getScale() < this.mMinScale && (displayRect = getDisplayRect()) != null) {
                        view.post(new a(getScale(), this.mMinScale, displayRect.centerX(), displayRect.centerY()));
                        z = true;
                        break;
                    }
                    break;
                case 2:
                default:
                    z = false;
                    break;
            }
            if (this.oVg != null) {
                boolean ejn = this.oVg.ejn();
                boolean isDragging = this.oVg.isDragging();
                z = this.oVg.onTouchEvent(motionEvent);
                boolean z3 = (ejn || this.oVg.ejn()) ? false : true;
                boolean z4 = (isDragging || this.oVg.isDragging()) ? false : true;
                if (z3 && z4) {
                    z2 = true;
                }
                this.oVe = z2;
            }
            if (this.mGestureDetector == null || !this.mGestureDetector.onTouchEvent(motionEvent)) {
                return z;
            }
            return true;
        }
        return false;
    }

    public void setAllowParentInterceptOnEdge(boolean z) {
        this.oVd = z;
    }

    public void setMinimumScale(float f2) {
        i(f2, this.oVc, this.mMaxScale);
        this.mMinScale = f2;
    }

    public void setMediumScale(float f2) {
        i(this.mMinScale, f2, this.mMaxScale);
        this.oVc = f2;
    }

    public void setMaximumScale(float f2) {
        i(this.mMinScale, this.oVc, f2);
        this.mMaxScale = f2;
    }

    public void setScaleLevels(float f2, float f3, float f4) {
        i(f2, f3, f4);
        this.mMinScale = f2;
        this.oVc = f3;
        this.mMaxScale = f4;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mLongClickListener = onLongClickListener;
    }

    public void setOnMatrixChangeListener(c cVar) {
        this.oVk = cVar;
    }

    public void setOnPhotoTapListener(InterfaceC0968d interfaceC0968d) {
        this.oVl = interfaceC0968d;
    }

    public InterfaceC0968d getOnPhotoTapListener() {
        return this.oVl;
    }

    public void setOnViewTapListener(f fVar) {
        this.oVm = fVar;
    }

    public f getOnViewTapListener() {
        return this.oVm;
    }

    public void setScale(float f2) {
        setScale(f2, false);
    }

    public void setScale(float f2, boolean z) {
        ImageView ejg = ejg();
        if (ejg != null) {
            setScale(f2, ejg.getRight() / 2, ejg.getBottom() / 2, z);
        }
    }

    public void setScale(float f2, float f3, float f4, boolean z) {
        ImageView ejg = ejg();
        if (ejg != null) {
            if (f2 < this.mMinScale || f2 > this.mMaxScale) {
                com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.b.a.ejo().i("PhotoViewAttacher", "Scale must be within the range of minScale and maxScale");
            } else if (z) {
                ejg.post(new a(getScale(), f2, f3, f4));
            } else {
                this.oVi.setScale(f2, f2, f3, f4);
                eji();
            }
        }
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        if (c(scaleType) && scaleType != this.mScaleType) {
            this.mScaleType = scaleType;
            update();
        }
    }

    public void setZoomable(boolean z) {
        this.oVu = z;
        update();
    }

    public void update() {
        ImageView ejg = ejg();
        if (ejg != null) {
            if (this.oVu) {
                g(ejg);
                q(ejg.getDrawable());
                return;
            }
            ejl();
        }
    }

    public Matrix getDisplayMatrix() {
        return new Matrix(getDrawMatrix());
    }

    public Matrix getDrawMatrix() {
        this.mDrawMatrix.set(this.oVh);
        this.mDrawMatrix.postConcat(this.oVi);
        return this.mDrawMatrix;
    }

    private void ejh() {
        if (this.oVs != null) {
            this.oVs.ejh();
            this.oVs = null;
        }
    }

    private void eji() {
        if (ejk()) {
            e(getDrawMatrix());
        }
    }

    private void ejj() {
        ImageView ejg = ejg();
        if (ejg != null && !(ejg instanceof com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.c) && !ImageView.ScaleType.MATRIX.equals(ejg.getScaleType())) {
            com.baidu.yuyinala.privatemessage.implugin.util.c.e("PhotoViewAttacher", "The ImageView's ScaleType has been changed since attaching a PhotoViewAttacher");
        }
    }

    private boolean ejk() {
        RectF d;
        float f2;
        float f3 = 0.0f;
        ImageView ejg = ejg();
        if (ejg != null && (d = d(getDrawMatrix())) != null) {
            float height = d.height();
            float width = d.width();
            int i = i(ejg);
            if (height <= i) {
                switch (AnonymousClass2.$SwitchMap$android$widget$ImageView$ScaleType[this.mScaleType.ordinal()]) {
                    case 2:
                        f2 = -d.top;
                        break;
                    case 3:
                        f2 = (i - height) - d.top;
                        break;
                    default:
                        f2 = ((i - height) / 2.0f) - d.top;
                        break;
                }
            } else if (d.top > 0.0f) {
                f2 = -d.top;
            } else {
                f2 = d.bottom < ((float) i) ? i - d.bottom : 0.0f;
            }
            int h = h(ejg);
            if (width <= h) {
                switch (AnonymousClass2.$SwitchMap$android$widget$ImageView$ScaleType[this.mScaleType.ordinal()]) {
                    case 2:
                        f3 = -d.left;
                        break;
                    case 3:
                        f3 = (h - width) - d.left;
                        break;
                    default:
                        f3 = ((h - width) / 2.0f) - d.left;
                        break;
                }
                this.oVt = 2;
            } else if (d.left > 0.0f) {
                this.oVt = 0;
                f3 = -d.left;
            } else if (d.right < h) {
                f3 = h - d.right;
                this.oVt = 1;
            } else {
                this.oVt = -1;
            }
            this.oVi.postTranslate(f3, f2);
            return true;
        }
        return false;
    }

    public Bitmap getVisibleRectangleBitmap() {
        ImageView ejg = ejg();
        if (ejg == null) {
            return null;
        }
        return ejg.getDrawingCache();
    }

    public void setZoomTransitionDuration(int i) {
        if (i < 0) {
            i = 200;
        }
        this.oVb = i;
    }

    private float a(Matrix matrix, int i) {
        matrix.getValues(this.mMatrixValues);
        if (i < 0 || i >= this.mMatrixValues.length) {
            return 0.0f;
        }
        return this.mMatrixValues[i];
    }

    private void ejl() {
        this.oVi.reset();
        e(getDrawMatrix());
        ejk();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(Matrix matrix) {
        RectF d;
        ImageView ejg = ejg();
        if (ejg != null) {
            ejj();
            ejg.setImageMatrix(matrix);
            if (this.oVk != null && (d = d(matrix)) != null) {
                this.oVk.a(d);
            }
        }
    }

    private void q(Drawable drawable) {
        ImageView ejg = ejg();
        if (ejg != null && drawable != null) {
            float h = h(ejg);
            float i = i(ejg);
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            this.oVh.reset();
            float f2 = h / intrinsicWidth;
            float f3 = i / intrinsicHeight;
            if (this.mScaleType == ImageView.ScaleType.CENTER) {
                this.oVh.postTranslate((h - intrinsicWidth) / 2.0f, (i - intrinsicHeight) / 2.0f);
            } else if (this.mScaleType == ImageView.ScaleType.CENTER_CROP) {
                float max = Math.max(f2, f3);
                this.oVh.postScale(max, max);
                this.oVh.postTranslate((h - (intrinsicWidth * max)) / 2.0f, (i - (intrinsicHeight * max)) / 2.0f);
            } else if (this.mScaleType == ImageView.ScaleType.CENTER_INSIDE) {
                float min = Math.min(1.0f, Math.min(f2, f3));
                this.oVh.postScale(min, min);
                this.oVh.postTranslate((h - (intrinsicWidth * min)) / 2.0f, (i - (intrinsicHeight * min)) / 2.0f);
            } else {
                RectF rectF = new RectF(0.0f, 0.0f, intrinsicWidth, intrinsicHeight);
                RectF rectF2 = new RectF(0.0f, 0.0f, h, i);
                switch (AnonymousClass2.$SwitchMap$android$widget$ImageView$ScaleType[this.mScaleType.ordinal()]) {
                    case 2:
                        this.oVh.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.START);
                        break;
                    case 3:
                        this.oVh.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.END);
                        break;
                    case 4:
                        this.oVh.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
                        break;
                    case 5:
                        this.oVh.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.FILL);
                        break;
                }
            }
            ejl();
        }
    }

    private int h(ImageView imageView) {
        if (imageView == null) {
            return 0;
        }
        return (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
    }

    private int i(ImageView imageView) {
        if (imageView == null) {
            return 0;
        }
        return (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class a implements Runnable {
        private final long mStartTime = System.currentTimeMillis();
        private final float oVw;
        private final float oVx;
        private final float oVy;
        private final float oVz;

        public a(float f, float f2, float f3, float f4) {
            this.oVw = f3;
            this.oVx = f4;
            this.oVy = f;
            this.oVz = f2;
        }

        @Override // java.lang.Runnable
        public void run() {
            ImageView ejg = d.this.ejg();
            if (ejg != null) {
                float ejm = ejm();
                float f = this.oVy + ((this.oVz - this.oVy) * ejm);
                if (d.this.getScale() > 0.0f) {
                    d.this.onScale(f / d.this.getScale(), this.oVw, this.oVx);
                    if (ejm < 1.0f) {
                        com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.postOnAnimation(ejg, this);
                    }
                }
            }
        }

        private float ejm() {
            return d.sInterpolator.getInterpolation(Math.min(1.0f, (((float) (System.currentTimeMillis() - this.mStartTime)) * 1.0f) / d.this.oVb));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class b implements Runnable {
        private int bJa;
        private int mCurrentX;
        private final com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.c.d oVA;

        public b(Context context) {
            this.oVA = com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.c.d.hB(context);
        }

        public void ejh() {
            if (d.DEBUG) {
                com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.b.a.ejo().d("PhotoViewAttacher", "Cancel Fling");
            }
            this.oVA.AB(true);
        }

        public void O(int i, int i2, int i3, int i4) {
            int i5;
            int i6;
            int i7;
            int i8;
            RectF displayRect = d.this.getDisplayRect();
            if (displayRect != null) {
                int round = Math.round(-displayRect.left);
                if (i < displayRect.width()) {
                    i5 = Math.round(displayRect.width() - i);
                    i6 = 0;
                } else {
                    i5 = round;
                    i6 = round;
                }
                int round2 = Math.round(-displayRect.top);
                if (i2 < displayRect.height()) {
                    i7 = Math.round(displayRect.height() - i2);
                    i8 = 0;
                } else {
                    i7 = round2;
                    i8 = round2;
                }
                this.mCurrentX = round;
                this.bJa = round2;
                if (d.DEBUG) {
                    com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.b.a.ejo().d("PhotoViewAttacher", "fling. StartX:" + round + " StartY:" + round2 + " MaxX:" + i5 + " MaxY:" + i7);
                }
                if (round != i5 || round2 != i7) {
                    this.oVA.fling(round, round2, i3, i4, i6, i5, i8, i7, 0, 0);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            ImageView ejg;
            if (!this.oVA.isFinished() && (ejg = d.this.ejg()) != null && this.oVA.computeScrollOffset()) {
                int currX = this.oVA.getCurrX();
                int currY = this.oVA.getCurrY();
                if (d.DEBUG) {
                    com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.b.a.ejo().d("PhotoViewAttacher", "fling run(). CurrentX:" + this.mCurrentX + " CurrentY:" + this.bJa + " NewX:" + currX + " NewY:" + currY);
                }
                d.this.oVi.postTranslate(this.mCurrentX - currX, this.bJa - currY);
                d.this.e(d.this.getDrawMatrix());
                this.mCurrentX = currX;
                this.bJa = currY;
                com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.postOnAnimation(ejg, this);
            }
        }
    }
}
