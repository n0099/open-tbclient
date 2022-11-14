package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.jq0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class xp0 extends bq0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final jq0 r;
    public final fq0 s;
    public final boolean t;
    public final String u;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xp0(tp0 common2, JSONObject root) {
        super(common2, root, true);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {common2, root};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((tp0) objArr2[0], (JSONObject) objArr2[1], ((Boolean) objArr2[2]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(common2, "common");
        Intrinsics.checkNotNullParameter(root, "root");
        jq0.a aVar = jq0.p;
        JSONObject optJSONObject = root.optJSONObject("reward");
        this.r = aVar.a(optJSONObject == null ? new JSONObject() : optJSONObject);
        this.s = fq0.f.a(root.optJSONObject("cmd_policy"));
        this.t = Intrinsics.areEqual(root.optString("type"), "detail");
        String optString = root.optString("panel_cmd");
        Intrinsics.checkNotNullExpressionValue(optString, "root.optString(\"panel_cmd\")");
        this.u = optString;
    }

    public final fq0 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.s;
        }
        return (fq0) invokeV.objValue;
    }

    public final String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.u;
        }
        return (String) invokeV.objValue;
    }

    public final jq0 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.r;
        }
        return (jq0) invokeV.objValue;
    }

    public final boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.t;
        }
        return invokeV.booleanValue;
    }
}
