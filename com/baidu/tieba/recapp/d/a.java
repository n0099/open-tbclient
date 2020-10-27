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
    private static a msl;
    private String latitude;
    private String longitude;
    private String msj;
    private String msk = b.bnH().getString(SharedPrefConfig.ASP_SHOWN_INFO, "");
    private long saveTime;

    private a() {
    }

    public static a dyA() {
        if (msl == null) {
            synchronized (com.baidu.tieba.tbadkCore.location.b.class) {
                if (msl == null) {
                    msl = new a();
                }
            }
        }
        return msl;
    }

    public void LW(String str) {
        this.longitude = str;
    }

    public void LX(String str) {
        this.latitude = str;
    }

    public void gx(long j) {
        this.saveTime = j;
    }

    private String dyB() {
        if (TextUtils.isEmpty(this.msj)) {
            dyC();
        }
        return this.msj;
    }

    public void dyC() {
        Context applicationContext = TbadkCoreApplication.getInst().getApplicationContext();
        if (ae.bov() && ae.ed(applicationContext)) {
            try {
                WifiInfo connectionInfo = ((WifiManager) applicationContext.getSystemService("wifi")).getConnectionInfo();
                if (connectionInfo != null) {
                    this.msj = connectionInfo.getBSSID();
                } else {
                    this.msj = "";
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void Rm(String str) {
        this.msk = str;
    }

    public void dyD() {
        b.bnH().putString(SharedPrefConfig.ASP_SHOWN_INFO, this.msk);
    }

    public AppPosInfo dyE() {
        AppPosInfo.Builder builder = new AppPosInfo.Builder();
        builder.ap_mac = dyB();
        builder.ap_connected = Boolean.valueOf(j.isWifiNet());
        builder.latitude = this.latitude;
        builder.longitude = this.longitude;
        builder.addr_timestamp = Long.valueOf(this.saveTime);
        builder.coordinate_type = "bd09ll";
        builder.asp_shown_info = this.msk;
        MercatorModel.MercatorData mercatorData = MercatorModel.dIs().getMercatorData();
        if (mercatorData != null) {
            builder.mercator_lat = mercatorData.dIu();
            builder.mercator_lon = mercatorData.dIt();
            builder.mercator_city = Integer.valueOf(mercatorData.dIw());
            builder.mercator_radius = mercatorData.dIv();
            builder.mercator_time = Long.valueOf(mercatorData.dIx());
        }
        return builder.build(false);
    }

    public AppPosInfo dyF() {
        AppPosInfo.Builder builder = new AppPosInfo.Builder();
        builder.ap_mac = dyB();
        builder.ap_connected = Boolean.valueOf(j.isWifiNet());
        builder.latitude = this.latitude;
        builder.longitude = this.longitude;
        if (at.isEmpty(this.latitude) || at.isEmpty(this.longitude)) {
            String string = b.bnH().getString("key_last_receive_location_latitude_and_longitude", "");
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
        builder.asp_shown_info = this.msk;
        MercatorModel.MercatorData mercatorData = MercatorModel.dIs().getMercatorData();
        if (mercatorData != null) {
            builder.mercator_lat = mercatorData.dIu();
            builder.mercator_lon = mercatorData.dIt();
            builder.mercator_city = Integer.valueOf(mercatorData.dIw());
            builder.mercator_radius = mercatorData.dIv();
            builder.mercator_time = Long.valueOf(mercatorData.dIx());
        }
        return builder.build(false);
    }

    public String dyG() {
        AppPosInfo dyF = dyF();
        JSONObject jSONObject = new JSONObject();
        if (dyF != null) {
            try {
                jSONObject.put("ap_mac", dyF.ap_mac);
                jSONObject.put("ap_connected", dyF.ap_connected);
                jSONObject.put("latitude", dyF.latitude);
                jSONObject.put("longitude", dyF.longitude);
                jSONObject.put("addr_timestamp", dyF.addr_timestamp);
                jSONObject.put("coordinate_type", dyF.coordinate_type);
                jSONObject.put(SharedPrefConfig.ASP_SHOWN_INFO, dyF.asp_shown_info);
                jSONObject.put("mercator_lat", dyF.mercator_lat);
                jSONObject.put("mercator_lon", dyF.mercator_lon);
                jSONObject.put("mercator_city", dyF.mercator_city);
                jSONObject.put("mercator_radius", dyF.mercator_radius);
                jSONObject.put("mercator_time", dyF.mercator_time);
            } catch (JSONException e) {
            }
        }
        return jSONObject.toString();
    }
}
