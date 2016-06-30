package com.baidu.tieba.recapp.report;

import com.baidu.tieba.tbadkCore.data.r;
/* loaded from: classes.dex */
public class e {
    public static a a(com.baidu.tbadk.core.data.b bVar, String str, int i) {
        if (bVar == null) {
            return null;
        }
        a aVar = new a();
        aVar.pN(com.baidu.adp.lib.h.b.g(bVar.MO, 0));
        aVar.oY(str);
        aVar.oZ(bVar.price);
        aVar.oX(bVar.MU);
        aVar.setPageNumber(i);
        return aVar;
    }

    public static a i(String str, int i, int i2) {
        a aVar = new a();
        aVar.oY(str);
        aVar.pN(i);
        aVar.setPageNumber(i2);
        return aVar;
    }

    public static a a(r rVar, String str) {
        if (rVar == null || rVar.bcb() == null) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.e bcb = rVar.bcb();
        a aVar = new a();
        aVar.pN(com.baidu.adp.lib.h.b.g(bcb.pos_name, 0));
        aVar.oX(bcb.ext_info);
        aVar.setPageNumber(rVar.pageNumber);
        aVar.oY(str);
        aVar.oZ(bcb.price);
        return aVar;
    }
}
