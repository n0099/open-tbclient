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
    private static a lQu;
    private String lQs;
    private String lQt = b.bjf().getString(SharedPrefConfig.ASP_SHOWN_INFO, "");
    private String latitude;
    private String longitude;
    private long saveTime;

    private a() {
    }

    public static a drI() {
        if (lQu == null) {
            synchronized (com.baidu.tieba.tbadkCore.location.b.class) {
                if (lQu == null) {
                    lQu = new a();
                }
            }
        }
        return lQu;
    }

    public void KJ(String str) {
        this.longitude = str;
    }

    public void KK(String str) {
        this.latitude = str;
    }

    public void ge(long j) {
        this.saveTime = j;
    }

    private String drJ() {
        if (TextUtils.isEmpty(this.lQs)) {
            drK();
        }
        return this.lQs;
    }

    public void drK() {
        Context applicationContext = TbadkCoreApplication.getInst().getApplicationContext();
        if (ae.bjT() && ae.dX(applicationContext)) {
            try {
                WifiInfo connectionInfo = ((WifiManager) applicationContext.getSystemService("wifi")).getConnectionInfo();
                if (connectionInfo != null) {
                    this.lQs = connectionInfo.getBSSID();
                } else {
                    this.lQs = "";
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void Qa(String str) {
        this.lQt = str;
    }

    public void drL() {
        b.bjf().putString(SharedPrefConfig.ASP_SHOWN_INFO, this.lQt);
    }

    public AppPosInfo drM() {
        AppPosInfo.Builder builder = new AppPosInfo.Builder();
        builder.ap_mac = drJ();
        builder.ap_connected = Boolean.valueOf(j.isWifiNet());
        builder.latitude = this.latitude;
        builder.longitude = this.longitude;
        builder.addr_timestamp = Long.valueOf(this.saveTime);
        builder.coordinate_type = "bd09ll";
        builder.asp_shown_info = this.lQt;
        MercatorModel.MercatorData mercatorData = MercatorModel.dBy().getMercatorData();
        if (mercatorData != null) {
            builder.mercator_lat = mercatorData.dBA();
            builder.mercator_lon = mercatorData.dBz();
            builder.mercator_city = Integer.valueOf(mercatorData.dBC());
            builder.mercator_radius = mercatorData.dBB();
            builder.mercator_time = Long.valueOf(mercatorData.dBD());
        }
        return builder.build(false);
    }

    public AppPosInfo drN() {
        AppPosInfo.Builder builder = new AppPosInfo.Builder();
        builder.ap_mac = drJ();
        builder.ap_connected = Boolean.valueOf(j.isWifiNet());
        builder.latitude = this.latitude;
        builder.longitude = this.longitude;
        if (at.isEmpty(this.latitude) || at.isEmpty(this.longitude)) {
            String string = b.bjf().getString("key_last_receive_location_latitude_and_longitude", "");
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
        builder.asp_shown_info = this.lQt;
        MercatorModel.MercatorData mercatorData = MercatorModel.dBy().getMercatorData();
        if (mercatorData != null) {
            builder.mercator_lat = mercatorData.dBA();
            builder.mercator_lon = mercatorData.dBz();
            builder.mercator_city = Integer.valueOf(mercatorData.dBC());
            builder.mercator_radius = mercatorData.dBB();
            builder.mercator_time = Long.valueOf(mercatorData.dBD());
        }
        return builder.build(false);
    }

    public String drO() {
        AppPosInfo drN = drN();
        JSONObject jSONObject = new JSONObject();
        if (drN != null) {
            try {
                jSONObject.put("ap_mac", drN.ap_mac);
                jSONObject.put("ap_connected", drN.ap_connected);
                jSONObject.put("latitude", drN.latitude);
                jSONObject.put("longitude", drN.longitude);
                jSONObject.put("addr_timestamp", drN.addr_timestamp);
                jSONObject.put("coordinate_type", drN.coordinate_type);
                jSONObject.put(SharedPrefConfig.ASP_SHOWN_INFO, drN.asp_shown_info);
                jSONObject.put("mercator_lat", drN.mercator_lat);
                jSONObject.put("mercator_lon", drN.mercator_lon);
                jSONObject.put("mercator_city", drN.mercator_city);
                jSONObject.put("mercator_radius", drN.mercator_radius);
                jSONObject.put("mercator_time", drN.mercator_time);
            } catch (JSONException e) {
            }
        }
        return jSONObject.toString();
    }
}
