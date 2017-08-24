package com.baidu.tieba.recapp.d;

import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.baidu.adp.lib.util.i;
import com.baidu.location.BDLocation;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tieba.tbadkCore.location.c;
import tbclient.AppPosInfo;
/* loaded from: classes.dex */
public class a {
    private static a fKj;
    private String fKh;
    private String fKi = b.getInstance().getString("asp_shown_info", "");
    private String latitude;
    private String longitude;
    private long ve;

    private a() {
    }

    public static a biJ() {
        if (fKj == null) {
            synchronized (c.class) {
                if (fKj == null) {
                    fKj = new a();
                }
            }
        }
        return fKj;
    }

    public void lQ(String str) {
        this.longitude = str;
    }

    public void lR(String str) {
        this.latitude = str;
    }

    public void cF(long j) {
        this.ve = j;
    }

    private String biK() {
        if (TextUtils.isEmpty(this.fKh)) {
            WifiInfo connectionInfo = ((WifiManager) TbadkCoreApplication.getInst().getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo != null) {
                this.fKh = connectionInfo.getBSSID();
            } else {
                this.fKh = "";
            }
        }
        return this.fKh;
    }

    public void rn(String str) {
        this.fKh = str;
    }

    public void ro(String str) {
        this.fKi = str;
    }

    public void biL() {
        b.getInstance().putString("asp_shown_info", this.fKi);
    }

    public AppPosInfo biM() {
        AppPosInfo.Builder builder = new AppPosInfo.Builder();
        builder.ap_mac = biK();
        builder.ap_connected = Boolean.valueOf(i.hs());
        builder.latitude = this.latitude;
        builder.longitude = this.longitude;
        builder.addr_timestamp = Long.valueOf(this.ve);
        builder.coordinate_type = BDLocation.BDLOCATION_GCJ02_TO_BD09LL;
        builder.asp_shown_info = this.fKi;
        return builder.build(false);
    }
}
