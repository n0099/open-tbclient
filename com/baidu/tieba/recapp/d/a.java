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
    private static a jGP;
    private String jGN;
    private String jGO = b.aCY().getString(SharedPrefConfig.ASP_SHOWN_INFO, "");
    private String latitude;
    private String longitude;
    private long saveTime;

    private a() {
    }

    public static a cAE() {
        if (jGP == null) {
            synchronized (c.class) {
                if (jGP == null) {
                    jGP = new a();
                }
            }
        }
        return jGP;
    }

    public void Cd(String str) {
        this.longitude = str;
    }

    public void Ce(String str) {
        this.latitude = str;
    }

    public void ex(long j) {
        this.saveTime = j;
    }

    private String cAF() {
        if (TextUtils.isEmpty(this.jGN)) {
            WifiInfo connectionInfo = ((WifiManager) TbadkCoreApplication.getInst().getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo != null) {
                this.jGN = connectionInfo.getBSSID();
            } else {
                this.jGN = "";
            }
        }
        return this.jGN;
    }

    public void Hz(String str) {
        this.jGN = str;
    }

    public void HA(String str) {
        this.jGO = str;
    }

    public void cAG() {
        b.aCY().putString(SharedPrefConfig.ASP_SHOWN_INFO, this.jGO);
    }

    public AppPosInfo cAH() {
        AppPosInfo.Builder builder = new AppPosInfo.Builder();
        builder.ap_mac = cAF();
        builder.ap_connected = Boolean.valueOf(j.isWifiNet());
        builder.latitude = this.latitude;
        builder.longitude = this.longitude;
        builder.addr_timestamp = Long.valueOf(this.saveTime);
        builder.coordinate_type = "bd09ll";
        builder.asp_shown_info = this.jGO;
        return builder.build(false);
    }
}
