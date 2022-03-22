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
import c.a.o0.c1.m;
import c.a.o0.c1.m0;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class CoverSelectLayout extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView a;

    /* renamed from: b  reason: collision with root package name */
    public ClipCoverView f37041b;

    /* renamed from: c  reason: collision with root package name */
    public float f37042c;

    /* renamed from: d  reason: collision with root package name */
    public float f37043d;

    /* renamed from: e  reason: collision with root package name */
    public float f37044e;

    /* renamed from: f  reason: collision with root package name */
    public float f37045f;

    /* renamed from: g  reason: collision with root package name */
    public float f37046g;

    /* renamed from: h  reason: collision with root package name */
    public Matrix f37047h;
    public Matrix i;
    public int j;
    public PointF k;
    public PointF l;
    public float m;
    public final float[] n;
    public float o;
    public float p;
    public int q;
    public int r;
    public int s;

    /* loaded from: classes6.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CoverSelectLayout f37048b;

        public a(CoverSelectLayout coverSelectLayout, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {coverSelectLayout, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f37048b = coverSelectLayout;
            this.a = str;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f37048b.f(this.a);
                this.f37048b.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
            RectF d2 = d(this.f37047h);
            int width = this.a.getWidth();
            int height = this.a.getHeight();
            float f3 = width;
            float f4 = this.f37045f;
            if (d2.width() + 0.01d >= f3 - (f4 * 2.0f)) {
                float f5 = d2.left;
                f2 = f5 > f4 ? (-f5) + f4 : 0.0f;
                float f6 = d2.right;
                float f7 = this.f37045f;
                if (f6 < f3 - f7) {
                    f2 = (f3 - f7) - f6;
                }
            } else {
                f2 = 0.0f;
            }
            float f8 = height;
            float f9 = this.f37044e;
            if (d2.height() + 0.01d >= f8 - (2.0f * f9)) {
                float f10 = d2.top;
                r11 = f10 > f9 ? (-f10) + f9 : 0.0f;
                float f11 = d2.bottom;
                float f12 = this.f37044e;
                if (f11 < f8 - f12) {
                    r11 = (f8 - f12) - f11;
                }
            }
            this.f37047h.postTranslate(f2, r11);
        }
    }

    public Bitmap c() {
        InterceptResult invokeV;
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            this.a.setDrawingCacheEnabled(true);
            this.a.buildDrawingCache();
            RectF clipCoverRect = this.f37041b.getClipCoverRect();
            try {
                bitmap = Bitmap.createBitmap(this.a.getDrawingCache(), (int) clipCoverRect.left, (int) clipCoverRect.top, (int) clipCoverRect.width(), (int) clipCoverRect.height());
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                bitmap = null;
            }
            this.a.destroyDrawingCache();
            return bitmap;
        }
        return (Bitmap) invokeV.objValue;
    }

    public final RectF d(Matrix matrix) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, matrix)) == null) {
            RectF rectF = new RectF();
            Drawable drawable = this.a.getDrawable();
            if (drawable != null) {
                rectF.set(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                matrix.mapRect(rectF);
            }
            return rectF;
        }
        return (RectF) invokeL.objValue;
    }

    public void e(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, context, attributeSet) == null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.obfuscated_res_0x7f040144, R.attr.obfuscated_res_0x7f0402a6, R.attr.obfuscated_res_0x7f040683});
            this.f37042c = obtainStyledAttributes.getDimensionPixelSize(1, (int) TypedValue.applyDimension(1, 0.0f, getResources().getDisplayMetrics()));
            this.f37043d = obtainStyledAttributes.getDimensionPixelSize(2, (int) TypedValue.applyDimension(1, 0.0f, getResources().getDisplayMetrics()));
            this.f37046g = obtainStyledAttributes.getDimensionPixelSize(0, (int) TypedValue.applyDimension(1, 1.0f, getResources().getDisplayMetrics()));
            obtainStyledAttributes.recycle();
            ClipCoverView clipCoverView = new ClipCoverView(context);
            this.f37041b = clipCoverView;
            clipCoverView.setClipBorderWidth(this.f37046g);
            this.f37041b.setmHorizontal(this.f37042c);
            this.f37041b.setmVerticalPadding(this.f37043d);
            this.a = new ImageView(context);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            addView(this.a, layoutParams);
            addView(this.f37041b, layoutParams);
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            this.q = displayMetrics.widthPixels;
            this.r = displayMetrics.heightPixels;
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
    public void f(String str) {
        float height;
        float height2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        int[] e2 = m.e(str);
        int i = e2[0];
        int i2 = e2[1];
        int i3 = this.q;
        if (i > i3) {
            i = i3;
        }
        int i4 = this.r;
        if (i2 > i4) {
            i2 = i4;
        }
        Bitmap b2 = m.b(str, i, i2);
        if (b2 == null) {
            return;
        }
        int readPictureDegree = BitmapHelper.readPictureDegree(str);
        Matrix matrix = new Matrix();
        matrix.setRotate(readPictureDegree);
        Bitmap createBitmap = Bitmap.createBitmap(b2, 0, 0, b2.getWidth(), b2.getHeight(), matrix, true);
        float width = (createBitmap.getWidth() * 1.0f) / createBitmap.getHeight();
        RectF clipCoverRect = this.f37041b.getClipCoverRect();
        if (width <= clipCoverRect.width() / clipCoverRect.height()) {
            height = this.a.getWidth() / createBitmap.getWidth();
            height2 = clipCoverRect.width() / createBitmap.getWidth();
            this.o = height2;
        } else {
            height = this.a.getHeight() / createBitmap.getHeight();
            height2 = clipCoverRect.height() / createBitmap.getHeight();
            this.o = height2;
        }
        this.f37047h.postScale(height, height);
        this.f37047h.postTranslate((this.a.getWidth() * 0.5f) - ((int) ((createBitmap.getWidth() * height) * 0.5f)), (this.a.getHeight() * 0.5f) - ((int) ((createBitmap.getHeight() * height) * 0.5f)));
        this.a.setScaleType(ImageView.ScaleType.MATRIX);
        this.a.setImageMatrix(this.f37047h);
        this.a.setImageBitmap(createBitmap);
    }

    public final float getScale() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            this.f37047h.getValues(this.n);
            return this.n[0];
        }
        return invokeV.floatValue;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, motionEvent)) == null) {
            int action = motionEvent.getAction() & 255;
            if (action == 0) {
                this.i.set(this.f37047h);
                this.k.set(motionEvent.getX(), motionEvent.getY());
                this.j = 1;
            } else if (action == 2) {
                int i = this.j;
                if (i == 1) {
                    this.f37047h.set(this.i);
                    float x = motionEvent.getX() - this.k.x;
                    float y = motionEvent.getY() - this.k.y;
                    this.f37044e = this.f37041b.getClipCoverRect().top;
                    this.f37045f = this.f37041b.getClipCoverRect().left;
                    this.f37047h.postTranslate(x, y);
                    b();
                } else if (i == 2) {
                    float d2 = m0.d(motionEvent);
                    if (d2 > 10.0f) {
                        float f2 = d2 / this.m;
                        if (f2 < 1.0f) {
                            if (getScale() > this.o) {
                                this.f37047h.set(this.i);
                                this.f37044e = this.f37041b.getClipCoverRect().top;
                                this.f37045f = this.f37041b.getClipCoverRect().left;
                                Matrix matrix = this.f37047h;
                                PointF pointF = this.l;
                                matrix.postScale(f2, f2, pointF.x, pointF.y);
                                while (getScale() < this.o) {
                                    Matrix matrix2 = this.f37047h;
                                    PointF pointF2 = this.l;
                                    matrix2.postScale(1.01f, 1.01f, pointF2.x, pointF2.y);
                                }
                            }
                            b();
                        } else if (getScale() <= this.p) {
                            this.f37047h.set(this.i);
                            this.f37044e = this.f37041b.getClipCoverRect().top;
                            this.f37045f = this.f37041b.getClipCoverRect().left;
                            Matrix matrix3 = this.f37047h;
                            PointF pointF3 = this.l;
                            matrix3.postScale(f2, f2, pointF3.x, pointF3.y);
                        }
                    }
                }
                this.a.setImageMatrix(this.f37047h);
            } else if (action == 5) {
                float d3 = m0.d(motionEvent);
                this.m = d3;
                if (d3 > 10.0f) {
                    this.i.set(this.f37047h);
                    this.l = m0.b(motionEvent);
                    this.j = 2;
                }
            } else if (action == 6) {
                this.j = 0;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void setClipType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.s = i;
            if (i == 1) {
                this.f37042c = UtilHelper.getDimenPixelSize(R.dimen.tbds920);
                this.f37043d = UtilHelper.getDimenPixelSize(R.dimen.tbds520);
            } else if (i == 2) {
                this.f37042c = UtilHelper.getDimenPixelSize(R.dimen.tbds920);
                this.f37043d = UtilHelper.getDimenPixelSize(R.dimen.tbds1227);
            }
            float dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.L_X04);
            this.f37046g = dimenPixelSize;
            this.f37041b.setClipBorderWidth(dimenPixelSize);
            this.f37041b.setmHorizontal(this.f37042c);
            this.f37041b.setmVerticalPadding(this.f37043d);
        }
    }

    public void setImagSrc(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.a.getViewTreeObserver().addOnGlobalLayoutListener(new a(this, str));
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoverSelectLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f37047h = new Matrix();
        this.i = new Matrix();
        this.j = 0;
        this.k = new PointF();
        this.l = new PointF();
        this.m = 1.0f;
        this.n = new float[9];
        this.p = 4.0f;
        e(context, attributeSet);
    }
}
