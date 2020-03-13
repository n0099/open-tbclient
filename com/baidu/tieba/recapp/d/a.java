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
    private static a jLG;
    private String jLE;
    private String jLF = b.aFD().getString(SharedPrefConfig.ASP_SHOWN_INFO, "");
    private String latitude;
    private String longitude;
    private long saveTime;

    private a() {
    }

    public static a cDl() {
        if (jLG == null) {
            synchronized (c.class) {
                if (jLG == null) {
                    jLG = new a();
                }
            }
        }
        return jLG;
    }

    public void CE(String str) {
        this.longitude = str;
    }

    public void CF(String str) {
        this.latitude = str;
    }

    public void ez(long j) {
        this.saveTime = j;
    }

    private String cDm() {
        if (TextUtils.isEmpty(this.jLE)) {
            WifiInfo connectionInfo = ((WifiManager) TbadkCoreApplication.getInst().getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo != null) {
                this.jLE = connectionInfo.getBSSID();
            } else {
                this.jLE = "";
            }
        }
        return this.jLE;
    }

    public void HY(String str) {
        this.jLE = str;
    }

    public void HZ(String str) {
        this.jLF = str;
    }

    public void cDn() {
        b.aFD().putString(SharedPrefConfig.ASP_SHOWN_INFO, this.jLF);
    }

    public AppPosInfo cDo() {
        AppPosInfo.Builder builder = new AppPosInfo.Builder();
        builder.ap_mac = cDm();
        builder.ap_connected = Boolean.valueOf(j.isWifiNet());
        builder.latitude = this.latitude;
        builder.longitude = this.longitude;
        builder.addr_timestamp = Long.valueOf(this.saveTime);
        builder.coordinate_type = "bd09ll";
        builder.asp_shown_info = this.jLF;
        return builder.build(false);
    }
}
