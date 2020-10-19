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
        cVar.Hs(i);
        cVar.QR(advertAppInfo.price);
        cVar.setExtInfo(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            cVar.Ht(-1);
            cVar.setPageNumber(-1);
        } else if ("NEWINDEX".equals(advertAppInfo.page)) {
            cVar.Ht(advertAppInfo.ekz);
            cVar.setPageNumber(i2);
        } else {
            cVar.Ht(com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, 0));
            cVar.setPageNumber(i2);
        }
        cVar.QU(advertAppInfo.ekH);
        cVar.QV(advertAppInfo.ekI);
        cVar.QW(advertAppInfo.ekJ);
        cVar.QX(advertAppInfo.page);
        return cVar;
    }

    public static c a(AdvertAppInfo advertAppInfo, String str, int i, int i2) {
        if (advertAppInfo == null) {
            return null;
        }
        c cVar = new c();
        cVar.Hs(i);
        cVar.setExtInfo(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            cVar.Ht(-1);
            cVar.setPageNumber(-1);
        } else if ("NEWINDEX".equals(advertAppInfo.page)) {
            cVar.Ht(advertAppInfo.ekz);
            cVar.setPageNumber(i2);
        } else {
            cVar.Ht(com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, 0));
            cVar.setPageNumber(i2);
        }
        cVar.QY(str);
        cVar.QX(advertAppInfo.page);
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
        cVar.Hs(i);
        cVar.QR(advertAppInfo.price);
        cVar.setExtInfo(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            cVar.Ht(-1);
            cVar.setPageNumber(-1);
        } else {
            cVar.Ht(advertAppInfo.ekz);
            cVar.setPageNumber(i2);
        }
        cVar.QU(advertAppInfo.ekH);
        cVar.QV(advertAppInfo.ekI);
        cVar.QW(advertAppInfo.ekJ);
        cVar.QX(advertAppInfo.page);
        return cVar;
    }

    public static c a(DownloadStaticsData downloadStaticsData, int i, int i2) {
        if (downloadStaticsData == null) {
            return null;
        }
        c cVar = new c();
        cVar.setDownloadStaticsData(downloadStaticsData);
        cVar.Hs(i);
        cVar.setPageNumber(i2);
        return cVar;
    }

    public static c Z(int i, int i2, int i3) {
        c cVar = new c();
        cVar.Hs(i);
        cVar.Ht(i2);
        cVar.setPageNumber(i3);
        return cVar;
    }

    public static c c(n nVar, int i) {
        if (nVar == null || nVar.dEd() == null) {
            return null;
        }
        AppData dEd = nVar.dEd();
        c cVar = new c();
        cVar.setExtInfo(dEd.ext_info);
        if (nVar.mEe) {
            cVar.Ht(-1);
            cVar.setPageNumber(-1);
        } else {
            cVar.Ht(com.baidu.adp.lib.f.b.toInt(dEd.pos_name, 0));
            cVar.setPageNumber(nVar.pageNumber);
        }
        cVar.Hs(i);
        cVar.QR(dEd.price);
        cVar.QU(nVar.ekH);
        cVar.QV(nVar.ekI);
        cVar.QW(nVar.forumId);
        cVar.QX(nVar.dEg());
        return cVar;
    }

    public static c a(AdvertAppInfo advertAppInfo, int i, int i2, int i3, int i4, int i5, int i6) {
        c c = c(advertAppInfo, i, i2);
        c.Hu(i3);
        c.Hv(i5);
        c.Hw(i4);
        if (i6 != -1 && i == 32) {
            c.Hy(i6);
        }
        c.QX(advertAppInfo.page);
        if (i == 2) {
            c.QT("video");
        }
        return c;
    }

    public static c a(com.baidu.afd.d dVar, int i, int i2, int i3, int i4, int i5, int i6) {
        c a2 = a(dVar, i, i2);
        a2.Hu(i3);
        a2.Hv(i5);
        a2.Hw(i4);
        if (i6 != -1 && i == 32) {
            a2.Hy(i6);
        }
        if (dVar != null) {
            a2.QX(dVar.rq().page);
        }
        if (i == 2) {
            a2.QT("video");
        }
        return a2;
    }

    public static c t(String str, int i, String str2) {
        return d(str, i, str2, "");
    }

    public static c d(String str, int i, String str2, String str3) {
        c cVar = new c();
        cVar.Hs(i);
        cVar.QQ(str2);
        cVar.QX("HOMEPAGE");
        cVar.setExtInfo(str);
        cVar.QY(str3);
        return cVar;
    }

    public static c a(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        c c = c(advertAppInfo, i, i2);
        c.Hu(i3);
        return c;
    }

    public static c b(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        c d = d(advertAppInfo, i, i2);
        d.Hu(i3);
        return d;
    }

    public static c a(com.baidu.afd.d dVar, ParseError parseError) {
        if (dVar == null || parseError == null) {
            return null;
        }
        c a2 = a(dVar, 5, dVar.getPageNum());
        a2.Hu(parseError.errorCode);
        return a2;
    }

    public static c o(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        c cVar = new c();
        cVar.Hs(aVar.ZL);
        cVar.Ht(aVar.ZN);
        cVar.QX(aVar.ZM);
        cVar.setExtInfo(aVar.extraParam);
        return cVar;
    }

    public static c p(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        c cVar = new c();
        cVar.Hs(aVar.ZL);
        cVar.Ht(aVar.ZN);
        cVar.QX(aVar.ZM);
        cVar.setExtInfo(aVar.extraParam);
        cVar.Hu(aVar.ZA);
        if (!TextUtils.isEmpty(aVar.tplName)) {
            cVar.QS(aVar.tplName);
        }
        cVar.Hw(aVar.ZB);
        return cVar;
    }

    public static c q(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        c cVar = new c();
        cVar.Hs(aVar.ZL);
        cVar.Ht(aVar.ZN);
        cVar.QX(aVar.ZM);
        cVar.setExtInfo(aVar.extraParam);
        cVar.Hu(0);
        cVar.Hv(aVar.ZP);
        cVar.Hw(aVar.ZO);
        cVar.Hx(aVar.startPosition);
        return cVar;
    }

    public static c r(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        c cVar = new c();
        cVar.Hs(aVar.ZL);
        cVar.Ht(aVar.ZN);
        cVar.QX(aVar.ZM);
        cVar.setExtInfo(aVar.extraParam);
        return cVar;
    }
}
