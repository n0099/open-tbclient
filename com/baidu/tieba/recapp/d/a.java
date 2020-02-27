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
    private static a jLs;
    private String jLq;
    private String jLr = b.aFB().getString(SharedPrefConfig.ASP_SHOWN_INFO, "");
    private String latitude;
    private String longitude;
    private long saveTime;

    private a() {
    }

    public static a cDi() {
        if (jLs == null) {
            synchronized (c.class) {
                if (jLs == null) {
                    jLs = new a();
                }
            }
        }
        return jLs;
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

    private String cDj() {
        if (TextUtils.isEmpty(this.jLq)) {
            WifiInfo connectionInfo = ((WifiManager) TbadkCoreApplication.getInst().getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo != null) {
                this.jLq = connectionInfo.getBSSID();
            } else {
                this.jLq = "";
            }
        }
        return this.jLq;
    }

    public void HX(String str) {
        this.jLq = str;
    }

    public void HY(String str) {
        this.jLr = str;
    }

    public void cDk() {
        b.aFB().putString(SharedPrefConfig.ASP_SHOWN_INFO, this.jLr);
    }

    public AppPosInfo cDl() {
        AppPosInfo.Builder builder = new AppPosInfo.Builder();
        builder.ap_mac = cDj();
        builder.ap_connected = Boolean.valueOf(j.isWifiNet());
        builder.latitude = this.latitude;
        builder.longitude = this.longitude;
        builder.addr_timestamp = Long.valueOf(this.saveTime);
        builder.coordinate_type = "bd09ll";
        builder.asp_shown_info = this.jLr;
        return builder.build(false);
    }
}
