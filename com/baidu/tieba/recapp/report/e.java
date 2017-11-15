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
        aVar.sx(com.baidu.adp.lib.g.b.g(advertAppInfo.adPosition, 0));
        aVar.sw(i);
        aVar.rE(advertAppInfo.price);
        aVar.rC(advertAppInfo.extensionInfo);
        aVar.setPageNumber(i2);
        aVar.rG(advertAppInfo.Uu);
        aVar.rH(advertAppInfo.Uv);
        aVar.rI(advertAppInfo.Uw);
        aVar.rJ(advertAppInfo.TL);
        return aVar;
    }

    public static a d(AdvertAppInfo advertAppInfo, int i, int i2) {
        if (advertAppInfo == null) {
            return null;
        }
        a aVar = new a();
        aVar.sx(advertAppInfo.Um);
        aVar.sw(i);
        aVar.rE(advertAppInfo.price);
        aVar.rC(advertAppInfo.extensionInfo);
        aVar.setPageNumber(i2);
        aVar.rG(advertAppInfo.Uu);
        aVar.rH(advertAppInfo.Uv);
        aVar.rI(advertAppInfo.Uw);
        aVar.rJ(advertAppInfo.TL);
        return aVar;
    }

    public static a a(DownloadStaticsData downloadStaticsData, int i, int i2) {
        if (downloadStaticsData == null) {
            return null;
        }
        a aVar = new a();
        aVar.setDownloadStaticsData(downloadStaticsData);
        aVar.sw(i);
        aVar.setPageNumber(i2);
        return aVar;
    }

    public static a aa(int i, int i2, int i3) {
        a aVar = new a();
        aVar.sw(i);
        aVar.sx(i2);
        aVar.setPageNumber(i3);
        return aVar;
    }

    public static a c(l lVar, int i) {
        if (lVar == null || lVar.buv() == null) {
            return null;
        }
        AppData buv = lVar.buv();
        a aVar = new a();
        aVar.sx(com.baidu.adp.lib.g.b.g(buv.pos_name, 0));
        aVar.rC(buv.ext_info);
        aVar.setPageNumber(lVar.pageNumber);
        aVar.sw(i);
        aVar.rE(buv.price);
        aVar.rG(lVar.Uu);
        aVar.rH(lVar.Uv);
        aVar.rI(lVar.forumId);
        aVar.rJ("PB");
        return aVar;
    }

    public static a a(AdvertAppInfo advertAppInfo, int i, int i2, int i3, int i4, int i5, int i6) {
        a c = c(advertAppInfo, i, i2);
        c.sy(i3);
        c.sz(i5);
        c.sA(i4);
        if (i6 != -1 && i == 32) {
            c.sB(i6);
        }
        c.rJ(advertAppInfo.TL);
        if (i == 2) {
            c.rF("video");
        }
        return c;
    }

    public static a i(String str, int i, String str2) {
        return c(str, i, str2, "");
    }

    public static a c(String str, int i, String str2, String str3) {
        a aVar = new a();
        aVar.sw(i);
        aVar.rD(str2);
        aVar.rJ("HOMEPAGE");
        aVar.rC(str);
        aVar.rK(str3);
        return aVar;
    }

    public static a a(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        a c = c(advertAppInfo, i, i2);
        c.sy(i3);
        return c;
    }

    public static a b(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        a d = d(advertAppInfo, i, i2);
        d.sy(i3);
        return d;
    }
}
