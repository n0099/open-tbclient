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
    private static a fFx;
    private String fFv;
    private String fFw = b.getInstance().getString("asp_shown_info", "");
    private String latitude;
    private String longitude;
    private long sR;

    private a() {
    }

    public static a bgt() {
        if (fFx == null) {
            synchronized (c.class) {
                if (fFx == null) {
                    fFx = new a();
                }
            }
        }
        return fFx;
    }

    public void lM(String str) {
        this.longitude = str;
    }

    public void lN(String str) {
        this.latitude = str;
    }

    public void cz(long j) {
        this.sR = j;
    }

    private String bgu() {
        if (TextUtils.isEmpty(this.fFv)) {
            WifiInfo connectionInfo = ((WifiManager) TbadkCoreApplication.getInst().getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo != null) {
                this.fFv = connectionInfo.getBSSID();
            } else {
                this.fFv = "";
            }
        }
        return this.fFv;
    }

    public void qM(String str) {
        this.fFv = str;
    }

    public void qN(String str) {
        this.fFw = str;
    }

    public void bgv() {
        b.getInstance().putString("asp_shown_info", this.fFw);
    }

    public AppPosInfo bgw() {
        AppPosInfo.Builder builder = new AppPosInfo.Builder();
        builder.ap_mac = bgu();
        builder.ap_connected = Boolean.valueOf(j.hi());
        builder.latitude = this.latitude;
        builder.longitude = this.longitude;
        builder.addr_timestamp = Long.valueOf(this.sR);
        builder.coordinate_type = BDLocation.BDLOCATION_GCJ02_TO_BD09LL;
        builder.asp_shown_info = this.fFw;
        return builder.build(false);
    }
}
