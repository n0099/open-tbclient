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
        aVar.rr(advertAppInfo.price);
        aVar.rp(advertAppInfo.extensionInfo);
        aVar.setPageNumber(i2);
        aVar.rt(advertAppInfo.UY);
        aVar.ru(advertAppInfo.UZ);
        aVar.rv(advertAppInfo.Va);
        aVar.rw(advertAppInfo.Up);
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
        if (lVar == null || lVar.bsO() == null) {
            return null;
        }
        AppData bsO = lVar.bsO();
        a aVar = new a();
        aVar.se(com.baidu.adp.lib.g.b.g(bsO.pos_name, 0));
        aVar.rp(bsO.ext_info);
        aVar.setPageNumber(lVar.pageNumber);
        aVar.sd(i);
        aVar.rr(bsO.price);
        aVar.rt(lVar.UY);
        aVar.ru(lVar.UZ);
        aVar.rv(lVar.forumId);
        aVar.rw("PB");
        return aVar;
    }

    public static a a(AdvertAppInfo advertAppInfo, int i, int i2, int i3, int i4, int i5) {
        a c = c(advertAppInfo, i, i2);
        c.sf(i3);
        c.sh(i4);
        c.sg(i5);
        c.rw(advertAppInfo.Up);
        if (i == 2) {
            c.rs("video");
        }
        return c;
    }

    public static a j(String str, int i, String str2) {
        return b(str, i, str2, "");
    }

    public static a b(String str, int i, String str2, String str3) {
        a aVar = new a();
        aVar.sd(i);
        aVar.rq(str2);
        aVar.rw("HOMEPAGE");
        aVar.rp(str);
        aVar.rx(str3);
        return aVar;
    }

    public static a a(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        a c = c(advertAppInfo, i, i2);
        c.sf(i3);
        return c;
    }
}
