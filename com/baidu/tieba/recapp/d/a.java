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
    private static a gtA;
    private String gty;
    private String gtz = b.getInstance().getString("asp_shown_info", "");
    private String latitude;
    private String longitude;
    private long xE;

    private a() {
    }

    public static a boe() {
        if (gtA == null) {
            synchronized (c.class) {
                if (gtA == null) {
                    gtA = new a();
                }
            }
        }
        return gtA;
    }

    public void nS(String str) {
        this.longitude = str;
    }

    public void nT(String str) {
        this.latitude = str;
    }

    public void cO(long j) {
        this.xE = j;
    }

    private String bof() {
        if (TextUtils.isEmpty(this.gty)) {
            WifiInfo connectionInfo = ((WifiManager) TbadkCoreApplication.getInst().getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo != null) {
                this.gty = connectionInfo.getBSSID();
            } else {
                this.gty = "";
            }
        }
        return this.gty;
    }

    public void sV(String str) {
        this.gty = str;
    }

    public void sW(String str) {
        this.gtz = str;
    }

    public void bog() {
        b.getInstance().putString("asp_shown_info", this.gtz);
    }

    public AppPosInfo boh() {
        AppPosInfo.Builder builder = new AppPosInfo.Builder();
        builder.ap_mac = bof();
        builder.ap_connected = Boolean.valueOf(j.jF());
        builder.latitude = this.latitude;
        builder.longitude = this.longitude;
        builder.addr_timestamp = Long.valueOf(this.xE);
        builder.coordinate_type = BDLocation.BDLOCATION_GCJ02_TO_BD09LL;
        builder.asp_shown_info = this.gtz;
        return builder.build(false);
    }
}
