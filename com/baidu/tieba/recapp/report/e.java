package com.baidu.tieba.recapp.report;

import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.tbadkCore.data.AppData;
import com.baidu.tieba.tbadkCore.data.o;
/* loaded from: classes.dex */
public class e {
    public static a b(AdvertAppInfo advertAppInfo, int i, int i2) {
        if (advertAppInfo == null) {
            return null;
        }
        a aVar = new a();
        aVar.rk(com.baidu.adp.lib.g.b.g(advertAppInfo.adPosition, 0));
        aVar.rj(i);
        aVar.pJ(advertAppInfo.price);
        aVar.pH(advertAppInfo.extensionInfo);
        aVar.setPageNumber(i2);
        aVar.pL(advertAppInfo.Tl);
        aVar.pM(advertAppInfo.Tm);
        aVar.pN(advertAppInfo.Tn);
        aVar.pO(advertAppInfo.SE);
        return aVar;
    }

    public static a a(DownloadStaticsData downloadStaticsData, int i, int i2) {
        if (downloadStaticsData == null) {
            return null;
        }
        a aVar = new a();
        aVar.setDownloadStaticsData(downloadStaticsData);
        aVar.rj(i);
        aVar.setPageNumber(i2);
        return aVar;
    }

    public static a O(int i, int i2, int i3) {
        a aVar = new a();
        aVar.rj(i);
        aVar.rk(i2);
        aVar.setPageNumber(i3);
        return aVar;
    }

    public static a b(o oVar, int i) {
        if (oVar == null || oVar.bhV() == null) {
            return null;
        }
        AppData bhV = oVar.bhV();
        a aVar = new a();
        aVar.rk(com.baidu.adp.lib.g.b.g(bhV.pos_name, 0));
        aVar.pH(bhV.ext_info);
        aVar.setPageNumber(oVar.pageNumber);
        aVar.rj(i);
        aVar.pJ(bhV.price);
        aVar.pL(oVar.Tl);
        aVar.pM(oVar.Tm);
        aVar.pN(oVar.forumId);
        aVar.pO("PB");
        return aVar;
    }

    public static a a(AdvertAppInfo advertAppInfo, int i, int i2, int i3, int i4, int i5) {
        a b = b(advertAppInfo, i, i2);
        b.rl(i3);
        b.rn(i4);
        b.rm(i5);
        b.pO(advertAppInfo.SE);
        if (i == 2) {
            b.pK("video");
        }
        return b;
    }

    public static a h(String str, int i, String str2) {
        a aVar = new a();
        aVar.rj(i);
        aVar.pI(str2);
        aVar.pO("HOMEPAGE");
        aVar.pH(str);
        return aVar;
    }

    public static a a(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        a b = b(advertAppInfo, i, i2);
        b.rl(i3);
        return b;
    }
}
