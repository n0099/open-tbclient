package com.baidu.tieba.recapp.d;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.tbadkCore.util.MercatorModel;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.AppPosInfo;
/* loaded from: classes.dex */
public class a {
    private static a mfM;
    private String latitude;
    private String longitude;
    private String mfK;
    private String mfL = b.blO().getString(SharedPrefConfig.ASP_SHOWN_INFO, "");
    private long saveTime;

    private a() {
    }

    public static a dvt() {
        if (mfM == null) {
            synchronized (com.baidu.tieba.tbadkCore.location.b.class) {
                if (mfM == null) {
                    mfM = new a();
                }
            }
        }
        return mfM;
    }

    public void Ly(String str) {
        this.longitude = str;
    }

    public void Lz(String str) {
        this.latitude = str;
    }

    public void gw(long j) {
        this.saveTime = j;
    }

    private String dvu() {
        if (TextUtils.isEmpty(this.mfK)) {
            dvv();
        }
        return this.mfK;
    }

    public void dvv() {
        Context applicationContext = TbadkCoreApplication.getInst().getApplicationContext();
        if (ae.bmC() && ae.ed(applicationContext)) {
            try {
                WifiInfo connectionInfo = ((WifiManager) applicationContext.getSystemService("wifi")).getConnectionInfo();
                if (connectionInfo != null) {
                    this.mfK = connectionInfo.getBSSID();
                } else {
                    this.mfK = "";
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void QO(String str) {
        this.mfL = str;
    }

    public void dvw() {
        b.blO().putString(SharedPrefConfig.ASP_SHOWN_INFO, this.mfL);
    }

    public AppPosInfo dvx() {
        AppPosInfo.Builder builder = new AppPosInfo.Builder();
        builder.ap_mac = dvu();
        builder.ap_connected = Boolean.valueOf(j.isWifiNet());
        builder.latitude = this.latitude;
        builder.longitude = this.longitude;
        builder.addr_timestamp = Long.valueOf(this.saveTime);
        builder.coordinate_type = "bd09ll";
        builder.asp_shown_info = this.mfL;
        MercatorModel.MercatorData mercatorData = MercatorModel.dFk().getMercatorData();
        if (mercatorData != null) {
            builder.mercator_lat = mercatorData.dFm();
            builder.mercator_lon = mercatorData.dFl();
            builder.mercator_city = Integer.valueOf(mercatorData.dFo());
            builder.mercator_radius = mercatorData.dFn();
            builder.mercator_time = Long.valueOf(mercatorData.dFp());
        }
        return builder.build(false);
    }

    public AppPosInfo dvy() {
        AppPosInfo.Builder builder = new AppPosInfo.Builder();
        builder.ap_mac = dvu();
        builder.ap_connected = Boolean.valueOf(j.isWifiNet());
        builder.latitude = this.latitude;
        builder.longitude = this.longitude;
        if (at.isEmpty(this.latitude) || at.isEmpty(this.longitude)) {
            String string = b.blO().getString("key_last_receive_location_latitude_and_longitude", "");
            if (!at.isEmpty(string)) {
                String[] split = string.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                if (split.length >= 2) {
                    builder.latitude = split[0];
                    builder.longitude = split[1];
                }
            }
        }
        builder.addr_timestamp = Long.valueOf(this.saveTime);
        builder.coordinate_type = "BD09LL";
        builder.asp_shown_info = this.mfL;
        MercatorModel.MercatorData mercatorData = MercatorModel.dFk().getMercatorData();
        if (mercatorData != null) {
            builder.mercator_lat = mercatorData.dFm();
            builder.mercator_lon = mercatorData.dFl();
            builder.mercator_city = Integer.valueOf(mercatorData.dFo());
            builder.mercator_radius = mercatorData.dFn();
            builder.mercator_time = Long.valueOf(mercatorData.dFp());
        }
        return builder.build(false);
    }

    public String dvz() {
        AppPosInfo dvy = dvy();
        JSONObject jSONObject = new JSONObject();
        if (dvy != null) {
            try {
                jSONObject.put("ap_mac", dvy.ap_mac);
                jSONObject.put("ap_connected", dvy.ap_connected);
                jSONObject.put("latitude", dvy.latitude);
                jSONObject.put("longitude", dvy.longitude);
                jSONObject.put("addr_timestamp", dvy.addr_timestamp);
                jSONObject.put("coordinate_type", dvy.coordinate_type);
                jSONObject.put(SharedPrefConfig.ASP_SHOWN_INFO, dvy.asp_shown_info);
                jSONObject.put("mercator_lat", dvy.mercator_lat);
                jSONObject.put("mercator_lon", dvy.mercator_lon);
                jSONObject.put("mercator_city", dvy.mercator_city);
                jSONObject.put("mercator_radius", dvy.mercator_radius);
                jSONObject.put("mercator_time", dvy.mercator_time);
            } catch (JSONException e) {
            }
        }
        return jSONObject.toString();
    }
}
