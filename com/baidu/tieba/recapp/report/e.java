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
        aVar.us(com.baidu.adp.lib.g.b.h(advertAppInfo.adPosition, 0));
        aVar.ur(i);
        aVar.rY(advertAppInfo.price);
        aVar.rW(advertAppInfo.extensionInfo);
        aVar.setPageNumber(i2);
        aVar.sa(advertAppInfo.aKT);
        aVar.sb(advertAppInfo.aKU);
        aVar.sc(advertAppInfo.aKV);
        aVar.sd(advertAppInfo.aKi);
        return aVar;
    }

    public static a d(AdvertAppInfo advertAppInfo, int i, int i2) {
        if (advertAppInfo == null) {
            return null;
        }
        a aVar = new a();
        aVar.us(advertAppInfo.aKL);
        aVar.ur(i);
        aVar.rY(advertAppInfo.price);
        aVar.rW(advertAppInfo.extensionInfo);
        aVar.setPageNumber(i2);
        aVar.sa(advertAppInfo.aKT);
        aVar.sb(advertAppInfo.aKU);
        aVar.sc(advertAppInfo.aKV);
        aVar.sd(advertAppInfo.aKi);
        return aVar;
    }

    public static a a(DownloadStaticsData downloadStaticsData, int i, int i2) {
        if (downloadStaticsData == null) {
            return null;
        }
        a aVar = new a();
        aVar.setDownloadStaticsData(downloadStaticsData);
        aVar.ur(i);
        aVar.setPageNumber(i2);
        return aVar;
    }

    public static a ai(int i, int i2, int i3) {
        a aVar = new a();
        aVar.ur(i);
        aVar.us(i2);
        aVar.setPageNumber(i3);
        return aVar;
    }

    public static a c(l lVar, int i) {
        if (lVar == null || lVar.bwJ() == null) {
            return null;
        }
        AppData bwJ = lVar.bwJ();
        a aVar = new a();
        aVar.us(com.baidu.adp.lib.g.b.h(bwJ.pos_name, 0));
        aVar.rW(bwJ.ext_info);
        aVar.setPageNumber(lVar.pageNumber);
        aVar.ur(i);
        aVar.rY(bwJ.price);
        aVar.sa(lVar.aKT);
        aVar.sb(lVar.aKU);
        aVar.sc(lVar.forumId);
        aVar.sd("PB");
        return aVar;
    }

    public static a a(AdvertAppInfo advertAppInfo, int i, int i2, int i3, int i4, int i5, int i6) {
        a c = c(advertAppInfo, i, i2);
        c.ut(i3);
        c.uu(i5);
        c.uv(i4);
        if (i6 != -1 && i == 32) {
            c.uw(i6);
        }
        c.sd(advertAppInfo.aKi);
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
        aVar.ur(i);
        aVar.rX(str2);
        aVar.sd("HOMEPAGE");
        aVar.rW(str);
        aVar.se(str3);
        return aVar;
    }

    public static a a(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        a c = c(advertAppInfo, i, i2);
        c.ut(i3);
        return c;
    }

    public static a b(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        a d = d(advertAppInfo, i, i2);
        d.ut(i3);
        return d;
    }
}
