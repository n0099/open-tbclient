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
    private Context c;
    private com.baidu.tbadk.cdnOptimize.f e;
    private StringBuilder f;
    public ArrayList<u> a = new ArrayList<>();
    public boolean b = false;
    private com.baidu.tbadk.cdnOptimize.g d = new com.baidu.tbadk.cdnOptimize.g();

    public t(Context context) {
        String[] strArr;
        this.c = context;
        for (String str : new String[]{context.getString(com.baidu.tieba.x.img_assistant_title_1), context.getString(com.baidu.tieba.x.img_assistant_title_2), context.getString(com.baidu.tieba.x.img_assistant_title_3), context.getString(com.baidu.tieba.x.img_assistant_title_4), context.getString(com.baidu.tieba.x.img_assistant_title_5), context.getString(com.baidu.tieba.x.img_assistant_title_6)}) {
            u uVar = new u(this);
            uVar.a = str;
            this.a.add(uVar);
        }
    }

    public void a() {
        this.f = new StringBuilder();
        Iterator<u> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().c = "";
        }
        u uVar = null;
        try {
            u uVar2 = this.a.get(0);
            try {
                if (com.baidu.adp.lib.util.j.c()) {
                    uVar2.b = 0;
                } else {
                    uVar2.b = 2;
                    uVar2.c = this.c.getString(com.baidu.tieba.x.img_assistant_helptext_1);
                    if (this.f != null) {
                        this.f.append("1:failed");
                    }
                }
            } catch (Exception e) {
                uVar = uVar2;
                e = e;
                if (uVar != null) {
                    uVar.b = 0;
                }
                BdLog.e(e);
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    public void b() {
        u uVar = null;
        try {
            u uVar2 = this.a.get(1);
            try {
                DhcpInfo dhcpInfo = ((WifiManager) BdBaseApplication.getInst().getApp().getSystemService("wifi")).getDhcpInfo();
                String[] strArr = {"8.8.8.8", "4.4.4.4", "8.8.4.4"};
                if (this.f != null) {
                    this.f.append("_2:" + a(dhcpInfo.dns1) + "," + a(dhcpInfo.dns2));
                }
                for (String str : strArr) {
                    if (a(dhcpInfo.dns1).equals(str) || a(dhcpInfo.dns2).equals(str)) {
                        uVar2.b = 1;
                        uVar2.c = String.valueOf(this.c.getString(com.baidu.tieba.x.img_assistant_helptext_2_1)) + a(dhcpInfo.dns1) + "," + a(dhcpInfo.dns2) + this.c.getString(com.baidu.tieba.x.img_assistant_helptext_2_2);
                        return;
                    }
                }
            } catch (Exception e) {
                uVar = uVar2;
                e = e;
                if (uVar != null) {
                    uVar.b = 0;
                }
                BdLog.e(e);
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    public void c() {
        String str;
        String str2;
        u uVar = null;
        try {
            u uVar2 = this.a.get(2);
            try {
                String property = System.getProperty("http.proxyHost");
                String property2 = System.getProperty("http.proxyPort");
                try {
                    if (TextUtils.isEmpty(property)) {
                        property = Proxy.getHost(this.c);
                    }
                } catch (Exception e) {
                }
                if (TextUtils.isEmpty(property2)) {
                    str = property;
                    str2 = String.valueOf(Proxy.getPort(this.c));
                    if (str == null && str2 != null && str.length() > 0) {
                        uVar2.b = 1;
                        uVar2.c = this.c.getString(com.baidu.tieba.x.img_assistant_helptext_3);
                        if (this.f != null) {
                            this.f.append("_3:" + str + ":" + str2);
                        }
                    } else {
                        uVar2.b = 0;
                    }
                }
                str = property;
                str2 = property2;
                if (str == null) {
                }
                uVar2.b = 0;
            } catch (Exception e2) {
                uVar = uVar2;
                e = e2;
                if (uVar != null) {
                    uVar.b = 0;
                }
                BdLog.e(e);
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    public void d() {
        u uVar = null;
        try {
            u uVar2 = this.a.get(3);
            try {
                long currentTimeMillis = System.currentTimeMillis();
                if (a("http://www.baidu.com/", null)) {
                    uVar2.b = 0;
                } else {
                    uVar2.b = 2;
                    uVar2.c = this.c.getString(com.baidu.tieba.x.img_assistant_helptext_4);
                    if (this.f != null) {
                        this.f.append("_4:failed:" + String.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    }
                }
            } catch (Exception e) {
                uVar = uVar2;
                e = e;
                if (uVar != null) {
                    uVar.b = 0;
                }
                BdLog.e(e);
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    public void e() {
        u uVar = null;
        try {
            u uVar2 = this.a.get(4);
            try {
                if (com.baidu.tbadk.core.sharedPref.b.a().a("show_images", true)) {
                    uVar2.b = 0;
                } else {
                    uVar2.b = 2;
                    uVar2.c = this.c.getString(com.baidu.tieba.x.img_assistant_helptext_5);
                    if (this.f != null) {
                        this.f.append("_5:failed");
                    }
                }
            } catch (Exception e) {
                uVar = uVar2;
                e = e;
                if (uVar != null) {
                    uVar.b = 0;
                }
                BdLog.e(e);
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    public void f() {
        u uVar;
        u uVar2 = null;
        try {
            uVar = this.a.get(5);
        } catch (Exception e) {
            e = e;
        }
        try {
            String h = new com.baidu.tbadk.core.util.ae(this.d.a).h();
            if (!TextUtils.isEmpty(h)) {
                JSONObject jSONObject = new JSONObject(h);
                this.e = new com.baidu.tbadk.cdnOptimize.f();
                this.e.a(jSONObject);
                boolean a = a(this.e.c, null);
                boolean a2 = a("http://imgsrc.baidu.com/forum/crop%3D0%2C63%2C900%2C630%3Bwh%3D150%2C105%3B/sign=8ec7a12a932397ddc236c24464b29e81/f2c8a786c9177f3e8cf664c072cf3bc79e3d5639.jpg", null);
                boolean a3 = a("http://ww2.sinaimg.cn/thumbnail/7131f451jw1eisq3v228jj20dk08at9k.jpg", null);
                boolean a4 = a("http://c.tieba.baidu.com/c/p/img?src=" + this.e.c, null);
                if (!a2 && !a3 && !a4) {
                    uVar.b = 2;
                    uVar.c = this.c.getString(com.baidu.tieba.x.img_assistant_helptext_6_1);
                    if (this.f != null) {
                        this.f.append("_6:failed1");
                        return;
                    }
                    return;
                } else if (!a) {
                    if (a4) {
                        uVar.b = 1;
                        uVar.c = this.c.getString(com.baidu.tieba.x.img_assistant_helptext_6_2);
                        if (this.f != null) {
                            this.f.append("_6:warning");
                        }
                        this.b = true;
                        return;
                    }
                    uVar.b = 2;
                    uVar.c = this.c.getString(com.baidu.tieba.x.img_assistant_helptext_6_3);
                    if (this.f != null) {
                        this.f.append("_6:failed2");
                        return;
                    }
                    return;
                } else {
                    uVar.b = 0;
                    return;
                }
            }
            uVar.b = 2;
            uVar.c = this.c.getString(com.baidu.tieba.x.img_assistant_helptext_6_1);
            if (this.f != null) {
                this.f.append("_6:failed:iplist");
            }
        } catch (Exception e2) {
            uVar2 = uVar;
            e = e2;
            if (uVar2 != null) {
                uVar2.b = 0;
            }
            BdLog.e(e);
        }
    }

    public void g() {
        com.baidu.tbadk.core.util.w.a(this.f.toString());
        if (this.b) {
            try {
                com.baidu.tbadk.core.util.ae aeVar = new com.baidu.tbadk.core.util.ae(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.CDN_LOG_ADDRESS);
                aeVar.a("ab_img_m", TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK);
                aeVar.h();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    private boolean a(String str, String str2) {
        boolean z = false;
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            com.baidu.adp.lib.network.http.e eVar = new com.baidu.adp.lib.network.http.e();
            ImgHttpClient imgHttpClient = new ImgHttpClient(eVar);
            eVar.a().a(str);
            if (str2 != null && str2.length() > 0) {
                imgHttpClient.a(str2, "tbcdn.hiphotos.baidu.com", 1);
            } else {
                imgHttpClient.a((String) null, (String) null, 1);
            }
            z = eVar.b().a();
            return z;
        } catch (Exception e) {
            BdLog.e(e);
            return z;
        }
    }

    private static String a(int i) {
        return String.valueOf(i & MotionEventCompat.ACTION_MASK) + "." + ((i >> 8) & MotionEventCompat.ACTION_MASK) + "." + ((i >> 16) & MotionEventCompat.ACTION_MASK) + "." + ((i >> 24) & MotionEventCompat.ACTION_MASK);
    }
}
