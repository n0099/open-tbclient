package com.baidu.tieba.util;

import com.baidu.tieba.im.message.bt;
import java.util.ArrayList;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements com.baidu.tieba.im.messageCenter.g {
    final /* synthetic */ ab a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ab abVar) {
        this.a = abVar;
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(com.baidu.tieba.im.message.n nVar) {
        ae aeVar;
        ae aeVar2;
        ae aeVar3;
        double d;
        double d2;
        ae aeVar4;
        ae aeVar5;
        if (nVar == null || nVar.t() != 103010) {
            aeVar = this.a.d;
            aeVar.a();
        } else if (!(nVar instanceof bt)) {
            aeVar5 = this.a.d;
            aeVar5.a();
        } else {
            bt btVar = (bt) nVar;
            if (btVar.i()) {
                aeVar4 = this.a.d;
                aeVar4.a();
                return;
            }
            Iterator<String> b = btVar.b();
            ArrayList arrayList = new ArrayList();
            while (b.hasNext()) {
                arrayList.add(b.next());
            }
            String a = btVar.a();
            if ((a == null || a.equals("")) && arrayList.size() < 1) {
                aeVar2 = this.a.d;
                aeVar2.a();
                return;
            }
            aeVar3 = this.a.d;
            d = this.a.b;
            d2 = this.a.a;
            aeVar3.a(a, arrayList, d, d2);
        }
    }
}
