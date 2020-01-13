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
    private static a jKr;
    private String jKp;
    private String jKq = b.aDr().getString(SharedPrefConfig.ASP_SHOWN_INFO, "");
    private String latitude;
    private String longitude;
    private long saveTime;

    private a() {
    }

    public static a cBK() {
        if (jKr == null) {
            synchronized (c.class) {
                if (jKr == null) {
                    jKr = new a();
                }
            }
        }
        return jKr;
    }

    public void Cn(String str) {
        this.longitude = str;
    }

    public void Co(String str) {
        this.latitude = str;
    }

    public void eC(long j) {
        this.saveTime = j;
    }

    private String cBL() {
        if (TextUtils.isEmpty(this.jKp)) {
            WifiInfo connectionInfo = ((WifiManager) TbadkCoreApplication.getInst().getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo != null) {
                this.jKp = connectionInfo.getBSSID();
            } else {
                this.jKp = "";
            }
        }
        return this.jKp;
    }

    public void HJ(String str) {
        this.jKp = str;
    }

    public void HK(String str) {
        this.jKq = str;
    }

    public void cBM() {
        b.aDr().putString(SharedPrefConfig.ASP_SHOWN_INFO, this.jKq);
    }

    public AppPosInfo cBN() {
        AppPosInfo.Builder builder = new AppPosInfo.Builder();
        builder.ap_mac = cBL();
        builder.ap_connected = Boolean.valueOf(j.isWifiNet());
        builder.latitude = this.latitude;
        builder.longitude = this.longitude;
        builder.addr_timestamp = Long.valueOf(this.saveTime);
        builder.coordinate_type = "bd09ll";
        builder.asp_shown_info = this.jKq;
        return builder.build(false);
    }
}
