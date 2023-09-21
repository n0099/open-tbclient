package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.chatmessage.messages.NetDiskFileMsg;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.model.AdOperator;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.tbadk.core.atomData.RecommendDetailActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class xr0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String A;
    public String B;
    public String C;
    public boolean D;
    public Boolean E;
    public String F;
    public final String a;
    public final String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public final String h;
    public final String i;
    public final String j;
    public final int k;
    public String l;
    public String m;
    public final String n;
    public final String o;
    public String p;
    public String q;
    public String r;
    public er0 s;
    public String t;
    public boolean u;
    public boolean v;
    public boolean w;
    public String x;
    public String y;
    public String z;

    public xr0(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.u = true;
        this.w = false;
        this.D = false;
        this.E = Boolean.FALSE;
        this.a = jSONObject.optString("style");
        this.b = jSONObject.optString("type");
        this.c = jSONObject.optString("user_name");
        this.d = jSONObject.optString(RecommendDetailActivityConfig.USER_PORTRAIT);
        this.e = jSONObject.optString("scheme");
        this.f = jSONObject.optString("panel_scheme");
        this.g = jSONObject.optString("button_scheme");
        this.h = jSONObject.optString(GameGuideConfigInfo.KEY_BUTTON_TEXT);
        this.i = jSONObject.optString("button_color");
        this.j = jSONObject.optString("button_icon");
        this.k = jSONObject.optInt("duration") * 1000;
        this.l = jSONObject.optString("trade");
        jSONObject.optString("score");
        this.m = jSONObject.optString("title");
        this.n = jSONObject.optString("sub_title");
        this.o = jSONObject.optString("popularity_text");
        this.p = jSONObject.optString(NetDiskFileMsg.NetDiskFile.JSON_KEY_COVER_URL);
        this.y = jSONObject.optString("bottom_button_text");
        this.x = jSONObject.optString("bottom_button_icon");
        this.z = jSONObject.optString("bottom_button_scheme");
        this.A = jSONObject.optString("bottom_btn_border_color");
        this.B = jSONObject.optString("bottom_btn_text_color");
        this.C = jSONObject.optString("swipe_up_lottie");
    }

    @Nullable
    public static xr0 a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            return new xr0(jSONObject);
        }
        return (xr0) invokeL.objValue;
    }

    public xr0 b(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            this.g = g61.a(this.g, str, "__BTN_SCHEME__");
            return this;
        }
        return (xr0) invokeL.objValue;
    }

    public xr0 c(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            this.p = str;
            return this;
        }
        return (xr0) invokeL.objValue;
    }

    public xr0 e(@NonNull er0 er0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, er0Var)) == null) {
            this.s = er0Var;
            return this;
        }
        return (xr0) invokeL.objValue;
    }

    public xr0 f(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            this.r = str;
            return this;
        }
        return (xr0) invokeL.objValue;
    }

    public xr0 g(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            this.e = g61.a(this.e, str, "__SCHEME__");
            return this;
        }
        return (xr0) invokeL.objValue;
    }

    public void d(@NonNull AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, adBaseModel) == null) {
            vr0 vr0Var = adBaseModel.j;
            if (vr0Var != null && !TextUtils.isEmpty(vr0Var.d)) {
                c(adBaseModel.j.d);
            }
            if (!TextUtils.isEmpty(adBaseModel.f.d)) {
                f(adBaseModel.f.d);
            }
            er0 er0Var = adBaseModel.l;
            if (er0Var != null) {
                e(er0Var);
            }
            if (!TextUtils.isEmpty(adBaseModel.f.c)) {
                g(adBaseModel.f.c);
            }
            AdOperator adOperator = adBaseModel.h;
            if (adOperator != null && !TextUtils.isEmpty(adOperator.d)) {
                b(adBaseModel.h.d);
            }
            if (adBaseModel.f != null) {
                if (TextUtils.isEmpty(this.m)) {
                    this.m = adBaseModel.f.g;
                }
                if (TextUtils.isEmpty(this.l)) {
                    this.l = adBaseModel.f.h;
                }
            }
        }
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (!TextUtils.isEmpty(this.f)) {
                return this.f;
            }
            return this.g;
        }
        return (String) invokeV.objValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            er0 er0Var = this.s;
            if (er0Var != null && er0Var.e) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (!i() && TextUtils.isEmpty(this.e)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }
}
