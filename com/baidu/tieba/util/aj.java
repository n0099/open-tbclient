package com.baidu.tieba.util;

import android.location.Address;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements com.baidu.adp.lib.c.d {
    final /* synthetic */ ai a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ai aiVar) {
        this.a = aiVar;
    }

    @Override // com.baidu.adp.lib.c.d
    public void a(int i, String str, Address address) {
        al alVar;
        al alVar2;
        com.baidu.tieba.im.model.am amVar;
        com.baidu.tieba.im.model.am amVar2;
        com.baidu.tieba.im.model.am amVar3;
        com.baidu.tieba.im.model.am amVar4;
        switch (i) {
            case 0:
                if (address != null) {
                    this.a.b = address.getLatitude();
                    this.a.a = address.getLongitude();
                    amVar = this.a.c;
                    amVar.b(String.valueOf(address.getLatitude()));
                    amVar2 = this.a.c;
                    amVar2.a(String.valueOf(address.getLongitude()));
                    amVar3 = this.a.c;
                    amVar3.a(0);
                    amVar4 = this.a.c;
                    amVar4.a();
                    return;
                }
                return;
            case 1:
            case 2:
            case 3:
                alVar2 = this.a.d;
                alVar2.b();
                return;
            case 4:
            case 5:
                alVar = this.a.d;
                alVar.a();
                return;
            default:
                return;
        }
    }
}
