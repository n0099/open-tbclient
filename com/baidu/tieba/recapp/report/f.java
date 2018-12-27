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
        bVar.ug(i);
        bVar.uR(advertAppInfo.price);
        bVar.uP(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            bVar.uh(-1);
            bVar.setPageNumber(-1);
        } else if ("NEWINDEX".equals(advertAppInfo.page)) {
            bVar.uh(advertAppInfo.apw);
            bVar.setPageNumber(i2);
        } else {
            bVar.uh(com.baidu.adp.lib.g.b.l(advertAppInfo.adPosition, 0));
            bVar.setPageNumber(i2);
        }
        bVar.uT(advertAppInfo.apE);
        bVar.uU(advertAppInfo.apF);
        bVar.uV(advertAppInfo.apG);
        bVar.uW(advertAppInfo.page);
        return bVar;
    }

    public static b a(AdvertAppInfo advertAppInfo, String str, int i, int i2) {
        if (advertAppInfo == null) {
            return null;
        }
        b bVar = new b();
        bVar.ug(i);
        bVar.uP(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            bVar.uh(-1);
            bVar.setPageNumber(-1);
        } else if ("NEWINDEX".equals(advertAppInfo.page)) {
            bVar.uh(advertAppInfo.apw);
            bVar.setPageNumber(i2);
        } else {
            bVar.uh(com.baidu.adp.lib.g.b.l(advertAppInfo.adPosition, 0));
            bVar.setPageNumber(i2);
        }
        bVar.uX(str);
        bVar.uW(advertAppInfo.page);
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
        bVar.ug(i);
        bVar.uR(advertAppInfo.price);
        bVar.uP(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            bVar.uh(-1);
            bVar.setPageNumber(-1);
        } else {
            bVar.uh(advertAppInfo.apw);
            bVar.setPageNumber(i2);
        }
        bVar.uT(advertAppInfo.apE);
        bVar.uU(advertAppInfo.apF);
        bVar.uV(advertAppInfo.apG);
        bVar.uW(advertAppInfo.page);
        return bVar;
    }

    public static b a(DownloadStaticsData downloadStaticsData, int i, int i2) {
        if (downloadStaticsData == null) {
            return null;
        }
        b bVar = new b();
        bVar.setDownloadStaticsData(downloadStaticsData);
        bVar.ug(i);
        bVar.setPageNumber(i2);
        return bVar;
    }

    public static b aa(int i, int i2, int i3) {
        b bVar = new b();
        bVar.ug(i);
        bVar.uh(i2);
        bVar.setPageNumber(i3);
        return bVar;
    }

    public static b c(l lVar, int i) {
        if (lVar == null || lVar.bDX() == null) {
            return null;
        }
        AppData bDX = lVar.bDX();
        b bVar = new b();
        bVar.uP(bDX.ext_info);
        if (lVar.hov) {
            bVar.uh(-1);
            bVar.setPageNumber(-1);
        } else {
            bVar.uh(com.baidu.adp.lib.g.b.l(bDX.pos_name, 0));
            bVar.setPageNumber(lVar.pageNumber);
        }
        bVar.ug(i);
        bVar.uR(bDX.price);
        bVar.uT(lVar.apE);
        bVar.uU(lVar.apF);
        bVar.uV(lVar.forumId);
        bVar.uW(lVar.bEa());
        return bVar;
    }

    public static b a(AdvertAppInfo advertAppInfo, int i, int i2, int i3, int i4, int i5, int i6) {
        b c = c(advertAppInfo, i, i2);
        c.ui(i3);
        c.uj(i5);
        c.uk(i4);
        if (i6 != -1 && i == 32) {
            c.ul(i6);
        }
        c.uW(advertAppInfo.page);
        if (i == 2) {
            c.uS("video");
        }
        return c;
    }

    public static b a(com.baidu.afd.d dVar, int i, int i2, int i3, int i4, int i5, int i6) {
        b a = a(dVar, i, i2);
        a.ui(i3);
        a.uj(i5);
        a.uk(i4);
        if (i6 != -1 && i == 32) {
            a.ul(i6);
        }
        if (dVar != null) {
            a.uW(dVar.pu().page);
        }
        if (i == 2) {
            a.uS("video");
        }
        return a;
    }

    public static b l(String str, int i, String str2) {
        return b(str, i, str2, "");
    }

    public static b b(String str, int i, String str2, String str3) {
        b bVar = new b();
        bVar.ug(i);
        bVar.uQ(str2);
        bVar.uW("HOMEPAGE");
        bVar.uP(str);
        bVar.uX(str3);
        return bVar;
    }

    public static b a(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        b c = c(advertAppInfo, i, i2);
        c.ui(i3);
        return c;
    }

    public static b b(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        b d = d(advertAppInfo, i, i2);
        d.ui(i3);
        return d;
    }

    public static b a(com.baidu.afd.d dVar, ParseError parseError) {
        if (dVar == null || parseError == null) {
            return null;
        }
        b a = a(dVar, 5, dVar.getPageNum());
        a.ui(parseError.errorCode);
        return a;
    }
}
