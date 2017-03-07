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
        aVar.qR(com.baidu.adp.lib.g.b.g(advertAppInfo.adPosition, 0));
        aVar.qQ(i);
        aVar.pf(advertAppInfo.price);
        aVar.pe(advertAppInfo.extensionInfo);
        aVar.setPageNumber(i2);
        aVar.ph(advertAppInfo.TL);
        aVar.pi(advertAppInfo.TM);
        aVar.pj(advertAppInfo.TO);
        aVar.pk(advertAppInfo.Te);
        return aVar;
    }

    public static a a(DownloadStaticsData downloadStaticsData, int i, int i2) {
        if (downloadStaticsData == null) {
            return null;
        }
        a aVar = new a();
        aVar.setDownloadStaticsData(downloadStaticsData);
        aVar.qQ(i);
        aVar.setPageNumber(i2);
        return aVar;
    }

    public static a O(int i, int i2, int i3) {
        a aVar = new a();
        aVar.qQ(i);
        aVar.qR(i2);
        aVar.setPageNumber(i3);
        return aVar;
    }

    public static a b(o oVar, int i) {
        if (oVar == null || oVar.bhr() == null) {
            return null;
        }
        AppData bhr = oVar.bhr();
        a aVar = new a();
        aVar.qR(com.baidu.adp.lib.g.b.g(bhr.pos_name, 0));
        aVar.pe(bhr.ext_info);
        aVar.setPageNumber(oVar.pageNumber);
        aVar.qQ(i);
        aVar.pf(bhr.price);
        aVar.ph(oVar.TL);
        aVar.pi(oVar.TM);
        aVar.pj(oVar.forumId);
        aVar.pk("PB");
        return aVar;
    }

    public static a a(AdvertAppInfo advertAppInfo, int i, int i2, int i3, int i4, int i5) {
        a b = b(advertAppInfo, i, i2);
        b.qS(i3);
        b.qU(i4);
        b.qT(i5);
        b.pk(advertAppInfo.Te);
        if (i == 2) {
            b.pg("video");
        }
        return b;
    }

    public static a a(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        a b = b(advertAppInfo, i, i2);
        b.qS(i3);
        return b;
    }
}
