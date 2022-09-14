package com.baidu.tieba;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class jl extends ol {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Path v;
    public boolean w;
    public Rect x;
    public final Paint y;
    public final Paint z;

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
                return;
            }
        }
        this.y = new Paint();
        this.z = new Paint();
        this.y.setColor(-16777216);
        this.y.setStyle(Paint.Style.FILL);
        this.y.setAntiAlias(true);
        this.z.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    @Override // com.baidu.tieba.el
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
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rect) == null) || rect == null) {
            return;
        }
        boolean z = true;
        boolean z2 = this.v == null || this.w != this.l.b;
        Rect rect2 = this.x;
        if (rect2 != null && rect2.contains(rect)) {
            z = z2;
        }
        this.w = this.l.b;
        if (z) {
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
