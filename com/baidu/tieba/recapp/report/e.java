package com.baidu.tieba.recapp.report;

import com.baidu.tieba.tbadkCore.data.n;
/* loaded from: classes.dex */
public class e {
    public static a a(com.baidu.tbadk.core.data.b bVar, String str, int i) {
        if (bVar == null) {
            return null;
        }
        a aVar = new a();
        aVar.lL(com.baidu.adp.lib.h.b.g(bVar.Us, 0));
        aVar.lU(str);
        aVar.lV(bVar.price);
        aVar.lT(bVar.Uy);
        aVar.setPageNumber(i);
        return aVar;
    }

    public static a g(String str, int i, int i2) {
        a aVar = new a();
        aVar.lU(str);
        aVar.lL(i);
        aVar.setPageNumber(i2);
        return aVar;
    }

    public static a a(n nVar, String str) {
        if (nVar == null || nVar.aCS() == null) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.d aCS = nVar.aCS();
        a aVar = new a();
        aVar.lL(com.baidu.adp.lib.h.b.g(aCS.pos_name, 0));
        aVar.lT(aCS.ext_info);
        aVar.setPageNumber(nVar.pageNumber);
        aVar.lU(str);
        aVar.lV(aCS.price);
        return aVar;
    }
}
