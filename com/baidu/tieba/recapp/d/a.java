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
    private static a myh;
    private String latitude;
    private String longitude;
    private String myf;
    private String myg = b.bqh().getString(SharedPrefConfig.ASP_SHOWN_INFO, "");
    private long saveTime;

    private a() {
    }

    public static a dBc() {
        if (myh == null) {
            synchronized (com.baidu.tieba.tbadkCore.location.b.class) {
                if (myh == null) {
                    myh = new a();
                }
            }
        }
        return myh;
    }

    public void Mn(String str) {
        this.longitude = str;
    }

    public void Mo(String str) {
        this.latitude = str;
    }

    public void gT(long j) {
        this.saveTime = j;
    }

    private String dBd() {
        if (TextUtils.isEmpty(this.myf)) {
            dBe();
        }
        return this.myf;
    }

    public void dBe() {
        Context applicationContext = TbadkCoreApplication.getInst().getApplicationContext();
        if (ae.bqV() && ae.ed(applicationContext)) {
            try {
                WifiInfo connectionInfo = ((WifiManager) applicationContext.getSystemService("wifi")).getConnectionInfo();
                if (connectionInfo != null) {
                    this.myf = connectionInfo.getBSSID();
                } else {
                    this.myf = "";
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void RD(String str) {
        this.myg = str;
    }

    public void dBf() {
        b.bqh().putString(SharedPrefConfig.ASP_SHOWN_INFO, this.myg);
    }

    public AppPosInfo dBg() {
        AppPosInfo.Builder builder = new AppPosInfo.Builder();
        builder.ap_mac = dBd();
        builder.ap_connected = Boolean.valueOf(j.isWifiNet());
        builder.latitude = this.latitude;
        builder.longitude = this.longitude;
        builder.addr_timestamp = Long.valueOf(this.saveTime);
        builder.coordinate_type = "bd09ll";
        builder.asp_shown_info = this.myg;
        MercatorModel.MercatorData mercatorData = MercatorModel.dKU().getMercatorData();
        if (mercatorData != null) {
            builder.mercator_lat = mercatorData.dKW();
            builder.mercator_lon = mercatorData.dKV();
            builder.mercator_city = Integer.valueOf(mercatorData.dKY());
            builder.mercator_radius = mercatorData.dKX();
            builder.mercator_time = Long.valueOf(mercatorData.dKZ());
        }
        return builder.build(false);
    }

    public AppPosInfo dBh() {
        AppPosInfo.Builder builder = new AppPosInfo.Builder();
        builder.ap_mac = dBd();
        builder.ap_connected = Boolean.valueOf(j.isWifiNet());
        builder.latitude = this.latitude;
        builder.longitude = this.longitude;
        if (at.isEmpty(this.latitude) || at.isEmpty(this.longitude)) {
            String string = b.bqh().getString("key_last_receive_location_latitude_and_longitude", "");
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
        builder.asp_shown_info = this.myg;
        MercatorModel.MercatorData mercatorData = MercatorModel.dKU().getMercatorData();
        if (mercatorData != null) {
            builder.mercator_lat = mercatorData.dKW();
            builder.mercator_lon = mercatorData.dKV();
            builder.mercator_city = Integer.valueOf(mercatorData.dKY());
            builder.mercator_radius = mercatorData.dKX();
            builder.mercator_time = Long.valueOf(mercatorData.dKZ());
        }
        return builder.build(false);
    }

    public String dBi() {
        AppPosInfo dBh = dBh();
        JSONObject jSONObject = new JSONObject();
        if (dBh != null) {
            try {
                jSONObject.put("ap_mac", dBh.ap_mac);
                jSONObject.put("ap_connected", dBh.ap_connected);
                jSONObject.put("latitude", dBh.latitude);
                jSONObject.put("longitude", dBh.longitude);
                jSONObject.put("addr_timestamp", dBh.addr_timestamp);
                jSONObject.put("coordinate_type", dBh.coordinate_type);
                jSONObject.put(SharedPrefConfig.ASP_SHOWN_INFO, dBh.asp_shown_info);
                jSONObject.put("mercator_lat", dBh.mercator_lat);
                jSONObject.put("mercator_lon", dBh.mercator_lon);
                jSONObject.put("mercator_city", dBh.mercator_city);
                jSONObject.put("mercator_radius", dBh.mercator_radius);
                jSONObject.put("mercator_time", dBh.mercator_time);
            } catch (JSONException e) {
            }
        }
        return jSONObject.toString();
    }
}
