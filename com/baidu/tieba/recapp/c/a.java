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
    private static a eXX;
    private String eXV;
    private String eXW = b.tQ().getString("asp_shown_info", "");
    private long lZ;
    private String latitude;
    private String longitude;

    private a() {
    }

    public static a bad() {
        if (eXX == null) {
            synchronized (c.class) {
                if (eXX == null) {
                    eXX = new a();
                }
            }
        }
        return eXX;
    }

    public void setLongitude(String str) {
        this.longitude = str;
    }

    public void setLatitude(String str) {
        this.latitude = str;
    }

    public void cu(long j) {
        this.lZ = j;
    }

    private String bae() {
        if (TextUtils.isEmpty(this.eXV)) {
            this.eXV = ((WifiManager) TbadkCoreApplication.m9getInst().getSystemService("wifi")).getConnectionInfo().getBSSID();
        }
        return this.eXV;
    }

    public void pT(String str) {
        this.eXV = str;
    }

    public void pU(String str) {
        this.eXW = str;
    }

    public void baf() {
        b.tQ().putString("asp_shown_info", this.eXW);
    }

    public AppPosInfo bag() {
        AppPosInfo.Builder builder = new AppPosInfo.Builder();
        builder.ap_mac = bae();
        builder.ap_connected = Boolean.valueOf(i.gl());
        builder.latitude = this.latitude;
        builder.longitude = this.longitude;
        builder.addr_timestamp = Long.valueOf(this.lZ);
        builder.coordinate_type = BDLocation.BDLOCATION_GCJ02_TO_BD09LL;
        builder.asp_shown_info = this.eXW;
        return builder.build(false);
    }
}
