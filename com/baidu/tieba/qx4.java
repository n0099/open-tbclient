package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import org.json.JSONObject;
import tbclient.FrsPage.Banner;
/* loaded from: classes7.dex */
public class qx4 {
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

    public qx4() {
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

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.d;
        }
        return invokeV.intValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.c;
        }
        return (String) invokeV.objValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
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

    public final void g(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            String[] split = str.split(",");
            if (split != null && split.length >= 2) {
                int i = JavaTypesHelper.toInt(split[0], 1);
                int i2 = JavaTypesHelper.toInt(split[1], 1);
                if (i2 != 0) {
                    this.h = i / i2;
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void i(Banner banner) {
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
        g(banner.tag_name_wh);
    }

    public void h(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048583, this, jSONObject) != null) || jSONObject == null) {
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
            jSONObject.optString(PushConstants.SUB_TAGS_STATUS_NAME);
            this.g = jSONObject.optString("tag_name_url");
            g(jSONObject.optString("tag_name_wh"));
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
    }
}
