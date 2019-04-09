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
    private static a ilS;
    private long AH;
    private String ilQ;
    private String ilR = b.getInstance().getString("asp_shown_info", "");
    private String latitude;
    private String longitude;

    private a() {
    }

    public static a bXv() {
        if (ilS == null) {
            synchronized (c.class) {
                if (ilS == null) {
                    ilS = new a();
                }
            }
        }
        return ilS;
    }

    public void wA(String str) {
        this.longitude = str;
    }

    public void wB(String str) {
        this.latitude = str;
    }

    public void dL(long j) {
        this.AH = j;
    }

    private String bXw() {
        if (TextUtils.isEmpty(this.ilQ)) {
            WifiInfo connectionInfo = ((WifiManager) TbadkCoreApplication.getInst().getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo != null) {
                this.ilQ = connectionInfo.getBSSID();
            } else {
                this.ilQ = "";
            }
        }
        return this.ilQ;
    }

    public void BF(String str) {
        this.ilQ = str;
    }

    public void BG(String str) {
        this.ilR = str;
    }

    public void bXx() {
        b.getInstance().putString("asp_shown_info", this.ilR);
    }

    public AppPosInfo bXy() {
        AppPosInfo.Builder builder = new AppPosInfo.Builder();
        builder.ap_mac = bXw();
        builder.ap_connected = Boolean.valueOf(j.kZ());
        builder.latitude = this.latitude;
        builder.longitude = this.longitude;
        builder.addr_timestamp = Long.valueOf(this.AH);
        builder.coordinate_type = "bd09ll";
        builder.asp_shown_info = this.ilR;
        return builder.build(false);
    }
}
