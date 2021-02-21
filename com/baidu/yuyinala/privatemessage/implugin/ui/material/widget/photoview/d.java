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
    private int pfO;
    private float pfP;
    private boolean pfQ;
    private boolean pfR;
    private WeakReference<ImageView> pfS;
    private com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.d pfT;
    private final Matrix pfU;
    private final Matrix pfV;
    private final RectF pfW;
    private c pfX;
    private InterfaceC0974d pfY;
    private f pfZ;
    private e pga;
    private int pgb;
    private int pgc;
    private int pgd;
    private int pge;
    private b pgf;
    private int pgg;
    private boolean pgh;

    /* loaded from: classes11.dex */
    public interface c {
        void a(RectF rectF);
    }

    /* renamed from: com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.d$d  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0974d {
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
        this.pfO = 200;
        this.mMinScale = 1.0f;
        this.pfP = 1.75f;
        this.mMaxScale = 3.0f;
        this.pfQ = true;
        this.pfR = false;
        this.pfU = new Matrix();
        this.mDrawMatrix = new Matrix();
        this.pfV = new Matrix();
        this.pfW = new RectF();
        this.mMatrixValues = new float[9];
        this.pgg = 2;
        this.mScaleType = ImageView.ScaleType.FIT_CENTER;
        this.pfS = new WeakReference<>(imageView);
        imageView.setDrawingCacheEnabled(true);
        imageView.setOnTouchListener(this);
        ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }
        g(imageView);
        if (!imageView.isInEditMode()) {
            this.pfT = com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.f.a(imageView.getContext(), this);
            this.mGestureDetector = new GestureDetector(imageView.getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.d.1
                @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
                public void onLongPress(MotionEvent motionEvent) {
                    if (d.this.mLongClickListener != null) {
                        d.this.mLongClickListener.onLongClick(d.this.elI());
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
        this.pga = eVar;
    }

    public void cleanup() {
        if (this.pfS != null) {
            ImageView imageView = this.pfS.get();
            if (imageView != null) {
                ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
                if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeGlobalOnLayoutListener(this);
                }
                imageView.setOnTouchListener(null);
                elJ();
            }
            if (this.mGestureDetector != null) {
                this.mGestureDetector.setOnDoubleTapListener(null);
            }
            this.pfX = null;
            this.pfY = null;
            this.pfZ = null;
            this.pfS = null;
        }
    }

    public RectF getDisplayRect() {
        elM();
        return d(getDrawMatrix());
    }

    private RectF d(Matrix matrix) {
        Drawable drawable;
        ImageView elI = elI();
        if (elI == null || (drawable = elI.getDrawable()) == null) {
            return null;
        }
        this.pfW.set(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        matrix.mapRect(this.pfW);
        return this.pfW;
    }

    public void setRotationTo(float f2) {
        this.pfV.setRotate(f2 % 360.0f);
        elK();
    }

    public void setRotationBy(float f2) {
        this.pfV.postRotate(f2 % 360.0f);
        elK();
    }

    public ImageView elI() {
        ImageView imageView = null;
        if (this.pfS != null) {
            imageView = this.pfS.get();
        }
        if (imageView == null) {
            cleanup();
            com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.b.a.elQ().i("PhotoViewAttacher", "ImageView no longer exists. You should not use this PhotoViewAttacher any more.");
        }
        return imageView;
    }

    public float getMinimumScale() {
        return this.mMinScale;
    }

    public float getMediumScale() {
        return this.pfP;
    }

    public float getMaximumScale() {
        return this.mMaxScale;
    }

    public float getScale() {
        return (float) Math.sqrt(((float) Math.pow(a(this.pfV, 0), 2.0d)) + ((float) Math.pow(a(this.pfV, 3), 2.0d)));
    }

    public ImageView.ScaleType getScaleType() {
        return this.mScaleType;
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.e
    public void onDrag(float f2, float f3) {
        if (!this.pfT.elP()) {
            if (DEBUG) {
                com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.b.a.elQ().d("PhotoViewAttacher", String.format("onDrag: dx: %.2f. dy: %.2f", Float.valueOf(f2), Float.valueOf(f3)));
            }
            ImageView elI = elI();
            this.pfV.postTranslate(f2, f3);
            elK();
            ViewParent parent = elI.getParent();
            if (this.pfQ && !this.pfT.elP() && !this.pfR) {
                if ((this.pgg == 2 || ((this.pgg == 0 && f2 >= 1.0f) || (this.pgg == 1 && f2 <= -1.0f))) && parent != null) {
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
            com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.b.a.elQ().d("PhotoViewAttacher", "onFling. sX: " + f2 + " sY: " + f3 + " Vx: " + f4 + " Vy: " + f5);
        }
        ImageView elI = elI();
        this.pgf = new b(elI.getContext());
        this.pgf.M(h(elI), i(elI), (int) f4, (int) f5);
        elI.post(this.pgf);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        ImageView elI = elI();
        if (elI != null) {
            if (this.pgh) {
                int top = elI.getTop();
                int right = elI.getRight();
                int bottom = elI.getBottom();
                int left = elI.getLeft();
                if (top != this.pgb || bottom != this.pgd || left != this.pge || right != this.pgc) {
                    q(elI.getDrawable());
                    this.pgb = top;
                    this.pgc = right;
                    this.pgd = bottom;
                    this.pge = left;
                    return;
                }
                return;
            }
            q(elI.getDrawable());
        }
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.e
    public void onScale(float f2, float f3, float f4) {
        if (DEBUG) {
            com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.b.a.elQ().d("PhotoViewAttacher", String.format("onScale: scale: %.2f. fX: %.2f. fY: %.2f", Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)));
        }
        if (getScale() < this.mMaxScale || f2 < 1.0f) {
            if (this.pga != null) {
                this.pga.j(f2, f3, f4);
            }
            this.pfV.postScale(f2, f2, f3, f4);
            elK();
        }
    }

    @Override // android.view.View.OnTouchListener
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouch(View view, MotionEvent motionEvent) {
        RectF displayRect;
        boolean z;
        boolean z2 = false;
        if (this.pgh && f((ImageView) view)) {
            ViewParent parent = view.getParent();
            switch (motionEvent.getAction()) {
                case 0:
                    if (parent != null) {
                        parent.requestDisallowInterceptTouchEvent(true);
                    } else {
                        com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.b.a.elQ().i("PhotoViewAttacher", "onTouch getParent() returned null");
                    }
                    elJ();
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
            if (this.pfT != null) {
                boolean elP = this.pfT.elP();
                boolean isDragging = this.pfT.isDragging();
                z = this.pfT.onTouchEvent(motionEvent);
                boolean z3 = (elP || this.pfT.elP()) ? false : true;
                boolean z4 = (isDragging || this.pfT.isDragging()) ? false : true;
                if (z3 && z4) {
                    z2 = true;
                }
                this.pfR = z2;
            }
            if (this.mGestureDetector == null || !this.mGestureDetector.onTouchEvent(motionEvent)) {
                return z;
            }
            return true;
        }
        return false;
    }

    public void setAllowParentInterceptOnEdge(boolean z) {
        this.pfQ = z;
    }

    public void setMinimumScale(float f2) {
        i(f2, this.pfP, this.mMaxScale);
        this.mMinScale = f2;
    }

    public void setMediumScale(float f2) {
        i(this.mMinScale, f2, this.mMaxScale);
        this.pfP = f2;
    }

    public void setMaximumScale(float f2) {
        i(this.mMinScale, this.pfP, f2);
        this.mMaxScale = f2;
    }

    public void setScaleLevels(float f2, float f3, float f4) {
        i(f2, f3, f4);
        this.mMinScale = f2;
        this.pfP = f3;
        this.mMaxScale = f4;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mLongClickListener = onLongClickListener;
    }

    public void setOnMatrixChangeListener(c cVar) {
        this.pfX = cVar;
    }

    public void setOnPhotoTapListener(InterfaceC0974d interfaceC0974d) {
        this.pfY = interfaceC0974d;
    }

    public InterfaceC0974d getOnPhotoTapListener() {
        return this.pfY;
    }

    public void setOnViewTapListener(f fVar) {
        this.pfZ = fVar;
    }

    public f getOnViewTapListener() {
        return this.pfZ;
    }

    public void setScale(float f2) {
        setScale(f2, false);
    }

    public void setScale(float f2, boolean z) {
        ImageView elI = elI();
        if (elI != null) {
            setScale(f2, elI.getRight() / 2, elI.getBottom() / 2, z);
        }
    }

    public void setScale(float f2, float f3, float f4, boolean z) {
        ImageView elI = elI();
        if (elI != null) {
            if (f2 < this.mMinScale || f2 > this.mMaxScale) {
                com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.b.a.elQ().i("PhotoViewAttacher", "Scale must be within the range of minScale and maxScale");
            } else if (z) {
                elI.post(new a(getScale(), f2, f3, f4));
            } else {
                this.pfV.setScale(f2, f2, f3, f4);
                elK();
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
        this.pgh = z;
        update();
    }

    public void update() {
        ImageView elI = elI();
        if (elI != null) {
            if (this.pgh) {
                g(elI);
                q(elI.getDrawable());
                return;
            }
            elN();
        }
    }

    public Matrix getDisplayMatrix() {
        return new Matrix(getDrawMatrix());
    }

    public Matrix getDrawMatrix() {
        this.mDrawMatrix.set(this.pfU);
        this.mDrawMatrix.postConcat(this.pfV);
        return this.mDrawMatrix;
    }

    private void elJ() {
        if (this.pgf != null) {
            this.pgf.elJ();
            this.pgf = null;
        }
    }

    private void elK() {
        if (elM()) {
            e(getDrawMatrix());
        }
    }

    private void elL() {
        ImageView elI = elI();
        if (elI != null && !(elI instanceof com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.c) && !ImageView.ScaleType.MATRIX.equals(elI.getScaleType())) {
            com.baidu.yuyinala.privatemessage.implugin.util.c.e("PhotoViewAttacher", "The ImageView's ScaleType has been changed since attaching a PhotoViewAttacher");
        }
    }

    private boolean elM() {
        RectF d;
        float f2;
        float f3 = 0.0f;
        ImageView elI = elI();
        if (elI != null && (d = d(getDrawMatrix())) != null) {
            float height = d.height();
            float width = d.width();
            int i = i(elI);
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
            int h = h(elI);
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
                this.pgg = 2;
            } else if (d.left > 0.0f) {
                this.pgg = 0;
                f3 = -d.left;
            } else if (d.right < h) {
                f3 = h - d.right;
                this.pgg = 1;
            } else {
                this.pgg = -1;
            }
            this.pfV.postTranslate(f3, f2);
            return true;
        }
        return false;
    }

    public Bitmap getVisibleRectangleBitmap() {
        ImageView elI = elI();
        if (elI == null) {
            return null;
        }
        return elI.getDrawingCache();
    }

    public void setZoomTransitionDuration(int i) {
        if (i < 0) {
            i = 200;
        }
        this.pfO = i;
    }

    private float a(Matrix matrix, int i) {
        matrix.getValues(this.mMatrixValues);
        if (i < 0 || i >= this.mMatrixValues.length) {
            return 0.0f;
        }
        return this.mMatrixValues[i];
    }

    private void elN() {
        this.pfV.reset();
        e(getDrawMatrix());
        elM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(Matrix matrix) {
        RectF d;
        ImageView elI = elI();
        if (elI != null) {
            elL();
            elI.setImageMatrix(matrix);
            if (this.pfX != null && (d = d(matrix)) != null) {
                this.pfX.a(d);
            }
        }
    }

    private void q(Drawable drawable) {
        ImageView elI = elI();
        if (elI != null && drawable != null) {
            float h = h(elI);
            float i = i(elI);
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            this.pfU.reset();
            float f2 = h / intrinsicWidth;
            float f3 = i / intrinsicHeight;
            if (this.mScaleType == ImageView.ScaleType.CENTER) {
                this.pfU.postTranslate((h - intrinsicWidth) / 2.0f, (i - intrinsicHeight) / 2.0f);
            } else if (this.mScaleType == ImageView.ScaleType.CENTER_CROP) {
                float max = Math.max(f2, f3);
                this.pfU.postScale(max, max);
                this.pfU.postTranslate((h - (intrinsicWidth * max)) / 2.0f, (i - (intrinsicHeight * max)) / 2.0f);
            } else if (this.mScaleType == ImageView.ScaleType.CENTER_INSIDE) {
                float min = Math.min(1.0f, Math.min(f2, f3));
                this.pfU.postScale(min, min);
                this.pfU.postTranslate((h - (intrinsicWidth * min)) / 2.0f, (i - (intrinsicHeight * min)) / 2.0f);
            } else {
                RectF rectF = new RectF(0.0f, 0.0f, intrinsicWidth, intrinsicHeight);
                RectF rectF2 = new RectF(0.0f, 0.0f, h, i);
                switch (AnonymousClass2.$SwitchMap$android$widget$ImageView$ScaleType[this.mScaleType.ordinal()]) {
                    case 2:
                        this.pfU.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.START);
                        break;
                    case 3:
                        this.pfU.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.END);
                        break;
                    case 4:
                        this.pfU.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
                        break;
                    case 5:
                        this.pfU.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.FILL);
                        break;
                }
            }
            elN();
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
        private final float pgj;
        private final float pgk;
        private final float pgl;
        private final float pgm;

        public a(float f, float f2, float f3, float f4) {
            this.pgj = f3;
            this.pgk = f4;
            this.pgl = f;
            this.pgm = f2;
        }

        @Override // java.lang.Runnable
        public void run() {
            ImageView elI = d.this.elI();
            if (elI != null) {
                float elO = elO();
                float f = this.pgl + ((this.pgm - this.pgl) * elO);
                if (d.this.getScale() > 0.0f) {
                    d.this.onScale(f / d.this.getScale(), this.pgj, this.pgk);
                    if (elO < 1.0f) {
                        com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.postOnAnimation(elI, this);
                    }
                }
            }
        }

        private float elO() {
            return d.sInterpolator.getInterpolation(Math.min(1.0f, (((float) (System.currentTimeMillis() - this.mStartTime)) * 1.0f) / d.this.pfO));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class b implements Runnable {
        private int bMK;
        private int mCurrentX;
        private final com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.c.d pgn;

        public b(Context context) {
            this.pgn = com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.c.d.hE(context);
        }

        public void elJ() {
            if (d.DEBUG) {
                com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.b.a.elQ().d("PhotoViewAttacher", "Cancel Fling");
            }
            this.pgn.AU(true);
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
                    com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.b.a.elQ().d("PhotoViewAttacher", "fling. StartX:" + round + " StartY:" + round2 + " MaxX:" + i5 + " MaxY:" + i7);
                }
                if (round != i5 || round2 != i7) {
                    this.pgn.fling(round, round2, i3, i4, i6, i5, i8, i7, 0, 0);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            ImageView elI;
            if (!this.pgn.isFinished() && (elI = d.this.elI()) != null && this.pgn.computeScrollOffset()) {
                int currX = this.pgn.getCurrX();
                int currY = this.pgn.getCurrY();
                if (d.DEBUG) {
                    com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.b.a.elQ().d("PhotoViewAttacher", "fling run(). CurrentX:" + this.mCurrentX + " CurrentY:" + this.bMK + " NewX:" + currX + " NewY:" + currY);
                }
                d.this.pfV.postTranslate(this.mCurrentX - currX, this.bMK - currY);
                d.this.e(d.this.getDrawMatrix());
                this.mCurrentX = currX;
                this.bMK = currY;
                com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.postOnAnimation(elI, this);
            }
        }
    }
}
