package com.baidu.tieba.recapp.report;

import com.baidu.tieba.tbadkCore.data.r;
/* loaded from: classes.dex */
public class e {
    public static a a(com.baidu.tbadk.core.data.b bVar, String str, int i) {
        if (bVar == null) {
            return null;
        }
        a aVar = new a();
        aVar.qf(com.baidu.adp.lib.h.b.g(bVar.MM, 0));
        aVar.pJ(str);
        aVar.pK(bVar.price);
        aVar.pI(bVar.MS);
        aVar.setPageNumber(i);
        return aVar;
    }

    public static a i(String str, int i, int i2) {
        a aVar = new a();
        aVar.pJ(str);
        aVar.qf(i);
        aVar.setPageNumber(i2);
        return aVar;
    }

    public static a a(r rVar, String str) {
        if (rVar == null || rVar.bfq() == null) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.e bfq = rVar.bfq();
        a aVar = new a();
        aVar.qf(com.baidu.adp.lib.h.b.g(bfq.pos_name, 0));
        aVar.pI(bfq.ext_info);
        aVar.setPageNumber(rVar.pageNumber);
        aVar.pJ(str);
        aVar.pK(bfq.price);
        return aVar;
    }
}
