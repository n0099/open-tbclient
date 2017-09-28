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
        aVar.sf(com.baidu.adp.lib.g.b.g(advertAppInfo.adPosition, 0));
        aVar.se(i);
        aVar.qR(advertAppInfo.price);
        aVar.qP(advertAppInfo.extensionInfo);
        aVar.setPageNumber(i2);
        aVar.qT(advertAppInfo.Uo);
        aVar.qU(advertAppInfo.Up);
        aVar.qV(advertAppInfo.Uq);
        aVar.qW(advertAppInfo.TF);
        return aVar;
    }

    public static a d(AdvertAppInfo advertAppInfo, int i, int i2) {
        if (advertAppInfo == null) {
            return null;
        }
        a aVar = new a();
        aVar.sf(advertAppInfo.Ug);
        aVar.se(i);
        aVar.qR(advertAppInfo.price);
        aVar.qP(advertAppInfo.extensionInfo);
        aVar.setPageNumber(i2);
        aVar.qT(advertAppInfo.Uo);
        aVar.qU(advertAppInfo.Up);
        aVar.qV(advertAppInfo.Uq);
        aVar.qW(advertAppInfo.TF);
        return aVar;
    }

    public static a a(DownloadStaticsData downloadStaticsData, int i, int i2) {
        if (downloadStaticsData == null) {
            return null;
        }
        a aVar = new a();
        aVar.setDownloadStaticsData(downloadStaticsData);
        aVar.se(i);
        aVar.setPageNumber(i2);
        return aVar;
    }

    public static a X(int i, int i2, int i3) {
        a aVar = new a();
        aVar.se(i);
        aVar.sf(i2);
        aVar.setPageNumber(i3);
        return aVar;
    }

    public static a c(l lVar, int i) {
        if (lVar == null || lVar.brm() == null) {
            return null;
        }
        AppData brm = lVar.brm();
        a aVar = new a();
        aVar.sf(com.baidu.adp.lib.g.b.g(brm.pos_name, 0));
        aVar.qP(brm.ext_info);
        aVar.setPageNumber(lVar.pageNumber);
        aVar.se(i);
        aVar.qR(brm.price);
        aVar.qT(lVar.Uo);
        aVar.qU(lVar.Up);
        aVar.qV(lVar.forumId);
        aVar.qW("PB");
        return aVar;
    }

    public static a a(AdvertAppInfo advertAppInfo, int i, int i2, int i3, int i4, int i5) {
        a c = c(advertAppInfo, i, i2);
        c.sg(i3);
        c.si(i4);
        c.sh(i5);
        c.qW(advertAppInfo.TF);
        if (i == 2) {
            c.qS("video");
        }
        return c;
    }

    public static a h(String str, int i, String str2) {
        return c(str, i, str2, "");
    }

    public static a c(String str, int i, String str2, String str3) {
        a aVar = new a();
        aVar.se(i);
        aVar.qQ(str2);
        aVar.qW("HOMEPAGE");
        aVar.qP(str);
        aVar.qX(str3);
        return aVar;
    }

    public static a a(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        a c = c(advertAppInfo, i, i2);
        c.sg(i3);
        return c;
    }

    public static a b(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        a d = d(advertAppInfo, i, i2);
        d.sg(i3);
        return d;
    }
}
