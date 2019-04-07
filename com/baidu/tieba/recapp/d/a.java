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
    private static a ilR;
    private long AH;
    private String ilP;
    private String ilQ = b.getInstance().getString("asp_shown_info", "");
    private String latitude;
    private String longitude;

    private a() {
    }

    public static a bXv() {
        if (ilR == null) {
            synchronized (c.class) {
                if (ilR == null) {
                    ilR = new a();
                }
            }
        }
        return ilR;
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
        if (TextUtils.isEmpty(this.ilP)) {
            WifiInfo connectionInfo = ((WifiManager) TbadkCoreApplication.getInst().getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo != null) {
                this.ilP = connectionInfo.getBSSID();
            } else {
                this.ilP = "";
            }
        }
        return this.ilP;
    }

    public void BF(String str) {
        this.ilP = str;
    }

    public void BG(String str) {
        this.ilQ = str;
    }

    public void bXx() {
        b.getInstance().putString("asp_shown_info", this.ilQ);
    }

    public AppPosInfo bXy() {
        AppPosInfo.Builder builder = new AppPosInfo.Builder();
        builder.ap_mac = bXw();
        builder.ap_connected = Boolean.valueOf(j.kZ());
        builder.latitude = this.latitude;
        builder.longitude = this.longitude;
        builder.addr_timestamp = Long.valueOf(this.AH);
        builder.coordinate_type = "bd09ll";
        builder.asp_shown_info = this.ilQ;
        return builder.build(false);
    }
}
