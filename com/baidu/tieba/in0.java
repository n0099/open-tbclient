package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.do0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class in0 extends mn0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final bo0 A;
    public final JSONObject B;
    public final JSONObject C;
    public final rn0 D;
    public final ao0 E;
    public final fo0 F;
    public final hn0 G;
    public final JSONObject H;
    public final gn0 I;
    public final do0 r;
    public final un0 s;
    public final sn0 t;
    public final boolean u;
    public final boolean v;
    public final boolean w;
    public final String x;
    public final String y;
    public final String z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public in0(cn0 common2, JSONObject root) {
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
                super((cn0) objArr2[0], (JSONObject) objArr2[1], ((Boolean) objArr2[2]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(common2, "common");
        Intrinsics.checkNotNullParameter(root, "root");
        boolean z = true;
        do0.a aVar = do0.A;
        JSONObject optJSONObject = root.optJSONObject("reward");
        this.r = aVar.a(optJSONObject == null ? new JSONObject() : optJSONObject);
        this.s = un0.g.a(root.optJSONObject("image_info"));
        this.t = sn0.v.a(root.optJSONObject("cmd_policy"));
        this.u = Intrinsics.areEqual(root.optString("type"), "detail");
        this.v = Intrinsics.areEqual(root.optString("type"), "download");
        un0 un0Var = this.s;
        this.w = (un0Var == null || !un0Var.f()) ? false : false;
        String optString = root.optString("panel_cmd");
        Intrinsics.checkNotNullExpressionValue(optString, "root.optString(\"panel_cmd\")");
        this.x = optString;
        String optString2 = root.optString("webpanel_cmd");
        Intrinsics.checkNotNullExpressionValue(optString2, "root.optString(\"webpanel_cmd\")");
        this.y = optString2;
        String optString3 = root.optString("lp_real_url");
        Intrinsics.checkNotNullExpressionValue(optString3, "root.optString(\"lp_real_url\")");
        this.z = optString3;
        this.A = bo0.i.a(root.optJSONObject("sliding_tag"));
        this.B = root.optJSONObject("sv_title");
        this.C = root.optJSONObject("sv_button");
        this.D = rn0.k.a(root.optJSONObject("big_card"));
        this.E = ao0.x.a(root.optJSONObject("rotation_component"));
        this.F = new fo0(false, false, 0, false, false, false, 63, null);
        this.G = hn0.d.a(root.optJSONObject("ad_tag"));
        JSONObject optJSONObject2 = root.optJSONObject("popover");
        this.H = optJSONObject2;
        this.I = gn0.b.a(optJSONObject2);
        root.optJSONObject("convert");
    }

    public final rn0 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.D;
        }
        return (rn0) invokeV.objValue;
    }

    public final sn0 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.t;
        }
        return (sn0) invokeV.objValue;
    }

    public final ao0 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.E;
        }
        return (ao0) invokeV.objValue;
    }

    public final un0 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.s;
        }
        return (un0) invokeV.objValue;
    }

    public final String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.z;
        }
        return (String) invokeV.objValue;
    }

    public final String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.x;
        }
        return (String) invokeV.objValue;
    }

    public final do0 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.r;
        }
        return (do0) invokeV.objValue;
    }

    public final gn0 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.I;
        }
        return (gn0) invokeV.objValue;
    }

    public final fo0 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.F;
        }
        return (fo0) invokeV.objValue;
    }

    public final bo0 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.A;
        }
        return (bo0) invokeV.objValue;
    }

    public final JSONObject l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.C;
        }
        return (JSONObject) invokeV.objValue;
    }

    public final JSONObject m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.B;
        }
        return (JSONObject) invokeV.objValue;
    }

    public final hn0 n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.G;
        }
        return (hn0) invokeV.objValue;
    }

    public final String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.y;
        }
        return (String) invokeV.objValue;
    }

    public final boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.u;
        }
        return invokeV.booleanValue;
    }

    public final boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.v;
        }
        return invokeV.booleanValue;
    }

    public final boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.w;
        }
        return invokeV.booleanValue;
    }
}
