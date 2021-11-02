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
import b.a.q0.s.u.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class ClipCoverView extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Paint f55462e;

    /* renamed from: f  reason: collision with root package name */
    public Paint f55463f;

    /* renamed from: g  reason: collision with root package name */
    public Path f55464g;

    /* renamed from: h  reason: collision with root package name */
    public float f55465h;

    /* renamed from: i  reason: collision with root package name */
    public Xfermode f55466i;
    public Context j;
    public int k;
    public int l;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ClipCoverView(Context context) {
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

    public final void a(@NonNull Canvas canvas, Path path) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, canvas, path) == null) {
            canvas.drawPath(path, this.f55463f);
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Paint paint = new Paint();
            this.f55463f = paint;
            paint.setAntiAlias(true);
            this.f55463f.setStyle(Paint.Style.STROKE);
            this.f55463f.setStrokeWidth(this.f55465h);
            this.f55463f.setColor(getResources().getColor(R.color.CAM_X0402));
        }
    }

    public RectF getClipCoverRect() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            RectF rectF = new RectF();
            rectF.left = (getWidth() - this.k) * 0.5f;
            rectF.right = (getWidth() + this.k) * 0.5f;
            rectF.top = (getHeight() - this.l) * 0.5f;
            rectF.bottom = (getHeight() + this.l) * 0.5f;
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
            this.f55462e.setXfermode(this.f55466i);
            RectF clipCoverRect = getClipCoverRect();
            if (this.f55464g == null) {
                this.f55464g = new Path();
            }
            this.f55464g.reset();
            this.f55464g.addRoundRect(clipCoverRect, a.y(R.string.J_X05), Path.Direction.CW);
            canvas.drawPath(this.f55464g, this.f55462e);
            a(canvas, this.f55464g);
            canvas.restore();
        }
    }

    public void setClipBorderWidth(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048580, this, f2) == null) {
            this.f55465h = f2;
            this.f55463f.setStrokeWidth(f2);
            invalidate();
        }
    }

    public void setmHorizontal(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048581, this, f2) == null) {
            this.k = (int) f2;
        }
    }

    public void setmVerticalPadding(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048582, this, f2) == null) {
            this.l = (int) f2;
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
    public ClipCoverView(Context context, AttributeSet attributeSet, int i2) {
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
        Paint paint = new Paint();
        this.f55462e = paint;
        paint.setAntiAlias(true);
        this.f55462e.setStyle(Paint.Style.FILL);
        this.f55466i = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
        this.j = context;
        b();
    }
}
