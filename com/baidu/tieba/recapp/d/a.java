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
    private static a fFM;
    private String fFK;
    private String fFL = b.getInstance().getString("asp_shown_info", "");
    private String latitude;
    private String longitude;
    private long sQ;

    private a() {
    }

    public static a bgz() {
        if (fFM == null) {
            synchronized (c.class) {
                if (fFM == null) {
                    fFM = new a();
                }
            }
        }
        return fFM;
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

    private String bgA() {
        if (TextUtils.isEmpty(this.fFK)) {
            WifiInfo connectionInfo = ((WifiManager) TbadkCoreApplication.getInst().getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo != null) {
                this.fFK = connectionInfo.getBSSID();
            } else {
                this.fFK = "";
            }
        }
        return this.fFK;
    }

    public void qN(String str) {
        this.fFK = str;
    }

    public void qO(String str) {
        this.fFL = str;
    }

    public void bgB() {
        b.getInstance().putString("asp_shown_info", this.fFL);
    }

    public AppPosInfo bgC() {
        AppPosInfo.Builder builder = new AppPosInfo.Builder();
        builder.ap_mac = bgA();
        builder.ap_connected = Boolean.valueOf(j.hi());
        builder.latitude = this.latitude;
        builder.longitude = this.longitude;
        builder.addr_timestamp = Long.valueOf(this.sQ);
        builder.coordinate_type = BDLocation.BDLOCATION_GCJ02_TO_BD09LL;
        builder.asp_shown_info = this.fFL;
        return builder.build(false);
    }
}
