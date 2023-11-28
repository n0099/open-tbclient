package com.baidu.tieba;

import android.os.Bundle;
import com.baidu.tieba.bb7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class mm7 implements bb7.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Bundle a;

    public mm7(Bundle bundle) {
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

    @Override // com.baidu.tieba.bb7.b
    public void a(nb7<?> data, int i) {
        xa7 xa7Var;
        Map<String, String> emptyMap;
        Map<String, String> emptyMap2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, data, i) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            if (data instanceof xa7) {
                xa7Var = (xa7) data;
            } else {
                xa7Var = null;
            }
            if (xa7Var == null) {
                return;
            }
            j77 j77Var = xa7Var.a;
            if (j77Var == null || (emptyMap = j77Var.a()) == null) {
                emptyMap = MapsKt__MapsKt.emptyMap();
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("get_position", String.valueOf(i + 1));
            r57 r57Var = xa7Var.b;
            if (r57Var == null || (emptyMap2 = r57Var.a()) == null) {
                emptyMap2 = MapsKt__MapsKt.emptyMap();
            }
            wb7.a.d(new pb7("card_click_other", emptyMap, linkedHashMap, emptyMap2), new qm7(this.a));
        }
    }
}
