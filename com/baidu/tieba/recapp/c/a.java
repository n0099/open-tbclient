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
    private static a mNC;
    private String latitude;
    private String longitude;
    private String mNA;
    private String mNB = b.brx().getString(SharedPrefConfig.ASP_SHOWN_INFO, "");
    private long saveTime;

    private a() {
    }

    public static a dBW() {
        if (mNC == null) {
            synchronized (com.baidu.tieba.tbadkCore.location.b.class) {
                if (mNC == null) {
                    mNC = new a();
                }
            }
        }
        return mNC;
    }

    public void QH(String str) {
        this.longitude = str;
    }

    public void QI(String str) {
        this.latitude = str;
    }

    public void hw(long j) {
        this.saveTime = j;
    }

    private String dBX() {
        if (TextUtils.isEmpty(this.mNA)) {
            dBY();
        }
        return this.mNA;
    }

    public void dBY() {
        Context applicationContext = TbadkCoreApplication.getInst().getApplicationContext();
        if (ad.bsf() && ad.eZ(applicationContext)) {
            try {
                WifiInfo connectionInfo = ((WifiManager) applicationContext.getSystemService("wifi")).getConnectionInfo();
                if (connectionInfo != null) {
                    this.mNA = connectionInfo.getBSSID();
                } else {
                    this.mNA = "";
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void QJ(String str) {
        this.mNB = str;
    }

    public void dBZ() {
        b.brx().putString(SharedPrefConfig.ASP_SHOWN_INFO, this.mNB);
    }

    public AppPosInfo dCa() {
        AppPosInfo.Builder builder = new AppPosInfo.Builder();
        builder.ap_mac = dBX();
        builder.ap_connected = Boolean.valueOf(j.isWifiNet());
        builder.latitude = this.latitude;
        builder.longitude = this.longitude;
        builder.addr_timestamp = Long.valueOf(this.saveTime);
        builder.coordinate_type = "bd09ll";
        builder.asp_shown_info = this.mNB;
        MercatorModel.MercatorData mercatorData = MercatorModel.dMr().getMercatorData();
        if (mercatorData != null) {
            builder.mercator_lat = mercatorData.dMt();
            builder.mercator_lon = mercatorData.dMs();
            builder.mercator_city = Integer.valueOf(mercatorData.dMv());
            builder.mercator_radius = mercatorData.dMu();
            builder.mercator_time = Long.valueOf(mercatorData.dMw());
        }
        return builder.build(false);
    }

    public AppPosInfo dCb() {
        AppPosInfo.Builder builder = new AppPosInfo.Builder();
        builder.ap_mac = dBX();
        builder.ap_connected = Boolean.valueOf(j.isWifiNet());
        builder.latitude = this.latitude;
        builder.longitude = this.longitude;
        if (at.isEmpty(this.latitude) || at.isEmpty(this.longitude)) {
            String string = b.brx().getString("key_last_receive_location_latitude_and_longitude", "");
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
        builder.asp_shown_info = this.mNB;
        MercatorModel.MercatorData mercatorData = MercatorModel.dMr().getMercatorData();
        if (mercatorData != null) {
            builder.mercator_lat = mercatorData.dMt();
            builder.mercator_lon = mercatorData.dMs();
            builder.mercator_city = Integer.valueOf(mercatorData.dMv());
            builder.mercator_radius = mercatorData.dMu();
            builder.mercator_time = Long.valueOf(mercatorData.dMw());
        }
        return builder.build(false);
    }

    public String dCc() {
        AppPosInfo dCb = dCb();
        JSONObject jSONObject = new JSONObject();
        if (dCb != null) {
            try {
                jSONObject.put("ap_mac", dCb.ap_mac);
                jSONObject.put("ap_connected", dCb.ap_connected);
                jSONObject.put("latitude", dCb.latitude);
                jSONObject.put("longitude", dCb.longitude);
                jSONObject.put("addr_timestamp", dCb.addr_timestamp);
                jSONObject.put("coordinate_type", dCb.coordinate_type);
                jSONObject.put(SharedPrefConfig.ASP_SHOWN_INFO, dCb.asp_shown_info);
                jSONObject.put("mercator_lat", dCb.mercator_lat);
                jSONObject.put("mercator_lon", dCb.mercator_lon);
                jSONObject.put("mercator_city", dCb.mercator_city);
                jSONObject.put("mercator_radius", dCb.mercator_radius);
                jSONObject.put("mercator_time", dCb.mercator_time);
            } catch (JSONException e) {
            }
        }
        return jSONObject.toString();
    }
}
