package com.baidu.tieba;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.DecryptCode.DataRes;
/* loaded from: classes6.dex */
public class vl4 {
    public static /* synthetic */ Interceptable $ic;
    public static final String l;
    public static final String m;
    public static final String n;
    public static final String o;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public int i;
    public String j;
    public Integer k;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948244619, "Lcom/baidu/tieba/vl4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948244619, "Lcom/baidu/tieba/vl4;");
                return;
            }
        }
        l = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f13b9);
        m = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1398);
        n = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0375);
        o = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f03b8);
    }

    public vl4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = "";
        this.b = "";
        this.c = "";
        this.d = "";
        this.e = "";
        this.f = "";
        this.g = "";
        this.h = "";
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f : (String) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.e : (String) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.b : (String) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.c : (String) invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.d : (String) invokeV.objValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.i : invokeV.intValue;
    }

    public void h(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, dataRes) == null) {
            int intValue = dataRes.type.intValue();
            this.i = intValue;
            if (intValue != 0 && intValue != 1) {
                if (intValue == 2) {
                    this.a = dataRes.title;
                    this.d = dataRes.url;
                    return;
                } else if (intValue != 4 && intValue == 3) {
                    this.d = dataRes.url;
                    this.a = dataRes.title;
                    this.b = dataRes.img;
                    this.c = dataRes.tips;
                    this.e = dataRes.btn_sure;
                    this.f = dataRes.btn_cancel;
                    return;
                } else {
                    return;
                }
            }
            this.a = StringUtils.isNull(dataRes.title) ? l : dataRes.title;
            this.b = dataRes.img;
            this.c = StringUtils.isNull(dataRes.tips) ? m : dataRes.tips;
            if (!StringUtils.isNull(dataRes.url)) {
                try {
                    JSONObject jSONObject = new JSONObject(dataRes.url);
                    this.g = jSONObject.optString("appid");
                    this.h = jSONObject.optString("appname");
                    String optString = jSONObject.optString("url");
                    Integer valueOf = Integer.valueOf(jSONObject.optInt("is_game"));
                    this.k = valueOf;
                    this.d = mr5.a(this.g, optString, "9104", valueOf);
                    this.j = jSONObject.optString("swan_app_id");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            this.e = StringUtils.isNull(dataRes.btn_sure) ? o : dataRes.btn_sure;
            this.f = StringUtils.isNull(dataRes.btn_cancel) ? n : dataRes.btn_cancel;
        }
    }
}
