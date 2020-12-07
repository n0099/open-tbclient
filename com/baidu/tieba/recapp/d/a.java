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
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.tbadkCore.util.MercatorModel;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.AppPosInfo;
/* loaded from: classes.dex */
public class a {
    private static a mMY;
    private String latitude;
    private String longitude;
    private String mMW;
    private String mMX = b.bsO().getString(SharedPrefConfig.ASP_SHOWN_INFO, "");
    private long saveTime;

    private a() {
    }

    public static a dFX() {
        if (mMY == null) {
            synchronized (com.baidu.tieba.tbadkCore.location.b.class) {
                if (mMY == null) {
                    mMY = new a();
                }
            }
        }
        return mMY;
    }

    public void MW(String str) {
        this.longitude = str;
    }

    public void MX(String str) {
        this.latitude = str;
    }

    public void hB(long j) {
        this.saveTime = j;
    }

    private String dFY() {
        if (TextUtils.isEmpty(this.mMW)) {
            dFZ();
        }
        return this.mMW;
    }

    public void dFZ() {
        Context applicationContext = TbadkCoreApplication.getInst().getApplicationContext();
        if (ae.btD() && ae.eI(applicationContext)) {
            try {
                WifiInfo connectionInfo = ((WifiManager) applicationContext.getSystemService("wifi")).getConnectionInfo();
                if (connectionInfo != null) {
                    this.mMW = connectionInfo.getBSSID();
                } else {
                    this.mMW = "";
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void Sk(String str) {
        this.mMX = str;
    }

    public void dGa() {
        b.bsO().putString(SharedPrefConfig.ASP_SHOWN_INFO, this.mMX);
    }

    public AppPosInfo dGb() {
        AppPosInfo.Builder builder = new AppPosInfo.Builder();
        builder.ap_mac = dFY();
        builder.ap_connected = Boolean.valueOf(j.isWifiNet());
        builder.latitude = this.latitude;
        builder.longitude = this.longitude;
        builder.addr_timestamp = Long.valueOf(this.saveTime);
        builder.coordinate_type = "bd09ll";
        builder.asp_shown_info = this.mMX;
        MercatorModel.MercatorData mercatorData = MercatorModel.dQl().getMercatorData();
        if (mercatorData != null) {
            builder.mercator_lat = mercatorData.dQn();
            builder.mercator_lon = mercatorData.dQm();
            builder.mercator_city = Integer.valueOf(mercatorData.dQp());
            builder.mercator_radius = mercatorData.dQo();
            builder.mercator_time = Long.valueOf(mercatorData.dQq());
        }
        return builder.build(false);
    }

    public AppPosInfo dGc() {
        AppPosInfo.Builder builder = new AppPosInfo.Builder();
        builder.ap_mac = dFY();
        builder.ap_connected = Boolean.valueOf(j.isWifiNet());
        builder.latitude = this.latitude;
        builder.longitude = this.longitude;
        if (au.isEmpty(this.latitude) || au.isEmpty(this.longitude)) {
            String string = b.bsO().getString("key_last_receive_location_latitude_and_longitude", "");
            if (!au.isEmpty(string)) {
                String[] split = string.split(",");
                if (split.length >= 2) {
                    builder.latitude = split[0];
                    builder.longitude = split[1];
                }
            }
        }
        builder.addr_timestamp = Long.valueOf(this.saveTime);
        builder.coordinate_type = "BD09LL";
        builder.asp_shown_info = this.mMX;
        MercatorModel.MercatorData mercatorData = MercatorModel.dQl().getMercatorData();
        if (mercatorData != null) {
            builder.mercator_lat = mercatorData.dQn();
            builder.mercator_lon = mercatorData.dQm();
            builder.mercator_city = Integer.valueOf(mercatorData.dQp());
            builder.mercator_radius = mercatorData.dQo();
            builder.mercator_time = Long.valueOf(mercatorData.dQq());
        }
        return builder.build(false);
    }

    public String dGd() {
        AppPosInfo dGc = dGc();
        JSONObject jSONObject = new JSONObject();
        if (dGc != null) {
            try {
                jSONObject.put("ap_mac", dGc.ap_mac);
                jSONObject.put("ap_connected", dGc.ap_connected);
                jSONObject.put("latitude", dGc.latitude);
                jSONObject.put("longitude", dGc.longitude);
                jSONObject.put("addr_timestamp", dGc.addr_timestamp);
                jSONObject.put("coordinate_type", dGc.coordinate_type);
                jSONObject.put(SharedPrefConfig.ASP_SHOWN_INFO, dGc.asp_shown_info);
                jSONObject.put("mercator_lat", dGc.mercator_lat);
                jSONObject.put("mercator_lon", dGc.mercator_lon);
                jSONObject.put("mercator_city", dGc.mercator_city);
                jSONObject.put("mercator_radius", dGc.mercator_radius);
                jSONObject.put("mercator_time", dGc.mercator_time);
            } catch (JSONException e) {
            }
        }
        return jSONObject.toString();
    }
}
