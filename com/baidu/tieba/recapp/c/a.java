package com.baidu.tieba.recapp.c;

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
    private static a fkX;
    private String fkV;
    private String fkW = b.um().getString("asp_shown_info", "");
    private String latitude;
    private String longitude;
    private long mg;

    private a() {
    }

    public static a beA() {
        if (fkX == null) {
            synchronized (c.class) {
                if (fkX == null) {
                    fkX = new a();
                }
            }
        }
        return fkX;
    }

    public void setLongitude(String str) {
        this.longitude = str;
    }

    public void setLatitude(String str) {
        this.latitude = str;
    }

    public void cT(long j) {
        this.mg = j;
    }

    private String beB() {
        if (TextUtils.isEmpty(this.fkV)) {
            this.fkV = ((WifiManager) TbadkCoreApplication.m9getInst().getSystemService("wifi")).getConnectionInfo().getBSSID();
        }
        return this.fkV;
    }

    public void qV(String str) {
        this.fkV = str;
    }

    public void qW(String str) {
        this.fkW = str;
    }

    public void beC() {
        b.um().putString("asp_shown_info", this.fkW);
    }

    public AppPosInfo beD() {
        AppPosInfo.Builder builder = new AppPosInfo.Builder();
        builder.ap_mac = beB();
        builder.ap_connected = Boolean.valueOf(i.gn());
        builder.latitude = this.latitude;
        builder.longitude = this.longitude;
        builder.addr_timestamp = Long.valueOf(this.mg);
        builder.coordinate_type = BDLocation.BDLOCATION_GCJ02_TO_BD09LL;
        builder.asp_shown_info = this.fkW;
        return builder.build(false);
    }
}
