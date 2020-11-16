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
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.AppPosInfo;
/* loaded from: classes.dex */
public class a {
    private static a myM;
    private String latitude;
    private String longitude;
    private String myK;
    private String myL = b.bpu().getString(SharedPrefConfig.ASP_SHOWN_INFO, "");
    private long saveTime;

    private a() {
    }

    public static a dAG() {
        if (myM == null) {
            synchronized (com.baidu.tieba.tbadkCore.location.b.class) {
                if (myM == null) {
                    myM = new a();
                }
            }
        }
        return myM;
    }

    public void LO(String str) {
        this.longitude = str;
    }

    public void LP(String str) {
        this.latitude = str;
    }

    public void gW(long j) {
        this.saveTime = j;
    }

    private String dAH() {
        if (TextUtils.isEmpty(this.myK)) {
            dAI();
        }
        return this.myK;
    }

    public void dAI() {
        Context applicationContext = TbadkCoreApplication.getInst().getApplicationContext();
        if (ae.bqi() && ae.ed(applicationContext)) {
            try {
                WifiInfo connectionInfo = ((WifiManager) applicationContext.getSystemService("wifi")).getConnectionInfo();
                if (connectionInfo != null) {
                    this.myK = connectionInfo.getBSSID();
                } else {
                    this.myK = "";
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void Rb(String str) {
        this.myL = str;
    }

    public void dAJ() {
        b.bpu().putString(SharedPrefConfig.ASP_SHOWN_INFO, this.myL);
    }

    public AppPosInfo dAK() {
        AppPosInfo.Builder builder = new AppPosInfo.Builder();
        builder.ap_mac = dAH();
        builder.ap_connected = Boolean.valueOf(j.isWifiNet());
        builder.latitude = this.latitude;
        builder.longitude = this.longitude;
        builder.addr_timestamp = Long.valueOf(this.saveTime);
        builder.coordinate_type = "bd09ll";
        builder.asp_shown_info = this.myL;
        MercatorModel.MercatorData mercatorData = MercatorModel.dKT().getMercatorData();
        if (mercatorData != null) {
            builder.mercator_lat = mercatorData.dKV();
            builder.mercator_lon = mercatorData.dKU();
            builder.mercator_city = Integer.valueOf(mercatorData.dKX());
            builder.mercator_radius = mercatorData.dKW();
            builder.mercator_time = Long.valueOf(mercatorData.dKY());
        }
        return builder.build(false);
    }

    public AppPosInfo dAL() {
        AppPosInfo.Builder builder = new AppPosInfo.Builder();
        builder.ap_mac = dAH();
        builder.ap_connected = Boolean.valueOf(j.isWifiNet());
        builder.latitude = this.latitude;
        builder.longitude = this.longitude;
        if (au.isEmpty(this.latitude) || au.isEmpty(this.longitude)) {
            String string = b.bpu().getString("key_last_receive_location_latitude_and_longitude", "");
            if (!au.isEmpty(string)) {
                String[] split = string.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                if (split.length >= 2) {
                    builder.latitude = split[0];
                    builder.longitude = split[1];
                }
            }
        }
        builder.addr_timestamp = Long.valueOf(this.saveTime);
        builder.coordinate_type = "BD09LL";
        builder.asp_shown_info = this.myL;
        MercatorModel.MercatorData mercatorData = MercatorModel.dKT().getMercatorData();
        if (mercatorData != null) {
            builder.mercator_lat = mercatorData.dKV();
            builder.mercator_lon = mercatorData.dKU();
            builder.mercator_city = Integer.valueOf(mercatorData.dKX());
            builder.mercator_radius = mercatorData.dKW();
            builder.mercator_time = Long.valueOf(mercatorData.dKY());
        }
        return builder.build(false);
    }

    public String dAM() {
        AppPosInfo dAL = dAL();
        JSONObject jSONObject = new JSONObject();
        if (dAL != null) {
            try {
                jSONObject.put("ap_mac", dAL.ap_mac);
                jSONObject.put("ap_connected", dAL.ap_connected);
                jSONObject.put("latitude", dAL.latitude);
                jSONObject.put("longitude", dAL.longitude);
                jSONObject.put("addr_timestamp", dAL.addr_timestamp);
                jSONObject.put("coordinate_type", dAL.coordinate_type);
                jSONObject.put(SharedPrefConfig.ASP_SHOWN_INFO, dAL.asp_shown_info);
                jSONObject.put("mercator_lat", dAL.mercator_lat);
                jSONObject.put("mercator_lon", dAL.mercator_lon);
                jSONObject.put("mercator_city", dAL.mercator_city);
                jSONObject.put("mercator_radius", dAL.mercator_radius);
                jSONObject.put("mercator_time", dAL.mercator_time);
            } catch (JSONException e) {
            }
        }
        return jSONObject.toString();
    }
}
