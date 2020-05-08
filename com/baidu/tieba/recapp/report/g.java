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
        cVar.JK(advertAppInfo.price);
        cVar.JI(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            cVar.BH(-1);
            cVar.setPageNumber(-1);
        } else if ("NEWINDEX".equals(advertAppInfo.page)) {
            cVar.BH(advertAppInfo.dmw);
            cVar.setPageNumber(i2);
        } else {
            cVar.BH(com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, 0));
            cVar.setPageNumber(i2);
        }
        cVar.JN(advertAppInfo.dmE);
        cVar.JO(advertAppInfo.dmF);
        cVar.JP(advertAppInfo.dmG);
        cVar.JQ(advertAppInfo.page);
        return cVar;
    }

    public static c a(AdvertAppInfo advertAppInfo, String str, int i, int i2) {
        if (advertAppInfo == null) {
            return null;
        }
        c cVar = new c();
        cVar.BG(i);
        cVar.JI(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            cVar.BH(-1);
            cVar.setPageNumber(-1);
        } else if ("NEWINDEX".equals(advertAppInfo.page)) {
            cVar.BH(advertAppInfo.dmw);
            cVar.setPageNumber(i2);
        } else {
            cVar.BH(com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, 0));
            cVar.setPageNumber(i2);
        }
        cVar.JR(str);
        cVar.JQ(advertAppInfo.page);
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
        cVar.JK(advertAppInfo.price);
        cVar.JI(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            cVar.BH(-1);
            cVar.setPageNumber(-1);
        } else {
            cVar.BH(advertAppInfo.dmw);
            cVar.setPageNumber(i2);
        }
        cVar.JN(advertAppInfo.dmE);
        cVar.JO(advertAppInfo.dmF);
        cVar.JP(advertAppInfo.dmG);
        cVar.JQ(advertAppInfo.page);
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
        if (mVar == null || mVar.cWc() == null) {
            return null;
        }
        AppData cWc = mVar.cWc();
        c cVar = new c();
        cVar.JI(cWc.ext_info);
        if (mVar.kSp) {
            cVar.BH(-1);
            cVar.setPageNumber(-1);
        } else {
            cVar.BH(com.baidu.adp.lib.f.b.toInt(cWc.pos_name, 0));
            cVar.setPageNumber(mVar.pageNumber);
        }
        cVar.BG(i);
        cVar.JK(cWc.price);
        cVar.JN(mVar.dmE);
        cVar.JO(mVar.dmF);
        cVar.JP(mVar.forumId);
        cVar.JQ(mVar.cWf());
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
        c.JQ(advertAppInfo.page);
        if (i == 2) {
            c.JM("video");
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
            a.JQ(dVar.po().page);
        }
        if (i == 2) {
            a.JM("video");
        }
        return a;
    }

    public static c u(String str, int i, String str2) {
        return c(str, i, str2, "");
    }

    public static c c(String str, int i, String str2, String str3) {
        c cVar = new c();
        cVar.BG(i);
        cVar.JJ(str2);
        cVar.JQ("HOMEPAGE");
        cVar.JI(str);
        cVar.JR(str3);
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
        cVar.BG(aVar.XL);
        cVar.BH(aVar.XN);
        cVar.JQ(aVar.XM);
        cVar.JI(aVar.extraParam);
        return cVar;
    }

    public static c p(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        c cVar = new c();
        cVar.BG(aVar.XL);
        cVar.BH(aVar.XN);
        cVar.JQ(aVar.XM);
        cVar.JI(aVar.extraParam);
        cVar.BI(aVar.XA);
        if (!TextUtils.isEmpty(aVar.tplName)) {
            cVar.JL(aVar.tplName);
        }
        cVar.BK(aVar.XB);
        return cVar;
    }

    public static c q(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        c cVar = new c();
        cVar.BG(aVar.XL);
        cVar.BH(aVar.XN);
        cVar.JQ(aVar.XM);
        cVar.JI(aVar.extraParam);
        cVar.BI(0);
        cVar.BJ(aVar.XP);
        cVar.BK(aVar.XO);
        cVar.BL(aVar.startPosition);
        return cVar;
    }

    public static c r(@NonNull com.baidu.afd.videopaster.b.a aVar) {
        c cVar = new c();
        cVar.BG(aVar.XL);
        cVar.BH(aVar.XN);
        cVar.JQ(aVar.XM);
        cVar.JI(aVar.extraParam);
        return cVar;
    }
}
