package com.baidu.tieba.recapp.d;

import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tieba.tbadkCore.location.c;
import tbclient.AppPosInfo;
/* loaded from: classes.dex */
public class a {
    private static a kwy;
    private String kww;
    private String kwx = b.aNV().getString(SharedPrefConfig.ASP_SHOWN_INFO, "");
    private String latitude;
    private String longitude;
    private long saveTime;

    private a() {
    }

    public static a cOb() {
        if (kwy == null) {
            synchronized (c.class) {
                if (kwy == null) {
                    kwy = new a();
                }
            }
        }
        return kwy;
    }

    public void Em(String str) {
        this.longitude = str;
    }

    public void En(String str) {
        this.latitude = str;
    }

    public void fm(long j) {
        this.saveTime = j;
    }

    private String cOc() {
        if (TextUtils.isEmpty(this.kww)) {
            WifiInfo connectionInfo = ((WifiManager) TbadkCoreApplication.getInst().getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo != null) {
                this.kww = connectionInfo.getBSSID();
            } else {
                this.kww = "";
            }
        }
        return this.kww;
    }

    public void JC(String str) {
        this.kww = str;
    }

    public void JD(String str) {
        this.kwx = str;
    }

    public void cOd() {
        b.aNV().putString(SharedPrefConfig.ASP_SHOWN_INFO, this.kwx);
    }

    public AppPosInfo cOe() {
        AppPosInfo.Builder builder = new AppPosInfo.Builder();
        builder.ap_mac = cOc();
        builder.ap_connected = Boolean.valueOf(j.isWifiNet());
        builder.latitude = this.latitude;
        builder.longitude = this.longitude;
        builder.addr_timestamp = Long.valueOf(this.saveTime);
        builder.coordinate_type = "bd09ll";
        builder.asp_shown_info = this.kwx;
        return builder.build(false);
    }
}
