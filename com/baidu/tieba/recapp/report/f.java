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
        bVar.tg(i);
        bVar.uj(advertAppInfo.price);
        bVar.uh(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            bVar.th(-1);
            bVar.setPageNumber(-1);
        } else if ("NEWINDEX".equals(advertAppInfo.page)) {
            bVar.th(advertAppInfo.alh);
            bVar.setPageNumber(i2);
        } else {
            bVar.th(com.baidu.adp.lib.g.b.l(advertAppInfo.adPosition, 0));
            bVar.setPageNumber(i2);
        }
        bVar.ul(advertAppInfo.alq);
        bVar.um(advertAppInfo.alr);
        bVar.un(advertAppInfo.als);
        bVar.uo(advertAppInfo.page);
        return bVar;
    }

    public static b a(AdvertAppInfo advertAppInfo, String str, int i, int i2) {
        if (advertAppInfo == null) {
            return null;
        }
        b bVar = new b();
        bVar.tg(i);
        bVar.uh(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            bVar.th(-1);
            bVar.setPageNumber(-1);
        } else if ("NEWINDEX".equals(advertAppInfo.page)) {
            bVar.th(advertAppInfo.alh);
            bVar.setPageNumber(i2);
        } else {
            bVar.th(com.baidu.adp.lib.g.b.l(advertAppInfo.adPosition, 0));
            bVar.setPageNumber(i2);
        }
        bVar.up(str);
        bVar.uo(advertAppInfo.page);
        return bVar;
    }

    public static b a(com.baidu.afd.d dVar, int i, int i2) {
        if (dVar == null) {
            return null;
        }
        return c(dVar.px(), i, i2);
    }

    public static b d(AdvertAppInfo advertAppInfo, int i, int i2) {
        if (advertAppInfo == null) {
            return null;
        }
        b bVar = new b();
        bVar.tg(i);
        bVar.uj(advertAppInfo.price);
        bVar.uh(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            bVar.th(-1);
            bVar.setPageNumber(-1);
        } else {
            bVar.th(advertAppInfo.alh);
            bVar.setPageNumber(i2);
        }
        bVar.ul(advertAppInfo.alq);
        bVar.um(advertAppInfo.alr);
        bVar.un(advertAppInfo.als);
        bVar.uo(advertAppInfo.page);
        return bVar;
    }

    public static b a(DownloadStaticsData downloadStaticsData, int i, int i2) {
        if (downloadStaticsData == null) {
            return null;
        }
        b bVar = new b();
        bVar.setDownloadStaticsData(downloadStaticsData);
        bVar.tg(i);
        bVar.setPageNumber(i2);
        return bVar;
    }

    public static b aa(int i, int i2, int i3) {
        b bVar = new b();
        bVar.tg(i);
        bVar.th(i2);
        bVar.setPageNumber(i3);
        return bVar;
    }

    public static b c(l lVar, int i) {
        if (lVar == null || lVar.bBP() == null) {
            return null;
        }
        AppData bBP = lVar.bBP();
        b bVar = new b();
        bVar.uh(bBP.ext_info);
        if (lVar.hcS) {
            bVar.th(-1);
            bVar.setPageNumber(-1);
        } else {
            bVar.th(com.baidu.adp.lib.g.b.l(bBP.pos_name, 0));
            bVar.setPageNumber(lVar.pageNumber);
        }
        bVar.tg(i);
        bVar.uj(bBP.price);
        bVar.ul(lVar.alq);
        bVar.um(lVar.alr);
        bVar.un(lVar.forumId);
        bVar.uo(lVar.bBS());
        return bVar;
    }

    public static b a(AdvertAppInfo advertAppInfo, int i, int i2, int i3, int i4, int i5, int i6) {
        b c = c(advertAppInfo, i, i2);
        c.ti(i3);
        c.tj(i5);
        c.tk(i4);
        if (i6 != -1 && i == 32) {
            c.tl(i6);
        }
        c.uo(advertAppInfo.page);
        if (i == 2) {
            c.uk("video");
        }
        return c;
    }

    public static b a(com.baidu.afd.d dVar, int i, int i2, int i3, int i4, int i5, int i6) {
        b a = a(dVar, i, i2);
        a.ti(i3);
        a.tj(i5);
        a.tk(i4);
        if (i6 != -1 && i == 32) {
            a.tl(i6);
        }
        if (dVar != null) {
            a.uo(dVar.px().page);
        }
        if (i == 2) {
            a.uk("video");
        }
        return a;
    }

    public static b l(String str, int i, String str2) {
        return b(str, i, str2, "");
    }

    public static b b(String str, int i, String str2, String str3) {
        b bVar = new b();
        bVar.tg(i);
        bVar.ui(str2);
        bVar.uo("HOMEPAGE");
        bVar.uh(str);
        bVar.up(str3);
        return bVar;
    }

    public static b a(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        b c = c(advertAppInfo, i, i2);
        c.ti(i3);
        return c;
    }

    public static b b(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        b d = d(advertAppInfo, i, i2);
        d.ti(i3);
        return d;
    }

    public static b a(com.baidu.afd.d dVar, ParseError parseError) {
        if (dVar == null || parseError == null) {
            return null;
        }
        b a = a(dVar, 5, dVar.getPageNum());
        a.ti(parseError.errorCode);
        return a;
    }
}
