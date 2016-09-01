package com.baidu.tieba.recapp.report;

import com.baidu.tieba.tbadkCore.data.p;
/* loaded from: classes.dex */
public class e {
    public static a a(com.baidu.tbadk.core.data.b bVar, String str, int i) {
        if (bVar == null) {
            return null;
        }
        a aVar = new a();
        aVar.qD(com.baidu.adp.lib.h.b.g(bVar.Pf, 0));
        aVar.qt(str);
        aVar.qu(bVar.price);
        aVar.qs(bVar.Pl);
        aVar.setPageNumber(i);
        return aVar;
    }

    public static a j(String str, int i, int i2) {
        a aVar = new a();
        aVar.qt(str);
        aVar.qD(i);
        aVar.setPageNumber(i2);
        return aVar;
    }

    public static a a(p pVar, String str) {
        if (pVar == null || pVar.biS() == null) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.e biS = pVar.biS();
        a aVar = new a();
        aVar.qD(com.baidu.adp.lib.h.b.g(biS.pos_name, 0));
        aVar.qs(biS.ext_info);
        aVar.setPageNumber(pVar.pageNumber);
        aVar.qt(str);
        aVar.qu(biS.price);
        return aVar;
    }

    public static a a(com.baidu.tbadk.core.data.b bVar, String str, int i, int i2, int i3, int i4) {
        a a = a(bVar, str, i);
        a.qE(i2);
        a.qF(i3);
        a.qG(i4);
        return a;
    }
}
