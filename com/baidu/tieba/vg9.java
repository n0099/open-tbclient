package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ll9;
import com.baidu.tieba.og9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class vg9 implements ll9.a<ng9> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ ll9 a;

    public vg9(ll9 ll9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ll9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = ll9Var;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.tieba.ll9.a
    public void a(ng9 ng9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ng9Var) == null) {
            LogPrinter.v("SlotId:%s is totally same with oldOne", ng9Var.a);
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.tieba.ll9.a
    public void b(ng9 ng9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ng9Var) == null) {
            ng9 ng9Var2 = ng9Var;
            LogPrinter.v("Update SlotId:%s", ng9Var2.a);
            HashMap<String, qg9> hashMap = this.a.c;
            String str = ng9Var2.a;
            hashMap.put(str, new qg9(str, new tg9(this, ng9Var2)));
            og9 og9Var = this.a.b;
            synchronized (og9Var.a) {
                og9Var.a(ng9Var2.a).add(new og9.a(ng9Var2));
            }
        }
    }
}
