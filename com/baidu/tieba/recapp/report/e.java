package com.baidu.tieba.recapp.report;

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
        aVar.qQ(advertAppInfo.price);
        aVar.qO(advertAppInfo.extensionInfo);
        aVar.setPageNumber(i2);
        aVar.qS(advertAppInfo.Uc);
        aVar.qT(advertAppInfo.Ud);
        aVar.qU(advertAppInfo.Ue);
        aVar.qV(advertAppInfo.Tt);
        return aVar;
    }

    public static a d(AdvertAppInfo advertAppInfo, int i, int i2) {
        if (advertAppInfo == null) {
            return null;
        }
        a aVar = new a();
        aVar.se(advertAppInfo.TU);
        aVar.sd(i);
        aVar.qQ(advertAppInfo.price);
        aVar.qO(advertAppInfo.extensionInfo);
        aVar.setPageNumber(i2);
        aVar.qS(advertAppInfo.Uc);
        aVar.qT(advertAppInfo.Ud);
        aVar.qU(advertAppInfo.Ue);
        aVar.qV(advertAppInfo.Tt);
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

    public static a X(int i, int i2, int i3) {
        a aVar = new a();
        aVar.sd(i);
        aVar.se(i2);
        aVar.setPageNumber(i3);
        return aVar;
    }

    public static a c(l lVar, int i) {
        if (lVar == null || lVar.bre() == null) {
            return null;
        }
        AppData bre = lVar.bre();
        a aVar = new a();
        aVar.se(com.baidu.adp.lib.g.b.g(bre.pos_name, 0));
        aVar.qO(bre.ext_info);
        aVar.setPageNumber(lVar.pageNumber);
        aVar.sd(i);
        aVar.qQ(bre.price);
        aVar.qS(lVar.Uc);
        aVar.qT(lVar.Ud);
        aVar.qU(lVar.forumId);
        aVar.qV("PB");
        return aVar;
    }

    public static a a(AdvertAppInfo advertAppInfo, int i, int i2, int i3, int i4, int i5) {
        a c = c(advertAppInfo, i, i2);
        c.sf(i3);
        c.sh(i4);
        c.sg(i5);
        c.qV(advertAppInfo.Tt);
        if (i == 2) {
            c.qR("video");
        }
        return c;
    }

    public static a h(String str, int i, String str2) {
        return c(str, i, str2, "");
    }

    public static a c(String str, int i, String str2, String str3) {
        a aVar = new a();
        aVar.sd(i);
        aVar.qP(str2);
        aVar.qV("HOMEPAGE");
        aVar.qO(str);
        aVar.qW(str3);
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
}
