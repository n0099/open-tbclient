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
    private static a fYD;
    private String fYB;
    private String fYC = b.getInstance().getString("asp_shown_info", "");
    private String latitude;
    private String longitude;
    private long sR;

    private a() {
    }

    public static a blQ() {
        if (fYD == null) {
            synchronized (c.class) {
                if (fYD == null) {
                    fYD = new a();
                }
            }
        }
        return fYD;
    }

    public void mt(String str) {
        this.longitude = str;
    }

    public void mu(String str) {
        this.latitude = str;
    }

    public void cJ(long j) {
        this.sR = j;
    }

    private String blR() {
        if (TextUtils.isEmpty(this.fYB)) {
            WifiInfo connectionInfo = ((WifiManager) TbadkCoreApplication.getInst().getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo != null) {
                this.fYB = connectionInfo.getBSSID();
            } else {
                this.fYB = "";
            }
        }
        return this.fYB;
    }

    public void rV(String str) {
        this.fYB = str;
    }

    public void rW(String str) {
        this.fYC = str;
    }

    public void blS() {
        b.getInstance().putString("asp_shown_info", this.fYC);
    }

    public AppPosInfo blT() {
        AppPosInfo.Builder builder = new AppPosInfo.Builder();
        builder.ap_mac = blR();
        builder.ap_connected = Boolean.valueOf(j.hi());
        builder.latitude = this.latitude;
        builder.longitude = this.longitude;
        builder.addr_timestamp = Long.valueOf(this.sR);
        builder.coordinate_type = BDLocation.BDLOCATION_GCJ02_TO_BD09LL;
        builder.asp_shown_info = this.fYC;
        return builder.build(false);
    }
}
