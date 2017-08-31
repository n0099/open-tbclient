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
        aVar.sb(com.baidu.adp.lib.g.b.g(advertAppInfo.adPosition, 0));
        aVar.sa(i);
        aVar.rf(advertAppInfo.price);
        aVar.rd(advertAppInfo.extensionInfo);
        aVar.setPageNumber(i2);
        aVar.rh(advertAppInfo.Ua);
        aVar.ri(advertAppInfo.Ub);
        aVar.rj(advertAppInfo.Uc);
        aVar.rk(advertAppInfo.Tr);
        return aVar;
    }

    public static a d(AdvertAppInfo advertAppInfo, int i, int i2) {
        if (advertAppInfo == null) {
            return null;
        }
        a aVar = new a();
        aVar.sb(advertAppInfo.TS);
        aVar.sa(i);
        aVar.rf(advertAppInfo.price);
        aVar.rd(advertAppInfo.extensionInfo);
        aVar.setPageNumber(i2);
        aVar.rh(advertAppInfo.Ua);
        aVar.ri(advertAppInfo.Ub);
        aVar.rj(advertAppInfo.Uc);
        aVar.rk(advertAppInfo.Tr);
        return aVar;
    }

    public static a a(DownloadStaticsData downloadStaticsData, int i, int i2) {
        if (downloadStaticsData == null) {
            return null;
        }
        a aVar = new a();
        aVar.setDownloadStaticsData(downloadStaticsData);
        aVar.sa(i);
        aVar.setPageNumber(i2);
        return aVar;
    }

    public static a Q(int i, int i2, int i3) {
        a aVar = new a();
        aVar.sa(i);
        aVar.sb(i2);
        aVar.setPageNumber(i3);
        return aVar;
    }

    public static a c(l lVar, int i) {
        if (lVar == null || lVar.bsd() == null) {
            return null;
        }
        AppData bsd = lVar.bsd();
        a aVar = new a();
        aVar.sb(com.baidu.adp.lib.g.b.g(bsd.pos_name, 0));
        aVar.rd(bsd.ext_info);
        aVar.setPageNumber(lVar.pageNumber);
        aVar.sa(i);
        aVar.rf(bsd.price);
        aVar.rh(lVar.Ua);
        aVar.ri(lVar.Ub);
        aVar.rj(lVar.forumId);
        aVar.rk("PB");
        return aVar;
    }

    public static a a(AdvertAppInfo advertAppInfo, int i, int i2, int i3, int i4, int i5) {
        a c = c(advertAppInfo, i, i2);
        c.sc(i3);
        c.se(i4);
        c.sd(i5);
        c.rk(advertAppInfo.Tr);
        if (i == 2) {
            c.rg("video");
        }
        return c;
    }

    public static a h(String str, int i, String str2) {
        return c(str, i, str2, "");
    }

    public static a c(String str, int i, String str2, String str3) {
        a aVar = new a();
        aVar.sa(i);
        aVar.re(str2);
        aVar.rk("HOMEPAGE");
        aVar.rd(str);
        aVar.rl(str3);
        return aVar;
    }

    public static a a(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        a c = c(advertAppInfo, i, i2);
        c.sc(i3);
        return c;
    }

    public static a b(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        a d = d(advertAppInfo, i, i2);
        d.sc(i3);
        return d;
    }
}
