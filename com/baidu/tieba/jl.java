package com.baidu.tieba;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class jl extends il {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Path v;
    public boolean w;
    public Rect x;

    public jl() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.yk
    public void e(Canvas canvas, Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, canvas, drawable) == null) {
            canvas.save();
            t(drawable.getBounds());
            try {
                canvas.clipPath(this.v);
            } catch (Exception unused) {
            }
            drawable.draw(canvas);
            canvas.restore();
        }
    }

    public final void t(Rect rect) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rect) != null) || rect == null) {
            return;
        }
        boolean z2 = true;
        if (this.v != null && this.w == this.l.b) {
            z = false;
        } else {
            z = true;
        }
        Rect rect2 = this.x;
        if (rect2 != null && rect2.contains(rect)) {
            z2 = z;
        }
        this.w = this.l.b;
        if (z2) {
            this.x = rect;
            Path path = new Path();
            this.v = path;
            if (this.w) {
                this.v.addCircle((rect.right + rect.left) / 2.0f, (rect.top + rect.bottom) / 2.0f, Math.min(rect.width(), rect.height()) / 2.0f, Path.Direction.CCW);
            } else {
                path.addRoundRect(new RectF(rect), this.l.a, Path.Direction.CW);
            }
            this.v.close();
        }
    }
}
