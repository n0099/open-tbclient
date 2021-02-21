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
    private static a mXr;
    private String latitude;
    private String longitude;
    private String mXp;
    private String mXq = b.brQ().getString(SharedPrefConfig.ASP_SHOWN_INFO, "");
    private long saveTime;

    private a() {
    }

    public static a dEm() {
        if (mXr == null) {
            synchronized (com.baidu.tieba.tbadkCore.location.b.class) {
                if (mXr == null) {
                    mXr = new a();
                }
            }
        }
        return mXr;
    }

    public void RN(String str) {
        this.longitude = str;
    }

    public void RO(String str) {
        this.latitude = str;
    }

    public void hB(long j) {
        this.saveTime = j;
    }

    private String dEn() {
        if (TextUtils.isEmpty(this.mXp)) {
            dEo();
        }
        return this.mXp;
    }

    public void dEo() {
        Context applicationContext = TbadkCoreApplication.getInst().getApplicationContext();
        if (ae.bsz() && ae.eY(applicationContext)) {
            try {
                WifiInfo connectionInfo = ((WifiManager) applicationContext.getSystemService("wifi")).getConnectionInfo();
                if (connectionInfo != null) {
                    this.mXp = connectionInfo.getBSSID();
                } else {
                    this.mXp = "";
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void RP(String str) {
        this.mXq = str;
    }

    public void dEp() {
        b.brQ().putString(SharedPrefConfig.ASP_SHOWN_INFO, this.mXq);
    }

    public AppPosInfo dEq() {
        AppPosInfo.Builder builder = new AppPosInfo.Builder();
        builder.ap_mac = dEn();
        builder.ap_connected = Boolean.valueOf(j.isWifiNet());
        builder.latitude = this.latitude;
        builder.longitude = this.longitude;
        builder.addr_timestamp = Long.valueOf(this.saveTime);
        builder.coordinate_type = "bd09ll";
        builder.asp_shown_info = this.mXq;
        MercatorModel.MercatorData mercatorData = MercatorModel.dOK().getMercatorData();
        if (mercatorData != null) {
            builder.mercator_lat = mercatorData.dOM();
            builder.mercator_lon = mercatorData.dOL();
            builder.mercator_city = Integer.valueOf(mercatorData.dOO());
            builder.mercator_radius = mercatorData.dON();
            builder.mercator_time = Long.valueOf(mercatorData.dOP());
        }
        return builder.build(false);
    }

    public AppPosInfo dEr() {
        AppPosInfo.Builder builder = new AppPosInfo.Builder();
        builder.ap_mac = dEn();
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
        builder.asp_shown_info = this.mXq;
        MercatorModel.MercatorData mercatorData = MercatorModel.dOK().getMercatorData();
        if (mercatorData != null) {
            builder.mercator_lat = mercatorData.dOM();
            builder.mercator_lon = mercatorData.dOL();
            builder.mercator_city = Integer.valueOf(mercatorData.dOO());
            builder.mercator_radius = mercatorData.dON();
            builder.mercator_time = Long.valueOf(mercatorData.dOP());
        }
        return builder.build(false);
    }

    public String dEs() {
        AppPosInfo dEr = dEr();
        JSONObject jSONObject = new JSONObject();
        if (dEr != null) {
            try {
                jSONObject.put("ap_mac", dEr.ap_mac);
                jSONObject.put("ap_connected", dEr.ap_connected);
                jSONObject.put("latitude", dEr.latitude);
                jSONObject.put("longitude", dEr.longitude);
                jSONObject.put("addr_timestamp", dEr.addr_timestamp);
                jSONObject.put("coordinate_type", dEr.coordinate_type);
                jSONObject.put(SharedPrefConfig.ASP_SHOWN_INFO, dEr.asp_shown_info);
                jSONObject.put("mercator_lat", dEr.mercator_lat);
                jSONObject.put("mercator_lon", dEr.mercator_lon);
                jSONObject.put("mercator_city", dEr.mercator_city);
                jSONObject.put("mercator_radius", dEr.mercator_radius);
                jSONObject.put("mercator_time", dEr.mercator_time);
            } catch (JSONException e) {
            }
        }
        return jSONObject.toString();
    }
}
