package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.os9;
import com.baidu.tieba.rn9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class yn9 implements os9.a<qn9> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ os9 a;

    public yn9(os9 os9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {os9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = os9Var;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.tieba.os9.a
    public void a(qn9 qn9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, qn9Var) == null) {
            LogPrinter.v("SlotId:%s is totally same with oldOne", qn9Var.a);
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.tieba.os9.a
    public void b(qn9 qn9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, qn9Var) == null) {
            qn9 qn9Var2 = qn9Var;
            LogPrinter.v("Update SlotId:%s", qn9Var2.a);
            HashMap<String, tn9> hashMap = this.a.c;
            String str = qn9Var2.a;
            hashMap.put(str, new tn9(str, new wn9(this, qn9Var2)));
            rn9 rn9Var = this.a.b;
            synchronized (rn9Var.a) {
                rn9Var.a(qn9Var2.a).add(new rn9.a(qn9Var2));
            }
        }
    }
}
