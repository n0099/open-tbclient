package com.baidu.tieba.recapp.report;

import com.baidu.tieba.tbadkCore.data.j;
/* loaded from: classes.dex */
public class e {
    public static a a(com.baidu.tbadk.core.data.b bVar, String str, int i) {
        if (bVar == null) {
            return null;
        }
        a aVar = new a();
        aVar.km(com.baidu.adp.lib.g.b.g(bVar.Ub, 0));
        aVar.kT(str);
        aVar.kU(bVar.price);
        aVar.kS(bVar.Uh);
        aVar.kn(i);
        return aVar;
    }

    public static a g(String str, int i, int i2) {
        a aVar = new a();
        aVar.kT(str);
        aVar.km(i);
        aVar.kn(i2);
        return aVar;
    }

    public static a a(j jVar, String str) {
        if (jVar == null || jVar.aws() == null) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.a aws = jVar.aws();
        a aVar = new a();
        aVar.km(com.baidu.adp.lib.g.b.g(aws.pos_name, 0));
        aVar.kS(aws.ext_info);
        aVar.kn(jVar.cHN);
        aVar.kT(str);
        aVar.kU(aws.price);
        return aVar;
    }
}
