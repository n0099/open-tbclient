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
    private static a kwC;
    private String kwA;
    private String kwB = b.aNT().getString(SharedPrefConfig.ASP_SHOWN_INFO, "");
    private String latitude;
    private String longitude;
    private long saveTime;

    private a() {
    }

    public static a cNY() {
        if (kwC == null) {
            synchronized (c.class) {
                if (kwC == null) {
                    kwC = new a();
                }
            }
        }
        return kwC;
    }

    public void Ep(String str) {
        this.longitude = str;
    }

    public void Eq(String str) {
        this.latitude = str;
    }

    public void fm(long j) {
        this.saveTime = j;
    }

    private String cNZ() {
        if (TextUtils.isEmpty(this.kwA)) {
            WifiInfo connectionInfo = ((WifiManager) TbadkCoreApplication.getInst().getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo != null) {
                this.kwA = connectionInfo.getBSSID();
            } else {
                this.kwA = "";
            }
        }
        return this.kwA;
    }

    public void JF(String str) {
        this.kwA = str;
    }

    public void JG(String str) {
        this.kwB = str;
    }

    public void cOa() {
        b.aNT().putString(SharedPrefConfig.ASP_SHOWN_INFO, this.kwB);
    }

    public AppPosInfo cOb() {
        AppPosInfo.Builder builder = new AppPosInfo.Builder();
        builder.ap_mac = cNZ();
        builder.ap_connected = Boolean.valueOf(j.isWifiNet());
        builder.latitude = this.latitude;
        builder.longitude = this.longitude;
        builder.addr_timestamp = Long.valueOf(this.saveTime);
        builder.coordinate_type = "bd09ll";
        builder.asp_shown_info = this.kwB;
        return builder.build(false);
    }
}
