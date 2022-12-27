package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.cr9;
import com.baidu.tieba.zv9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class yv9 implements zv9.a<zq9> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ zv9 a;

    public yv9(zv9 zv9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {zv9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = zv9Var;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.tieba.zv9.a
    public void a(zq9 zq9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, zq9Var) == null) {
            LogPrinter.v("SerialSlotId:%s is totally same with oldOne", zq9Var.a);
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.tieba.zv9.a
    public void b(zq9 zq9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zq9Var) == null) {
            zq9 zq9Var2 = zq9Var;
            LogPrinter.v("Update SerialSlotId:%s", zq9Var2.a);
            HashMap<String, er9> hashMap = this.a.c;
            String str = zq9Var2.a;
            hashMap.put(str, new er9(str, new lr9(this, zq9Var2)));
            cr9 cr9Var = this.a.b;
            synchronized (cr9Var.a) {
                cr9Var.a(zq9Var2.a).add(new cr9.b(zq9Var2));
            }
        }
    }
}
