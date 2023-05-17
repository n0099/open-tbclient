package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.csa;
import com.baidu.tieba.zwa;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class jsa implements zwa.a<bsa> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ zwa a;

    public jsa(zwa zwaVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {zwaVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = zwaVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.tieba.zwa.a
    public void a(bsa bsaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bsaVar) == null) {
            LogPrinter.v("SlotId:%s is totally same with oldOne", bsaVar.a);
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.tieba.zwa.a
    public void b(bsa bsaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bsaVar) == null) {
            bsa bsaVar2 = bsaVar;
            LogPrinter.v("Update SlotId:%s", bsaVar2.a);
            HashMap<String, esa> hashMap = this.a.c;
            String str = bsaVar2.a;
            hashMap.put(str, new esa(str, new hsa(this, bsaVar2)));
            csa csaVar = this.a.b;
            synchronized (csaVar.a) {
                csaVar.a(bsaVar2.a).add(new csa.a(bsaVar2));
            }
        }
    }
}
