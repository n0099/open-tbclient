package com.baidu.tieba.recapp.d;

import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.tbadkCore.location.c;
import com.baidu.tieba.tbadkCore.util.MercatorModel;
import com.xiaomi.mipush.sdk.Constants;
import tbclient.AppPosInfo;
/* loaded from: classes.dex */
public class a {
    private static a kPE;
    private String kPC;
    private String kPD = b.aTX().getString(SharedPrefConfig.ASP_SHOWN_INFO, "");
    private String latitude;
    private String longitude;
    private long saveTime;

    private a() {
    }

    public static a cVp() {
        if (kPE == null) {
            synchronized (c.class) {
                if (kPE == null) {
                    kPE = new a();
                }
            }
        }
        return kPE;
    }

    public void FY(String str) {
        this.longitude = str;
    }

    public void FZ(String str) {
        this.latitude = str;
    }

    public void fm(long j) {
        this.saveTime = j;
    }

    private String cVq() {
        if (TextUtils.isEmpty(this.kPC)) {
            WifiInfo connectionInfo = ((WifiManager) TbadkCoreApplication.getInst().getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo != null) {
                this.kPC = connectionInfo.getBSSID();
            } else {
                this.kPC = "";
            }
        }
        return this.kPC;
    }

    public void Ls(String str) {
        this.kPC = str;
    }

    public void Lt(String str) {
        this.kPD = str;
    }

    public void cVr() {
        b.aTX().putString(SharedPrefConfig.ASP_SHOWN_INFO, this.kPD);
    }

    public AppPosInfo cVs() {
        AppPosInfo.Builder builder = new AppPosInfo.Builder();
        builder.ap_mac = cVq();
        builder.ap_connected = Boolean.valueOf(j.isWifiNet());
        builder.latitude = this.latitude;
        builder.longitude = this.longitude;
        builder.addr_timestamp = Long.valueOf(this.saveTime);
        builder.coordinate_type = "bd09ll";
        builder.asp_shown_info = this.kPD;
        MercatorModel.MercatorData mercatorData = MercatorModel.deJ().getMercatorData();
        if (mercatorData != null) {
            builder.mercator_lat = mercatorData.deL();
            builder.mercator_lon = mercatorData.deK();
            builder.mercator_city = Integer.valueOf(mercatorData.deN());
            builder.mercator_radius = mercatorData.deM();
            builder.mercator_time = Long.valueOf(mercatorData.deO());
        }
        return builder.build(false);
    }

    public AppPosInfo cVt() {
        AppPosInfo.Builder builder = new AppPosInfo.Builder();
        builder.ap_mac = cVq();
        builder.ap_connected = Boolean.valueOf(j.isWifiNet());
        builder.latitude = this.latitude;
        builder.longitude = this.longitude;
        if (aq.isEmpty(this.latitude) || aq.isEmpty(this.longitude)) {
            String string = b.aTX().getString("key_last_receive_location_latitude_and_longitude", "");
            if (!aq.isEmpty(string)) {
                String[] split = string.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                if (split.length >= 2) {
                    builder.latitude = split[0];
                    builder.longitude = split[1];
                }
            }
        }
        builder.addr_timestamp = Long.valueOf(this.saveTime);
        builder.coordinate_type = "BD09LL";
        builder.asp_shown_info = this.kPD;
        MercatorModel.MercatorData mercatorData = MercatorModel.deJ().getMercatorData();
        if (mercatorData != null) {
            builder.mercator_lat = mercatorData.deL();
            builder.mercator_lon = mercatorData.deK();
            builder.mercator_city = Integer.valueOf(mercatorData.deN());
            builder.mercator_radius = mercatorData.deM();
            builder.mercator_time = Long.valueOf(mercatorData.deO());
        }
        return builder.build(false);
    }
}
