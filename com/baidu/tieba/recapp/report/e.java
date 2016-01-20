package com.baidu.tieba.recapp.report;

import com.baidu.tieba.tbadkCore.data.q;
/* loaded from: classes.dex */
public class e {
    public static a a(com.baidu.tbadk.core.data.b bVar, String str, int i) {
        if (bVar == null) {
            return null;
        }
        a aVar = new a();
        aVar.mk(com.baidu.adp.lib.h.b.g(bVar.UT, 0));
        aVar.lS(str);
        aVar.lT(bVar.price);
        aVar.lR(bVar.UZ);
        aVar.setPageNumber(i);
        return aVar;
    }

    public static a g(String str, int i, int i2) {
        a aVar = new a();
        aVar.lS(str);
        aVar.mk(i);
        aVar.setPageNumber(i2);
        return aVar;
    }

    public static a a(q qVar, String str) {
        if (qVar == null || qVar.aFf() == null) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.d aFf = qVar.aFf();
        a aVar = new a();
        aVar.mk(com.baidu.adp.lib.h.b.g(aFf.pos_name, 0));
        aVar.lR(aFf.ext_info);
        aVar.setPageNumber(qVar.pageNumber);
        aVar.lS(str);
        aVar.lT(aFf.price);
        return aVar;
    }
}
