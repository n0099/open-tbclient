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
        aVar.sK(com.baidu.adp.lib.g.b.g(advertAppInfo.adPosition, 0));
        aVar.sJ(i);
        aVar.rZ(advertAppInfo.price);
        aVar.rX(advertAppInfo.extensionInfo);
        aVar.setPageNumber(i2);
        aVar.sb(advertAppInfo.Vf);
        aVar.sc(advertAppInfo.Vg);
        aVar.sd(advertAppInfo.Vh);
        aVar.se(advertAppInfo.Ut);
        return aVar;
    }

    public static a d(AdvertAppInfo advertAppInfo, int i, int i2) {
        if (advertAppInfo == null) {
            return null;
        }
        a aVar = new a();
        aVar.sK(advertAppInfo.UX);
        aVar.sJ(i);
        aVar.rZ(advertAppInfo.price);
        aVar.rX(advertAppInfo.extensionInfo);
        aVar.setPageNumber(i2);
        aVar.sb(advertAppInfo.Vf);
        aVar.sc(advertAppInfo.Vg);
        aVar.sd(advertAppInfo.Vh);
        aVar.se(advertAppInfo.Ut);
        return aVar;
    }

    public static a a(DownloadStaticsData downloadStaticsData, int i, int i2) {
        if (downloadStaticsData == null) {
            return null;
        }
        a aVar = new a();
        aVar.setDownloadStaticsData(downloadStaticsData);
        aVar.sJ(i);
        aVar.setPageNumber(i2);
        return aVar;
    }

    public static a Z(int i, int i2, int i3) {
        a aVar = new a();
        aVar.sJ(i);
        aVar.sK(i2);
        aVar.setPageNumber(i3);
        return aVar;
    }

    public static a c(l lVar, int i) {
        if (lVar == null || lVar.bwd() == null) {
            return null;
        }
        AppData bwd = lVar.bwd();
        a aVar = new a();
        aVar.sK(com.baidu.adp.lib.g.b.g(bwd.pos_name, 0));
        aVar.rX(bwd.ext_info);
        aVar.setPageNumber(lVar.pageNumber);
        aVar.sJ(i);
        aVar.rZ(bwd.price);
        aVar.sb(lVar.Vf);
        aVar.sc(lVar.Vg);
        aVar.sd(lVar.forumId);
        aVar.se("PB");
        return aVar;
    }

    public static a a(AdvertAppInfo advertAppInfo, int i, int i2, int i3, int i4, int i5, int i6) {
        a c = c(advertAppInfo, i, i2);
        c.sL(i3);
        c.sM(i5);
        c.sN(i4);
        if (i6 != -1 && i == 32) {
            c.sO(i6);
        }
        c.se(advertAppInfo.Ut);
        if (i == 2) {
            c.sa("video");
        }
        return c;
    }

    public static a m(String str, int i, String str2) {
        return b(str, i, str2, "");
    }

    public static a b(String str, int i, String str2, String str3) {
        a aVar = new a();
        aVar.sJ(i);
        aVar.rY(str2);
        aVar.se("HOMEPAGE");
        aVar.rX(str);
        aVar.sf(str3);
        return aVar;
    }

    public static a a(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        a c = c(advertAppInfo, i, i2);
        c.sL(i3);
        return c;
    }

    public static a b(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        a d = d(advertAppInfo, i, i2);
        d.sL(i3);
        return d;
    }
}
