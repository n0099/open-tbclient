package com.baidu.wallet.base.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.base.widget.NetImageView;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class RoundRectNetImageView extends NetImageView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f60197a;

    /* renamed from: b  reason: collision with root package name */
    public int f60198b;

    /* renamed from: c  reason: collision with root package name */
    public int f60199c;

    /* renamed from: d  reason: collision with root package name */
    public int f60200d;

    /* renamed from: e  reason: collision with root package name */
    public Bitmap f60201e;

    /* renamed from: f  reason: collision with root package name */
    public Paint f60202f;

    /* renamed from: g  reason: collision with root package name */
    public Paint f60203g;

    /* renamed from: h  reason: collision with root package name */
    public final Matrix f60204h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f60205i;

    /* renamed from: j  reason: collision with root package name */
    public int f60206j;
    public int k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoundRectNetImageView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f60197a = RoundRectNetImageView.class.getName();
        this.f60204h = new Matrix();
        this.f60205i = true;
        this.f60206j = 0;
        this.k = 0;
        c();
    }

    private void a(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, context, attributeSet) == null) {
            this.f60205i = true;
            this.f60206j = -1;
        }
    }

    private int b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(AdIconUtil.AD_TEXT_ID, this, i2)) == null) {
            return View.MeasureSpec.getMode(i2) == 1073741824 ? View.MeasureSpec.getSize(i2) : this.f60199c;
        }
        return invokeI.intValue;
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            Paint paint = new Paint();
            this.f60202f = paint;
            paint.setAntiAlias(true);
            Paint paint2 = new Paint();
            this.f60203g = paint2;
            paint2.setAntiAlias(true);
            this.f60204h.set(null);
            this.f60204h.postTranslate(this.f60198b, this.f60199c);
            this.f60200d = DisplayUtils.dip2px(getContext(), 39.0f);
        }
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) getDrawable();
            if (bitmapDrawable == null) {
                bitmapDrawable = (BitmapDrawable) getResources().getDrawable(this.k);
            }
            if (bitmapDrawable != null) {
                this.f60201e = bitmapDrawable.getBitmap();
            }
        }
    }

    @Override // com.baidu.apollon.base.widget.NetImageView, android.widget.ImageView, android.view.View
    @SuppressLint({"DrawAllocation"})
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            if (this.f60205i) {
                d();
                if (this.f60201e == null) {
                    return;
                }
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(this.f60201e, this.f60198b, this.f60199c, false);
                Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                BitmapShader bitmapShader = new BitmapShader(createScaledBitmap, tileMode, tileMode);
                bitmapShader.setLocalMatrix(this.f60204h);
                this.f60202f.setShader(bitmapShader);
            } else {
                this.f60202f.setColor(this.f60206j);
            }
            Path path = new Path();
            path.moveTo(this.f60200d, 0.0f);
            path.lineTo(this.f60198b - this.f60200d, 0.0f);
            int i2 = this.f60198b;
            path.quadTo(i2, 0.0f, i2, this.f60200d);
            path.lineTo(this.f60198b, this.f60199c - this.f60200d);
            int i3 = this.f60198b;
            int i4 = this.f60199c;
            path.quadTo(i3, i4, i3 - this.f60200d, i4);
            path.lineTo(this.f60200d, this.f60199c);
            int i5 = this.f60199c;
            path.quadTo(0.0f, i5, 0.0f, i5 - this.f60200d);
            path.lineTo(0.0f, this.f60200d);
            path.quadTo(0.0f, 0.0f, this.f60200d, 0.0f);
            path.close();
            canvas.drawPath(path, this.f60202f);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
            int a2 = a(i2);
            int b2 = b(i3);
            this.f60198b = a2;
            this.f60199c = b2;
            setMeasuredDimension(a2, b2);
        }
    }

    public void setBackgroudColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f60206j = i2;
        }
    }

    public void setCornerSize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f60200d = i2;
        }
    }

    public void setResId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            setImageResource(0);
            setImageResource(i2);
            invalidate();
        }
    }

    private int a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, this, i2)) == null) {
            return View.MeasureSpec.getMode(i2) == 1073741824 ? View.MeasureSpec.getSize(i2) : this.f60198b;
        }
        return invokeI.intValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoundRectNetImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f60197a = RoundRectNetImageView.class.getName();
        this.f60204h = new Matrix();
        this.f60205i = true;
        this.f60206j = 0;
        this.k = 0;
        a(context, attributeSet);
        c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoundRectNetImageView(Context context, AttributeSet attributeSet, int i2) {
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
        this.f60197a = RoundRectNetImageView.class.getName();
        this.f60204h = new Matrix();
        this.f60205i = true;
        this.f60206j = 0;
        this.k = 0;
        a(context, attributeSet);
        c();
    }
}
