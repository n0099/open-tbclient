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
/* loaded from: classes4.dex */
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
    private int oCL;
    private float oCM;
    private boolean oCN;
    private boolean oCO;
    private WeakReference<ImageView> oCP;
    private com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.d oCQ;
    private final Matrix oCR;
    private final Matrix oCS;
    private final RectF oCT;
    private c oCU;
    private InterfaceC0951d oCV;
    private f oCW;
    private e oCX;
    private int oCY;
    private int oCZ;
    private int oDa;
    private int oDb;
    private b oDc;
    private int oDd;
    private boolean oDe;

    /* loaded from: classes4.dex */
    public interface c {
        void a(RectF rectF);
    }

    /* renamed from: com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.d$d  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0951d {
        void d(View view, float f, float f2);
    }

    /* loaded from: classes4.dex */
    public interface e {
        void j(float f, float f2, float f3);
    }

    /* loaded from: classes4.dex */
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

    private static boolean d(ImageView imageView) {
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
    /* loaded from: classes4.dex */
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

    private static void e(ImageView imageView) {
        if (imageView != null && !(imageView instanceof com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.c) && !ImageView.ScaleType.MATRIX.equals(imageView.getScaleType())) {
            imageView.setScaleType(ImageView.ScaleType.MATRIX);
        }
    }

    public d(ImageView imageView) {
        this(imageView, true);
    }

    public d(ImageView imageView, boolean z) {
        this.oCL = 200;
        this.mMinScale = 1.0f;
        this.oCM = 1.75f;
        this.mMaxScale = 3.0f;
        this.oCN = true;
        this.oCO = false;
        this.oCR = new Matrix();
        this.mDrawMatrix = new Matrix();
        this.oCS = new Matrix();
        this.oCT = new RectF();
        this.mMatrixValues = new float[9];
        this.oDd = 2;
        this.mScaleType = ImageView.ScaleType.FIT_CENTER;
        this.oCP = new WeakReference<>(imageView);
        imageView.setDrawingCacheEnabled(true);
        imageView.setOnTouchListener(this);
        ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }
        e(imageView);
        if (!imageView.isInEditMode()) {
            this.oCQ = com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.f.a(imageView.getContext(), this);
            this.mGestureDetector = new GestureDetector(imageView.getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.d.1
                @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
                public void onLongPress(MotionEvent motionEvent) {
                    if (d.this.mLongClickListener != null) {
                        d.this.mLongClickListener.onLongClick(d.this.ehk());
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
        this.oCX = eVar;
    }

    public void cleanup() {
        if (this.oCP != null) {
            ImageView imageView = this.oCP.get();
            if (imageView != null) {
                ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
                if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeGlobalOnLayoutListener(this);
                }
                imageView.setOnTouchListener(null);
                ehl();
            }
            if (this.mGestureDetector != null) {
                this.mGestureDetector.setOnDoubleTapListener(null);
            }
            this.oCU = null;
            this.oCV = null;
            this.oCW = null;
            this.oCP = null;
        }
    }

    public RectF getDisplayRect() {
        eho();
        return c(getDrawMatrix());
    }

    private RectF c(Matrix matrix) {
        Drawable drawable;
        ImageView ehk = ehk();
        if (ehk == null || (drawable = ehk.getDrawable()) == null) {
            return null;
        }
        this.oCT.set(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        matrix.mapRect(this.oCT);
        return this.oCT;
    }

    public void setRotationTo(float f2) {
        this.oCS.setRotate(f2 % 360.0f);
        ehm();
    }

    public void setRotationBy(float f2) {
        this.oCS.postRotate(f2 % 360.0f);
        ehm();
    }

    public ImageView ehk() {
        ImageView imageView = null;
        if (this.oCP != null) {
            imageView = this.oCP.get();
        }
        if (imageView == null) {
            cleanup();
            com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.b.a.ehs().i("PhotoViewAttacher", "ImageView no longer exists. You should not use this PhotoViewAttacher any more.");
        }
        return imageView;
    }

    public float getMinimumScale() {
        return this.mMinScale;
    }

    public float getMediumScale() {
        return this.oCM;
    }

    public float getMaximumScale() {
        return this.mMaxScale;
    }

    public float getScale() {
        return (float) Math.sqrt(((float) Math.pow(a(this.oCS, 0), 2.0d)) + ((float) Math.pow(a(this.oCS, 3), 2.0d)));
    }

    public ImageView.ScaleType getScaleType() {
        return this.mScaleType;
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.e
    public void onDrag(float f2, float f3) {
        if (!this.oCQ.ehr()) {
            if (DEBUG) {
                com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.b.a.ehs().d("PhotoViewAttacher", String.format("onDrag: dx: %.2f. dy: %.2f", Float.valueOf(f2), Float.valueOf(f3)));
            }
            ImageView ehk = ehk();
            this.oCS.postTranslate(f2, f3);
            ehm();
            ViewParent parent = ehk.getParent();
            if (this.oCN && !this.oCQ.ehr() && !this.oCO) {
                if ((this.oDd == 2 || ((this.oDd == 0 && f2 >= 1.0f) || (this.oDd == 1 && f2 <= -1.0f))) && parent != null) {
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
            com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.b.a.ehs().d("PhotoViewAttacher", "onFling. sX: " + f2 + " sY: " + f3 + " Vx: " + f4 + " Vy: " + f5);
        }
        ImageView ehk = ehk();
        this.oDc = new b(ehk.getContext());
        this.oDc.J(f(ehk), g(ehk), (int) f4, (int) f5);
        ehk.post(this.oDc);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        ImageView ehk = ehk();
        if (ehk != null) {
            if (this.oDe) {
                int top = ehk.getTop();
                int right = ehk.getRight();
                int bottom = ehk.getBottom();
                int left = ehk.getLeft();
                if (top != this.oCY || bottom != this.oDa || left != this.oDb || right != this.oCZ) {
                    k(ehk.getDrawable());
                    this.oCY = top;
                    this.oCZ = right;
                    this.oDa = bottom;
                    this.oDb = left;
                    return;
                }
                return;
            }
            k(ehk.getDrawable());
        }
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.e
    public void onScale(float f2, float f3, float f4) {
        if (DEBUG) {
            com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.b.a.ehs().d("PhotoViewAttacher", String.format("onScale: scale: %.2f. fX: %.2f. fY: %.2f", Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)));
        }
        if (getScale() < this.mMaxScale || f2 < 1.0f) {
            if (this.oCX != null) {
                this.oCX.j(f2, f3, f4);
            }
            this.oCS.postScale(f2, f2, f3, f4);
            ehm();
        }
    }

    @Override // android.view.View.OnTouchListener
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouch(View view, MotionEvent motionEvent) {
        RectF displayRect;
        boolean z;
        boolean z2 = false;
        if (this.oDe && d((ImageView) view)) {
            ViewParent parent = view.getParent();
            switch (motionEvent.getAction()) {
                case 0:
                    if (parent != null) {
                        parent.requestDisallowInterceptTouchEvent(true);
                    } else {
                        com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.b.a.ehs().i("PhotoViewAttacher", "onTouch getParent() returned null");
                    }
                    ehl();
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
            if (this.oCQ != null) {
                boolean ehr = this.oCQ.ehr();
                boolean isDragging = this.oCQ.isDragging();
                z = this.oCQ.onTouchEvent(motionEvent);
                boolean z3 = (ehr || this.oCQ.ehr()) ? false : true;
                boolean z4 = (isDragging || this.oCQ.isDragging()) ? false : true;
                if (z3 && z4) {
                    z2 = true;
                }
                this.oCO = z2;
            }
            if (this.mGestureDetector == null || !this.mGestureDetector.onTouchEvent(motionEvent)) {
                return z;
            }
            return true;
        }
        return false;
    }

    public void setAllowParentInterceptOnEdge(boolean z) {
        this.oCN = z;
    }

    public void setMinimumScale(float f2) {
        i(f2, this.oCM, this.mMaxScale);
        this.mMinScale = f2;
    }

    public void setMediumScale(float f2) {
        i(this.mMinScale, f2, this.mMaxScale);
        this.oCM = f2;
    }

    public void setMaximumScale(float f2) {
        i(this.mMinScale, this.oCM, f2);
        this.mMaxScale = f2;
    }

    public void setScaleLevels(float f2, float f3, float f4) {
        i(f2, f3, f4);
        this.mMinScale = f2;
        this.oCM = f3;
        this.mMaxScale = f4;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mLongClickListener = onLongClickListener;
    }

    public void setOnMatrixChangeListener(c cVar) {
        this.oCU = cVar;
    }

    public void setOnPhotoTapListener(InterfaceC0951d interfaceC0951d) {
        this.oCV = interfaceC0951d;
    }

    public InterfaceC0951d getOnPhotoTapListener() {
        return this.oCV;
    }

    public void setOnViewTapListener(f fVar) {
        this.oCW = fVar;
    }

    public f getOnViewTapListener() {
        return this.oCW;
    }

    public void setScale(float f2) {
        setScale(f2, false);
    }

    public void setScale(float f2, boolean z) {
        ImageView ehk = ehk();
        if (ehk != null) {
            setScale(f2, ehk.getRight() / 2, ehk.getBottom() / 2, z);
        }
    }

    public void setScale(float f2, float f3, float f4, boolean z) {
        ImageView ehk = ehk();
        if (ehk != null) {
            if (f2 < this.mMinScale || f2 > this.mMaxScale) {
                com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.b.a.ehs().i("PhotoViewAttacher", "Scale must be within the range of minScale and maxScale");
            } else if (z) {
                ehk.post(new a(getScale(), f2, f3, f4));
            } else {
                this.oCS.setScale(f2, f2, f3, f4);
                ehm();
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
        this.oDe = z;
        update();
    }

    public void update() {
        ImageView ehk = ehk();
        if (ehk != null) {
            if (this.oDe) {
                e(ehk);
                k(ehk.getDrawable());
                return;
            }
            ehp();
        }
    }

    public Matrix getDisplayMatrix() {
        return new Matrix(getDrawMatrix());
    }

    public Matrix getDrawMatrix() {
        this.mDrawMatrix.set(this.oCR);
        this.mDrawMatrix.postConcat(this.oCS);
        return this.mDrawMatrix;
    }

    private void ehl() {
        if (this.oDc != null) {
            this.oDc.ehl();
            this.oDc = null;
        }
    }

    private void ehm() {
        if (eho()) {
            d(getDrawMatrix());
        }
    }

    private void ehn() {
        ImageView ehk = ehk();
        if (ehk != null && !(ehk instanceof com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.c) && !ImageView.ScaleType.MATRIX.equals(ehk.getScaleType())) {
            com.baidu.yuyinala.privatemessage.implugin.util.c.e("PhotoViewAttacher", "The ImageView's ScaleType has been changed since attaching a PhotoViewAttacher");
        }
    }

    private boolean eho() {
        RectF c2;
        float f2;
        float f3 = 0.0f;
        ImageView ehk = ehk();
        if (ehk != null && (c2 = c(getDrawMatrix())) != null) {
            float height = c2.height();
            float width = c2.width();
            int g = g(ehk);
            if (height <= g) {
                switch (AnonymousClass2.$SwitchMap$android$widget$ImageView$ScaleType[this.mScaleType.ordinal()]) {
                    case 2:
                        f2 = -c2.top;
                        break;
                    case 3:
                        f2 = (g - height) - c2.top;
                        break;
                    default:
                        f2 = ((g - height) / 2.0f) - c2.top;
                        break;
                }
            } else if (c2.top > 0.0f) {
                f2 = -c2.top;
            } else {
                f2 = c2.bottom < ((float) g) ? g - c2.bottom : 0.0f;
            }
            int f4 = f(ehk);
            if (width <= f4) {
                switch (AnonymousClass2.$SwitchMap$android$widget$ImageView$ScaleType[this.mScaleType.ordinal()]) {
                    case 2:
                        f3 = -c2.left;
                        break;
                    case 3:
                        f3 = (f4 - width) - c2.left;
                        break;
                    default:
                        f3 = ((f4 - width) / 2.0f) - c2.left;
                        break;
                }
                this.oDd = 2;
            } else if (c2.left > 0.0f) {
                this.oDd = 0;
                f3 = -c2.left;
            } else if (c2.right < f4) {
                f3 = f4 - c2.right;
                this.oDd = 1;
            } else {
                this.oDd = -1;
            }
            this.oCS.postTranslate(f3, f2);
            return true;
        }
        return false;
    }

    public Bitmap getVisibleRectangleBitmap() {
        ImageView ehk = ehk();
        if (ehk == null) {
            return null;
        }
        return ehk.getDrawingCache();
    }

    public void setZoomTransitionDuration(int i) {
        if (i < 0) {
            i = 200;
        }
        this.oCL = i;
    }

    private float a(Matrix matrix, int i) {
        matrix.getValues(this.mMatrixValues);
        if (i < 0 || i >= this.mMatrixValues.length) {
            return 0.0f;
        }
        return this.mMatrixValues[i];
    }

    private void ehp() {
        this.oCS.reset();
        d(getDrawMatrix());
        eho();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Matrix matrix) {
        RectF c2;
        ImageView ehk = ehk();
        if (ehk != null) {
            ehn();
            ehk.setImageMatrix(matrix);
            if (this.oCU != null && (c2 = c(matrix)) != null) {
                this.oCU.a(c2);
            }
        }
    }

    private void k(Drawable drawable) {
        ImageView ehk = ehk();
        if (ehk != null && drawable != null) {
            float f2 = f(ehk);
            float g = g(ehk);
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            this.oCR.reset();
            float f3 = f2 / intrinsicWidth;
            float f4 = g / intrinsicHeight;
            if (this.mScaleType == ImageView.ScaleType.CENTER) {
                this.oCR.postTranslate((f2 - intrinsicWidth) / 2.0f, (g - intrinsicHeight) / 2.0f);
            } else if (this.mScaleType == ImageView.ScaleType.CENTER_CROP) {
                float max = Math.max(f3, f4);
                this.oCR.postScale(max, max);
                this.oCR.postTranslate((f2 - (intrinsicWidth * max)) / 2.0f, (g - (intrinsicHeight * max)) / 2.0f);
            } else if (this.mScaleType == ImageView.ScaleType.CENTER_INSIDE) {
                float min = Math.min(1.0f, Math.min(f3, f4));
                this.oCR.postScale(min, min);
                this.oCR.postTranslate((f2 - (intrinsicWidth * min)) / 2.0f, (g - (intrinsicHeight * min)) / 2.0f);
            } else {
                RectF rectF = new RectF(0.0f, 0.0f, intrinsicWidth, intrinsicHeight);
                RectF rectF2 = new RectF(0.0f, 0.0f, f2, g);
                switch (AnonymousClass2.$SwitchMap$android$widget$ImageView$ScaleType[this.mScaleType.ordinal()]) {
                    case 2:
                        this.oCR.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.START);
                        break;
                    case 3:
                        this.oCR.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.END);
                        break;
                    case 4:
                        this.oCR.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
                        break;
                    case 5:
                        this.oCR.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.FILL);
                        break;
                }
            }
            ehp();
        }
    }

    private int f(ImageView imageView) {
        if (imageView == null) {
            return 0;
        }
        return (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
    }

    private int g(ImageView imageView) {
        if (imageView == null) {
            return 0;
        }
        return (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a implements Runnable {
        private final long mStartTime = System.currentTimeMillis();
        private final float oDg;
        private final float oDh;
        private final float oDi;
        private final float oDj;

        public a(float f, float f2, float f3, float f4) {
            this.oDg = f3;
            this.oDh = f4;
            this.oDi = f;
            this.oDj = f2;
        }

        @Override // java.lang.Runnable
        public void run() {
            ImageView ehk = d.this.ehk();
            if (ehk != null) {
                float ehq = ehq();
                float f = this.oDi + ((this.oDj - this.oDi) * ehq);
                if (d.this.getScale() > 0.0f) {
                    d.this.onScale(f / d.this.getScale(), this.oDg, this.oDh);
                    if (ehq < 1.0f) {
                        com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.postOnAnimation(ehk, this);
                    }
                }
            }
        }

        private float ehq() {
            return d.sInterpolator.getInterpolation(Math.min(1.0f, (((float) (System.currentTimeMillis() - this.mStartTime)) * 1.0f) / d.this.oCL));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class b implements Runnable {
        private int bFB;
        private int mCurrentX;
        private final com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.c.d oDk;

        public b(Context context) {
            this.oDk = com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.c.d.gJ(context);
        }

        public void ehl() {
            if (d.DEBUG) {
                com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.b.a.ehs().d("PhotoViewAttacher", "Cancel Fling");
            }
            this.oDk.zU(true);
        }

        public void J(int i, int i2, int i3, int i4) {
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
                this.bFB = round2;
                if (d.DEBUG) {
                    com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.b.a.ehs().d("PhotoViewAttacher", "fling. StartX:" + round + " StartY:" + round2 + " MaxX:" + i5 + " MaxY:" + i7);
                }
                if (round != i5 || round2 != i7) {
                    this.oDk.fling(round, round2, i3, i4, i6, i5, i8, i7, 0, 0);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            ImageView ehk;
            if (!this.oDk.isFinished() && (ehk = d.this.ehk()) != null && this.oDk.computeScrollOffset()) {
                int currX = this.oDk.getCurrX();
                int currY = this.oDk.getCurrY();
                if (d.DEBUG) {
                    com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.b.a.ehs().d("PhotoViewAttacher", "fling run(). CurrentX:" + this.mCurrentX + " CurrentY:" + this.bFB + " NewX:" + currX + " NewY:" + currY);
                }
                d.this.oCS.postTranslate(this.mCurrentX - currX, this.bFB - currY);
                d.this.d(d.this.getDrawMatrix());
                this.mCurrentX = currX;
                this.bFB = currY;
                com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.postOnAnimation(ehk, this);
            }
        }
    }
}
