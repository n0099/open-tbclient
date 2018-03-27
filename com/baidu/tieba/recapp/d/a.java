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
    private static a gHc;
    private long ahe;
    private String gHa;
    private String gHb = b.getInstance().getString("asp_shown_info", "");
    private String latitude;
    private String longitude;

    private a() {
    }

    public static a boS() {
        if (gHc == null) {
            synchronized (c.class) {
                if (gHc == null) {
                    gHc = new a();
                }
            }
        }
        return gHc;
    }

    public void mU(String str) {
        this.longitude = str;
    }

    public void mV(String str) {
        this.latitude = str;
    }

    public void cM(long j) {
        this.ahe = j;
    }

    private String boT() {
        if (TextUtils.isEmpty(this.gHa)) {
            WifiInfo connectionInfo = ((WifiManager) TbadkCoreApplication.getInst().getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo != null) {
                this.gHa = connectionInfo.getBSSID();
            } else {
                this.gHa = "";
            }
        }
        return this.gHa;
    }

    public void rU(String str) {
        this.gHa = str;
    }

    public void rV(String str) {
        this.gHb = str;
    }

    public void boU() {
        b.getInstance().putString("asp_shown_info", this.gHb);
    }

    public AppPosInfo boV() {
        AppPosInfo.Builder builder = new AppPosInfo.Builder();
        builder.ap_mac = boT();
        builder.ap_connected = Boolean.valueOf(j.oK());
        builder.latitude = this.latitude;
        builder.longitude = this.longitude;
        builder.addr_timestamp = Long.valueOf(this.ahe);
        builder.coordinate_type = BDLocation.BDLOCATION_GCJ02_TO_BD09LL;
        builder.asp_shown_info = this.gHb;
        return builder.build(false);
    }
}
