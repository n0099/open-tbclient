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
    private static a gGM;
    private long ahe;
    private String gGK;
    private String gGL = b.getInstance().getString("asp_shown_info", "");
    private String latitude;
    private String longitude;

    private a() {
    }

    public static a boR() {
        if (gGM == null) {
            synchronized (c.class) {
                if (gGM == null) {
                    gGM = new a();
                }
            }
        }
        return gGM;
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

    private String boS() {
        if (TextUtils.isEmpty(this.gGK)) {
            WifiInfo connectionInfo = ((WifiManager) TbadkCoreApplication.getInst().getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo != null) {
                this.gGK = connectionInfo.getBSSID();
            } else {
                this.gGK = "";
            }
        }
        return this.gGK;
    }

    public void rU(String str) {
        this.gGK = str;
    }

    public void rV(String str) {
        this.gGL = str;
    }

    public void boT() {
        b.getInstance().putString("asp_shown_info", this.gGL);
    }

    public AppPosInfo boU() {
        AppPosInfo.Builder builder = new AppPosInfo.Builder();
        builder.ap_mac = boS();
        builder.ap_connected = Boolean.valueOf(j.oK());
        builder.latitude = this.latitude;
        builder.longitude = this.longitude;
        builder.addr_timestamp = Long.valueOf(this.ahe);
        builder.coordinate_type = BDLocation.BDLOCATION_GCJ02_TO_BD09LL;
        builder.asp_shown_info = this.gGL;
        return builder.build(false);
    }
}
