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
import tbclient.AppPosInfo;
/* loaded from: classes2.dex */
public class a {
    private static a lHn;
    private String lHl;
    private String lHm = b.bik().getString(SharedPrefConfig.ASP_SHOWN_INFO, "");
    private String latitude;
    private String longitude;
    private long saveTime;

    private a() {
    }

    public static a dnW() {
        if (lHn == null) {
            synchronized (com.baidu.tieba.tbadkCore.location.b.class) {
                if (lHn == null) {
                    lHn = new a();
                }
            }
        }
        return lHn;
    }

    public void Kg(String str) {
        this.longitude = str;
    }

    public void Kh(String str) {
        this.latitude = str;
    }

    public void fO(long j) {
        this.saveTime = j;
    }

    private String dnX() {
        if (TextUtils.isEmpty(this.lHl)) {
            dnY();
        }
        return this.lHl;
    }

    public void dnY() {
        Context applicationContext = TbadkCoreApplication.getInst().getApplicationContext();
        if (ae.biY() && ae.dY(applicationContext)) {
            try {
                WifiInfo connectionInfo = ((WifiManager) applicationContext.getSystemService("wifi")).getConnectionInfo();
                if (connectionInfo != null) {
                    this.lHl = connectionInfo.getBSSID();
                } else {
                    this.lHl = "";
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void Pz(String str) {
        this.lHm = str;
    }

    public void dnZ() {
        b.bik().putString(SharedPrefConfig.ASP_SHOWN_INFO, this.lHm);
    }

    public AppPosInfo doa() {
        AppPosInfo.Builder builder = new AppPosInfo.Builder();
        builder.ap_mac = dnX();
        builder.ap_connected = Boolean.valueOf(j.isWifiNet());
        builder.latitude = this.latitude;
        builder.longitude = this.longitude;
        builder.addr_timestamp = Long.valueOf(this.saveTime);
        builder.coordinate_type = "bd09ll";
        builder.asp_shown_info = this.lHm;
        MercatorModel.MercatorData mercatorData = MercatorModel.dxA().getMercatorData();
        if (mercatorData != null) {
            builder.mercator_lat = mercatorData.dxC();
            builder.mercator_lon = mercatorData.dxB();
            builder.mercator_city = Integer.valueOf(mercatorData.dxE());
            builder.mercator_radius = mercatorData.dxD();
            builder.mercator_time = Long.valueOf(mercatorData.dxF());
        }
        return builder.build(false);
    }

    public AppPosInfo dob() {
        AppPosInfo.Builder builder = new AppPosInfo.Builder();
        builder.ap_mac = dnX();
        builder.ap_connected = Boolean.valueOf(j.isWifiNet());
        builder.latitude = this.latitude;
        builder.longitude = this.longitude;
        if (at.isEmpty(this.latitude) || at.isEmpty(this.longitude)) {
            String string = b.bik().getString("key_last_receive_location_latitude_and_longitude", "");
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
        builder.asp_shown_info = this.lHm;
        MercatorModel.MercatorData mercatorData = MercatorModel.dxA().getMercatorData();
        if (mercatorData != null) {
            builder.mercator_lat = mercatorData.dxC();
            builder.mercator_lon = mercatorData.dxB();
            builder.mercator_city = Integer.valueOf(mercatorData.dxE());
            builder.mercator_radius = mercatorData.dxD();
            builder.mercator_time = Long.valueOf(mercatorData.dxF());
        }
        return builder.build(false);
    }
}
