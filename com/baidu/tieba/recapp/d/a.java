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
    private static a imm;
    private long AI;
    private String imk;
    private String iml = b.getInstance().getString("asp_shown_info", "");
    private String latitude;
    private String longitude;

    private a() {
    }

    public static a bXw() {
        if (imm == null) {
            synchronized (c.class) {
                if (imm == null) {
                    imm = new a();
                }
            }
        }
        return imm;
    }

    public void wC(String str) {
        this.longitude = str;
    }

    public void wD(String str) {
        this.latitude = str;
    }

    public void dL(long j) {
        this.AI = j;
    }

    private String bXx() {
        if (TextUtils.isEmpty(this.imk)) {
            WifiInfo connectionInfo = ((WifiManager) TbadkCoreApplication.getInst().getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo != null) {
                this.imk = connectionInfo.getBSSID();
            } else {
                this.imk = "";
            }
        }
        return this.imk;
    }

    public void BH(String str) {
        this.imk = str;
    }

    public void BI(String str) {
        this.iml = str;
    }

    public void bXy() {
        b.getInstance().putString("asp_shown_info", this.iml);
    }

    public AppPosInfo bXz() {
        AppPosInfo.Builder builder = new AppPosInfo.Builder();
        builder.ap_mac = bXx();
        builder.ap_connected = Boolean.valueOf(j.kZ());
        builder.latitude = this.latitude;
        builder.longitude = this.longitude;
        builder.addr_timestamp = Long.valueOf(this.AI);
        builder.coordinate_type = BDLocation.BDLOCATION_GCJ02_TO_BD09LL;
        builder.asp_shown_info = this.iml;
        return builder.build(false);
    }
}
