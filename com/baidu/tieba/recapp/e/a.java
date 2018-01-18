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
    private static a gEp;
    private long ahj;
    private String gEn;
    private String gEo = b.getInstance().getString("asp_shown_info", "");
    private String latitude;
    private String longitude;

    private a() {
    }

    public static a bnw() {
        if (gEp == null) {
            synchronized (c.class) {
                if (gEp == null) {
                    gEp = new a();
                }
            }
        }
        return gEp;
    }

    public void mF(String str) {
        this.longitude = str;
    }

    public void mG(String str) {
        this.latitude = str;
    }

    public void cL(long j) {
        this.ahj = j;
    }

    private String bnx() {
        if (TextUtils.isEmpty(this.gEn)) {
            WifiInfo connectionInfo = ((WifiManager) TbadkCoreApplication.getInst().getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo != null) {
                this.gEn = connectionInfo.getBSSID();
            } else {
                this.gEn = "";
            }
        }
        return this.gEn;
    }

    public void rF(String str) {
        this.gEn = str;
    }

    public void rG(String str) {
        this.gEo = str;
    }

    public void bny() {
        b.getInstance().putString("asp_shown_info", this.gEo);
    }

    public AppPosInfo bnz() {
        AppPosInfo.Builder builder = new AppPosInfo.Builder();
        builder.ap_mac = bnx();
        builder.ap_connected = Boolean.valueOf(j.oJ());
        builder.latitude = this.latitude;
        builder.longitude = this.longitude;
        builder.addr_timestamp = Long.valueOf(this.ahj);
        builder.coordinate_type = BDLocation.BDLOCATION_GCJ02_TO_BD09LL;
        builder.asp_shown_info = this.gEo;
        return builder.build(false);
    }
}
