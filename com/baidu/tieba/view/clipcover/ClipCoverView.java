package com.baidu.tieba.view.clipcover;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.tieba.l75;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class ClipCoverView extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Paint a;
    public Paint b;
    public Path c;
    public float d;
    public Xfermode e;
    public Context f;
    public int g;
    public int h;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ClipCoverView(Context context) {
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

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ClipCoverView(Context context, AttributeSet attributeSet) {
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
    public ClipCoverView(Context context, AttributeSet attributeSet, int i) {
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
        Paint paint = new Paint();
        this.a = paint;
        paint.setAntiAlias(true);
        this.a.setStyle(Paint.Style.FILL);
        this.e = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
        this.f = context;
        b();
    }

    public final void a(@NonNull Canvas canvas, Path path) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, canvas, path) == null) {
            canvas.drawPath(path, this.b);
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Paint paint = new Paint();
            this.b = paint;
            paint.setAntiAlias(true);
            this.b.setStyle(Paint.Style.STROKE);
            this.b.setStrokeWidth(this.d);
            this.b.setColor(getResources().getColor(R.color.CAM_X0402));
        }
    }

    public RectF getClipCoverRect() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            RectF rectF = new RectF();
            rectF.left = (getWidth() - this.g) * 0.5f;
            rectF.right = (getWidth() + this.g) * 0.5f;
            rectF.top = (getHeight() - this.h) * 0.5f;
            rectF.bottom = (getHeight() + this.h) * 0.5f;
            return rectF;
        }
        return (RectF) invokeV.objValue;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, canvas) == null) {
            super.onDraw(canvas);
            canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
            canvas.drawColor(getResources().getColor(R.color.CAM_X0608));
            this.a.setXfermode(this.e);
            RectF clipCoverRect = getClipCoverRect();
            if (this.c == null) {
                this.c = new Path();
            }
            this.c.reset();
            this.c.addRoundRect(clipCoverRect, l75.B(R.string.J_X05), Path.Direction.CW);
            canvas.drawPath(this.c, this.a);
            a(canvas, this.c);
            canvas.restore();
        }
    }

    public void setClipBorderWidth(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048580, this, f) == null) {
            this.d = f;
            this.b.setStrokeWidth(f);
            invalidate();
        }
    }

    public void setmHorizontal(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048581, this, f) == null) {
            this.g = (int) f;
        }
    }

    public void setmVerticalPadding(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048582, this, f) == null) {
            this.h = (int) f;
        }
    }
}
