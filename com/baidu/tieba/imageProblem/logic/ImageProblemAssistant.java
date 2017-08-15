package com.baidu.tieba.imageProblem.logic;

import android.content.Context;
import android.net.DhcpInfo;
import android.net.Proxy;
import android.net.wifi.WifiManager;
import android.support.v4.view.MotionEventCompat;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.i;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbDomainConfig;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.a.e;
import com.baidu.tbadk.core.util.a.f;
import com.baidu.tbadk.core.util.r;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.d;
import com.baidu.tieba.imageProblem.cdnOptimize.TbCdnIpListData;
import com.baidu.tieba.imageProblem.cdnOptimize.TbCdnTachometerModel;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ImageProblemAssistant {
    private StringBuilder Ab;
    private TbCdnIpListData dJb;
    public ArrayList<TestTask> dJc = new ArrayList<>();
    public boolean dJd = false;
    private final Context mContext;

    public ImageProblemAssistant(Context context) {
        String[] strArr;
        this.mContext = context;
        for (String str : new String[]{context.getString(d.l.img_assistant_title_1), context.getString(d.l.img_assistant_title_2), context.getString(d.l.img_assistant_title_3), context.getString(d.l.img_assistant_title_4), context.getString(d.l.img_assistant_title_5), context.getString(d.l.img_assistant_title_6)}) {
            TestTask testTask = new TestTask();
            testTask.title = str;
            this.dJc.add(testTask);
        }
    }

    /* loaded from: classes2.dex */
    public class TestTask {
        public String dJe;
        public int result;
        public String title;

        public TestTask() {
        }
    }

    public boolean hasImageProblem() {
        if (!e.getInstance().aiW) {
            e.getInstance().init();
        }
        return e.getInstance().hasImageProblem();
    }

    public void networkCheck() {
        this.Ab = new StringBuilder();
        Iterator<TestTask> it = this.dJc.iterator();
        while (it.hasNext()) {
            it.next().dJe = "";
        }
        TestTask testTask = null;
        try {
            TestTask testTask2 = this.dJc.get(0);
            try {
                if (k.hI()) {
                    testTask2.result = 0;
                } else {
                    testTask2.result = 2;
                    testTask2.dJe = this.mContext.getString(d.l.img_assistant_helptext_1);
                    if (this.Ab != null) {
                        this.Ab.append("1:failed");
                    }
                }
            } catch (Exception e) {
                testTask = testTask2;
                e = e;
                if (testTask != null) {
                    testTask.result = 0;
                }
                BdLog.e(e);
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    public void checkDNSIP() {
        TestTask testTask;
        TestTask testTask2 = null;
        try {
            testTask = this.dJc.get(1);
        } catch (Exception e) {
            e = e;
        }
        try {
            DhcpInfo dhcpInfo = ((WifiManager) BdBaseApplication.getInst().getApp().getSystemService("wifi")).getDhcpInfo();
            String[] strArr = {"8.8.8.8", "4.4.4.4", "8.8.4.4"};
            if (this.Ab != null) {
                this.Ab.append("_2:" + intToIp(dhcpInfo.dns1) + Constants.ACCEPT_TIME_SEPARATOR_SP + intToIp(dhcpInfo.dns2));
            }
            for (String str : strArr) {
                if (intToIp(dhcpInfo.dns1).equals(str) || intToIp(dhcpInfo.dns2).equals(str)) {
                    testTask.result = 1;
                    testTask.dJe = this.mContext.getString(d.l.img_assistant_helptext_2_1) + intToIp(dhcpInfo.dns1) + Constants.ACCEPT_TIME_SEPARATOR_SP + intToIp(dhcpInfo.dns2) + this.mContext.getString(d.l.img_assistant_helptext_2_2);
                    return;
                }
            }
        } catch (Exception e2) {
            testTask2 = testTask;
            e = e2;
            if (testTask2 != null) {
                testTask2.result = 0;
            }
            BdLog.e(e);
        }
    }

    public void checkProxyIP() {
        TestTask testTask = null;
        try {
            TestTask testTask2 = this.dJc.get(2);
            try {
                String property = System.getProperty("http.proxyHost");
                String property2 = System.getProperty("http.proxyPort");
                try {
                    if (TextUtils.isEmpty(property)) {
                        property = Proxy.getHost(this.mContext);
                    }
                    if (TextUtils.isEmpty(property2)) {
                        property2 = String.valueOf(Proxy.getPort(this.mContext));
                    }
                } catch (Exception e) {
                }
                if (property != null && property2 != null && property.length() > 0) {
                    testTask2.result = 1;
                    if (i.hs()) {
                        testTask2.dJe = this.mContext.getString(d.l.img_assistant_helptext_3);
                    } else {
                        testTask2.dJe = this.mContext.getString(d.l.img_assistant_helptext_3_mobile);
                    }
                    if (this.Ab != null) {
                        this.Ab.append("_3:" + property + ":" + property2);
                        return;
                    }
                    return;
                }
                testTask2.result = 0;
            } catch (Exception e2) {
                testTask = testTask2;
                e = e2;
                if (testTask != null) {
                    testTask.result = 0;
                }
                BdLog.e(e);
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    public void networkTest() {
        TestTask testTask;
        TestTask testTask2 = null;
        try {
            testTask = this.dJc.get(3);
        } catch (Exception e) {
            e = e;
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            if (bs(TbDomainConfig.DOMAIN_HTTPS_BAIDU, null)) {
                testTask.result = 0;
            } else {
                testTask.result = 2;
                testTask.dJe = this.mContext.getString(d.l.img_assistant_helptext_4);
                if (this.Ab != null) {
                    this.Ab.append("_4:failed:" + String.valueOf(System.currentTimeMillis() - currentTimeMillis));
                }
            }
        } catch (Exception e2) {
            testTask2 = testTask;
            e = e2;
            if (testTask2 != null) {
                testTask2.result = 0;
            }
            BdLog.e(e);
        }
    }

    public void checkSetting() {
        TestTask testTask = null;
        try {
            TestTask testTask2 = this.dJc.get(4);
            try {
                if (b.getInstance().getBoolean("show_images", true)) {
                    testTask2.result = 0;
                } else {
                    testTask2.result = 2;
                    testTask2.dJe = this.mContext.getString(d.l.img_assistant_helptext_5);
                    if (this.Ab != null) {
                        this.Ab.append("_5:failed");
                    }
                }
            } catch (Exception e) {
                testTask = testTask2;
                e = e;
                if (testTask != null) {
                    testTask.result = 0;
                }
                BdLog.e(e);
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    public void checkLoadImg() {
        TestTask testTask = null;
        try {
            TestTask testTask2 = this.dJc.get(5);
            try {
                String uO = new w(TbCdnTachometerModel.IPLIST_ADDRESS).uO();
                if (!TextUtils.isEmpty(uO)) {
                    JSONObject jSONObject = new JSONObject(uO);
                    this.dJb = new TbCdnIpListData();
                    this.dJb.parseJson(jSONObject);
                    boolean bs = bs(this.dJb.imageUrl, null);
                    boolean bs2 = bs("http://imgsrc.baidu.com/forum/crop%3D0%2C63%2C900%2C630%3Bwh%3D150%2C105%3B/sign=8ec7a12a932397ddc236c24464b29e81/f2c8a786c9177f3e8cf664c072cf3bc79e3d5639.jpg", null);
                    boolean bs3 = bs(TbConfig.URL_IMAGE_PREFIX + this.dJb.imageUrl, null);
                    if (!bs2 && !bs3) {
                        testTask2.result = 2;
                        testTask2.dJe = this.mContext.getString(d.l.img_assistant_helptext_6_1);
                        if (this.Ab != null) {
                            this.Ab.append("_6:failed1");
                            return;
                        }
                        return;
                    } else if (bs && bs2 && bs3) {
                        testTask2.result = 0;
                        this.dJd = true;
                        return;
                    } else if (bs3) {
                        testTask2.result = 1;
                        testTask2.dJe = this.mContext.getString(d.l.img_assistant_helptext_6_2);
                        if (this.Ab != null) {
                            this.Ab.append("_6:warning");
                        }
                        this.dJd = true;
                        return;
                    } else {
                        testTask2.result = 2;
                        testTask2.dJe = this.mContext.getString(d.l.img_assistant_helptext_6_1);
                        if (this.Ab != null) {
                            this.Ab.append("_6:failed2");
                            return;
                        }
                        return;
                    }
                }
                testTask2.result = 2;
                testTask2.dJe = this.mContext.getString(d.l.img_assistant_helptext_6_1);
                if (this.Ab != null) {
                    this.Ab.append("_6:failed:iplist");
                }
            } catch (Exception e) {
                testTask = testTask2;
                e = e;
                if (testTask != null) {
                    testTask.result = 0;
                }
                BdLog.e(e);
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    public void fix() {
        r.dM(this.Ab.toString());
        if (this.dJd) {
            try {
                w wVar = new w(TbConfig.SERVER_ADDRESS + TbConfig.CDN_LOG_ADDRESS);
                wVar.n("ab_img_m", "1");
                wVar.uO();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    private boolean bs(String str, String str2) {
        boolean z = false;
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            com.baidu.adp.lib.network.http.e eVar = new com.baidu.adp.lib.network.http.e();
            f fVar = new f(eVar);
            eVar.fJ().setUrl(str);
            if (str2 != null && str2.length() > 0) {
                fVar.d(str2, "tbcdn.hiphotos.baidu.com", 1);
            } else {
                fVar.d(null, null, 1);
            }
            z = eVar.fK().fQ();
            return z;
        } catch (Exception e) {
            BdLog.e(e);
            return z;
        }
    }

    private static String intToIp(int i) {
        return (i & MotionEventCompat.ACTION_MASK) + "." + ((i >> 8) & MotionEventCompat.ACTION_MASK) + "." + ((i >> 16) & MotionEventCompat.ACTION_MASK) + "." + ((i >> 24) & MotionEventCompat.ACTION_MASK);
    }
}
