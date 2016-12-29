package com.baidu.tieba.imageProblem.logic;

import android.content.Context;
import android.net.DhcpInfo;
import android.net.Proxy;
import android.net.wifi.WifiManager;
import android.support.v4.view.MotionEventCompat;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.network.http.f;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.i;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbDomainConfig;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.a.e;
import com.baidu.tbadk.core.util.u;
import com.baidu.tbadk.core.util.z;
import com.baidu.tieba.imageProblem.cdnOptimize.TbCdnIpListData;
import com.baidu.tieba.imageProblem.cdnOptimize.TbCdnTachometerModel;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ImageProblemAssistant {
    private TbCdnIpListData dfA;
    public ArrayList<TestTask> dfB = new ArrayList<>();
    public boolean dfC = false;
    private final Context mContext;
    private StringBuilder rH;

    public ImageProblemAssistant(Context context) {
        String[] strArr;
        this.mContext = context;
        for (String str : new String[]{context.getString(r.j.img_assistant_title_1), context.getString(r.j.img_assistant_title_2), context.getString(r.j.img_assistant_title_3), context.getString(r.j.img_assistant_title_4), context.getString(r.j.img_assistant_title_5), context.getString(r.j.img_assistant_title_6)}) {
            TestTask testTask = new TestTask();
            testTask.title = str;
            this.dfB.add(testTask);
        }
    }

    /* loaded from: classes.dex */
    public class TestTask {
        public String dfD;
        public int result;
        public String title;

        public TestTask() {
        }
    }

    public boolean hasImageProblem() {
        if (!e.getInstance().acx) {
            e.getInstance().init();
        }
        return e.getInstance().hasImageProblem();
    }

    public void networkCheck() {
        this.rH = new StringBuilder();
        Iterator<TestTask> it = this.dfB.iterator();
        while (it.hasNext()) {
            it.next().dfD = "";
        }
        TestTask testTask = null;
        try {
            TestTask testTask2 = this.dfB.get(0);
            try {
                if (k.gD()) {
                    testTask2.result = 0;
                } else {
                    testTask2.result = 2;
                    testTask2.dfD = this.mContext.getString(r.j.img_assistant_helptext_1);
                    if (this.rH != null) {
                        this.rH.append("1:failed");
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
        TestTask testTask = null;
        try {
            TestTask testTask2 = this.dfB.get(1);
            try {
                DhcpInfo dhcpInfo = ((WifiManager) BdBaseApplication.getInst().getApp().getSystemService("wifi")).getDhcpInfo();
                String[] strArr = {"8.8.8.8", "4.4.4.4", "8.8.4.4"};
                if (this.rH != null) {
                    this.rH.append("_2:" + intToIp(dhcpInfo.dns1) + "," + intToIp(dhcpInfo.dns2));
                }
                for (String str : strArr) {
                    if (intToIp(dhcpInfo.dns1).equals(str) || intToIp(dhcpInfo.dns2).equals(str)) {
                        testTask2.result = 1;
                        testTask2.dfD = String.valueOf(this.mContext.getString(r.j.img_assistant_helptext_2_1)) + intToIp(dhcpInfo.dns1) + "," + intToIp(dhcpInfo.dns2) + this.mContext.getString(r.j.img_assistant_helptext_2_2);
                        return;
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

    public void checkProxyIP() {
        String str;
        String str2;
        TestTask testTask = null;
        try {
            TestTask testTask2 = this.dfB.get(2);
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
                        testTask2.result = 1;
                        if (i.gn()) {
                            testTask2.dfD = this.mContext.getString(r.j.img_assistant_helptext_3);
                        } else {
                            testTask2.dfD = this.mContext.getString(r.j.img_assistant_helptext_3_mobile);
                        }
                        if (this.rH != null) {
                            this.rH.append("_3:" + str + ":" + str2);
                            return;
                        }
                        return;
                    }
                    testTask2.result = 0;
                }
                str = property;
                str2 = property2;
                if (str == null) {
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
        TestTask testTask = null;
        try {
            TestTask testTask2 = this.dfB.get(3);
            try {
                long currentTimeMillis = System.currentTimeMillis();
                if (bm(TbDomainConfig.DOMAIN_HTTPS_BAIDU, null)) {
                    testTask2.result = 0;
                } else {
                    testTask2.result = 2;
                    testTask2.dfD = this.mContext.getString(r.j.img_assistant_helptext_4);
                    if (this.rH != null) {
                        this.rH.append("_4:failed:" + String.valueOf(System.currentTimeMillis() - currentTimeMillis));
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

    public void checkSetting() {
        TestTask testTask = null;
        try {
            TestTask testTask2 = this.dfB.get(4);
            try {
                if (b.tW().getBoolean("show_images", true)) {
                    testTask2.result = 0;
                } else {
                    testTask2.result = 2;
                    testTask2.dfD = this.mContext.getString(r.j.img_assistant_helptext_5);
                    if (this.rH != null) {
                        this.rH.append("_5:failed");
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
            TestTask testTask2 = this.dfB.get(5);
            try {
                String uk = new z(TbCdnTachometerModel.dfe).uk();
                if (!TextUtils.isEmpty(uk)) {
                    JSONObject jSONObject = new JSONObject(uk);
                    this.dfA = new TbCdnIpListData();
                    this.dfA.parseJson(jSONObject);
                    boolean bm = bm(this.dfA.imageUrl, null);
                    boolean bm2 = bm("http://imgsrc.baidu.com/forum/crop%3D0%2C63%2C900%2C630%3Bwh%3D150%2C105%3B/sign=8ec7a12a932397ddc236c24464b29e81/f2c8a786c9177f3e8cf664c072cf3bc79e3d5639.jpg", null);
                    boolean bm3 = bm("http://c.tieba.baidu.com/c/p/img?src=" + this.dfA.imageUrl, null);
                    if (!bm2 && !bm3) {
                        testTask2.result = 2;
                        testTask2.dfD = this.mContext.getString(r.j.img_assistant_helptext_6_1);
                        if (this.rH != null) {
                            this.rH.append("_6:failed1");
                            return;
                        }
                        return;
                    } else if (bm && bm2 && bm3) {
                        testTask2.result = 0;
                        this.dfC = true;
                        return;
                    } else if (bm3) {
                        testTask2.result = 1;
                        testTask2.dfD = this.mContext.getString(r.j.img_assistant_helptext_6_2);
                        if (this.rH != null) {
                            this.rH.append("_6:warning");
                        }
                        this.dfC = true;
                        return;
                    } else {
                        testTask2.result = 2;
                        testTask2.dfD = this.mContext.getString(r.j.img_assistant_helptext_6_3);
                        if (this.rH != null) {
                            this.rH.append("_6:failed2");
                            return;
                        }
                        return;
                    }
                }
                testTask2.result = 2;
                testTask2.dfD = this.mContext.getString(r.j.img_assistant_helptext_6_1);
                if (this.rH != null) {
                    this.rH.append("_6:failed:iplist");
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
        u.dq(this.rH.toString());
        if (this.dfC) {
            try {
                z zVar = new z(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.CDN_LOG_ADDRESS);
                zVar.n("ab_img_m", "1");
                zVar.uk();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    private boolean bm(String str, String str2) {
        boolean z = false;
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            f fVar = new f();
            com.baidu.tbadk.core.util.a.f fVar2 = new com.baidu.tbadk.core.util.a.f(fVar);
            fVar.ep().setUrl(str);
            if (str2 != null && str2.length() > 0) {
                fVar2.d(str2, "tbcdn.hiphotos.baidu.com", 1);
            } else {
                fVar2.d(null, null, 1);
            }
            z = fVar.eq().ew();
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
