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
        aVar.ut(com.baidu.adp.lib.g.b.h(advertAppInfo.adPosition, 0));
        aVar.us(i);
        aVar.rR(advertAppInfo.price);
        aVar.rP(advertAppInfo.extensionInfo);
        aVar.setPageNumber(i2);
        aVar.rT(advertAppInfo.aJA);
        aVar.rU(advertAppInfo.aJB);
        aVar.rV(advertAppInfo.aJC);
        aVar.rW(advertAppInfo.aIP);
        return aVar;
    }

    public static a d(AdvertAppInfo advertAppInfo, int i, int i2) {
        if (advertAppInfo == null) {
            return null;
        }
        a aVar = new a();
        aVar.ut(advertAppInfo.aJs);
        aVar.us(i);
        aVar.rR(advertAppInfo.price);
        aVar.rP(advertAppInfo.extensionInfo);
        aVar.setPageNumber(i2);
        aVar.rT(advertAppInfo.aJA);
        aVar.rU(advertAppInfo.aJB);
        aVar.rV(advertAppInfo.aJC);
        aVar.rW(advertAppInfo.aIP);
        return aVar;
    }

    public static a a(DownloadStaticsData downloadStaticsData, int i, int i2) {
        if (downloadStaticsData == null) {
            return null;
        }
        a aVar = new a();
        aVar.setDownloadStaticsData(downloadStaticsData);
        aVar.us(i);
        aVar.setPageNumber(i2);
        return aVar;
    }

    public static a ah(int i, int i2, int i3) {
        a aVar = new a();
        aVar.us(i);
        aVar.ut(i2);
        aVar.setPageNumber(i3);
        return aVar;
    }

    public static a c(l lVar, int i) {
        if (lVar == null || lVar.bvx() == null) {
            return null;
        }
        AppData bvx = lVar.bvx();
        a aVar = new a();
        aVar.ut(com.baidu.adp.lib.g.b.h(bvx.pos_name, 0));
        aVar.rP(bvx.ext_info);
        aVar.setPageNumber(lVar.pageNumber);
        aVar.us(i);
        aVar.rR(bvx.price);
        aVar.rT(lVar.aJA);
        aVar.rU(lVar.aJB);
        aVar.rV(lVar.forumId);
        aVar.rW("PB");
        return aVar;
    }

    public static a a(AdvertAppInfo advertAppInfo, int i, int i2, int i3, int i4, int i5, int i6) {
        a c = c(advertAppInfo, i, i2);
        c.uu(i3);
        c.uv(i5);
        c.uw(i4);
        if (i6 != -1 && i == 32) {
            c.ux(i6);
        }
        c.rW(advertAppInfo.aIP);
        if (i == 2) {
            c.rS("video");
        }
        return c;
    }

    public static a m(String str, int i, String str2) {
        return b(str, i, str2, "");
    }

    public static a b(String str, int i, String str2, String str3) {
        a aVar = new a();
        aVar.us(i);
        aVar.rQ(str2);
        aVar.rW("HOMEPAGE");
        aVar.rP(str);
        aVar.rX(str3);
        return aVar;
    }

    public static a a(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        a c = c(advertAppInfo, i, i2);
        c.uu(i3);
        return c;
    }

    public static a b(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        a d = d(advertAppInfo, i, i2);
        d.uu(i3);
        return d;
    }
}
