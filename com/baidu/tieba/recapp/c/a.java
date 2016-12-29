package com.baidu.tieba.recapp.c;

import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.baidu.adp.lib.util.i;
import com.baidu.location.BDLocation;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tieba.tbadkCore.location.c;
import tbclient.AppPosInfo;
/* loaded from: classes.dex */
public class a {
    private static a eOu;
    private String eOs;
    private String eOt = b.tW().getString("asp_shown_info", "");
    private String latitude;
    private String longitude;
    private long mg;

    private a() {
    }

    public static a aYn() {
        if (eOu == null) {
            synchronized (c.class) {
                if (eOu == null) {
                    eOu = new a();
                }
            }
        }
        return eOu;
    }

    public void setLongitude(String str) {
        this.longitude = str;
    }

    public void setLatitude(String str) {
        this.latitude = str;
    }

    public void cB(long j) {
        this.mg = j;
    }

    private String aYo() {
        if (TextUtils.isEmpty(this.eOs)) {
            this.eOs = ((WifiManager) TbadkCoreApplication.m9getInst().getSystemService("wifi")).getConnectionInfo().getBSSID();
        }
        return this.eOs;
    }

    public void pz(String str) {
        this.eOs = str;
    }

    public void pA(String str) {
        this.eOt = str;
    }

    public void aYp() {
        b.tW().putString("asp_shown_info", this.eOt);
    }

    public AppPosInfo aYq() {
        AppPosInfo.Builder builder = new AppPosInfo.Builder();
        builder.ap_mac = aYo();
        builder.ap_connected = Boolean.valueOf(i.gn());
        builder.latitude = this.latitude;
        builder.longitude = this.longitude;
        builder.addr_timestamp = Long.valueOf(this.mg);
        builder.coordinate_type = BDLocation.BDLOCATION_GCJ02_TO_BD09LL;
        builder.asp_shown_info = this.eOt;
        return builder.build(false);
    }
}
