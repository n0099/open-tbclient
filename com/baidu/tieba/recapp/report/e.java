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
        aVar.qP(com.baidu.adp.lib.g.b.g(advertAppInfo.adPosition, 0));
        aVar.qO(i);
        aVar.pv(advertAppInfo.price);
        aVar.pt(advertAppInfo.extensionInfo);
        aVar.setPageNumber(i2);
        aVar.px(advertAppInfo.Ue);
        aVar.py(advertAppInfo.Uf);
        aVar.pz(advertAppInfo.Ug);
        aVar.pA(advertAppInfo.Tw);
        return aVar;
    }

    public static a a(DownloadStaticsData downloadStaticsData, int i, int i2) {
        if (downloadStaticsData == null) {
            return null;
        }
        a aVar = new a();
        aVar.setDownloadStaticsData(downloadStaticsData);
        aVar.qO(i);
        aVar.setPageNumber(i2);
        return aVar;
    }

    public static a O(int i, int i2, int i3) {
        a aVar = new a();
        aVar.qO(i);
        aVar.qP(i2);
        aVar.setPageNumber(i3);
        return aVar;
    }

    public static a b(o oVar, int i) {
        if (oVar == null || oVar.bic() == null) {
            return null;
        }
        AppData bic = oVar.bic();
        a aVar = new a();
        aVar.qP(com.baidu.adp.lib.g.b.g(bic.pos_name, 0));
        aVar.pt(bic.ext_info);
        aVar.setPageNumber(oVar.pageNumber);
        aVar.qO(i);
        aVar.pv(bic.price);
        aVar.px(oVar.Ue);
        aVar.py(oVar.Uf);
        aVar.pz(oVar.forumId);
        aVar.pA("PB");
        return aVar;
    }

    public static a a(AdvertAppInfo advertAppInfo, int i, int i2, int i3, int i4, int i5) {
        a b = b(advertAppInfo, i, i2);
        b.qQ(i3);
        b.qS(i4);
        b.qR(i5);
        b.pA(advertAppInfo.Tw);
        if (i == 2) {
            b.pw("video");
        }
        return b;
    }

    public static a h(String str, int i, String str2) {
        a aVar = new a();
        aVar.qO(i);
        aVar.pu(str2);
        aVar.pA("HOMEPAGE");
        aVar.pt(str);
        return aVar;
    }

    public static a a(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        a b = b(advertAppInfo, i, i2);
        b.qQ(i3);
        return b;
    }
}
