package com.baidu.tieba.recapp.d;

import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.mobads.interfaces.utils.IXAdSystemUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tieba.tbadkCore.location.c;
import tbclient.AppPosInfo;
/* loaded from: classes.dex */
public class a {
    private static a iMd;
    private String iMb;
    private String iMc = b.ahQ().getString("asp_shown_info", "");
    private String latitude;
    private String longitude;
    private long yx;

    private a() {
    }

    public static a ciL() {
        if (iMd == null) {
            synchronized (c.class) {
                if (iMd == null) {
                    iMd = new a();
                }
            }
        }
        return iMd;
    }

    public void yC(String str) {
        this.longitude = str;
    }

    public void yD(String str) {
        this.latitude = str;
    }

    public void et(long j) {
        this.yx = j;
    }

    private String ciM() {
        if (TextUtils.isEmpty(this.iMb)) {
            WifiInfo connectionInfo = ((WifiManager) TbadkCoreApplication.getInst().getSystemService(IXAdSystemUtils.NT_WIFI)).getConnectionInfo();
            if (connectionInfo != null) {
                this.iMb = connectionInfo.getBSSID();
            } else {
                this.iMb = "";
            }
        }
        return this.iMb;
    }

    public void DR(String str) {
        this.iMb = str;
    }

    public void DS(String str) {
        this.iMc = str;
    }

    public void ciN() {
        b.ahQ().putString("asp_shown_info", this.iMc);
    }

    public AppPosInfo ciO() {
        AppPosInfo.Builder builder = new AppPosInfo.Builder();
        builder.ap_mac = ciM();
        builder.ap_connected = Boolean.valueOf(j.kd());
        builder.latitude = this.latitude;
        builder.longitude = this.longitude;
        builder.addr_timestamp = Long.valueOf(this.yx);
        builder.coordinate_type = "bd09ll";
        builder.asp_shown_info = this.iMc;
        return builder.build(false);
    }
}
