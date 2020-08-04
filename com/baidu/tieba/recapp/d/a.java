package com.baidu.tieba.recapp.d;

import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.tbadkCore.location.c;
import com.baidu.tieba.tbadkCore.util.MercatorModel;
import com.xiaomi.mipush.sdk.Constants;
import tbclient.AppPosInfo;
/* loaded from: classes.dex */
public class a {
    private static a lqS;
    private String latitude;
    private String longitude;
    private String lqQ;
    private String lqR = b.aZP().getString(SharedPrefConfig.ASP_SHOWN_INFO, "");
    private long saveTime;

    private a() {
    }

    public static a dcN() {
        if (lqS == null) {
            synchronized (c.class) {
                if (lqS == null) {
                    lqS = new a();
                }
            }
        }
        return lqS;
    }

    public void Ho(String str) {
        this.longitude = str;
    }

    public void Hp(String str) {
        this.latitude = str;
    }

    public void fC(long j) {
        this.saveTime = j;
    }

    private String dcO() {
        if (TextUtils.isEmpty(this.lqQ)) {
            WifiInfo connectionInfo = ((WifiManager) TbadkCoreApplication.getInst().getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo != null) {
                this.lqQ = connectionInfo.getBSSID();
            } else {
                this.lqQ = "";
            }
        }
        return this.lqQ;
    }

    public void MB(String str) {
        this.lqQ = str;
    }

    public void MC(String str) {
        this.lqR = str;
    }

    public void dcP() {
        b.aZP().putString(SharedPrefConfig.ASP_SHOWN_INFO, this.lqR);
    }

    public AppPosInfo dcQ() {
        AppPosInfo.Builder builder = new AppPosInfo.Builder();
        builder.ap_mac = dcO();
        builder.ap_connected = Boolean.valueOf(j.isWifiNet());
        builder.latitude = this.latitude;
        builder.longitude = this.longitude;
        builder.addr_timestamp = Long.valueOf(this.saveTime);
        builder.coordinate_type = "bd09ll";
        builder.asp_shown_info = this.lqR;
        MercatorModel.MercatorData mercatorData = MercatorModel.dmf().getMercatorData();
        if (mercatorData != null) {
            builder.mercator_lat = mercatorData.dmh();
            builder.mercator_lon = mercatorData.dmg();
            builder.mercator_city = Integer.valueOf(mercatorData.dmj());
            builder.mercator_radius = mercatorData.dmi();
            builder.mercator_time = Long.valueOf(mercatorData.dmk());
        }
        return builder.build(false);
    }

    public AppPosInfo dcR() {
        AppPosInfo.Builder builder = new AppPosInfo.Builder();
        builder.ap_mac = dcO();
        builder.ap_connected = Boolean.valueOf(j.isWifiNet());
        builder.latitude = this.latitude;
        builder.longitude = this.longitude;
        if (as.isEmpty(this.latitude) || as.isEmpty(this.longitude)) {
            String string = b.aZP().getString("key_last_receive_location_latitude_and_longitude", "");
            if (!as.isEmpty(string)) {
                String[] split = string.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                if (split.length >= 2) {
                    builder.latitude = split[0];
                    builder.longitude = split[1];
                }
            }
        }
        builder.addr_timestamp = Long.valueOf(this.saveTime);
        builder.coordinate_type = "BD09LL";
        builder.asp_shown_info = this.lqR;
        MercatorModel.MercatorData mercatorData = MercatorModel.dmf().getMercatorData();
        if (mercatorData != null) {
            builder.mercator_lat = mercatorData.dmh();
            builder.mercator_lon = mercatorData.dmg();
            builder.mercator_city = Integer.valueOf(mercatorData.dmj());
            builder.mercator_radius = mercatorData.dmi();
            builder.mercator_time = Long.valueOf(mercatorData.dmk());
        }
        return builder.build(false);
    }
}
