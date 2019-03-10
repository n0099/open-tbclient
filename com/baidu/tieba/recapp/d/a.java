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
    private static a imn;
    private long AI;
    private String iml;
    private String imm = b.getInstance().getString("asp_shown_info", "");
    private String latitude;
    private String longitude;

    private a() {
    }

    public static a bXx() {
        if (imn == null) {
            synchronized (c.class) {
                if (imn == null) {
                    imn = new a();
                }
            }
        }
        return imn;
    }

    public void wD(String str) {
        this.longitude = str;
    }

    public void wE(String str) {
        this.latitude = str;
    }

    public void dL(long j) {
        this.AI = j;
    }

    private String bXy() {
        if (TextUtils.isEmpty(this.iml)) {
            WifiInfo connectionInfo = ((WifiManager) TbadkCoreApplication.getInst().getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo != null) {
                this.iml = connectionInfo.getBSSID();
            } else {
                this.iml = "";
            }
        }
        return this.iml;
    }

    public void BI(String str) {
        this.iml = str;
    }

    public void BJ(String str) {
        this.imm = str;
    }

    public void bXz() {
        b.getInstance().putString("asp_shown_info", this.imm);
    }

    public AppPosInfo bXA() {
        AppPosInfo.Builder builder = new AppPosInfo.Builder();
        builder.ap_mac = bXy();
        builder.ap_connected = Boolean.valueOf(j.kZ());
        builder.latitude = this.latitude;
        builder.longitude = this.longitude;
        builder.addr_timestamp = Long.valueOf(this.AI);
        builder.coordinate_type = BDLocation.BDLOCATION_GCJ02_TO_BD09LL;
        builder.asp_shown_info = this.imm;
        return builder.build(false);
    }
}
