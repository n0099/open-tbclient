package com.baidu.tieba;

import android.os.Bundle;
import com.baidu.tieba.oa7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class lk7 implements oa7.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Bundle a;

    public lk7(Bundle bundle) {
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

    @Override // com.baidu.tieba.oa7.b
    public void a(ab7<?> data, int i) {
        ka7 ka7Var;
        Map<String, String> emptyMap;
        Map<String, String> emptyMap2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, data, i) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            if (data instanceof ka7) {
                ka7Var = (ka7) data;
            } else {
                ka7Var = null;
            }
            if (ka7Var == null) {
                return;
            }
            w67 w67Var = ka7Var.a;
            if (w67Var == null || (emptyMap = w67Var.a()) == null) {
                emptyMap = MapsKt__MapsKt.emptyMap();
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("get_position", String.valueOf(i + 1));
            e57 e57Var = ka7Var.b;
            if (e57Var == null || (emptyMap2 = e57Var.a()) == null) {
                emptyMap2 = MapsKt__MapsKt.emptyMap();
            }
            jb7.a.d(new cb7("card_click_other", emptyMap, linkedHashMap, emptyMap2), new pk7(this.a));
        }
    }
}
