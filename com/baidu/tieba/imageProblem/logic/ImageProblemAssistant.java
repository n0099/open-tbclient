package com.baidu.tieba.imageProblem.logic;

import android.content.Context;
import android.net.DhcpInfo;
import android.net.Proxy;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.ar.util.SystemInfoUtil;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbDomainConfig;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.a.e;
import com.baidu.tbadk.core.util.a.f;
import com.baidu.tbadk.core.util.t;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.d;
import com.baidu.tieba.imageProblem.cdnOptimize.TbCdnIpListData;
import com.baidu.tieba.imageProblem.cdnOptimize.TbCdnTachometerModel;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ImageProblemAssistant {
    private StringBuilder CI;
    private TbCdnIpListData eLy;
    private final Context mContext;
    public ArrayList<TestTask> taskList = new ArrayList<>();
    public boolean eLz = false;

    public ImageProblemAssistant(Context context) {
        String[] strArr;
        this.mContext = context;
        for (String str : new String[]{context.getString(d.j.img_assistant_title_1), context.getString(d.j.img_assistant_title_2), context.getString(d.j.img_assistant_title_3), context.getString(d.j.img_assistant_title_4), context.getString(d.j.img_assistant_title_5), context.getString(d.j.img_assistant_title_6)}) {
            TestTask testTask = new TestTask();
            testTask.title = str;
            this.taskList.add(testTask);
        }
    }

    /* loaded from: classes2.dex */
    public class TestTask {
        public String eLA;
        public int result;
        public String title;

        public TestTask() {
        }
    }

    public boolean hasImageProblem() {
        if (!e.getInstance().arX) {
            e.getInstance().init();
        }
        return e.getInstance().hasImageProblem();
    }

    public void networkCheck() {
        this.CI = new StringBuilder();
        Iterator<TestTask> it = this.taskList.iterator();
        while (it.hasNext()) {
            it.next().eLA = "";
        }
        TestTask testTask = null;
        try {
            TestTask testTask2 = this.taskList.get(0);
            try {
                if (l.jV()) {
                    testTask2.result = 0;
                } else {
                    testTask2.result = 2;
                    testTask2.eLA = this.mContext.getString(d.j.img_assistant_helptext_1);
                    if (this.CI != null) {
                        this.CI.append("1:failed");
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
            testTask = this.taskList.get(1);
        } catch (Exception e) {
            e = e;
        }
        try {
            DhcpInfo dhcpInfo = ((WifiManager) BdBaseApplication.getInst().getApp().getSystemService("wifi")).getDhcpInfo();
            String[] strArr = {"8.8.8.8", "4.4.4.4", "8.8.4.4"};
            if (this.CI != null) {
                this.CI.append("_2:" + intToIp(dhcpInfo.dns1) + "," + intToIp(dhcpInfo.dns2));
            }
            for (String str : strArr) {
                if (intToIp(dhcpInfo.dns1).equals(str) || intToIp(dhcpInfo.dns2).equals(str)) {
                    testTask.result = 1;
                    testTask.eLA = this.mContext.getString(d.j.img_assistant_helptext_2_1) + intToIp(dhcpInfo.dns1) + "," + intToIp(dhcpInfo.dns2) + this.mContext.getString(d.j.img_assistant_helptext_2_2);
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
            TestTask testTask2 = this.taskList.get(2);
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
                    if (j.jF()) {
                        testTask2.eLA = this.mContext.getString(d.j.img_assistant_helptext_3);
                    } else {
                        testTask2.eLA = this.mContext.getString(d.j.img_assistant_helptext_3_mobile);
                    }
                    if (this.CI != null) {
                        this.CI.append("_3:" + property + SystemInfoUtil.COLON + property2);
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
            testTask = this.taskList.get(3);
        } catch (Exception e) {
            e = e;
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            if (bz(TbDomainConfig.DOMAIN_HTTPS_BAIDU, null)) {
                testTask.result = 0;
            } else {
                testTask.result = 2;
                testTask.eLA = this.mContext.getString(d.j.img_assistant_helptext_4);
                if (this.CI != null) {
                    this.CI.append("_4:failed:" + String.valueOf(System.currentTimeMillis() - currentTimeMillis));
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
            TestTask testTask2 = this.taskList.get(4);
            try {
                if (b.getInstance().getBoolean("show_images", true)) {
                    testTask2.result = 0;
                } else {
                    testTask2.result = 2;
                    testTask2.eLA = this.mContext.getString(d.j.img_assistant_helptext_5);
                    if (this.CI != null) {
                        this.CI.append("_5:failed");
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
            TestTask testTask2 = this.taskList.get(5);
            try {
                String yq = new y(TbCdnTachometerModel.IPLIST_ADDRESS).yq();
                if (!TextUtils.isEmpty(yq)) {
                    JSONObject jSONObject = new JSONObject(yq);
                    this.eLy = new TbCdnIpListData();
                    this.eLy.parseJson(jSONObject);
                    boolean bz = bz(this.eLy.imageUrl, null);
                    boolean bz2 = bz("http://imgsrc.baidu.com/forum/crop%3D0%2C63%2C900%2C630%3Bwh%3D150%2C105%3B/sign=8ec7a12a932397ddc236c24464b29e81/f2c8a786c9177f3e8cf664c072cf3bc79e3d5639.jpg", null);
                    boolean bz3 = bz(TbConfig.URL_IMAGE_PREFIX + this.eLy.imageUrl, null);
                    if (!bz2 && !bz3) {
                        testTask2.result = 2;
                        testTask2.eLA = this.mContext.getString(d.j.img_assistant_helptext_6_1);
                        if (this.CI != null) {
                            this.CI.append("_6:failed1");
                            return;
                        }
                        return;
                    } else if (bz && bz2 && bz3) {
                        testTask2.result = 0;
                        this.eLz = true;
                        return;
                    } else if (bz3) {
                        testTask2.result = 1;
                        testTask2.eLA = this.mContext.getString(d.j.img_assistant_helptext_6_2);
                        if (this.CI != null) {
                            this.CI.append("_6:warning");
                        }
                        this.eLz = true;
                        return;
                    } else {
                        testTask2.result = 2;
                        testTask2.eLA = this.mContext.getString(d.j.img_assistant_helptext_6_1);
                        if (this.CI != null) {
                            this.CI.append("_6:failed2");
                            return;
                        }
                        return;
                    }
                }
                testTask2.result = 2;
                testTask2.eLA = this.mContext.getString(d.j.img_assistant_helptext_6_1);
                if (this.CI != null) {
                    this.CI.append("_6:failed:iplist");
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
        t.ew(this.CI.toString());
        if (this.eLz) {
            try {
                y yVar = new y(TbConfig.SERVER_ADDRESS + TbConfig.CDN_LOG_ADDRESS);
                yVar.o("ab_img_m", "1");
                yVar.yq();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    private boolean bz(String str, String str2) {
        boolean z = false;
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            com.baidu.adp.lib.network.http.e eVar = new com.baidu.adp.lib.network.http.e();
            f fVar = new f(eVar);
            eVar.hW().setUrl(str);
            if (str2 != null && str2.length() > 0) {
                fVar.e(str2, "tbcdn.hiphotos.baidu.com", 1);
            } else {
                fVar.e(null, null, 1);
            }
            z = eVar.hX().id();
            return z;
        } catch (Exception e) {
            BdLog.e(e);
            return z;
        }
    }

    private static String intToIp(int i) {
        return (i & 255) + "." + ((i >> 8) & 255) + "." + ((i >> 16) & 255) + "." + ((i >> 24) & 255);
    }
}
