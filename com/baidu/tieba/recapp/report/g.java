package com.baidu.tieba.recapp.report;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.afd.ParseError;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.tbadkCore.data.AppData;
import com.baidu.tieba.tbadkCore.data.m;
/* loaded from: classes.dex */
public class g {
    public static c c(AdvertAppInfo advertAppInfo, int i, int i2) {
        if (advertAppInfo == null) {
            return null;
        }
        c cVar = new c();
        cVar.BG(i);
        cVar.JH(advertAppInfo.price);
        cVar.JF(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            cVar.BH(-1);
            cVar.setPageNumber(-1);
        } else if ("NEWINDEX".equals(advertAppInfo.page)) {
            cVar.BH(advertAppInfo.dms);
            cVar.setPageNumber(i2);
        } else {
            cVar.BH(com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, 0));
            cVar.setPageNumber(i2);
        }
        cVar.JK(advertAppInfo.dmA);
        cVar.JL(advertAppInfo.dmB);
        cVar.JM(advertAppInfo.dmC);
        cVar.JN(advertAppInfo.page);
        return cVar;
    }

    public static c a(AdvertAppInfo advertAppInfo, String str, int i, int i2) {
        if (advertAppInfo == null) {
            return null;
        }
        c cVar = new c();
        cVar.BG(i);
        cVar.JF(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            cVar.BH(-1);
            cVar.setPageNumber(-1);
        } else if ("NEWINDEX".equals(advertAppInfo.page)) {
            cVar.BH(advertAppInfo.dms);
            cVar.setPageNumber(i2);
        } else {
            cVar.BH(com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, 0));
            cVar.setPageNumber(i2);
        }
        cVar.JO(str);
        cVar.JN(advertAppInfo.page);
        return cVar;
    }

    public static c a(com.baidu.afd.d dVar, int i, int i2) {
        if (dVar == null) {
            return null;
        }
        return c(dVar.po(), i, i2);
    }

    public static c d(AdvertAppInfo advertAppInfo, int i, int i2) {
        if (advertAppInfo == null) {
            return null;
        }
        c cVar = new c();
        cVar.BG(i);
        cVar.JH(advertAppInfo.price);
        cVar.JF(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            cVar.BH(-1);
            cVar.setPageNumber(-1);
        } else {
            cVar.BH(advertAppInfo.dms);
            cVar.setPageNumber(i2);
        }
        cVar.JK(advertAppInfo.dmA);
        cVar.JL(advertAppInfo.dmB);
        cVar.JM(advertAppInfo.dmC);
        cVar.JN(advertAppInfo.page);
        return cVar;
    }

    public static c a(DownloadStaticsData downloadStaticsData, int i, int i2) {
        if (downloadStaticsData == null) {
            return null;
        }
        c cVar = new c();
        cVar.setDownloadStaticsData(downloadStaticsData);
        cVar.BG(i);
        cVar.setPageNumber(i2);
        return cVar;
    }

    public static c ab(int i, int i2, int i3) {
        c cVar = new c();
        cVar.BG(i);
        cVar.BH(i2);
        cVar.setPageNumber(i3);
        return cVar;
    }

    public static c c(m mVar, int i) {
        if (mVar == null || mVar.cWf() == null) {
            return null;
        }
        AppData cWf = mVar.cWf();
        c cVar = new c();
        cVar.JF(cWf.ext_info);
        if (mVar.kSl) {
            cVar.BH(-1);
            cVar.setPageNumber(-1);
        } else {
            cVar.BH(com.baidu.adp.lib.f.b.toInt(cWf.pos_name, 0));
            cVar.setPageNumber(mVar.pageNumber);
        }
        cVar.BG(i);
        cVar.JH(cWf.price);
        cVar.JK(mVar.dmA);
        cVar.JL(mVar.dmB);
        cVar.JM(mVar.forumId);
        cVar.JN(mVar.cWi());
        return cVar;
    }

    public static c a(AdvertAppInfo advertAppInfo, int i, int i2, int i3, int i4, int i5, int i6) {
        c c = c(advertAppInfo, i, i2);
        c.BI(i3);
        c.BJ(i5);
        c.BK(i4);
        if (i6 != -1 && i == 32) {
            c.BM(i6);
        }
        c.JN(advertAppInfo.page);
        if (i == 2) {
            c.JJ("video");
        }
        return c;
    }

    public static c a(com.baidu.afd.d dVar, int i, int i2, int i3, int i4, int i5, int i6) {
        c a = a(dVar, i, i2);
        a.BI(i3);
        a.BJ(i5);
        a.BK(i4);
        if (i6 != -1 && i == 32) {
            a.BM(i6);
        }
        if (dVar != null) {
            a.JN(dVar.po().page);
        }
        if (i == 2) {
            a.JJ("video");
        }
        return a;
    }

    public static c u(String str, int i, String str2) {
        return c(str, i, str2, "");
    }

    public static c c(String str, int i, String str2, String str3) {
        c cVar = new c();
        cVar.BG(i);
        cVar.JG(str2);
        cVar.JN("HOMEPAGE");
        cVar.JF(str);
        cVar.JO(str3);
        return cVar;
    }

    public static c a(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        c c = c(advertAppInfo, i, i2);
        c.BI(i3);
        return c;
    }

    public static c b(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        c d = d(advertAppInfo, i, i2);
        d.BI(i3);
        return d;
    }

    public static c a(com.baidu.afd.d dVar, ParseError parseError) {
        if (dVar == null || parseError == null) {
            return null;
        }
        c a = a(dVar, 5, dVar.getPageNum());
        a.BI(parseError.errorCode);
        return a;
    }

    public static c o(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        c cVar = new c();
        cVar.BG(aVar.XI);
        cVar.BH(aVar.XK);
        cVar.JN(aVar.XJ);
        cVar.JF(aVar.extraParam);
        return cVar;
    }

    public static c p(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        c cVar = new c();
        cVar.BG(aVar.XI);
        cVar.BH(aVar.XK);
        cVar.JN(aVar.XJ);
        cVar.JF(aVar.extraParam);
        cVar.BI(aVar.Xx);
        if (!TextUtils.isEmpty(aVar.tplName)) {
            cVar.JI(aVar.tplName);
        }
        cVar.BK(aVar.Xy);
        return cVar;
    }

    public static c q(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        c cVar = new c();
        cVar.BG(aVar.XI);
        cVar.BH(aVar.XK);
        cVar.JN(aVar.XJ);
        cVar.JF(aVar.extraParam);
        cVar.BI(0);
        cVar.BJ(aVar.XM);
        cVar.BK(aVar.XL);
        cVar.BL(aVar.startPosition);
        return cVar;
    }

    public static c r(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        c cVar = new c();
        cVar.BG(aVar.XI);
        cVar.BH(aVar.XK);
        cVar.JN(aVar.XJ);
        cVar.JF(aVar.extraParam);
        return cVar;
    }
}
