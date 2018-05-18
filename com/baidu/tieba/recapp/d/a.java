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
    private static a gdc;
    private String gda;
    private String gdb = b.getInstance().getString("asp_shown_info", "");
    private String latitude;
    private String longitude;
    private long ry;

    private a() {
    }

    public static a bjY() {
        if (gdc == null) {
            synchronized (c.class) {
                if (gdc == null) {
                    gdc = new a();
                }
            }
        }
        return gdc;
    }

    public void nb(String str) {
        this.longitude = str;
    }

    public void nc(String str) {
        this.latitude = str;
    }

    public void cQ(long j) {
        this.ry = j;
    }

    private String bjZ() {
        if (TextUtils.isEmpty(this.gda)) {
            WifiInfo connectionInfo = ((WifiManager) TbadkCoreApplication.getInst().getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo != null) {
                this.gda = connectionInfo.getBSSID();
            } else {
                this.gda = "";
            }
        }
        return this.gda;
    }

    public void se(String str) {
        this.gda = str;
    }

    public void sf(String str) {
        this.gdb = str;
    }

    public void bka() {
        b.getInstance().putString("asp_shown_info", this.gdb);
    }

    public AppPosInfo bkb() {
        AppPosInfo.Builder builder = new AppPosInfo.Builder();
        builder.ap_mac = bjZ();
        builder.ap_connected = Boolean.valueOf(j.gQ());
        builder.latitude = this.latitude;
        builder.longitude = this.longitude;
        builder.addr_timestamp = Long.valueOf(this.ry);
        builder.coordinate_type = BDLocation.BDLOCATION_GCJ02_TO_BD09LL;
        builder.asp_shown_info = this.gdb;
        return builder.build(false);
    }
}
