package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.VrPlayerActivityConfig;
import com.baidu.tbadk.core.util.UtilHelper;
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
public class jd5 {
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
    public boolean j;

    public jd5() {
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

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (!TextUtils.isEmpty(this.b) && this.a > 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.i == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Nullable
    public static jd5 b(String str) {
        InterceptResult invokeL;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (TextUtils.isEmpty(str) || !str.startsWith("[pic-tab]")) {
                return null;
            }
            try {
                jSONObject = new JSONObject(str.substring(9));
            } catch (JSONException e) {
                e.printStackTrace();
                jSONObject = null;
            }
            try {
                jd5 jd5Var = new jd5();
                jd5Var.g = c(jSONObject);
                if (jSONObject != null) {
                    jd5Var.b = jSONObject.optString("tabName");
                }
                return jd5Var;
            } catch (Exception unused) {
                return null;
            }
        }
        return (jd5) invokeL.objValue;
    }

    public void i(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject) != null) || jSONObject == null) {
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
            this.g = c(optJSONObject);
        }
    }

    public static TabPic c(JSONObject jSONObject) {
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

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj == null || jd5.class != obj.getClass()) {
                return false;
            }
            jd5 jd5Var = (jd5) obj;
            if (this.a == jd5Var.a && this.f == jd5Var.f && this.i == jd5Var.i && StringUtils.equalsIgnoreNull(this.b, jd5Var.b) && StringUtils.equalsIgnoreNull(this.c, jd5Var.c) && jd5Var.j) {
                return a(this.d, jd5Var.d);
            }
            if (StringUtils.equalsIgnoreNull(this.d, jd5Var.d) && StringUtils.equalsIgnoreNull(this.e, jd5Var.e) && StringUtils.equalsIgnoreNull(this.h, jd5Var.h)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            return StringUtils.equalsIgnoreNull(UtilHelper.getNoQueryUrl(str), UtilHelper.getNoQueryUrl(str2));
        }
        return invokeLL.booleanValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (h()) {
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

    public boolean h() {
        InterceptResult invokeV;
        TabPic tabPic;
        TabPicDesc tabPicDesc;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (!TextUtils.isEmpty(this.h) && (tabPic = this.g) != null && (tabPicDesc = tabPic.normal) != null && !TextUtils.isEmpty(tabPicDesc.unselected_pic_url) && this.g.normal.pic_width.intValue() > 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return Objects.hash(Integer.valueOf(this.a), this.b, this.c, this.d, this.e, Boolean.valueOf(this.f), this.h);
        }
        return invokeV.intValue;
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.i = z ? 1 : 0;
        }
    }
}
