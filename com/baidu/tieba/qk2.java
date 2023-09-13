package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes7.dex */
public class qk2 extends ok2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qk2(@NonNull nk2 nk2Var) {
        super(nk2Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {nk2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((nk2) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.ok2
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            d();
            lr4.M(pi3.w());
            a73.a();
            lr4.L(mf2.a().b());
            lr4.M(zb3.e());
            Map<String, PMSAppInfo> v = ej4.i().v();
            rj2 d = tj2.c().d();
            ArrayList arrayList = new ArrayList(v.keySet());
            cl2 l = cl2.l();
            l.i(15);
            d.g(arrayList, true, false, l.k());
        }
    }
}
