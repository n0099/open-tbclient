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
    private static a fbH;
    private String fbF;
    private String fbG = b.tX().getString("asp_shown_info", "");
    private String latitude;
    private String longitude;
    private long ty;

    private a() {
    }

    public static a aYU() {
        if (fbH == null) {
            synchronized (d.class) {
                if (fbH == null) {
                    fbH = new a();
                }
            }
        }
        return fbH;
    }

    public void setLongitude(String str) {
        this.longitude = str;
    }

    public void setLatitude(String str) {
        this.latitude = str;
    }

    public void ch(long j) {
        this.ty = j;
    }

    private String aYV() {
        if (TextUtils.isEmpty(this.fbF)) {
            WifiInfo connectionInfo = ((WifiManager) TbadkCoreApplication.m9getInst().getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo != null) {
                this.fbF = connectionInfo.getBSSID();
            } else {
                this.fbF = "";
            }
        }
        return this.fbF;
    }

    public void pq(String str) {
        this.fbF = str;
    }

    public void pr(String str) {
        this.fbG = str;
    }

    public void aYW() {
        b.tX().putString("asp_shown_info", this.fbG);
    }

    public AppPosInfo aYX() {
        AppPosInfo.Builder builder = new AppPosInfo.Builder();
        builder.ap_mac = aYV();
        builder.ap_connected = Boolean.valueOf(i.hl());
        builder.latitude = this.latitude;
        builder.longitude = this.longitude;
        builder.addr_timestamp = Long.valueOf(this.ty);
        builder.coordinate_type = BDLocation.BDLOCATION_GCJ02_TO_BD09LL;
        builder.asp_shown_info = this.fbG;
        return builder.build(false);
    }
}
