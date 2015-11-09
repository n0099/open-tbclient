package com.baidu.tieba.recapp.report;

import com.baidu.tieba.tbadkCore.data.n;
/* loaded from: classes.dex */
public class e {
    public static a a(com.baidu.tbadk.core.data.b bVar, String str, int i) {
        if (bVar == null) {
            return null;
        }
        a aVar = new a();
        aVar.kA(com.baidu.adp.lib.g.b.g(bVar.Uc, 0));
        aVar.kX(str);
        aVar.kY(bVar.price);
        aVar.kW(bVar.Ui);
        aVar.kB(i);
        return aVar;
    }

    public static a g(String str, int i, int i2) {
        a aVar = new a();
        aVar.kX(str);
        aVar.kA(i);
        aVar.kB(i2);
        return aVar;
    }

    public static a a(n nVar, String str) {
        if (nVar == null || nVar.axg() == null) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.d axg = nVar.axg();
        a aVar = new a();
        aVar.kA(com.baidu.adp.lib.g.b.g(axg.pos_name, 0));
        aVar.kW(axg.ext_info);
        aVar.kB(nVar.cJj);
        aVar.kX(str);
        aVar.kY(axg.price);
        return aVar;
    }
}
