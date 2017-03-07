package com.baidu.tieba.recapp.c;

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
    private static a fcb;
    private String fbZ;
    private String fca = b.uo().getString("asp_shown_info", "");
    private String latitude;
    private String longitude;
    private long tU;

    private a() {
    }

    public static a aZL() {
        if (fcb == null) {
            synchronized (c.class) {
                if (fcb == null) {
                    fcb = new a();
                }
            }
        }
        return fcb;
    }

    public void setLongitude(String str) {
        this.longitude = str;
    }

    public void setLatitude(String str) {
        this.latitude = str;
    }

    public void cw(long j) {
        this.tU = j;
    }

    private String aZM() {
        if (TextUtils.isEmpty(this.fbZ)) {
            WifiInfo connectionInfo = ((WifiManager) TbadkCoreApplication.m9getInst().getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo != null) {
                this.fbZ = connectionInfo.getBSSID();
            } else {
                this.fbZ = "";
            }
        }
        return this.fbZ;
    }

    public void pc(String str) {
        this.fbZ = str;
    }

    public void pd(String str) {
        this.fca = str;
    }

    public void aZN() {
        b.uo().putString("asp_shown_info", this.fca);
    }

    public AppPosInfo aZO() {
        AppPosInfo.Builder builder = new AppPosInfo.Builder();
        builder.ap_mac = aZM();
        builder.ap_connected = Boolean.valueOf(i.hf());
        builder.latitude = this.latitude;
        builder.longitude = this.longitude;
        builder.addr_timestamp = Long.valueOf(this.tU);
        builder.coordinate_type = BDLocation.BDLOCATION_GCJ02_TO_BD09LL;
        builder.asp_shown_info = this.fca;
        return builder.build(false);
    }
}
