package com.baidu.tieba;

import android.os.Bundle;
import com.baidu.tieba.gb7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes8.dex */
public final class rm7 implements gb7.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Bundle a;

    public rm7(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bundle};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        this.a = bundle;
    }

    @Override // com.baidu.tieba.gb7.b
    public void a(sb7<?> data, int i) {
        cb7 cb7Var;
        Map<String, String> emptyMap;
        Map<String, String> emptyMap2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, data, i) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            if (data instanceof cb7) {
                cb7Var = (cb7) data;
            } else {
                cb7Var = null;
            }
            if (cb7Var == null) {
                return;
            }
            n77 n77Var = cb7Var.a;
            if (n77Var == null || (emptyMap = n77Var.a()) == null) {
                emptyMap = MapsKt__MapsKt.emptyMap();
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("get_position", String.valueOf(i + 1));
            v57 v57Var = cb7Var.b;
            if (v57Var == null || (emptyMap2 = v57Var.a()) == null) {
                emptyMap2 = MapsKt__MapsKt.emptyMap();
            }
            bc7.a.d(new ub7("card_click_other", emptyMap, linkedHashMap, emptyMap2), new vm7(this.a));
        }
    }
}
