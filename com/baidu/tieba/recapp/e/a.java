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
    private static a gPg;
    private long ahj;
    private String gPe;
    private String gPf = b.getInstance().getString("asp_shown_info", "");
    private String latitude;
    private String longitude;

    private a() {
    }

    public static a bud() {
        if (gPg == null) {
            synchronized (c.class) {
                if (gPg == null) {
                    gPg = new a();
                }
            }
        }
        return gPg;
    }

    public void mC(String str) {
        this.longitude = str;
    }

    public void mD(String str) {
        this.latitude = str;
    }

    public void cT(long j) {
        this.ahj = j;
    }

    private String bue() {
        if (TextUtils.isEmpty(this.gPe)) {
            WifiInfo connectionInfo = ((WifiManager) TbadkCoreApplication.getInst().getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo != null) {
                this.gPe = connectionInfo.getBSSID();
            } else {
                this.gPe = "";
            }
        }
        return this.gPe;
    }

    public void sl(String str) {
        this.gPe = str;
    }

    public void sm(String str) {
        this.gPf = str;
    }

    public void buf() {
        b.getInstance().putString("asp_shown_info", this.gPf);
    }

    public AppPosInfo bug() {
        AppPosInfo.Builder builder = new AppPosInfo.Builder();
        builder.ap_mac = bue();
        builder.ap_connected = Boolean.valueOf(j.oJ());
        builder.latitude = this.latitude;
        builder.longitude = this.longitude;
        builder.addr_timestamp = Long.valueOf(this.ahj);
        builder.coordinate_type = BDLocation.BDLOCATION_GCJ02_TO_BD09LL;
        builder.asp_shown_info = this.gPf;
        return builder.build(false);
    }
}
