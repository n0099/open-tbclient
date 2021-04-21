package com.baidu.tieba.imageProblem.logic;

import android.content.Context;
import android.net.DhcpInfo;
import android.net.Proxy;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbDomainConfig;
import com.baidu.tbadk.core.util.ImageLogger;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.httpNet.ICDNIPDirectConnect;
import com.baidu.tbadk.core.util.httpNet.ImgHttpClient;
import com.baidu.tieba.R;
import com.baidu.tieba.imageProblem.cdnOptimize.TbCdnIpListData;
import com.baidu.tieba.imageProblem.cdnOptimize.TbCdnTachometerModel;
import d.b.c.e.j.a.e;
import d.b.c.e.p.j;
import d.b.c.e.p.l;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ImageProblemAssistant {

    /* renamed from: a  reason: collision with root package name */
    public final Context f18129a;

    /* renamed from: b  reason: collision with root package name */
    public TbCdnIpListData f18130b;

    /* renamed from: c  reason: collision with root package name */
    public StringBuilder f18131c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<TestTask> f18132d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    public boolean f18133e = false;

    /* loaded from: classes4.dex */
    public class TestTask {

        /* renamed from: a  reason: collision with root package name */
        public String f18134a;

        /* renamed from: b  reason: collision with root package name */
        public int f18135b;

        /* renamed from: c  reason: collision with root package name */
        public String f18136c;

        public TestTask(ImageProblemAssistant imageProblemAssistant) {
        }
    }

    public ImageProblemAssistant(Context context) {
        this.f18129a = context;
        String[] strArr = {context.getString(R.string.img_assistant_title_1), context.getString(R.string.img_assistant_title_2), context.getString(R.string.img_assistant_title_3), context.getString(R.string.img_assistant_title_4), context.getString(R.string.img_assistant_title_5), context.getString(R.string.img_assistant_title_6)};
        for (int i = 0; i < 6; i++) {
            String str = strArr[i];
            TestTask testTask = new TestTask(this);
            testTask.f18134a = str;
            this.f18132d.add(testTask);
        }
    }

    public static String b(int i) {
        return (i & 255) + "." + ((i >> 8) & 255) + "." + ((i >> 16) & 255) + "." + ((i >> 24) & 255);
    }

    public final boolean a(String str, String str2) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            e eVar = new e();
            ImgHttpClient imgHttpClient = new ImgHttpClient(eVar);
            eVar.b().s(str);
            if (str2 != null && str2.length() > 0) {
                imgHttpClient.getNetDataWithIp(str2, "tbcdn.hiphotos.baidu.com", 1);
            } else {
                imgHttpClient.getNetDataWithIp(null, null, 1);
            }
            return eVar.c().b();
        } catch (Exception e2) {
            BdLog.e(e2);
            return false;
        }
    }

    public void checkDNSIP() {
        TestTask testTask;
        Exception e2;
        int i;
        if (PermissionUtil.isAgreePrivacyPolicy()) {
            try {
                testTask = this.f18132d.get(1);
            } catch (Exception e3) {
                testTask = null;
                e2 = e3;
            }
            try {
                DhcpInfo dhcpInfo = ((WifiManager) BdBaseApplication.getInst().getApplicationContext().getSystemService("wifi")).getDhcpInfo();
                String[] strArr = {"8.8.8.8", "4.4.4.4", "8.8.4.4"};
                if (this.f18131c != null) {
                    this.f18131c.append("_2:" + b(dhcpInfo.dns1) + "," + b(dhcpInfo.dns2));
                }
                while (i < 3) {
                    String str = strArr[i];
                    i = (b(dhcpInfo.dns1).equals(str) || b(dhcpInfo.dns2).equals(str)) ? 0 : i + 1;
                    testTask.f18135b = 1;
                    testTask.f18136c = this.f18129a.getString(R.string.img_assistant_helptext_2_1) + b(dhcpInfo.dns1) + "," + b(dhcpInfo.dns2) + this.f18129a.getString(R.string.img_assistant_helptext_2_2);
                    return;
                }
            } catch (Exception e4) {
                e2 = e4;
                if (testTask != null) {
                    testTask.f18135b = 0;
                }
                BdLog.e(e2);
            }
        }
    }

    public void checkLoadImg() {
        TestTask testTask;
        Exception e2;
        try {
            testTask = this.f18132d.get(5);
        } catch (Exception e3) {
            testTask = null;
            e2 = e3;
        }
        try {
            String postNetData = new NetWork(TbCdnTachometerModel.IPLIST_ADDRESS).postNetData();
            if (!TextUtils.isEmpty(postNetData)) {
                JSONObject jSONObject = new JSONObject(postNetData);
                TbCdnIpListData tbCdnIpListData = new TbCdnIpListData();
                this.f18130b = tbCdnIpListData;
                tbCdnIpListData.parseJson(jSONObject);
                boolean a2 = a(this.f18130b.f18090c, null);
                boolean a3 = a("http://imgsrc.baidu.com/forum/crop%3D0%2C63%2C900%2C630%3Bwh%3D150%2C105%3B/sign=8ec7a12a932397ddc236c24464b29e81/f2c8a786c9177f3e8cf664c072cf3bc79e3d5639.jpg", null);
                boolean a4 = a(TbConfig.URL_IMAGE_PREFIX + this.f18130b.f18090c, null);
                if (!a3 && !a4) {
                    testTask.f18135b = 2;
                    testTask.f18136c = this.f18129a.getString(R.string.img_assistant_helptext_6_1);
                    if (this.f18131c != null) {
                        this.f18131c.append("_6:failed1");
                        return;
                    }
                    return;
                } else if (a2 && a3 && a4) {
                    testTask.f18135b = 0;
                    this.f18133e = true;
                    return;
                } else if (a4) {
                    testTask.f18135b = 1;
                    testTask.f18136c = this.f18129a.getString(R.string.img_assistant_helptext_6_2);
                    if (this.f18131c != null) {
                        this.f18131c.append("_6:warning");
                    }
                    this.f18133e = true;
                    return;
                } else {
                    testTask.f18135b = 2;
                    testTask.f18136c = this.f18129a.getString(R.string.img_assistant_helptext_6_1);
                    if (this.f18131c != null) {
                        this.f18131c.append("_6:failed2");
                        return;
                    }
                    return;
                }
            }
            testTask.f18135b = 2;
            testTask.f18136c = this.f18129a.getString(R.string.img_assistant_helptext_6_1);
            if (this.f18131c != null) {
                this.f18131c.append("_6:failed:iplist");
            }
        } catch (Exception e4) {
            e2 = e4;
            if (testTask != null) {
                testTask.f18135b = 0;
            }
            BdLog.e(e2);
        }
    }

    public void checkProxyIP() {
        TestTask testTask;
        Exception e2;
        try {
            testTask = this.f18132d.get(2);
        } catch (Exception e3) {
            testTask = null;
            e2 = e3;
        }
        try {
            String property = System.getProperty("http.proxyHost");
            String property2 = System.getProperty("http.proxyPort");
            try {
                if (TextUtils.isEmpty(property)) {
                    property = Proxy.getHost(this.f18129a);
                }
                if (TextUtils.isEmpty(property2)) {
                    property2 = String.valueOf(Proxy.getPort(this.f18129a));
                }
            } catch (Exception unused) {
            }
            if (property != null && property2 != null && property.length() > 0) {
                testTask.f18135b = 1;
                if (j.H()) {
                    testTask.f18136c = this.f18129a.getString(R.string.img_assistant_helptext_3);
                } else {
                    testTask.f18136c = this.f18129a.getString(R.string.img_assistant_helptext_3_mobile);
                }
                if (this.f18131c != null) {
                    this.f18131c.append("_3:" + property + ":" + property2);
                    return;
                }
                return;
            }
            testTask.f18135b = 0;
        } catch (Exception e4) {
            e2 = e4;
            if (testTask != null) {
                testTask.f18135b = 0;
            }
            BdLog.e(e2);
        }
    }

    public void checkSetting() {
        TestTask testTask;
        Exception e2;
        try {
            testTask = this.f18132d.get(4);
        } catch (Exception e3) {
            testTask = null;
            e2 = e3;
        }
        try {
            testTask.f18135b = 0;
        } catch (Exception e4) {
            e2 = e4;
            if (testTask != null) {
                testTask.f18135b = 0;
            }
            BdLog.e(e2);
        }
    }

    public void fix() {
        ImageLogger.assistant(this.f18131c.toString());
        if (this.f18133e) {
            try {
                NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.CDN_LOG_ADDRESS);
                netWork.addPostData("ab_img_m", "1");
                netWork.postNetData();
            } catch (Exception e2) {
                BdLog.e(e2);
            }
        }
    }

    public boolean hasImageProblem() {
        if (!ICDNIPDirectConnect.getInstance().isAlreadyInit) {
            ICDNIPDirectConnect.getInstance().init();
        }
        return ICDNIPDirectConnect.getInstance().hasImageProblem();
    }

    public void networkCheck() {
        TestTask testTask;
        Exception e2;
        this.f18131c = new StringBuilder();
        Iterator<TestTask> it = this.f18132d.iterator();
        while (it.hasNext()) {
            it.next().f18136c = "";
        }
        try {
            testTask = this.f18132d.get(0);
        } catch (Exception e3) {
            testTask = null;
            e2 = e3;
        }
        try {
            if (l.C()) {
                testTask.f18135b = 0;
            } else {
                testTask.f18135b = 2;
                testTask.f18136c = this.f18129a.getString(R.string.img_assistant_helptext_1);
                if (this.f18131c != null) {
                    this.f18131c.append("1:failed");
                }
            }
        } catch (Exception e4) {
            e2 = e4;
            if (testTask != null) {
                testTask.f18135b = 0;
            }
            BdLog.e(e2);
        }
    }

    public void networkTest() {
        TestTask testTask;
        Exception e2;
        try {
            testTask = this.f18132d.get(3);
        } catch (Exception e3) {
            testTask = null;
            e2 = e3;
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            if (a(TbDomainConfig.DOMAIN_HTTPS_BAIDU, null)) {
                testTask.f18135b = 0;
            } else {
                testTask.f18135b = 2;
                testTask.f18136c = this.f18129a.getString(R.string.img_assistant_helptext_4);
                if (this.f18131c != null) {
                    this.f18131c.append("_4:failed:" + String.valueOf(System.currentTimeMillis() - currentTimeMillis));
                }
            }
        } catch (Exception e4) {
            e2 = e4;
            if (testTask != null) {
                testTask.f18135b = 0;
            }
            BdLog.e(e2);
        }
    }
}
