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
    private static a gUJ;
    private long AJ;
    private String gUH;
    private String gUI = b.getInstance().getString("asp_shown_info", "");
    private String latitude;
    private String longitude;

    private a() {
    }

    public static a bwJ() {
        if (gUJ == null) {
            synchronized (c.class) {
                if (gUJ == null) {
                    gUJ = new a();
                }
            }
        }
        return gUJ;
    }

    public void pX(String str) {
        this.longitude = str;
    }

    public void pY(String str) {
        this.latitude = str;
    }

    public void dg(long j) {
        this.AJ = j;
    }

    private String bwK() {
        if (TextUtils.isEmpty(this.gUH)) {
            WifiInfo connectionInfo = ((WifiManager) TbadkCoreApplication.getInst().getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo != null) {
                this.gUH = connectionInfo.getBSSID();
            } else {
                this.gUH = "";
            }
        }
        return this.gUH;
    }

    public void vc(String str) {
        this.gUH = str;
    }

    public void vd(String str) {
        this.gUI = str;
    }

    public void bwL() {
        b.getInstance().putString("asp_shown_info", this.gUI);
    }

    public AppPosInfo bwM() {
        AppPosInfo.Builder builder = new AppPosInfo.Builder();
        builder.ap_mac = bwK();
        builder.ap_connected = Boolean.valueOf(j.kW());
        builder.latitude = this.latitude;
        builder.longitude = this.longitude;
        builder.addr_timestamp = Long.valueOf(this.AJ);
        builder.coordinate_type = "bd09ll";
        builder.asp_shown_info = this.gUI;
        return builder.build(false);
    }
}
