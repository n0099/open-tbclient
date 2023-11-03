package com.baidu.tieba;

import android.os.Bundle;
import com.baidu.tieba.na7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class kk7 implements na7.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Bundle a;

    public kk7(Bundle bundle) {
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

    @Override // com.baidu.tieba.na7.b
    public void a(za7<?> data, int i) {
        ja7 ja7Var;
        Map<String, String> emptyMap;
        Map<String, String> emptyMap2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, data, i) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            if (data instanceof ja7) {
                ja7Var = (ja7) data;
            } else {
                ja7Var = null;
            }
            if (ja7Var == null) {
                return;
            }
            v67 v67Var = ja7Var.a;
            if (v67Var == null || (emptyMap = v67Var.a()) == null) {
                emptyMap = MapsKt__MapsKt.emptyMap();
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("get_position", String.valueOf(i + 1));
            d57 d57Var = ja7Var.b;
            if (d57Var == null || (emptyMap2 = d57Var.a()) == null) {
                emptyMap2 = MapsKt__MapsKt.emptyMap();
            }
            ib7.a.d(new bb7("card_click_other", emptyMap, linkedHashMap, emptyMap2), new ok7(this.a));
        }
    }
}
