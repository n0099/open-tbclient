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
    private static a iEG;
    private String iEE;
    private String iEF = b.agM().getString("asp_shown_info", "");
    private String latitude;
    private String longitude;
    private long ys;

    private a() {
    }

    public static a cfB() {
        if (iEG == null) {
            synchronized (c.class) {
                if (iEG == null) {
                    iEG = new a();
                }
            }
        }
        return iEG;
    }

    public void xP(String str) {
        this.longitude = str;
    }

    public void xQ(String str) {
        this.latitude = str;
    }

    public void ej(long j) {
        this.ys = j;
    }

    private String cfC() {
        if (TextUtils.isEmpty(this.iEE)) {
            WifiInfo connectionInfo = ((WifiManager) TbadkCoreApplication.getInst().getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo != null) {
                this.iEE = connectionInfo.getBSSID();
            } else {
                this.iEE = "";
            }
        }
        return this.iEE;
    }

    public void Db(String str) {
        this.iEE = str;
    }

    public void Dc(String str) {
        this.iEF = str;
    }

    public void cfD() {
        b.agM().putString("asp_shown_info", this.iEF);
    }

    public AppPosInfo cfE() {
        AppPosInfo.Builder builder = new AppPosInfo.Builder();
        builder.ap_mac = cfC();
        builder.ap_connected = Boolean.valueOf(j.jT());
        builder.latitude = this.latitude;
        builder.longitude = this.longitude;
        builder.addr_timestamp = Long.valueOf(this.ys);
        builder.coordinate_type = "bd09ll";
        builder.asp_shown_info = this.iEF;
        return builder.build(false);
    }
}
