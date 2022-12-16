package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.br9;
import com.baidu.tieba.yv9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class ir9 implements yv9.a<ar9> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ yv9 a;

    public ir9(yv9 yv9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {yv9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = yv9Var;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.tieba.yv9.a
    public void a(ar9 ar9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ar9Var) == null) {
            LogPrinter.v("SlotId:%s is totally same with oldOne", ar9Var.a);
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.tieba.yv9.a
    public void b(ar9 ar9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ar9Var) == null) {
            ar9 ar9Var2 = ar9Var;
            LogPrinter.v("Update SlotId:%s", ar9Var2.a);
            HashMap<String, dr9> hashMap = this.a.c;
            String str = ar9Var2.a;
            hashMap.put(str, new dr9(str, new gr9(this, ar9Var2)));
            br9 br9Var = this.a.b;
            synchronized (br9Var.a) {
                br9Var.a(ar9Var2.a).add(new br9.a(ar9Var2));
            }
        }
    }
}
