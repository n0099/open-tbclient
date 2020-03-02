package com.baidu.tieba.recapp.d;

import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tieba.tbadkCore.location.c;
import tbclient.AppPosInfo;
/* loaded from: classes.dex */
public class a {
    private static a jLu;
    private String jLs;
    private String jLt = b.aFD().getString(SharedPrefConfig.ASP_SHOWN_INFO, "");
    private String latitude;
    private String longitude;
    private long saveTime;

    private a() {
    }

    public static a cDk() {
        if (jLu == null) {
            synchronized (c.class) {
                if (jLu == null) {
                    jLu = new a();
                }
            }
        }
        return jLu;
    }

    public void CD(String str) {
        this.longitude = str;
    }

    public void CE(String str) {
        this.latitude = str;
    }

    public void ez(long j) {
        this.saveTime = j;
    }

    private String cDl() {
        if (TextUtils.isEmpty(this.jLs)) {
            WifiInfo connectionInfo = ((WifiManager) TbadkCoreApplication.getInst().getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo != null) {
                this.jLs = connectionInfo.getBSSID();
            } else {
                this.jLs = "";
            }
        }
        return this.jLs;
    }

    public void HX(String str) {
        this.jLs = str;
    }

    public void HY(String str) {
        this.jLt = str;
    }

    public void cDm() {
        b.aFD().putString(SharedPrefConfig.ASP_SHOWN_INFO, this.jLt);
    }

    public AppPosInfo cDn() {
        AppPosInfo.Builder builder = new AppPosInfo.Builder();
        builder.ap_mac = cDl();
        builder.ap_connected = Boolean.valueOf(j.isWifiNet());
        builder.latitude = this.latitude;
        builder.longitude = this.longitude;
        builder.addr_timestamp = Long.valueOf(this.saveTime);
        builder.coordinate_type = "bd09ll";
        builder.asp_shown_info = this.jLt;
        return builder.build(false);
    }
}
