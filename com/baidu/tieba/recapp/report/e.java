package com.baidu.tieba.recapp.report;

import com.baidu.afd.ParseError;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.tbadkCore.data.AppData;
import com.baidu.tieba.tbadkCore.data.l;
/* loaded from: classes.dex */
public class e {
    public static a c(AdvertAppInfo advertAppInfo, int i, int i2) {
        if (advertAppInfo == null) {
            return null;
        }
        a aVar = new a();
        aVar.sn(i);
        aVar.sZ(advertAppInfo.price);
        aVar.sX(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.adE)) {
            aVar.so(-1);
            aVar.setPageNumber(-1);
        } else {
            aVar.so(com.baidu.adp.lib.g.b.g(advertAppInfo.adPosition, 0));
            aVar.setPageNumber(i2);
        }
        aVar.tb(advertAppInfo.aep);
        aVar.tc(advertAppInfo.aeq);
        aVar.td(advertAppInfo.aer);
        aVar.te(advertAppInfo.adE);
        return aVar;
    }

    public static a a(AdvertAppInfo advertAppInfo, String str, int i, int i2) {
        if (advertAppInfo == null) {
            return null;
        }
        a aVar = new a();
        aVar.sn(i);
        aVar.sX(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.adE)) {
            aVar.so(-1);
            aVar.setPageNumber(-1);
        } else {
            aVar.so(com.baidu.adp.lib.g.b.g(advertAppInfo.adPosition, 0));
            aVar.setPageNumber(i2);
        }
        aVar.tf(str);
        aVar.te(advertAppInfo.adE);
        return aVar;
    }

    public static a a(com.baidu.afd.d dVar, int i, int i2) {
        if (dVar == null) {
            return null;
        }
        return c(dVar.ok(), i, i2);
    }

    public static a d(AdvertAppInfo advertAppInfo, int i, int i2) {
        if (advertAppInfo == null) {
            return null;
        }
        a aVar = new a();
        aVar.sn(i);
        aVar.sZ(advertAppInfo.price);
        aVar.sX(advertAppInfo.extensionInfo);
        if ("PB_BANNER".equals(advertAppInfo.adE)) {
            aVar.so(-1);
            aVar.setPageNumber(-1);
        } else {
            aVar.so(advertAppInfo.aeg);
            aVar.setPageNumber(i2);
        }
        aVar.tb(advertAppInfo.aep);
        aVar.tc(advertAppInfo.aeq);
        aVar.td(advertAppInfo.aer);
        aVar.te(advertAppInfo.adE);
        return aVar;
    }

    public static a a(DownloadStaticsData downloadStaticsData, int i, int i2) {
        if (downloadStaticsData == null) {
            return null;
        }
        a aVar = new a();
        aVar.setDownloadStaticsData(downloadStaticsData);
        aVar.sn(i);
        aVar.setPageNumber(i2);
        return aVar;
    }

    public static a W(int i, int i2, int i3) {
        a aVar = new a();
        aVar.sn(i);
        aVar.so(i2);
        aVar.setPageNumber(i3);
        return aVar;
    }

    public static a c(l lVar, int i) {
        if (lVar == null || lVar.bxq() == null) {
            return null;
        }
        AppData bxq = lVar.bxq();
        a aVar = new a();
        aVar.sX(bxq.ext_info);
        if (lVar.gMT) {
            aVar.so(-1);
            aVar.setPageNumber(-1);
        } else {
            aVar.so(com.baidu.adp.lib.g.b.g(bxq.pos_name, 0));
            aVar.setPageNumber(lVar.pageNumber);
        }
        aVar.sn(i);
        aVar.sZ(bxq.price);
        aVar.tb(lVar.aep);
        aVar.tc(lVar.aeq);
        aVar.td(lVar.forumId);
        aVar.te(lVar.bxt());
        return aVar;
    }

    public static a a(AdvertAppInfo advertAppInfo, int i, int i2, int i3, int i4, int i5, int i6) {
        a c = c(advertAppInfo, i, i2);
        c.sp(i3);
        c.sq(i5);
        c.sr(i4);
        if (i6 != -1 && i == 32) {
            c.ss(i6);
        }
        c.te(advertAppInfo.adE);
        if (i == 2) {
            c.ta("video");
        }
        return c;
    }

    public static a a(com.baidu.afd.d dVar, int i, int i2, int i3, int i4, int i5, int i6) {
        a a = a(dVar, i, i2);
        a.sp(i3);
        a.sq(i5);
        a.sr(i4);
        if (i6 != -1 && i == 32) {
            a.ss(i6);
        }
        if (dVar != null) {
            a.te(dVar.ok().adE);
        }
        if (i == 2) {
            a.ta("video");
        }
        return a;
    }

    public static a m(String str, int i, String str2) {
        return b(str, i, str2, "");
    }

    public static a b(String str, int i, String str2, String str3) {
        a aVar = new a();
        aVar.sn(i);
        aVar.sY(str2);
        aVar.te("HOMEPAGE");
        aVar.sX(str);
        aVar.tf(str3);
        return aVar;
    }

    public static a a(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        a c = c(advertAppInfo, i, i2);
        c.sp(i3);
        return c;
    }

    public static a b(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        a d = d(advertAppInfo, i, i2);
        d.sp(i3);
        return d;
    }

    public static a a(com.baidu.afd.d dVar, ParseError parseError) {
        if (dVar == null || parseError == null) {
            return null;
        }
        a a = a(dVar, 5, dVar.getPageNum());
        a.sp(parseError.errorCode);
        return a;
    }
}
