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
        aVar.vS(com.baidu.adp.lib.g.b.h(advertAppInfo.adPosition, 0));
        aVar.vR(i);
        aVar.sp(advertAppInfo.price);
        aVar.sn(advertAppInfo.extensionInfo);
        aVar.setPageNumber(i2);
        aVar.ss(advertAppInfo.aJz);
        aVar.st(advertAppInfo.aJA);
        aVar.su(advertAppInfo.aJB);
        aVar.sv(advertAppInfo.aIO);
        return aVar;
    }

    public static a d(AdvertAppInfo advertAppInfo, int i, int i2) {
        if (advertAppInfo == null) {
            return null;
        }
        a aVar = new a();
        aVar.vS(advertAppInfo.aJr);
        aVar.vR(i);
        aVar.sp(advertAppInfo.price);
        aVar.sn(advertAppInfo.extensionInfo);
        aVar.setPageNumber(i2);
        aVar.ss(advertAppInfo.aJz);
        aVar.st(advertAppInfo.aJA);
        aVar.su(advertAppInfo.aJB);
        aVar.sv(advertAppInfo.aIO);
        return aVar;
    }

    public static a a(DownloadStaticsData downloadStaticsData, int i, int i2) {
        if (downloadStaticsData == null) {
            return null;
        }
        a aVar = new a();
        aVar.setDownloadStaticsData(downloadStaticsData);
        aVar.vR(i);
        aVar.setPageNumber(i2);
        return aVar;
    }

    public static a ai(int i, int i2, int i3) {
        a aVar = new a();
        aVar.vR(i);
        aVar.vS(i2);
        aVar.setPageNumber(i3);
        return aVar;
    }

    public static a c(l lVar, int i) {
        if (lVar == null || lVar.bBZ() == null) {
            return null;
        }
        AppData bBZ = lVar.bBZ();
        a aVar = new a();
        aVar.vS(com.baidu.adp.lib.g.b.h(bBZ.pos_name, 0));
        aVar.sn(bBZ.ext_info);
        aVar.setPageNumber(lVar.pageNumber);
        aVar.vR(i);
        aVar.sp(bBZ.price);
        aVar.ss(lVar.aJz);
        aVar.st(lVar.aJA);
        aVar.su(lVar.forumId);
        aVar.sv("PB");
        return aVar;
    }

    public static a a(AdvertAppInfo advertAppInfo, int i, int i2, int i3, int i4, int i5, int i6) {
        a c = c(advertAppInfo, i, i2);
        c.vT(i3);
        c.vU(i5);
        c.vV(i4);
        if (i6 != -1 && i == 32) {
            c.vW(i6);
        }
        c.sv(advertAppInfo.aIO);
        if (i == 2) {
            c.sq("video");
        }
        return c;
    }

    public static a m(String str, int i, String str2) {
        return b(str, i, str2, "");
    }

    public static a b(String str, int i, String str2, String str3) {
        a aVar = new a();
        aVar.vR(i);
        aVar.so(str2);
        aVar.sv("HOMEPAGE");
        aVar.sn(str);
        aVar.sw(str3);
        return aVar;
    }

    public static a a(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        a c = c(advertAppInfo, i, i2);
        c.vT(i3);
        return c;
    }

    public static a b(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        a d = d(advertAppInfo, i, i2);
        d.vT(i3);
        return d;
    }
}
