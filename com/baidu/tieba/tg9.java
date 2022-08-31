package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.jl9;
import com.baidu.tieba.mg9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class tg9 implements jl9.a<lg9> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ jl9 a;

    public tg9(jl9 jl9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jl9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = jl9Var;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.tieba.jl9.a
    public void a(lg9 lg9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, lg9Var) == null) {
            LogPrinter.v("SlotId:%s is totally same with oldOne", lg9Var.a);
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.tieba.jl9.a
    public void b(lg9 lg9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lg9Var) == null) {
            lg9 lg9Var2 = lg9Var;
            LogPrinter.v("Update SlotId:%s", lg9Var2.a);
            HashMap<String, og9> hashMap = this.a.c;
            String str = lg9Var2.a;
            hashMap.put(str, new og9(str, new rg9(this, lg9Var2)));
            mg9 mg9Var = this.a.b;
            synchronized (mg9Var.a) {
                mg9Var.a(lg9Var2.a).add(new mg9.a(lg9Var2));
            }
        }
    }
}
