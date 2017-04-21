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
    private static a ffO;
    private String ffM;
    private String ffN = b.uL().getString("asp_shown_info", "");
    private String latitude;
    private String longitude;
    private long tx;

    private a() {
    }

    public static a bbv() {
        if (ffO == null) {
            synchronized (d.class) {
                if (ffO == null) {
                    ffO = new a();
                }
            }
        }
        return ffO;
    }

    public void setLongitude(String str) {
        this.longitude = str;
    }

    public void setLatitude(String str) {
        this.latitude = str;
    }

    public void cw(long j) {
        this.tx = j;
    }

    private String bbw() {
        if (TextUtils.isEmpty(this.ffM)) {
            WifiInfo connectionInfo = ((WifiManager) TbadkCoreApplication.m9getInst().getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo != null) {
                this.ffM = connectionInfo.getBSSID();
            } else {
                this.ffM = "";
            }
        }
        return this.ffM;
    }

    public void ps(String str) {
        this.ffM = str;
    }

    public void pt(String str) {
        this.ffN = str;
    }

    public void bbx() {
        b.uL().putString("asp_shown_info", this.ffN);
    }

    public AppPosInfo bby() {
        AppPosInfo.Builder builder = new AppPosInfo.Builder();
        builder.ap_mac = bbw();
        builder.ap_connected = Boolean.valueOf(i.hl());
        builder.latitude = this.latitude;
        builder.longitude = this.longitude;
        builder.addr_timestamp = Long.valueOf(this.tx);
        builder.coordinate_type = BDLocation.BDLOCATION_GCJ02_TO_BD09LL;
        builder.asp_shown_info = this.ffN;
        return builder.build(false);
    }
}
