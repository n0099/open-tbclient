package com.baidu.tieba.recapp.report;

import com.baidu.tieba.tbadkCore.data.AppData;
import com.baidu.tieba.tbadkCore.data.o;
/* loaded from: classes.dex */
public class e {
    public static a a(com.baidu.tbadk.core.data.c cVar, int i, int i2) {
        if (cVar == null) {
            return null;
        }
        a aVar = new a();
        aVar.qU(com.baidu.adp.lib.g.b.g(cVar.adPosition, 0));
        aVar.qT(i);
        aVar.pW(cVar.price);
        aVar.pV(cVar.extensionInfo);
        aVar.setPageNumber(i2);
        aVar.pY(cVar.OH);
        aVar.pZ(cVar.OI);
        aVar.qa(cVar.OJ);
        aVar.qb(cVar.Oa);
        return aVar;
    }

    public static a a(DownloadStaticsData downloadStaticsData, int i, int i2) {
        if (downloadStaticsData == null) {
            return null;
        }
        a aVar = new a();
        aVar.setDownloadStaticsData(downloadStaticsData);
        aVar.qT(i);
        aVar.setPageNumber(i2);
        return aVar;
    }

    public static a P(int i, int i2, int i3) {
        a aVar = new a();
        aVar.qT(i);
        aVar.qU(i2);
        aVar.setPageNumber(i3);
        return aVar;
    }

    public static a a(o oVar, int i) {
        if (oVar == null || oVar.bhE() == null) {
            return null;
        }
        AppData bhE = oVar.bhE();
        a aVar = new a();
        aVar.qU(com.baidu.adp.lib.g.b.g(bhE.pos_name, 0));
        aVar.pV(bhE.ext_info);
        aVar.setPageNumber(oVar.pageNumber);
        aVar.qT(i);
        aVar.pW(bhE.price);
        aVar.pY(oVar.OH);
        aVar.pZ(oVar.OI);
        aVar.qa(oVar.forumId);
        aVar.qb("PB");
        return aVar;
    }

    public static a a(com.baidu.tbadk.core.data.c cVar, int i, int i2, int i3, int i4, int i5) {
        a a = a(cVar, i, i2);
        a.qV(i3);
        a.qW(i4);
        a.qX(i5);
        a.qb(cVar.Oa);
        return a;
    }
}
