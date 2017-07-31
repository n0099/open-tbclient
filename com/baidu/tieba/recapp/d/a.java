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
    private static a fIn;
    private String fIl;
    private String fIm = b.getInstance().getString("asp_shown_info", "");
    private String latitude;
    private String longitude;
    private long vc;

    private a() {
    }

    public static a bii() {
        if (fIn == null) {
            synchronized (c.class) {
                if (fIn == null) {
                    fIn = new a();
                }
            }
        }
        return fIn;
    }

    public void setLongitude(String str) {
        this.longitude = str;
    }

    public void setLatitude(String str) {
        this.latitude = str;
    }

    public void cF(long j) {
        this.vc = j;
    }

    private String bij() {
        if (TextUtils.isEmpty(this.fIl)) {
            WifiInfo connectionInfo = ((WifiManager) TbadkCoreApplication.getInst().getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo != null) {
                this.fIl = connectionInfo.getBSSID();
            } else {
                this.fIl = "";
            }
        }
        return this.fIl;
    }

    public void rg(String str) {
        this.fIl = str;
    }

    public void rh(String str) {
        this.fIm = str;
    }

    public void bik() {
        b.getInstance().putString("asp_shown_info", this.fIm);
    }

    public AppPosInfo bil() {
        AppPosInfo.Builder builder = new AppPosInfo.Builder();
        builder.ap_mac = bij();
        builder.ap_connected = Boolean.valueOf(i.hs());
        builder.latitude = this.latitude;
        builder.longitude = this.longitude;
        builder.addr_timestamp = Long.valueOf(this.vc);
        builder.coordinate_type = BDLocation.BDLOCATION_GCJ02_TO_BD09LL;
        builder.asp_shown_info = this.fIm;
        return builder.build(false);
    }
}
