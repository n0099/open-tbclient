package com.baidu.tieba.recapp.report;

import com.baidu.tieba.tbadkCore.data.r;
/* loaded from: classes.dex */
public class e {
    public static a a(com.baidu.tbadk.core.data.c cVar, String str, int i) {
        if (cVar == null) {
            return null;
        }
        a aVar = new a();
        aVar.og(com.baidu.adp.lib.h.b.g(cVar.MT, 0));
        aVar.nq(str);
        aVar.nr(cVar.price);
        aVar.np(cVar.MZ);
        aVar.setPageNumber(i);
        return aVar;
    }

    public static a i(String str, int i, int i2) {
        a aVar = new a();
        aVar.nq(str);
        aVar.og(i);
        aVar.setPageNumber(i2);
        return aVar;
    }

    public static a a(r rVar, String str) {
        if (rVar == null || rVar.aTN() == null) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.e aTN = rVar.aTN();
        a aVar = new a();
        aVar.og(com.baidu.adp.lib.h.b.g(aTN.pos_name, 0));
        aVar.np(aTN.ext_info);
        aVar.setPageNumber(rVar.pageNumber);
        aVar.nq(str);
        aVar.nr(aTN.price);
        return aVar;
    }
}
