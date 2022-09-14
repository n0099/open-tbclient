package com.baidu.tieba;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Shader;
import android.widget.ImageView;
import com.baidu.adp.newwidget.ImageView.DrawerArgs;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ol extends el {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Matrix s;
    public BitmapShader t;
    public RectF u;

    public ol() {
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
        this.s = new Matrix();
        this.u = new RectF();
    }

    @Override // com.baidu.tieba.el
    public void a(hl hlVar, ImageView imageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, hlVar, imageView) == null) {
            int b = hlVar.b();
            int a = hlVar.a();
            RectF rectF = this.g;
            PointF b2 = b(rectF.left, rectF.top, this.f);
            int i = (int) b2.x;
            int i2 = (int) b2.y;
            RectF rectF2 = this.g;
            PointF b3 = b(rectF2.right, rectF2.bottom, this.f);
            int i3 = (int) b3.x;
            int i4 = (int) b3.y;
            this.s.reset();
            this.s.postScale((i3 - i) / b, (i4 - i2) / a);
            this.s.postTranslate(i, i2);
            if (hlVar.e()) {
                Bitmap bitmap = hlVar.a.getBitmap();
                Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                this.t = new BitmapShader(bitmap, tileMode, tileMode);
            } else {
                this.t = hlVar.b.d();
            }
            BitmapShader bitmapShader = this.t;
            if (bitmapShader == null) {
                return;
            }
            bitmapShader.setLocalMatrix(this.s);
            this.c.setShader(this.t);
            int width = (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
            int height = (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
            this.u.set(Math.max(i, 0), Math.max(i2, 0), Math.min(i3, width), Math.min(i4, height));
            DrawerArgs drawerArgs = this.l;
            if (drawerArgs.c) {
                float f = drawerArgs.d / 2.0f;
                if (!drawerArgs.g) {
                    this.h.set(f, f, imageView.getWidth() - f, imageView.getHeight() - f);
                    return;
                }
                RectF rectF3 = this.h;
                RectF rectF4 = this.u;
                rectF3.set(rectF4.left + f, rectF4.top + f, rectF4.right - f, rectF4.bottom - f);
            }
        }
    }

    @Override // com.baidu.tieba.el
    public void f(Canvas canvas, ImageView imageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas, imageView) == null) {
            DrawerArgs drawerArgs = this.l;
            if (drawerArgs.c) {
                if (!drawerArgs.b) {
                    canvas.drawPath(l(this.h, drawerArgs.a), this.d);
                    return;
                }
                RectF rectF = this.u;
                float f = (rectF.right + rectF.left) / 2.0f;
                float f2 = (rectF.top + rectF.bottom) / 2.0f;
                float min = Math.min(rectF.width(), this.u.height()) / 2.0f;
                if (min <= 0.0f) {
                    f = (imageView.getRight() + imageView.getLeft()) / 2.0f;
                    f2 = (imageView.getTop() + imageView.getBottom()) / 2.0f;
                    min = Math.min(imageView.getWidth(), imageView.getHeight()) / 2.0f;
                }
                canvas.drawCircle(f, f2, min - (this.l.d / 2.0f), this.d);
            }
        }
    }

    @Override // com.baidu.tieba.el
    public void h(Canvas canvas, hl hlVar, ImageView imageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, canvas, hlVar, imageView) == null) {
            boolean d = hlVar.d();
            if (d && hlVar.d()) {
                hlVar.b.b(true);
            }
            DrawerArgs drawerArgs = this.l;
            if (!drawerArgs.b) {
                canvas.drawPath(l(this.u, drawerArgs.a), this.c);
            } else {
                RectF rectF = this.u;
                canvas.drawCircle((rectF.right + rectF.left) / 2.0f, (rectF.top + rectF.bottom) / 2.0f, Math.min(rectF.width(), this.u.height()) / 2.0f, this.c);
            }
            if (d && hlVar.d()) {
                hlVar.b.b(false);
            }
        }
    }

    @Override // com.baidu.tieba.el
    public void i(Canvas canvas, ImageView imageView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, canvas, imageView) == null) || this.l.m == 0) {
            return;
        }
        int scrollX = imageView.getScrollX();
        int scrollY = imageView.getScrollY();
        canvas.translate(scrollX, scrollY);
        this.e.setColor(this.l.m);
        if (!this.l.b) {
            this.o.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
            canvas.drawPath(l(this.o, this.l.a), this.e);
        } else {
            float width = imageView.getWidth() / 2.0f;
            float height = imageView.getHeight() / 2.0f;
            canvas.drawCircle(width, height, Math.min(width, height) - (this.l.d / 2.0f), this.e);
        }
        canvas.translate(-scrollX, -scrollY);
    }
}
