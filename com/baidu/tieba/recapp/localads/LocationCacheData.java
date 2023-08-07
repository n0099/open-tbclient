package com.baidu.tieba.recapp.localads;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tieba.bi;
import com.baidu.tieba.pca;
import com.baidu.tieba.tbadkCore.util.MercatorModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.AppPosInfo;
/* loaded from: classes7.dex */
public class LocationCacheData {
    public static /* synthetic */ Interceptable $ic;
    public static LocationCacheData sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public String ap_MacAddress;
    public String aspShowInfo;
    public String latitude;
    public String longitude;
    public long saveTime;

    public LocationCacheData() {
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
        this.aspShowInfo = SharedPrefHelper.getInstance().getString("asp_shown_info", "");
    }

    private String getApMacAddress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            if (TextUtils.isEmpty(this.ap_MacAddress)) {
                refreshMacAddress();
            }
            return this.ap_MacAddress;
        }
        return (String) invokeV.objValue;
    }

    public static LocationCacheData getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (sInstance == null) {
                synchronized (pca.class) {
                    if (sInstance == null) {
                        sInstance = new LocationCacheData();
                    }
                }
            }
            return sInstance;
        }
        return (LocationCacheData) invokeV.objValue;
    }

    public void saveAspShowInfoInSharePref() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            SharedPrefHelper.getInstance().putString("asp_shown_info", this.aspShowInfo);
        }
    }

    public AppPosInfo createAppPosInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            AppPosInfo.Builder builder = new AppPosInfo.Builder();
            builder.ap_mac = getApMacAddress();
            builder.ap_connected = Boolean.valueOf(BdNetTypeUtil.isWifiNet());
            builder.latitude = this.latitude;
            builder.longitude = this.longitude;
            builder.addr_timestamp = Long.valueOf(this.saveTime);
            builder.coordinate_type = "bd09ll";
            builder.asp_shown_info = this.aspShowInfo;
            MercatorModel.MercatorData e = MercatorModel.d().e();
            if (e != null) {
                builder.mercator_lat = e.Q();
                builder.mercator_lon = e.R();
                builder.mercator_city = Integer.valueOf(e.N());
                builder.mercator_radius = e.T();
                builder.mercator_time = Long.valueOf(e.U());
            }
            return builder.build(false);
        }
        return (AppPosInfo) invokeV.objValue;
    }

    public String createAppPosInfoForFlutter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            AppPosInfo createRecReqAppPosInfo = createRecReqAppPosInfo();
            JSONObject jSONObject = new JSONObject();
            if (createRecReqAppPosInfo != null) {
                try {
                    jSONObject.put("ap_mac", createRecReqAppPosInfo.ap_mac);
                    jSONObject.put("ap_connected", createRecReqAppPosInfo.ap_connected);
                    jSONObject.put("latitude", createRecReqAppPosInfo.latitude);
                    jSONObject.put("longitude", createRecReqAppPosInfo.longitude);
                    jSONObject.put("addr_timestamp", createRecReqAppPosInfo.addr_timestamp);
                    jSONObject.put("coordinate_type", createRecReqAppPosInfo.coordinate_type);
                    jSONObject.put("asp_shown_info", createRecReqAppPosInfo.asp_shown_info);
                    jSONObject.put(SearchJsBridge.COOKIE_MERCATOR_LAT, createRecReqAppPosInfo.mercator_lat);
                    jSONObject.put(SearchJsBridge.COOKIE_MERCATOR_LON, createRecReqAppPosInfo.mercator_lon);
                    jSONObject.put(SearchJsBridge.COOKIE_MERCATOR_CITY, createRecReqAppPosInfo.mercator_city);
                    jSONObject.put(SearchJsBridge.COOKIE_MERCATOR_RADIUS, createRecReqAppPosInfo.mercator_radius);
                    jSONObject.put(SearchJsBridge.COOKIE_MERCATOR_TIME, createRecReqAppPosInfo.mercator_time);
                    jSONObject.put("mercator_province_name", createRecReqAppPosInfo.mercator_province_name);
                    jSONObject.put("mercator_city_name", createRecReqAppPosInfo.mercator_city_name);
                    jSONObject.put("mercator_district_name", createRecReqAppPosInfo.mercator_district_name);
                } catch (JSONException unused) {
                }
            }
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }

    public AppPosInfo createRecReqAppPosInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            AppPosInfo.Builder builder = new AppPosInfo.Builder();
            builder.ap_mac = getApMacAddress();
            builder.ap_connected = Boolean.valueOf(BdNetTypeUtil.isWifiNet());
            String str = this.latitude;
            builder.latitude = str;
            builder.longitude = this.longitude;
            if (bi.isEmpty(str) || bi.isEmpty(this.longitude)) {
                String string = SharedPrefHelper.getInstance().getString("key_last_receive_location_latitude_and_longitude", "");
                if (!bi.isEmpty(string)) {
                    String[] split = string.split(",");
                    if (split.length >= 2) {
                        builder.latitude = split[0];
                        builder.longitude = split[1];
                    }
                }
            }
            builder.addr_timestamp = Long.valueOf(this.saveTime);
            builder.coordinate_type = "BD09LL";
            builder.asp_shown_info = this.aspShowInfo;
            MercatorModel.MercatorData e = MercatorModel.d().e();
            if (e != null) {
                builder.mercator_lat = e.Q();
                builder.mercator_lon = e.R();
                builder.mercator_city = Integer.valueOf(e.N());
                builder.mercator_radius = e.T();
                builder.mercator_time = Long.valueOf(e.U());
                builder.mercator_province_name = e.S();
                builder.mercator_city_name = e.O();
                builder.mercator_district_name = e.P();
            }
            return builder.build(false);
        }
        return (AppPosInfo) invokeV.objValue;
    }

    public void refreshMacAddress() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Context applicationContext = TbadkCoreApplication.getInst().getApplicationContext();
            if (PermissionUtil.isAgreePrivacyPolicy() && PermissionUtil.checkReadWifiState(applicationContext)) {
                try {
                    WifiInfo connectionInfo = ((WifiManager) applicationContext.getSystemService("wifi")).getConnectionInfo();
                    if (connectionInfo != null) {
                        this.ap_MacAddress = connectionInfo.getBSSID();
                    } else {
                        this.ap_MacAddress = "";
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void setAspShowInfo(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.aspShowInfo = str;
        }
    }

    public void setLatitude(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.latitude = str;
        }
    }

    public void setLongitude(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.longitude = str;
        }
    }

    public void setSaveTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j) == null) {
            this.saveTime = j;
        }
    }
}
