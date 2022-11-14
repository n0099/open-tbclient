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
/* loaded from: classes6.dex */
public final class yn0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public xn0 j;
    public xn0 k;
    public xn0 l;
    public xn0 m;
    @ColorInt
    public int n;
    @ColorInt
    public int o;
    @ColorInt
    public int p;

    public yn0(String jsonString) {
        xn0 xn0Var;
        String str;
        xn0 xn0Var2;
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
        try {
            JSONObject jSONObject = new JSONObject(jsonString);
            this.a = jSONObject.optString("top_image");
            this.b = jSONObject.optString("top_mid_image");
            this.c = jSONObject.optString("close_image");
            jSONObject.optString("content");
            jSONObject.optString("content_text_color");
            JSONObject optJSONObject = jSONObject.optJSONObject("close_btn");
            if (optJSONObject != null) {
                optJSONObject.optString(GameGuideConfigInfo.KEY_BUTTON_TEXT);
                optJSONObject.optString(MultiMediaDataConstant.KEY_EXT_TEXT_WORDS_COLOR);
            }
            this.e = jSONObject.optString("dialog_type");
            this.d = jSONObject.optString("type");
            this.f = jSONObject.optString("avatar");
            this.g = jSONObject.optString("brand_name");
            this.h = jSONObject.optString("title");
            this.i = jSONObject.optString("convert_cmd");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("convert_btn");
            if (optJSONObject2 != null) {
                xn0 a = xn0.f.a(optJSONObject2);
                this.j = a;
                if (a != null) {
                    str = a.b();
                } else {
                    str = null;
                }
                if (TextUtils.equals(str, "__CONVERT_CMD__") && (xn0Var2 = this.j) != null) {
                    String str2 = this.i;
                    if (str2 != null) {
                        xn0Var2.f(str2);
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                }
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("main_btn");
            if (optJSONObject3 != null) {
                xn0 a2 = xn0.f.a(optJSONObject3);
                this.k = a2;
                if (TextUtils.equals(a2 != null ? a2.b() : null, "__CONVERT_CMD__") && (xn0Var = this.k) != null) {
                    String str3 = this.i;
                    if (str3 != null) {
                        xn0Var.f(str3);
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                }
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("bottom_left_btn");
            if (optJSONObject4 != null) {
                this.l = xn0.f.a(optJSONObject4);
            }
            JSONObject optJSONObject5 = jSONObject.optJSONObject("bottom_right_btn");
            if (optJSONObject5 != null) {
                this.m = xn0.f.a(optJSONObject5);
            }
            String optString = jSONObject.optString("bg_start_color");
            Intrinsics.checkNotNullExpressionValue(optString, "optString(\"bg_start_color\")");
            this.n = ExtensionsKt.e(optString, R.color.obfuscated_res_0x7f060873);
            String optString2 = jSONObject.optString("bg_end_color");
            Intrinsics.checkNotNullExpressionValue(optString2, "optString(\"bg_end_color\")");
            this.o = ExtensionsKt.e(optString2, R.color.obfuscated_res_0x7f060872);
            String optString3 = jSONObject.optString("border_color");
            Intrinsics.checkNotNullExpressionValue(optString3, "optString(\"border_color\")");
            this.p = ExtensionsKt.e(optString3, R.color.obfuscated_res_0x7f060871);
        } catch (JSONException unused) {
        }
    }

    public final String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.f;
        }
        return (String) invokeV.objValue;
    }

    public final int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.o;
        }
        return invokeV.intValue;
    }

    public final int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.n;
        }
        return invokeV.intValue;
    }

    public final int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.p;
        }
        return invokeV.intValue;
    }

    public final xn0 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.l;
        }
        return (xn0) invokeV.objValue;
    }

    public final xn0 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.m;
        }
        return (xn0) invokeV.objValue;
    }

    public final String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.c;
        }
        return (String) invokeV.objValue;
    }

    public final String getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.d;
        }
        return (String) invokeV.objValue;
    }

    public final xn0 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.j;
        }
        return (xn0) invokeV.objValue;
    }

    public final String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.i;
        }
        return (String) invokeV.objValue;
    }

    public final String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public final String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.e;
        }
        return (String) invokeV.objValue;
    }

    public final xn0 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.k;
        }
        return (xn0) invokeV.objValue;
    }

    public final String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.h;
        }
        return (String) invokeV.objValue;
    }

    public final String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.g;
        }
        return (String) invokeV.objValue;
    }

    public final String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.a;
        }
        return (String) invokeV.objValue;
    }

    public final boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return TextUtils.equals(this.d, "detail");
        }
        return invokeV.booleanValue;
    }

    public final boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return TextUtils.equals(this.d, "download");
        }
        return invokeV.booleanValue;
    }
}
