package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.gha;
import com.baidu.tieba.jca;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class qca implements gha.a<ica> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ gha a;

    public qca(gha ghaVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ghaVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = ghaVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.tieba.gha.a
    public void a(ica icaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, icaVar) == null) {
            LogPrinter.v("SlotId:%s is totally same with oldOne", icaVar.a);
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.tieba.gha.a
    public void b(ica icaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, icaVar) == null) {
            ica icaVar2 = icaVar;
            LogPrinter.v("Update SlotId:%s", icaVar2.a);
            HashMap<String, lca> hashMap = this.a.c;
            String str = icaVar2.a;
            hashMap.put(str, new lca(str, new oca(this, icaVar2)));
            jca jcaVar = this.a.b;
            synchronized (jcaVar.a) {
                jcaVar.a(icaVar2.a).add(new jca.a(icaVar2));
            }
        }
    }
}
