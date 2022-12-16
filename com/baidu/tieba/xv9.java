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
/* loaded from: classes6.dex */
public class xv9 implements yv9.a<yq9> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ yv9 a;

    public xv9(yv9 yv9Var) {
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
    public void a(yq9 yq9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, yq9Var) == null) {
            LogPrinter.v("SerialSlotId:%s is totally same with oldOne", yq9Var.a);
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.tieba.yv9.a
    public void b(yq9 yq9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yq9Var) == null) {
            yq9 yq9Var2 = yq9Var;
            LogPrinter.v("Update SerialSlotId:%s", yq9Var2.a);
            HashMap<String, dr9> hashMap = this.a.c;
            String str = yq9Var2.a;
            hashMap.put(str, new dr9(str, new kr9(this, yq9Var2)));
            br9 br9Var = this.a.b;
            synchronized (br9Var.a) {
                br9Var.a(yq9Var2.a).add(new br9.b(yq9Var2));
            }
        }
    }
}
