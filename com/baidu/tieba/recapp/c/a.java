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
    private static a mSi;
    private String latitude;
    private String longitude;
    private String mSg;
    private String mSh = b.bvr().getString(SharedPrefConfig.ASP_SHOWN_INFO, "");
    private long saveTime;

    private a() {
    }

    public static a dFO() {
        if (mSi == null) {
            synchronized (com.baidu.tieba.tbadkCore.location.b.class) {
                if (mSi == null) {
                    mSi = new a();
                }
            }
        }
        return mSi;
    }

    public void RP(String str) {
        this.longitude = str;
    }

    public void RQ(String str) {
        this.latitude = str;
    }

    public void hw(long j) {
        this.saveTime = j;
    }

    private String dFP() {
        if (TextUtils.isEmpty(this.mSg)) {
            dFQ();
        }
        return this.mSg;
    }

    public void dFQ() {
        Context applicationContext = TbadkCoreApplication.getInst().getApplicationContext();
        if (ad.bvZ() && ad.fb(applicationContext)) {
            try {
                WifiInfo connectionInfo = ((WifiManager) applicationContext.getSystemService("wifi")).getConnectionInfo();
                if (connectionInfo != null) {
                    this.mSg = connectionInfo.getBSSID();
                } else {
                    this.mSg = "";
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void RR(String str) {
        this.mSh = str;
    }

    public void dFR() {
        b.bvr().putString(SharedPrefConfig.ASP_SHOWN_INFO, this.mSh);
    }

    public AppPosInfo dFS() {
        AppPosInfo.Builder builder = new AppPosInfo.Builder();
        builder.ap_mac = dFP();
        builder.ap_connected = Boolean.valueOf(j.isWifiNet());
        builder.latitude = this.latitude;
        builder.longitude = this.longitude;
        builder.addr_timestamp = Long.valueOf(this.saveTime);
        builder.coordinate_type = "bd09ll";
        builder.asp_shown_info = this.mSh;
        MercatorModel.MercatorData mercatorData = MercatorModel.dQj().getMercatorData();
        if (mercatorData != null) {
            builder.mercator_lat = mercatorData.dQl();
            builder.mercator_lon = mercatorData.dQk();
            builder.mercator_city = Integer.valueOf(mercatorData.dQn());
            builder.mercator_radius = mercatorData.dQm();
            builder.mercator_time = Long.valueOf(mercatorData.dQo());
        }
        return builder.build(false);
    }

    public AppPosInfo dFT() {
        AppPosInfo.Builder builder = new AppPosInfo.Builder();
        builder.ap_mac = dFP();
        builder.ap_connected = Boolean.valueOf(j.isWifiNet());
        builder.latitude = this.latitude;
        builder.longitude = this.longitude;
        if (at.isEmpty(this.latitude) || at.isEmpty(this.longitude)) {
            String string = b.bvr().getString("key_last_receive_location_latitude_and_longitude", "");
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
        builder.asp_shown_info = this.mSh;
        MercatorModel.MercatorData mercatorData = MercatorModel.dQj().getMercatorData();
        if (mercatorData != null) {
            builder.mercator_lat = mercatorData.dQl();
            builder.mercator_lon = mercatorData.dQk();
            builder.mercator_city = Integer.valueOf(mercatorData.dQn());
            builder.mercator_radius = mercatorData.dQm();
            builder.mercator_time = Long.valueOf(mercatorData.dQo());
        }
        return builder.build(false);
    }

    public String dFU() {
        AppPosInfo dFT = dFT();
        JSONObject jSONObject = new JSONObject();
        if (dFT != null) {
            try {
                jSONObject.put("ap_mac", dFT.ap_mac);
                jSONObject.put("ap_connected", dFT.ap_connected);
                jSONObject.put("latitude", dFT.latitude);
                jSONObject.put("longitude", dFT.longitude);
                jSONObject.put("addr_timestamp", dFT.addr_timestamp);
                jSONObject.put("coordinate_type", dFT.coordinate_type);
                jSONObject.put(SharedPrefConfig.ASP_SHOWN_INFO, dFT.asp_shown_info);
                jSONObject.put("mercator_lat", dFT.mercator_lat);
                jSONObject.put("mercator_lon", dFT.mercator_lon);
                jSONObject.put("mercator_city", dFT.mercator_city);
                jSONObject.put("mercator_radius", dFT.mercator_radius);
                jSONObject.put("mercator_time", dFT.mercator_time);
            } catch (JSONException e) {
            }
        }
        return jSONObject.toString();
    }
}
