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
        aVar.rJ(advertAppInfo.price);
        aVar.rH(advertAppInfo.extensionInfo);
        aVar.setPageNumber(i2);
        aVar.rL(advertAppInfo.aJx);
        aVar.rM(advertAppInfo.aJy);
        aVar.rN(advertAppInfo.aJz);
        aVar.rO(advertAppInfo.aIM);
        return aVar;
    }

    public static a d(AdvertAppInfo advertAppInfo, int i, int i2) {
        if (advertAppInfo == null) {
            return null;
        }
        a aVar = new a();
        aVar.ut(advertAppInfo.aJp);
        aVar.us(i);
        aVar.rJ(advertAppInfo.price);
        aVar.rH(advertAppInfo.extensionInfo);
        aVar.setPageNumber(i2);
        aVar.rL(advertAppInfo.aJx);
        aVar.rM(advertAppInfo.aJy);
        aVar.rN(advertAppInfo.aJz);
        aVar.rO(advertAppInfo.aIM);
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
        if (lVar == null || lVar.bvv() == null) {
            return null;
        }
        AppData bvv = lVar.bvv();
        a aVar = new a();
        aVar.ut(com.baidu.adp.lib.g.b.h(bvv.pos_name, 0));
        aVar.rH(bvv.ext_info);
        aVar.setPageNumber(lVar.pageNumber);
        aVar.us(i);
        aVar.rJ(bvv.price);
        aVar.rL(lVar.aJx);
        aVar.rM(lVar.aJy);
        aVar.rN(lVar.forumId);
        aVar.rO("PB");
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
        c.rO(advertAppInfo.aIM);
        if (i == 2) {
            c.rK("video");
        }
        return c;
    }

    public static a m(String str, int i, String str2) {
        return b(str, i, str2, "");
    }

    public static a b(String str, int i, String str2, String str3) {
        a aVar = new a();
        aVar.us(i);
        aVar.rI(str2);
        aVar.rO("HOMEPAGE");
        aVar.rH(str);
        aVar.rP(str3);
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
