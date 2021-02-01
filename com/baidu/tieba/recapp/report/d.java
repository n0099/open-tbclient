package com.baidu.tieba.recapp.report;

import android.app.ActivityManager;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.tbadkCore.data.o;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.HashMap;
/* loaded from: classes.dex */
public class d {
    private static String mProcessName = null;

    public static void a(o oVar, int i) {
        a(oVar, i, (int) AdCard.INVALID_NUM, (int) AdCard.INVALID_NUM);
    }

    public static void a(o oVar, int i, int i2, int i3) {
        if (oVar != null && oVar.dNl() != null && oVar.dNl().goods != null && oVar.dNl().goods.goods_style != 1001 && oVar.dNl().goods.goods_style != -1001) {
            c b2 = h.b(oVar, 5);
            b2.HY(i);
            if (i2 != -999) {
                b2.HZ(i2);
            }
            if (i3 != -999) {
                b2.Ia(i3);
            }
            e.dEm().a(b2);
            if (oVar != null && oVar.dNl() != null) {
                oVar.dNl().mDiscardReason = i;
            }
        }
    }

    public static void a(AdvertAppInfo advertAppInfo, int i, int i2) {
        a(advertAppInfo, i, i2, (int) AdCard.INVALID_NUM, (int) AdCard.INVALID_NUM);
    }

    public static void a(AdvertAppInfo advertAppInfo, int i, int i2, int i3, int i4) {
        if (advertAppInfo != null && advertAppInfo.eLD != null && advertAppInfo.eLD.eLR != 1001 && advertAppInfo.eLD.eLR != -1001) {
            c a2 = h.a(advertAppInfo, 5, i, i2);
            if (i3 != -999) {
                a2.HZ(i3);
            }
            if (i4 != -999) {
                a2.Ia(i4);
            }
            if (i2 == 31) {
                if (TextUtils.isEmpty(mProcessName)) {
                    mProcessName = getProcessName();
                }
                a2.RL(mProcessName);
            }
            e.dEm().a(a2);
            if (advertAppInfo.eLK != null) {
                advertAppInfo.eLK.mDiscardReason = 2;
            }
        }
    }

    public static void a(AdvertAppInfo advertAppInfo, int i, String str, int i2) {
        c b2 = h.b(advertAppInfo, 2, i);
        if (TextUtils.isEmpty(str)) {
            str = "hotarea";
        }
        b2.RR(str);
        e.dEm().a(b2);
        b2.HW(706);
        boolean z = i2 == 1000;
        b2.RR(z ? "APP" : "URL");
        if (!z) {
            b2.HZ(i2);
        }
        b2.RQ("DEEPLINK");
        e.dEm().a(b2);
    }

    public static void a(AdvertAppInfo advertAppInfo, int i, HashMap hashMap, int i2) {
        a(advertAppInfo, i, J(hashMap), i2);
    }

    public static void a(AdvertAppInfo advertAppInfo, int i, String str, String str2, String str3) {
        com.baidu.tbadk.distribute.a.bAU().a(advertAppInfo, str, 0L, advertAppInfo.page, "click", i);
        c c = h.c(advertAppInfo, 2, i);
        c.RM(str2);
        if (TextUtils.isEmpty(str3)) {
            str3 = "hotarea";
        }
        c.RR(str3);
        e.dEm().a(c);
    }

    public static void a(AdvertAppInfo advertAppInfo, int i, String str, String str2, HashMap hashMap) {
        a(advertAppInfo, i, str, str2, J(hashMap));
    }

    private static String J(HashMap hashMap) {
        String str = null;
        if (hashMap != null) {
            str = String.valueOf(hashMap.get("da_area"));
        }
        if (TextUtils.isEmpty(str)) {
            return "hotarea";
        }
        return str;
    }

    private static String getProcessName() {
        try {
            int myPid = Process.myPid();
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) TbadkCoreApplication.getInst().getContext().getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == myPid) {
                    return runningAppProcessInfo.processName;
                }
            }
            return "GET_PROCESS_NAME_FAIL";
        } catch (Exception e) {
            return "GET_PROCESS_NAME_FAIL";
        }
    }
}
