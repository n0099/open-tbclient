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
    private static a gJV;
    private long AJ;
    private String gJT;
    private String gJU = b.getInstance().getString("asp_shown_info", "");
    private String latitude;
    private String longitude;

    private a() {
    }

    public static a btw() {
        if (gJV == null) {
            synchronized (c.class) {
                if (gJV == null) {
                    gJV = new a();
                }
            }
        }
        return gJV;
    }

    public void pc(String str) {
        this.longitude = str;
    }

    public void pd(String str) {
        this.latitude = str;
    }

    public void cU(long j) {
        this.AJ = j;
    }

    private String btx() {
        if (TextUtils.isEmpty(this.gJT)) {
            WifiInfo connectionInfo = ((WifiManager) TbadkCoreApplication.getInst().getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo != null) {
                this.gJT = connectionInfo.getBSSID();
            } else {
                this.gJT = "";
            }
        }
        return this.gJT;
    }

    public void ui(String str) {
        this.gJT = str;
    }

    public void uj(String str) {
        this.gJU = str;
    }

    public void bty() {
        b.getInstance().putString("asp_shown_info", this.gJU);
    }

    public AppPosInfo btz() {
        AppPosInfo.Builder builder = new AppPosInfo.Builder();
        builder.ap_mac = btx();
        builder.ap_connected = Boolean.valueOf(j.kW());
        builder.latitude = this.latitude;
        builder.longitude = this.longitude;
        builder.addr_timestamp = Long.valueOf(this.AJ);
        builder.coordinate_type = "bd09ll";
        builder.asp_shown_info = this.gJU;
        return builder.build(false);
    }
}
