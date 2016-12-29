package com.baidu.tieba.recapp.report;

import com.baidu.tieba.tbadkCore.data.p;
/* loaded from: classes.dex */
public class e {
    public static a a(com.baidu.tbadk.core.data.c cVar, int i, int i2) {
        if (cVar == null) {
            return null;
        }
        a aVar = new a();
        aVar.qk(com.baidu.adp.lib.h.b.g(cVar.adPosition, 0));
        aVar.qj(i);
        aVar.pC(cVar.price);
        aVar.pB(cVar.extensionInfo);
        aVar.setPageNumber(i2);
        aVar.pE(cVar.PA);
        aVar.pF(cVar.PC);
        aVar.pG(cVar.PD);
        aVar.pH(cVar.OO);
        return aVar;
    }

    public static a a(DownloadStaticsData downloadStaticsData, int i, int i2) {
        if (downloadStaticsData == null) {
            return null;
        }
        a aVar = new a();
        aVar.setDownloadStaticsData(downloadStaticsData);
        aVar.qj(i);
        aVar.setPageNumber(i2);
        return aVar;
    }

    public static a O(int i, int i2, int i3) {
        a aVar = new a();
        aVar.qj(i);
        aVar.qk(i2);
        aVar.setPageNumber(i3);
        return aVar;
    }

    public static a a(p pVar, int i) {
        if (pVar == null || pVar.bfO() == null) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.e bfO = pVar.bfO();
        a aVar = new a();
        aVar.qk(com.baidu.adp.lib.h.b.g(bfO.pos_name, 0));
        aVar.pB(bfO.ext_info);
        aVar.setPageNumber(pVar.pageNumber);
        aVar.qj(i);
        aVar.pC(bfO.price);
        aVar.pE(pVar.PA);
        aVar.pF(pVar.PC);
        aVar.pG(pVar.forumId);
        aVar.pH("PB");
        return aVar;
    }

    public static a a(com.baidu.tbadk.core.data.c cVar, int i, int i2, int i3, int i4, int i5) {
        a a = a(cVar, i, i2);
        a.ql(i3);
        a.qm(i4);
        a.qn(i5);
        a.pH(cVar.OO);
        return a;
    }
}
