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
    private final RectF otA;
    private c otB;
    private InterfaceC0933d otC;
    private f otD;
    private e otE;
    private int otF;
    private int otG;
    private int otH;
    private int otI;
    private b otJ;
    private int otK;
    private boolean otL;
    private int ots;
    private float ott;
    private boolean otu;
    private boolean otv;
    private WeakReference<ImageView> otw;
    private com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.d otx;
    private final Matrix oty;
    private final Matrix otz;

    /* loaded from: classes4.dex */
    public interface c {
        void a(RectF rectF);
    }

    /* renamed from: com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.d$d  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0933d {
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
        this.ots = 200;
        this.mMinScale = 1.0f;
        this.ott = 1.75f;
        this.mMaxScale = 3.0f;
        this.otu = true;
        this.otv = false;
        this.oty = new Matrix();
        this.mDrawMatrix = new Matrix();
        this.otz = new Matrix();
        this.otA = new RectF();
        this.mMatrixValues = new float[9];
        this.otK = 2;
        this.mScaleType = ImageView.ScaleType.FIT_CENTER;
        this.otw = new WeakReference<>(imageView);
        imageView.setDrawingCacheEnabled(true);
        imageView.setOnTouchListener(this);
        ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }
        e(imageView);
        if (!imageView.isInEditMode()) {
            this.otx = com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.f.a(imageView.getContext(), this);
            this.mGestureDetector = new GestureDetector(imageView.getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.d.1
                @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
                public void onLongPress(MotionEvent motionEvent) {
                    if (d.this.mLongClickListener != null) {
                        d.this.mLongClickListener.onLongClick(d.this.edv());
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
        this.otE = eVar;
    }

    public void cleanup() {
        if (this.otw != null) {
            ImageView imageView = this.otw.get();
            if (imageView != null) {
                ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
                if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeGlobalOnLayoutListener(this);
                }
                imageView.setOnTouchListener(null);
                edw();
            }
            if (this.mGestureDetector != null) {
                this.mGestureDetector.setOnDoubleTapListener(null);
            }
            this.otB = null;
            this.otC = null;
            this.otD = null;
            this.otw = null;
        }
    }

    public RectF getDisplayRect() {
        edz();
        return c(getDrawMatrix());
    }

    private RectF c(Matrix matrix) {
        Drawable drawable;
        ImageView edv = edv();
        if (edv == null || (drawable = edv.getDrawable()) == null) {
            return null;
        }
        this.otA.set(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        matrix.mapRect(this.otA);
        return this.otA;
    }

    public void setRotationTo(float f2) {
        this.otz.setRotate(f2 % 360.0f);
        edx();
    }

    public void setRotationBy(float f2) {
        this.otz.postRotate(f2 % 360.0f);
        edx();
    }

    public ImageView edv() {
        ImageView imageView = null;
        if (this.otw != null) {
            imageView = this.otw.get();
        }
        if (imageView == null) {
            cleanup();
            com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.b.a.edD().i("PhotoViewAttacher", "ImageView no longer exists. You should not use this PhotoViewAttacher any more.");
        }
        return imageView;
    }

    public float getMinimumScale() {
        return this.mMinScale;
    }

    public float getMediumScale() {
        return this.ott;
    }

    public float getMaximumScale() {
        return this.mMaxScale;
    }

    public float getScale() {
        return (float) Math.sqrt(((float) Math.pow(a(this.otz, 0), 2.0d)) + ((float) Math.pow(a(this.otz, 3), 2.0d)));
    }

    public ImageView.ScaleType getScaleType() {
        return this.mScaleType;
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.e
    public void onDrag(float f2, float f3) {
        if (!this.otx.edC()) {
            if (DEBUG) {
                com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.b.a.edD().d("PhotoViewAttacher", String.format("onDrag: dx: %.2f. dy: %.2f", Float.valueOf(f2), Float.valueOf(f3)));
            }
            ImageView edv = edv();
            this.otz.postTranslate(f2, f3);
            edx();
            ViewParent parent = edv.getParent();
            if (this.otu && !this.otx.edC() && !this.otv) {
                if ((this.otK == 2 || ((this.otK == 0 && f2 >= 1.0f) || (this.otK == 1 && f2 <= -1.0f))) && parent != null) {
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
            com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.b.a.edD().d("PhotoViewAttacher", "onFling. sX: " + f2 + " sY: " + f3 + " Vx: " + f4 + " Vy: " + f5);
        }
        ImageView edv = edv();
        this.otJ = new b(edv.getContext());
        this.otJ.J(f(edv), g(edv), (int) f4, (int) f5);
        edv.post(this.otJ);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        ImageView edv = edv();
        if (edv != null) {
            if (this.otL) {
                int top = edv.getTop();
                int right = edv.getRight();
                int bottom = edv.getBottom();
                int left = edv.getLeft();
                if (top != this.otF || bottom != this.otH || left != this.otI || right != this.otG) {
                    k(edv.getDrawable());
                    this.otF = top;
                    this.otG = right;
                    this.otH = bottom;
                    this.otI = left;
                    return;
                }
                return;
            }
            k(edv.getDrawable());
        }
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.e
    public void onScale(float f2, float f3, float f4) {
        if (DEBUG) {
            com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.b.a.edD().d("PhotoViewAttacher", String.format("onScale: scale: %.2f. fX: %.2f. fY: %.2f", Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)));
        }
        if (getScale() < this.mMaxScale || f2 < 1.0f) {
            if (this.otE != null) {
                this.otE.j(f2, f3, f4);
            }
            this.otz.postScale(f2, f2, f3, f4);
            edx();
        }
    }

    @Override // android.view.View.OnTouchListener
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouch(View view, MotionEvent motionEvent) {
        RectF displayRect;
        boolean z;
        boolean z2 = false;
        if (this.otL && d((ImageView) view)) {
            ViewParent parent = view.getParent();
            switch (motionEvent.getAction()) {
                case 0:
                    if (parent != null) {
                        parent.requestDisallowInterceptTouchEvent(true);
                    } else {
                        com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.b.a.edD().i("PhotoViewAttacher", "onTouch getParent() returned null");
                    }
                    edw();
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
            if (this.otx != null) {
                boolean edC = this.otx.edC();
                boolean isDragging = this.otx.isDragging();
                z = this.otx.onTouchEvent(motionEvent);
                boolean z3 = (edC || this.otx.edC()) ? false : true;
                boolean z4 = (isDragging || this.otx.isDragging()) ? false : true;
                if (z3 && z4) {
                    z2 = true;
                }
                this.otv = z2;
            }
            if (this.mGestureDetector == null || !this.mGestureDetector.onTouchEvent(motionEvent)) {
                return z;
            }
            return true;
        }
        return false;
    }

    public void setAllowParentInterceptOnEdge(boolean z) {
        this.otu = z;
    }

    public void setMinimumScale(float f2) {
        i(f2, this.ott, this.mMaxScale);
        this.mMinScale = f2;
    }

    public void setMediumScale(float f2) {
        i(this.mMinScale, f2, this.mMaxScale);
        this.ott = f2;
    }

    public void setMaximumScale(float f2) {
        i(this.mMinScale, this.ott, f2);
        this.mMaxScale = f2;
    }

    public void setScaleLevels(float f2, float f3, float f4) {
        i(f2, f3, f4);
        this.mMinScale = f2;
        this.ott = f3;
        this.mMaxScale = f4;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mLongClickListener = onLongClickListener;
    }

    public void setOnMatrixChangeListener(c cVar) {
        this.otB = cVar;
    }

    public void setOnPhotoTapListener(InterfaceC0933d interfaceC0933d) {
        this.otC = interfaceC0933d;
    }

    public InterfaceC0933d getOnPhotoTapListener() {
        return this.otC;
    }

    public void setOnViewTapListener(f fVar) {
        this.otD = fVar;
    }

    public f getOnViewTapListener() {
        return this.otD;
    }

    public void setScale(float f2) {
        setScale(f2, false);
    }

    public void setScale(float f2, boolean z) {
        ImageView edv = edv();
        if (edv != null) {
            setScale(f2, edv.getRight() / 2, edv.getBottom() / 2, z);
        }
    }

    public void setScale(float f2, float f3, float f4, boolean z) {
        ImageView edv = edv();
        if (edv != null) {
            if (f2 < this.mMinScale || f2 > this.mMaxScale) {
                com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.b.a.edD().i("PhotoViewAttacher", "Scale must be within the range of minScale and maxScale");
            } else if (z) {
                edv.post(new a(getScale(), f2, f3, f4));
            } else {
                this.otz.setScale(f2, f2, f3, f4);
                edx();
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
        this.otL = z;
        update();
    }

    public void update() {
        ImageView edv = edv();
        if (edv != null) {
            if (this.otL) {
                e(edv);
                k(edv.getDrawable());
                return;
            }
            edA();
        }
    }

    public Matrix getDisplayMatrix() {
        return new Matrix(getDrawMatrix());
    }

    public Matrix getDrawMatrix() {
        this.mDrawMatrix.set(this.oty);
        this.mDrawMatrix.postConcat(this.otz);
        return this.mDrawMatrix;
    }

    private void edw() {
        if (this.otJ != null) {
            this.otJ.edw();
            this.otJ = null;
        }
    }

    private void edx() {
        if (edz()) {
            d(getDrawMatrix());
        }
    }

    private void edy() {
        ImageView edv = edv();
        if (edv != null && !(edv instanceof com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.c) && !ImageView.ScaleType.MATRIX.equals(edv.getScaleType())) {
            com.baidu.yuyinala.privatemessage.implugin.util.c.e("PhotoViewAttacher", "The ImageView's ScaleType has been changed since attaching a PhotoViewAttacher");
        }
    }

    private boolean edz() {
        RectF c2;
        float f2;
        float f3 = 0.0f;
        ImageView edv = edv();
        if (edv != null && (c2 = c(getDrawMatrix())) != null) {
            float height = c2.height();
            float width = c2.width();
            int g = g(edv);
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
            int f4 = f(edv);
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
                this.otK = 2;
            } else if (c2.left > 0.0f) {
                this.otK = 0;
                f3 = -c2.left;
            } else if (c2.right < f4) {
                f3 = f4 - c2.right;
                this.otK = 1;
            } else {
                this.otK = -1;
            }
            this.otz.postTranslate(f3, f2);
            return true;
        }
        return false;
    }

    public Bitmap getVisibleRectangleBitmap() {
        ImageView edv = edv();
        if (edv == null) {
            return null;
        }
        return edv.getDrawingCache();
    }

    public void setZoomTransitionDuration(int i) {
        if (i < 0) {
            i = 200;
        }
        this.ots = i;
    }

    private float a(Matrix matrix, int i) {
        matrix.getValues(this.mMatrixValues);
        if (i < 0 || i >= this.mMatrixValues.length) {
            return 0.0f;
        }
        return this.mMatrixValues[i];
    }

    private void edA() {
        this.otz.reset();
        d(getDrawMatrix());
        edz();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Matrix matrix) {
        RectF c2;
        ImageView edv = edv();
        if (edv != null) {
            edy();
            edv.setImageMatrix(matrix);
            if (this.otB != null && (c2 = c(matrix)) != null) {
                this.otB.a(c2);
            }
        }
    }

    private void k(Drawable drawable) {
        ImageView edv = edv();
        if (edv != null && drawable != null) {
            float f2 = f(edv);
            float g = g(edv);
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            this.oty.reset();
            float f3 = f2 / intrinsicWidth;
            float f4 = g / intrinsicHeight;
            if (this.mScaleType == ImageView.ScaleType.CENTER) {
                this.oty.postTranslate((f2 - intrinsicWidth) / 2.0f, (g - intrinsicHeight) / 2.0f);
            } else if (this.mScaleType == ImageView.ScaleType.CENTER_CROP) {
                float max = Math.max(f3, f4);
                this.oty.postScale(max, max);
                this.oty.postTranslate((f2 - (intrinsicWidth * max)) / 2.0f, (g - (intrinsicHeight * max)) / 2.0f);
            } else if (this.mScaleType == ImageView.ScaleType.CENTER_INSIDE) {
                float min = Math.min(1.0f, Math.min(f3, f4));
                this.oty.postScale(min, min);
                this.oty.postTranslate((f2 - (intrinsicWidth * min)) / 2.0f, (g - (intrinsicHeight * min)) / 2.0f);
            } else {
                RectF rectF = new RectF(0.0f, 0.0f, intrinsicWidth, intrinsicHeight);
                RectF rectF2 = new RectF(0.0f, 0.0f, f2, g);
                switch (AnonymousClass2.$SwitchMap$android$widget$ImageView$ScaleType[this.mScaleType.ordinal()]) {
                    case 2:
                        this.oty.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.START);
                        break;
                    case 3:
                        this.oty.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.END);
                        break;
                    case 4:
                        this.oty.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
                        break;
                    case 5:
                        this.oty.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.FILL);
                        break;
                }
            }
            edA();
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
        private final float otN;
        private final float otO;
        private final float otP;
        private final float otQ;

        public a(float f, float f2, float f3, float f4) {
            this.otN = f3;
            this.otO = f4;
            this.otP = f;
            this.otQ = f2;
        }

        @Override // java.lang.Runnable
        public void run() {
            ImageView edv = d.this.edv();
            if (edv != null) {
                float edB = edB();
                float f = this.otP + ((this.otQ - this.otP) * edB);
                if (d.this.getScale() > 0.0f) {
                    d.this.onScale(f / d.this.getScale(), this.otN, this.otO);
                    if (edB < 1.0f) {
                        com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.postOnAnimation(edv, this);
                    }
                }
            }
        }

        private float edB() {
            return d.sInterpolator.getInterpolation(Math.min(1.0f, (((float) (System.currentTimeMillis() - this.mStartTime)) * 1.0f) / d.this.ots));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class b implements Runnable {
        private int bzq;
        private int mCurrentX;
        private final com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.c.d otR;

        public b(Context context) {
            this.otR = com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.c.d.gJ(context);
        }

        public void edw() {
            if (d.DEBUG) {
                com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.b.a.edD().d("PhotoViewAttacher", "Cancel Fling");
            }
            this.otR.zJ(true);
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
                this.bzq = round2;
                if (d.DEBUG) {
                    com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.b.a.edD().d("PhotoViewAttacher", "fling. StartX:" + round + " StartY:" + round2 + " MaxX:" + i5 + " MaxY:" + i7);
                }
                if (round != i5 || round2 != i7) {
                    this.otR.fling(round, round2, i3, i4, i6, i5, i8, i7, 0, 0);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            ImageView edv;
            if (!this.otR.isFinished() && (edv = d.this.edv()) != null && this.otR.computeScrollOffset()) {
                int currX = this.otR.getCurrX();
                int currY = this.otR.getCurrY();
                if (d.DEBUG) {
                    com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.b.a.edD().d("PhotoViewAttacher", "fling run(). CurrentX:" + this.mCurrentX + " CurrentY:" + this.bzq + " NewX:" + currX + " NewY:" + currY);
                }
                d.this.otz.postTranslate(this.mCurrentX - currX, this.bzq - currY);
                d.this.d(d.this.getDrawMatrix());
                this.mCurrentX = currX;
                this.bzq = currY;
                com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a.postOnAnimation(edv, this);
            }
        }
    }
}
