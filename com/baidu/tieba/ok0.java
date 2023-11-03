package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.ColorInt;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.utils.ExtensionsKt;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.data.MultiMediaDataConstant;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class ok0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public tn0 A;
    public String B;
    public String C;
    public boolean D;
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public nk0 k;
    public nk0 l;
    public nk0 m;
    public nk0 n;
    public nk0 o;
    @ColorInt
    public int p;
    @ColorInt
    public int q;
    @ColorInt
    public int r;
    public boolean s;
    public String t;
    public String u;
    public String v;
    public String w;
    public String x;
    public String y;
    public String z;

    public ok0(String jsonString) {
        nk0 nk0Var;
        String str;
        nk0 nk0Var2;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jsonString};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(jsonString, "jsonString");
        this.z = "0";
        try {
            JSONObject jSONObject = new JSONObject(jsonString);
            this.a = jSONObject.optString("top_image");
            this.b = jSONObject.optString("top_mid_image");
            this.c = jSONObject.optString("close_image");
            jSONObject.optString("invoke_content");
            this.d = jSONObject.optString("content_text_color");
            JSONObject optJSONObject = jSONObject.optJSONObject("close_btn");
            if (optJSONObject != null) {
                optJSONObject.optString(GameGuideConfigInfo.KEY_BUTTON_TEXT);
                optJSONObject.optString(MultiMediaDataConstant.KEY_EXT_TEXT_WORDS_COLOR);
            }
            this.f = jSONObject.optString("dialog_type");
            this.e = jSONObject.optString("type");
            this.g = jSONObject.optString("avatar");
            this.h = jSONObject.optString("brand_name");
            this.i = jSONObject.optString("title");
            this.j = jSONObject.optString("convert_cmd");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("convert_btn");
            if (optJSONObject2 != null) {
                nk0 a = nk0.f.a(optJSONObject2);
                this.k = a;
                if (a != null) {
                    str = a.b();
                } else {
                    str = null;
                }
                if (TextUtils.equals(str, "__CONVERT_CMD__") && (nk0Var2 = this.k) != null) {
                    String str2 = this.j;
                    if (str2 != null) {
                        nk0Var2.f(str2);
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                }
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("main_btn");
            if (optJSONObject3 != null) {
                nk0 a2 = nk0.f.a(optJSONObject3);
                this.l = a2;
                if (TextUtils.equals(a2 != null ? a2.b() : null, "__CONVERT_CMD__") && (nk0Var = this.l) != null) {
                    String str3 = this.j;
                    if (str3 != null) {
                        nk0Var.f(str3);
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                }
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("sub_btn");
            if (optJSONObject4 != null) {
                this.m = nk0.f.a(optJSONObject4);
            }
            JSONObject optJSONObject5 = jSONObject.optJSONObject("bottom_left_btn");
            if (optJSONObject5 != null) {
                this.n = nk0.f.a(optJSONObject5);
            }
            JSONObject optJSONObject6 = jSONObject.optJSONObject("bottom_right_btn");
            if (optJSONObject6 != null) {
                this.o = nk0.f.a(optJSONObject6);
            }
            String optString = jSONObject.optString("bg_start_color");
            Intrinsics.checkNotNullExpressionValue(optString, "optString(\"bg_start_color\")");
            this.p = ExtensionsKt.g(optString, R.color.nad_reward_video_btn_bg_start);
            String optString2 = jSONObject.optString("bg_end_color");
            Intrinsics.checkNotNullExpressionValue(optString2, "optString(\"bg_end_color\")");
            this.q = ExtensionsKt.g(optString2, R.color.nad_reward_video_btn_bg_end);
            String optString3 = jSONObject.optString("border_color");
            Intrinsics.checkNotNullExpressionValue(optString3, "optString(\"border_color\")");
            this.r = ExtensionsKt.g(optString3, R.color.nad_reward_video_btn_bg_border);
            String optString4 = jSONObject.optString("border_color");
            Intrinsics.checkNotNullExpressionValue(optString4, "optString(\"border_color\")");
            ExtensionsKt.g(optString4, R.color.nad_reward_video_btn_bg_border);
            this.w = jSONObject.optString("content_tips");
            this.x = jSONObject.optString("bg_lottie_url");
            this.y = jSONObject.optString("countdown_tips");
            String optString5 = jSONObject.optString("dialog_animation_switch");
            Intrinsics.checkNotNullExpressionValue(optString5, "optString(\"dialog_animation_switch\")");
            this.z = optString5;
        } catch (JSONException unused) {
        }
    }

    public final boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.s;
        }
        return invokeV.booleanValue;
    }

    public final String B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.v;
        }
        return (String) invokeV.objValue;
    }

    public final boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return TextUtils.equals(this.e, "download");
        }
        return invokeV.booleanValue;
    }

    public final boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.D;
        }
        return invokeV.booleanValue;
    }

    public final boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return TextUtils.equals(this.f, "7");
        }
        return invokeV.booleanValue;
    }

    public final String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.g;
        }
        return (String) invokeV.objValue;
    }

    public final int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.q;
        }
        return invokeV.intValue;
    }

    public final String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.x;
        }
        return (String) invokeV.objValue;
    }

    public final int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.p;
        }
        return invokeV.intValue;
    }

    public final int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.r;
        }
        return invokeV.intValue;
    }

    public final nk0 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.n;
        }
        return (nk0) invokeV.objValue;
    }

    public final nk0 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.o;
        }
        return (nk0) invokeV.objValue;
    }

    public final String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.c;
        }
        return (String) invokeV.objValue;
    }

    public final String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.w;
        }
        return (String) invokeV.objValue;
    }

    public final nk0 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.k;
        }
        return (nk0) invokeV.objValue;
    }

    public final String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.j;
        }
        return (String) invokeV.objValue;
    }

    public final String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.y;
        }
        return (String) invokeV.objValue;
    }

    public final String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.z;
        }
        return (String) invokeV.objValue;
    }

    public final String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.t;
        }
        return (String) invokeV.objValue;
    }

    public final String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public final String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.f;
        }
        return (String) invokeV.objValue;
    }

    public final String q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.C;
        }
        return (String) invokeV.objValue;
    }

    public final tn0 r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.A;
        }
        return (tn0) invokeV.objValue;
    }

    public final nk0 s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return this.l;
        }
        return (nk0) invokeV.objValue;
    }

    public final String t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.u;
        }
        return (String) invokeV.objValue;
    }

    public final nk0 u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return this.m;
        }
        return (nk0) invokeV.objValue;
    }

    public final String v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return this.i;
        }
        return (String) invokeV.objValue;
    }

    public final String w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return this.B;
        }
        return (String) invokeV.objValue;
    }

    public final String x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return this.h;
        }
        return (String) invokeV.objValue;
    }

    public final String y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            return this.d;
        }
        return (String) invokeV.objValue;
    }

    public final String z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            return this.a;
        }
        return (String) invokeV.objValue;
    }

    public final void F(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.t = str;
        }
    }

    public final void G(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.C = str;
        }
    }

    public final void H(tn0 tn0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, tn0Var) == null) {
            this.A = tn0Var;
        }
    }

    public final void I(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.D = z;
        }
    }

    public final void J(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.u = str;
        }
    }

    public final void K(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.B = str;
        }
    }

    public final void L(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.s = z;
        }
    }

    public final void M(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.v = str;
        }
    }
}
