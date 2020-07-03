package com.baidu.tieba.recapp.d;

import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.tbadkCore.location.c;
import com.baidu.tieba.tbadkCore.util.MercatorModel;
import com.xiaomi.mipush.sdk.Constants;
import tbclient.AppPosInfo;
/* loaded from: classes.dex */
public class a {
    private static a ljx;
    private String latitude;
    private String ljv;
    private String ljw = b.aVP().getString(SharedPrefConfig.ASP_SHOWN_INFO, "");
    private String longitude;
    private long saveTime;

    private a() {
    }

    public static a cZF() {
        if (ljx == null) {
            synchronized (c.class) {
                if (ljx == null) {
                    ljx = new a();
                }
            }
        }
        return ljx;
    }

    public void GA(String str) {
        this.longitude = str;
    }

    public void GB(String str) {
        this.latitude = str;
    }

    public void fp(long j) {
        this.saveTime = j;
    }

    private String cZG() {
        if (TextUtils.isEmpty(this.ljv)) {
            WifiInfo connectionInfo = ((WifiManager) TbadkCoreApplication.getInst().getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo != null) {
                this.ljv = connectionInfo.getBSSID();
            } else {
                this.ljv = "";
            }
        }
        return this.ljv;
    }

    public void LT(String str) {
        this.ljv = str;
    }

    public void LU(String str) {
        this.ljw = str;
    }

    public void cZH() {
        b.aVP().putString(SharedPrefConfig.ASP_SHOWN_INFO, this.ljw);
    }

    public AppPosInfo cZI() {
        AppPosInfo.Builder builder = new AppPosInfo.Builder();
        builder.ap_mac = cZG();
        builder.ap_connected = Boolean.valueOf(j.isWifiNet());
        builder.latitude = this.latitude;
        builder.longitude = this.longitude;
        builder.addr_timestamp = Long.valueOf(this.saveTime);
        builder.coordinate_type = "bd09ll";
        builder.asp_shown_info = this.ljw;
        MercatorModel.MercatorData mercatorData = MercatorModel.diV().getMercatorData();
        if (mercatorData != null) {
            builder.mercator_lat = mercatorData.diX();
            builder.mercator_lon = mercatorData.diW();
            builder.mercator_city = Integer.valueOf(mercatorData.diZ());
            builder.mercator_radius = mercatorData.diY();
            builder.mercator_time = Long.valueOf(mercatorData.dja());
        }
        return builder.build(false);
    }

    public AppPosInfo cZJ() {
        AppPosInfo.Builder builder = new AppPosInfo.Builder();
        builder.ap_mac = cZG();
        builder.ap_connected = Boolean.valueOf(j.isWifiNet());
        builder.latitude = this.latitude;
        builder.longitude = this.longitude;
        if (ar.isEmpty(this.latitude) || ar.isEmpty(this.longitude)) {
            String string = b.aVP().getString("key_last_receive_location_latitude_and_longitude", "");
            if (!ar.isEmpty(string)) {
                String[] split = string.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                if (split.length >= 2) {
                    builder.latitude = split[0];
                    builder.longitude = split[1];
                }
            }
        }
        builder.addr_timestamp = Long.valueOf(this.saveTime);
        builder.coordinate_type = "BD09LL";
        builder.asp_shown_info = this.ljw;
        MercatorModel.MercatorData mercatorData = MercatorModel.diV().getMercatorData();
        if (mercatorData != null) {
            builder.mercator_lat = mercatorData.diX();
            builder.mercator_lon = mercatorData.diW();
            builder.mercator_city = Integer.valueOf(mercatorData.diZ());
            builder.mercator_radius = mercatorData.diY();
            builder.mercator_time = Long.valueOf(mercatorData.dja());
        }
        return builder.build(false);
    }
}
