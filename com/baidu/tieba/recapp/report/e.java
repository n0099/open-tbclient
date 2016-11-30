package com.baidu.tieba.recapp.report;

import com.baidu.tieba.tbadkCore.data.p;
/* loaded from: classes.dex */
public class e {
    public static a a(com.baidu.tbadk.core.data.c cVar, int i, int i2) {
        if (cVar == null) {
            return null;
        }
        a aVar = new a();
        aVar.rj(com.baidu.adp.lib.h.b.g(cVar.adPosition, 0));
        aVar.ri(i);
        aVar.qY(cVar.price);
        aVar.qX(cVar.extensionInfo);
        aVar.setPageNumber(i2);
        aVar.ra(cVar.PE);
        aVar.rb(cVar.PF);
        aVar.rc(cVar.PG);
        aVar.rd(cVar.OS);
        return aVar;
    }

    public static a a(DownloadStaticsData downloadStaticsData, int i, int i2) {
        if (downloadStaticsData == null) {
            return null;
        }
        a aVar = new a();
        aVar.setDownloadStaticsData(downloadStaticsData);
        aVar.ri(i);
        aVar.setPageNumber(i2);
        return aVar;
    }

    public static a P(int i, int i2, int i3) {
        a aVar = new a();
        aVar.ri(i);
        aVar.rj(i2);
        aVar.setPageNumber(i3);
        return aVar;
    }

    public static a a(p pVar, int i) {
        if (pVar == null || pVar.blZ() == null) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.e blZ = pVar.blZ();
        a aVar = new a();
        aVar.rj(com.baidu.adp.lib.h.b.g(blZ.pos_name, 0));
        aVar.qX(blZ.ext_info);
        aVar.setPageNumber(pVar.pageNumber);
        aVar.ri(i);
        aVar.qY(blZ.price);
        aVar.ra(pVar.PE);
        aVar.rb(pVar.PF);
        aVar.rc(pVar.forumId);
        aVar.rd("PB");
        return aVar;
    }

    public static a a(com.baidu.tbadk.core.data.c cVar, int i, int i2, int i3, int i4, int i5) {
        a a = a(cVar, i, i2);
        a.rk(i3);
        a.rl(i4);
        a.rm(i5);
        a.rd(cVar.OS);
        return a;
    }
}
