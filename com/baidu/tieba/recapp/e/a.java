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
    private static a gEK;
    private long ahm;
    private String gEI;
    private String gEJ = b.getInstance().getString("asp_shown_info", "");
    private String latitude;
    private String longitude;

    private a() {
    }

    public static a bnx() {
        if (gEK == null) {
            synchronized (c.class) {
                if (gEK == null) {
                    gEK = new a();
                }
            }
        }
        return gEK;
    }

    public void mM(String str) {
        this.longitude = str;
    }

    public void mN(String str) {
        this.latitude = str;
    }

    public void cN(long j) {
        this.ahm = j;
    }

    private String bny() {
        if (TextUtils.isEmpty(this.gEI)) {
            WifiInfo connectionInfo = ((WifiManager) TbadkCoreApplication.getInst().getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo != null) {
                this.gEI = connectionInfo.getBSSID();
            } else {
                this.gEI = "";
            }
        }
        return this.gEI;
    }

    public void rM(String str) {
        this.gEI = str;
    }

    public void rN(String str) {
        this.gEJ = str;
    }

    public void bnz() {
        b.getInstance().putString("asp_shown_info", this.gEJ);
    }

    public AppPosInfo bnA() {
        AppPosInfo.Builder builder = new AppPosInfo.Builder();
        builder.ap_mac = bny();
        builder.ap_connected = Boolean.valueOf(j.oK());
        builder.latitude = this.latitude;
        builder.longitude = this.longitude;
        builder.addr_timestamp = Long.valueOf(this.ahm);
        builder.coordinate_type = BDLocation.BDLOCATION_GCJ02_TO_BD09LL;
        builder.asp_shown_info = this.gEJ;
        return builder.build(false);
    }
}
