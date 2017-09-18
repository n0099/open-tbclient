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
        aVar.sd(com.baidu.adp.lib.g.b.g(advertAppInfo.adPosition, 0));
        aVar.sc(i);
        aVar.rh(advertAppInfo.price);
        aVar.rf(advertAppInfo.extensionInfo);
        aVar.setPageNumber(i2);
        aVar.rj(advertAppInfo.Ua);
        aVar.rk(advertAppInfo.Ub);
        aVar.rl(advertAppInfo.Uc);
        aVar.rm(advertAppInfo.Tr);
        return aVar;
    }

    public static a d(AdvertAppInfo advertAppInfo, int i, int i2) {
        if (advertAppInfo == null) {
            return null;
        }
        a aVar = new a();
        aVar.sd(advertAppInfo.TS);
        aVar.sc(i);
        aVar.rh(advertAppInfo.price);
        aVar.rf(advertAppInfo.extensionInfo);
        aVar.setPageNumber(i2);
        aVar.rj(advertAppInfo.Ua);
        aVar.rk(advertAppInfo.Ub);
        aVar.rl(advertAppInfo.Uc);
        aVar.rm(advertAppInfo.Tr);
        return aVar;
    }

    public static a a(DownloadStaticsData downloadStaticsData, int i, int i2) {
        if (downloadStaticsData == null) {
            return null;
        }
        a aVar = new a();
        aVar.setDownloadStaticsData(downloadStaticsData);
        aVar.sc(i);
        aVar.setPageNumber(i2);
        return aVar;
    }

    public static a Q(int i, int i2, int i3) {
        a aVar = new a();
        aVar.sc(i);
        aVar.sd(i2);
        aVar.setPageNumber(i3);
        return aVar;
    }

    public static a c(l lVar, int i) {
        if (lVar == null || lVar.bso() == null) {
            return null;
        }
        AppData bso = lVar.bso();
        a aVar = new a();
        aVar.sd(com.baidu.adp.lib.g.b.g(bso.pos_name, 0));
        aVar.rf(bso.ext_info);
        aVar.setPageNumber(lVar.pageNumber);
        aVar.sc(i);
        aVar.rh(bso.price);
        aVar.rj(lVar.Ua);
        aVar.rk(lVar.Ub);
        aVar.rl(lVar.forumId);
        aVar.rm("PB");
        return aVar;
    }

    public static a a(AdvertAppInfo advertAppInfo, int i, int i2, int i3, int i4, int i5) {
        a c = c(advertAppInfo, i, i2);
        c.se(i3);
        c.sg(i4);
        c.sf(i5);
        c.rm(advertAppInfo.Tr);
        if (i == 2) {
            c.ri("video");
        }
        return c;
    }

    public static a h(String str, int i, String str2) {
        return c(str, i, str2, "");
    }

    public static a c(String str, int i, String str2, String str3) {
        a aVar = new a();
        aVar.sc(i);
        aVar.rg(str2);
        aVar.rm("HOMEPAGE");
        aVar.rf(str);
        aVar.rn(str3);
        return aVar;
    }

    public static a a(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        a c = c(advertAppInfo, i, i2);
        c.se(i3);
        return c;
    }

    public static a b(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        a d = d(advertAppInfo, i, i2);
        d.se(i3);
        return d;
    }
}
