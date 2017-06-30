package com.baidu.tieba.recapp.report;

import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.tbadkCore.data.AppData;
import com.baidu.tieba.tbadkCore.data.o;
/* loaded from: classes.dex */
public class e {
    public static a c(AdvertAppInfo advertAppInfo, int i, int i2) {
        if (advertAppInfo == null) {
            return null;
        }
        a aVar = new a();
        aVar.rD(com.baidu.adp.lib.g.b.g(advertAppInfo.adPosition, 0));
        aVar.rC(i);
        aVar.qG(advertAppInfo.price);
        aVar.qE(advertAppInfo.extensionInfo);
        aVar.setPageNumber(i2);
        aVar.qI(advertAppInfo.Tg);
        aVar.qJ(advertAppInfo.Th);
        aVar.qK(advertAppInfo.Ti);
        aVar.qL(advertAppInfo.Sz);
        return aVar;
    }

    public static a a(DownloadStaticsData downloadStaticsData, int i, int i2) {
        if (downloadStaticsData == null) {
            return null;
        }
        a aVar = new a();
        aVar.setDownloadStaticsData(downloadStaticsData);
        aVar.rC(i);
        aVar.setPageNumber(i2);
        return aVar;
    }

    public static a P(int i, int i2, int i3) {
        a aVar = new a();
        aVar.rC(i);
        aVar.rD(i2);
        aVar.setPageNumber(i3);
        return aVar;
    }

    public static a c(o oVar, int i) {
        if (oVar == null || oVar.bmj() == null) {
            return null;
        }
        AppData bmj = oVar.bmj();
        a aVar = new a();
        aVar.rD(com.baidu.adp.lib.g.b.g(bmj.pos_name, 0));
        aVar.qE(bmj.ext_info);
        aVar.setPageNumber(oVar.pageNumber);
        aVar.rC(i);
        aVar.qG(bmj.price);
        aVar.qI(oVar.Tg);
        aVar.qJ(oVar.Th);
        aVar.qK(oVar.forumId);
        aVar.qL("PB");
        return aVar;
    }

    public static a a(AdvertAppInfo advertAppInfo, int i, int i2, int i3, int i4, int i5) {
        a c = c(advertAppInfo, i, i2);
        c.rE(i3);
        c.rG(i4);
        c.rF(i5);
        c.qL(advertAppInfo.Sz);
        if (i == 2) {
            c.qH("video");
        }
        return c;
    }

    public static a h(String str, int i, String str2) {
        return a(str, i, str2, "");
    }

    public static a a(String str, int i, String str2, String str3) {
        a aVar = new a();
        aVar.rC(i);
        aVar.qF(str2);
        aVar.qL("HOMEPAGE");
        aVar.qE(str);
        aVar.qM(str3);
        return aVar;
    }

    public static a a(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        a c = c(advertAppInfo, i, i2);
        c.rE(i3);
        return c;
    }
}
