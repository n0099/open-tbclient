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
    private static a gsl;
    private String gsj;
    private String gsk = b.getInstance().getString("asp_shown_info", "");
    private String latitude;
    private String longitude;
    private long xJ;

    private a() {
    }

    public static a bpy() {
        if (gsl == null) {
            synchronized (c.class) {
                if (gsl == null) {
                    gsl = new a();
                }
            }
        }
        return gsl;
    }

    public void nO(String str) {
        this.longitude = str;
    }

    public void nP(String str) {
        this.latitude = str;
    }

    public void cR(long j) {
        this.xJ = j;
    }

    private String bpz() {
        if (TextUtils.isEmpty(this.gsj)) {
            WifiInfo connectionInfo = ((WifiManager) TbadkCoreApplication.getInst().getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo != null) {
                this.gsj = connectionInfo.getBSSID();
            } else {
                this.gsj = "";
            }
        }
        return this.gsj;
    }

    public void sV(String str) {
        this.gsj = str;
    }

    public void sW(String str) {
        this.gsk = str;
    }

    public void bpA() {
        b.getInstance().putString("asp_shown_info", this.gsk);
    }

    public AppPosInfo bpB() {
        AppPosInfo.Builder builder = new AppPosInfo.Builder();
        builder.ap_mac = bpz();
        builder.ap_connected = Boolean.valueOf(j.jE());
        builder.latitude = this.latitude;
        builder.longitude = this.longitude;
        builder.addr_timestamp = Long.valueOf(this.xJ);
        builder.coordinate_type = BDLocation.BDLOCATION_GCJ02_TO_BD09LL;
        builder.asp_shown_info = this.gsk;
        return builder.build(false);
    }
}
