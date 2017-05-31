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
    private static a fjL;
    private String fjJ;
    private String fjK = b.getInstance().getString("asp_shown_info", "");
    private String latitude;
    private String longitude;
    private long ty;

    private a() {
    }

    public static a ban() {
        if (fjL == null) {
            synchronized (d.class) {
                if (fjL == null) {
                    fjL = new a();
                }
            }
        }
        return fjL;
    }

    public void setLongitude(String str) {
        this.longitude = str;
    }

    public void setLatitude(String str) {
        this.latitude = str;
    }

    public void cm(long j) {
        this.ty = j;
    }

    private String bao() {
        if (TextUtils.isEmpty(this.fjJ)) {
            WifiInfo connectionInfo = ((WifiManager) TbadkCoreApplication.m9getInst().getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo != null) {
                this.fjJ = connectionInfo.getBSSID();
            } else {
                this.fjJ = "";
            }
        }
        return this.fjJ;
    }

    public void pF(String str) {
        this.fjJ = str;
    }

    public void pG(String str) {
        this.fjK = str;
    }

    public void bap() {
        b.getInstance().putString("asp_shown_info", this.fjK);
    }

    public AppPosInfo baq() {
        AppPosInfo.Builder builder = new AppPosInfo.Builder();
        builder.ap_mac = bao();
        builder.ap_connected = Boolean.valueOf(i.hl());
        builder.latitude = this.latitude;
        builder.longitude = this.longitude;
        builder.addr_timestamp = Long.valueOf(this.ty);
        builder.coordinate_type = BDLocation.BDLOCATION_GCJ02_TO_BD09LL;
        builder.asp_shown_info = this.fjK;
        return builder.build(false);
    }
}
