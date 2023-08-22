package com.baidu.tieba;

import android.graphics.Bitmap;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class m27 extends k27 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public m27(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = z;
    }

    @Override // com.baidu.tieba.k27
    public void f() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            q27 q27Var = this.a;
            if (q27Var.h == null) {
                this.b.onError(q27Var.f, "cover config is null !!");
                return;
            }
            int i2 = q27Var.a;
            if (i2 > 0 && (i = q27Var.b) > 0) {
                Bitmap createBitmap = Bitmap.createBitmap(i2, i, Bitmap.Config.ARGB_8888);
                createBitmap.copyPixelsFromBuffer(this.a.h);
                g(new p27(), createBitmap);
                return;
            }
            o27 o27Var = this.b;
            String str = this.a.f;
            o27Var.onError(str, "cover config size illegal width=" + this.a.a + " height=" + this.a.b);
        }
    }
}
