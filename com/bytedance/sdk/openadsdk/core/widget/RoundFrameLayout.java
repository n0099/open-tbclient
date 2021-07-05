package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes6.dex */
public class RoundFrameLayout extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Path f30642a;

    /* renamed from: b  reason: collision with root package name */
    public Paint f30643b;

    /* renamed from: c  reason: collision with root package name */
    public RectF f30644c;

    /* renamed from: d  reason: collision with root package name */
    public float[] f30645d;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RoundFrameLayout(@NonNull Context context) {
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

    public void a(float f2, float f3, float f4, float f5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)}) == null) {
            float[] fArr = this.f30645d;
            fArr[0] = f2;
            fArr[1] = f2;
            fArr[2] = f3;
            fArr[3] = f3;
            fArr[4] = f5;
            fArr[5] = f5;
            fArr[6] = f4;
            fArr[7] = f4;
            postInvalidate();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) {
            if (Build.VERSION.SDK_INT >= 28) {
                canvas.save();
                canvas.clipPath(a());
                super.dispatchDraw(canvas);
            } else {
                canvas.saveLayer(this.f30644c, null, 31);
                super.dispatchDraw(canvas);
                canvas.drawPath(a(), this.f30643b);
            }
            canvas.restore();
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            if (Build.VERSION.SDK_INT >= 28) {
                canvas.save();
                canvas.clipPath(a());
                super.draw(canvas);
            } else {
                canvas.saveLayer(this.f30644c, null, 31);
                super.draw(canvas);
                canvas.drawPath(a(), this.f30643b);
            }
            canvas.restore();
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048579, this, i2, i3, i4, i5) == null) {
            super.onSizeChanged(i2, i3, i4, i5);
            this.f30644c.set(0.0f, 0.0f, i2, i3);
        }
    }

    public void setBottomLeftRadius(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048580, this, f2) == null) {
            float[] fArr = this.f30645d;
            fArr[6] = f2;
            fArr[7] = f2;
            postInvalidate();
        }
    }

    public void setBottomRightRadius(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048581, this, f2) == null) {
            float[] fArr = this.f30645d;
            fArr[5] = f2;
            fArr[6] = f2;
            postInvalidate();
        }
    }

    public void setRadius(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048582, this, f2) == null) {
            Arrays.fill(this.f30645d, f2);
            postInvalidate();
        }
    }

    public void setTopLeftRadius(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048583, this, f2) == null) {
            float[] fArr = this.f30645d;
            fArr[0] = f2;
            fArr[1] = f2;
            postInvalidate();
        }
    }

    public void setTopRightRadius(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(InputDeviceCompat.SOURCE_TOUCHPAD, this, f2) == null) {
            float[] fArr = this.f30645d;
            fArr[2] = f2;
            fArr[3] = f2;
            postInvalidate();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RoundFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
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
    public RoundFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        this.f30642a = new Path();
        this.f30644c = new RectF();
        Paint paint = new Paint();
        this.f30643b = paint;
        paint.setAntiAlias(true);
        this.f30643b.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        this.f30645d = new float[8];
    }

    private Path a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            this.f30642a.reset();
            this.f30642a.addRoundRect(this.f30644c, this.f30645d, Path.Direction.CW);
            return this.f30642a;
        }
        return (Path) invokeV.objValue;
    }
}
