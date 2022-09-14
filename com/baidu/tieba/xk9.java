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
/* loaded from: classes6.dex */
public class xk9 implements np9.a<pk9> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ np9 a;

    public xk9(np9 np9Var) {
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
    public void a(pk9 pk9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, pk9Var) == null) {
            LogPrinter.v("SlotId:%s is totally same with oldOne", pk9Var.a);
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.tieba.np9.a
    public void b(pk9 pk9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pk9Var) == null) {
            pk9 pk9Var2 = pk9Var;
            LogPrinter.v("Update SlotId:%s", pk9Var2.a);
            HashMap<String, sk9> hashMap = this.a.c;
            String str = pk9Var2.a;
            hashMap.put(str, new sk9(str, new vk9(this, pk9Var2)));
            qk9 qk9Var = this.a.b;
            synchronized (qk9Var.a) {
                qk9Var.a(pk9Var2.a).add(new qk9.a(pk9Var2));
            }
        }
    }
}
