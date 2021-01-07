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
import com.baidu.tbadk.core.util.ad;
import com.baidu.tbadk.core.util.b.e;
import com.baidu.tbadk.core.util.b.f;
import com.baidu.tbadk.core.util.t;
import com.baidu.tbadk.core.util.z;
import com.baidu.tieba.R;
import com.baidu.tieba.imageProblem.cdnOptimize.TbCdnIpListData;
import com.baidu.tieba.imageProblem.cdnOptimize.TbCdnTachometerModel;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class ImageProblemAssistant {
    private TbCdnIpListData kTB;
    private final Context mContext;
    private StringBuilder mLogContent;
    public ArrayList<TestTask> aPH = new ArrayList<>();
    public boolean kTC = false;

    public ImageProblemAssistant(Context context) {
        String[] strArr;
        this.mContext = context;
        for (String str : new String[]{context.getString(R.string.img_assistant_title_1), context.getString(R.string.img_assistant_title_2), context.getString(R.string.img_assistant_title_3), context.getString(R.string.img_assistant_title_4), context.getString(R.string.img_assistant_title_5), context.getString(R.string.img_assistant_title_6)}) {
            TestTask testTask = new TestTask();
            testTask.title = str;
            this.aPH.add(testTask);
        }
    }

    /* loaded from: classes8.dex */
    public class TestTask {
        public String kTD;
        public int result;
        public String title;

        public TestTask() {
        }
    }

    public boolean hasImageProblem() {
        if (!e.getInstance().fek) {
            e.getInstance().init();
        }
        return e.getInstance().hasImageProblem();
    }

    public void networkCheck() {
        Exception e;
        this.mLogContent = new StringBuilder();
        Iterator<TestTask> it = this.aPH.iterator();
        while (it.hasNext()) {
            it.next().kTD = "";
        }
        TestTask testTask = null;
        try {
            TestTask testTask2 = this.aPH.get(0);
            try {
                if (l.isNetOk()) {
                    testTask2.result = 0;
                } else {
                    testTask2.result = 2;
                    testTask2.kTD = this.mContext.getString(R.string.img_assistant_helptext_1);
                    if (this.mLogContent != null) {
                        this.mLogContent.append("1:failed");
                    }
                }
            } catch (Exception e2) {
                e = e2;
                testTask = testTask2;
                if (testTask != null) {
                    testTask.result = 0;
                }
                BdLog.e(e);
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    public void checkDNSIP() {
        Exception e;
        TestTask testTask;
        if (ad.bvZ()) {
            TestTask testTask2 = null;
            try {
                testTask = this.aPH.get(1);
            } catch (Exception e2) {
                e = e2;
            }
            try {
                DhcpInfo dhcpInfo = ((WifiManager) BdBaseApplication.getInst().getApplicationContext().getSystemService("wifi")).getDhcpInfo();
                String[] strArr = {"8.8.8.8", "4.4.4.4", "8.8.4.4"};
                if (this.mLogContent != null) {
                    this.mLogContent.append("_2:" + intToIp(dhcpInfo.dns1) + "," + intToIp(dhcpInfo.dns2));
                }
                for (String str : strArr) {
                    if (intToIp(dhcpInfo.dns1).equals(str) || intToIp(dhcpInfo.dns2).equals(str)) {
                        testTask.result = 1;
                        testTask.kTD = this.mContext.getString(R.string.img_assistant_helptext_2_1) + intToIp(dhcpInfo.dns1) + "," + intToIp(dhcpInfo.dns2) + this.mContext.getString(R.string.img_assistant_helptext_2_2);
                        return;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                testTask2 = testTask;
                if (testTask2 != null) {
                    testTask2.result = 0;
                }
                BdLog.e(e);
            }
        }
    }

    public void checkProxyIP() {
        Exception e;
        TestTask testTask = null;
        try {
            TestTask testTask2 = this.aPH.get(2);
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
                } catch (Exception e2) {
                }
                if (property != null && property2 != null && property.length() > 0) {
                    testTask2.result = 1;
                    if (j.isWifiNet()) {
                        testTask2.kTD = this.mContext.getString(R.string.img_assistant_helptext_3);
                    } else {
                        testTask2.kTD = this.mContext.getString(R.string.img_assistant_helptext_3_mobile);
                    }
                    if (this.mLogContent != null) {
                        this.mLogContent.append("_3:" + property + ":" + property2);
                        return;
                    }
                    return;
                }
                testTask2.result = 0;
            } catch (Exception e3) {
                e = e3;
                testTask = testTask2;
                if (testTask != null) {
                    testTask.result = 0;
                }
                BdLog.e(e);
            }
        } catch (Exception e4) {
            e = e4;
        }
    }

    public void networkTest() {
        Exception e;
        TestTask testTask;
        TestTask testTask2 = null;
        try {
            testTask = this.aPH.get(3);
        } catch (Exception e2) {
            e = e2;
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            if (fF("http://www.baidu.com/", null)) {
                testTask.result = 0;
            } else {
                testTask.result = 2;
                testTask.kTD = this.mContext.getString(R.string.img_assistant_helptext_4);
                if (this.mLogContent != null) {
                    this.mLogContent.append("_4:failed:" + String.valueOf(System.currentTimeMillis() - currentTimeMillis));
                }
            }
        } catch (Exception e3) {
            e = e3;
            testTask2 = testTask;
            if (testTask2 != null) {
                testTask2.result = 0;
            }
            BdLog.e(e);
        }
    }

    public void checkSetting() {
        Exception e;
        TestTask testTask;
        TestTask testTask2 = null;
        try {
            testTask = this.aPH.get(4);
        } catch (Exception e2) {
            e = e2;
        }
        try {
            testTask.result = 0;
        } catch (Exception e3) {
            e = e3;
            testTask2 = testTask;
            if (testTask2 != null) {
                testTask2.result = 0;
            }
            BdLog.e(e);
        }
    }

    public void checkLoadImg() {
        Exception e;
        TestTask testTask = null;
        try {
            TestTask testTask2 = this.aPH.get(5);
            try {
                String postNetData = new z(TbCdnTachometerModel.IPLIST_ADDRESS).postNetData();
                if (!TextUtils.isEmpty(postNetData)) {
                    JSONObject jSONObject = new JSONObject(postNetData);
                    this.kTB = new TbCdnIpListData();
                    this.kTB.parseJson(jSONObject);
                    boolean fF = fF(this.kTB.imageUrl, null);
                    boolean fF2 = fF("http://imgsrc.baidu.com/forum/crop%3D0%2C63%2C900%2C630%3Bwh%3D150%2C105%3B/sign=8ec7a12a932397ddc236c24464b29e81/f2c8a786c9177f3e8cf664c072cf3bc79e3d5639.jpg", null);
                    boolean fF3 = fF(TbConfig.URL_IMAGE_PREFIX + this.kTB.imageUrl, null);
                    if (!fF2 && !fF3) {
                        testTask2.result = 2;
                        testTask2.kTD = this.mContext.getString(R.string.img_assistant_helptext_6_1);
                        if (this.mLogContent != null) {
                            this.mLogContent.append("_6:failed1");
                            return;
                        }
                        return;
                    } else if (fF && fF2 && fF3) {
                        testTask2.result = 0;
                        this.kTC = true;
                        return;
                    } else if (fF3) {
                        testTask2.result = 1;
                        testTask2.kTD = this.mContext.getString(R.string.img_assistant_helptext_6_2);
                        if (this.mLogContent != null) {
                            this.mLogContent.append("_6:warning");
                        }
                        this.kTC = true;
                        return;
                    } else {
                        testTask2.result = 2;
                        testTask2.kTD = this.mContext.getString(R.string.img_assistant_helptext_6_1);
                        if (this.mLogContent != null) {
                            this.mLogContent.append("_6:failed2");
                            return;
                        }
                        return;
                    }
                }
                testTask2.result = 2;
                testTask2.kTD = this.mContext.getString(R.string.img_assistant_helptext_6_1);
                if (this.mLogContent != null) {
                    this.mLogContent.append("_6:failed:iplist");
                }
            } catch (Exception e2) {
                e = e2;
                testTask = testTask2;
                if (testTask != null) {
                    testTask.result = 0;
                }
                BdLog.e(e);
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    public void fix() {
        t.BQ(this.mLogContent.toString());
        if (this.kTC) {
            try {
                z zVar = new z(TbConfig.SERVER_ADDRESS + TbConfig.CDN_LOG_ADDRESS);
                zVar.addPostData("ab_img_m", "1");
                zVar.postNetData();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    private boolean fF(String str, String str2) {
        boolean z = false;
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            com.baidu.adp.lib.network.http.e eVar = new com.baidu.adp.lib.network.http.e();
            f fVar = new f(eVar);
            eVar.lV().setUrl(str);
            if (str2 != null && str2.length() > 0) {
                fVar.q(str2, "tbcdn.hiphotos.baidu.com", 1);
            } else {
                fVar.q(null, null, 1);
            }
            z = eVar.lW().me();
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
