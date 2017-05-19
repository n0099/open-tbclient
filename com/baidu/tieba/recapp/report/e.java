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
        aVar.qN(com.baidu.adp.lib.g.b.g(advertAppInfo.adPosition, 0));
        aVar.qM(i);
        aVar.pu(advertAppInfo.price);
        aVar.ps(advertAppInfo.extensionInfo);
        aVar.setPageNumber(i2);
        aVar.pw(advertAppInfo.Ty);
        aVar.px(advertAppInfo.Tz);
        aVar.py(advertAppInfo.TA);
        aVar.pz(advertAppInfo.SR);
        return aVar;
    }

    public static a a(DownloadStaticsData downloadStaticsData, int i, int i2) {
        if (downloadStaticsData == null) {
            return null;
        }
        a aVar = new a();
        aVar.setDownloadStaticsData(downloadStaticsData);
        aVar.qM(i);
        aVar.setPageNumber(i2);
        return aVar;
    }

    public static a O(int i, int i2, int i3) {
        a aVar = new a();
        aVar.qM(i);
        aVar.qN(i2);
        aVar.setPageNumber(i3);
        return aVar;
    }

    public static a b(o oVar, int i) {
        if (oVar == null || oVar.bgA() == null) {
            return null;
        }
        AppData bgA = oVar.bgA();
        a aVar = new a();
        aVar.qN(com.baidu.adp.lib.g.b.g(bgA.pos_name, 0));
        aVar.ps(bgA.ext_info);
        aVar.setPageNumber(oVar.pageNumber);
        aVar.qM(i);
        aVar.pu(bgA.price);
        aVar.pw(oVar.Ty);
        aVar.px(oVar.Tz);
        aVar.py(oVar.forumId);
        aVar.pz("PB");
        return aVar;
    }

    public static a a(AdvertAppInfo advertAppInfo, int i, int i2, int i3, int i4, int i5) {
        a b = b(advertAppInfo, i, i2);
        b.qO(i3);
        b.qQ(i4);
        b.qP(i5);
        b.pz(advertAppInfo.SR);
        if (i == 2) {
            b.pv("video");
        }
        return b;
    }

    public static a h(String str, int i, String str2) {
        a aVar = new a();
        aVar.qM(i);
        aVar.pt(str2);
        aVar.pz("HOMEPAGE");
        aVar.ps(str);
        return aVar;
    }

    public static a a(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        a b = b(advertAppInfo, i, i2);
        b.qO(i3);
        return b;
    }
}
