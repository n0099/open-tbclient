package com.baidu.tieba.recapp.e;

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
    private static a fOl;
    private String fOj;
    private String fOk = b.getInstance().getString("asp_shown_info", "");
    private String latitude;
    private String longitude;
    private long sR;

    private a() {
    }

    public static a bjF() {
        if (fOl == null) {
            synchronized (c.class) {
                if (fOl == null) {
                    fOl = new a();
                }
            }
        }
        return fOl;
    }

    public void mi(String str) {
        this.longitude = str;
    }

    public void mj(String str) {
        this.latitude = str;
    }

    public void cA(long j) {
        this.sR = j;
    }

    private String bjG() {
        if (TextUtils.isEmpty(this.fOj)) {
            WifiInfo connectionInfo = ((WifiManager) TbadkCoreApplication.getInst().getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo != null) {
                this.fOj = connectionInfo.getBSSID();
            } else {
                this.fOj = "";
            }
        }
        return this.fOj;
    }

    public void rt(String str) {
        this.fOj = str;
    }

    public void ru(String str) {
        this.fOk = str;
    }

    public void bjH() {
        b.getInstance().putString("asp_shown_info", this.fOk);
    }

    public AppPosInfo bjI() {
        AppPosInfo.Builder builder = new AppPosInfo.Builder();
        builder.ap_mac = bjG();
        builder.ap_connected = Boolean.valueOf(j.hi());
        builder.latitude = this.latitude;
        builder.longitude = this.longitude;
        builder.addr_timestamp = Long.valueOf(this.sR);
        builder.coordinate_type = BDLocation.BDLOCATION_GCJ02_TO_BD09LL;
        builder.asp_shown_info = this.fOk;
        return builder.build(false);
    }
}
