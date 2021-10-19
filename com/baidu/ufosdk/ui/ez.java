package com.baidu.ufosdk.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.widget.ImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public final class ez extends ImageView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Paint f60087a;

    /* renamed from: b  reason: collision with root package name */
    public int f60088b;

    /* renamed from: c  reason: collision with root package name */
    public int f60089c;

    /* renamed from: d  reason: collision with root package name */
    public Paint f60090d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ez(Context context) {
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
        this.f60088b = 5;
        this.f60089c = 5;
        float f2 = context.getResources().getDisplayMetrics().density;
        this.f60088b = (int) (this.f60088b * f2);
        this.f60089c = (int) (this.f60089c * f2);
        Paint paint = new Paint();
        this.f60087a = paint;
        paint.setColor(-1);
        this.f60087a.setAntiAlias(true);
        this.f60087a.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        Paint paint2 = new Paint();
        this.f60090d = paint2;
        paint2.setXfermode(null);
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            Bitmap createBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.RGB_565);
            Canvas canvas2 = new Canvas(createBitmap);
            super.draw(canvas2);
            Path path = new Path();
            path.moveTo(0.0f, this.f60089c);
            path.lineTo(0.0f, 0.0f);
            path.lineTo(this.f60088b, 0.0f);
            path.arcTo(new RectF(0.0f, 0.0f, this.f60088b * 2, this.f60089c * 2), -90.0f, -90.0f);
            path.close();
            canvas2.drawPath(path, this.f60087a);
            Path path2 = new Path();
            path2.moveTo(getWidth(), this.f60089c);
            path2.lineTo(getWidth(), 0.0f);
            path2.lineTo(getWidth() - this.f60088b, 0.0f);
            path2.arcTo(new RectF(getWidth() - (this.f60088b * 2), 0.0f, getWidth(), (this.f60089c * 2) + 0), -90.0f, 90.0f);
            path2.close();
            canvas2.drawPath(path2, this.f60087a);
            Path path3 = new Path();
            path3.moveTo(0.0f, getHeight() - this.f60089c);
            path3.lineTo(0.0f, getHeight());
            path3.lineTo(this.f60088b, getHeight());
            path3.arcTo(new RectF(0.0f, getHeight() - (this.f60089c * 2), (this.f60088b * 2) + 0, getHeight()), 90.0f, 90.0f);
            path3.close();
            canvas2.drawPath(path3, this.f60087a);
            Path path4 = new Path();
            path4.moveTo(getWidth() - this.f60088b, getHeight());
            path4.lineTo(getWidth(), getHeight());
            path4.lineTo(getWidth(), getHeight() - this.f60089c);
            path4.arcTo(new RectF(getWidth() - (this.f60088b * 2), getHeight() - (this.f60089c * 2), getWidth(), getHeight()), 0.0f, 90.0f);
            path4.close();
            canvas2.drawPath(path4, this.f60087a);
            canvas.drawBitmap(createBitmap, 0.0f, 0.0f, this.f60090d);
            createBitmap.recycle();
        }
    }
}
