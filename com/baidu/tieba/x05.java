package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.VrPlayerActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.TabPic;
import tbclient.TabPicDesc;
/* loaded from: classes6.dex */
public class x05 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public String b;
    public String c;
    public String d;
    public String e;
    public boolean f;
    public TabPic g;
    public String h;
    public int i;

    public x05() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Nullable
    public static x05 a(String str) {
        InterceptResult invokeL;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (!TextUtils.isEmpty(str) && str.startsWith("[pic-tab]")) {
                try {
                    jSONObject = new JSONObject(str.substring(9));
                } catch (JSONException e) {
                    e.printStackTrace();
                    jSONObject = null;
                }
                try {
                    x05 x05Var = new x05();
                    x05Var.g = b(jSONObject);
                    if (jSONObject != null) {
                        x05Var.b = jSONObject.optString("tabName");
                    }
                    return x05Var;
                } catch (Exception unused) {
                    return null;
                }
            }
            return null;
        }
        return (x05) invokeL.objValue;
    }

    public static TabPic b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            TabPic.Builder builder = new TabPic.Builder();
            JSONObject optJSONObject = jSONObject.optJSONObject("normal");
            if (optJSONObject != null) {
                TabPicDesc.Builder builder2 = new TabPicDesc.Builder();
                builder2.selected_pic_url = optJSONObject.optString("selected_pic_url");
                builder2.unselected_pic_url = optJSONObject.optString("unselected_pic_url");
                builder2.pic_height = Integer.valueOf(optJSONObject.optInt(VrPlayerActivityConfig.PIC_HEIGHT));
                builder2.pic_width = Integer.valueOf(optJSONObject.optInt(VrPlayerActivityConfig.PIC_WIDTH));
                builder.normal = builder2.build(true);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("dark");
            if (optJSONObject2 != null) {
                TabPicDesc.Builder builder3 = new TabPicDesc.Builder();
                builder3.selected_pic_url = optJSONObject2.optString("selected_pic_url");
                builder3.unselected_pic_url = optJSONObject2.optString("unselected_pic_url");
                builder3.pic_height = Integer.valueOf(optJSONObject2.optInt(VrPlayerActivityConfig.PIC_HEIGHT));
                builder3.pic_width = Integer.valueOf(optJSONObject2.optInt(VrPlayerActivityConfig.PIC_WIDTH));
                builder.dark = builder3.build(true);
            }
            return builder.build(true);
        }
        return (TabPic) invokeL.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.b : (String) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (g()) {
                try {
                    JSONObject jSONObject = new JSONObject(this.h);
                    jSONObject.put("tabName", this.b);
                    return "[pic-tab]" + jSONObject.toString();
                } catch (JSONException e) {
                    e.printStackTrace();
                    return "[pic-tab]" + this.h;
                }
            }
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? TextUtils.isEmpty(this.b) || this.a <= 0 : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj == null || x05.class != obj.getClass()) {
                return false;
            }
            x05 x05Var = (x05) obj;
            return this.a == x05Var.a && this.f == x05Var.f && this.i == x05Var.i && Objects.equals(this.b, x05Var.b) && Objects.equals(this.c, x05Var.c) && Objects.equals(this.d, x05Var.d) && Objects.equals(this.e, x05Var.e) && Objects.equals(this.h, x05Var.h);
        }
        return invokeL.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.i == 1 : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        TabPic tabPic;
        TabPicDesc tabPicDesc;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (TextUtils.isEmpty(this.h) || (tabPic = this.g) == null || (tabPicDesc = tabPic.normal) == null || TextUtils.isEmpty(tabPicDesc.unselected_pic_url) || this.g.normal.pic_width.intValue() <= 0) ? false : true : invokeV.booleanValue;
    }

    public void h(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.a = jSONObject.optInt("tab_type");
        this.b = jSONObject.optString("tab_name");
        this.c = jSONObject.optString("tab_code");
        this.i = jSONObject.optInt("is_main_tab", 0);
        this.d = jSONObject.optString("tab_url");
        this.e = jSONObject.optString("tab_version");
        JSONObject optJSONObject = jSONObject.optJSONObject("head_pics");
        if (optJSONObject != null) {
            this.h = optJSONObject.toString();
            this.g = b(optJSONObject);
        }
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? Objects.hash(Integer.valueOf(this.a), this.b, this.c, this.d, this.e, Boolean.valueOf(this.f), this.h) : invokeV.intValue;
    }

    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.i = z ? 1 : 0;
        }
    }
}
