package com.baidu.tieba.view.clipcover;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.s0.d1.m;
import c.a.s0.d1.m0;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.R$styleable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes13.dex */
public class CoverSelectLayout extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f49302e;

    /* renamed from: f  reason: collision with root package name */
    public ClipCoverView f49303f;

    /* renamed from: g  reason: collision with root package name */
    public float f49304g;

    /* renamed from: h  reason: collision with root package name */
    public float f49305h;

    /* renamed from: i  reason: collision with root package name */
    public float f49306i;

    /* renamed from: j  reason: collision with root package name */
    public float f49307j;
    public float k;
    public Matrix l;
    public Matrix m;
    public int n;
    public PointF o;
    public PointF p;
    public float q;
    public final float[] r;
    public float s;
    public float t;
    public int u;
    public int v;
    public int w;

    /* loaded from: classes13.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f49308e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CoverSelectLayout f49309f;

        public a(CoverSelectLayout coverSelectLayout, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {coverSelectLayout, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49309f = coverSelectLayout;
            this.f49308e = str;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f49309f.initSrcPic(this.f49308e);
                this.f49309f.f49302e.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CoverSelectLayout(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void b() {
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            RectF c2 = c(this.l);
            int width = this.f49302e.getWidth();
            int height = this.f49302e.getHeight();
            float f3 = width;
            float f4 = this.f49307j;
            if (c2.width() + 0.01d >= f3 - (f4 * 2.0f)) {
                float f5 = c2.left;
                f2 = f5 > f4 ? (-f5) + f4 : 0.0f;
                float f6 = c2.right;
                float f7 = this.f49307j;
                if (f6 < f3 - f7) {
                    f2 = (f3 - f7) - f6;
                }
            } else {
                f2 = 0.0f;
            }
            float f8 = height;
            float f9 = this.f49306i;
            if (c2.height() + 0.01d >= f8 - (2.0f * f9)) {
                float f10 = c2.top;
                r11 = f10 > f9 ? (-f10) + f9 : 0.0f;
                float f11 = c2.bottom;
                float f12 = this.f49306i;
                if (f11 < f8 - f12) {
                    r11 = (f8 - f12) - f11;
                }
            }
            this.l.postTranslate(f2, r11);
        }
    }

    public final RectF c(Matrix matrix) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, matrix)) == null) {
            RectF rectF = new RectF();
            Drawable drawable = this.f49302e.getDrawable();
            if (drawable != null) {
                rectF.set(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                matrix.mapRect(rectF);
            }
            return rectF;
        }
        return (RectF) invokeL.objValue;
    }

    public Bitmap clip() {
        InterceptResult invokeV;
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            this.f49302e.setDrawingCacheEnabled(true);
            this.f49302e.buildDrawingCache();
            RectF clipCoverRect = this.f49303f.getClipCoverRect();
            try {
                bitmap = Bitmap.createBitmap(this.f49302e.getDrawingCache(), (int) clipCoverRect.left, (int) clipCoverRect.top, (int) clipCoverRect.width(), (int) clipCoverRect.height());
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                bitmap = null;
            }
            this.f49302e.destroyDrawingCache();
            return bitmap;
        }
        return (Bitmap) invokeV.objValue;
    }

    public final float getScale() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            this.l.getValues(this.r);
            return this.r[0];
        }
        return invokeV.floatValue;
    }

    public void init(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, context, attributeSet) == null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CoverSelectLayout);
            this.f49304g = obtainStyledAttributes.getDimensionPixelSize(R$styleable.CoverSelectLayout_horizontal, (int) TypedValue.applyDimension(1, 0.0f, getResources().getDisplayMetrics()));
            this.f49305h = obtainStyledAttributes.getDimensionPixelSize(R$styleable.CoverSelectLayout_vertivalPadding, (int) TypedValue.applyDimension(1, 0.0f, getResources().getDisplayMetrics()));
            this.k = obtainStyledAttributes.getDimensionPixelSize(R$styleable.CoverSelectLayout_clipBorderWidth, (int) TypedValue.applyDimension(1, 1.0f, getResources().getDisplayMetrics()));
            obtainStyledAttributes.recycle();
            ClipCoverView clipCoverView = new ClipCoverView(context);
            this.f49303f = clipCoverView;
            clipCoverView.setClipBorderWidth(this.k);
            this.f49303f.setmHorizontal(this.f49304g);
            this.f49303f.setmVerticalPadding(this.f49305h);
            this.f49302e = new ImageView(context);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            addView(this.f49302e, layoutParams);
            addView(this.f49303f, layoutParams);
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            this.u = displayMetrics.widthPixels;
            this.v = displayMetrics.heightPixels;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x007f, code lost:
        if (r0 < r1) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x009d, code lost:
        if (r0 < r1) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x009f, code lost:
        r0 = r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void initSrcPic(String str) {
        float height;
        float height2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        int[] e2 = m.e(str);
        int i2 = e2[0];
        int i3 = e2[1];
        int i4 = this.u;
        if (i2 > i4) {
            i2 = i4;
        }
        int i5 = this.v;
        if (i3 > i5) {
            i3 = i5;
        }
        Bitmap b2 = m.b(str, i2, i3);
        if (b2 == null) {
            return;
        }
        int readPictureDegree = BitmapHelper.readPictureDegree(str);
        Matrix matrix = new Matrix();
        matrix.setRotate(readPictureDegree);
        Bitmap createBitmap = Bitmap.createBitmap(b2, 0, 0, b2.getWidth(), b2.getHeight(), matrix, true);
        float width = (createBitmap.getWidth() * 1.0f) / createBitmap.getHeight();
        RectF clipCoverRect = this.f49303f.getClipCoverRect();
        if (width <= clipCoverRect.width() / clipCoverRect.height()) {
            height = this.f49302e.getWidth() / createBitmap.getWidth();
            height2 = clipCoverRect.width() / createBitmap.getWidth();
            this.s = height2;
        } else {
            height = this.f49302e.getHeight() / createBitmap.getHeight();
            height2 = clipCoverRect.height() / createBitmap.getHeight();
            this.s = height2;
        }
        this.l.postScale(height, height);
        this.l.postTranslate((this.f49302e.getWidth() * 0.5f) - ((int) ((createBitmap.getWidth() * height) * 0.5f)), (this.f49302e.getHeight() * 0.5f) - ((int) ((createBitmap.getHeight() * height) * 0.5f)));
        this.f49302e.setScaleType(ImageView.ScaleType.MATRIX);
        this.f49302e.setImageMatrix(this.l);
        this.f49302e.setImageBitmap(createBitmap);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, motionEvent)) == null) {
            int action = motionEvent.getAction() & 255;
            if (action == 0) {
                this.m.set(this.l);
                this.o.set(motionEvent.getX(), motionEvent.getY());
                this.n = 1;
            } else if (action == 2) {
                int i2 = this.n;
                if (i2 == 1) {
                    this.l.set(this.m);
                    float x = motionEvent.getX() - this.o.x;
                    float y = motionEvent.getY() - this.o.y;
                    this.f49306i = this.f49303f.getClipCoverRect().top;
                    this.f49307j = this.f49303f.getClipCoverRect().left;
                    this.l.postTranslate(x, y);
                    b();
                } else if (i2 == 2) {
                    float d2 = m0.d(motionEvent);
                    if (d2 > 10.0f) {
                        float f2 = d2 / this.q;
                        if (f2 < 1.0f) {
                            if (getScale() > this.s) {
                                this.l.set(this.m);
                                this.f49306i = this.f49303f.getClipCoverRect().top;
                                this.f49307j = this.f49303f.getClipCoverRect().left;
                                Matrix matrix = this.l;
                                PointF pointF = this.p;
                                matrix.postScale(f2, f2, pointF.x, pointF.y);
                                while (getScale() < this.s) {
                                    Matrix matrix2 = this.l;
                                    PointF pointF2 = this.p;
                                    matrix2.postScale(1.01f, 1.01f, pointF2.x, pointF2.y);
                                }
                            }
                            b();
                        } else if (getScale() <= this.t) {
                            this.l.set(this.m);
                            this.f49306i = this.f49303f.getClipCoverRect().top;
                            this.f49307j = this.f49303f.getClipCoverRect().left;
                            Matrix matrix3 = this.l;
                            PointF pointF3 = this.p;
                            matrix3.postScale(f2, f2, pointF3.x, pointF3.y);
                        }
                    }
                }
                this.f49302e.setImageMatrix(this.l);
            } else if (action == 5) {
                float d3 = m0.d(motionEvent);
                this.q = d3;
                if (d3 > 10.0f) {
                    this.m.set(this.l);
                    this.p = m0.b(motionEvent);
                    this.n = 2;
                }
            } else if (action == 6) {
                this.n = 0;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void setClipType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.w = i2;
            if (i2 == 1) {
                this.f49304g = UtilHelper.getDimenPixelSize(R.dimen.tbds920);
                this.f49305h = UtilHelper.getDimenPixelSize(R.dimen.tbds520);
            } else if (i2 == 2) {
                this.f49304g = UtilHelper.getDimenPixelSize(R.dimen.tbds920);
                this.f49305h = UtilHelper.getDimenPixelSize(R.dimen.tbds1227);
            }
            float dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.L_X04);
            this.k = dimenPixelSize;
            this.f49303f.setClipBorderWidth(dimenPixelSize);
            this.f49303f.setmHorizontal(this.f49304g);
            this.f49303f.setmVerticalPadding(this.f49305h);
        }
    }

    public void setImagSrc(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.f49302e.getViewTreeObserver().addOnGlobalLayoutListener(new a(this, str));
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CoverSelectLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoverSelectLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.l = new Matrix();
        this.m = new Matrix();
        this.n = 0;
        this.o = new PointF();
        this.p = new PointF();
        this.q = 1.0f;
        this.r = new float[9];
        this.t = 4.0f;
        init(context, attributeSet);
    }
}
