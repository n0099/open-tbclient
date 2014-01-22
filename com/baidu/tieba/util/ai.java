package com.baidu.tieba.util;

import com.baidu.tieba.im.message.ci;
import java.util.ArrayList;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements com.baidu.tieba.im.messageCenter.g {
    final /* synthetic */ ag a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(ag agVar) {
        this.a = agVar;
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(com.baidu.tieba.im.message.q qVar) {
        aj ajVar;
        aj ajVar2;
        aj ajVar3;
        double d;
        double d2;
        aj ajVar4;
        aj ajVar5;
        if (qVar == null || qVar.w() != 103010) {
            ajVar = this.a.d;
            ajVar.a();
        } else if (!(qVar instanceof ci)) {
            ajVar5 = this.a.d;
            ajVar5.a();
        } else {
            ci ciVar = (ci) qVar;
            if (ciVar.k()) {
                ajVar4 = this.a.d;
                ajVar4.a();
                return;
            }
            Iterator<String> b = ciVar.b();
            ArrayList arrayList = new ArrayList();
            while (b.hasNext()) {
                arrayList.add(b.next());
            }
            String a = ciVar.a();
            if ((a == null || a.equals("")) && arrayList.size() < 1) {
                ajVar2 = this.a.d;
                ajVar2.a();
                return;
            }
            ajVar3 = this.a.d;
            d = this.a.b;
            d2 = this.a.a;
            ajVar3.a(a, arrayList, d, d2);
        }
    }
}
