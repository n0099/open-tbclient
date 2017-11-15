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
    private static a fPk;
    private String fPi;
    private String fPj = b.getInstance().getString("asp_shown_info", "");
    private String latitude;
    private String longitude;
    private long sR;

    private a() {
    }

    public static a bjQ() {
        if (fPk == null) {
            synchronized (c.class) {
                if (fPk == null) {
                    fPk = new a();
                }
            }
        }
        return fPk;
    }

    public void mk(String str) {
        this.longitude = str;
    }

    public void ml(String str) {
        this.latitude = str;
    }

    public void cC(long j) {
        this.sR = j;
    }

    private String bjR() {
        if (TextUtils.isEmpty(this.fPi)) {
            WifiInfo connectionInfo = ((WifiManager) TbadkCoreApplication.getInst().getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo != null) {
                this.fPi = connectionInfo.getBSSID();
            } else {
                this.fPi = "";
            }
        }
        return this.fPi;
    }

    public void rA(String str) {
        this.fPi = str;
    }

    public void rB(String str) {
        this.fPj = str;
    }

    public void bjS() {
        b.getInstance().putString("asp_shown_info", this.fPj);
    }

    public AppPosInfo bjT() {
        AppPosInfo.Builder builder = new AppPosInfo.Builder();
        builder.ap_mac = bjR();
        builder.ap_connected = Boolean.valueOf(j.hi());
        builder.latitude = this.latitude;
        builder.longitude = this.longitude;
        builder.addr_timestamp = Long.valueOf(this.sR);
        builder.coordinate_type = BDLocation.BDLOCATION_GCJ02_TO_BD09LL;
        builder.asp_shown_info = this.fPj;
        return builder.build(false);
    }
}
