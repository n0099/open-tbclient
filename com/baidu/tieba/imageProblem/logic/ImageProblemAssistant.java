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
import com.baidu.tbadk.core.util.t;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.imageProblem.cdnOptimize.TbCdnIpListData;
import com.baidu.tieba.imageProblem.cdnOptimize.TbCdnTachometerModel;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ImageProblemAssistant {
    private TbCdnIpListData dmJ;
    public ArrayList<TestTask> dmK = new ArrayList<>();
    public boolean dmL = false;
    private final Context mContext;
    private StringBuilder rz;

    public ImageProblemAssistant(Context context) {
        String[] strArr;
        this.mContext = context;
        for (String str : new String[]{context.getString(r.l.img_assistant_title_1), context.getString(r.l.img_assistant_title_2), context.getString(r.l.img_assistant_title_3), context.getString(r.l.img_assistant_title_4), context.getString(r.l.img_assistant_title_5), context.getString(r.l.img_assistant_title_6)}) {
            TestTask testTask = new TestTask();
            testTask.title = str;
            this.dmK.add(testTask);
        }
    }

    /* loaded from: classes.dex */
    public class TestTask {
        public String dmM;
        public int result;
        public String title;

        public TestTask() {
        }
    }

    public boolean hasImageProblem() {
        if (!e.getInstance().abJ) {
            e.getInstance().init();
        }
        return e.getInstance().hasImageProblem();
    }

    public void networkCheck() {
        this.rz = new StringBuilder();
        Iterator<TestTask> it = this.dmK.iterator();
        while (it.hasNext()) {
            it.next().dmM = "";
        }
        TestTask testTask = null;
        try {
            TestTask testTask2 = this.dmK.get(0);
            try {
                if (k.gB()) {
                    testTask2.result = 0;
                } else {
                    testTask2.result = 2;
                    testTask2.dmM = this.mContext.getString(r.l.img_assistant_helptext_1);
                    if (this.rz != null) {
                        this.rz.append("1:failed");
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
            TestTask testTask2 = this.dmK.get(1);
            try {
                DhcpInfo dhcpInfo = ((WifiManager) BdBaseApplication.getInst().getApp().getSystemService("wifi")).getDhcpInfo();
                String[] strArr = {"8.8.8.8", "4.4.4.4", "8.8.4.4"};
                if (this.rz != null) {
                    this.rz.append("_2:" + intToIp(dhcpInfo.dns1) + "," + intToIp(dhcpInfo.dns2));
                }
                for (String str : strArr) {
                    if (intToIp(dhcpInfo.dns1).equals(str) || intToIp(dhcpInfo.dns2).equals(str)) {
                        testTask2.result = 1;
                        testTask2.dmM = String.valueOf(this.mContext.getString(r.l.img_assistant_helptext_2_1)) + intToIp(dhcpInfo.dns1) + "," + intToIp(dhcpInfo.dns2) + this.mContext.getString(r.l.img_assistant_helptext_2_2);
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
            TestTask testTask2 = this.dmK.get(2);
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
                        if (i.gl()) {
                            testTask2.dmM = this.mContext.getString(r.l.img_assistant_helptext_3);
                        } else {
                            testTask2.dmM = this.mContext.getString(r.l.img_assistant_helptext_3_mobile);
                        }
                        if (this.rz != null) {
                            this.rz.append("_3:" + str + ":" + str2);
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
            TestTask testTask2 = this.dmK.get(3);
            try {
                long currentTimeMillis = System.currentTimeMillis();
                if (br(TbDomainConfig.DOMAIN_HTTPS_BAIDU, null)) {
                    testTask2.result = 0;
                } else {
                    testTask2.result = 2;
                    testTask2.dmM = this.mContext.getString(r.l.img_assistant_helptext_4);
                    if (this.rz != null) {
                        this.rz.append("_4:failed:" + String.valueOf(System.currentTimeMillis() - currentTimeMillis));
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
            TestTask testTask2 = this.dmK.get(4);
            try {
                if (b.tQ().getBoolean("show_images", true)) {
                    testTask2.result = 0;
                } else {
                    testTask2.result = 2;
                    testTask2.dmM = this.mContext.getString(r.l.img_assistant_helptext_5);
                    if (this.rz != null) {
                        this.rz.append("_5:failed");
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
            TestTask testTask2 = this.dmK.get(5);
            try {
                String ud = new y(TbCdnTachometerModel.IPLIST_ADDRESS).ud();
                if (!TextUtils.isEmpty(ud)) {
                    JSONObject jSONObject = new JSONObject(ud);
                    this.dmJ = new TbCdnIpListData();
                    this.dmJ.parseJson(jSONObject);
                    boolean br = br(this.dmJ.imageUrl, null);
                    boolean br2 = br("http://imgsrc.baidu.com/forum/crop%3D0%2C63%2C900%2C630%3Bwh%3D150%2C105%3B/sign=8ec7a12a932397ddc236c24464b29e81/f2c8a786c9177f3e8cf664c072cf3bc79e3d5639.jpg", null);
                    boolean br3 = br("http://c.tieba.baidu.com/c/p/img?src=" + this.dmJ.imageUrl, null);
                    if (!br2 && !br3) {
                        testTask2.result = 2;
                        testTask2.dmM = this.mContext.getString(r.l.img_assistant_helptext_6_1);
                        if (this.rz != null) {
                            this.rz.append("_6:failed1");
                            return;
                        }
                        return;
                    } else if (br && br2 && br3) {
                        testTask2.result = 0;
                        this.dmL = true;
                        return;
                    } else if (br3) {
                        testTask2.result = 1;
                        testTask2.dmM = this.mContext.getString(r.l.img_assistant_helptext_6_2);
                        if (this.rz != null) {
                            this.rz.append("_6:warning");
                        }
                        this.dmL = true;
                        return;
                    } else {
                        testTask2.result = 2;
                        testTask2.dmM = this.mContext.getString(r.l.img_assistant_helptext_6_1);
                        if (this.rz != null) {
                            this.rz.append("_6:failed2");
                            return;
                        }
                        return;
                    }
                }
                testTask2.result = 2;
                testTask2.dmM = this.mContext.getString(r.l.img_assistant_helptext_6_1);
                if (this.rz != null) {
                    this.rz.append("_6:failed:iplist");
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
        t.m11do(this.rz.toString());
        if (this.dmL) {
            try {
                y yVar = new y(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.CDN_LOG_ADDRESS);
                yVar.n("ab_img_m", "1");
                yVar.ud();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    private boolean br(String str, String str2) {
        boolean z = false;
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            f fVar = new f();
            com.baidu.tbadk.core.util.a.f fVar2 = new com.baidu.tbadk.core.util.a.f(fVar);
            fVar.en().setUrl(str);
            if (str2 != null && str2.length() > 0) {
                fVar2.d(str2, "tbcdn.hiphotos.baidu.com", 1);
            } else {
                fVar2.d(null, null, 1);
            }
            z = fVar.eo().eu();
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
