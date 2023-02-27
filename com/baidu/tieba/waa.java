package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.a6a;
import com.baidu.tieba.xaa;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class waa implements xaa.a<x5a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ xaa a;

    public waa(xaa xaaVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {xaaVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = xaaVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.tieba.xaa.a
    public void a(x5a x5aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, x5aVar) == null) {
            LogPrinter.v("SerialSlotId:%s is totally same with oldOne", x5aVar.a);
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.tieba.xaa.a
    public void b(x5a x5aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, x5aVar) == null) {
            x5a x5aVar2 = x5aVar;
            LogPrinter.v("Update SerialSlotId:%s", x5aVar2.a);
            HashMap<String, c6a> hashMap = this.a.c;
            String str = x5aVar2.a;
            hashMap.put(str, new c6a(str, new j6a(this, x5aVar2)));
            a6a a6aVar = this.a.b;
            synchronized (a6aVar.a) {
                a6aVar.a(x5aVar2.a).add(new a6a.b(x5aVar2));
            }
        }
    }
}
