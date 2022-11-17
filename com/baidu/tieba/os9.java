package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ps9;
import com.baidu.tieba.sn9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class os9 implements ps9.a<pn9> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ ps9 a;

    public os9(ps9 ps9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ps9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = ps9Var;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.tieba.ps9.a
    public void a(pn9 pn9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, pn9Var) == null) {
            LogPrinter.v("SerialSlotId:%s is totally same with oldOne", pn9Var.a);
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.tieba.ps9.a
    public void b(pn9 pn9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pn9Var) == null) {
            pn9 pn9Var2 = pn9Var;
            LogPrinter.v("Update SerialSlotId:%s", pn9Var2.a);
            HashMap<String, un9> hashMap = this.a.c;
            String str = pn9Var2.a;
            hashMap.put(str, new un9(str, new bo9(this, pn9Var2)));
            sn9 sn9Var = this.a.b;
            synchronized (sn9Var.a) {
                sn9Var.a(pn9Var2.a).add(new sn9.b(pn9Var2));
            }
        }
    }
}
