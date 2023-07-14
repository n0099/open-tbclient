package com.baidu.tieba;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.widget.ImageView;
import com.baidu.mapapi.map.MapViewLayoutParams;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.tieba.so3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class ug4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a implements so3.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ny2 a;
        public final /* synthetic */ fh4 b;
        public final /* synthetic */ bh4 c;

        public a(ny2 ny2Var, fh4 fh4Var, bh4 bh4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ny2Var, fh4Var, bh4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ny2Var;
            this.b = fh4Var;
            this.c = bh4Var;
        }

        @Override // com.baidu.tieba.so3.b
        public void a(String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, bitmap) == null) {
                if (bitmap == null) {
                    v82.o("map", " icon is null ");
                }
                if (bitmap != null) {
                    int i = this.a.d.c;
                    if (i == -1) {
                        i = bitmap.getWidth();
                    }
                    int i2 = this.a.d.d;
                    if (i2 == -1) {
                        i2 = bitmap.getHeight();
                    }
                    MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
                    builder.layoutMode(MapViewLayoutParams.ELayoutMode.absoluteMode);
                    builder.width(i);
                    builder.height(i2);
                    builder.align(1, 8);
                    sy2 sy2Var = this.a.d;
                    builder.point(new Point(sy2Var.a, sy2Var.b));
                    ImageView imageView = new ImageView(AppRuntime.getAppContext());
                    imageView.setImageBitmap(bitmap);
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    this.b.l.addView(imageView, builder.build());
                    imageView.setOnClickListener(this.c);
                    imageView.setClickable(this.a.c);
                    dh4 dh4Var = new dh4();
                    dh4Var.a = this.a;
                    dh4Var.b = imageView;
                    this.b.o.add(dh4Var);
                }
            }
        }
    }

    public static void a(fh4 fh4Var, ny2 ny2Var, bh4 bh4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, fh4Var, ny2Var, bh4Var) == null) {
            v82.i("map", "createControl start");
            if (ny2Var != null && ny2Var.isValid()) {
                so3.e(ny2Var.b, new a(ny2Var, fh4Var, bh4Var));
            }
            v82.i("map", "createControl end");
        }
    }
}
