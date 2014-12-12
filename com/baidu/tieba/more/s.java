package com.baidu.tieba.more;

import android.content.Context;
import android.net.DhcpInfo;
import android.net.Proxy;
import android.net.wifi.WifiManager;
import android.support.v4.view.MotionEventCompat;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.httpNet.ImgHttpClient;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class s {
    private com.baidu.tbadk.cdnOptimize.g bul;
    public ArrayList<t> bum = new ArrayList<>();
    public boolean bun = false;
    private Context mContext;
    private StringBuilder mK;

    public s(Context context) {
        String[] strArr;
        this.mContext = context;
        for (String str : new String[]{context.getString(com.baidu.tieba.z.img_assistant_title_1), context.getString(com.baidu.tieba.z.img_assistant_title_2), context.getString(com.baidu.tieba.z.img_assistant_title_3), context.getString(com.baidu.tieba.z.img_assistant_title_4), context.getString(com.baidu.tieba.z.img_assistant_title_5), context.getString(com.baidu.tieba.z.img_assistant_title_6)}) {
            t tVar = new t(this);
            tVar.title = str;
            this.bum.add(tVar);
        }
    }

    public void UR() {
        this.mK = new StringBuilder();
        Iterator<t> it = this.bum.iterator();
        while (it.hasNext()) {
            it.next().bup = "";
        }
        t tVar = null;
        try {
            t tVar2 = this.bum.get(0);
            try {
                if (com.baidu.adp.lib.util.l.isNetOk()) {
                    tVar2.buo = 0;
                } else {
                    tVar2.buo = 2;
                    tVar2.bup = this.mContext.getString(com.baidu.tieba.z.img_assistant_helptext_1);
                    if (this.mK != null) {
                        this.mK.append("1:failed");
                    }
                }
            } catch (Exception e) {
                tVar = tVar2;
                e = e;
                if (tVar != null) {
                    tVar.buo = 0;
                }
                BdLog.e(e);
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    public void US() {
        t tVar = null;
        try {
            t tVar2 = this.bum.get(1);
            try {
                DhcpInfo dhcpInfo = ((WifiManager) BdBaseApplication.getInst().getApp().getSystemService("wifi")).getDhcpInfo();
                String[] strArr = {"8.8.8.8", "4.4.4.4", "8.8.4.4"};
                if (this.mK != null) {
                    this.mK.append("_2:" + intToIp(dhcpInfo.dns1) + "," + intToIp(dhcpInfo.dns2));
                }
                for (String str : strArr) {
                    if (intToIp(dhcpInfo.dns1).equals(str) || intToIp(dhcpInfo.dns2).equals(str)) {
                        tVar2.buo = 1;
                        tVar2.bup = String.valueOf(this.mContext.getString(com.baidu.tieba.z.img_assistant_helptext_2_1)) + intToIp(dhcpInfo.dns1) + "," + intToIp(dhcpInfo.dns2) + this.mContext.getString(com.baidu.tieba.z.img_assistant_helptext_2_2);
                        return;
                    }
                }
            } catch (Exception e) {
                tVar = tVar2;
                e = e;
                if (tVar != null) {
                    tVar.buo = 0;
                }
                BdLog.e(e);
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    public void UT() {
        String str;
        String str2;
        t tVar = null;
        try {
            t tVar2 = this.bum.get(2);
            try {
                String property = System.getProperty("http.proxyHost");
                String property2 = System.getProperty("http.proxyPort");
                try {
                    if (TextUtils.isEmpty(property)) {
                        property = Proxy.getHost(this.mContext);
                    }
                } catch (Exception e) {
                }
                if (TextUtils.isEmpty(property2)) {
                    str = property;
                    str2 = String.valueOf(Proxy.getPort(this.mContext));
                    if (str == null && str2 != null && str.length() > 0) {
                        tVar2.buo = 1;
                        if (com.baidu.adp.lib.util.i.fh()) {
                            tVar2.bup = this.mContext.getString(com.baidu.tieba.z.img_assistant_helptext_3);
                        } else {
                            tVar2.bup = this.mContext.getString(com.baidu.tieba.z.img_assistant_helptext_3_mobile);
                        }
                        if (this.mK != null) {
                            this.mK.append("_3:" + str + ":" + str2);
                            return;
                        }
                        return;
                    }
                    tVar2.buo = 0;
                }
                str = property;
                str2 = property2;
                if (str == null) {
                }
                tVar2.buo = 0;
            } catch (Exception e2) {
                tVar = tVar2;
                e = e2;
                if (tVar != null) {
                    tVar.buo = 0;
                }
                BdLog.e(e);
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    public void UU() {
        t tVar = null;
        try {
            t tVar2 = this.bum.get(3);
            try {
                long currentTimeMillis = System.currentTimeMillis();
                if (aJ("http://www.baidu.com/", null)) {
                    tVar2.buo = 0;
                } else {
                    tVar2.buo = 2;
                    tVar2.bup = this.mContext.getString(com.baidu.tieba.z.img_assistant_helptext_4);
                    if (this.mK != null) {
                        this.mK.append("_4:failed:" + String.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    }
                }
            } catch (Exception e) {
                tVar = tVar2;
                e = e;
                if (tVar != null) {
                    tVar.buo = 0;
                }
                BdLog.e(e);
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    public void UV() {
        t tVar = null;
        try {
            t tVar2 = this.bum.get(4);
            try {
                if (com.baidu.tbadk.core.sharedPref.b.og().getBoolean("show_images", true)) {
                    tVar2.buo = 0;
                } else {
                    tVar2.buo = 2;
                    tVar2.bup = this.mContext.getString(com.baidu.tieba.z.img_assistant_helptext_5);
                    if (this.mK != null) {
                        this.mK.append("_5:failed");
                    }
                }
            } catch (Exception e) {
                tVar = tVar2;
                e = e;
                if (tVar != null) {
                    tVar.buo = 0;
                }
                BdLog.e(e);
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    public void UW() {
        t tVar = null;
        try {
            t tVar2 = this.bum.get(5);
            try {
                String ov = new com.baidu.tbadk.core.util.ad(com.baidu.tbadk.cdnOptimize.m.BU).ov();
                if (!TextUtils.isEmpty(ov)) {
                    JSONObject jSONObject = new JSONObject(ov);
                    this.bul = new com.baidu.tbadk.cdnOptimize.g();
                    this.bul.parseJson(jSONObject);
                    boolean aJ = aJ(this.bul.imageUrl, null);
                    boolean aJ2 = aJ("http://imgsrc.baidu.com/forum/crop%3D0%2C63%2C900%2C630%3Bwh%3D150%2C105%3B/sign=8ec7a12a932397ddc236c24464b29e81/f2c8a786c9177f3e8cf664c072cf3bc79e3d5639.jpg", null);
                    boolean aJ3 = aJ("http://c.tieba.baidu.com/c/p/img?src=" + this.bul.imageUrl, null);
                    if (!aJ2 && !aJ3) {
                        tVar2.buo = 2;
                        tVar2.bup = this.mContext.getString(com.baidu.tieba.z.img_assistant_helptext_6_1);
                        if (this.mK != null) {
                            this.mK.append("_6:failed1");
                            return;
                        }
                        return;
                    } else if (aJ && aJ2 && aJ3) {
                        tVar2.buo = 0;
                        this.bun = true;
                        return;
                    } else if (aJ3) {
                        tVar2.buo = 1;
                        tVar2.bup = this.mContext.getString(com.baidu.tieba.z.img_assistant_helptext_6_2);
                        if (this.mK != null) {
                            this.mK.append("_6:warning");
                        }
                        this.bun = true;
                        return;
                    } else {
                        tVar2.buo = 2;
                        tVar2.bup = this.mContext.getString(com.baidu.tieba.z.img_assistant_helptext_6_3);
                        if (this.mK != null) {
                            this.mK.append("_6:failed2");
                            return;
                        }
                        return;
                    }
                }
                tVar2.buo = 2;
                tVar2.bup = this.mContext.getString(com.baidu.tieba.z.img_assistant_helptext_6_1);
                if (this.mK != null) {
                    this.mK.append("_6:failed:iplist");
                }
            } catch (Exception e) {
                tVar = tVar2;
                e = e;
                if (tVar != null) {
                    tVar.buo = 0;
                }
                BdLog.e(e);
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    public void UX() {
        com.baidu.tbadk.core.util.w.cw(this.mK.toString());
        if (this.bun) {
            try {
                com.baidu.tbadk.core.util.ad adVar = new com.baidu.tbadk.core.util.ad(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.CDN_LOG_ADDRESS);
                adVar.o("ab_img_m", "1");
                adVar.ov();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    private boolean aJ(String str, String str2) {
        boolean z = false;
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            com.baidu.adp.lib.network.http.e eVar = new com.baidu.adp.lib.network.http.e();
            ImgHttpClient imgHttpClient = new ImgHttpClient(eVar);
            eVar.dP().setUrl(str);
            if (str2 != null && str2.length() > 0) {
                imgHttpClient.c(str2, "tbcdn.hiphotos.baidu.com", 1);
            } else {
                imgHttpClient.c(null, null, 1);
            }
            z = eVar.dQ().dV();
            return z;
        } catch (Exception e) {
            BdLog.e(e);
            return z;
        }
    }

    private static String intToIp(int i) {
        return String.valueOf(i & MotionEventCompat.ACTION_MASK) + "." + ((i >> 8) & MotionEventCompat.ACTION_MASK) + "." + ((i >> 16) & MotionEventCompat.ACTION_MASK) + "." + ((i >> 24) & MotionEventCompat.ACTION_MASK);
    }
}
