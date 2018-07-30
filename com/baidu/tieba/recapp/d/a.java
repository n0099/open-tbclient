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
    private static a gtx;
    private String gtv;
    private String gtw = b.getInstance().getString("asp_shown_info", "");
    private String latitude;
    private String longitude;
    private long xD;

    private a() {
    }

    public static a bod() {
        if (gtx == null) {
            synchronized (c.class) {
                if (gtx == null) {
                    gtx = new a();
                }
            }
        }
        return gtx;
    }

    public void nQ(String str) {
        this.longitude = str;
    }

    public void nR(String str) {
        this.latitude = str;
    }

    public void cO(long j) {
        this.xD = j;
    }

    private String boe() {
        if (TextUtils.isEmpty(this.gtv)) {
            WifiInfo connectionInfo = ((WifiManager) TbadkCoreApplication.getInst().getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo != null) {
                this.gtv = connectionInfo.getBSSID();
            } else {
                this.gtv = "";
            }
        }
        return this.gtv;
    }

    public void sR(String str) {
        this.gtv = str;
    }

    public void sS(String str) {
        this.gtw = str;
    }

    public void bof() {
        b.getInstance().putString("asp_shown_info", this.gtw);
    }

    public AppPosInfo bog() {
        AppPosInfo.Builder builder = new AppPosInfo.Builder();
        builder.ap_mac = boe();
        builder.ap_connected = Boolean.valueOf(j.jF());
        builder.latitude = this.latitude;
        builder.longitude = this.longitude;
        builder.addr_timestamp = Long.valueOf(this.xD);
        builder.coordinate_type = BDLocation.BDLOCATION_GCJ02_TO_BD09LL;
        builder.asp_shown_info = this.gtw;
        return builder.build(false);
    }
}
