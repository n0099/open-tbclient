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
    private int oVa;
    private float oVb;
    private boolean oVc;
    private boolean oVd;
    private WeakReference<ImageView> oVe;
    private com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.d oVf;
    private final Matrix oVg;
    private final Matrix oVh;
    private final RectF oVi;
    private c oVj;
    private InterfaceC0968d oVk;
    private f oVl;
    private e oVm;
    private int oVn;
    private int oVo;
    private int oVp;
    private int oVq;
    private b oVr;
    private int oVs;
    private boolean oVt;

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
        this.oVa = 200;
        this.mMinScale = 1.0f;
        this.oVb = 1.75f;
        this.mMaxScale = 3.0f;
        this.oVc = true;
        this.oVd = false;
        this.oVg = new Matrix();
        this.mDrawMatrix = new Matrix();
        this.oVh = new Matrix();
        this.oVi = new RectF();
        this.mMatrixValues = new float[9];
        this.oVs = 2;
        this.mScaleType = ImageView.ScaleType.FIT_CENTER;
        this.oVe = new WeakReference<>(imageView);
        imageView.setDrawingCacheEnabled(true);
        imageView.setOnTouchListener(this);
        ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }
        g(imageView);
        if (!imageView.isInEditMode()) {
            this.oVf = com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.f.a(imageView.getContext(), this);
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
        this.oVm = eVar;
    }

    public void cleanup() {
        if (this.oVe != null) {
            ImageView imageView = this.oVe.get();
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
            this.oVj = null;
            this.oVk = null;
            this.oVl = null;
            this.oVe = null;
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
        this.oVi.set(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        matrix.mapRect(this.oVi);
        return this.oVi;
    }

    public void setRotationTo(float f2) {
        this.oVh.setRotate(f2 % 360.0f);
        eji();
    }

    public void setRotationBy(float f2) {
        this.oVh.postRotate(f2 % 360.0f);
        eji();
    }

    public ImageView ejg() {
        ImageView imageView = null;
        if (this.oVe != null) {
            imageView = this.oVe.get();
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
        return this.oVb;
    }

    public float getMaximumScale() {
        return this.mMaxScale;
    }

    public float getScale() {
        return (float) Math.sqrt(((float) Math.pow(a(this.oVh, 0), 2.0d)) + ((float) Math.pow(a(this.oVh, 3), 2.0d)));
    }

    public ImageView.ScaleType getScaleType() {
        return this.mScaleType;
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.e
    public void onDrag(float f2, float f3) {
        if (!this.oVf.ejn()) {
            if (DEBUG) {
                com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.b.a.ejo().d("PhotoViewAttacher", String.format("onDrag: dx: %.2f. dy: %.2f", Float.valueOf(f2), Float.valueOf(f3)));
            }
            ImageView ejg = ejg();
            this.oVh.postTranslate(f2, f3);
            eji();
            ViewParent parent = ejg.getParent();
            if (this.oVc && !this.oVf.ejn() && !this.oVd) {
                if ((this.oVs == 2 || ((this.oVs == 0 && f2 >= 1.0f) || (this.oVs == 1 && f2 <= -1.0f))) && parent != null) {
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
        this.oVr = new b(ejg.getContext());
        this.oVr.O(h(ejg), i(ejg), (int) f4, (int) f5);
        ejg.post(this.oVr);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        ImageView ejg = ejg();
        if (ejg != null) {
            if (this.oVt) {
                int top = ejg.getTop();
                int right = ejg.getRight();
                int bottom = ejg.getBottom();
                int left = ejg.getLeft();
                if (top != this.oVn || bottom != this.oVp || left != this.oVq || right != this.oVo) {
                    q(ejg.getDrawable());
                    this.oVn = top;
                    this.oVo = right;
                    this.oVp = bottom;
                    this.oVq = left;
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
            if (this.oVm != null) {
                this.oVm.j(f2, f3, f4);
            }
            this.oVh.postScale(f2, f2, f3, f4);
            eji();
        }
    }

    @Override // android.view.View.OnTouchListener
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouch(View view, MotionEvent motionEvent) {
        RectF displayRect;
        boolean z;
        boolean z2 = false;
        if (this.oVt && f((ImageView) view)) {
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
            if (this.oVf != null) {
                boolean ejn = this.oVf.ejn();
                boolean isDragging = this.oVf.isDragging();
                z = this.oVf.onTouchEvent(motionEvent);
                boolean z3 = (ejn || this.oVf.ejn()) ? false : true;
                boolean z4 = (isDragging || this.oVf.isDragging()) ? false : true;
                if (z3 && z4) {
                    z2 = true;
                }
                this.oVd = z2;
            }
            if (this.mGestureDetector == null || !this.mGestureDetector.onTouchEvent(motionEvent)) {
                return z;
            }
            return true;
        }
        return false;
    }

    public void setAllowParentInterceptOnEdge(boolean z) {
        this.oVc = z;
    }

    public void setMinimumScale(float f2) {
        i(f2, this.oVb, this.mMaxScale);
        this.mMinScale = f2;
    }

    public void setMediumScale(float f2) {
        i(this.mMinScale, f2, this.mMaxScale);
        this.oVb = f2;
    }

    public void setMaximumScale(float f2) {
        i(this.mMinScale, this.oVb, f2);
        this.mMaxScale = f2;
    }

    public void setScaleLevels(float f2, float f3, float f4) {
        i(f2, f3, f4);
        this.mMinScale = f2;
        this.oVb = f3;
        this.mMaxScale = f4;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mLongClickListener = onLongClickListener;
    }

    public void setOnMatrixChangeListener(c cVar) {
        this.oVj = cVar;
    }

    public void setOnPhotoTapListener(InterfaceC0968d interfaceC0968d) {
        this.oVk = interfaceC0968d;
    }

    public InterfaceC0968d getOnPhotoTapListener() {
        return this.oVk;
    }

    public void setOnViewTapListener(f fVar) {
        this.oVl = fVar;
    }

    public f getOnViewTapListener() {
        return this.oVl;
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
                this.oVh.setScale(f2, f2, f3, f4);
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
        this.oVt = z;
        update();
    }

    public void update() {
        ImageView ejg = ejg();
        if (ejg != null) {
            if (this.oVt) {
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
        this.mDrawMatrix.set(this.oVg);
        this.mDrawMatrix.postConcat(this.oVh);
        return this.mDrawMatrix;
    }

    private void ejh() {
        if (this.oVr != null) {
            this.oVr.ejh();
            this.oVr = null;
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
                this.oVs = 2;
            } else if (d.left > 0.0f) {
                this.oVs = 0;
                f3 = -d.left;
            } else if (d.right < h) {
                f3 = h - d.right;
                this.oVs = 1;
            } else {
                this.oVs = -1;
            }
            this.oVh.postTranslate(f3, f2);
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
        this.oVa = i;
    }

    private float a(Matrix matrix, int i) {
        matrix.getValues(this.mMatrixValues);
        if (i < 0 || i >= this.mMatrixValues.length) {
            return 0.0f;
        }
        return this.mMatrixValues[i];
    }

    private void ejl() {
        this.oVh.reset();
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
            if (this.oVj != null && (d = d(matrix)) != null) {
                this.oVj.a(d);
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
            this.oVg.reset();
            float f2 = h / intrinsicWidth;
            float f3 = i / intrinsicHeight;
            if (this.mScaleType == ImageView.ScaleType.CENTER) {
                this.oVg.postTranslate((h - intrinsicWidth) / 2.0f, (i - intrinsicHeight) / 2.0f);
            } else if (this.mScaleType == ImageView.ScaleType.CENTER_CROP) {
                float max = Math.max(f2, f3);
                this.oVg.postScale(max, max);
                this.oVg.postTranslate((h - (intrinsicWidth * max)) / 2.0f, (i - (intrinsicHeight * max)) / 2.0f);
            } else if (this.mScaleType == ImageView.ScaleType.CENTER_INSIDE) {
                float min = Math.min(1.0f, Math.min(f2, f3));
                this.oVg.postScale(min, min);
                this.oVg.postTranslate((h - (intrinsicWidth * min)) / 2.0f, (i - (intrinsicHeight * min)) / 2.0f);
            } else {
                RectF rectF = new RectF(0.0f, 0.0f, intrinsicWidth, intrinsicHeight);
                RectF rectF2 = new RectF(0.0f, 0.0f, h, i);
                switch (AnonymousClass2.$SwitchMap$android$widget$ImageView$ScaleType[this.mScaleType.ordinal()]) {
                    case 2:
                        this.oVg.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.START);
                        break;
                    case 3:
                        this.oVg.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.END);
                        break;
                    case 4:
                        this.oVg.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
                        break;
                    case 5:
                        this.oVg.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.FILL);
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
        private final float oVv;
        private final float oVw;
        private final float oVx;
        private final float oVy;

        public a(float f, float f2, float f3, float f4) {
            this.oVv = f3;
            this.oVw = f4;
            this.oVx = f;
            this.oVy = f2;
        }

        @Override // java.lang.Runnable
        public void run() {
            ImageView ejg = d.this.ejg();
            if (ejg != null) {
                float ejm = ejm();
                float f = this.oVx + ((this.oVy - this.oVx) * ejm);
                if (d.this.getScale() > 0.0f) {
                    d.this.onScale(f / d.this.getScale(), this.oVv, this.oVw);
                    if (ejm < 1.0f) {
                        com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.postOnAnimation(ejg, this);
                    }
                }
            }
        }

        private float ejm() {
            return d.sInterpolator.getInterpolation(Math.min(1.0f, (((float) (System.currentTimeMillis() - this.mStartTime)) * 1.0f) / d.this.oVa));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class b implements Runnable {
        private int bJa;
        private int mCurrentX;
        private final com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.c.d oVz;

        public b(Context context) {
            this.oVz = com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.c.d.hB(context);
        }

        public void ejh() {
            if (d.DEBUG) {
                com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.b.a.ejo().d("PhotoViewAttacher", "Cancel Fling");
            }
            this.oVz.AB(true);
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
                    this.oVz.fling(round, round2, i3, i4, i6, i5, i8, i7, 0, 0);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            ImageView ejg;
            if (!this.oVz.isFinished() && (ejg = d.this.ejg()) != null && this.oVz.computeScrollOffset()) {
                int currX = this.oVz.getCurrX();
                int currY = this.oVz.getCurrY();
                if (d.DEBUG) {
                    com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.b.a.ejo().d("PhotoViewAttacher", "fling run(). CurrentX:" + this.mCurrentX + " CurrentY:" + this.bJa + " NewX:" + currX + " NewY:" + currY);
                }
                d.this.oVh.postTranslate(this.mCurrentX - currX, this.bJa - currY);
                d.this.e(d.this.getDrawMatrix());
                this.mCurrentX = currX;
                this.bJa = currY;
                com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.postOnAnimation(ejg, this);
            }
        }
    }
}
