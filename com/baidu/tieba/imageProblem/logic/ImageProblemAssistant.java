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
import com.baidu.tieba.R;
import com.baidu.tieba.imageProblem.cdnOptimize.TbCdnIpListData;
import com.baidu.tieba.imageProblem.cdnOptimize.TbCdnTachometerModel;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ImageProblemAssistant {
    private StringBuilder Dz;
    private TbCdnIpListData gTJ;
    private final Context mContext;
    public ArrayList<TestTask> taskList = new ArrayList<>();
    public boolean gTK = false;

    public ImageProblemAssistant(Context context) {
        String[] strArr;
        this.mContext = context;
        for (String str : new String[]{context.getString(R.string.img_assistant_title_1), context.getString(R.string.img_assistant_title_2), context.getString(R.string.img_assistant_title_3), context.getString(R.string.img_assistant_title_4), context.getString(R.string.img_assistant_title_5), context.getString(R.string.img_assistant_title_6)}) {
            TestTask testTask = new TestTask();
            testTask.title = str;
            this.taskList.add(testTask);
        }
    }

    /* loaded from: classes2.dex */
    public class TestTask {
        public String gTL;
        public int result;
        public String title;

        public TestTask() {
        }
    }

    public boolean hasImageProblem() {
        if (!e.getInstance().bTJ) {
            e.getInstance().init();
        }
        return e.getInstance().hasImageProblem();
    }

    public void networkCheck() {
        this.Dz = new StringBuilder();
        Iterator<TestTask> it = this.taskList.iterator();
        while (it.hasNext()) {
            it.next().gTL = "";
        }
        TestTask testTask = null;
        try {
            TestTask testTask2 = this.taskList.get(0);
            try {
                if (l.ki()) {
                    testTask2.result = 0;
                } else {
                    testTask2.result = 2;
                    testTask2.gTL = this.mContext.getString(R.string.img_assistant_helptext_1);
                    if (this.Dz != null) {
                        this.Dz.append("1:failed");
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
            if (this.Dz != null) {
                this.Dz.append("_2:" + intToIp(dhcpInfo.dns1) + Constants.ACCEPT_TIME_SEPARATOR_SP + intToIp(dhcpInfo.dns2));
            }
            for (String str : strArr) {
                if (intToIp(dhcpInfo.dns1).equals(str) || intToIp(dhcpInfo.dns2).equals(str)) {
                    testTask.result = 1;
                    testTask.gTL = this.mContext.getString(R.string.img_assistant_helptext_2_1) + intToIp(dhcpInfo.dns1) + Constants.ACCEPT_TIME_SEPARATOR_SP + intToIp(dhcpInfo.dns2) + this.mContext.getString(R.string.img_assistant_helptext_2_2);
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
                    if (j.jT()) {
                        testTask2.gTL = this.mContext.getString(R.string.img_assistant_helptext_3);
                    } else {
                        testTask2.gTL = this.mContext.getString(R.string.img_assistant_helptext_3_mobile);
                    }
                    if (this.Dz != null) {
                        this.Dz.append("_3:" + property + ":" + property2);
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
            if (du(TbDomainConfig.DOMAIN_HTTPS_BAIDU, null)) {
                testTask.result = 0;
            } else {
                testTask.result = 2;
                testTask.gTL = this.mContext.getString(R.string.img_assistant_helptext_4);
                if (this.Dz != null) {
                    this.Dz.append("_4:failed:" + String.valueOf(System.currentTimeMillis() - currentTimeMillis));
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
                if (b.agM().getBoolean("show_images", true)) {
                    testTask2.result = 0;
                } else {
                    testTask2.result = 2;
                    testTask2.gTL = this.mContext.getString(R.string.img_assistant_helptext_5);
                    if (this.Dz != null) {
                        this.Dz.append("_5:failed");
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
        TestTask testTask;
        TestTask testTask2 = null;
        try {
            testTask = this.taskList.get(5);
        } catch (Exception e) {
            e = e;
        }
        try {
            String ahe = new x(TbCdnTachometerModel.IPLIST_ADDRESS).ahe();
            if (!TextUtils.isEmpty(ahe)) {
                JSONObject jSONObject = new JSONObject(ahe);
                this.gTJ = new TbCdnIpListData();
                this.gTJ.parseJson(jSONObject);
                boolean du = du(this.gTJ.imageUrl, null);
                boolean du2 = du("http://imgsrc.baidu.com/forum/crop%3D0%2C63%2C900%2C630%3Bwh%3D150%2C105%3B/sign=8ec7a12a932397ddc236c24464b29e81/f2c8a786c9177f3e8cf664c072cf3bc79e3d5639.jpg", null);
                boolean du3 = du(TbConfig.URL_IMAGE_PREFIX + this.gTJ.imageUrl, null);
                if (!du2 && !du3) {
                    testTask.result = 2;
                    testTask.gTL = this.mContext.getString(R.string.img_assistant_helptext_6_1);
                    if (this.Dz != null) {
                        this.Dz.append("_6:failed1");
                        return;
                    }
                    return;
                } else if (du && du2 && du3) {
                    testTask.result = 0;
                    this.gTK = true;
                    return;
                } else if (du3) {
                    testTask.result = 1;
                    testTask.gTL = this.mContext.getString(R.string.img_assistant_helptext_6_2);
                    if (this.Dz != null) {
                        this.Dz.append("_6:warning");
                    }
                    this.gTK = true;
                    return;
                } else {
                    testTask.result = 2;
                    testTask.gTL = this.mContext.getString(R.string.img_assistant_helptext_6_1);
                    if (this.Dz != null) {
                        this.Dz.append("_6:failed2");
                        return;
                    }
                    return;
                }
            }
            testTask.result = 2;
            testTask.gTL = this.mContext.getString(R.string.img_assistant_helptext_6_1);
            if (this.Dz != null) {
                this.Dz.append("_6:failed:iplist");
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

    public void fix() {
        s.nC(this.Dz.toString());
        if (this.gTK) {
            try {
                x xVar = new x(TbConfig.SERVER_ADDRESS + TbConfig.CDN_LOG_ADDRESS);
                xVar.o("ab_img_m", "1");
                xVar.ahe();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    private boolean du(String str, String str2) {
        boolean z = false;
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            com.baidu.adp.lib.network.http.e eVar = new com.baidu.adp.lib.network.http.e();
            f fVar = new f(eVar);
            eVar.ik().setUrl(str);
            if (str2 != null && str2.length() > 0) {
                fVar.l(str2, "tbcdn.hiphotos.baidu.com", 1);
            } else {
                fVar.l(null, null, 1);
            }
            z = eVar.il().is();
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
