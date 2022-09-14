package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.np9;
import com.baidu.tieba.qk9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class mp9 implements np9.a<nk9> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ np9 a;

    public mp9(np9 np9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {np9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = np9Var;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.tieba.np9.a
    public void a(nk9 nk9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, nk9Var) == null) {
            LogPrinter.v("SerialSlotId:%s is totally same with oldOne", nk9Var.a);
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.tieba.np9.a
    public void b(nk9 nk9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nk9Var) == null) {
            nk9 nk9Var2 = nk9Var;
            LogPrinter.v("Update SerialSlotId:%s", nk9Var2.a);
            HashMap<String, sk9> hashMap = this.a.c;
            String str = nk9Var2.a;
            hashMap.put(str, new sk9(str, new zk9(this, nk9Var2)));
            qk9 qk9Var = this.a.b;
            synchronized (qk9Var.a) {
                qk9Var.a(nk9Var2.a).add(new qk9.b(nk9Var2));
            }
        }
    }
}
