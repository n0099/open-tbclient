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
        aVar.sV(com.baidu.adp.lib.g.b.g(advertAppInfo.adPosition, 0));
        aVar.sU(i);
        aVar.sd(advertAppInfo.price);
        aVar.sb(advertAppInfo.extensionInfo);
        aVar.setPageNumber(i2);
        aVar.sf(advertAppInfo.UZ);
        aVar.sg(advertAppInfo.Va);
        aVar.sh(advertAppInfo.Vb);
        aVar.si(advertAppInfo.Un);
        return aVar;
    }

    public static a d(AdvertAppInfo advertAppInfo, int i, int i2) {
        if (advertAppInfo == null) {
            return null;
        }
        a aVar = new a();
        aVar.sV(advertAppInfo.UR);
        aVar.sU(i);
        aVar.sd(advertAppInfo.price);
        aVar.sb(advertAppInfo.extensionInfo);
        aVar.setPageNumber(i2);
        aVar.sf(advertAppInfo.UZ);
        aVar.sg(advertAppInfo.Va);
        aVar.sh(advertAppInfo.Vb);
        aVar.si(advertAppInfo.Un);
        return aVar;
    }

    public static a a(DownloadStaticsData downloadStaticsData, int i, int i2) {
        if (downloadStaticsData == null) {
            return null;
        }
        a aVar = new a();
        aVar.setDownloadStaticsData(downloadStaticsData);
        aVar.sU(i);
        aVar.setPageNumber(i2);
        return aVar;
    }

    public static a Z(int i, int i2, int i3) {
        a aVar = new a();
        aVar.sU(i);
        aVar.sV(i2);
        aVar.setPageNumber(i3);
        return aVar;
    }

    public static a c(l lVar, int i) {
        if (lVar == null || lVar.bwJ() == null) {
            return null;
        }
        AppData bwJ = lVar.bwJ();
        a aVar = new a();
        aVar.sV(com.baidu.adp.lib.g.b.g(bwJ.pos_name, 0));
        aVar.sb(bwJ.ext_info);
        aVar.setPageNumber(lVar.pageNumber);
        aVar.sU(i);
        aVar.sd(bwJ.price);
        aVar.sf(lVar.UZ);
        aVar.sg(lVar.Va);
        aVar.sh(lVar.forumId);
        aVar.si("PB");
        return aVar;
    }

    public static a a(AdvertAppInfo advertAppInfo, int i, int i2, int i3, int i4, int i5, int i6) {
        a c = c(advertAppInfo, i, i2);
        c.sW(i3);
        c.sX(i5);
        c.sY(i4);
        if (i6 != -1 && i == 32) {
            c.sZ(i6);
        }
        c.si(advertAppInfo.Un);
        if (i == 2) {
            c.se("video");
        }
        return c;
    }

    public static a m(String str, int i, String str2) {
        return b(str, i, str2, "");
    }

    public static a b(String str, int i, String str2, String str3) {
        a aVar = new a();
        aVar.sU(i);
        aVar.sc(str2);
        aVar.si("HOMEPAGE");
        aVar.sb(str);
        aVar.sj(str3);
        return aVar;
    }

    public static a a(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        a c = c(advertAppInfo, i, i2);
        c.sW(i3);
        return c;
    }

    public static a b(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        a d = d(advertAppInfo, i, i2);
        d.sW(i3);
        return d;
    }
}
