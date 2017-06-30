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
    private static a fub;
    private String ftZ;
    private String fua = b.getInstance().getString("asp_shown_info", "");
    private String latitude;
    private String longitude;
    private long tx;

    private a() {
    }

    public static a bex() {
        if (fub == null) {
            synchronized (d.class) {
                if (fub == null) {
                    fub = new a();
                }
            }
        }
        return fub;
    }

    public void setLongitude(String str) {
        this.longitude = str;
    }

    public void setLatitude(String str) {
        this.latitude = str;
    }

    public void cB(long j) {
        this.tx = j;
    }

    private String bey() {
        if (TextUtils.isEmpty(this.ftZ)) {
            WifiInfo connectionInfo = ((WifiManager) TbadkCoreApplication.m9getInst().getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo != null) {
                this.ftZ = connectionInfo.getBSSID();
            } else {
                this.ftZ = "";
            }
        }
        return this.ftZ;
    }

    public void qC(String str) {
        this.ftZ = str;
    }

    public void qD(String str) {
        this.fua = str;
    }

    public void bez() {
        b.getInstance().putString("asp_shown_info", this.fua);
    }

    public AppPosInfo beA() {
        AppPosInfo.Builder builder = new AppPosInfo.Builder();
        builder.ap_mac = bey();
        builder.ap_connected = Boolean.valueOf(i.hk());
        builder.latitude = this.latitude;
        builder.longitude = this.longitude;
        builder.addr_timestamp = Long.valueOf(this.tx);
        builder.coordinate_type = BDLocation.BDLOCATION_GCJ02_TO_BD09LL;
        builder.asp_shown_info = this.fua;
        return builder.build(false);
    }
}
