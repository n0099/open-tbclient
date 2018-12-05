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
    private static a gQL;
    private long AJ;
    private String gQJ;
    private String gQK = b.getInstance().getString("asp_shown_info", "");
    private String latitude;
    private String longitude;

    private a() {
    }

    public static a bvp() {
        if (gQL == null) {
            synchronized (c.class) {
                if (gQL == null) {
                    gQL = new a();
                }
            }
        }
        return gQL;
    }

    public void pE(String str) {
        this.longitude = str;
    }

    public void pF(String str) {
        this.latitude = str;
    }

    public void db(long j) {
        this.AJ = j;
    }

    private String bvq() {
        if (TextUtils.isEmpty(this.gQJ)) {
            WifiInfo connectionInfo = ((WifiManager) TbadkCoreApplication.getInst().getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo != null) {
                this.gQJ = connectionInfo.getBSSID();
            } else {
                this.gQJ = "";
            }
        }
        return this.gQJ;
    }

    public void uJ(String str) {
        this.gQJ = str;
    }

    public void uK(String str) {
        this.gQK = str;
    }

    public void bvr() {
        b.getInstance().putString("asp_shown_info", this.gQK);
    }

    public AppPosInfo bvs() {
        AppPosInfo.Builder builder = new AppPosInfo.Builder();
        builder.ap_mac = bvq();
        builder.ap_connected = Boolean.valueOf(j.kW());
        builder.latitude = this.latitude;
        builder.longitude = this.longitude;
        builder.addr_timestamp = Long.valueOf(this.AJ);
        builder.coordinate_type = "bd09ll";
        builder.asp_shown_info = this.gQK;
        return builder.build(false);
    }
}
