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
    private static a mNa;
    private String latitude;
    private String longitude;
    private String mMY;
    private String mMZ = b.bsO().getString(SharedPrefConfig.ASP_SHOWN_INFO, "");
    private long saveTime;

    private a() {
    }

    public static a dFY() {
        if (mNa == null) {
            synchronized (com.baidu.tieba.tbadkCore.location.b.class) {
                if (mNa == null) {
                    mNa = new a();
                }
            }
        }
        return mNa;
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

    private String dFZ() {
        if (TextUtils.isEmpty(this.mMY)) {
            dGa();
        }
        return this.mMY;
    }

    public void dGa() {
        Context applicationContext = TbadkCoreApplication.getInst().getApplicationContext();
        if (ae.btD() && ae.eI(applicationContext)) {
            try {
                WifiInfo connectionInfo = ((WifiManager) applicationContext.getSystemService("wifi")).getConnectionInfo();
                if (connectionInfo != null) {
                    this.mMY = connectionInfo.getBSSID();
                } else {
                    this.mMY = "";
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void Sk(String str) {
        this.mMZ = str;
    }

    public void dGb() {
        b.bsO().putString(SharedPrefConfig.ASP_SHOWN_INFO, this.mMZ);
    }

    public AppPosInfo dGc() {
        AppPosInfo.Builder builder = new AppPosInfo.Builder();
        builder.ap_mac = dFZ();
        builder.ap_connected = Boolean.valueOf(j.isWifiNet());
        builder.latitude = this.latitude;
        builder.longitude = this.longitude;
        builder.addr_timestamp = Long.valueOf(this.saveTime);
        builder.coordinate_type = "bd09ll";
        builder.asp_shown_info = this.mMZ;
        MercatorModel.MercatorData mercatorData = MercatorModel.dQm().getMercatorData();
        if (mercatorData != null) {
            builder.mercator_lat = mercatorData.dQo();
            builder.mercator_lon = mercatorData.dQn();
            builder.mercator_city = Integer.valueOf(mercatorData.dQq());
            builder.mercator_radius = mercatorData.dQp();
            builder.mercator_time = Long.valueOf(mercatorData.dQr());
        }
        return builder.build(false);
    }

    public AppPosInfo dGd() {
        AppPosInfo.Builder builder = new AppPosInfo.Builder();
        builder.ap_mac = dFZ();
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
        builder.asp_shown_info = this.mMZ;
        MercatorModel.MercatorData mercatorData = MercatorModel.dQm().getMercatorData();
        if (mercatorData != null) {
            builder.mercator_lat = mercatorData.dQo();
            builder.mercator_lon = mercatorData.dQn();
            builder.mercator_city = Integer.valueOf(mercatorData.dQq());
            builder.mercator_radius = mercatorData.dQp();
            builder.mercator_time = Long.valueOf(mercatorData.dQr());
        }
        return builder.build(false);
    }

    public String dGe() {
        AppPosInfo dGd = dGd();
        JSONObject jSONObject = new JSONObject();
        if (dGd != null) {
            try {
                jSONObject.put("ap_mac", dGd.ap_mac);
                jSONObject.put("ap_connected", dGd.ap_connected);
                jSONObject.put("latitude", dGd.latitude);
                jSONObject.put("longitude", dGd.longitude);
                jSONObject.put("addr_timestamp", dGd.addr_timestamp);
                jSONObject.put("coordinate_type", dGd.coordinate_type);
                jSONObject.put(SharedPrefConfig.ASP_SHOWN_INFO, dGd.asp_shown_info);
                jSONObject.put("mercator_lat", dGd.mercator_lat);
                jSONObject.put("mercator_lon", dGd.mercator_lon);
                jSONObject.put("mercator_city", dGd.mercator_city);
                jSONObject.put("mercator_radius", dGd.mercator_radius);
                jSONObject.put("mercator_time", dGd.mercator_time);
            } catch (JSONException e) {
            }
        }
        return jSONObject.toString();
    }
}
