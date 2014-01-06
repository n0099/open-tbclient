package com.baidu.tieba.util;

import java.util.ArrayList;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements com.baidu.tieba.im.messageCenter.g {
    final /* synthetic */ ad a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(ad adVar) {
        this.a = adVar;
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(com.baidu.tieba.im.message.o oVar) {
        ag agVar;
        ag agVar2;
        ag agVar3;
        double d;
        double d2;
        ag agVar4;
        ag agVar5;
        if (oVar == null || oVar.u() != 103010) {
            agVar = this.a.d;
            agVar.a();
        } else if (!(oVar instanceof com.baidu.tieba.im.message.bw)) {
            agVar5 = this.a.d;
            agVar5.a();
        } else {
            com.baidu.tieba.im.message.bw bwVar = (com.baidu.tieba.im.message.bw) oVar;
            if (bwVar.i()) {
                agVar4 = this.a.d;
                agVar4.a();
                return;
            }
            Iterator<String> b = bwVar.b();
            ArrayList arrayList = new ArrayList();
            while (b.hasNext()) {
                arrayList.add(b.next());
            }
            String a = bwVar.a();
            if ((a == null || a.equals("")) && arrayList.size() < 1) {
                agVar2 = this.a.d;
                agVar2.a();
                return;
            }
            agVar3 = this.a.d;
            d = this.a.b;
            d2 = this.a.a;
            agVar3.a(a, arrayList, d, d2);
        }
    }
}
