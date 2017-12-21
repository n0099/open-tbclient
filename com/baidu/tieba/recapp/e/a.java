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
    private static a gbo;
    private String gbm;
    private String gbn = b.getInstance().getString("asp_shown_info", "");
    private String latitude;
    private String longitude;
    private long sP;

    private a() {
    }

    public static a bmw() {
        if (gbo == null) {
            synchronized (c.class) {
                if (gbo == null) {
                    gbo = new a();
                }
            }
        }
        return gbo;
    }

    public void mt(String str) {
        this.longitude = str;
    }

    public void mu(String str) {
        this.latitude = str;
    }

    public void cK(long j) {
        this.sP = j;
    }

    private String bmx() {
        if (TextUtils.isEmpty(this.gbm)) {
            WifiInfo connectionInfo = ((WifiManager) TbadkCoreApplication.getInst().getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo != null) {
                this.gbm = connectionInfo.getBSSID();
            } else {
                this.gbm = "";
            }
        }
        return this.gbm;
    }

    public void rZ(String str) {
        this.gbm = str;
    }

    public void sa(String str) {
        this.gbn = str;
    }

    public void bmy() {
        b.getInstance().putString("asp_shown_info", this.gbn);
    }

    public AppPosInfo bmz() {
        AppPosInfo.Builder builder = new AppPosInfo.Builder();
        builder.ap_mac = bmx();
        builder.ap_connected = Boolean.valueOf(j.hi());
        builder.latitude = this.latitude;
        builder.longitude = this.longitude;
        builder.addr_timestamp = Long.valueOf(this.sP);
        builder.coordinate_type = BDLocation.BDLOCATION_GCJ02_TO_BD09LL;
        builder.asp_shown_info = this.gbn;
        return builder.build(false);
    }
}
