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
    private static a jKw;
    private String jKu;
    private String jKv = b.aDr().getString(SharedPrefConfig.ASP_SHOWN_INFO, "");
    private String latitude;
    private String longitude;
    private long saveTime;

    private a() {
    }

    public static a cBM() {
        if (jKw == null) {
            synchronized (c.class) {
                if (jKw == null) {
                    jKw = new a();
                }
            }
        }
        return jKw;
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

    private String cBN() {
        if (TextUtils.isEmpty(this.jKu)) {
            WifiInfo connectionInfo = ((WifiManager) TbadkCoreApplication.getInst().getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo != null) {
                this.jKu = connectionInfo.getBSSID();
            } else {
                this.jKu = "";
            }
        }
        return this.jKu;
    }

    public void HJ(String str) {
        this.jKu = str;
    }

    public void HK(String str) {
        this.jKv = str;
    }

    public void cBO() {
        b.aDr().putString(SharedPrefConfig.ASP_SHOWN_INFO, this.jKv);
    }

    public AppPosInfo cBP() {
        AppPosInfo.Builder builder = new AppPosInfo.Builder();
        builder.ap_mac = cBN();
        builder.ap_connected = Boolean.valueOf(j.isWifiNet());
        builder.latitude = this.latitude;
        builder.longitude = this.longitude;
        builder.addr_timestamp = Long.valueOf(this.saveTime);
        builder.coordinate_type = "bd09ll";
        builder.asp_shown_info = this.jKv;
        return builder.build(false);
    }
}
