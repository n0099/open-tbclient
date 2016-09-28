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
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.a.e;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.imageProblem.cdnOptimize.TbCdnIpListData;
import com.baidu.tieba.imageProblem.cdnOptimize.TbCdnTachometerModel;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ImageProblemAssistant {
    private TbCdnIpListData dwY;
    public ArrayList<TestTask> dwZ = new ArrayList<>();
    public boolean dxa = false;
    private final Context mContext;
    private StringBuilder rG;

    public ImageProblemAssistant(Context context) {
        String[] strArr;
        this.mContext = context;
        for (String str : new String[]{context.getString(r.j.img_assistant_title_1), context.getString(r.j.img_assistant_title_2), context.getString(r.j.img_assistant_title_3), context.getString(r.j.img_assistant_title_4), context.getString(r.j.img_assistant_title_5), context.getString(r.j.img_assistant_title_6)}) {
            TestTask testTask = new TestTask();
            testTask.title = str;
            this.dwZ.add(testTask);
        }
    }

    /* loaded from: classes.dex */
    public class TestTask {
        public String dxb;
        public int result;
        public String title;

        public TestTask() {
        }
    }

    public boolean hasImageProblem() {
        if (!e.getInstance().acG) {
            e.getInstance().init();
        }
        return e.getInstance().hasImageProblem();
    }

    public void networkCheck() {
        this.rG = new StringBuilder();
        Iterator<TestTask> it = this.dwZ.iterator();
        while (it.hasNext()) {
            it.next().dxb = "";
        }
        TestTask testTask = null;
        try {
            TestTask testTask2 = this.dwZ.get(0);
            try {
                if (k.gD()) {
                    testTask2.result = 0;
                } else {
                    testTask2.result = 2;
                    testTask2.dxb = this.mContext.getString(r.j.img_assistant_helptext_1);
                    if (this.rG != null) {
                        this.rG.append("1:failed");
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
            TestTask testTask2 = this.dwZ.get(1);
            try {
                DhcpInfo dhcpInfo = ((WifiManager) BdBaseApplication.getInst().getApp().getSystemService("wifi")).getDhcpInfo();
                String[] strArr = {"8.8.8.8", "4.4.4.4", "8.8.4.4"};
                if (this.rG != null) {
                    this.rG.append("_2:" + intToIp(dhcpInfo.dns1) + "," + intToIp(dhcpInfo.dns2));
                }
                for (String str : strArr) {
                    if (intToIp(dhcpInfo.dns1).equals(str) || intToIp(dhcpInfo.dns2).equals(str)) {
                        testTask2.result = 1;
                        testTask2.dxb = String.valueOf(this.mContext.getString(r.j.img_assistant_helptext_2_1)) + intToIp(dhcpInfo.dns1) + "," + intToIp(dhcpInfo.dns2) + this.mContext.getString(r.j.img_assistant_helptext_2_2);
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
            TestTask testTask2 = this.dwZ.get(2);
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
                            testTask2.dxb = this.mContext.getString(r.j.img_assistant_helptext_3);
                        } else {
                            testTask2.dxb = this.mContext.getString(r.j.img_assistant_helptext_3_mobile);
                        }
                        if (this.rG != null) {
                            this.rG.append("_3:" + str + ":" + str2);
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
            TestTask testTask2 = this.dwZ.get(3);
            try {
                long currentTimeMillis = System.currentTimeMillis();
                if (bq("http://www.baidu.com/", null)) {
                    testTask2.result = 0;
                } else {
                    testTask2.result = 2;
                    testTask2.dxb = this.mContext.getString(r.j.img_assistant_helptext_4);
                    if (this.rG != null) {
                        this.rG.append("_4:failed:" + String.valueOf(System.currentTimeMillis() - currentTimeMillis));
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
            TestTask testTask2 = this.dwZ.get(4);
            try {
                if (b.uh().getBoolean("show_images", true)) {
                    testTask2.result = 0;
                } else {
                    testTask2.result = 2;
                    testTask2.dxb = this.mContext.getString(r.j.img_assistant_helptext_5);
                    if (this.rG != null) {
                        this.rG.append("_5:failed");
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
            TestTask testTask2 = this.dwZ.get(5);
            try {
                String uu = new ab(TbCdnTachometerModel.dwC).uu();
                if (!TextUtils.isEmpty(uu)) {
                    JSONObject jSONObject = new JSONObject(uu);
                    this.dwY = new TbCdnIpListData();
                    this.dwY.parseJson(jSONObject);
                    boolean bq = bq(this.dwY.imageUrl, null);
                    boolean bq2 = bq("http://imgsrc.baidu.com/forum/crop%3D0%2C63%2C900%2C630%3Bwh%3D150%2C105%3B/sign=8ec7a12a932397ddc236c24464b29e81/f2c8a786c9177f3e8cf664c072cf3bc79e3d5639.jpg", null);
                    boolean bq3 = bq("http://c.tieba.baidu.com/c/p/img?src=" + this.dwY.imageUrl, null);
                    if (!bq2 && !bq3) {
                        testTask2.result = 2;
                        testTask2.dxb = this.mContext.getString(r.j.img_assistant_helptext_6_1);
                        if (this.rG != null) {
                            this.rG.append("_6:failed1");
                            return;
                        }
                        return;
                    } else if (bq && bq2 && bq3) {
                        testTask2.result = 0;
                        this.dxa = true;
                        return;
                    } else if (bq3) {
                        testTask2.result = 1;
                        testTask2.dxb = this.mContext.getString(r.j.img_assistant_helptext_6_2);
                        if (this.rG != null) {
                            this.rG.append("_6:warning");
                        }
                        this.dxa = true;
                        return;
                    } else {
                        testTask2.result = 2;
                        testTask2.dxb = this.mContext.getString(r.j.img_assistant_helptext_6_3);
                        if (this.rG != null) {
                            this.rG.append("_6:failed2");
                            return;
                        }
                        return;
                    }
                }
                testTask2.result = 2;
                testTask2.dxb = this.mContext.getString(r.j.img_assistant_helptext_6_1);
                if (this.rG != null) {
                    this.rG.append("_6:failed:iplist");
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
        v.dn(this.rG.toString());
        if (this.dxa) {
            try {
                ab abVar = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.CDN_LOG_ADDRESS);
                abVar.n("ab_img_m", "1");
                abVar.uu();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    private boolean bq(String str, String str2) {
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
