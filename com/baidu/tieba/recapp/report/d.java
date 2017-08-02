package com.baidu.tieba.recapp.report;

import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.tbadkCore.data.AppData;
import com.baidu.tieba.tbadkCore.data.l;
/* loaded from: classes.dex */
public class d {
    public static a c(AdvertAppInfo advertAppInfo, int i, int i2) {
        if (advertAppInfo == null) {
            return null;
        }
        a aVar = new a();
        aVar.rV(com.baidu.adp.lib.g.b.g(advertAppInfo.adPosition, 0));
        aVar.rU(i);
        aVar.rf(advertAppInfo.price);
        aVar.rd(advertAppInfo.extensionInfo);
        aVar.setPageNumber(i2);
        aVar.rh(advertAppInfo.Tv);
        aVar.ri(advertAppInfo.Tw);
        aVar.rj(advertAppInfo.Tx);
        aVar.rk(advertAppInfo.SO);
        return aVar;
    }

    public static a a(DownloadStaticsData downloadStaticsData, int i, int i2) {
        if (downloadStaticsData == null) {
            return null;
        }
        a aVar = new a();
        aVar.setDownloadStaticsData(downloadStaticsData);
        aVar.rU(i);
        aVar.setPageNumber(i2);
        return aVar;
    }

    public static a Q(int i, int i2, int i3) {
        a aVar = new a();
        aVar.rU(i);
        aVar.rV(i2);
        aVar.setPageNumber(i3);
        return aVar;
    }

    public static a c(l lVar, int i) {
        if (lVar == null || lVar.bsg() == null) {
            return null;
        }
        AppData bsg = lVar.bsg();
        a aVar = new a();
        aVar.rV(com.baidu.adp.lib.g.b.g(bsg.pos_name, 0));
        aVar.rd(bsg.ext_info);
        aVar.setPageNumber(lVar.pageNumber);
        aVar.rU(i);
        aVar.rf(bsg.price);
        aVar.rh(lVar.Tv);
        aVar.ri(lVar.Tw);
        aVar.rj(lVar.forumId);
        aVar.rk("PB");
        return aVar;
    }

    public static a a(AdvertAppInfo advertAppInfo, int i, int i2, int i3, int i4, int i5) {
        a c = c(advertAppInfo, i, i2);
        c.rW(i3);
        c.rY(i4);
        c.rX(i5);
        c.rk(advertAppInfo.SO);
        if (i == 2) {
            c.rg("video");
        }
        return c;
    }

    public static a i(String str, int i, String str2) {
        return b(str, i, str2, "");
    }

    public static a b(String str, int i, String str2, String str3) {
        a aVar = new a();
        aVar.rU(i);
        aVar.re(str2);
        aVar.rk("HOMEPAGE");
        aVar.rd(str);
        aVar.rl(str3);
        return aVar;
    }

    public static a a(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        a c = c(advertAppInfo, i, i2);
        c.rW(i3);
        return c;
    }
}
