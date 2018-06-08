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
    private static a gou;
    private String gos;
    private String got = b.getInstance().getString("asp_shown_info", "");
    private String latitude;
    private String longitude;
    private long xL;

    private a() {
    }

    public static a boX() {
        if (gou == null) {
            synchronized (c.class) {
                if (gou == null) {
                    gou = new a();
                }
            }
        }
        return gou;
    }

    public void nN(String str) {
        this.longitude = str;
    }

    public void nO(String str) {
        this.latitude = str;
    }

    public void cW(long j) {
        this.xL = j;
    }

    private String boY() {
        if (TextUtils.isEmpty(this.gos)) {
            WifiInfo connectionInfo = ((WifiManager) TbadkCoreApplication.getInst().getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo != null) {
                this.gos = connectionInfo.getBSSID();
            } else {
                this.gos = "";
            }
        }
        return this.gos;
    }

    public void sW(String str) {
        this.gos = str;
    }

    public void sX(String str) {
        this.got = str;
    }

    public void boZ() {
        b.getInstance().putString("asp_shown_info", this.got);
    }

    public AppPosInfo bpa() {
        AppPosInfo.Builder builder = new AppPosInfo.Builder();
        builder.ap_mac = boY();
        builder.ap_connected = Boolean.valueOf(j.jE());
        builder.latitude = this.latitude;
        builder.longitude = this.longitude;
        builder.addr_timestamp = Long.valueOf(this.xL);
        builder.coordinate_type = BDLocation.BDLOCATION_GCJ02_TO_BD09LL;
        builder.asp_shown_info = this.got;
        return builder.build(false);
    }
}
