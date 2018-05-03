package com.baidu.tieba.recapp.d;

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
    private static a gbW;
    private String gbU;
    private String gbV = b.getInstance().getString("asp_shown_info", "");
    private String latitude;
    private String longitude;
    private long rz;

    private a() {
    }

    public static a bjZ() {
        if (gbW == null) {
            synchronized (c.class) {
                if (gbW == null) {
                    gbW = new a();
                }
            }
        }
        return gbW;
    }

    public void mY(String str) {
        this.longitude = str;
    }

    public void mZ(String str) {
        this.latitude = str;
    }

    public void cQ(long j) {
        this.rz = j;
    }

    private String bka() {
        if (TextUtils.isEmpty(this.gbU)) {
            WifiInfo connectionInfo = ((WifiManager) TbadkCoreApplication.getInst().getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo != null) {
                this.gbU = connectionInfo.getBSSID();
            } else {
                this.gbU = "";
            }
        }
        return this.gbU;
    }

    public void sb(String str) {
        this.gbU = str;
    }

    public void sc(String str) {
        this.gbV = str;
    }

    public void bkb() {
        b.getInstance().putString("asp_shown_info", this.gbV);
    }

    public AppPosInfo bkc() {
        AppPosInfo.Builder builder = new AppPosInfo.Builder();
        builder.ap_mac = bka();
        builder.ap_connected = Boolean.valueOf(j.gQ());
        builder.latitude = this.latitude;
        builder.longitude = this.longitude;
        builder.addr_timestamp = Long.valueOf(this.rz);
        builder.coordinate_type = BDLocation.BDLOCATION_GCJ02_TO_BD09LL;
        builder.asp_shown_info = this.gbV;
        return builder.build(false);
    }
}
