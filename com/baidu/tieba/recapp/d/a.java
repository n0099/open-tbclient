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
    private static a jNi;
    private String jNg;
    private String jNh = b.aFH().getString(SharedPrefConfig.ASP_SHOWN_INFO, "");
    private String latitude;
    private String longitude;
    private long saveTime;

    private a() {
    }

    public static a cDF() {
        if (jNi == null) {
            synchronized (c.class) {
                if (jNi == null) {
                    jNi = new a();
                }
            }
        }
        return jNi;
    }

    public void CE(String str) {
        this.longitude = str;
    }

    public void CF(String str) {
        this.latitude = str;
    }

    public void eA(long j) {
        this.saveTime = j;
    }

    private String cDG() {
        if (TextUtils.isEmpty(this.jNg)) {
            WifiInfo connectionInfo = ((WifiManager) TbadkCoreApplication.getInst().getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo != null) {
                this.jNg = connectionInfo.getBSSID();
            } else {
                this.jNg = "";
            }
        }
        return this.jNg;
    }

    public void HY(String str) {
        this.jNg = str;
    }

    public void HZ(String str) {
        this.jNh = str;
    }

    public void cDH() {
        b.aFH().putString(SharedPrefConfig.ASP_SHOWN_INFO, this.jNh);
    }

    public AppPosInfo cDI() {
        AppPosInfo.Builder builder = new AppPosInfo.Builder();
        builder.ap_mac = cDG();
        builder.ap_connected = Boolean.valueOf(j.isWifiNet());
        builder.latitude = this.latitude;
        builder.longitude = this.longitude;
        builder.addr_timestamp = Long.valueOf(this.saveTime);
        builder.coordinate_type = "bd09ll";
        builder.asp_shown_info = this.jNh;
        return builder.build(false);
    }
}
