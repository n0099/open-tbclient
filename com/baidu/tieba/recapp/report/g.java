package com.baidu.tieba.recapp.report;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.afd.ParseError;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.tbadkCore.data.AppData;
import com.baidu.tieba.tbadkCore.data.n;
/* loaded from: classes.dex */
public class g {
    public static c c(AdvertAppInfo advertAppInfo, int i, int i2) {
        if (advertAppInfo == null) {
            return null;
        }
        c cVar = new c();
        cVar.HY(i);
        cVar.RG(advertAppInfo.price);
        cVar.setExtInfo(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            cVar.HZ(-1);
            cVar.setPageNumber(-1);
        } else if ("NEWINDEX".equals(advertAppInfo.page)) {
            cVar.HZ(advertAppInfo.eyS);
            cVar.setPageNumber(i2);
        } else {
            cVar.HZ(com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, 0));
            cVar.setPageNumber(i2);
        }
        cVar.RJ(advertAppInfo.eza);
        cVar.RK(advertAppInfo.ezb);
        cVar.RL(advertAppInfo.ezc);
        cVar.RM(advertAppInfo.page);
        return cVar;
    }

    public static c a(AdvertAppInfo advertAppInfo, String str, int i, int i2) {
        if (advertAppInfo == null) {
            return null;
        }
        c cVar = new c();
        cVar.HY(i);
        cVar.setExtInfo(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            cVar.HZ(-1);
            cVar.setPageNumber(-1);
        } else if ("NEWINDEX".equals(advertAppInfo.page)) {
            cVar.HZ(advertAppInfo.eyS);
            cVar.setPageNumber(i2);
        } else {
            cVar.HZ(com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, 0));
            cVar.setPageNumber(i2);
        }
        cVar.RN(str);
        cVar.RM(advertAppInfo.page);
        return cVar;
    }

    public static c a(com.baidu.afd.d dVar, int i, int i2) {
        if (dVar == null) {
            return null;
        }
        return c(dVar.rq(), i, i2);
    }

    public static c d(AdvertAppInfo advertAppInfo, int i, int i2) {
        if (advertAppInfo == null) {
            return null;
        }
        c cVar = new c();
        cVar.HY(i);
        cVar.RG(advertAppInfo.price);
        cVar.setExtInfo(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            cVar.HZ(-1);
            cVar.setPageNumber(-1);
        } else {
            cVar.HZ(advertAppInfo.eyS);
            cVar.setPageNumber(i2);
        }
        cVar.RJ(advertAppInfo.eza);
        cVar.RK(advertAppInfo.ezb);
        cVar.RL(advertAppInfo.ezc);
        cVar.RM(advertAppInfo.page);
        return cVar;
    }

    public static c a(DownloadStaticsData downloadStaticsData, int i, int i2) {
        if (downloadStaticsData == null) {
            return null;
        }
        c cVar = new c();
        cVar.setDownloadStaticsData(downloadStaticsData);
        cVar.HY(i);
        cVar.setPageNumber(i2);
        return cVar;
    }

    public static c aa(int i, int i2, int i3) {
        c cVar = new c();
        cVar.HY(i);
        cVar.HZ(i2);
        cVar.setPageNumber(i3);
        return cVar;
    }

    public static c c(n nVar, int i) {
        if (nVar == null || nVar.dJN() == null) {
            return null;
        }
        AppData dJN = nVar.dJN();
        c cVar = new c();
        cVar.setExtInfo(dJN.ext_info);
        if (nVar.mWO) {
            cVar.HZ(-1);
            cVar.setPageNumber(-1);
        } else {
            cVar.HZ(com.baidu.adp.lib.f.b.toInt(dJN.pos_name, 0));
            cVar.setPageNumber(nVar.pageNumber);
        }
        cVar.HY(i);
        cVar.RG(dJN.price);
        cVar.RJ(nVar.eza);
        cVar.RK(nVar.ezb);
        cVar.RL(nVar.forumId);
        cVar.RM(nVar.dJQ());
        return cVar;
    }

    public static c a(AdvertAppInfo advertAppInfo, int i, int i2, int i3, int i4, int i5, int i6) {
        c c = c(advertAppInfo, i, i2);
        c.Ia(i3);
        c.Ib(i5);
        c.Ic(i4);
        if (i6 != -1 && i == 32) {
            c.Ie(i6);
        }
        c.RM(advertAppInfo.page);
        if (i == 2) {
            c.RI("video");
        }
        return c;
    }

    public static c a(com.baidu.afd.d dVar, int i, int i2, int i3, int i4, int i5, int i6) {
        c a2 = a(dVar, i, i2);
        a2.Ia(i3);
        a2.Ib(i5);
        a2.Ic(i4);
        if (i6 != -1 && i == 32) {
            a2.Ie(i6);
        }
        if (dVar != null) {
            a2.RM(dVar.rq().page);
        }
        if (i == 2) {
            a2.RI("video");
        }
        return a2;
    }

    public static c u(String str, int i, String str2) {
        return d(str, i, str2, "");
    }

    public static c d(String str, int i, String str2, String str3) {
        c cVar = new c();
        cVar.HY(i);
        cVar.RF(str2);
        cVar.RM("HOMEPAGE");
        cVar.setExtInfo(str);
        cVar.RN(str3);
        return cVar;
    }

    public static c a(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        c c = c(advertAppInfo, i, i2);
        c.Ia(i3);
        return c;
    }

    public static c b(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        c d = d(advertAppInfo, i, i2);
        d.Ia(i3);
        return d;
    }

    public static c a(com.baidu.afd.d dVar, ParseError parseError) {
        if (dVar == null || parseError == null) {
            return null;
        }
        c a2 = a(dVar, 5, dVar.getPageNum());
        a2.Ia(parseError.errorCode);
        return a2;
    }

    public static c o(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        c cVar = new c();
        cVar.HY(aVar.ZM);
        cVar.HZ(aVar.ZO);
        cVar.RM(aVar.ZN);
        cVar.setExtInfo(aVar.extraParam);
        return cVar;
    }

    public static c p(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        c cVar = new c();
        cVar.HY(aVar.ZM);
        cVar.HZ(aVar.ZO);
        cVar.RM(aVar.ZN);
        cVar.setExtInfo(aVar.extraParam);
        cVar.Ia(aVar.ZB);
        if (!TextUtils.isEmpty(aVar.tplName)) {
            cVar.RH(aVar.tplName);
        }
        cVar.Ic(aVar.ZC);
        return cVar;
    }

    public static c q(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        c cVar = new c();
        cVar.HY(aVar.ZM);
        cVar.HZ(aVar.ZO);
        cVar.RM(aVar.ZN);
        cVar.setExtInfo(aVar.extraParam);
        cVar.Ia(0);
        cVar.Ib(aVar.ZQ);
        cVar.Ic(aVar.ZP);
        cVar.Id(aVar.startPosition);
        return cVar;
    }

    public static c r(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        c cVar = new c();
        cVar.HY(aVar.ZM);
        cVar.HZ(aVar.ZO);
        cVar.RM(aVar.ZN);
        cVar.setExtInfo(aVar.extraParam);
        return cVar;
    }
}
