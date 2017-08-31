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
    private static a fIj;
    private String fIh;
    private String fIi = b.getInstance().getString("asp_shown_info", "");
    private String latitude;
    private String longitude;
    private long sQ;

    private a() {
    }

    public static a bhI() {
        if (fIj == null) {
            synchronized (c.class) {
                if (fIj == null) {
                    fIj = new a();
                }
            }
        }
        return fIj;
    }

    public void mh(String str) {
        this.longitude = str;
    }

    public void mi(String str) {
        this.latitude = str;
    }

    public void cA(long j) {
        this.sQ = j;
    }

    private String bhJ() {
        if (TextUtils.isEmpty(this.fIh)) {
            WifiInfo connectionInfo = ((WifiManager) TbadkCoreApplication.getInst().getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo != null) {
                this.fIh = connectionInfo.getBSSID();
            } else {
                this.fIh = "";
            }
        }
        return this.fIh;
    }

    public void rb(String str) {
        this.fIh = str;
    }

    public void rc(String str) {
        this.fIi = str;
    }

    public void bhK() {
        b.getInstance().putString("asp_shown_info", this.fIi);
    }

    public AppPosInfo bhL() {
        AppPosInfo.Builder builder = new AppPosInfo.Builder();
        builder.ap_mac = bhJ();
        builder.ap_connected = Boolean.valueOf(i.hj());
        builder.latitude = this.latitude;
        builder.longitude = this.longitude;
        builder.addr_timestamp = Long.valueOf(this.sQ);
        builder.coordinate_type = BDLocation.BDLOCATION_GCJ02_TO_BD09LL;
        builder.asp_shown_info = this.fIi;
        return builder.build(false);
    }
}
