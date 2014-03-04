package com.baidu.tieba.util;

import com.baidu.tieba.im.message.cr;
import java.util.ArrayList;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ak implements com.baidu.tieba.im.messageCenter.g {
    final /* synthetic */ ai a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(ai aiVar) {
        this.a = aiVar;
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public final void a(com.baidu.tieba.im.message.s sVar) {
        al alVar;
        al alVar2;
        al alVar3;
        double d;
        double d2;
        al alVar4;
        al alVar5;
        if (sVar == null || sVar.v() != 103010) {
            alVar = this.a.d;
            alVar.a();
        } else if (!(sVar instanceof cr)) {
            alVar5 = this.a.d;
            alVar5.a();
        } else {
            cr crVar = (cr) sVar;
            if (crVar.l()) {
                alVar4 = this.a.d;
                alVar4.a();
                return;
            }
            Iterator<String> b = crVar.b();
            ArrayList arrayList = new ArrayList();
            while (b.hasNext()) {
                arrayList.add(b.next());
            }
            String a = crVar.a();
            if ((a == null || a.equals("")) && arrayList.size() <= 0) {
                alVar2 = this.a.d;
                alVar2.a();
                return;
            }
            alVar3 = this.a.d;
            d = this.a.b;
            d2 = this.a.a;
            alVar3.a(a, arrayList, d, d2);
        }
    }
}
