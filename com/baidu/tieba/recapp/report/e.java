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
        aVar.se(com.baidu.adp.lib.g.b.g(advertAppInfo.adPosition, 0));
        aVar.sd(i);
        aVar.ta(advertAppInfo.price);
        aVar.sY(advertAppInfo.extensionInfo);
        aVar.setPageNumber(i2);
        aVar.tc(advertAppInfo.aea);
        aVar.td(advertAppInfo.aeb);
        aVar.te(advertAppInfo.aec);
        aVar.tf(advertAppInfo.adp);
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
        aVar.se(advertAppInfo.adR);
        aVar.sd(i);
        aVar.ta(advertAppInfo.price);
        aVar.sY(advertAppInfo.extensionInfo);
        aVar.setPageNumber(i2);
        aVar.tc(advertAppInfo.aea);
        aVar.td(advertAppInfo.aeb);
        aVar.te(advertAppInfo.aec);
        aVar.tf(advertAppInfo.adp);
        return aVar;
    }

    public static a a(DownloadStaticsData downloadStaticsData, int i, int i2) {
        if (downloadStaticsData == null) {
            return null;
        }
        a aVar = new a();
        aVar.setDownloadStaticsData(downloadStaticsData);
        aVar.sd(i);
        aVar.setPageNumber(i2);
        return aVar;
    }

    public static a W(int i, int i2, int i3) {
        a aVar = new a();
        aVar.sd(i);
        aVar.se(i2);
        aVar.setPageNumber(i3);
        return aVar;
    }

    public static a c(l lVar, int i) {
        if (lVar == null || lVar.bwP() == null) {
            return null;
        }
        AppData bwP = lVar.bwP();
        a aVar = new a();
        aVar.se(com.baidu.adp.lib.g.b.g(bwP.pos_name, 0));
        aVar.sY(bwP.ext_info);
        aVar.setPageNumber(lVar.pageNumber);
        aVar.sd(i);
        aVar.ta(bwP.price);
        aVar.tc(lVar.aea);
        aVar.td(lVar.aeb);
        aVar.te(lVar.forumId);
        aVar.tf("PB");
        return aVar;
    }

    public static a a(AdvertAppInfo advertAppInfo, int i, int i2, int i3, int i4, int i5, int i6) {
        a c = c(advertAppInfo, i, i2);
        c.sf(i3);
        c.sg(i5);
        c.sh(i4);
        if (i6 != -1 && i == 32) {
            c.si(i6);
        }
        c.tf(advertAppInfo.adp);
        if (i == 2) {
            c.tb("video");
        }
        return c;
    }

    public static a a(com.baidu.afd.d dVar, int i, int i2, int i3, int i4, int i5, int i6) {
        a a = a(dVar, i, i2);
        a.sf(i3);
        a.sg(i5);
        a.sh(i4);
        if (i6 != -1 && i == 32) {
            a.si(i6);
        }
        if (dVar != null) {
            a.tf(dVar.ok().adp);
        }
        if (i == 2) {
            a.tb("video");
        }
        return a;
    }

    public static a m(String str, int i, String str2) {
        return b(str, i, str2, "");
    }

    public static a b(String str, int i, String str2, String str3) {
        a aVar = new a();
        aVar.sd(i);
        aVar.sZ(str2);
        aVar.tf("HOMEPAGE");
        aVar.sY(str);
        aVar.tg(str3);
        return aVar;
    }

    public static a a(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        a c = c(advertAppInfo, i, i2);
        c.sf(i3);
        return c;
    }

    public static a b(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        a d = d(advertAppInfo, i, i2);
        d.sf(i3);
        return d;
    }

    public static a a(com.baidu.afd.d dVar, ParseError parseError) {
        if (dVar == null || parseError == null) {
            return null;
        }
        a a = a(dVar, 5, dVar.getPageNum());
        a.sf(parseError.errorCode);
        return a;
    }
}
