package com.baidu.tieba.recapp.report;

import com.baidu.tieba.tbadkCore.data.q;
/* loaded from: classes.dex */
public class e {
    public static a a(com.baidu.tbadk.core.data.c cVar, String str, int i) {
        if (cVar == null) {
            return null;
        }
        a aVar = new a();
        aVar.no(com.baidu.adp.lib.h.b.g(cVar.Uz, 0));
        aVar.mi(str);
        aVar.mj(cVar.price);
        aVar.mh(cVar.UG);
        aVar.setPageNumber(i);
        return aVar;
    }

    public static a g(String str, int i, int i2) {
        a aVar = new a();
        aVar.mi(str);
        aVar.no(i);
        aVar.setPageNumber(i2);
        return aVar;
    }

    public static a a(q qVar, String str) {
        if (qVar == null || qVar.aMl() == null) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.d aMl = qVar.aMl();
        a aVar = new a();
        aVar.no(com.baidu.adp.lib.h.b.g(aMl.pos_name, 0));
        aVar.mh(aMl.ext_info);
        aVar.setPageNumber(qVar.pageNumber);
        aVar.mi(str);
        aVar.mj(aMl.price);
        return aVar;
    }
}
