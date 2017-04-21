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
        aVar.qV(com.baidu.adp.lib.g.b.g(advertAppInfo.adPosition, 0));
        aVar.qU(i);
        aVar.pw(advertAppInfo.price);
        aVar.pu(advertAppInfo.extensionInfo);
        aVar.setPageNumber(i2);
        aVar.py(advertAppInfo.Ug);
        aVar.pz(advertAppInfo.Uh);
        aVar.pA(advertAppInfo.Ui);
        aVar.pB(advertAppInfo.Ty);
        return aVar;
    }

    public static a a(DownloadStaticsData downloadStaticsData, int i, int i2) {
        if (downloadStaticsData == null) {
            return null;
        }
        a aVar = new a();
        aVar.setDownloadStaticsData(downloadStaticsData);
        aVar.qU(i);
        aVar.setPageNumber(i2);
        return aVar;
    }

    public static a O(int i, int i2, int i3) {
        a aVar = new a();
        aVar.qU(i);
        aVar.qV(i2);
        aVar.setPageNumber(i3);
        return aVar;
    }

    public static a b(o oVar, int i) {
        if (oVar == null || oVar.bjd() == null) {
            return null;
        }
        AppData bjd = oVar.bjd();
        a aVar = new a();
        aVar.qV(com.baidu.adp.lib.g.b.g(bjd.pos_name, 0));
        aVar.pu(bjd.ext_info);
        aVar.setPageNumber(oVar.pageNumber);
        aVar.qU(i);
        aVar.pw(bjd.price);
        aVar.py(oVar.Ug);
        aVar.pz(oVar.Uh);
        aVar.pA(oVar.forumId);
        aVar.pB("PB");
        return aVar;
    }

    public static a a(AdvertAppInfo advertAppInfo, int i, int i2, int i3, int i4, int i5) {
        a b = b(advertAppInfo, i, i2);
        b.qW(i3);
        b.qY(i4);
        b.qX(i5);
        b.pB(advertAppInfo.Ty);
        if (i == 2) {
            b.px("video");
        }
        return b;
    }

    public static a h(String str, int i, String str2) {
        a aVar = new a();
        aVar.qU(i);
        aVar.pv(str2);
        aVar.pB("HOMEPAGE");
        aVar.pu(str);
        return aVar;
    }

    public static a a(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        a b = b(advertAppInfo, i, i2);
        b.qW(i3);
        return b;
    }
}
