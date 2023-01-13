package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
import tbclient.FrsPage.Banner;
/* loaded from: classes5.dex */
public class mt4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public String b;
    public String c;
    public int d;
    public String e;
    public String f;
    public String g;
    public float h;
    public boolean i;

    public mt4() {
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
        this.i = true;
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return invokeV.intValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.f;
        }
        return (String) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.c;
        }
        return (String) invokeV.objValue;
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.d;
        }
        return invokeV.intValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (StringUtils.isNull(this.c)) {
                return false;
            }
            int i = this.d;
            if (i == 1) {
                int i2 = this.a;
                if (i2 != 1 && i2 != 4 && i2 != 2 && i2 != 3) {
                    return false;
                }
                return true;
            } else if (i != 2 || StringUtils.isNull(this.e)) {
                return false;
            } else {
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    public final void f(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            String[] split = str.split(",");
            if (split != null && split.length >= 2) {
                int e = yg.e(split[0], 1);
                int e2 = yg.e(split[1], 1);
                if (e2 != 0) {
                    this.h = e / e2;
                }
            }
        } catch (Exception e3) {
            BdLog.e(e3.getMessage());
        }
    }

    public void h(Banner banner) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, banner) != null) || banner == null) {
            return;
        }
        this.a = banner.banner_type.intValue();
        this.b = banner.banner_url;
        this.c = banner.value;
        this.d = banner.type.intValue();
        this.e = banner.desc;
        banner.template_id.intValue();
        this.f = banner.obj_id;
        String str = banner.tag_name;
        this.g = banner.tag_name_url;
        f(banner.tag_name_wh);
    }

    public void g(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, jSONObject) != null) || jSONObject == null) {
            return;
        }
        try {
            this.a = jSONObject.optInt("bannerType");
            this.b = jSONObject.optString("bannerUrl");
            this.c = jSONObject.optString("value");
            this.d = jSONObject.optInt("type");
            this.e = jSONObject.optString("desc");
            jSONObject.optInt("template_id");
            this.f = jSONObject.optString("obj_id");
            jSONObject.optString("tag_name");
            this.g = jSONObject.optString("tag_name_url");
            f(jSONObject.optString("tag_name_wh"));
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }
}
