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
    private int phT;
    private float phU;
    private boolean phV;
    private boolean phW;
    private WeakReference<ImageView> phX;
    private com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.d phY;
    private final Matrix phZ;
    private final Matrix pia;
    private final RectF pib;
    private c pie;
    private InterfaceC0980d pif;
    private f pig;
    private e pih;
    private int pii;
    private int pij;
    private int pik;
    private int pil;
    private b pim;
    private int pio;
    private boolean pip;

    /* loaded from: classes10.dex */
    public interface c {
        void a(RectF rectF);
    }

    /* renamed from: com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.d$d  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0980d {
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

    private static boolean e(ImageView imageView) {
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

    private static void f(ImageView imageView) {
        if (imageView != null && !(imageView instanceof com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.c) && !ImageView.ScaleType.MATRIX.equals(imageView.getScaleType())) {
            imageView.setScaleType(ImageView.ScaleType.MATRIX);
        }
    }

    public d(ImageView imageView) {
        this(imageView, true);
    }

    public d(ImageView imageView, boolean z) {
        this.phT = 200;
        this.mMinScale = 1.0f;
        this.phU = 1.75f;
        this.mMaxScale = 3.0f;
        this.phV = true;
        this.phW = false;
        this.phZ = new Matrix();
        this.mDrawMatrix = new Matrix();
        this.pia = new Matrix();
        this.pib = new RectF();
        this.mMatrixValues = new float[9];
        this.pio = 2;
        this.mScaleType = ImageView.ScaleType.FIT_CENTER;
        this.phX = new WeakReference<>(imageView);
        imageView.setDrawingCacheEnabled(true);
        imageView.setOnTouchListener(this);
        ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }
        f(imageView);
        if (!imageView.isInEditMode()) {
            this.phY = com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.f.a(imageView.getContext(), this);
            this.mGestureDetector = new GestureDetector(imageView.getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.d.1
                @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
                public void onLongPress(MotionEvent motionEvent) {
                    if (d.this.mLongClickListener != null) {
                        d.this.mLongClickListener.onLongClick(d.this.elS());
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
        this.pih = eVar;
    }

    public void cleanup() {
        if (this.phX != null) {
            ImageView imageView = this.phX.get();
            if (imageView != null) {
                ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
                if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeGlobalOnLayoutListener(this);
                }
                imageView.setOnTouchListener(null);
                elT();
            }
            if (this.mGestureDetector != null) {
                this.mGestureDetector.setOnDoubleTapListener(null);
            }
            this.pie = null;
            this.pif = null;
            this.pig = null;
            this.phX = null;
        }
    }

    public RectF getDisplayRect() {
        elW();
        return d(getDrawMatrix());
    }

    private RectF d(Matrix matrix) {
        Drawable drawable;
        ImageView elS = elS();
        if (elS == null || (drawable = elS.getDrawable()) == null) {
            return null;
        }
        this.pib.set(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        matrix.mapRect(this.pib);
        return this.pib;
    }

    public void setRotationTo(float f2) {
        this.pia.setRotate(f2 % 360.0f);
        elU();
    }

    public void setRotationBy(float f2) {
        this.pia.postRotate(f2 % 360.0f);
        elU();
    }

    public ImageView elS() {
        ImageView imageView = null;
        if (this.phX != null) {
            imageView = this.phX.get();
        }
        if (imageView == null) {
            cleanup();
            com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.b.a.ema().i("PhotoViewAttacher", "ImageView no longer exists. You should not use this PhotoViewAttacher any more.");
        }
        return imageView;
    }

    public float getMinimumScale() {
        return this.mMinScale;
    }

    public float getMediumScale() {
        return this.phU;
    }

    public float getMaximumScale() {
        return this.mMaxScale;
    }

    public float getScale() {
        return (float) Math.sqrt(((float) Math.pow(a(this.pia, 0), 2.0d)) + ((float) Math.pow(a(this.pia, 3), 2.0d)));
    }

    public ImageView.ScaleType getScaleType() {
        return this.mScaleType;
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.e
    public void onDrag(float f2, float f3) {
        if (!this.phY.elZ()) {
            if (DEBUG) {
                com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.b.a.ema().d("PhotoViewAttacher", String.format("onDrag: dx: %.2f. dy: %.2f", Float.valueOf(f2), Float.valueOf(f3)));
            }
            ImageView elS = elS();
            this.pia.postTranslate(f2, f3);
            elU();
            ViewParent parent = elS.getParent();
            if (this.phV && !this.phY.elZ() && !this.phW) {
                if ((this.pio == 2 || ((this.pio == 0 && f2 >= 1.0f) || (this.pio == 1 && f2 <= -1.0f))) && parent != null) {
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
            com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.b.a.ema().d("PhotoViewAttacher", "onFling. sX: " + f2 + " sY: " + f3 + " Vx: " + f4 + " Vy: " + f5);
        }
        ImageView elS = elS();
        this.pim = new b(elS.getContext());
        this.pim.M(g(elS), h(elS), (int) f4, (int) f5);
        elS.post(this.pim);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        ImageView elS = elS();
        if (elS != null) {
            if (this.pip) {
                int top = elS.getTop();
                int right = elS.getRight();
                int bottom = elS.getBottom();
                int left = elS.getLeft();
                if (top != this.pii || bottom != this.pik || left != this.pil || right != this.pij) {
                    q(elS.getDrawable());
                    this.pii = top;
                    this.pij = right;
                    this.pik = bottom;
                    this.pil = left;
                    return;
                }
                return;
            }
            q(elS.getDrawable());
        }
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.e
    public void onScale(float f2, float f3, float f4) {
        if (DEBUG) {
            com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.b.a.ema().d("PhotoViewAttacher", String.format("onScale: scale: %.2f. fX: %.2f. fY: %.2f", Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)));
        }
        if (getScale() < this.mMaxScale || f2 < 1.0f) {
            if (this.pih != null) {
                this.pih.j(f2, f3, f4);
            }
            this.pia.postScale(f2, f2, f3, f4);
            elU();
        }
    }

    @Override // android.view.View.OnTouchListener
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouch(View view, MotionEvent motionEvent) {
        RectF displayRect;
        boolean z;
        boolean z2 = false;
        if (this.pip && e((ImageView) view)) {
            ViewParent parent = view.getParent();
            switch (motionEvent.getAction()) {
                case 0:
                    if (parent != null) {
                        parent.requestDisallowInterceptTouchEvent(true);
                    } else {
                        com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.b.a.ema().i("PhotoViewAttacher", "onTouch getParent() returned null");
                    }
                    elT();
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
            if (this.phY != null) {
                boolean elZ = this.phY.elZ();
                boolean isDragging = this.phY.isDragging();
                z = this.phY.onTouchEvent(motionEvent);
                boolean z3 = (elZ || this.phY.elZ()) ? false : true;
                boolean z4 = (isDragging || this.phY.isDragging()) ? false : true;
                if (z3 && z4) {
                    z2 = true;
                }
                this.phW = z2;
            }
            if (this.mGestureDetector == null || !this.mGestureDetector.onTouchEvent(motionEvent)) {
                return z;
            }
            return true;
        }
        return false;
    }

    public void setAllowParentInterceptOnEdge(boolean z) {
        this.phV = z;
    }

    public void setMinimumScale(float f2) {
        i(f2, this.phU, this.mMaxScale);
        this.mMinScale = f2;
    }

    public void setMediumScale(float f2) {
        i(this.mMinScale, f2, this.mMaxScale);
        this.phU = f2;
    }

    public void setMaximumScale(float f2) {
        i(this.mMinScale, this.phU, f2);
        this.mMaxScale = f2;
    }

    public void setScaleLevels(float f2, float f3, float f4) {
        i(f2, f3, f4);
        this.mMinScale = f2;
        this.phU = f3;
        this.mMaxScale = f4;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mLongClickListener = onLongClickListener;
    }

    public void setOnMatrixChangeListener(c cVar) {
        this.pie = cVar;
    }

    public void setOnPhotoTapListener(InterfaceC0980d interfaceC0980d) {
        this.pif = interfaceC0980d;
    }

    public InterfaceC0980d getOnPhotoTapListener() {
        return this.pif;
    }

    public void setOnViewTapListener(f fVar) {
        this.pig = fVar;
    }

    public f getOnViewTapListener() {
        return this.pig;
    }

    public void setScale(float f2) {
        setScale(f2, false);
    }

    public void setScale(float f2, boolean z) {
        ImageView elS = elS();
        if (elS != null) {
            setScale(f2, elS.getRight() / 2, elS.getBottom() / 2, z);
        }
    }

    public void setScale(float f2, float f3, float f4, boolean z) {
        ImageView elS = elS();
        if (elS != null) {
            if (f2 < this.mMinScale || f2 > this.mMaxScale) {
                com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.b.a.ema().i("PhotoViewAttacher", "Scale must be within the range of minScale and maxScale");
            } else if (z) {
                elS.post(new a(getScale(), f2, f3, f4));
            } else {
                this.pia.setScale(f2, f2, f3, f4);
                elU();
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
        this.pip = z;
        update();
    }

    public void update() {
        ImageView elS = elS();
        if (elS != null) {
            if (this.pip) {
                f(elS);
                q(elS.getDrawable());
                return;
            }
            elX();
        }
    }

    public Matrix getDisplayMatrix() {
        return new Matrix(getDrawMatrix());
    }

    public Matrix getDrawMatrix() {
        this.mDrawMatrix.set(this.phZ);
        this.mDrawMatrix.postConcat(this.pia);
        return this.mDrawMatrix;
    }

    private void elT() {
        if (this.pim != null) {
            this.pim.elT();
            this.pim = null;
        }
    }

    private void elU() {
        if (elW()) {
            e(getDrawMatrix());
        }
    }

    private void elV() {
        ImageView elS = elS();
        if (elS != null && !(elS instanceof com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.c) && !ImageView.ScaleType.MATRIX.equals(elS.getScaleType())) {
            com.baidu.yuyinala.privatemessage.implugin.util.c.e("PhotoViewAttacher", "The ImageView's ScaleType has been changed since attaching a PhotoViewAttacher");
        }
    }

    private boolean elW() {
        RectF d;
        float f2;
        float f3 = 0.0f;
        ImageView elS = elS();
        if (elS != null && (d = d(getDrawMatrix())) != null) {
            float height = d.height();
            float width = d.width();
            int h = h(elS);
            if (height <= h) {
                switch (AnonymousClass2.$SwitchMap$android$widget$ImageView$ScaleType[this.mScaleType.ordinal()]) {
                    case 2:
                        f2 = -d.top;
                        break;
                    case 3:
                        f2 = (h - height) - d.top;
                        break;
                    default:
                        f2 = ((h - height) / 2.0f) - d.top;
                        break;
                }
            } else if (d.top > 0.0f) {
                f2 = -d.top;
            } else {
                f2 = d.bottom < ((float) h) ? h - d.bottom : 0.0f;
            }
            int g = g(elS);
            if (width <= g) {
                switch (AnonymousClass2.$SwitchMap$android$widget$ImageView$ScaleType[this.mScaleType.ordinal()]) {
                    case 2:
                        f3 = -d.left;
                        break;
                    case 3:
                        f3 = (g - width) - d.left;
                        break;
                    default:
                        f3 = ((g - width) / 2.0f) - d.left;
                        break;
                }
                this.pio = 2;
            } else if (d.left > 0.0f) {
                this.pio = 0;
                f3 = -d.left;
            } else if (d.right < g) {
                f3 = g - d.right;
                this.pio = 1;
            } else {
                this.pio = -1;
            }
            this.pia.postTranslate(f3, f2);
            return true;
        }
        return false;
    }

    public Bitmap getVisibleRectangleBitmap() {
        ImageView elS = elS();
        if (elS == null) {
            return null;
        }
        return elS.getDrawingCache();
    }

    public void setZoomTransitionDuration(int i) {
        if (i < 0) {
            i = 200;
        }
        this.phT = i;
    }

    private float a(Matrix matrix, int i) {
        matrix.getValues(this.mMatrixValues);
        if (i < 0 || i >= this.mMatrixValues.length) {
            return 0.0f;
        }
        return this.mMatrixValues[i];
    }

    private void elX() {
        this.pia.reset();
        e(getDrawMatrix());
        elW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(Matrix matrix) {
        RectF d;
        ImageView elS = elS();
        if (elS != null) {
            elV();
            elS.setImageMatrix(matrix);
            if (this.pie != null && (d = d(matrix)) != null) {
                this.pie.a(d);
            }
        }
    }

    private void q(Drawable drawable) {
        ImageView elS = elS();
        if (elS != null && drawable != null) {
            float g = g(elS);
            float h = h(elS);
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            this.phZ.reset();
            float f2 = g / intrinsicWidth;
            float f3 = h / intrinsicHeight;
            if (this.mScaleType == ImageView.ScaleType.CENTER) {
                this.phZ.postTranslate((g - intrinsicWidth) / 2.0f, (h - intrinsicHeight) / 2.0f);
            } else if (this.mScaleType == ImageView.ScaleType.CENTER_CROP) {
                float max = Math.max(f2, f3);
                this.phZ.postScale(max, max);
                this.phZ.postTranslate((g - (intrinsicWidth * max)) / 2.0f, (h - (intrinsicHeight * max)) / 2.0f);
            } else if (this.mScaleType == ImageView.ScaleType.CENTER_INSIDE) {
                float min = Math.min(1.0f, Math.min(f2, f3));
                this.phZ.postScale(min, min);
                this.phZ.postTranslate((g - (intrinsicWidth * min)) / 2.0f, (h - (intrinsicHeight * min)) / 2.0f);
            } else {
                RectF rectF = new RectF(0.0f, 0.0f, intrinsicWidth, intrinsicHeight);
                RectF rectF2 = new RectF(0.0f, 0.0f, g, h);
                switch (AnonymousClass2.$SwitchMap$android$widget$ImageView$ScaleType[this.mScaleType.ordinal()]) {
                    case 2:
                        this.phZ.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.START);
                        break;
                    case 3:
                        this.phZ.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.END);
                        break;
                    case 4:
                        this.phZ.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
                        break;
                    case 5:
                        this.phZ.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.FILL);
                        break;
                }
            }
            elX();
        }
    }

    private int g(ImageView imageView) {
        if (imageView == null) {
            return 0;
        }
        return (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
    }

    private int h(ImageView imageView) {
        if (imageView == null) {
            return 0;
        }
        return (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class a implements Runnable {
        private final long mStartTime = System.currentTimeMillis();
        private final float pir;
        private final float pis;
        private final float pit;
        private final float piu;

        public a(float f, float f2, float f3, float f4) {
            this.pir = f3;
            this.pis = f4;
            this.pit = f;
            this.piu = f2;
        }

        @Override // java.lang.Runnable
        public void run() {
            ImageView elS = d.this.elS();
            if (elS != null) {
                float elY = elY();
                float f = this.pit + ((this.piu - this.pit) * elY);
                if (d.this.getScale() > 0.0f) {
                    d.this.onScale(f / d.this.getScale(), this.pir, this.pis);
                    if (elY < 1.0f) {
                        com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.postOnAnimation(elS, this);
                    }
                }
            }
        }

        private float elY() {
            return d.sInterpolator.getInterpolation(Math.min(1.0f, (((float) (System.currentTimeMillis() - this.mStartTime)) * 1.0f) / d.this.phT));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class b implements Runnable {
        private int bOk;
        private int mCurrentX;
        private final com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.c.d piv;

        public b(Context context) {
            this.piv = com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.c.d.hD(context);
        }

        public void elT() {
            if (d.DEBUG) {
                com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.b.a.ema().d("PhotoViewAttacher", "Cancel Fling");
            }
            this.piv.AT(true);
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
                this.bOk = round2;
                if (d.DEBUG) {
                    com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.b.a.ema().d("PhotoViewAttacher", "fling. StartX:" + round + " StartY:" + round2 + " MaxX:" + i5 + " MaxY:" + i7);
                }
                if (round != i5 || round2 != i7) {
                    this.piv.fling(round, round2, i3, i4, i6, i5, i8, i7, 0, 0);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            ImageView elS;
            if (!this.piv.isFinished() && (elS = d.this.elS()) != null && this.piv.computeScrollOffset()) {
                int currX = this.piv.getCurrX();
                int currY = this.piv.getCurrY();
                if (d.DEBUG) {
                    com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.b.a.ema().d("PhotoViewAttacher", "fling run(). CurrentX:" + this.mCurrentX + " CurrentY:" + this.bOk + " NewX:" + currX + " NewY:" + currY);
                }
                d.this.pia.postTranslate(this.mCurrentX - currX, this.bOk - currY);
                d.this.e(d.this.getDrawMatrix());
                this.mCurrentX = currX;
                this.bOk = currY;
                com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.postOnAnimation(elS, this);
            }
        }
    }
}
