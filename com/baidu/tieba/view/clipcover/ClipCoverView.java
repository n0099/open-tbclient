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
import c.a.o0.r.v.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ClipCoverView extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Paint a;

    /* renamed from: b  reason: collision with root package name */
    public Paint f37034b;

    /* renamed from: c  reason: collision with root package name */
    public Path f37035c;

    /* renamed from: d  reason: collision with root package name */
    public float f37036d;

    /* renamed from: e  reason: collision with root package name */
    public Xfermode f37037e;

    /* renamed from: f  reason: collision with root package name */
    public Context f37038f;

    /* renamed from: g  reason: collision with root package name */
    public int f37039g;

    /* renamed from: h  reason: collision with root package name */
    public int f37040h;

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

    public final void a(@NonNull Canvas canvas, Path path) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, canvas, path) == null) {
            canvas.drawPath(path, this.f37034b);
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Paint paint = new Paint();
            this.f37034b = paint;
            paint.setAntiAlias(true);
            this.f37034b.setStyle(Paint.Style.STROKE);
            this.f37034b.setStrokeWidth(this.f37036d);
            this.f37034b.setColor(getResources().getColor(R.color.CAM_X0402));
        }
    }

    public RectF getClipCoverRect() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            RectF rectF = new RectF();
            rectF.left = (getWidth() - this.f37039g) * 0.5f;
            rectF.right = (getWidth() + this.f37039g) * 0.5f;
            rectF.top = (getHeight() - this.f37040h) * 0.5f;
            rectF.bottom = (getHeight() + this.f37040h) * 0.5f;
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
            this.a.setXfermode(this.f37037e);
            RectF clipCoverRect = getClipCoverRect();
            if (this.f37035c == null) {
                this.f37035c = new Path();
            }
            this.f37035c.reset();
            this.f37035c.addRoundRect(clipCoverRect, a.y(R.string.J_X05), Path.Direction.CW);
            canvas.drawPath(this.f37035c, this.a);
            a(canvas, this.f37035c);
            canvas.restore();
        }
    }

    public void setClipBorderWidth(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048580, this, f2) == null) {
            this.f37036d = f2;
            this.f37034b.setStrokeWidth(f2);
            invalidate();
        }
    }

    public void setmHorizontal(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048581, this, f2) == null) {
            this.f37039g = (int) f2;
        }
    }

    public void setmVerticalPadding(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048582, this, f2) == null) {
            this.f37040h = (int) f2;
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
        this.f37037e = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
        this.f37038f = context;
        b();
    }
}
