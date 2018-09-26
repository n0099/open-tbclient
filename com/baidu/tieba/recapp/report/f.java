package com.baidu.tieba.recapp.report;

import com.baidu.afd.ParseError;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.tbadkCore.data.AppData;
import com.baidu.tieba.tbadkCore.data.l;
/* loaded from: classes.dex */
public class f {
    public static b c(AdvertAppInfo advertAppInfo, int i, int i2) {
        if (advertAppInfo == null) {
            return null;
        }
        b bVar = new b();
        bVar.sJ(i);
        bVar.tH(advertAppInfo.price);
        bVar.tF(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            bVar.sK(-1);
            bVar.setPageNumber(-1);
        } else if ("NEWINDEX".equals(advertAppInfo.page)) {
            bVar.sK(advertAppInfo.agl);
            bVar.setPageNumber(i2);
        } else {
            bVar.sK(com.baidu.adp.lib.g.b.l(advertAppInfo.adPosition, 0));
            bVar.setPageNumber(i2);
        }
        bVar.tJ(advertAppInfo.agu);
        bVar.tK(advertAppInfo.agv);
        bVar.tL(advertAppInfo.agw);
        bVar.tM(advertAppInfo.page);
        return bVar;
    }

    public static b a(AdvertAppInfo advertAppInfo, String str, int i, int i2) {
        if (advertAppInfo == null) {
            return null;
        }
        b bVar = new b();
        bVar.sJ(i);
        bVar.tF(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            bVar.sK(-1);
            bVar.setPageNumber(-1);
        } else if ("NEWINDEX".equals(advertAppInfo.page)) {
            bVar.sK(advertAppInfo.agl);
            bVar.setPageNumber(i2);
        } else {
            bVar.sK(com.baidu.adp.lib.g.b.l(advertAppInfo.adPosition, 0));
            bVar.setPageNumber(i2);
        }
        bVar.tN(str);
        bVar.tM(advertAppInfo.page);
        return bVar;
    }

    public static b a(com.baidu.afd.d dVar, int i, int i2) {
        if (dVar == null) {
            return null;
        }
        return c(dVar.pp(), i, i2);
    }

    public static b d(AdvertAppInfo advertAppInfo, int i, int i2) {
        if (advertAppInfo == null) {
            return null;
        }
        b bVar = new b();
        bVar.sJ(i);
        bVar.tH(advertAppInfo.price);
        bVar.tF(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            bVar.sK(-1);
            bVar.setPageNumber(-1);
        } else {
            bVar.sK(advertAppInfo.agl);
            bVar.setPageNumber(i2);
        }
        bVar.tJ(advertAppInfo.agu);
        bVar.tK(advertAppInfo.agv);
        bVar.tL(advertAppInfo.agw);
        bVar.tM(advertAppInfo.page);
        return bVar;
    }

    public static b a(DownloadStaticsData downloadStaticsData, int i, int i2) {
        if (downloadStaticsData == null) {
            return null;
        }
        b bVar = new b();
        bVar.setDownloadStaticsData(downloadStaticsData);
        bVar.sJ(i);
        bVar.setPageNumber(i2);
        return bVar;
    }

    public static b aa(int i, int i2, int i3) {
        b bVar = new b();
        bVar.sJ(i);
        bVar.sK(i2);
        bVar.setPageNumber(i3);
        return bVar;
    }

    public static b c(l lVar, int i) {
        if (lVar == null || lVar.byA() == null) {
            return null;
        }
        AppData byA = lVar.byA();
        b bVar = new b();
        bVar.tF(byA.ext_info);
        if (lVar.gVx) {
            bVar.sK(-1);
            bVar.setPageNumber(-1);
        } else {
            bVar.sK(com.baidu.adp.lib.g.b.l(byA.pos_name, 0));
            bVar.setPageNumber(lVar.pageNumber);
        }
        bVar.sJ(i);
        bVar.tH(byA.price);
        bVar.tJ(lVar.agu);
        bVar.tK(lVar.agv);
        bVar.tL(lVar.forumId);
        bVar.tM(lVar.byD());
        return bVar;
    }

    public static b a(AdvertAppInfo advertAppInfo, int i, int i2, int i3, int i4, int i5, int i6) {
        b c = c(advertAppInfo, i, i2);
        c.sL(i3);
        c.sM(i5);
        c.sN(i4);
        if (i6 != -1 && i == 32) {
            c.sO(i6);
        }
        c.tM(advertAppInfo.page);
        if (i == 2) {
            c.tI("video");
        }
        return c;
    }

    public static b a(com.baidu.afd.d dVar, int i, int i2, int i3, int i4, int i5, int i6) {
        b a = a(dVar, i, i2);
        a.sL(i3);
        a.sM(i5);
        a.sN(i4);
        if (i6 != -1 && i == 32) {
            a.sO(i6);
        }
        if (dVar != null) {
            a.tM(dVar.pp().page);
        }
        if (i == 2) {
            a.tI("video");
        }
        return a;
    }

    public static b l(String str, int i, String str2) {
        return b(str, i, str2, "");
    }

    public static b b(String str, int i, String str2, String str3) {
        b bVar = new b();
        bVar.sJ(i);
        bVar.tG(str2);
        bVar.tM("HOMEPAGE");
        bVar.tF(str);
        bVar.tN(str3);
        return bVar;
    }

    public static b a(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        b c = c(advertAppInfo, i, i2);
        c.sL(i3);
        return c;
    }

    public static b b(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        b d = d(advertAppInfo, i, i2);
        d.sL(i3);
        return d;
    }

    public static b a(com.baidu.afd.d dVar, ParseError parseError) {
        if (dVar == null || parseError == null) {
            return null;
        }
        b a = a(dVar, 5, dVar.getPageNum());
        a.sL(parseError.errorCode);
        return a;
    }
}
