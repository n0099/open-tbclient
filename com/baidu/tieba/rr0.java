package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
/* loaded from: classes7.dex */
public class rr0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String A;
    public String B;
    public boolean C;
    public Boolean D;
    public String E;
    public final String a;
    public final String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public final String g;
    public final String h;
    public final String i;
    public final int j;
    public String k;
    public String l;
    public final String m;
    public final String n;
    public String o;
    public String p;
    public String q;
    public yq0 r;
    public String s;
    public boolean t;
    public boolean u;
    public boolean v;
    public String w;
    public String x;
    public String y;
    public String z;

    public rr0(JSONObject jSONObject) {
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
        this.t = true;
        this.v = false;
        this.C = false;
        this.D = Boolean.FALSE;
        this.E = "0";
        this.a = jSONObject.optString("style");
        this.b = jSONObject.optString("type");
        this.c = jSONObject.optString("user_name");
        this.d = jSONObject.optString(RecommendDetailActivityConfig.USER_PORTRAIT);
        this.e = jSONObject.optString("scheme");
        this.f = jSONObject.optString("button_scheme");
        this.g = jSONObject.optString(GameGuideConfigInfo.KEY_BUTTON_TEXT);
        this.h = jSONObject.optString("button_color");
        this.i = jSONObject.optString("button_icon");
        this.j = jSONObject.optInt("duration") * 1000;
        this.k = jSONObject.optString("trade");
        jSONObject.optString("score");
        this.l = jSONObject.optString("title");
        this.m = jSONObject.optString("sub_title");
        this.n = jSONObject.optString("popularity_text");
        this.o = jSONObject.optString(NetDiskFileMsg.NetDiskFile.JSON_KEY_COVER_URL);
        this.x = jSONObject.optString("bottom_button_text");
        this.w = jSONObject.optString("bottom_button_icon");
        this.y = jSONObject.optString("bottom_button_scheme");
        this.z = jSONObject.optString("bottom_btn_border_color");
        this.A = jSONObject.optString("bottom_btn_text_color");
        this.B = jSONObject.optString("swipe_up_lottie");
    }

    @Nullable
    public static rr0 a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            return new rr0(jSONObject);
        }
        return (rr0) invokeL.objValue;
    }

    public rr0 b(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            this.f = y51.a(this.f, str, "__BTN_SCHEME__");
            return this;
        }
        return (rr0) invokeL.objValue;
    }

    public rr0 c(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            this.o = str;
            return this;
        }
        return (rr0) invokeL.objValue;
    }

    public rr0 e(@NonNull yq0 yq0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, yq0Var)) == null) {
            this.r = yq0Var;
            return this;
        }
        return (rr0) invokeL.objValue;
    }

    public rr0 f(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            this.q = str;
            return this;
        }
        return (rr0) invokeL.objValue;
    }

    public rr0 g(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            this.e = y51.a(this.e, str, "__SCHEME__");
            return this;
        }
        return (rr0) invokeL.objValue;
    }

    public void d(@NonNull AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, adBaseModel) == null) {
            pr0 pr0Var = adBaseModel.j;
            if (pr0Var != null && !TextUtils.isEmpty(pr0Var.d)) {
                c(adBaseModel.j.d);
            }
            if (!TextUtils.isEmpty(adBaseModel.f.d)) {
                f(adBaseModel.f.d);
            }
            yq0 yq0Var = adBaseModel.l;
            if (yq0Var != null) {
                e(yq0Var);
            }
            if (!TextUtils.isEmpty(adBaseModel.f.c)) {
                g(adBaseModel.f.c);
            }
            AdOperator adOperator = adBaseModel.h;
            if (adOperator != null && !TextUtils.isEmpty(adOperator.d)) {
                b(adBaseModel.h.d);
            }
            if (adBaseModel.f != null) {
                if (TextUtils.isEmpty(this.l)) {
                    this.l = adBaseModel.f.g;
                }
                if (TextUtils.isEmpty(this.k)) {
                    this.k = adBaseModel.f.h;
                }
            }
        }
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            yq0 yq0Var = this.r;
            if (yq0Var != null && yq0Var.e) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (!h() && TextUtils.isEmpty(this.e)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }
}
