package com.baidu.tieba.recapp.d;

import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.location.BDLocation;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tieba.tbadkCore.location.c;
import tbclient.AppPosInfo;
/* loaded from: classes.dex */
public class a {
    private static a gAU;
    private String gAS;
    private String gAT = b.getInstance().getString("asp_shown_info", "");
    private String latitude;
    private String longitude;
    private long zW;

    private a() {
    }

    public static a bqL() {
        if (gAU == null) {
            synchronized (c.class) {
                if (gAU == null) {
                    gAU = new a();
                }
            }
        }
        return gAU;
    }

    public void oz(String str) {
        this.longitude = str;
    }

    public void oA(String str) {
        this.latitude = str;
    }

    public void cS(long j) {
        this.zW = j;
    }

    private String bqM() {
        if (TextUtils.isEmpty(this.gAS)) {
            WifiInfo connectionInfo = ((WifiManager) TbadkCoreApplication.getInst().getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo != null) {
                this.gAS = connectionInfo.getBSSID();
            } else {
                this.gAS = "";
            }
        }
        return this.gAS;
    }

    public void tC(String str) {
        this.gAS = str;
    }

    public void tD(String str) {
        this.gAT = str;
    }

    public void bqN() {
        b.getInstance().putString("asp_shown_info", this.gAT);
    }

    public AppPosInfo bqO() {
        AppPosInfo.Builder builder = new AppPosInfo.Builder();
        builder.ap_mac = bqM();
        builder.ap_connected = Boolean.valueOf(j.kL());
        builder.latitude = this.latitude;
        builder.longitude = this.longitude;
        builder.addr_timestamp = Long.valueOf(this.zW);
        builder.coordinate_type = BDLocation.BDLOCATION_GCJ02_TO_BD09LL;
        builder.asp_shown_info = this.gAT;
        return builder.build(false);
    }
}
