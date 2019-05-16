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
    private static a iEE;
    private String iEC;
    private String iED = b.agM().getString("asp_shown_info", "");
    private String latitude;
    private String longitude;
    private long ys;

    private a() {
    }

    public static a cfz() {
        if (iEE == null) {
            synchronized (c.class) {
                if (iEE == null) {
                    iEE = new a();
                }
            }
        }
        return iEE;
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

    private String cfA() {
        if (TextUtils.isEmpty(this.iEC)) {
            WifiInfo connectionInfo = ((WifiManager) TbadkCoreApplication.getInst().getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo != null) {
                this.iEC = connectionInfo.getBSSID();
            } else {
                this.iEC = "";
            }
        }
        return this.iEC;
    }

    public void Db(String str) {
        this.iEC = str;
    }

    public void Dc(String str) {
        this.iED = str;
    }

    public void cfB() {
        b.agM().putString("asp_shown_info", this.iED);
    }

    public AppPosInfo cfC() {
        AppPosInfo.Builder builder = new AppPosInfo.Builder();
        builder.ap_mac = cfA();
        builder.ap_connected = Boolean.valueOf(j.jT());
        builder.latitude = this.latitude;
        builder.longitude = this.longitude;
        builder.addr_timestamp = Long.valueOf(this.ys);
        builder.coordinate_type = "bd09ll";
        builder.asp_shown_info = this.iED;
        return builder.build(false);
    }
}
