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
    private static a iKZ;
    private String iKX;
    private String iKY = b.ahO().getString("asp_shown_info", "");
    private String latitude;
    private String longitude;
    private long yx;

    private a() {
    }

    public static a cit() {
        if (iKZ == null) {
            synchronized (c.class) {
                if (iKZ == null) {
                    iKZ = new a();
                }
            }
        }
        return iKZ;
    }

    public void yB(String str) {
        this.longitude = str;
    }

    public void yC(String str) {
        this.latitude = str;
    }

    public void et(long j) {
        this.yx = j;
    }

    private String ciu() {
        if (TextUtils.isEmpty(this.iKX)) {
            WifiInfo connectionInfo = ((WifiManager) TbadkCoreApplication.getInst().getSystemService(IXAdSystemUtils.NT_WIFI)).getConnectionInfo();
            if (connectionInfo != null) {
                this.iKX = connectionInfo.getBSSID();
            } else {
                this.iKX = "";
            }
        }
        return this.iKX;
    }

    public void DQ(String str) {
        this.iKX = str;
    }

    public void DR(String str) {
        this.iKY = str;
    }

    public void civ() {
        b.ahO().putString("asp_shown_info", this.iKY);
    }

    public AppPosInfo ciw() {
        AppPosInfo.Builder builder = new AppPosInfo.Builder();
        builder.ap_mac = ciu();
        builder.ap_connected = Boolean.valueOf(j.kd());
        builder.latitude = this.latitude;
        builder.longitude = this.longitude;
        builder.addr_timestamp = Long.valueOf(this.yx);
        builder.coordinate_type = "bd09ll";
        builder.asp_shown_info = this.iKY;
        return builder.build(false);
    }
}
