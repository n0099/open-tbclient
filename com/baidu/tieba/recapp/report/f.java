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
        bVar.tT(i);
        bVar.uO(advertAppInfo.price);
        bVar.uM(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            bVar.tU(-1);
            bVar.setPageNumber(-1);
        } else if ("NEWINDEX".equals(advertAppInfo.page)) {
            bVar.tU(advertAppInfo.apw);
            bVar.setPageNumber(i2);
        } else {
            bVar.tU(com.baidu.adp.lib.g.b.l(advertAppInfo.adPosition, 0));
            bVar.setPageNumber(i2);
        }
        bVar.uQ(advertAppInfo.apE);
        bVar.uR(advertAppInfo.apF);
        bVar.uS(advertAppInfo.apG);
        bVar.uT(advertAppInfo.page);
        return bVar;
    }

    public static b a(AdvertAppInfo advertAppInfo, String str, int i, int i2) {
        if (advertAppInfo == null) {
            return null;
        }
        b bVar = new b();
        bVar.tT(i);
        bVar.uM(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            bVar.tU(-1);
            bVar.setPageNumber(-1);
        } else if ("NEWINDEX".equals(advertAppInfo.page)) {
            bVar.tU(advertAppInfo.apw);
            bVar.setPageNumber(i2);
        } else {
            bVar.tU(com.baidu.adp.lib.g.b.l(advertAppInfo.adPosition, 0));
            bVar.setPageNumber(i2);
        }
        bVar.uU(str);
        bVar.uT(advertAppInfo.page);
        return bVar;
    }

    public static b a(com.baidu.afd.d dVar, int i, int i2) {
        if (dVar == null) {
            return null;
        }
        return c(dVar.pu(), i, i2);
    }

    public static b d(AdvertAppInfo advertAppInfo, int i, int i2) {
        if (advertAppInfo == null) {
            return null;
        }
        b bVar = new b();
        bVar.tT(i);
        bVar.uO(advertAppInfo.price);
        bVar.uM(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            bVar.tU(-1);
            bVar.setPageNumber(-1);
        } else {
            bVar.tU(advertAppInfo.apw);
            bVar.setPageNumber(i2);
        }
        bVar.uQ(advertAppInfo.apE);
        bVar.uR(advertAppInfo.apF);
        bVar.uS(advertAppInfo.apG);
        bVar.uT(advertAppInfo.page);
        return bVar;
    }

    public static b a(DownloadStaticsData downloadStaticsData, int i, int i2) {
        if (downloadStaticsData == null) {
            return null;
        }
        b bVar = new b();
        bVar.setDownloadStaticsData(downloadStaticsData);
        bVar.tT(i);
        bVar.setPageNumber(i2);
        return bVar;
    }

    public static b aa(int i, int i2, int i3) {
        b bVar = new b();
        bVar.tT(i);
        bVar.tU(i2);
        bVar.setPageNumber(i3);
        return bVar;
    }

    public static b c(l lVar, int i) {
        if (lVar == null || lVar.bDf() == null) {
            return null;
        }
        AppData bDf = lVar.bDf();
        b bVar = new b();
        bVar.uM(bDf.ext_info);
        if (lVar.hlk) {
            bVar.tU(-1);
            bVar.setPageNumber(-1);
        } else {
            bVar.tU(com.baidu.adp.lib.g.b.l(bDf.pos_name, 0));
            bVar.setPageNumber(lVar.pageNumber);
        }
        bVar.tT(i);
        bVar.uO(bDf.price);
        bVar.uQ(lVar.apE);
        bVar.uR(lVar.apF);
        bVar.uS(lVar.forumId);
        bVar.uT(lVar.bDi());
        return bVar;
    }

    public static b a(AdvertAppInfo advertAppInfo, int i, int i2, int i3, int i4, int i5, int i6) {
        b c = c(advertAppInfo, i, i2);
        c.tV(i3);
        c.tW(i5);
        c.tX(i4);
        if (i6 != -1 && i == 32) {
            c.tY(i6);
        }
        c.uT(advertAppInfo.page);
        if (i == 2) {
            c.uP("video");
        }
        return c;
    }

    public static b a(com.baidu.afd.d dVar, int i, int i2, int i3, int i4, int i5, int i6) {
        b a = a(dVar, i, i2);
        a.tV(i3);
        a.tW(i5);
        a.tX(i4);
        if (i6 != -1 && i == 32) {
            a.tY(i6);
        }
        if (dVar != null) {
            a.uT(dVar.pu().page);
        }
        if (i == 2) {
            a.uP("video");
        }
        return a;
    }

    public static b l(String str, int i, String str2) {
        return b(str, i, str2, "");
    }

    public static b b(String str, int i, String str2, String str3) {
        b bVar = new b();
        bVar.tT(i);
        bVar.uN(str2);
        bVar.uT("HOMEPAGE");
        bVar.uM(str);
        bVar.uU(str3);
        return bVar;
    }

    public static b a(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        b c = c(advertAppInfo, i, i2);
        c.tV(i3);
        return c;
    }

    public static b b(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        b d = d(advertAppInfo, i, i2);
        d.tV(i3);
        return d;
    }

    public static b a(com.baidu.afd.d dVar, ParseError parseError) {
        if (dVar == null || parseError == null) {
            return null;
        }
        b a = a(dVar, 5, dVar.getPageNum());
        a.tV(parseError.errorCode);
        return a;
    }
}
