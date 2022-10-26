package com.baidu.tieba;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.tieba.gq2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class k84 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public final class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w84 a;
        public final /* synthetic */ gq2 b;

        public a(w84 w84Var, gq2 gq2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w84Var, gq2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = w84Var;
            this.b = gq2Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                r84.a(this.a, this.b);
            }
        }
    }

    public static View a(w84 w84Var, gq2 gq2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, w84Var, gq2Var)) == null) {
            m02.i("map", "creatCallout start");
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.FILL_AND_STROKE);
            paint.setColor(gq2Var.i.b);
            paint.setTextSize(gq2Var.i.c);
            gq2.b bVar = gq2Var.i;
            float f = bVar.e;
            float f2 = bVar.f;
            Paint paint2 = new Paint();
            paint2.setAntiAlias(true);
            paint2.setStyle(Paint.Style.FILL_AND_STROKE);
            paint2.setColor(gq2Var.i.h);
            String str = gq2Var.i.a;
            int g = dh3.g(6.0f);
            float f3 = f * 2.0f;
            float measureText = paint.measureText(str) + f3;
            float f4 = paint.getFontMetrics().bottom - paint.getFontMetrics().top;
            float f5 = g + f4 + f3;
            if (f5 > 0.0f && measureText > 0.0f) {
                Bitmap createBitmap = Bitmap.createBitmap((int) measureText, (int) f5, Bitmap.Config.ARGB_8888);
                createBitmap.eraseColor(Color.argb(0, 0, 0, 0));
                Canvas canvas = new Canvas(createBitmap);
                canvas.drawColor(0, PorterDuff.Mode.CLEAR);
                RectF rectF = new RectF();
                rectF.left = 0.0f;
                rectF.top = 0.0f;
                float f6 = f4 + f3;
                rectF.bottom = f6;
                rectF.right = measureText;
                canvas.drawRoundRect(rectF, f2, f2, paint2);
                Path path = new Path();
                float f7 = measureText / 2.0f;
                float f8 = g / 2;
                path.moveTo(f7 - f8, f6);
                path.lineTo(f7, f5);
                path.lineTo(f7 + f8, f6);
                path.close();
                canvas.drawPath(path, paint2);
                canvas.drawText(str, f, (-paint.getFontMetrics().top) + f, paint);
                ImageView imageView = new ImageView(AppRuntime.getAppContext());
                imageView.setLayoutParams(new ViewGroup.LayoutParams(createBitmap.getWidth(), createBitmap.getHeight()));
                imageView.setImageBitmap(createBitmap);
                imageView.setOnClickListener(new a(w84Var, gq2Var));
                m02.i("map", "creatCallout end");
                return imageView;
            }
            m02.o("map", "callout height or wodth is 0");
            return new ImageView(AppRuntime.getAppContext());
        }
        return (View) invokeLL.objValue;
    }
}
