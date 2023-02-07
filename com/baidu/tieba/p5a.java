package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.q5a;
import com.baidu.tieba.t0a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class p5a implements q5a.a<q0a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ q5a a;

    public p5a(q5a q5aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {q5aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = q5aVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.tieba.q5a.a
    public void a(q0a q0aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, q0aVar) == null) {
            LogPrinter.v("SerialSlotId:%s is totally same with oldOne", q0aVar.a);
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.tieba.q5a.a
    public void b(q0a q0aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, q0aVar) == null) {
            q0a q0aVar2 = q0aVar;
            LogPrinter.v("Update SerialSlotId:%s", q0aVar2.a);
            HashMap<String, v0a> hashMap = this.a.c;
            String str = q0aVar2.a;
            hashMap.put(str, new v0a(str, new c1a(this, q0aVar2)));
            t0a t0aVar = this.a.b;
            synchronized (t0aVar.a) {
                t0aVar.a(q0aVar2.a).add(new t0a.b(q0aVar2));
            }
        }
    }
}
