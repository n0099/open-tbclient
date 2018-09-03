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
        bVar.sl(i);
        bVar.ta(advertAppInfo.price);
        bVar.sY(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            bVar.sm(-1);
            bVar.setPageNumber(-1);
        } else if ("NEWINDEX".equals(advertAppInfo.page)) {
            bVar.sm(advertAppInfo.adK);
            bVar.setPageNumber(i2);
        } else {
            bVar.sm(com.baidu.adp.lib.g.b.g(advertAppInfo.adPosition, 0));
            bVar.setPageNumber(i2);
        }
        bVar.tc(advertAppInfo.adT);
        bVar.td(advertAppInfo.adU);
        bVar.te(advertAppInfo.adV);
        bVar.tf(advertAppInfo.page);
        return bVar;
    }

    public static b a(AdvertAppInfo advertAppInfo, String str, int i, int i2) {
        if (advertAppInfo == null) {
            return null;
        }
        b bVar = new b();
        bVar.sl(i);
        bVar.sY(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            bVar.sm(-1);
            bVar.setPageNumber(-1);
        } else if ("NEWINDEX".equals(advertAppInfo.page)) {
            bVar.sm(advertAppInfo.adK);
            bVar.setPageNumber(i2);
        } else {
            bVar.sm(com.baidu.adp.lib.g.b.g(advertAppInfo.adPosition, 0));
            bVar.setPageNumber(i2);
        }
        bVar.tg(str);
        bVar.tf(advertAppInfo.page);
        return bVar;
    }

    public static b a(com.baidu.afd.d dVar, int i, int i2) {
        if (dVar == null) {
            return null;
        }
        return c(dVar.oj(), i, i2);
    }

    public static b d(AdvertAppInfo advertAppInfo, int i, int i2) {
        if (advertAppInfo == null) {
            return null;
        }
        b bVar = new b();
        bVar.sl(i);
        bVar.ta(advertAppInfo.price);
        bVar.sY(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.page)) {
            bVar.sm(-1);
            bVar.setPageNumber(-1);
        } else {
            bVar.sm(advertAppInfo.adK);
            bVar.setPageNumber(i2);
        }
        bVar.tc(advertAppInfo.adT);
        bVar.td(advertAppInfo.adU);
        bVar.te(advertAppInfo.adV);
        bVar.tf(advertAppInfo.page);
        return bVar;
    }

    public static b a(DownloadStaticsData downloadStaticsData, int i, int i2) {
        if (downloadStaticsData == null) {
            return null;
        }
        b bVar = new b();
        bVar.setDownloadStaticsData(downloadStaticsData);
        bVar.sl(i);
        bVar.setPageNumber(i2);
        return bVar;
    }

    public static b V(int i, int i2, int i3) {
        b bVar = new b();
        bVar.sl(i);
        bVar.sm(i2);
        bVar.setPageNumber(i3);
        return bVar;
    }

    public static b c(l lVar, int i) {
        if (lVar == null || lVar.bvU() == null) {
            return null;
        }
        AppData bvU = lVar.bvU();
        b bVar = new b();
        bVar.sY(bvU.ext_info);
        if (lVar.gNT) {
            bVar.sm(-1);
            bVar.setPageNumber(-1);
        } else {
            bVar.sm(com.baidu.adp.lib.g.b.g(bvU.pos_name, 0));
            bVar.setPageNumber(lVar.pageNumber);
        }
        bVar.sl(i);
        bVar.ta(bvU.price);
        bVar.tc(lVar.adT);
        bVar.td(lVar.adU);
        bVar.te(lVar.forumId);
        bVar.tf(lVar.bvX());
        return bVar;
    }

    public static b a(AdvertAppInfo advertAppInfo, int i, int i2, int i3, int i4, int i5, int i6) {
        b c = c(advertAppInfo, i, i2);
        c.sn(i3);
        c.so(i5);
        c.sp(i4);
        if (i6 != -1 && i == 32) {
            c.sq(i6);
        }
        c.tf(advertAppInfo.page);
        if (i == 2) {
            c.tb("video");
        }
        return c;
    }

    public static b a(com.baidu.afd.d dVar, int i, int i2, int i3, int i4, int i5, int i6) {
        b a = a(dVar, i, i2);
        a.sn(i3);
        a.so(i5);
        a.sp(i4);
        if (i6 != -1 && i == 32) {
            a.sq(i6);
        }
        if (dVar != null) {
            a.tf(dVar.oj().page);
        }
        if (i == 2) {
            a.tb("video");
        }
        return a;
    }

    public static b l(String str, int i, String str2) {
        return b(str, i, str2, "");
    }

    public static b b(String str, int i, String str2, String str3) {
        b bVar = new b();
        bVar.sl(i);
        bVar.sZ(str2);
        bVar.tf("HOMEPAGE");
        bVar.sY(str);
        bVar.tg(str3);
        return bVar;
    }

    public static b a(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        b c = c(advertAppInfo, i, i2);
        c.sn(i3);
        return c;
    }

    public static b b(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        b d = d(advertAppInfo, i, i2);
        d.sn(i3);
        return d;
    }

    public static b a(com.baidu.afd.d dVar, ParseError parseError) {
        if (dVar == null || parseError == null) {
            return null;
        }
        b a = a(dVar, 5, dVar.getPageNum());
        a.sn(parseError.errorCode);
        return a;
    }
}
