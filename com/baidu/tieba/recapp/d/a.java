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
    private static a iOz;
    private String iOx;
    private String iOy = b.ahU().getString("asp_shown_info", "");
    private String latitude;
    private String longitude;
    private long yx;

    private a() {
    }

    public static a cjz() {
        if (iOz == null) {
            synchronized (c.class) {
                if (iOz == null) {
                    iOz = new a();
                }
            }
        }
        return iOz;
    }

    public void zb(String str) {
        this.longitude = str;
    }

    public void zc(String str) {
        this.latitude = str;
    }

    public void ew(long j) {
        this.yx = j;
    }

    private String cjA() {
        if (TextUtils.isEmpty(this.iOx)) {
            WifiInfo connectionInfo = ((WifiManager) TbadkCoreApplication.getInst().getSystemService(IXAdSystemUtils.NT_WIFI)).getConnectionInfo();
            if (connectionInfo != null) {
                this.iOx = connectionInfo.getBSSID();
            } else {
                this.iOx = "";
            }
        }
        return this.iOx;
    }

    public void Er(String str) {
        this.iOx = str;
    }

    public void Es(String str) {
        this.iOy = str;
    }

    public void cjB() {
        b.ahU().putString("asp_shown_info", this.iOy);
    }

    public AppPosInfo cjC() {
        AppPosInfo.Builder builder = new AppPosInfo.Builder();
        builder.ap_mac = cjA();
        builder.ap_connected = Boolean.valueOf(j.kd());
        builder.latitude = this.latitude;
        builder.longitude = this.longitude;
        builder.addr_timestamp = Long.valueOf(this.yx);
        builder.coordinate_type = "bd09ll";
        builder.asp_shown_info = this.iOy;
        return builder.build(false);
    }
}
