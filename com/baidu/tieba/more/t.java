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
public class t {
    private com.baidu.tbadk.cdnOptimize.f bqI;
    public ArrayList<u> bqJ = new ArrayList<>();
    public boolean bqK = false;
    private Context mContext;
    private StringBuilder mM;

    public t(Context context) {
        String[] strArr;
        this.mContext = context;
        for (String str : new String[]{context.getString(com.baidu.tieba.y.img_assistant_title_1), context.getString(com.baidu.tieba.y.img_assistant_title_2), context.getString(com.baidu.tieba.y.img_assistant_title_3), context.getString(com.baidu.tieba.y.img_assistant_title_4), context.getString(com.baidu.tieba.y.img_assistant_title_5), context.getString(com.baidu.tieba.y.img_assistant_title_6)}) {
            u uVar = new u(this);
            uVar.title = str;
            this.bqJ.add(uVar);
        }
    }

    public void UC() {
        this.mM = new StringBuilder();
        Iterator<u> it = this.bqJ.iterator();
        while (it.hasNext()) {
            it.next().bqM = "";
        }
        u uVar = null;
        try {
            u uVar2 = this.bqJ.get(0);
            try {
                if (com.baidu.adp.lib.util.m.isNetOk()) {
                    uVar2.bqL = 0;
                } else {
                    uVar2.bqL = 2;
                    uVar2.bqM = this.mContext.getString(com.baidu.tieba.y.img_assistant_helptext_1);
                    if (this.mM != null) {
                        this.mM.append("1:failed");
                    }
                }
            } catch (Exception e) {
                uVar = uVar2;
                e = e;
                if (uVar != null) {
                    uVar.bqL = 0;
                }
                BdLog.e(e);
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    public void UD() {
        u uVar = null;
        try {
            u uVar2 = this.bqJ.get(1);
            try {
                DhcpInfo dhcpInfo = ((WifiManager) BdBaseApplication.getInst().getApp().getSystemService("wifi")).getDhcpInfo();
                String[] strArr = {"8.8.8.8", "4.4.4.4", "8.8.4.4"};
                if (this.mM != null) {
                    this.mM.append("_2:" + intToIp(dhcpInfo.dns1) + "," + intToIp(dhcpInfo.dns2));
                }
                for (String str : strArr) {
                    if (intToIp(dhcpInfo.dns1).equals(str) || intToIp(dhcpInfo.dns2).equals(str)) {
                        uVar2.bqL = 1;
                        uVar2.bqM = String.valueOf(this.mContext.getString(com.baidu.tieba.y.img_assistant_helptext_2_1)) + intToIp(dhcpInfo.dns1) + "," + intToIp(dhcpInfo.dns2) + this.mContext.getString(com.baidu.tieba.y.img_assistant_helptext_2_2);
                        return;
                    }
                }
            } catch (Exception e) {
                uVar = uVar2;
                e = e;
                if (uVar != null) {
                    uVar.bqL = 0;
                }
                BdLog.e(e);
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    public void UE() {
        String str;
        String str2;
        u uVar = null;
        try {
            u uVar2 = this.bqJ.get(2);
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
                        uVar2.bqL = 1;
                        uVar2.bqM = this.mContext.getString(com.baidu.tieba.y.img_assistant_helptext_3);
                        if (this.mM != null) {
                            this.mM.append("_3:" + str + ":" + str2);
                        }
                    } else {
                        uVar2.bqL = 0;
                    }
                }
                str = property;
                str2 = property2;
                if (str == null) {
                }
                uVar2.bqL = 0;
            } catch (Exception e2) {
                uVar = uVar2;
                e = e2;
                if (uVar != null) {
                    uVar.bqL = 0;
                }
                BdLog.e(e);
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    public void UF() {
        u uVar = null;
        try {
            u uVar2 = this.bqJ.get(3);
            try {
                long currentTimeMillis = System.currentTimeMillis();
                if (aA("http://www.baidu.com/", null)) {
                    uVar2.bqL = 0;
                } else {
                    uVar2.bqL = 2;
                    uVar2.bqM = this.mContext.getString(com.baidu.tieba.y.img_assistant_helptext_4);
                    if (this.mM != null) {
                        this.mM.append("_4:failed:" + String.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    }
                }
            } catch (Exception e) {
                uVar = uVar2;
                e = e;
                if (uVar != null) {
                    uVar.bqL = 0;
                }
                BdLog.e(e);
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    public void UG() {
        u uVar = null;
        try {
            u uVar2 = this.bqJ.get(4);
            try {
                if (com.baidu.tbadk.core.sharedPref.b.lk().getBoolean("show_images", true)) {
                    uVar2.bqL = 0;
                } else {
                    uVar2.bqL = 2;
                    uVar2.bqM = this.mContext.getString(com.baidu.tieba.y.img_assistant_helptext_5);
                    if (this.mM != null) {
                        this.mM.append("_5:failed");
                    }
                }
            } catch (Exception e) {
                uVar = uVar2;
                e = e;
                if (uVar != null) {
                    uVar.bqL = 0;
                }
                BdLog.e(e);
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    public void UH() {
        u uVar = null;
        try {
            u uVar2 = this.bqJ.get(5);
            try {
                String lA = new com.baidu.tbadk.core.util.ac(com.baidu.tbadk.cdnOptimize.g.ya).lA();
                if (!TextUtils.isEmpty(lA)) {
                    JSONObject jSONObject = new JSONObject(lA);
                    this.bqI = new com.baidu.tbadk.cdnOptimize.f();
                    this.bqI.parseJson(jSONObject);
                    boolean aA = aA(this.bqI.imageUrl, null);
                    boolean aA2 = aA("http://imgsrc.baidu.com/forum/crop%3D0%2C63%2C900%2C630%3Bwh%3D150%2C105%3B/sign=8ec7a12a932397ddc236c24464b29e81/f2c8a786c9177f3e8cf664c072cf3bc79e3d5639.jpg", null);
                    boolean aA3 = aA("http://c.tieba.baidu.com/c/p/img?src=" + this.bqI.imageUrl, null);
                    if (!aA2 && !aA3) {
                        uVar2.bqL = 2;
                        uVar2.bqM = this.mContext.getString(com.baidu.tieba.y.img_assistant_helptext_6_1);
                        if (this.mM != null) {
                            this.mM.append("_6:failed1");
                            return;
                        }
                        return;
                    } else if (aA && aA2 && aA3) {
                        uVar2.bqL = 0;
                        this.bqK = true;
                        return;
                    } else if (aA3) {
                        uVar2.bqL = 1;
                        uVar2.bqM = this.mContext.getString(com.baidu.tieba.y.img_assistant_helptext_6_2);
                        if (this.mM != null) {
                            this.mM.append("_6:warning");
                        }
                        this.bqK = true;
                        return;
                    } else {
                        uVar2.bqL = 2;
                        uVar2.bqM = this.mContext.getString(com.baidu.tieba.y.img_assistant_helptext_6_3);
                        if (this.mM != null) {
                            this.mM.append("_6:failed2");
                            return;
                        }
                        return;
                    }
                }
                uVar2.bqL = 2;
                uVar2.bqM = this.mContext.getString(com.baidu.tieba.y.img_assistant_helptext_6_1);
                if (this.mM != null) {
                    this.mM.append("_6:failed:iplist");
                }
            } catch (Exception e) {
                uVar = uVar2;
                e = e;
                if (uVar != null) {
                    uVar.bqL = 0;
                }
                BdLog.e(e);
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    public void UI() {
        com.baidu.tbadk.core.util.v.bD(this.mM.toString());
        if (this.bqK) {
            try {
                com.baidu.tbadk.core.util.ac acVar = new com.baidu.tbadk.core.util.ac(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.CDN_LOG_ADDRESS);
                acVar.k("ab_img_m", "1");
                acVar.lA();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    private boolean aA(String str, String str2) {
        boolean z = false;
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            com.baidu.adp.lib.network.http.e eVar = new com.baidu.adp.lib.network.http.e();
            ImgHttpClient imgHttpClient = new ImgHttpClient(eVar);
            eVar.dQ().setUrl(str);
            if (str2 != null && str2.length() > 0) {
                imgHttpClient.a(str2, "tbcdn.hiphotos.baidu.com", 1);
            } else {
                imgHttpClient.a(null, null, 1);
            }
            z = eVar.dR().dW();
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
