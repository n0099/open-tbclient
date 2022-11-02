package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ds9;
import com.baidu.tieba.gn9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class nn9 implements ds9.a<fn9> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ ds9 a;

    public nn9(ds9 ds9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ds9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = ds9Var;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.tieba.ds9.a
    public void a(fn9 fn9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, fn9Var) == null) {
            LogPrinter.v("SlotId:%s is totally same with oldOne", fn9Var.a);
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.tieba.ds9.a
    public void b(fn9 fn9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fn9Var) == null) {
            fn9 fn9Var2 = fn9Var;
            LogPrinter.v("Update SlotId:%s", fn9Var2.a);
            HashMap<String, in9> hashMap = this.a.c;
            String str = fn9Var2.a;
            hashMap.put(str, new in9(str, new ln9(this, fn9Var2)));
            gn9 gn9Var = this.a.b;
            synchronized (gn9Var.a) {
                gn9Var.a(fn9Var2.a).add(new gn9.a(fn9Var2));
            }
        }
    }
}
