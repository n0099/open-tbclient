package com.baidu.tieba.recapp.report;

import com.baidu.tieba.tbadkCore.data.p;
/* loaded from: classes.dex */
public class e {
    public static a a(com.baidu.tbadk.core.data.b bVar, String str, int i) {
        if (bVar == null) {
            return null;
        }
        a aVar = new a();
        aVar.qR(com.baidu.adp.lib.h.b.g(bVar.adPosition, 0));
        aVar.qH(str);
        aVar.qI(bVar.price);
        aVar.qG(bVar.extensionInfo);
        aVar.setPageNumber(i);
        return aVar;
    }

    public static a a(DownloadStaticsData downloadStaticsData, String str, int i) {
        if (downloadStaticsData == null) {
            return null;
        }
        a aVar = new a();
        aVar.setDownloadStaticsData(downloadStaticsData);
        aVar.qH(str);
        aVar.setPageNumber(i);
        return aVar;
    }

    public static a j(String str, int i, int i2) {
        a aVar = new a();
        aVar.qH(str);
        aVar.qR(i);
        aVar.setPageNumber(i2);
        return aVar;
    }

    public static a a(p pVar, String str) {
        if (pVar == null || pVar.bjD() == null) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.e bjD = pVar.bjD();
        a aVar = new a();
        aVar.qR(com.baidu.adp.lib.h.b.g(bjD.pos_name, 0));
        aVar.qG(bjD.ext_info);
        aVar.setPageNumber(pVar.pageNumber);
        aVar.qH(str);
        aVar.qI(bjD.price);
        return aVar;
    }

    public static a a(com.baidu.tbadk.core.data.b bVar, String str, int i, int i2, int i3, int i4) {
        a a = a(bVar, str, i);
        a.qS(i2);
        a.qT(i3);
        a.qU(i4);
        return a;
    }
}
