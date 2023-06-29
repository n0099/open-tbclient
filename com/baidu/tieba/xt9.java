package com.baidu.tieba;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tieba.tbadkCore.util.MercatorModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.AppPosInfo;
/* loaded from: classes8.dex */
public class xt9 {
    public static /* synthetic */ Interceptable $ic;
    public static xt9 f;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public long c;
    public String d;
    public String e;

    public xt9() {
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
        this.e = r95.p().w("asp_shown_info", "");
    }

    public static xt9 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f == null) {
                synchronized (l5a.class) {
                    if (f == null) {
                        f = new xt9();
                    }
                }
            }
            return f;
        }
        return (xt9) invokeV.objValue;
    }

    public final String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (TextUtils.isEmpty(this.d)) {
                f();
            }
            return this.d;
        }
        return (String) invokeV.objValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            r95.p().J("asp_shown_info", this.e);
        }
    }

    public AppPosInfo a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            AppPosInfo.Builder builder = new AppPosInfo.Builder();
            builder.ap_mac = d();
            builder.ap_connected = Boolean.valueOf(BdNetTypeUtil.isWifiNet());
            builder.latitude = this.b;
            builder.longitude = this.a;
            builder.addr_timestamp = Long.valueOf(this.c);
            builder.coordinate_type = "bd09ll";
            builder.asp_shown_info = this.e;
            MercatorModel.MercatorData e = MercatorModel.d().e();
            if (e != null) {
                builder.mercator_lat = e.X();
                builder.mercator_lon = e.Y();
                builder.mercator_city = Integer.valueOf(e.U());
                builder.mercator_radius = e.a0();
                builder.mercator_time = Long.valueOf(e.b0());
            }
            return builder.build(false);
        }
        return (AppPosInfo) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            AppPosInfo c = c();
            JSONObject jSONObject = new JSONObject();
            if (c != null) {
                try {
                    jSONObject.put("ap_mac", c.ap_mac);
                    jSONObject.put("ap_connected", c.ap_connected);
                    jSONObject.put("latitude", c.latitude);
                    jSONObject.put("longitude", c.longitude);
                    jSONObject.put("addr_timestamp", c.addr_timestamp);
                    jSONObject.put("coordinate_type", c.coordinate_type);
                    jSONObject.put("asp_shown_info", c.asp_shown_info);
                    jSONObject.put(SearchJsBridge.COOKIE_MERCATOR_LAT, c.mercator_lat);
                    jSONObject.put(SearchJsBridge.COOKIE_MERCATOR_LON, c.mercator_lon);
                    jSONObject.put(SearchJsBridge.COOKIE_MERCATOR_CITY, c.mercator_city);
                    jSONObject.put(SearchJsBridge.COOKIE_MERCATOR_RADIUS, c.mercator_radius);
                    jSONObject.put(SearchJsBridge.COOKIE_MERCATOR_TIME, c.mercator_time);
                    jSONObject.put("mercator_province_name", c.mercator_province_name);
                    jSONObject.put("mercator_city_name", c.mercator_city_name);
                    jSONObject.put("mercator_district_name", c.mercator_district_name);
                } catch (JSONException unused) {
                }
            }
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }

    public AppPosInfo c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            AppPosInfo.Builder builder = new AppPosInfo.Builder();
            builder.ap_mac = d();
            builder.ap_connected = Boolean.valueOf(BdNetTypeUtil.isWifiNet());
            String str = this.b;
            builder.latitude = str;
            builder.longitude = this.a;
            if (wi.isEmpty(str) || wi.isEmpty(this.a)) {
                String w = r95.p().w("key_last_receive_location_latitude_and_longitude", "");
                if (!wi.isEmpty(w)) {
                    String[] split = w.split(",");
                    if (split.length >= 2) {
                        builder.latitude = split[0];
                        builder.longitude = split[1];
                    }
                }
            }
            builder.addr_timestamp = Long.valueOf(this.c);
            builder.coordinate_type = "BD09LL";
            builder.asp_shown_info = this.e;
            MercatorModel.MercatorData e = MercatorModel.d().e();
            if (e != null) {
                builder.mercator_lat = e.X();
                builder.mercator_lon = e.Y();
                builder.mercator_city = Integer.valueOf(e.U());
                builder.mercator_radius = e.a0();
                builder.mercator_time = Long.valueOf(e.b0());
                builder.mercator_province_name = e.Z();
                builder.mercator_city_name = e.V();
                builder.mercator_district_name = e.W();
            }
            return builder.build(false);
        }
        return (AppPosInfo) invokeV.objValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            Context applicationContext = TbadkCoreApplication.getInst().getApplicationContext();
            if (PermissionUtil.isAgreePrivacyPolicy() && PermissionUtil.checkReadWifiState(applicationContext)) {
                try {
                    WifiInfo connectionInfo = ((WifiManager) applicationContext.getSystemService("wifi")).getConnectionInfo();
                    if (connectionInfo != null) {
                        this.d = connectionInfo.getBSSID();
                    } else {
                        this.d = "";
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.e = str;
        }
    }

    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.b = str;
        }
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.a = str;
        }
    }

    public void k(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048585, this, j) == null) {
            this.c = j;
        }
    }
}
