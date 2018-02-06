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
    private static a gHb;
    private long ahk;
    private String gGZ;
    private String gHa = b.getInstance().getString("asp_shown_info", "");
    private String latitude;
    private String longitude;

    private a() {
    }

    public static a boS() {
        if (gHb == null) {
            synchronized (c.class) {
                if (gHb == null) {
                    gHb = new a();
                }
            }
        }
        return gHb;
    }

    public void mU(String str) {
        this.longitude = str;
    }

    public void mV(String str) {
        this.latitude = str;
    }

    public void cM(long j) {
        this.ahk = j;
    }

    private String boT() {
        if (TextUtils.isEmpty(this.gGZ)) {
            WifiInfo connectionInfo = ((WifiManager) TbadkCoreApplication.getInst().getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo != null) {
                this.gGZ = connectionInfo.getBSSID();
            } else {
                this.gGZ = "";
            }
        }
        return this.gGZ;
    }

    public void rU(String str) {
        this.gGZ = str;
    }

    public void rV(String str) {
        this.gHa = str;
    }

    public void boU() {
        b.getInstance().putString("asp_shown_info", this.gHa);
    }

    public AppPosInfo boV() {
        AppPosInfo.Builder builder = new AppPosInfo.Builder();
        builder.ap_mac = boT();
        builder.ap_connected = Boolean.valueOf(j.oK());
        builder.latitude = this.latitude;
        builder.longitude = this.longitude;
        builder.addr_timestamp = Long.valueOf(this.ahk);
        builder.coordinate_type = BDLocation.BDLOCATION_GCJ02_TO_BD09LL;
        builder.asp_shown_info = this.gHa;
        return builder.build(false);
    }
}
