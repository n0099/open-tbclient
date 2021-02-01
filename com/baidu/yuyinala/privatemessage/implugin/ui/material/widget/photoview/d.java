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
/* loaded from: classes11.dex */
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
    private e pfA;
    private int pfB;
    private int pfC;
    private int pfD;
    private int pfE;
    private b pfF;
    private int pfG;
    private boolean pfH;
    private int pfo;
    private float pfp;
    private boolean pfq;
    private boolean pfr;
    private WeakReference<ImageView> pfs;
    private com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.d pft;
    private final Matrix pfu;
    private final Matrix pfv;
    private final RectF pfw;
    private c pfx;
    private InterfaceC0972d pfy;
    private f pfz;

    /* loaded from: classes11.dex */
    public interface c {
        void a(RectF rectF);
    }

    /* renamed from: com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.d$d  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0972d {
        void d(View view, float f, float f2);
    }

    /* loaded from: classes11.dex */
    public interface e {
        void j(float f, float f2, float f3);
    }

    /* loaded from: classes11.dex */
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
    /* loaded from: classes11.dex */
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
        this.pfo = 200;
        this.mMinScale = 1.0f;
        this.pfp = 1.75f;
        this.mMaxScale = 3.0f;
        this.pfq = true;
        this.pfr = false;
        this.pfu = new Matrix();
        this.mDrawMatrix = new Matrix();
        this.pfv = new Matrix();
        this.pfw = new RectF();
        this.mMatrixValues = new float[9];
        this.pfG = 2;
        this.mScaleType = ImageView.ScaleType.FIT_CENTER;
        this.pfs = new WeakReference<>(imageView);
        imageView.setDrawingCacheEnabled(true);
        imageView.setOnTouchListener(this);
        ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }
        g(imageView);
        if (!imageView.isInEditMode()) {
            this.pft = com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.f.a(imageView.getContext(), this);
            this.mGestureDetector = new GestureDetector(imageView.getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.d.1
                @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
                public void onLongPress(MotionEvent motionEvent) {
                    if (d.this.mLongClickListener != null) {
                        d.this.mLongClickListener.onLongClick(d.this.elA());
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
        this.pfA = eVar;
    }

    public void cleanup() {
        if (this.pfs != null) {
            ImageView imageView = this.pfs.get();
            if (imageView != null) {
                ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
                if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeGlobalOnLayoutListener(this);
                }
                imageView.setOnTouchListener(null);
                elB();
            }
            if (this.mGestureDetector != null) {
                this.mGestureDetector.setOnDoubleTapListener(null);
            }
            this.pfx = null;
            this.pfy = null;
            this.pfz = null;
            this.pfs = null;
        }
    }

    public RectF getDisplayRect() {
        elE();
        return d(getDrawMatrix());
    }

    private RectF d(Matrix matrix) {
        Drawable drawable;
        ImageView elA = elA();
        if (elA == null || (drawable = elA.getDrawable()) == null) {
            return null;
        }
        this.pfw.set(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        matrix.mapRect(this.pfw);
        return this.pfw;
    }

    public void setRotationTo(float f2) {
        this.pfv.setRotate(f2 % 360.0f);
        elC();
    }

    public void setRotationBy(float f2) {
        this.pfv.postRotate(f2 % 360.0f);
        elC();
    }

    public ImageView elA() {
        ImageView imageView = null;
        if (this.pfs != null) {
            imageView = this.pfs.get();
        }
        if (imageView == null) {
            cleanup();
            com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.b.a.elI().i("PhotoViewAttacher", "ImageView no longer exists. You should not use this PhotoViewAttacher any more.");
        }
        return imageView;
    }

    public float getMinimumScale() {
        return this.mMinScale;
    }

    public float getMediumScale() {
        return this.pfp;
    }

    public float getMaximumScale() {
        return this.mMaxScale;
    }

    public float getScale() {
        return (float) Math.sqrt(((float) Math.pow(a(this.pfv, 0), 2.0d)) + ((float) Math.pow(a(this.pfv, 3), 2.0d)));
    }

    public ImageView.ScaleType getScaleType() {
        return this.mScaleType;
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.e
    public void onDrag(float f2, float f3) {
        if (!this.pft.elH()) {
            if (DEBUG) {
                com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.b.a.elI().d("PhotoViewAttacher", String.format("onDrag: dx: %.2f. dy: %.2f", Float.valueOf(f2), Float.valueOf(f3)));
            }
            ImageView elA = elA();
            this.pfv.postTranslate(f2, f3);
            elC();
            ViewParent parent = elA.getParent();
            if (this.pfq && !this.pft.elH() && !this.pfr) {
                if ((this.pfG == 2 || ((this.pfG == 0 && f2 >= 1.0f) || (this.pfG == 1 && f2 <= -1.0f))) && parent != null) {
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
            com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.b.a.elI().d("PhotoViewAttacher", "onFling. sX: " + f2 + " sY: " + f3 + " Vx: " + f4 + " Vy: " + f5);
        }
        ImageView elA = elA();
        this.pfF = new b(elA.getContext());
        this.pfF.M(h(elA), i(elA), (int) f4, (int) f5);
        elA.post(this.pfF);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        ImageView elA = elA();
        if (elA != null) {
            if (this.pfH) {
                int top = elA.getTop();
                int right = elA.getRight();
                int bottom = elA.getBottom();
                int left = elA.getLeft();
                if (top != this.pfB || bottom != this.pfD || left != this.pfE || right != this.pfC) {
                    q(elA.getDrawable());
                    this.pfB = top;
                    this.pfC = right;
                    this.pfD = bottom;
                    this.pfE = left;
                    return;
                }
                return;
            }
            q(elA.getDrawable());
        }
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.e
    public void onScale(float f2, float f3, float f4) {
        if (DEBUG) {
            com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.b.a.elI().d("PhotoViewAttacher", String.format("onScale: scale: %.2f. fX: %.2f. fY: %.2f", Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)));
        }
        if (getScale() < this.mMaxScale || f2 < 1.0f) {
            if (this.pfA != null) {
                this.pfA.j(f2, f3, f4);
            }
            this.pfv.postScale(f2, f2, f3, f4);
            elC();
        }
    }

    @Override // android.view.View.OnTouchListener
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouch(View view, MotionEvent motionEvent) {
        RectF displayRect;
        boolean z;
        boolean z2 = false;
        if (this.pfH && f((ImageView) view)) {
            ViewParent parent = view.getParent();
            switch (motionEvent.getAction()) {
                case 0:
                    if (parent != null) {
                        parent.requestDisallowInterceptTouchEvent(true);
                    } else {
                        com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.b.a.elI().i("PhotoViewAttacher", "onTouch getParent() returned null");
                    }
                    elB();
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
            if (this.pft != null) {
                boolean elH = this.pft.elH();
                boolean isDragging = this.pft.isDragging();
                z = this.pft.onTouchEvent(motionEvent);
                boolean z3 = (elH || this.pft.elH()) ? false : true;
                boolean z4 = (isDragging || this.pft.isDragging()) ? false : true;
                if (z3 && z4) {
                    z2 = true;
                }
                this.pfr = z2;
            }
            if (this.mGestureDetector == null || !this.mGestureDetector.onTouchEvent(motionEvent)) {
                return z;
            }
            return true;
        }
        return false;
    }

    public void setAllowParentInterceptOnEdge(boolean z) {
        this.pfq = z;
    }

    public void setMinimumScale(float f2) {
        i(f2, this.pfp, this.mMaxScale);
        this.mMinScale = f2;
    }

    public void setMediumScale(float f2) {
        i(this.mMinScale, f2, this.mMaxScale);
        this.pfp = f2;
    }

    public void setMaximumScale(float f2) {
        i(this.mMinScale, this.pfp, f2);
        this.mMaxScale = f2;
    }

    public void setScaleLevels(float f2, float f3, float f4) {
        i(f2, f3, f4);
        this.mMinScale = f2;
        this.pfp = f3;
        this.mMaxScale = f4;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mLongClickListener = onLongClickListener;
    }

    public void setOnMatrixChangeListener(c cVar) {
        this.pfx = cVar;
    }

    public void setOnPhotoTapListener(InterfaceC0972d interfaceC0972d) {
        this.pfy = interfaceC0972d;
    }

    public InterfaceC0972d getOnPhotoTapListener() {
        return this.pfy;
    }

    public void setOnViewTapListener(f fVar) {
        this.pfz = fVar;
    }

    public f getOnViewTapListener() {
        return this.pfz;
    }

    public void setScale(float f2) {
        setScale(f2, false);
    }

    public void setScale(float f2, boolean z) {
        ImageView elA = elA();
        if (elA != null) {
            setScale(f2, elA.getRight() / 2, elA.getBottom() / 2, z);
        }
    }

    public void setScale(float f2, float f3, float f4, boolean z) {
        ImageView elA = elA();
        if (elA != null) {
            if (f2 < this.mMinScale || f2 > this.mMaxScale) {
                com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.b.a.elI().i("PhotoViewAttacher", "Scale must be within the range of minScale and maxScale");
            } else if (z) {
                elA.post(new a(getScale(), f2, f3, f4));
            } else {
                this.pfv.setScale(f2, f2, f3, f4);
                elC();
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
        this.pfH = z;
        update();
    }

    public void update() {
        ImageView elA = elA();
        if (elA != null) {
            if (this.pfH) {
                g(elA);
                q(elA.getDrawable());
                return;
            }
            elF();
        }
    }

    public Matrix getDisplayMatrix() {
        return new Matrix(getDrawMatrix());
    }

    public Matrix getDrawMatrix() {
        this.mDrawMatrix.set(this.pfu);
        this.mDrawMatrix.postConcat(this.pfv);
        return this.mDrawMatrix;
    }

    private void elB() {
        if (this.pfF != null) {
            this.pfF.elB();
            this.pfF = null;
        }
    }

    private void elC() {
        if (elE()) {
            e(getDrawMatrix());
        }
    }

    private void elD() {
        ImageView elA = elA();
        if (elA != null && !(elA instanceof com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.c) && !ImageView.ScaleType.MATRIX.equals(elA.getScaleType())) {
            com.baidu.yuyinala.privatemessage.implugin.util.c.e("PhotoViewAttacher", "The ImageView's ScaleType has been changed since attaching a PhotoViewAttacher");
        }
    }

    private boolean elE() {
        RectF d;
        float f2;
        float f3 = 0.0f;
        ImageView elA = elA();
        if (elA != null && (d = d(getDrawMatrix())) != null) {
            float height = d.height();
            float width = d.width();
            int i = i(elA);
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
            int h = h(elA);
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
                this.pfG = 2;
            } else if (d.left > 0.0f) {
                this.pfG = 0;
                f3 = -d.left;
            } else if (d.right < h) {
                f3 = h - d.right;
                this.pfG = 1;
            } else {
                this.pfG = -1;
            }
            this.pfv.postTranslate(f3, f2);
            return true;
        }
        return false;
    }

    public Bitmap getVisibleRectangleBitmap() {
        ImageView elA = elA();
        if (elA == null) {
            return null;
        }
        return elA.getDrawingCache();
    }

    public void setZoomTransitionDuration(int i) {
        if (i < 0) {
            i = 200;
        }
        this.pfo = i;
    }

    private float a(Matrix matrix, int i) {
        matrix.getValues(this.mMatrixValues);
        if (i < 0 || i >= this.mMatrixValues.length) {
            return 0.0f;
        }
        return this.mMatrixValues[i];
    }

    private void elF() {
        this.pfv.reset();
        e(getDrawMatrix());
        elE();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(Matrix matrix) {
        RectF d;
        ImageView elA = elA();
        if (elA != null) {
            elD();
            elA.setImageMatrix(matrix);
            if (this.pfx != null && (d = d(matrix)) != null) {
                this.pfx.a(d);
            }
        }
    }

    private void q(Drawable drawable) {
        ImageView elA = elA();
        if (elA != null && drawable != null) {
            float h = h(elA);
            float i = i(elA);
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            this.pfu.reset();
            float f2 = h / intrinsicWidth;
            float f3 = i / intrinsicHeight;
            if (this.mScaleType == ImageView.ScaleType.CENTER) {
                this.pfu.postTranslate((h - intrinsicWidth) / 2.0f, (i - intrinsicHeight) / 2.0f);
            } else if (this.mScaleType == ImageView.ScaleType.CENTER_CROP) {
                float max = Math.max(f2, f3);
                this.pfu.postScale(max, max);
                this.pfu.postTranslate((h - (intrinsicWidth * max)) / 2.0f, (i - (intrinsicHeight * max)) / 2.0f);
            } else if (this.mScaleType == ImageView.ScaleType.CENTER_INSIDE) {
                float min = Math.min(1.0f, Math.min(f2, f3));
                this.pfu.postScale(min, min);
                this.pfu.postTranslate((h - (intrinsicWidth * min)) / 2.0f, (i - (intrinsicHeight * min)) / 2.0f);
            } else {
                RectF rectF = new RectF(0.0f, 0.0f, intrinsicWidth, intrinsicHeight);
                RectF rectF2 = new RectF(0.0f, 0.0f, h, i);
                switch (AnonymousClass2.$SwitchMap$android$widget$ImageView$ScaleType[this.mScaleType.ordinal()]) {
                    case 2:
                        this.pfu.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.START);
                        break;
                    case 3:
                        this.pfu.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.END);
                        break;
                    case 4:
                        this.pfu.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
                        break;
                    case 5:
                        this.pfu.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.FILL);
                        break;
                }
            }
            elF();
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
    /* loaded from: classes11.dex */
    public class a implements Runnable {
        private final long mStartTime = System.currentTimeMillis();
        private final float pfJ;
        private final float pfK;
        private final float pfL;
        private final float pfM;

        public a(float f, float f2, float f3, float f4) {
            this.pfJ = f3;
            this.pfK = f4;
            this.pfL = f;
            this.pfM = f2;
        }

        @Override // java.lang.Runnable
        public void run() {
            ImageView elA = d.this.elA();
            if (elA != null) {
                float elG = elG();
                float f = this.pfL + ((this.pfM - this.pfL) * elG);
                if (d.this.getScale() > 0.0f) {
                    d.this.onScale(f / d.this.getScale(), this.pfJ, this.pfK);
                    if (elG < 1.0f) {
                        com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.postOnAnimation(elA, this);
                    }
                }
            }
        }

        private float elG() {
            return d.sInterpolator.getInterpolation(Math.min(1.0f, (((float) (System.currentTimeMillis() - this.mStartTime)) * 1.0f) / d.this.pfo));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class b implements Runnable {
        private int bMK;
        private int mCurrentX;
        private final com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.c.d pfN;

        public b(Context context) {
            this.pfN = com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.c.d.hE(context);
        }

        public void elB() {
            if (d.DEBUG) {
                com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.b.a.elI().d("PhotoViewAttacher", "Cancel Fling");
            }
            this.pfN.AU(true);
        }

        public void M(int i, int i2, int i3, int i4) {
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
                this.bMK = round2;
                if (d.DEBUG) {
                    com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.b.a.elI().d("PhotoViewAttacher", "fling. StartX:" + round + " StartY:" + round2 + " MaxX:" + i5 + " MaxY:" + i7);
                }
                if (round != i5 || round2 != i7) {
                    this.pfN.fling(round, round2, i3, i4, i6, i5, i8, i7, 0, 0);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            ImageView elA;
            if (!this.pfN.isFinished() && (elA = d.this.elA()) != null && this.pfN.computeScrollOffset()) {
                int currX = this.pfN.getCurrX();
                int currY = this.pfN.getCurrY();
                if (d.DEBUG) {
                    com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.b.a.elI().d("PhotoViewAttacher", "fling run(). CurrentX:" + this.mCurrentX + " CurrentY:" + this.bMK + " NewX:" + currX + " NewY:" + currY);
                }
                d.this.pfv.postTranslate(this.mCurrentX - currX, this.bMK - currY);
                d.this.e(d.this.getDrawMatrix());
                this.mCurrentX = currX;
                this.bMK = currY;
                com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.postOnAnimation(elA, this);
            }
        }
    }
}
