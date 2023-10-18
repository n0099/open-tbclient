package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.jn0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class pm0 extends tm0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final JSONObject A;
    public final JSONObject B;
    public final xm0 C;
    public final gn0 D;
    public final ln0 E;
    public final om0 F;
    public final JSONObject G;
    public final nm0 H;
    public final jn0 r;
    public final an0 s;
    public final ym0 t;
    public final boolean u;
    public final boolean v;
    public final boolean w;
    public final String x;
    public final String y;
    public final hn0 z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pm0(jm0 common2, JSONObject root) {
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
                super((jm0) objArr2[0], (JSONObject) objArr2[1], ((Boolean) objArr2[2]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(common2, "common");
        Intrinsics.checkNotNullParameter(root, "root");
        boolean z = true;
        jn0.a aVar = jn0.A;
        JSONObject optJSONObject = root.optJSONObject("reward");
        this.r = aVar.a(optJSONObject == null ? new JSONObject() : optJSONObject);
        this.s = an0.g.a(root.optJSONObject("image_info"));
        this.t = ym0.v.a(root.optJSONObject("cmd_policy"));
        this.u = Intrinsics.areEqual(root.optString("type"), "detail");
        this.v = Intrinsics.areEqual(root.optString("type"), "download");
        an0 an0Var = this.s;
        this.w = (an0Var == null || !an0Var.d()) ? false : false;
        String optString = root.optString("panel_cmd");
        Intrinsics.checkNotNullExpressionValue(optString, "root.optString(\"panel_cmd\")");
        this.x = optString;
        String optString2 = root.optString("webpanel_cmd");
        Intrinsics.checkNotNullExpressionValue(optString2, "root.optString(\"webpanel_cmd\")");
        this.y = optString2;
        Intrinsics.checkNotNullExpressionValue(root.optString("lp_real_url"), "root.optString(\"lp_real_url\")");
        this.z = hn0.i.a(root.optJSONObject("sliding_tag"));
        this.A = root.optJSONObject("sv_title");
        this.B = root.optJSONObject("sv_button");
        this.C = xm0.i.a(root.optJSONObject("big_card"));
        this.D = gn0.w.a(root.optJSONObject("rotation_component"));
        this.E = new ln0(false, false, 0, false, false, false, 63, null);
        this.F = om0.d.a(root.optJSONObject("ad_tag"));
        JSONObject optJSONObject2 = root.optJSONObject("popover");
        this.G = optJSONObject2;
        this.H = nm0.b.a(optJSONObject2);
        root.optJSONObject("convert");
    }

    public final xm0 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.C;
        }
        return (xm0) invokeV.objValue;
    }

    public final ym0 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.t;
        }
        return (ym0) invokeV.objValue;
    }

    public final gn0 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.D;
        }
        return (gn0) invokeV.objValue;
    }

    public final an0 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.s;
        }
        return (an0) invokeV.objValue;
    }

    public final String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.x;
        }
        return (String) invokeV.objValue;
    }

    public final jn0 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.r;
        }
        return (jn0) invokeV.objValue;
    }

    public final nm0 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.H;
        }
        return (nm0) invokeV.objValue;
    }

    public final ln0 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.E;
        }
        return (ln0) invokeV.objValue;
    }

    public final hn0 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.z;
        }
        return (hn0) invokeV.objValue;
    }

    public final JSONObject k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.B;
        }
        return (JSONObject) invokeV.objValue;
    }

    public final JSONObject l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.A;
        }
        return (JSONObject) invokeV.objValue;
    }

    public final om0 m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.F;
        }
        return (om0) invokeV.objValue;
    }

    public final String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.y;
        }
        return (String) invokeV.objValue;
    }

    public final boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.u;
        }
        return invokeV.booleanValue;
    }

    public final boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.v;
        }
        return invokeV.booleanValue;
    }

    public final boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.w;
        }
        return invokeV.booleanValue;
    }
}
