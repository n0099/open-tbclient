package com.baidu.tieba;

import android.graphics.Bitmap;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class p37 extends n37 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public p37(boolean z) {
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

    @Override // com.baidu.tieba.n37
    public void f() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            t37 t37Var = this.a;
            if (t37Var.h == null) {
                this.b.onError(t37Var.f, "cover config is null !!");
                return;
            }
            int i2 = t37Var.a;
            if (i2 > 0 && (i = t37Var.b) > 0) {
                Bitmap createBitmap = Bitmap.createBitmap(i2, i, Bitmap.Config.ARGB_8888);
                createBitmap.copyPixelsFromBuffer(this.a.h);
                g(new s37(), createBitmap);
                return;
            }
            r37 r37Var = this.b;
            String str = this.a.f;
            r37Var.onError(str, "cover config size illegal width=" + this.a.a + " height=" + this.a.b);
        }
    }
}
