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
        if (oVar != null && oVar.dNC() != null && oVar.dNC().goods != null && oVar.dNC().goods.goods_style != 1001 && oVar.dNC().goods.goods_style != -1001) {
            c b = h.b(oVar, 5);
            b.Ic(i);
            if (i2 != -999) {
                b.Id(i2);
            }
            if (i3 != -999) {
                b.Ie(i3);
            }
            e.dEC().a(b);
            if (oVar != null && oVar.dNC() != null) {
                oVar.dNC().mDiscardReason = i;
            }
        }
    }

    public static void a(AdvertAppInfo advertAppInfo, int i, int i2) {
        a(advertAppInfo, i, i2, (int) AdCard.INVALID_NUM, (int) AdCard.INVALID_NUM);
    }

    public static void a(AdvertAppInfo advertAppInfo, int i, int i2, int i3, int i4) {
        if (advertAppInfo != null && advertAppInfo.eNd != null && advertAppInfo.eNd.eNs != 1001 && advertAppInfo.eNd.eNs != -1001) {
            c a2 = h.a(advertAppInfo, 5, i, i2);
            if (i3 != -999) {
                a2.Id(i3);
            }
            if (i4 != -999) {
                a2.Ie(i4);
            }
            if (i2 == 31) {
                if (TextUtils.isEmpty(mProcessName)) {
                    mProcessName = getProcessName();
                }
                a2.Sd(mProcessName);
            }
            e.dEC().a(a2);
            if (advertAppInfo.eNk != null) {
                advertAppInfo.eNk.mDiscardReason = 2;
            }
        }
    }

    public static void a(AdvertAppInfo advertAppInfo, int i, String str, int i2) {
        c b = h.b(advertAppInfo, 2, i);
        if (TextUtils.isEmpty(str)) {
            str = "hotarea";
        }
        b.Sj(str);
        e.dEC().a(b);
        a(b, i2);
        e.dEC().a(b);
    }

    public static void a(AdvertAppInfo advertAppInfo, int i, HashMap hashMap, int i2) {
        a(advertAppInfo, i, J(hashMap), i2);
    }

    public static void a(AdvertAppInfo advertAppInfo, int i, String str, String str2, String str3) {
        com.baidu.tbadk.distribute.a.bAX().a(advertAppInfo, str, 0L, advertAppInfo.page, "click", i);
        c c = h.c(advertAppInfo, 2, i);
        c.Se(str2);
        if (TextUtils.isEmpty(str3)) {
            str3 = "hotarea";
        }
        c.Sj(str3);
        e.dEC().a(c);
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

    private static void a(c cVar, int i) {
        cVar.Ia(706);
        boolean z = i == 1000;
        cVar.Sj(z ? "APP" : "URL");
        if (!z) {
            cVar.Id(i);
        }
        cVar.Si("DEEPLINK");
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
