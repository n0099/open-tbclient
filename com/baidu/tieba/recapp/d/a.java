package com.baidu.tieba.recapp.d;

import android.net.wifi.WifiInfo;
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
    private static a fHb;
    private String fGZ;
    private String fHa = b.getInstance().getString("asp_shown_info", "");
    private String latitude;
    private String longitude;
    private long ty;

    private a() {
    }

    public static a bhY() {
        if (fHb == null) {
            synchronized (c.class) {
                if (fHb == null) {
                    fHb = new a();
                }
            }
        }
        return fHb;
    }

    public void setLongitude(String str) {
        this.longitude = str;
    }

    public void setLatitude(String str) {
        this.latitude = str;
    }

    public void cF(long j) {
        this.ty = j;
    }

    private String bhZ() {
        if (TextUtils.isEmpty(this.fGZ)) {
            WifiInfo connectionInfo = ((WifiManager) TbadkCoreApplication.getInst().getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo != null) {
                this.fGZ = connectionInfo.getBSSID();
            } else {
                this.fGZ = "";
            }
        }
        return this.fGZ;
    }

    public void rb(String str) {
        this.fGZ = str;
    }

    public void rc(String str) {
        this.fHa = str;
    }

    public void bia() {
        b.getInstance().putString("asp_shown_info", this.fHa);
    }

    public AppPosInfo bib() {
        AppPosInfo.Builder builder = new AppPosInfo.Builder();
        builder.ap_mac = bhZ();
        builder.ap_connected = Boolean.valueOf(i.hi());
        builder.latitude = this.latitude;
        builder.longitude = this.longitude;
        builder.addr_timestamp = Long.valueOf(this.ty);
        builder.coordinate_type = BDLocation.BDLOCATION_GCJ02_TO_BD09LL;
        builder.asp_shown_info = this.fHa;
        return builder.build(false);
    }
}
