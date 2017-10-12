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
    private static a fFL;
    private String fFJ;
    private String fFK = b.getInstance().getString("asp_shown_info", "");
    private String latitude;
    private String longitude;
    private long sQ;

    private a() {
    }

    public static a bgy() {
        if (fFL == null) {
            synchronized (c.class) {
                if (fFL == null) {
                    fFL = new a();
                }
            }
        }
        return fFL;
    }

    public void lN(String str) {
        this.longitude = str;
    }

    public void lO(String str) {
        this.latitude = str;
    }

    public void cy(long j) {
        this.sQ = j;
    }

    private String bgz() {
        if (TextUtils.isEmpty(this.fFJ)) {
            WifiInfo connectionInfo = ((WifiManager) TbadkCoreApplication.getInst().getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo != null) {
                this.fFJ = connectionInfo.getBSSID();
            } else {
                this.fFJ = "";
            }
        }
        return this.fFJ;
    }

    public void qN(String str) {
        this.fFJ = str;
    }

    public void qO(String str) {
        this.fFK = str;
    }

    public void bgA() {
        b.getInstance().putString("asp_shown_info", this.fFK);
    }

    public AppPosInfo bgB() {
        AppPosInfo.Builder builder = new AppPosInfo.Builder();
        builder.ap_mac = bgz();
        builder.ap_connected = Boolean.valueOf(j.hi());
        builder.latitude = this.latitude;
        builder.longitude = this.longitude;
        builder.addr_timestamp = Long.valueOf(this.sQ);
        builder.coordinate_type = BDLocation.BDLOCATION_GCJ02_TO_BD09LL;
        builder.asp_shown_info = this.fFK;
        return builder.build(false);
    }
}
