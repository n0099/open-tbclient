package com.baidu.tieba.recapp.d;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.tbadkCore.util.MercatorModel;
import com.xiaomi.mipush.sdk.Constants;
import tbclient.AppPosInfo;
/* loaded from: classes.dex */
public class a {
    private static a lHA;
    private String lHy;
    private String lHz = b.bik().getString(SharedPrefConfig.ASP_SHOWN_INFO, "");
    private String latitude;
    private String longitude;
    private long saveTime;

    private a() {
    }

    public static a dnZ() {
        if (lHA == null) {
            synchronized (com.baidu.tieba.tbadkCore.location.b.class) {
                if (lHA == null) {
                    lHA = new a();
                }
            }
        }
        return lHA;
    }

    public void Kh(String str) {
        this.longitude = str;
    }

    public void Ki(String str) {
        this.latitude = str;
    }

    public void fQ(long j) {
        this.saveTime = j;
    }

    private String doa() {
        if (TextUtils.isEmpty(this.lHy)) {
            dob();
        }
        return this.lHy;
    }

    public void dob() {
        Context applicationContext = TbadkCoreApplication.getInst().getApplicationContext();
        if (ae.biY() && ae.dY(applicationContext)) {
            try {
                WifiInfo connectionInfo = ((WifiManager) applicationContext.getSystemService("wifi")).getConnectionInfo();
                if (connectionInfo != null) {
                    this.lHy = connectionInfo.getBSSID();
                } else {
                    this.lHy = "";
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void PA(String str) {
        this.lHz = str;
    }

    public void doc() {
        b.bik().putString(SharedPrefConfig.ASP_SHOWN_INFO, this.lHz);
    }

    public AppPosInfo dod() {
        AppPosInfo.Builder builder = new AppPosInfo.Builder();
        builder.ap_mac = doa();
        builder.ap_connected = Boolean.valueOf(j.isWifiNet());
        builder.latitude = this.latitude;
        builder.longitude = this.longitude;
        builder.addr_timestamp = Long.valueOf(this.saveTime);
        builder.coordinate_type = "bd09ll";
        builder.asp_shown_info = this.lHz;
        MercatorModel.MercatorData mercatorData = MercatorModel.dxF().getMercatorData();
        if (mercatorData != null) {
            builder.mercator_lat = mercatorData.dxH();
            builder.mercator_lon = mercatorData.dxG();
            builder.mercator_city = Integer.valueOf(mercatorData.dxJ());
            builder.mercator_radius = mercatorData.dxI();
            builder.mercator_time = Long.valueOf(mercatorData.dxK());
        }
        return builder.build(false);
    }

    public AppPosInfo doe() {
        AppPosInfo.Builder builder = new AppPosInfo.Builder();
        builder.ap_mac = doa();
        builder.ap_connected = Boolean.valueOf(j.isWifiNet());
        builder.latitude = this.latitude;
        builder.longitude = this.longitude;
        if (at.isEmpty(this.latitude) || at.isEmpty(this.longitude)) {
            String string = b.bik().getString("key_last_receive_location_latitude_and_longitude", "");
            if (!at.isEmpty(string)) {
                String[] split = string.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                if (split.length >= 2) {
                    builder.latitude = split[0];
                    builder.longitude = split[1];
                }
            }
        }
        builder.addr_timestamp = Long.valueOf(this.saveTime);
        builder.coordinate_type = "BD09LL";
        builder.asp_shown_info = this.lHz;
        MercatorModel.MercatorData mercatorData = MercatorModel.dxF().getMercatorData();
        if (mercatorData != null) {
            builder.mercator_lat = mercatorData.dxH();
            builder.mercator_lon = mercatorData.dxG();
            builder.mercator_city = Integer.valueOf(mercatorData.dxJ());
            builder.mercator_radius = mercatorData.dxI();
            builder.mercator_time = Long.valueOf(mercatorData.dxK());
        }
        return builder.build(false);
    }
}
