package com.baidu.tieba.imageProblem.logic;

import android.content.Context;
import android.net.DhcpInfo;
import android.net.Proxy;
import android.net.wifi.WifiManager;
import android.support.v4.view.MotionEventCompat;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.a.e;
import com.baidu.tbadk.core.util.a.f;
import com.baidu.tbadk.core.util.r;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.i;
import com.baidu.tieba.imageProblem.cdnOptimize.TbCdnIpListData;
import com.baidu.tieba.imageProblem.cdnOptimize.TbCdnTachometerModel;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ImageProblemAssistant {
    private TbCdnIpListData bQw;
    public ArrayList<TestTask> bQx = new ArrayList<>();
    public boolean bQy = false;
    private final Context mContext;
    private StringBuilder xZ;

    public ImageProblemAssistant(Context context) {
        String[] strArr;
        this.mContext = context;
        for (String str : new String[]{context.getString(i.h.img_assistant_title_1), context.getString(i.h.img_assistant_title_2), context.getString(i.h.img_assistant_title_3), context.getString(i.h.img_assistant_title_4), context.getString(i.h.img_assistant_title_5), context.getString(i.h.img_assistant_title_6)}) {
            TestTask testTask = new TestTask();
            testTask.title = str;
            this.bQx.add(testTask);
        }
    }

    /* loaded from: classes.dex */
    public class TestTask {
        public String bQz;
        public int result;
        public String title;

        public TestTask() {
        }
    }

    public boolean hasImageProblem() {
        if (!e.getInstance().abS) {
            e.getInstance().init();
        }
        return e.getInstance().hasImageProblem();
    }

    public void networkCheck() {
        this.xZ = new StringBuilder();
        Iterator<TestTask> it = this.bQx.iterator();
        while (it.hasNext()) {
            it.next().bQz = "";
        }
        TestTask testTask = null;
        try {
            TestTask testTask2 = this.bQx.get(0);
            try {
                if (k.jd()) {
                    testTask2.result = 0;
                } else {
                    testTask2.result = 2;
                    testTask2.bQz = this.mContext.getString(i.h.img_assistant_helptext_1);
                    if (this.xZ != null) {
                        this.xZ.append("1:failed");
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
            TestTask testTask2 = this.bQx.get(1);
            try {
                DhcpInfo dhcpInfo = ((WifiManager) BdBaseApplication.getInst().getApp().getSystemService("wifi")).getDhcpInfo();
                String[] strArr = {"8.8.8.8", "4.4.4.4", "8.8.4.4"};
                if (this.xZ != null) {
                    this.xZ.append("_2:" + intToIp(dhcpInfo.dns1) + "," + intToIp(dhcpInfo.dns2));
                }
                for (String str : strArr) {
                    if (intToIp(dhcpInfo.dns1).equals(str) || intToIp(dhcpInfo.dns2).equals(str)) {
                        testTask2.result = 1;
                        testTask2.bQz = String.valueOf(this.mContext.getString(i.h.img_assistant_helptext_2_1)) + intToIp(dhcpInfo.dns1) + "," + intToIp(dhcpInfo.dns2) + this.mContext.getString(i.h.img_assistant_helptext_2_2);
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
            TestTask testTask2 = this.bQx.get(2);
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
                        if (com.baidu.adp.lib.util.i.iN()) {
                            testTask2.bQz = this.mContext.getString(i.h.img_assistant_helptext_3);
                        } else {
                            testTask2.bQz = this.mContext.getString(i.h.img_assistant_helptext_3_mobile);
                        }
                        if (this.xZ != null) {
                            this.xZ.append("_3:" + str + ":" + str2);
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
            TestTask testTask2 = this.bQx.get(3);
            try {
                long currentTimeMillis = System.currentTimeMillis();
                if (aR("http://www.baidu.com/", null)) {
                    testTask2.result = 0;
                } else {
                    testTask2.result = 2;
                    testTask2.bQz = this.mContext.getString(i.h.img_assistant_helptext_4);
                    if (this.xZ != null) {
                        this.xZ.append("_4:failed:" + String.valueOf(System.currentTimeMillis() - currentTimeMillis));
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
            TestTask testTask2 = this.bQx.get(4);
            try {
                if (b.tu().getBoolean("show_images", true)) {
                    testTask2.result = 0;
                } else {
                    testTask2.result = 2;
                    testTask2.bQz = this.mContext.getString(i.h.img_assistant_helptext_5);
                    if (this.xZ != null) {
                        this.xZ.append("_5:failed");
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
            TestTask testTask2 = this.bQx.get(5);
            try {
                String tG = new w(TbCdnTachometerModel.bQa).tG();
                if (!TextUtils.isEmpty(tG)) {
                    JSONObject jSONObject = new JSONObject(tG);
                    this.bQw = new TbCdnIpListData();
                    this.bQw.parseJson(jSONObject);
                    boolean aR = aR(this.bQw.imageUrl, null);
                    boolean aR2 = aR("http://imgsrc.baidu.com/forum/crop%3D0%2C63%2C900%2C630%3Bwh%3D150%2C105%3B/sign=8ec7a12a932397ddc236c24464b29e81/f2c8a786c9177f3e8cf664c072cf3bc79e3d5639.jpg", null);
                    boolean aR3 = aR("http://c.tieba.baidu.com/c/p/img?src=" + this.bQw.imageUrl, null);
                    if (!aR2 && !aR3) {
                        testTask2.result = 2;
                        testTask2.bQz = this.mContext.getString(i.h.img_assistant_helptext_6_1);
                        if (this.xZ != null) {
                            this.xZ.append("_6:failed1");
                            return;
                        }
                        return;
                    } else if (aR && aR2 && aR3) {
                        testTask2.result = 0;
                        this.bQy = true;
                        return;
                    } else if (aR3) {
                        testTask2.result = 1;
                        testTask2.bQz = this.mContext.getString(i.h.img_assistant_helptext_6_2);
                        if (this.xZ != null) {
                            this.xZ.append("_6:warning");
                        }
                        this.bQy = true;
                        return;
                    } else {
                        testTask2.result = 2;
                        testTask2.bQz = this.mContext.getString(i.h.img_assistant_helptext_6_3);
                        if (this.xZ != null) {
                            this.xZ.append("_6:failed2");
                            return;
                        }
                        return;
                    }
                }
                testTask2.result = 2;
                testTask2.bQz = this.mContext.getString(i.h.img_assistant_helptext_6_1);
                if (this.xZ != null) {
                    this.xZ.append("_6:failed:iplist");
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
        r.da(this.xZ.toString());
        if (this.bQy) {
            try {
                w wVar = new w(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.CDN_LOG_ADDRESS);
                wVar.o("ab_img_m", "1");
                wVar.tG();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    private boolean aR(String str, String str2) {
        boolean z = false;
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            com.baidu.adp.lib.network.http.e eVar = new com.baidu.adp.lib.network.http.e();
            f fVar = new f(eVar);
            eVar.gP().setUrl(str);
            if (str2 != null && str2.length() > 0) {
                fVar.e(str2, "tbcdn.hiphotos.baidu.com", 1);
            } else {
                fVar.e(null, null, 1);
            }
            z = eVar.gQ().gW();
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
