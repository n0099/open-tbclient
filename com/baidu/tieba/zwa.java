package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.axa;
import com.baidu.tieba.dsa;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class zwa implements axa.a<asa> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ axa a;

    public zwa(axa axaVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {axaVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = axaVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.tieba.axa.a
    public void a(asa asaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, asaVar) == null) {
            LogPrinter.v("SerialSlotId:%s is totally same with oldOne", asaVar.a);
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.tieba.axa.a
    public void b(asa asaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, asaVar) == null) {
            asa asaVar2 = asaVar;
            LogPrinter.v("Update SerialSlotId:%s", asaVar2.a);
            HashMap<String, fsa> hashMap = this.a.c;
            String str = asaVar2.a;
            hashMap.put(str, new fsa(str, new msa(this, asaVar2)));
            dsa dsaVar = this.a.b;
            synchronized (dsaVar.a) {
                dsaVar.a(asaVar2.a).add(new dsa.b(asaVar2));
            }
        }
    }
}
