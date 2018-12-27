package com.baidu.tieba.recapp.d;

import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tieba.tbadkCore.location.c;
import tbclient.AppPosInfo;
/* loaded from: classes.dex */
public class a {
    private static a gTD;
    private long AJ;
    private String gTB;
    private String gTC = b.getInstance().getString("asp_shown_info", "");
    private String latitude;
    private String longitude;

    private a() {
    }

    public static a bwa() {
        if (gTD == null) {
            synchronized (c.class) {
                if (gTD == null) {
                    gTD = new a();
                }
            }
        }
        return gTD;
    }

    public void pH(String str) {
        this.longitude = str;
    }

    public void pI(String str) {
        this.latitude = str;
    }

    public void dg(long j) {
        this.AJ = j;
    }

    private String bwb() {
        if (TextUtils.isEmpty(this.gTB)) {
            WifiInfo connectionInfo = ((WifiManager) TbadkCoreApplication.getInst().getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo != null) {
                this.gTB = connectionInfo.getBSSID();
            } else {
                this.gTB = "";
            }
        }
        return this.gTB;
    }

    public void uM(String str) {
        this.gTB = str;
    }

    public void uN(String str) {
        this.gTC = str;
    }

    public void bwc() {
        b.getInstance().putString("asp_shown_info", this.gTC);
    }

    public AppPosInfo bwd() {
        AppPosInfo.Builder builder = new AppPosInfo.Builder();
        builder.ap_mac = bwb();
        builder.ap_connected = Boolean.valueOf(j.kW());
        builder.latitude = this.latitude;
        builder.longitude = this.longitude;
        builder.addr_timestamp = Long.valueOf(this.AJ);
        builder.coordinate_type = "bd09ll";
        builder.asp_shown_info = this.gTC;
        return builder.build(false);
    }
}
