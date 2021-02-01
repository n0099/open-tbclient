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
    private static a mWR;
    private String latitude;
    private String longitude;
    private String mWP;
    private String mWQ = b.brQ().getString(SharedPrefConfig.ASP_SHOWN_INFO, "");
    private long saveTime;

    private a() {
    }

    public static a dEe() {
        if (mWR == null) {
            synchronized (com.baidu.tieba.tbadkCore.location.b.class) {
                if (mWR == null) {
                    mWR = new a();
                }
            }
        }
        return mWR;
    }

    public void RB(String str) {
        this.longitude = str;
    }

    public void RC(String str) {
        this.latitude = str;
    }

    public void hB(long j) {
        this.saveTime = j;
    }

    private String dEf() {
        if (TextUtils.isEmpty(this.mWP)) {
            dEg();
        }
        return this.mWP;
    }

    public void dEg() {
        Context applicationContext = TbadkCoreApplication.getInst().getApplicationContext();
        if (ae.bsz() && ae.eY(applicationContext)) {
            try {
                WifiInfo connectionInfo = ((WifiManager) applicationContext.getSystemService("wifi")).getConnectionInfo();
                if (connectionInfo != null) {
                    this.mWP = connectionInfo.getBSSID();
                } else {
                    this.mWP = "";
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void RD(String str) {
        this.mWQ = str;
    }

    public void dEh() {
        b.brQ().putString(SharedPrefConfig.ASP_SHOWN_INFO, this.mWQ);
    }

    public AppPosInfo dEi() {
        AppPosInfo.Builder builder = new AppPosInfo.Builder();
        builder.ap_mac = dEf();
        builder.ap_connected = Boolean.valueOf(j.isWifiNet());
        builder.latitude = this.latitude;
        builder.longitude = this.longitude;
        builder.addr_timestamp = Long.valueOf(this.saveTime);
        builder.coordinate_type = "bd09ll";
        builder.asp_shown_info = this.mWQ;
        MercatorModel.MercatorData mercatorData = MercatorModel.dOC().getMercatorData();
        if (mercatorData != null) {
            builder.mercator_lat = mercatorData.dOE();
            builder.mercator_lon = mercatorData.dOD();
            builder.mercator_city = Integer.valueOf(mercatorData.dOG());
            builder.mercator_radius = mercatorData.dOF();
            builder.mercator_time = Long.valueOf(mercatorData.dOH());
        }
        return builder.build(false);
    }

    public AppPosInfo dEj() {
        AppPosInfo.Builder builder = new AppPosInfo.Builder();
        builder.ap_mac = dEf();
        builder.ap_connected = Boolean.valueOf(j.isWifiNet());
        builder.latitude = this.latitude;
        builder.longitude = this.longitude;
        if (au.isEmpty(this.latitude) || au.isEmpty(this.longitude)) {
            String string = b.brQ().getString("key_last_receive_location_latitude_and_longitude", "");
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
        builder.asp_shown_info = this.mWQ;
        MercatorModel.MercatorData mercatorData = MercatorModel.dOC().getMercatorData();
        if (mercatorData != null) {
            builder.mercator_lat = mercatorData.dOE();
            builder.mercator_lon = mercatorData.dOD();
            builder.mercator_city = Integer.valueOf(mercatorData.dOG());
            builder.mercator_radius = mercatorData.dOF();
            builder.mercator_time = Long.valueOf(mercatorData.dOH());
        }
        return builder.build(false);
    }

    public String dEk() {
        AppPosInfo dEj = dEj();
        JSONObject jSONObject = new JSONObject();
        if (dEj != null) {
            try {
                jSONObject.put("ap_mac", dEj.ap_mac);
                jSONObject.put("ap_connected", dEj.ap_connected);
                jSONObject.put("latitude", dEj.latitude);
                jSONObject.put("longitude", dEj.longitude);
                jSONObject.put("addr_timestamp", dEj.addr_timestamp);
                jSONObject.put("coordinate_type", dEj.coordinate_type);
                jSONObject.put(SharedPrefConfig.ASP_SHOWN_INFO, dEj.asp_shown_info);
                jSONObject.put("mercator_lat", dEj.mercator_lat);
                jSONObject.put("mercator_lon", dEj.mercator_lon);
                jSONObject.put("mercator_city", dEj.mercator_city);
                jSONObject.put("mercator_radius", dEj.mercator_radius);
                jSONObject.put("mercator_time", dEj.mercator_time);
            } catch (JSONException e) {
            }
        }
        return jSONObject.toString();
    }
}
