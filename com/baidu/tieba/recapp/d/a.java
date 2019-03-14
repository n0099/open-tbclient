package com.baidu.tieba.recapp.d;

import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tieba.tbadkCore.location.c;
import tbclient.AppPosInfo;
/* loaded from: classes.dex */
public class a {
    private static a imf;
    private long AI;
    private String imd;
    private String ime = b.getInstance().getString("asp_shown_info", "");
    private String latitude;
    private String longitude;

    private a() {
    }

    public static a bXz() {
        if (imf == null) {
            synchronized (c.class) {
                if (imf == null) {
                    imf = new a();
                }
            }
        }
        return imf;
    }

    public void wB(String str) {
        this.longitude = str;
    }

    public void wC(String str) {
        this.latitude = str;
    }

    public void dL(long j) {
        this.AI = j;
    }

    private String bXA() {
        if (TextUtils.isEmpty(this.imd)) {
            WifiInfo connectionInfo = ((WifiManager) TbadkCoreApplication.getInst().getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo != null) {
                this.imd = connectionInfo.getBSSID();
            } else {
                this.imd = "";
            }
        }
        return this.imd;
    }

    public void BG(String str) {
        this.imd = str;
    }

    public void BH(String str) {
        this.ime = str;
    }

    public void bXB() {
        b.getInstance().putString("asp_shown_info", this.ime);
    }

    public AppPosInfo bXC() {
        AppPosInfo.Builder builder = new AppPosInfo.Builder();
        builder.ap_mac = bXA();
        builder.ap_connected = Boolean.valueOf(j.kZ());
        builder.latitude = this.latitude;
        builder.longitude = this.longitude;
        builder.addr_timestamp = Long.valueOf(this.AI);
        builder.coordinate_type = "bd09ll";
        builder.asp_shown_info = this.ime;
        return builder.build(false);
    }
}
