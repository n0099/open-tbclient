package com.baidu.tieba.recapp.d;

import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tieba.tbadkCore.location.c;
import tbclient.AppPosInfo;
/* loaded from: classes.dex */
public class a {
    private static a iEH;
    private String iEF;
    private String iEG = b.agM().getString("asp_shown_info", "");
    private String latitude;
    private String longitude;
    private long yr;

    private a() {
    }

    public static a cfC() {
        if (iEH == null) {
            synchronized (c.class) {
                if (iEH == null) {
                    iEH = new a();
                }
            }
        }
        return iEH;
    }

    public void xR(String str) {
        this.longitude = str;
    }

    public void xS(String str) {
        this.latitude = str;
    }

    public void ej(long j) {
        this.yr = j;
    }

    private String cfD() {
        if (TextUtils.isEmpty(this.iEF)) {
            WifiInfo connectionInfo = ((WifiManager) TbadkCoreApplication.getInst().getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo != null) {
                this.iEF = connectionInfo.getBSSID();
            } else {
                this.iEF = "";
            }
        }
        return this.iEF;
    }

    public void Dd(String str) {
        this.iEF = str;
    }

    public void De(String str) {
        this.iEG = str;
    }

    public void cfE() {
        b.agM().putString("asp_shown_info", this.iEG);
    }

    public AppPosInfo cfF() {
        AppPosInfo.Builder builder = new AppPosInfo.Builder();
        builder.ap_mac = cfD();
        builder.ap_connected = Boolean.valueOf(j.jT());
        builder.latitude = this.latitude;
        builder.longitude = this.longitude;
        builder.addr_timestamp = Long.valueOf(this.yr);
        builder.coordinate_type = "bd09ll";
        builder.asp_shown_info = this.iEG;
        return builder.build(false);
    }
}
