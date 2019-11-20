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
    private static a iMA;
    private String iMy;
    private String iMz = b.alP().getString(SharedPrefConfig.ASP_SHOWN_INFO, "");
    private String latitude;
    private String longitude;
    private long saveTime;

    private a() {
    }

    public static a cgB() {
        if (iMA == null) {
            synchronized (c.class) {
                if (iMA == null) {
                    iMA = new a();
                }
            }
        }
        return iMA;
    }

    public void xu(String str) {
        this.longitude = str;
    }

    public void xv(String str) {
        this.latitude = str;
    }

    public void dQ(long j) {
        this.saveTime = j;
    }

    private String cgC() {
        if (TextUtils.isEmpty(this.iMy)) {
            WifiInfo connectionInfo = ((WifiManager) TbadkCoreApplication.getInst().getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo != null) {
                this.iMy = connectionInfo.getBSSID();
            } else {
                this.iMy = "";
            }
        }
        return this.iMy;
    }

    public void CM(String str) {
        this.iMy = str;
    }

    public void CN(String str) {
        this.iMz = str;
    }

    public void cgD() {
        b.alP().putString(SharedPrefConfig.ASP_SHOWN_INFO, this.iMz);
    }

    public AppPosInfo cgE() {
        AppPosInfo.Builder builder = new AppPosInfo.Builder();
        builder.ap_mac = cgC();
        builder.ap_connected = Boolean.valueOf(j.isWifiNet());
        builder.latitude = this.latitude;
        builder.longitude = this.longitude;
        builder.addr_timestamp = Long.valueOf(this.saveTime);
        builder.coordinate_type = "bd09ll";
        builder.asp_shown_info = this.iMz;
        return builder.build(false);
    }
}
