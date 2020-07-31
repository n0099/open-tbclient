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
    private static a lqQ;
    private String latitude;
    private String longitude;
    private String lqO;
    private String lqP = b.aZP().getString(SharedPrefConfig.ASP_SHOWN_INFO, "");
    private long saveTime;

    private a() {
    }

    public static a dcN() {
        if (lqQ == null) {
            synchronized (c.class) {
                if (lqQ == null) {
                    lqQ = new a();
                }
            }
        }
        return lqQ;
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
        if (TextUtils.isEmpty(this.lqO)) {
            WifiInfo connectionInfo = ((WifiManager) TbadkCoreApplication.getInst().getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo != null) {
                this.lqO = connectionInfo.getBSSID();
            } else {
                this.lqO = "";
            }
        }
        return this.lqO;
    }

    public void MB(String str) {
        this.lqO = str;
    }

    public void MC(String str) {
        this.lqP = str;
    }

    public void dcP() {
        b.aZP().putString(SharedPrefConfig.ASP_SHOWN_INFO, this.lqP);
    }

    public AppPosInfo dcQ() {
        AppPosInfo.Builder builder = new AppPosInfo.Builder();
        builder.ap_mac = dcO();
        builder.ap_connected = Boolean.valueOf(j.isWifiNet());
        builder.latitude = this.latitude;
        builder.longitude = this.longitude;
        builder.addr_timestamp = Long.valueOf(this.saveTime);
        builder.coordinate_type = "bd09ll";
        builder.asp_shown_info = this.lqP;
        MercatorModel.MercatorData mercatorData = MercatorModel.dme().getMercatorData();
        if (mercatorData != null) {
            builder.mercator_lat = mercatorData.dmg();
            builder.mercator_lon = mercatorData.dmf();
            builder.mercator_city = Integer.valueOf(mercatorData.dmi());
            builder.mercator_radius = mercatorData.dmh();
            builder.mercator_time = Long.valueOf(mercatorData.dmj());
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
        builder.asp_shown_info = this.lqP;
        MercatorModel.MercatorData mercatorData = MercatorModel.dme().getMercatorData();
        if (mercatorData != null) {
            builder.mercator_lat = mercatorData.dmg();
            builder.mercator_lon = mercatorData.dmf();
            builder.mercator_city = Integer.valueOf(mercatorData.dmi());
            builder.mercator_radius = mercatorData.dmh();
            builder.mercator_time = Long.valueOf(mercatorData.dmj());
        }
        return builder.build(false);
    }
}
