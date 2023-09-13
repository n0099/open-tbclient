package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class kf5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Inject(force = false)
    public pk1<lf5> a;

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            nk1 b = nk1.b();
            this.a = b;
            b.a(new mf5());
        }
    }

    public kf5() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a();
    }

    public void b(@NonNull JSONObject jSONObject) {
        pk1<lf5> pk1Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) != null) || (pk1Var = this.a) == null || ListUtils.isEmpty(pk1Var.getList())) {
            return;
        }
        for (lf5 lf5Var : this.a.getList()) {
            if (lf5Var != null) {
                lf5Var.parseJson(jSONObject);
            }
        }
    }
}
