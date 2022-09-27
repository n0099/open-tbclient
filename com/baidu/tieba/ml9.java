package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.cq9;
import com.baidu.tieba.fl9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class ml9 implements cq9.a<el9> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ cq9 a;

    public ml9(cq9 cq9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cq9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = cq9Var;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.tieba.cq9.a
    public void a(el9 el9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, el9Var) == null) {
            LogPrinter.v("SlotId:%s is totally same with oldOne", el9Var.a);
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.tieba.cq9.a
    public void b(el9 el9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, el9Var) == null) {
            el9 el9Var2 = el9Var;
            LogPrinter.v("Update SlotId:%s", el9Var2.a);
            HashMap<String, hl9> hashMap = this.a.c;
            String str = el9Var2.a;
            hashMap.put(str, new hl9(str, new kl9(this, el9Var2)));
            fl9 fl9Var = this.a.b;
            synchronized (fl9Var.a) {
                fl9Var.a(el9Var2.a).add(new fl9.a(el9Var2));
            }
        }
    }
}
