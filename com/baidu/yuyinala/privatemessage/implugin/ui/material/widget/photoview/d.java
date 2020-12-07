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
    private com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.d oTA;
    private final Matrix oTB;
    private final Matrix oTC;
    private final RectF oTD;
    private c oTE;
    private InterfaceC0971d oTF;
    private f oTG;
    private e oTH;
    private int oTI;
    private int oTJ;
    private int oTK;
    private int oTL;
    private b oTM;
    private int oTN;
    private boolean oTO;
    private int oTv;
    private float oTw;
    private boolean oTx;
    private boolean oTy;
    private WeakReference<ImageView> oTz;

    /* loaded from: classes4.dex */
    public interface c {
        void a(RectF rectF);
    }

    /* renamed from: com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.d$d  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0971d {
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
        this.oTv = 200;
        this.mMinScale = 1.0f;
        this.oTw = 1.75f;
        this.mMaxScale = 3.0f;
        this.oTx = true;
        this.oTy = false;
        this.oTB = new Matrix();
        this.mDrawMatrix = new Matrix();
        this.oTC = new Matrix();
        this.oTD = new RectF();
        this.mMatrixValues = new float[9];
        this.oTN = 2;
        this.mScaleType = ImageView.ScaleType.FIT_CENTER;
        this.oTz = new WeakReference<>(imageView);
        imageView.setDrawingCacheEnabled(true);
        imageView.setOnTouchListener(this);
        ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }
        e(imageView);
        if (!imageView.isInEditMode()) {
            this.oTA = com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.f.a(imageView.getContext(), this);
            this.mGestureDetector = new GestureDetector(imageView.getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.d.1
                @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
                public void onLongPress(MotionEvent motionEvent) {
                    if (d.this.mLongClickListener != null) {
                        d.this.mLongClickListener.onLongClick(d.this.emW());
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
        this.oTH = eVar;
    }

    public void cleanup() {
        if (this.oTz != null) {
            ImageView imageView = this.oTz.get();
            if (imageView != null) {
                ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
                if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeGlobalOnLayoutListener(this);
                }
                imageView.setOnTouchListener(null);
                emX();
            }
            if (this.mGestureDetector != null) {
                this.mGestureDetector.setOnDoubleTapListener(null);
            }
            this.oTE = null;
            this.oTF = null;
            this.oTG = null;
            this.oTz = null;
        }
    }

    public RectF getDisplayRect() {
        ena();
        return c(getDrawMatrix());
    }

    private RectF c(Matrix matrix) {
        Drawable drawable;
        ImageView emW = emW();
        if (emW == null || (drawable = emW.getDrawable()) == null) {
            return null;
        }
        this.oTD.set(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        matrix.mapRect(this.oTD);
        return this.oTD;
    }

    public void setRotationTo(float f2) {
        this.oTC.setRotate(f2 % 360.0f);
        emY();
    }

    public void setRotationBy(float f2) {
        this.oTC.postRotate(f2 % 360.0f);
        emY();
    }

    public ImageView emW() {
        ImageView imageView = null;
        if (this.oTz != null) {
            imageView = this.oTz.get();
        }
        if (imageView == null) {
            cleanup();
            com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.b.a.enf().i("PhotoViewAttacher", "ImageView no longer exists. You should not use this PhotoViewAttacher any more.");
        }
        return imageView;
    }

    public float getMinimumScale() {
        return this.mMinScale;
    }

    public float getMediumScale() {
        return this.oTw;
    }

    public float getMaximumScale() {
        return this.mMaxScale;
    }

    public float getScale() {
        return (float) Math.sqrt(((float) Math.pow(a(this.oTC, 0), 2.0d)) + ((float) Math.pow(a(this.oTC, 3), 2.0d)));
    }

    public ImageView.ScaleType getScaleType() {
        return this.mScaleType;
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.e
    public void onDrag(float f2, float f3) {
        if (!this.oTA.ene()) {
            if (DEBUG) {
                com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.b.a.enf().d("PhotoViewAttacher", String.format("onDrag: dx: %.2f. dy: %.2f", Float.valueOf(f2), Float.valueOf(f3)));
            }
            ImageView emW = emW();
            this.oTC.postTranslate(f2, f3);
            emY();
            ViewParent parent = emW.getParent();
            if (this.oTx && !this.oTA.ene() && !this.oTy) {
                if ((this.oTN == 2 || ((this.oTN == 0 && f2 >= 1.0f) || (this.oTN == 1 && f2 <= -1.0f))) && parent != null) {
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
            com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.b.a.enf().d("PhotoViewAttacher", "onFling. sX: " + f2 + " sY: " + f3 + " Vx: " + f4 + " Vy: " + f5);
        }
        ImageView emW = emW();
        this.oTM = new b(emW.getContext());
        this.oTM.O(f(emW), g(emW), (int) f4, (int) f5);
        emW.post(this.oTM);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        ImageView emW = emW();
        if (emW != null) {
            if (this.oTO) {
                int top = emW.getTop();
                int right = emW.getRight();
                int bottom = emW.getBottom();
                int left = emW.getLeft();
                if (top != this.oTI || bottom != this.oTK || left != this.oTL || right != this.oTJ) {
                    l(emW.getDrawable());
                    this.oTI = top;
                    this.oTJ = right;
                    this.oTK = bottom;
                    this.oTL = left;
                    return;
                }
                return;
            }
            l(emW.getDrawable());
        }
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.e
    public void onScale(float f2, float f3, float f4) {
        if (DEBUG) {
            com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.b.a.enf().d("PhotoViewAttacher", String.format("onScale: scale: %.2f. fX: %.2f. fY: %.2f", Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)));
        }
        if (getScale() < this.mMaxScale || f2 < 1.0f) {
            if (this.oTH != null) {
                this.oTH.j(f2, f3, f4);
            }
            this.oTC.postScale(f2, f2, f3, f4);
            emY();
        }
    }

    @Override // android.view.View.OnTouchListener
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouch(View view, MotionEvent motionEvent) {
        RectF displayRect;
        boolean z;
        boolean z2 = false;
        if (this.oTO && d((ImageView) view)) {
            ViewParent parent = view.getParent();
            switch (motionEvent.getAction()) {
                case 0:
                    if (parent != null) {
                        parent.requestDisallowInterceptTouchEvent(true);
                    } else {
                        com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.b.a.enf().i("PhotoViewAttacher", "onTouch getParent() returned null");
                    }
                    emX();
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
            if (this.oTA != null) {
                boolean ene = this.oTA.ene();
                boolean isDragging = this.oTA.isDragging();
                z = this.oTA.onTouchEvent(motionEvent);
                boolean z3 = (ene || this.oTA.ene()) ? false : true;
                boolean z4 = (isDragging || this.oTA.isDragging()) ? false : true;
                if (z3 && z4) {
                    z2 = true;
                }
                this.oTy = z2;
            }
            if (this.mGestureDetector == null || !this.mGestureDetector.onTouchEvent(motionEvent)) {
                return z;
            }
            return true;
        }
        return false;
    }

    public void setAllowParentInterceptOnEdge(boolean z) {
        this.oTx = z;
    }

    public void setMinimumScale(float f2) {
        i(f2, this.oTw, this.mMaxScale);
        this.mMinScale = f2;
    }

    public void setMediumScale(float f2) {
        i(this.mMinScale, f2, this.mMaxScale);
        this.oTw = f2;
    }

    public void setMaximumScale(float f2) {
        i(this.mMinScale, this.oTw, f2);
        this.mMaxScale = f2;
    }

    public void setScaleLevels(float f2, float f3, float f4) {
        i(f2, f3, f4);
        this.mMinScale = f2;
        this.oTw = f3;
        this.mMaxScale = f4;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mLongClickListener = onLongClickListener;
    }

    public void setOnMatrixChangeListener(c cVar) {
        this.oTE = cVar;
    }

    public void setOnPhotoTapListener(InterfaceC0971d interfaceC0971d) {
        this.oTF = interfaceC0971d;
    }

    public InterfaceC0971d getOnPhotoTapListener() {
        return this.oTF;
    }

    public void setOnViewTapListener(f fVar) {
        this.oTG = fVar;
    }

    public f getOnViewTapListener() {
        return this.oTG;
    }

    public void setScale(float f2) {
        setScale(f2, false);
    }

    public void setScale(float f2, boolean z) {
        ImageView emW = emW();
        if (emW != null) {
            setScale(f2, emW.getRight() / 2, emW.getBottom() / 2, z);
        }
    }

    public void setScale(float f2, float f3, float f4, boolean z) {
        ImageView emW = emW();
        if (emW != null) {
            if (f2 < this.mMinScale || f2 > this.mMaxScale) {
                com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.b.a.enf().i("PhotoViewAttacher", "Scale must be within the range of minScale and maxScale");
            } else if (z) {
                emW.post(new a(getScale(), f2, f3, f4));
            } else {
                this.oTC.setScale(f2, f2, f3, f4);
                emY();
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
        this.oTO = z;
        update();
    }

    public void update() {
        ImageView emW = emW();
        if (emW != null) {
            if (this.oTO) {
                e(emW);
                l(emW.getDrawable());
                return;
            }
            enb();
        }
    }

    public Matrix getDisplayMatrix() {
        return new Matrix(getDrawMatrix());
    }

    public Matrix getDrawMatrix() {
        this.mDrawMatrix.set(this.oTB);
        this.mDrawMatrix.postConcat(this.oTC);
        return this.mDrawMatrix;
    }

    private void emX() {
        if (this.oTM != null) {
            this.oTM.emX();
            this.oTM = null;
        }
    }

    private void emY() {
        if (ena()) {
            d(getDrawMatrix());
        }
    }

    private void emZ() {
        ImageView emW = emW();
        if (emW != null && !(emW instanceof com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.c) && !ImageView.ScaleType.MATRIX.equals(emW.getScaleType())) {
            com.baidu.yuyinala.privatemessage.implugin.util.c.e("PhotoViewAttacher", "The ImageView's ScaleType has been changed since attaching a PhotoViewAttacher");
        }
    }

    private boolean ena() {
        RectF c2;
        float f2;
        float f3 = 0.0f;
        ImageView emW = emW();
        if (emW != null && (c2 = c(getDrawMatrix())) != null) {
            float height = c2.height();
            float width = c2.width();
            int g = g(emW);
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
            int f4 = f(emW);
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
                this.oTN = 2;
            } else if (c2.left > 0.0f) {
                this.oTN = 0;
                f3 = -c2.left;
            } else if (c2.right < f4) {
                f3 = f4 - c2.right;
                this.oTN = 1;
            } else {
                this.oTN = -1;
            }
            this.oTC.postTranslate(f3, f2);
            return true;
        }
        return false;
    }

    public Bitmap getVisibleRectangleBitmap() {
        ImageView emW = emW();
        if (emW == null) {
            return null;
        }
        return emW.getDrawingCache();
    }

    public void setZoomTransitionDuration(int i) {
        if (i < 0) {
            i = 200;
        }
        this.oTv = i;
    }

    private float a(Matrix matrix, int i) {
        matrix.getValues(this.mMatrixValues);
        if (i < 0 || i >= this.mMatrixValues.length) {
            return 0.0f;
        }
        return this.mMatrixValues[i];
    }

    private void enb() {
        this.oTC.reset();
        d(getDrawMatrix());
        ena();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Matrix matrix) {
        RectF c2;
        ImageView emW = emW();
        if (emW != null) {
            emZ();
            emW.setImageMatrix(matrix);
            if (this.oTE != null && (c2 = c(matrix)) != null) {
                this.oTE.a(c2);
            }
        }
    }

    private void l(Drawable drawable) {
        ImageView emW = emW();
        if (emW != null && drawable != null) {
            float f2 = f(emW);
            float g = g(emW);
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            this.oTB.reset();
            float f3 = f2 / intrinsicWidth;
            float f4 = g / intrinsicHeight;
            if (this.mScaleType == ImageView.ScaleType.CENTER) {
                this.oTB.postTranslate((f2 - intrinsicWidth) / 2.0f, (g - intrinsicHeight) / 2.0f);
            } else if (this.mScaleType == ImageView.ScaleType.CENTER_CROP) {
                float max = Math.max(f3, f4);
                this.oTB.postScale(max, max);
                this.oTB.postTranslate((f2 - (intrinsicWidth * max)) / 2.0f, (g - (intrinsicHeight * max)) / 2.0f);
            } else if (this.mScaleType == ImageView.ScaleType.CENTER_INSIDE) {
                float min = Math.min(1.0f, Math.min(f3, f4));
                this.oTB.postScale(min, min);
                this.oTB.postTranslate((f2 - (intrinsicWidth * min)) / 2.0f, (g - (intrinsicHeight * min)) / 2.0f);
            } else {
                RectF rectF = new RectF(0.0f, 0.0f, intrinsicWidth, intrinsicHeight);
                RectF rectF2 = new RectF(0.0f, 0.0f, f2, g);
                switch (AnonymousClass2.$SwitchMap$android$widget$ImageView$ScaleType[this.mScaleType.ordinal()]) {
                    case 2:
                        this.oTB.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.START);
                        break;
                    case 3:
                        this.oTB.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.END);
                        break;
                    case 4:
                        this.oTB.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
                        break;
                    case 5:
                        this.oTB.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.FILL);
                        break;
                }
            }
            enb();
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
        private final float oTQ;
        private final float oTR;
        private final float oTS;
        private final float oTT;

        public a(float f, float f2, float f3, float f4) {
            this.oTQ = f3;
            this.oTR = f4;
            this.oTS = f;
            this.oTT = f2;
        }

        @Override // java.lang.Runnable
        public void run() {
            ImageView emW = d.this.emW();
            if (emW != null) {
                float enc = enc();
                float f = this.oTS + ((this.oTT - this.oTS) * enc);
                if (d.this.getScale() > 0.0f) {
                    d.this.onScale(f / d.this.getScale(), this.oTQ, this.oTR);
                    if (enc < 1.0f) {
                        com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.postOnAnimation(emW, this);
                    }
                }
            }
        }

        private float enc() {
            return d.sInterpolator.getInterpolation(Math.min(1.0f, (((float) (System.currentTimeMillis() - this.mStartTime)) * 1.0f) / d.this.oTv));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class b implements Runnable {
        private int bIY;
        private int mCurrentX;
        private final com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.c.d oTU;

        public b(Context context) {
            this.oTU = com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.c.d.hq(context);
        }

        public void emX() {
            if (d.DEBUG) {
                com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.b.a.enf().d("PhotoViewAttacher", "Cancel Fling");
            }
            this.oTU.AF(true);
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
                this.bIY = round2;
                if (d.DEBUG) {
                    com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.b.a.enf().d("PhotoViewAttacher", "fling. StartX:" + round + " StartY:" + round2 + " MaxX:" + i5 + " MaxY:" + i7);
                }
                if (round != i5 || round2 != i7) {
                    this.oTU.fling(round, round2, i3, i4, i6, i5, i8, i7, 0, 0);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            ImageView emW;
            if (!this.oTU.isFinished() && (emW = d.this.emW()) != null && this.oTU.computeScrollOffset()) {
                int currX = this.oTU.getCurrX();
                int currY = this.oTU.getCurrY();
                if (d.DEBUG) {
                    com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.b.a.enf().d("PhotoViewAttacher", "fling run(). CurrentX:" + this.mCurrentX + " CurrentY:" + this.bIY + " NewX:" + currX + " NewY:" + currY);
                }
                d.this.oTC.postTranslate(this.mCurrentX - currX, this.bIY - currY);
                d.this.d(d.this.getDrawMatrix());
                this.mCurrentX = currX;
                this.bIY = currY;
                com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.postOnAnimation(emW, this);
            }
        }
    }
}
