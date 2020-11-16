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
    private f oEA;
    private e oEB;
    private int oEC;
    private int oED;
    private int oEE;
    private int oEF;
    private b oEG;
    private int oEH;
    private boolean oEI;
    private int oEp;
    private float oEq;
    private boolean oEr;
    private boolean oEs;
    private WeakReference<ImageView> oEt;
    private com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.d oEu;
    private final Matrix oEv;
    private final Matrix oEw;
    private final RectF oEx;
    private c oEy;
    private InterfaceC0954d oEz;

    /* loaded from: classes4.dex */
    public interface c {
        void a(RectF rectF);
    }

    /* renamed from: com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.d$d  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0954d {
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
        this.oEp = 200;
        this.mMinScale = 1.0f;
        this.oEq = 1.75f;
        this.mMaxScale = 3.0f;
        this.oEr = true;
        this.oEs = false;
        this.oEv = new Matrix();
        this.mDrawMatrix = new Matrix();
        this.oEw = new Matrix();
        this.oEx = new RectF();
        this.mMatrixValues = new float[9];
        this.oEH = 2;
        this.mScaleType = ImageView.ScaleType.FIT_CENTER;
        this.oEt = new WeakReference<>(imageView);
        imageView.setDrawingCacheEnabled(true);
        imageView.setOnTouchListener(this);
        ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }
        e(imageView);
        if (!imageView.isInEditMode()) {
            this.oEu = com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.f.a(imageView.getContext(), this);
            this.mGestureDetector = new GestureDetector(imageView.getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.d.1
                @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
                public void onLongPress(MotionEvent motionEvent) {
                    if (d.this.mLongClickListener != null) {
                        d.this.mLongClickListener.onLongClick(d.this.ehi());
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
        this.oEB = eVar;
    }

    public void cleanup() {
        if (this.oEt != null) {
            ImageView imageView = this.oEt.get();
            if (imageView != null) {
                ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
                if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeGlobalOnLayoutListener(this);
                }
                imageView.setOnTouchListener(null);
                ehj();
            }
            if (this.mGestureDetector != null) {
                this.mGestureDetector.setOnDoubleTapListener(null);
            }
            this.oEy = null;
            this.oEz = null;
            this.oEA = null;
            this.oEt = null;
        }
    }

    public RectF getDisplayRect() {
        ehm();
        return c(getDrawMatrix());
    }

    private RectF c(Matrix matrix) {
        Drawable drawable;
        ImageView ehi = ehi();
        if (ehi == null || (drawable = ehi.getDrawable()) == null) {
            return null;
        }
        this.oEx.set(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        matrix.mapRect(this.oEx);
        return this.oEx;
    }

    public void setRotationTo(float f2) {
        this.oEw.setRotate(f2 % 360.0f);
        ehk();
    }

    public void setRotationBy(float f2) {
        this.oEw.postRotate(f2 % 360.0f);
        ehk();
    }

    public ImageView ehi() {
        ImageView imageView = null;
        if (this.oEt != null) {
            imageView = this.oEt.get();
        }
        if (imageView == null) {
            cleanup();
            com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.b.a.ehq().i("PhotoViewAttacher", "ImageView no longer exists. You should not use this PhotoViewAttacher any more.");
        }
        return imageView;
    }

    public float getMinimumScale() {
        return this.mMinScale;
    }

    public float getMediumScale() {
        return this.oEq;
    }

    public float getMaximumScale() {
        return this.mMaxScale;
    }

    public float getScale() {
        return (float) Math.sqrt(((float) Math.pow(a(this.oEw, 0), 2.0d)) + ((float) Math.pow(a(this.oEw, 3), 2.0d)));
    }

    public ImageView.ScaleType getScaleType() {
        return this.mScaleType;
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.e
    public void onDrag(float f2, float f3) {
        if (!this.oEu.ehp()) {
            if (DEBUG) {
                com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.b.a.ehq().d("PhotoViewAttacher", String.format("onDrag: dx: %.2f. dy: %.2f", Float.valueOf(f2), Float.valueOf(f3)));
            }
            ImageView ehi = ehi();
            this.oEw.postTranslate(f2, f3);
            ehk();
            ViewParent parent = ehi.getParent();
            if (this.oEr && !this.oEu.ehp() && !this.oEs) {
                if ((this.oEH == 2 || ((this.oEH == 0 && f2 >= 1.0f) || (this.oEH == 1 && f2 <= -1.0f))) && parent != null) {
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
            com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.b.a.ehq().d("PhotoViewAttacher", "onFling. sX: " + f2 + " sY: " + f3 + " Vx: " + f4 + " Vy: " + f5);
        }
        ImageView ehi = ehi();
        this.oEG = new b(ehi.getContext());
        this.oEG.K(f(ehi), g(ehi), (int) f4, (int) f5);
        ehi.post(this.oEG);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        ImageView ehi = ehi();
        if (ehi != null) {
            if (this.oEI) {
                int top = ehi.getTop();
                int right = ehi.getRight();
                int bottom = ehi.getBottom();
                int left = ehi.getLeft();
                if (top != this.oEC || bottom != this.oEE || left != this.oEF || right != this.oED) {
                    l(ehi.getDrawable());
                    this.oEC = top;
                    this.oED = right;
                    this.oEE = bottom;
                    this.oEF = left;
                    return;
                }
                return;
            }
            l(ehi.getDrawable());
        }
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.e
    public void onScale(float f2, float f3, float f4) {
        if (DEBUG) {
            com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.b.a.ehq().d("PhotoViewAttacher", String.format("onScale: scale: %.2f. fX: %.2f. fY: %.2f", Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)));
        }
        if (getScale() < this.mMaxScale || f2 < 1.0f) {
            if (this.oEB != null) {
                this.oEB.j(f2, f3, f4);
            }
            this.oEw.postScale(f2, f2, f3, f4);
            ehk();
        }
    }

    @Override // android.view.View.OnTouchListener
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouch(View view, MotionEvent motionEvent) {
        RectF displayRect;
        boolean z;
        boolean z2 = false;
        if (this.oEI && d((ImageView) view)) {
            ViewParent parent = view.getParent();
            switch (motionEvent.getAction()) {
                case 0:
                    if (parent != null) {
                        parent.requestDisallowInterceptTouchEvent(true);
                    } else {
                        com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.b.a.ehq().i("PhotoViewAttacher", "onTouch getParent() returned null");
                    }
                    ehj();
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
            if (this.oEu != null) {
                boolean ehp = this.oEu.ehp();
                boolean isDragging = this.oEu.isDragging();
                z = this.oEu.onTouchEvent(motionEvent);
                boolean z3 = (ehp || this.oEu.ehp()) ? false : true;
                boolean z4 = (isDragging || this.oEu.isDragging()) ? false : true;
                if (z3 && z4) {
                    z2 = true;
                }
                this.oEs = z2;
            }
            if (this.mGestureDetector == null || !this.mGestureDetector.onTouchEvent(motionEvent)) {
                return z;
            }
            return true;
        }
        return false;
    }

    public void setAllowParentInterceptOnEdge(boolean z) {
        this.oEr = z;
    }

    public void setMinimumScale(float f2) {
        i(f2, this.oEq, this.mMaxScale);
        this.mMinScale = f2;
    }

    public void setMediumScale(float f2) {
        i(this.mMinScale, f2, this.mMaxScale);
        this.oEq = f2;
    }

    public void setMaximumScale(float f2) {
        i(this.mMinScale, this.oEq, f2);
        this.mMaxScale = f2;
    }

    public void setScaleLevels(float f2, float f3, float f4) {
        i(f2, f3, f4);
        this.mMinScale = f2;
        this.oEq = f3;
        this.mMaxScale = f4;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mLongClickListener = onLongClickListener;
    }

    public void setOnMatrixChangeListener(c cVar) {
        this.oEy = cVar;
    }

    public void setOnPhotoTapListener(InterfaceC0954d interfaceC0954d) {
        this.oEz = interfaceC0954d;
    }

    public InterfaceC0954d getOnPhotoTapListener() {
        return this.oEz;
    }

    public void setOnViewTapListener(f fVar) {
        this.oEA = fVar;
    }

    public f getOnViewTapListener() {
        return this.oEA;
    }

    public void setScale(float f2) {
        setScale(f2, false);
    }

    public void setScale(float f2, boolean z) {
        ImageView ehi = ehi();
        if (ehi != null) {
            setScale(f2, ehi.getRight() / 2, ehi.getBottom() / 2, z);
        }
    }

    public void setScale(float f2, float f3, float f4, boolean z) {
        ImageView ehi = ehi();
        if (ehi != null) {
            if (f2 < this.mMinScale || f2 > this.mMaxScale) {
                com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.b.a.ehq().i("PhotoViewAttacher", "Scale must be within the range of minScale and maxScale");
            } else if (z) {
                ehi.post(new a(getScale(), f2, f3, f4));
            } else {
                this.oEw.setScale(f2, f2, f3, f4);
                ehk();
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
        this.oEI = z;
        update();
    }

    public void update() {
        ImageView ehi = ehi();
        if (ehi != null) {
            if (this.oEI) {
                e(ehi);
                l(ehi.getDrawable());
                return;
            }
            ehn();
        }
    }

    public Matrix getDisplayMatrix() {
        return new Matrix(getDrawMatrix());
    }

    public Matrix getDrawMatrix() {
        this.mDrawMatrix.set(this.oEv);
        this.mDrawMatrix.postConcat(this.oEw);
        return this.mDrawMatrix;
    }

    private void ehj() {
        if (this.oEG != null) {
            this.oEG.ehj();
            this.oEG = null;
        }
    }

    private void ehk() {
        if (ehm()) {
            d(getDrawMatrix());
        }
    }

    private void ehl() {
        ImageView ehi = ehi();
        if (ehi != null && !(ehi instanceof com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.c) && !ImageView.ScaleType.MATRIX.equals(ehi.getScaleType())) {
            com.baidu.yuyinala.privatemessage.implugin.util.c.e("PhotoViewAttacher", "The ImageView's ScaleType has been changed since attaching a PhotoViewAttacher");
        }
    }

    private boolean ehm() {
        RectF c2;
        float f2;
        float f3 = 0.0f;
        ImageView ehi = ehi();
        if (ehi != null && (c2 = c(getDrawMatrix())) != null) {
            float height = c2.height();
            float width = c2.width();
            int g = g(ehi);
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
            int f4 = f(ehi);
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
                this.oEH = 2;
            } else if (c2.left > 0.0f) {
                this.oEH = 0;
                f3 = -c2.left;
            } else if (c2.right < f4) {
                f3 = f4 - c2.right;
                this.oEH = 1;
            } else {
                this.oEH = -1;
            }
            this.oEw.postTranslate(f3, f2);
            return true;
        }
        return false;
    }

    public Bitmap getVisibleRectangleBitmap() {
        ImageView ehi = ehi();
        if (ehi == null) {
            return null;
        }
        return ehi.getDrawingCache();
    }

    public void setZoomTransitionDuration(int i) {
        if (i < 0) {
            i = 200;
        }
        this.oEp = i;
    }

    private float a(Matrix matrix, int i) {
        matrix.getValues(this.mMatrixValues);
        if (i < 0 || i >= this.mMatrixValues.length) {
            return 0.0f;
        }
        return this.mMatrixValues[i];
    }

    private void ehn() {
        this.oEw.reset();
        d(getDrawMatrix());
        ehm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Matrix matrix) {
        RectF c2;
        ImageView ehi = ehi();
        if (ehi != null) {
            ehl();
            ehi.setImageMatrix(matrix);
            if (this.oEy != null && (c2 = c(matrix)) != null) {
                this.oEy.a(c2);
            }
        }
    }

    private void l(Drawable drawable) {
        ImageView ehi = ehi();
        if (ehi != null && drawable != null) {
            float f2 = f(ehi);
            float g = g(ehi);
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            this.oEv.reset();
            float f3 = f2 / intrinsicWidth;
            float f4 = g / intrinsicHeight;
            if (this.mScaleType == ImageView.ScaleType.CENTER) {
                this.oEv.postTranslate((f2 - intrinsicWidth) / 2.0f, (g - intrinsicHeight) / 2.0f);
            } else if (this.mScaleType == ImageView.ScaleType.CENTER_CROP) {
                float max = Math.max(f3, f4);
                this.oEv.postScale(max, max);
                this.oEv.postTranslate((f2 - (intrinsicWidth * max)) / 2.0f, (g - (intrinsicHeight * max)) / 2.0f);
            } else if (this.mScaleType == ImageView.ScaleType.CENTER_INSIDE) {
                float min = Math.min(1.0f, Math.min(f3, f4));
                this.oEv.postScale(min, min);
                this.oEv.postTranslate((f2 - (intrinsicWidth * min)) / 2.0f, (g - (intrinsicHeight * min)) / 2.0f);
            } else {
                RectF rectF = new RectF(0.0f, 0.0f, intrinsicWidth, intrinsicHeight);
                RectF rectF2 = new RectF(0.0f, 0.0f, f2, g);
                switch (AnonymousClass2.$SwitchMap$android$widget$ImageView$ScaleType[this.mScaleType.ordinal()]) {
                    case 2:
                        this.oEv.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.START);
                        break;
                    case 3:
                        this.oEv.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.END);
                        break;
                    case 4:
                        this.oEv.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
                        break;
                    case 5:
                        this.oEv.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.FILL);
                        break;
                }
            }
            ehn();
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
        private final float oEK;
        private final float oEL;
        private final float oEM;
        private final float oEN;

        public a(float f, float f2, float f3, float f4) {
            this.oEK = f3;
            this.oEL = f4;
            this.oEM = f;
            this.oEN = f2;
        }

        @Override // java.lang.Runnable
        public void run() {
            ImageView ehi = d.this.ehi();
            if (ehi != null) {
                float eho = eho();
                float f = this.oEM + ((this.oEN - this.oEM) * eho);
                if (d.this.getScale() > 0.0f) {
                    d.this.onScale(f / d.this.getScale(), this.oEK, this.oEL);
                    if (eho < 1.0f) {
                        com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.postOnAnimation(ehi, this);
                    }
                }
            }
        }

        private float eho() {
            return d.sInterpolator.getInterpolation(Math.min(1.0f, (((float) (System.currentTimeMillis() - this.mStartTime)) * 1.0f) / d.this.oEp));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class b implements Runnable {
        private int bDQ;
        private int mCurrentX;
        private final com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.c.d oEO;

        public b(Context context) {
            this.oEO = com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.c.d.gH(context);
        }

        public void ehj() {
            if (d.DEBUG) {
                com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.b.a.ehq().d("PhotoViewAttacher", "Cancel Fling");
            }
            this.oEO.Ab(true);
        }

        public void K(int i, int i2, int i3, int i4) {
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
                this.bDQ = round2;
                if (d.DEBUG) {
                    com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.b.a.ehq().d("PhotoViewAttacher", "fling. StartX:" + round + " StartY:" + round2 + " MaxX:" + i5 + " MaxY:" + i7);
                }
                if (round != i5 || round2 != i7) {
                    this.oEO.fling(round, round2, i3, i4, i6, i5, i8, i7, 0, 0);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            ImageView ehi;
            if (!this.oEO.isFinished() && (ehi = d.this.ehi()) != null && this.oEO.computeScrollOffset()) {
                int currX = this.oEO.getCurrX();
                int currY = this.oEO.getCurrY();
                if (d.DEBUG) {
                    com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.b.a.ehq().d("PhotoViewAttacher", "fling run(). CurrentX:" + this.mCurrentX + " CurrentY:" + this.bDQ + " NewX:" + currX + " NewY:" + currY);
                }
                d.this.oEw.postTranslate(this.mCurrentX - currX, this.bDQ - currY);
                d.this.d(d.this.getDrawMatrix());
                this.mCurrentX = currX;
                this.bDQ = currY;
                com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.postOnAnimation(ehi, this);
            }
        }
    }
}
