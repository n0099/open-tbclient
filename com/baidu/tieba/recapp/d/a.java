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
    private static a fJc;
    private String fJa;
    private String fJb = b.getInstance().getString("asp_shown_info", "");
    private String latitude;
    private String longitude;
    private long sQ;

    private a() {
    }

    public static a bhT() {
        if (fJc == null) {
            synchronized (c.class) {
                if (fJc == null) {
                    fJc = new a();
                }
            }
        }
        return fJc;
    }

    public void mj(String str) {
        this.longitude = str;
    }

    public void mk(String str) {
        this.latitude = str;
    }

    public void cA(long j) {
        this.sQ = j;
    }

    private String bhU() {
        if (TextUtils.isEmpty(this.fJa)) {
            WifiInfo connectionInfo = ((WifiManager) TbadkCoreApplication.getInst().getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo != null) {
                this.fJa = connectionInfo.getBSSID();
            } else {
                this.fJa = "";
            }
        }
        return this.fJa;
    }

    public void rd(String str) {
        this.fJa = str;
    }

    public void re(String str) {
        this.fJb = str;
    }

    public void bhV() {
        b.getInstance().putString("asp_shown_info", this.fJb);
    }

    public AppPosInfo bhW() {
        AppPosInfo.Builder builder = new AppPosInfo.Builder();
        builder.ap_mac = bhU();
        builder.ap_connected = Boolean.valueOf(i.hj());
        builder.latitude = this.latitude;
        builder.longitude = this.longitude;
        builder.addr_timestamp = Long.valueOf(this.sQ);
        builder.coordinate_type = BDLocation.BDLOCATION_GCJ02_TO_BD09LL;
        builder.asp_shown_info = this.fJb;
        return builder.build(false);
    }
}
