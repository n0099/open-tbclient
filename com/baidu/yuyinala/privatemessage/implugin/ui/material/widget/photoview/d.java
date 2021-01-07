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
    private int oZC;
    private float oZD;
    private boolean oZE;
    private boolean oZF;
    private WeakReference<ImageView> oZG;
    private com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.d oZH;
    private final Matrix oZI;
    private final Matrix oZJ;
    private final RectF oZK;
    private c oZL;
    private InterfaceC0985d oZM;
    private f oZN;
    private e oZO;
    private int oZP;
    private int oZQ;
    private int oZR;
    private int oZS;
    private b oZT;
    private int oZU;
    private boolean oZV;

    /* loaded from: classes11.dex */
    public interface c {
        void a(RectF rectF);
    }

    /* renamed from: com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.d$d  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0985d {
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
        this.oZC = 200;
        this.mMinScale = 1.0f;
        this.oZD = 1.75f;
        this.mMaxScale = 3.0f;
        this.oZE = true;
        this.oZF = false;
        this.oZI = new Matrix();
        this.mDrawMatrix = new Matrix();
        this.oZJ = new Matrix();
        this.oZK = new RectF();
        this.mMatrixValues = new float[9];
        this.oZU = 2;
        this.mScaleType = ImageView.ScaleType.FIT_CENTER;
        this.oZG = new WeakReference<>(imageView);
        imageView.setDrawingCacheEnabled(true);
        imageView.setOnTouchListener(this);
        ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }
        g(imageView);
        if (!imageView.isInEditMode()) {
            this.oZH = com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.f.a(imageView.getContext(), this);
            this.mGestureDetector = new GestureDetector(imageView.getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.d.1
                @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
                public void onLongPress(MotionEvent motionEvent) {
                    if (d.this.mLongClickListener != null) {
                        d.this.mLongClickListener.onLongClick(d.this.ena());
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
        this.oZO = eVar;
    }

    public void cleanup() {
        if (this.oZG != null) {
            ImageView imageView = this.oZG.get();
            if (imageView != null) {
                ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
                if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeGlobalOnLayoutListener(this);
                }
                imageView.setOnTouchListener(null);
                enb();
            }
            if (this.mGestureDetector != null) {
                this.mGestureDetector.setOnDoubleTapListener(null);
            }
            this.oZL = null;
            this.oZM = null;
            this.oZN = null;
            this.oZG = null;
        }
    }

    public RectF getDisplayRect() {
        enf();
        return d(getDrawMatrix());
    }

    private RectF d(Matrix matrix) {
        Drawable drawable;
        ImageView ena = ena();
        if (ena == null || (drawable = ena.getDrawable()) == null) {
            return null;
        }
        this.oZK.set(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        matrix.mapRect(this.oZK);
        return this.oZK;
    }

    public void setRotationTo(float f2) {
        this.oZJ.setRotate(f2 % 360.0f);
        enc();
    }

    public void setRotationBy(float f2) {
        this.oZJ.postRotate(f2 % 360.0f);
        enc();
    }

    public ImageView ena() {
        ImageView imageView = null;
        if (this.oZG != null) {
            imageView = this.oZG.get();
        }
        if (imageView == null) {
            cleanup();
            com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.b.a.enj().i("PhotoViewAttacher", "ImageView no longer exists. You should not use this PhotoViewAttacher any more.");
        }
        return imageView;
    }

    public float getMinimumScale() {
        return this.mMinScale;
    }

    public float getMediumScale() {
        return this.oZD;
    }

    public float getMaximumScale() {
        return this.mMaxScale;
    }

    public float getScale() {
        return (float) Math.sqrt(((float) Math.pow(a(this.oZJ, 0), 2.0d)) + ((float) Math.pow(a(this.oZJ, 3), 2.0d)));
    }

    public ImageView.ScaleType getScaleType() {
        return this.mScaleType;
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.e
    public void onDrag(float f2, float f3) {
        if (!this.oZH.eni()) {
            if (DEBUG) {
                com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.b.a.enj().d("PhotoViewAttacher", String.format("onDrag: dx: %.2f. dy: %.2f", Float.valueOf(f2), Float.valueOf(f3)));
            }
            ImageView ena = ena();
            this.oZJ.postTranslate(f2, f3);
            enc();
            ViewParent parent = ena.getParent();
            if (this.oZE && !this.oZH.eni() && !this.oZF) {
                if ((this.oZU == 2 || ((this.oZU == 0 && f2 >= 1.0f) || (this.oZU == 1 && f2 <= -1.0f))) && parent != null) {
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
            com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.b.a.enj().d("PhotoViewAttacher", "onFling. sX: " + f2 + " sY: " + f3 + " Vx: " + f4 + " Vy: " + f5);
        }
        ImageView ena = ena();
        this.oZT = new b(ena.getContext());
        this.oZT.O(h(ena), i(ena), (int) f4, (int) f5);
        ena.post(this.oZT);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        ImageView ena = ena();
        if (ena != null) {
            if (this.oZV) {
                int top = ena.getTop();
                int right = ena.getRight();
                int bottom = ena.getBottom();
                int left = ena.getLeft();
                if (top != this.oZP || bottom != this.oZR || left != this.oZS || right != this.oZQ) {
                    q(ena.getDrawable());
                    this.oZP = top;
                    this.oZQ = right;
                    this.oZR = bottom;
                    this.oZS = left;
                    return;
                }
                return;
            }
            q(ena.getDrawable());
        }
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.e
    public void onScale(float f2, float f3, float f4) {
        if (DEBUG) {
            com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.b.a.enj().d("PhotoViewAttacher", String.format("onScale: scale: %.2f. fX: %.2f. fY: %.2f", Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)));
        }
        if (getScale() < this.mMaxScale || f2 < 1.0f) {
            if (this.oZO != null) {
                this.oZO.j(f2, f3, f4);
            }
            this.oZJ.postScale(f2, f2, f3, f4);
            enc();
        }
    }

    @Override // android.view.View.OnTouchListener
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouch(View view, MotionEvent motionEvent) {
        RectF displayRect;
        boolean z;
        boolean z2 = false;
        if (this.oZV && f((ImageView) view)) {
            ViewParent parent = view.getParent();
            switch (motionEvent.getAction()) {
                case 0:
                    if (parent != null) {
                        parent.requestDisallowInterceptTouchEvent(true);
                    } else {
                        com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.b.a.enj().i("PhotoViewAttacher", "onTouch getParent() returned null");
                    }
                    enb();
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
            if (this.oZH != null) {
                boolean eni = this.oZH.eni();
                boolean isDragging = this.oZH.isDragging();
                z = this.oZH.onTouchEvent(motionEvent);
                boolean z3 = (eni || this.oZH.eni()) ? false : true;
                boolean z4 = (isDragging || this.oZH.isDragging()) ? false : true;
                if (z3 && z4) {
                    z2 = true;
                }
                this.oZF = z2;
            }
            if (this.mGestureDetector == null || !this.mGestureDetector.onTouchEvent(motionEvent)) {
                return z;
            }
            return true;
        }
        return false;
    }

    public void setAllowParentInterceptOnEdge(boolean z) {
        this.oZE = z;
    }

    public void setMinimumScale(float f2) {
        i(f2, this.oZD, this.mMaxScale);
        this.mMinScale = f2;
    }

    public void setMediumScale(float f2) {
        i(this.mMinScale, f2, this.mMaxScale);
        this.oZD = f2;
    }

    public void setMaximumScale(float f2) {
        i(this.mMinScale, this.oZD, f2);
        this.mMaxScale = f2;
    }

    public void setScaleLevels(float f2, float f3, float f4) {
        i(f2, f3, f4);
        this.mMinScale = f2;
        this.oZD = f3;
        this.mMaxScale = f4;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mLongClickListener = onLongClickListener;
    }

    public void setOnMatrixChangeListener(c cVar) {
        this.oZL = cVar;
    }

    public void setOnPhotoTapListener(InterfaceC0985d interfaceC0985d) {
        this.oZM = interfaceC0985d;
    }

    public InterfaceC0985d getOnPhotoTapListener() {
        return this.oZM;
    }

    public void setOnViewTapListener(f fVar) {
        this.oZN = fVar;
    }

    public f getOnViewTapListener() {
        return this.oZN;
    }

    public void setScale(float f2) {
        setScale(f2, false);
    }

    public void setScale(float f2, boolean z) {
        ImageView ena = ena();
        if (ena != null) {
            setScale(f2, ena.getRight() / 2, ena.getBottom() / 2, z);
        }
    }

    public void setScale(float f2, float f3, float f4, boolean z) {
        ImageView ena = ena();
        if (ena != null) {
            if (f2 < this.mMinScale || f2 > this.mMaxScale) {
                com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.b.a.enj().i("PhotoViewAttacher", "Scale must be within the range of minScale and maxScale");
            } else if (z) {
                ena.post(new a(getScale(), f2, f3, f4));
            } else {
                this.oZJ.setScale(f2, f2, f3, f4);
                enc();
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
        this.oZV = z;
        update();
    }

    public void update() {
        ImageView ena = ena();
        if (ena != null) {
            if (this.oZV) {
                g(ena);
                q(ena.getDrawable());
                return;
            }
            eng();
        }
    }

    public Matrix getDisplayMatrix() {
        return new Matrix(getDrawMatrix());
    }

    public Matrix getDrawMatrix() {
        this.mDrawMatrix.set(this.oZI);
        this.mDrawMatrix.postConcat(this.oZJ);
        return this.mDrawMatrix;
    }

    private void enb() {
        if (this.oZT != null) {
            this.oZT.enb();
            this.oZT = null;
        }
    }

    private void enc() {
        if (enf()) {
            e(getDrawMatrix());
        }
    }

    private void ene() {
        ImageView ena = ena();
        if (ena != null && !(ena instanceof com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.c) && !ImageView.ScaleType.MATRIX.equals(ena.getScaleType())) {
            com.baidu.yuyinala.privatemessage.implugin.util.c.e("PhotoViewAttacher", "The ImageView's ScaleType has been changed since attaching a PhotoViewAttacher");
        }
    }

    private boolean enf() {
        RectF d;
        float f2;
        float f3 = 0.0f;
        ImageView ena = ena();
        if (ena != null && (d = d(getDrawMatrix())) != null) {
            float height = d.height();
            float width = d.width();
            int i = i(ena);
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
            int h = h(ena);
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
                this.oZU = 2;
            } else if (d.left > 0.0f) {
                this.oZU = 0;
                f3 = -d.left;
            } else if (d.right < h) {
                f3 = h - d.right;
                this.oZU = 1;
            } else {
                this.oZU = -1;
            }
            this.oZJ.postTranslate(f3, f2);
            return true;
        }
        return false;
    }

    public Bitmap getVisibleRectangleBitmap() {
        ImageView ena = ena();
        if (ena == null) {
            return null;
        }
        return ena.getDrawingCache();
    }

    public void setZoomTransitionDuration(int i) {
        if (i < 0) {
            i = 200;
        }
        this.oZC = i;
    }

    private float a(Matrix matrix, int i) {
        matrix.getValues(this.mMatrixValues);
        if (i < 0 || i >= this.mMatrixValues.length) {
            return 0.0f;
        }
        return this.mMatrixValues[i];
    }

    private void eng() {
        this.oZJ.reset();
        e(getDrawMatrix());
        enf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(Matrix matrix) {
        RectF d;
        ImageView ena = ena();
        if (ena != null) {
            ene();
            ena.setImageMatrix(matrix);
            if (this.oZL != null && (d = d(matrix)) != null) {
                this.oZL.a(d);
            }
        }
    }

    private void q(Drawable drawable) {
        ImageView ena = ena();
        if (ena != null && drawable != null) {
            float h = h(ena);
            float i = i(ena);
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            this.oZI.reset();
            float f2 = h / intrinsicWidth;
            float f3 = i / intrinsicHeight;
            if (this.mScaleType == ImageView.ScaleType.CENTER) {
                this.oZI.postTranslate((h - intrinsicWidth) / 2.0f, (i - intrinsicHeight) / 2.0f);
            } else if (this.mScaleType == ImageView.ScaleType.CENTER_CROP) {
                float max = Math.max(f2, f3);
                this.oZI.postScale(max, max);
                this.oZI.postTranslate((h - (intrinsicWidth * max)) / 2.0f, (i - (intrinsicHeight * max)) / 2.0f);
            } else if (this.mScaleType == ImageView.ScaleType.CENTER_INSIDE) {
                float min = Math.min(1.0f, Math.min(f2, f3));
                this.oZI.postScale(min, min);
                this.oZI.postTranslate((h - (intrinsicWidth * min)) / 2.0f, (i - (intrinsicHeight * min)) / 2.0f);
            } else {
                RectF rectF = new RectF(0.0f, 0.0f, intrinsicWidth, intrinsicHeight);
                RectF rectF2 = new RectF(0.0f, 0.0f, h, i);
                switch (AnonymousClass2.$SwitchMap$android$widget$ImageView$ScaleType[this.mScaleType.ordinal()]) {
                    case 2:
                        this.oZI.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.START);
                        break;
                    case 3:
                        this.oZI.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.END);
                        break;
                    case 4:
                        this.oZI.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
                        break;
                    case 5:
                        this.oZI.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.FILL);
                        break;
                }
            }
            eng();
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
        private final float oZX;
        private final float oZY;
        private final float oZZ;
        private final float paa;

        public a(float f, float f2, float f3, float f4) {
            this.oZX = f3;
            this.oZY = f4;
            this.oZZ = f;
            this.paa = f2;
        }

        @Override // java.lang.Runnable
        public void run() {
            ImageView ena = d.this.ena();
            if (ena != null) {
                float enh = enh();
                float f = this.oZZ + ((this.paa - this.oZZ) * enh);
                if (d.this.getScale() > 0.0f) {
                    d.this.onScale(f / d.this.getScale(), this.oZX, this.oZY);
                    if (enh < 1.0f) {
                        com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.postOnAnimation(ena, this);
                    }
                }
            }
        }

        private float enh() {
            return d.sInterpolator.getInterpolation(Math.min(1.0f, (((float) (System.currentTimeMillis() - this.mStartTime)) * 1.0f) / d.this.oZC));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class b implements Runnable {
        private int bNM;
        private int mCurrentX;
        private final com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.c.d pab;

        public b(Context context) {
            this.pab = com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.c.d.hD(context);
        }

        public void enb() {
            if (d.DEBUG) {
                com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.b.a.enj().d("PhotoViewAttacher", "Cancel Fling");
            }
            this.pab.AF(true);
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
                this.bNM = round2;
                if (d.DEBUG) {
                    com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.b.a.enj().d("PhotoViewAttacher", "fling. StartX:" + round + " StartY:" + round2 + " MaxX:" + i5 + " MaxY:" + i7);
                }
                if (round != i5 || round2 != i7) {
                    this.pab.fling(round, round2, i3, i4, i6, i5, i8, i7, 0, 0);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            ImageView ena;
            if (!this.pab.isFinished() && (ena = d.this.ena()) != null && this.pab.computeScrollOffset()) {
                int currX = this.pab.getCurrX();
                int currY = this.pab.getCurrY();
                if (d.DEBUG) {
                    com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.b.a.enj().d("PhotoViewAttacher", "fling run(). CurrentX:" + this.mCurrentX + " CurrentY:" + this.bNM + " NewX:" + currX + " NewY:" + currY);
                }
                d.this.oZJ.postTranslate(this.mCurrentX - currX, this.bNM - currY);
                d.this.e(d.this.getDrawMatrix());
                this.mCurrentX = currX;
                this.bNM = currY;
                com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.postOnAnimation(ena, this);
            }
        }
    }
}
