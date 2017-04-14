package com.baidu.tieba.recapp.d;

import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.baidu.adp.lib.util.i;
import com.baidu.location.BDLocation;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tieba.tbadkCore.location.d;
import tbclient.AppPosInfo;
/* loaded from: classes.dex */
public class a {
    private static a fdx;
    private String fdv;
    private String fdw = b.uL().getString("asp_shown_info", "");
    private String latitude;
    private String longitude;
    private long ts;

    private a() {
    }

    public static a bau() {
        if (fdx == null) {
            synchronized (d.class) {
                if (fdx == null) {
                    fdx = new a();
                }
            }
        }
        return fdx;
    }

    public void setLongitude(String str) {
        this.longitude = str;
    }

    public void setLatitude(String str) {
        this.latitude = str;
    }

    public void cw(long j) {
        this.ts = j;
    }

    private String bav() {
        if (TextUtils.isEmpty(this.fdv)) {
            WifiInfo connectionInfo = ((WifiManager) TbadkCoreApplication.m9getInst().getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo != null) {
                this.fdv = connectionInfo.getBSSID();
            } else {
                this.fdv = "";
            }
        }
        return this.fdv;
    }

    public void pr(String str) {
        this.fdv = str;
    }

    public void ps(String str) {
        this.fdw = str;
    }

    public void baw() {
        b.uL().putString("asp_shown_info", this.fdw);
    }

    public AppPosInfo bax() {
        AppPosInfo.Builder builder = new AppPosInfo.Builder();
        builder.ap_mac = bav();
        builder.ap_connected = Boolean.valueOf(i.hk());
        builder.latitude = this.latitude;
        builder.longitude = this.longitude;
        builder.addr_timestamp = Long.valueOf(this.ts);
        builder.coordinate_type = BDLocation.BDLOCATION_GCJ02_TO_BD09LL;
        builder.asp_shown_info = this.fdw;
        return builder.build(false);
    }
}
