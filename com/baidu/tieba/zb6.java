package com.baidu.tieba;

import android.graphics.Bitmap;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class zb6 extends xb6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public zb6(boolean z) {
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

    @Override // com.baidu.tieba.xb6
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            dc6 dc6Var = this.a;
            if (dc6Var.h == null) {
                this.b.onError(dc6Var.f, "cover config is null !!");
                return;
            }
            Bitmap createBitmap = Bitmap.createBitmap(dc6Var.a, dc6Var.b, Bitmap.Config.ARGB_8888);
            createBitmap.copyPixelsFromBuffer(this.a.h);
            g(new cc6(), createBitmap);
        }
    }
}
