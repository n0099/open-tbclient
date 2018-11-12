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
        bVar.tz(i);
        bVar.un(advertAppInfo.price);
        bVar.ul(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            bVar.tA(-1);
            bVar.setPageNumber(-1);
        } else if ("NEWINDEX".equals(advertAppInfo.page)) {
            bVar.tA(advertAppInfo.alV);
            bVar.setPageNumber(i2);
        } else {
            bVar.tA(com.baidu.adp.lib.g.b.l(advertAppInfo.adPosition, 0));
            bVar.setPageNumber(i2);
        }
        bVar.up(advertAppInfo.amd);
        bVar.uq(advertAppInfo.ame);
        bVar.ur(advertAppInfo.amf);
        bVar.us(advertAppInfo.page);
        return bVar;
    }

    public static b a(AdvertAppInfo advertAppInfo, String str, int i, int i2) {
        if (advertAppInfo == null) {
            return null;
        }
        b bVar = new b();
        bVar.tz(i);
        bVar.ul(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            bVar.tA(-1);
            bVar.setPageNumber(-1);
        } else if ("NEWINDEX".equals(advertAppInfo.page)) {
            bVar.tA(advertAppInfo.alV);
            bVar.setPageNumber(i2);
        } else {
            bVar.tA(com.baidu.adp.lib.g.b.l(advertAppInfo.adPosition, 0));
            bVar.setPageNumber(i2);
        }
        bVar.ut(str);
        bVar.us(advertAppInfo.page);
        return bVar;
    }

    public static b a(com.baidu.afd.d dVar, int i, int i2) {
        if (dVar == null) {
            return null;
        }
        return c(dVar.pv(), i, i2);
    }

    public static b d(AdvertAppInfo advertAppInfo, int i, int i2) {
        if (advertAppInfo == null) {
            return null;
        }
        b bVar = new b();
        bVar.tz(i);
        bVar.un(advertAppInfo.price);
        bVar.ul(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            bVar.tA(-1);
            bVar.setPageNumber(-1);
        } else {
            bVar.tA(advertAppInfo.alV);
            bVar.setPageNumber(i2);
        }
        bVar.up(advertAppInfo.amd);
        bVar.uq(advertAppInfo.ame);
        bVar.ur(advertAppInfo.amf);
        bVar.us(advertAppInfo.page);
        return bVar;
    }

    public static b a(DownloadStaticsData downloadStaticsData, int i, int i2) {
        if (downloadStaticsData == null) {
            return null;
        }
        b bVar = new b();
        bVar.setDownloadStaticsData(downloadStaticsData);
        bVar.tz(i);
        bVar.setPageNumber(i2);
        return bVar;
    }

    public static b aa(int i, int i2, int i3) {
        b bVar = new b();
        bVar.tz(i);
        bVar.tA(i2);
        bVar.setPageNumber(i3);
        return bVar;
    }

    public static b c(l lVar, int i) {
        if (lVar == null || lVar.bBl() == null) {
            return null;
        }
        AppData bBl = lVar.bBl();
        b bVar = new b();
        bVar.ul(bBl.ext_info);
        if (lVar.heq) {
            bVar.tA(-1);
            bVar.setPageNumber(-1);
        } else {
            bVar.tA(com.baidu.adp.lib.g.b.l(bBl.pos_name, 0));
            bVar.setPageNumber(lVar.pageNumber);
        }
        bVar.tz(i);
        bVar.un(bBl.price);
        bVar.up(lVar.amd);
        bVar.uq(lVar.ame);
        bVar.ur(lVar.forumId);
        bVar.us(lVar.bBo());
        return bVar;
    }

    public static b a(AdvertAppInfo advertAppInfo, int i, int i2, int i3, int i4, int i5, int i6) {
        b c = c(advertAppInfo, i, i2);
        c.tB(i3);
        c.tC(i5);
        c.tD(i4);
        if (i6 != -1 && i == 32) {
            c.tE(i6);
        }
        c.us(advertAppInfo.page);
        if (i == 2) {
            c.uo("video");
        }
        return c;
    }

    public static b a(com.baidu.afd.d dVar, int i, int i2, int i3, int i4, int i5, int i6) {
        b a = a(dVar, i, i2);
        a.tB(i3);
        a.tC(i5);
        a.tD(i4);
        if (i6 != -1 && i == 32) {
            a.tE(i6);
        }
        if (dVar != null) {
            a.us(dVar.pv().page);
        }
        if (i == 2) {
            a.uo("video");
        }
        return a;
    }

    public static b l(String str, int i, String str2) {
        return b(str, i, str2, "");
    }

    public static b b(String str, int i, String str2, String str3) {
        b bVar = new b();
        bVar.tz(i);
        bVar.um(str2);
        bVar.us("HOMEPAGE");
        bVar.ul(str);
        bVar.ut(str3);
        return bVar;
    }

    public static b a(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        b c = c(advertAppInfo, i, i2);
        c.tB(i3);
        return c;
    }

    public static b b(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        b d = d(advertAppInfo, i, i2);
        d.tB(i3);
        return d;
    }

    public static b a(com.baidu.afd.d dVar, ParseError parseError) {
        if (dVar == null || parseError == null) {
            return null;
        }
        b a = a(dVar, 5, dVar.getPageNum());
        a.tB(parseError.errorCode);
        return a;
    }
}
