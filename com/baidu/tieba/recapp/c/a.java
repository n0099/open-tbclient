package com.baidu.tieba.recapp.c;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.ad;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.tbadkCore.util.MercatorModel;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.AppPosInfo;
/* loaded from: classes.dex */
public class a {
    private static a mSj;
    private String latitude;
    private String longitude;
    private String mSh;
    private String mSi = b.bvq().getString(SharedPrefConfig.ASP_SHOWN_INFO, "");
    private long saveTime;

    private a() {
    }

    public static a dFN() {
        if (mSj == null) {
            synchronized (com.baidu.tieba.tbadkCore.location.b.class) {
                if (mSj == null) {
                    mSj = new a();
                }
            }
        }
        return mSj;
    }

    public void RQ(String str) {
        this.longitude = str;
    }

    public void RR(String str) {
        this.latitude = str;
    }

    public void hw(long j) {
        this.saveTime = j;
    }

    private String dFO() {
        if (TextUtils.isEmpty(this.mSh)) {
            dFP();
        }
        return this.mSh;
    }

    public void dFP() {
        Context applicationContext = TbadkCoreApplication.getInst().getApplicationContext();
        if (ad.bvY() && ad.fb(applicationContext)) {
            try {
                WifiInfo connectionInfo = ((WifiManager) applicationContext.getSystemService("wifi")).getConnectionInfo();
                if (connectionInfo != null) {
                    this.mSh = connectionInfo.getBSSID();
                } else {
                    this.mSh = "";
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void RS(String str) {
        this.mSi = str;
    }

    public void dFQ() {
        b.bvq().putString(SharedPrefConfig.ASP_SHOWN_INFO, this.mSi);
    }

    public AppPosInfo dFR() {
        AppPosInfo.Builder builder = new AppPosInfo.Builder();
        builder.ap_mac = dFO();
        builder.ap_connected = Boolean.valueOf(j.isWifiNet());
        builder.latitude = this.latitude;
        builder.longitude = this.longitude;
        builder.addr_timestamp = Long.valueOf(this.saveTime);
        builder.coordinate_type = "bd09ll";
        builder.asp_shown_info = this.mSi;
        MercatorModel.MercatorData mercatorData = MercatorModel.dQi().getMercatorData();
        if (mercatorData != null) {
            builder.mercator_lat = mercatorData.dQk();
            builder.mercator_lon = mercatorData.dQj();
            builder.mercator_city = Integer.valueOf(mercatorData.dQm());
            builder.mercator_radius = mercatorData.dQl();
            builder.mercator_time = Long.valueOf(mercatorData.dQn());
        }
        return builder.build(false);
    }

    public AppPosInfo dFS() {
        AppPosInfo.Builder builder = new AppPosInfo.Builder();
        builder.ap_mac = dFO();
        builder.ap_connected = Boolean.valueOf(j.isWifiNet());
        builder.latitude = this.latitude;
        builder.longitude = this.longitude;
        if (at.isEmpty(this.latitude) || at.isEmpty(this.longitude)) {
            String string = b.bvq().getString("key_last_receive_location_latitude_and_longitude", "");
            if (!at.isEmpty(string)) {
                String[] split = string.split(",");
                if (split.length >= 2) {
                    builder.latitude = split[0];
                    builder.longitude = split[1];
                }
            }
        }
        builder.addr_timestamp = Long.valueOf(this.saveTime);
        builder.coordinate_type = "BD09LL";
        builder.asp_shown_info = this.mSi;
        MercatorModel.MercatorData mercatorData = MercatorModel.dQi().getMercatorData();
        if (mercatorData != null) {
            builder.mercator_lat = mercatorData.dQk();
            builder.mercator_lon = mercatorData.dQj();
            builder.mercator_city = Integer.valueOf(mercatorData.dQm());
            builder.mercator_radius = mercatorData.dQl();
            builder.mercator_time = Long.valueOf(mercatorData.dQn());
        }
        return builder.build(false);
    }

    public String dFT() {
        AppPosInfo dFS = dFS();
        JSONObject jSONObject = new JSONObject();
        if (dFS != null) {
            try {
                jSONObject.put("ap_mac", dFS.ap_mac);
                jSONObject.put("ap_connected", dFS.ap_connected);
                jSONObject.put("latitude", dFS.latitude);
                jSONObject.put("longitude", dFS.longitude);
                jSONObject.put("addr_timestamp", dFS.addr_timestamp);
                jSONObject.put("coordinate_type", dFS.coordinate_type);
                jSONObject.put(SharedPrefConfig.ASP_SHOWN_INFO, dFS.asp_shown_info);
                jSONObject.put("mercator_lat", dFS.mercator_lat);
                jSONObject.put("mercator_lon", dFS.mercator_lon);
                jSONObject.put("mercator_city", dFS.mercator_city);
                jSONObject.put("mercator_radius", dFS.mercator_radius);
                jSONObject.put("mercator_time", dFS.mercator_time);
            } catch (JSONException e) {
            }
        }
        return jSONObject.toString();
    }
}
