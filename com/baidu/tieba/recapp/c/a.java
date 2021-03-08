package com.baidu.tieba.recapp.c;

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
    private static a mZB;
    private String latitude;
    private String longitude;
    private String mZA = b.brR().getString(SharedPrefConfig.ASP_SHOWN_INFO, "");
    private String mZz;
    private long saveTime;

    private a() {
    }

    public static a dEu() {
        if (mZB == null) {
            synchronized (com.baidu.tieba.tbadkCore.location.b.class) {
                if (mZB == null) {
                    mZB = new a();
                }
            }
        }
        return mZB;
    }

    public void RT(String str) {
        this.longitude = str;
    }

    public void RU(String str) {
        this.latitude = str;
    }

    public void hB(long j) {
        this.saveTime = j;
    }

    private String dEv() {
        if (TextUtils.isEmpty(this.mZz)) {
            dEw();
        }
        return this.mZz;
    }

    public void dEw() {
        Context applicationContext = TbadkCoreApplication.getInst().getApplicationContext();
        if (ae.bsC() && ae.eX(applicationContext)) {
            try {
                WifiInfo connectionInfo = ((WifiManager) applicationContext.getSystemService("wifi")).getConnectionInfo();
                if (connectionInfo != null) {
                    this.mZz = connectionInfo.getBSSID();
                } else {
                    this.mZz = "";
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void RV(String str) {
        this.mZA = str;
    }

    public void dEx() {
        b.brR().putString(SharedPrefConfig.ASP_SHOWN_INFO, this.mZA);
    }

    public AppPosInfo dEy() {
        AppPosInfo.Builder builder = new AppPosInfo.Builder();
        builder.ap_mac = dEv();
        builder.ap_connected = Boolean.valueOf(j.isWifiNet());
        builder.latitude = this.latitude;
        builder.longitude = this.longitude;
        builder.addr_timestamp = Long.valueOf(this.saveTime);
        builder.coordinate_type = "bd09ll";
        builder.asp_shown_info = this.mZA;
        MercatorModel.MercatorData mercatorData = MercatorModel.dOT().getMercatorData();
        if (mercatorData != null) {
            builder.mercator_lat = mercatorData.dOV();
            builder.mercator_lon = mercatorData.dOU();
            builder.mercator_city = Integer.valueOf(mercatorData.dOX());
            builder.mercator_radius = mercatorData.dOW();
            builder.mercator_time = Long.valueOf(mercatorData.dOY());
        }
        return builder.build(false);
    }

    public AppPosInfo dEz() {
        AppPosInfo.Builder builder = new AppPosInfo.Builder();
        builder.ap_mac = dEv();
        builder.ap_connected = Boolean.valueOf(j.isWifiNet());
        builder.latitude = this.latitude;
        builder.longitude = this.longitude;
        if (au.isEmpty(this.latitude) || au.isEmpty(this.longitude)) {
            String string = b.brR().getString("key_last_receive_location_latitude_and_longitude", "");
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
        builder.asp_shown_info = this.mZA;
        MercatorModel.MercatorData mercatorData = MercatorModel.dOT().getMercatorData();
        if (mercatorData != null) {
            builder.mercator_lat = mercatorData.dOV();
            builder.mercator_lon = mercatorData.dOU();
            builder.mercator_city = Integer.valueOf(mercatorData.dOX());
            builder.mercator_radius = mercatorData.dOW();
            builder.mercator_time = Long.valueOf(mercatorData.dOY());
        }
        return builder.build(false);
    }

    public String dEA() {
        AppPosInfo dEz = dEz();
        JSONObject jSONObject = new JSONObject();
        if (dEz != null) {
            try {
                jSONObject.put("ap_mac", dEz.ap_mac);
                jSONObject.put("ap_connected", dEz.ap_connected);
                jSONObject.put("latitude", dEz.latitude);
                jSONObject.put("longitude", dEz.longitude);
                jSONObject.put("addr_timestamp", dEz.addr_timestamp);
                jSONObject.put("coordinate_type", dEz.coordinate_type);
                jSONObject.put(SharedPrefConfig.ASP_SHOWN_INFO, dEz.asp_shown_info);
                jSONObject.put("mercator_lat", dEz.mercator_lat);
                jSONObject.put("mercator_lon", dEz.mercator_lon);
                jSONObject.put("mercator_city", dEz.mercator_city);
                jSONObject.put("mercator_radius", dEz.mercator_radius);
                jSONObject.put("mercator_time", dEz.mercator_time);
            } catch (JSONException e) {
            }
        }
        return jSONObject.toString();
    }
}
