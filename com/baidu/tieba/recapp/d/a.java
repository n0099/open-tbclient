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
    private static a iNr;
    private String iNp;
    private String iNq = b.alR().getString(SharedPrefConfig.ASP_SHOWN_INFO, "");
    private String latitude;
    private String longitude;
    private long saveTime;

    private a() {
    }

    public static a cgD() {
        if (iNr == null) {
            synchronized (c.class) {
                if (iNr == null) {
                    iNr = new a();
                }
            }
        }
        return iNr;
    }

    public void xu(String str) {
        this.longitude = str;
    }

    public void xv(String str) {
        this.latitude = str;
    }

    public void dR(long j) {
        this.saveTime = j;
    }

    private String cgE() {
        if (TextUtils.isEmpty(this.iNp)) {
            WifiInfo connectionInfo = ((WifiManager) TbadkCoreApplication.getInst().getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo != null) {
                this.iNp = connectionInfo.getBSSID();
            } else {
                this.iNp = "";
            }
        }
        return this.iNp;
    }

    public void CM(String str) {
        this.iNp = str;
    }

    public void CN(String str) {
        this.iNq = str;
    }

    public void cgF() {
        b.alR().putString(SharedPrefConfig.ASP_SHOWN_INFO, this.iNq);
    }

    public AppPosInfo cgG() {
        AppPosInfo.Builder builder = new AppPosInfo.Builder();
        builder.ap_mac = cgE();
        builder.ap_connected = Boolean.valueOf(j.isWifiNet());
        builder.latitude = this.latitude;
        builder.longitude = this.longitude;
        builder.addr_timestamp = Long.valueOf(this.saveTime);
        builder.coordinate_type = "bd09ll";
        builder.asp_shown_info = this.iNq;
        return builder.build(false);
    }
}
