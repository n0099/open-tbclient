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
        bVar.sW(advertAppInfo.price);
        bVar.sU(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.adi)) {
            bVar.sm(-1);
            bVar.setPageNumber(-1);
        } else if ("NEWINDEX".equals(advertAppInfo.adi)) {
            bVar.sm(advertAppInfo.adK);
            bVar.setPageNumber(i2);
        } else {
            bVar.sm(com.baidu.adp.lib.g.b.g(advertAppInfo.adPosition, 0));
            bVar.setPageNumber(i2);
        }
        bVar.sY(advertAppInfo.adT);
        bVar.sZ(advertAppInfo.adU);
        bVar.ta(advertAppInfo.adV);
        bVar.tb(advertAppInfo.adi);
        return bVar;
    }

    public static b a(AdvertAppInfo advertAppInfo, String str, int i, int i2) {
        if (advertAppInfo == null) {
            return null;
        }
        b bVar = new b();
        bVar.sl(i);
        bVar.sU(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.adi)) {
            bVar.sm(-1);
            bVar.setPageNumber(-1);
        } else if ("NEWINDEX".equals(advertAppInfo.adi)) {
            bVar.sm(advertAppInfo.adK);
            bVar.setPageNumber(i2);
        } else {
            bVar.sm(com.baidu.adp.lib.g.b.g(advertAppInfo.adPosition, 0));
            bVar.setPageNumber(i2);
        }
        bVar.tc(str);
        bVar.tb(advertAppInfo.adi);
        return bVar;
    }

    public static b a(com.baidu.afd.d dVar, int i, int i2) {
        if (dVar == null) {
            return null;
        }
        return c(dVar.om(), i, i2);
    }

    public static b d(AdvertAppInfo advertAppInfo, int i, int i2) {
        if (advertAppInfo == null) {
            return null;
        }
        b bVar = new b();
        bVar.sl(i);
        bVar.sW(advertAppInfo.price);
        bVar.sU(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.adi)) {
            bVar.sm(-1);
            bVar.setPageNumber(-1);
        } else {
            bVar.sm(advertAppInfo.adK);
            bVar.setPageNumber(i2);
        }
        bVar.sY(advertAppInfo.adT);
        bVar.sZ(advertAppInfo.adU);
        bVar.ta(advertAppInfo.adV);
        bVar.tb(advertAppInfo.adi);
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
        if (lVar == null || lVar.bvT() == null) {
            return null;
        }
        AppData bvT = lVar.bvT();
        b bVar = new b();
        bVar.sU(bvT.ext_info);
        if (lVar.gNR) {
            bVar.sm(-1);
            bVar.setPageNumber(-1);
        } else {
            bVar.sm(com.baidu.adp.lib.g.b.g(bvT.pos_name, 0));
            bVar.setPageNumber(lVar.pageNumber);
        }
        bVar.sl(i);
        bVar.sW(bvT.price);
        bVar.sY(lVar.adT);
        bVar.sZ(lVar.adU);
        bVar.ta(lVar.forumId);
        bVar.tb(lVar.bvW());
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
        c.tb(advertAppInfo.adi);
        if (i == 2) {
            c.sX("video");
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
            a.tb(dVar.om().adi);
        }
        if (i == 2) {
            a.sX("video");
        }
        return a;
    }

    public static b m(String str, int i, String str2) {
        return b(str, i, str2, "");
    }

    public static b b(String str, int i, String str2, String str3) {
        b bVar = new b();
        bVar.sl(i);
        bVar.sV(str2);
        bVar.tb("HOMEPAGE");
        bVar.sU(str);
        bVar.tc(str3);
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
