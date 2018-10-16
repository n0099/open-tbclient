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
    private static a gIt;
    private long AG;
    private String gIr;
    private String gIs = b.getInstance().getString("asp_shown_info", "");
    private String latitude;
    private String longitude;

    private a() {
    }

    public static a bua() {
        if (gIt == null) {
            synchronized (c.class) {
                if (gIt == null) {
                    gIt = new a();
                }
            }
        }
        return gIt;
    }

    public void pb(String str) {
        this.longitude = str;
    }

    public void pc(String str) {
        this.latitude = str;
    }

    public void cZ(long j) {
        this.AG = j;
    }

    private String bub() {
        if (TextUtils.isEmpty(this.gIr)) {
            WifiInfo connectionInfo = ((WifiManager) TbadkCoreApplication.getInst().getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo != null) {
                this.gIr = connectionInfo.getBSSID();
            } else {
                this.gIr = "";
            }
        }
        return this.gIr;
    }

    public void ue(String str) {
        this.gIr = str;
    }

    public void uf(String str) {
        this.gIs = str;
    }

    public void buc() {
        b.getInstance().putString("asp_shown_info", this.gIs);
    }

    public AppPosInfo bud() {
        AppPosInfo.Builder builder = new AppPosInfo.Builder();
        builder.ap_mac = bub();
        builder.ap_connected = Boolean.valueOf(j.kY());
        builder.latitude = this.latitude;
        builder.longitude = this.longitude;
        builder.addr_timestamp = Long.valueOf(this.AG);
        builder.coordinate_type = "bd09ll";
        builder.asp_shown_info = this.gIs;
        return builder.build(false);
    }
}
