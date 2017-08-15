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
        aVar.se(com.baidu.adp.lib.g.b.g(advertAppInfo.adPosition, 0));
        aVar.sd(i);
        aVar.rm(advertAppInfo.price);
        aVar.rk(advertAppInfo.extensionInfo);
        aVar.setPageNumber(i2);
        aVar.ro(advertAppInfo.UX);
        aVar.rp(advertAppInfo.UY);
        aVar.rq(advertAppInfo.UZ);
        aVar.rr(advertAppInfo.Uo);
        return aVar;
    }

    public static a a(DownloadStaticsData downloadStaticsData, int i, int i2) {
        if (downloadStaticsData == null) {
            return null;
        }
        a aVar = new a();
        aVar.setDownloadStaticsData(downloadStaticsData);
        aVar.sd(i);
        aVar.setPageNumber(i2);
        return aVar;
    }

    public static a Q(int i, int i2, int i3) {
        a aVar = new a();
        aVar.sd(i);
        aVar.se(i2);
        aVar.setPageNumber(i3);
        return aVar;
    }

    public static a c(l lVar, int i) {
        if (lVar == null || lVar.bsV() == null) {
            return null;
        }
        AppData bsV = lVar.bsV();
        a aVar = new a();
        aVar.se(com.baidu.adp.lib.g.b.g(bsV.pos_name, 0));
        aVar.rk(bsV.ext_info);
        aVar.setPageNumber(lVar.pageNumber);
        aVar.sd(i);
        aVar.rm(bsV.price);
        aVar.ro(lVar.UX);
        aVar.rp(lVar.UY);
        aVar.rq(lVar.forumId);
        aVar.rr("PB");
        return aVar;
    }

    public static a a(AdvertAppInfo advertAppInfo, int i, int i2, int i3, int i4, int i5) {
        a c = c(advertAppInfo, i, i2);
        c.sf(i3);
        c.sh(i4);
        c.sg(i5);
        c.rr(advertAppInfo.Uo);
        if (i == 2) {
            c.rn("video");
        }
        return c;
    }

    public static a i(String str, int i, String str2) {
        return b(str, i, str2, "");
    }

    public static a b(String str, int i, String str2, String str3) {
        a aVar = new a();
        aVar.sd(i);
        aVar.rl(str2);
        aVar.rr("HOMEPAGE");
        aVar.rk(str);
        aVar.rs(str3);
        return aVar;
    }

    public static a a(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        a c = c(advertAppInfo, i, i2);
        c.sf(i3);
        return c;
    }
}
