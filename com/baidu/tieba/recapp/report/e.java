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
        aVar.rY(advertAppInfo.price);
        aVar.rW(advertAppInfo.extensionInfo);
        aVar.setPageNumber(i2);
        aVar.sa(advertAppInfo.aKI);
        aVar.sb(advertAppInfo.aKJ);
        aVar.sc(advertAppInfo.aKK);
        aVar.sd(advertAppInfo.aJX);
        return aVar;
    }

    public static a d(AdvertAppInfo advertAppInfo, int i, int i2) {
        if (advertAppInfo == null) {
            return null;
        }
        a aVar = new a();
        aVar.ut(advertAppInfo.aKA);
        aVar.us(i);
        aVar.rY(advertAppInfo.price);
        aVar.rW(advertAppInfo.extensionInfo);
        aVar.setPageNumber(i2);
        aVar.sa(advertAppInfo.aKI);
        aVar.sb(advertAppInfo.aKJ);
        aVar.sc(advertAppInfo.aKK);
        aVar.sd(advertAppInfo.aJX);
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

    public static a ai(int i, int i2, int i3) {
        a aVar = new a();
        aVar.us(i);
        aVar.ut(i2);
        aVar.setPageNumber(i3);
        return aVar;
    }

    public static a c(l lVar, int i) {
        if (lVar == null || lVar.bwI() == null) {
            return null;
        }
        AppData bwI = lVar.bwI();
        a aVar = new a();
        aVar.ut(com.baidu.adp.lib.g.b.h(bwI.pos_name, 0));
        aVar.rW(bwI.ext_info);
        aVar.setPageNumber(lVar.pageNumber);
        aVar.us(i);
        aVar.rY(bwI.price);
        aVar.sa(lVar.aKI);
        aVar.sb(lVar.aKJ);
        aVar.sc(lVar.forumId);
        aVar.sd("PB");
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
        c.sd(advertAppInfo.aJX);
        if (i == 2) {
            c.rZ("video");
        }
        return c;
    }

    public static a m(String str, int i, String str2) {
        return b(str, i, str2, "");
    }

    public static a b(String str, int i, String str2, String str3) {
        a aVar = new a();
        aVar.us(i);
        aVar.rX(str2);
        aVar.sd("HOMEPAGE");
        aVar.rW(str);
        aVar.se(str3);
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
