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
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbDomainConfig;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.a.e;
import com.baidu.tbadk.core.util.a.f;
import com.baidu.tbadk.core.util.s;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.d;
import com.baidu.tieba.imageProblem.cdnOptimize.TbCdnIpListData;
import com.baidu.tieba.imageProblem.cdnOptimize.TbCdnTachometerModel;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ImageProblemAssistant {
    private StringBuilder amk;
    private TbCdnIpListData eRl;
    private final Context mContext;
    public ArrayList<TestTask> taskList = new ArrayList<>();
    public boolean eRm = false;

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
        public String eRn;
        public int result;
        public String title;

        public TestTask() {
        }
    }

    public boolean hasImageProblem() {
        if (!e.getInstance().aWH) {
            e.getInstance().init();
        }
        return e.getInstance().hasImageProblem();
    }

    public void networkCheck() {
        this.amk = new StringBuilder();
        Iterator<TestTask> it = this.taskList.iterator();
        while (it.hasNext()) {
            it.next().eRn = "";
        }
        TestTask testTask = null;
        try {
            TestTask testTask2 = this.taskList.get(0);
            try {
                if (l.pa()) {
                    testTask2.result = 0;
                } else {
                    testTask2.result = 2;
                    testTask2.eRn = this.mContext.getString(d.j.img_assistant_helptext_1);
                    if (this.amk != null) {
                        this.amk.append("1:failed");
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
            if (this.amk != null) {
                this.amk.append("_2:" + intToIp(dhcpInfo.dns1) + Constants.ACCEPT_TIME_SEPARATOR_SP + intToIp(dhcpInfo.dns2));
            }
            for (String str : strArr) {
                if (intToIp(dhcpInfo.dns1).equals(str) || intToIp(dhcpInfo.dns2).equals(str)) {
                    testTask.result = 1;
                    testTask.eRn = this.mContext.getString(d.j.img_assistant_helptext_2_1) + intToIp(dhcpInfo.dns1) + Constants.ACCEPT_TIME_SEPARATOR_SP + intToIp(dhcpInfo.dns2) + this.mContext.getString(d.j.img_assistant_helptext_2_2);
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
                    if (j.oK()) {
                        testTask2.eRn = this.mContext.getString(d.j.img_assistant_helptext_3);
                    } else {
                        testTask2.eRn = this.mContext.getString(d.j.img_assistant_helptext_3_mobile);
                    }
                    if (this.amk != null) {
                        this.amk.append("_3:" + property + ":" + property2);
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
            if (bn(TbDomainConfig.DOMAIN_HTTPS_BAIDU, null)) {
                testTask.result = 0;
            } else {
                testTask.result = 2;
                testTask.eRn = this.mContext.getString(d.j.img_assistant_helptext_4);
                if (this.amk != null) {
                    this.amk.append("_4:failed:" + String.valueOf(System.currentTimeMillis() - currentTimeMillis));
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
                    testTask2.eRn = this.mContext.getString(d.j.img_assistant_helptext_5);
                    if (this.amk != null) {
                        this.amk.append("_5:failed");
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
                String BI = new x(TbCdnTachometerModel.IPLIST_ADDRESS).BI();
                if (!TextUtils.isEmpty(BI)) {
                    JSONObject jSONObject = new JSONObject(BI);
                    this.eRl = new TbCdnIpListData();
                    this.eRl.parseJson(jSONObject);
                    boolean bn = bn(this.eRl.imageUrl, null);
                    boolean bn2 = bn("http://imgsrc.baidu.com/forum/crop%3D0%2C63%2C900%2C630%3Bwh%3D150%2C105%3B/sign=8ec7a12a932397ddc236c24464b29e81/f2c8a786c9177f3e8cf664c072cf3bc79e3d5639.jpg", null);
                    boolean bn3 = bn(TbConfig.URL_IMAGE_PREFIX + this.eRl.imageUrl, null);
                    if (!bn2 && !bn3) {
                        testTask2.result = 2;
                        testTask2.eRn = this.mContext.getString(d.j.img_assistant_helptext_6_1);
                        if (this.amk != null) {
                            this.amk.append("_6:failed1");
                            return;
                        }
                        return;
                    } else if (bn && bn2 && bn3) {
                        testTask2.result = 0;
                        this.eRm = true;
                        return;
                    } else if (bn3) {
                        testTask2.result = 1;
                        testTask2.eRn = this.mContext.getString(d.j.img_assistant_helptext_6_2);
                        if (this.amk != null) {
                            this.amk.append("_6:warning");
                        }
                        this.eRm = true;
                        return;
                    } else {
                        testTask2.result = 2;
                        testTask2.eRn = this.mContext.getString(d.j.img_assistant_helptext_6_1);
                        if (this.amk != null) {
                            this.amk.append("_6:failed2");
                            return;
                        }
                        return;
                    }
                }
                testTask2.result = 2;
                testTask2.eRn = this.mContext.getString(d.j.img_assistant_helptext_6_1);
                if (this.amk != null) {
                    this.amk.append("_6:failed:iplist");
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
        s.dS(this.amk.toString());
        if (this.eRm) {
            try {
                x xVar = new x(TbConfig.SERVER_ADDRESS + TbConfig.CDN_LOG_ADDRESS);
                xVar.n("ab_img_m", "1");
                xVar.BI();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    private boolean bn(String str, String str2) {
        boolean z = false;
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            com.baidu.adp.lib.network.http.e eVar = new com.baidu.adp.lib.network.http.e();
            f fVar = new f(eVar);
            eVar.nb().setUrl(str);
            if (str2 != null && str2.length() > 0) {
                fVar.d(str2, "tbcdn.hiphotos.baidu.com", 1);
            } else {
                fVar.d(null, null, 1);
            }
            z = eVar.nc().ni();
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
