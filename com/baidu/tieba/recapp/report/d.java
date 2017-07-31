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
        aVar.rU(com.baidu.adp.lib.g.b.g(advertAppInfo.adPosition, 0));
        aVar.rT(i);
        aVar.rk(advertAppInfo.price);
        aVar.ri(advertAppInfo.extensionInfo);
        aVar.setPageNumber(i2);
        aVar.rm(advertAppInfo.UV);
        aVar.rn(advertAppInfo.UW);
        aVar.ro(advertAppInfo.UX);
        aVar.rp(advertAppInfo.Um);
        return aVar;
    }

    public static a a(DownloadStaticsData downloadStaticsData, int i, int i2) {
        if (downloadStaticsData == null) {
            return null;
        }
        a aVar = new a();
        aVar.setDownloadStaticsData(downloadStaticsData);
        aVar.rT(i);
        aVar.setPageNumber(i2);
        return aVar;
    }

    public static a Q(int i, int i2, int i3) {
        a aVar = new a();
        aVar.rT(i);
        aVar.rU(i2);
        aVar.setPageNumber(i3);
        return aVar;
    }

    public static a c(l lVar, int i) {
        if (lVar == null || lVar.bsn() == null) {
            return null;
        }
        AppData bsn = lVar.bsn();
        a aVar = new a();
        aVar.rU(com.baidu.adp.lib.g.b.g(bsn.pos_name, 0));
        aVar.ri(bsn.ext_info);
        aVar.setPageNumber(lVar.pageNumber);
        aVar.rT(i);
        aVar.rk(bsn.price);
        aVar.rm(lVar.UV);
        aVar.rn(lVar.UW);
        aVar.ro(lVar.forumId);
        aVar.rp("PB");
        return aVar;
    }

    public static a a(AdvertAppInfo advertAppInfo, int i, int i2, int i3, int i4, int i5) {
        a c = c(advertAppInfo, i, i2);
        c.rV(i3);
        c.rX(i4);
        c.rW(i5);
        c.rp(advertAppInfo.Um);
        if (i == 2) {
            c.rl("video");
        }
        return c;
    }

    public static a i(String str, int i, String str2) {
        return b(str, i, str2, "");
    }

    public static a b(String str, int i, String str2, String str3) {
        a aVar = new a();
        aVar.rT(i);
        aVar.rj(str2);
        aVar.rp("HOMEPAGE");
        aVar.ri(str);
        aVar.rq(str3);
        return aVar;
    }

    public static a a(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        a c = c(advertAppInfo, i, i2);
        c.rV(i3);
        return c;
    }
}
