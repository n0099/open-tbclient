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
    private static a gIu;
    private long AG;
    private String gIs;
    private String gIt = b.getInstance().getString("asp_shown_info", "");
    private String latitude;
    private String longitude;

    private a() {
    }

    public static a bua() {
        if (gIu == null) {
            synchronized (c.class) {
                if (gIu == null) {
                    gIu = new a();
                }
            }
        }
        return gIu;
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
        if (TextUtils.isEmpty(this.gIs)) {
            WifiInfo connectionInfo = ((WifiManager) TbadkCoreApplication.getInst().getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo != null) {
                this.gIs = connectionInfo.getBSSID();
            } else {
                this.gIs = "";
            }
        }
        return this.gIs;
    }

    public void ue(String str) {
        this.gIs = str;
    }

    public void uf(String str) {
        this.gIt = str;
    }

    public void buc() {
        b.getInstance().putString("asp_shown_info", this.gIt);
    }

    public AppPosInfo bud() {
        AppPosInfo.Builder builder = new AppPosInfo.Builder();
        builder.ap_mac = bub();
        builder.ap_connected = Boolean.valueOf(j.kY());
        builder.latitude = this.latitude;
        builder.longitude = this.longitude;
        builder.addr_timestamp = Long.valueOf(this.AG);
        builder.coordinate_type = "bd09ll";
        builder.asp_shown_info = this.gIt;
        return builder.build(false);
    }
}
