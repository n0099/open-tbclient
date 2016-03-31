package com.baidu.tieba.recapp.report;

import com.baidu.tieba.tbadkCore.data.r;
/* loaded from: classes.dex */
public class e {
    public static a a(com.baidu.tbadk.core.data.c cVar, String str, int i) {
        if (cVar == null) {
            return null;
        }
        a aVar = new a();
        aVar.or(com.baidu.adp.lib.h.b.g(cVar.Sf, 0));
        aVar.nr(str);
        aVar.ns(cVar.price);
        aVar.nq(cVar.Sl);
        aVar.setPageNumber(i);
        return aVar;
    }

    public static a h(String str, int i, int i2) {
        a aVar = new a();
        aVar.nr(str);
        aVar.or(i);
        aVar.setPageNumber(i2);
        return aVar;
    }

    public static a a(r rVar, String str) {
        if (rVar == null || rVar.aTh() == null) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.e aTh = rVar.aTh();
        a aVar = new a();
        aVar.or(com.baidu.adp.lib.h.b.g(aTh.pos_name, 0));
        aVar.nq(aTh.ext_info);
        aVar.setPageNumber(rVar.pageNumber);
        aVar.nr(str);
        aVar.ns(aTh.price);
        return aVar;
    }
}
