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
    private static a fKh;
    private String fKf;
    private String fKg = b.getInstance().getString("asp_shown_info", "");
    private String latitude;
    private String longitude;
    private long ve;

    private a() {
    }

    public static a biO() {
        if (fKh == null) {
            synchronized (c.class) {
                if (fKh == null) {
                    fKh = new a();
                }
            }
        }
        return fKh;
    }

    public void setLongitude(String str) {
        this.longitude = str;
    }

    public void setLatitude(String str) {
        this.latitude = str;
    }

    public void cF(long j) {
        this.ve = j;
    }

    private String biP() {
        if (TextUtils.isEmpty(this.fKf)) {
            WifiInfo connectionInfo = ((WifiManager) TbadkCoreApplication.getInst().getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo != null) {
                this.fKf = connectionInfo.getBSSID();
            } else {
                this.fKf = "";
            }
        }
        return this.fKf;
    }

    public void ri(String str) {
        this.fKf = str;
    }

    public void rj(String str) {
        this.fKg = str;
    }

    public void biQ() {
        b.getInstance().putString("asp_shown_info", this.fKg);
    }

    public AppPosInfo biR() {
        AppPosInfo.Builder builder = new AppPosInfo.Builder();
        builder.ap_mac = biP();
        builder.ap_connected = Boolean.valueOf(i.hs());
        builder.latitude = this.latitude;
        builder.longitude = this.longitude;
        builder.addr_timestamp = Long.valueOf(this.ve);
        builder.coordinate_type = BDLocation.BDLOCATION_GCJ02_TO_BD09LL;
        builder.asp_shown_info = this.fKg;
        return builder.build(false);
    }
}
