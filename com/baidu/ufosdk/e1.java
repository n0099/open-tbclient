package com.baidu.ufosdk;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.widget.ImageView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class e1 extends ImageView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Paint a;
    public int b;
    public int c;
    public Paint d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e1(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = 0;
        this.c = 0;
        a(context);
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            float f = context.getResources().getDisplayMetrics().density;
            this.b = (int) (this.b * f);
            this.c = (int) (this.c * f);
            Paint paint = new Paint();
            this.a = paint;
            paint.setColor(-1);
            this.a.setAntiAlias(true);
            this.a.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
            Paint paint2 = new Paint();
            this.d = paint2;
            paint2.setXfermode(null);
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) {
            Bitmap createBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.RGB_565);
            Canvas canvas2 = new Canvas(createBitmap);
            super.draw(canvas2);
            Path path = new Path();
            path.moveTo(0.0f, this.c);
            path.lineTo(0.0f, 0.0f);
            path.lineTo(this.b, 0.0f);
            path.arcTo(new RectF(0.0f, 0.0f, this.b * 2, this.c * 2), -90.0f, -90.0f);
            path.close();
            canvas2.drawPath(path, this.a);
            Path path2 = new Path();
            path2.moveTo(getWidth(), this.c);
            path2.lineTo(getWidth(), 0.0f);
            path2.lineTo(getWidth() - this.b, 0.0f);
            path2.arcTo(new RectF(getWidth() - (this.b * 2), 0.0f, getWidth(), (this.c * 2) + 0), -90.0f, 90.0f);
            path2.close();
            canvas2.drawPath(path2, this.a);
            Path path3 = new Path();
            path3.moveTo(0.0f, getHeight() - this.c);
            path3.lineTo(0.0f, getHeight());
            path3.lineTo(this.b, getHeight());
            path3.arcTo(new RectF(0.0f, getHeight() - (this.c * 2), (this.b * 2) + 0, getHeight()), 90.0f, 90.0f);
            path3.close();
            canvas2.drawPath(path3, this.a);
            Path path4 = new Path();
            path4.moveTo(getWidth() - this.b, getHeight());
            path4.lineTo(getWidth(), getHeight());
            path4.lineTo(getWidth(), getHeight() - this.c);
            path4.arcTo(new RectF(getWidth() - (this.b * 2), getHeight() - (this.c * 2), getWidth(), getHeight()), 0.0f, 90.0f);
            path4.close();
            canvas2.drawPath(path4, this.a);
            canvas.drawBitmap(createBitmap, 0.0f, 0.0f, this.d);
            createBitmap.recycle();
        }
    }
}
