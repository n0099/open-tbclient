package com.baidu.tieba.util;

import android.location.Address;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements com.baidu.adp.lib.c.d {
    final /* synthetic */ ab a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(ab abVar) {
        this.a = abVar;
    }

    @Override // com.baidu.adp.lib.c.d
    public void a(int i, String str, Address address) {
        ae aeVar;
        ae aeVar2;
        com.baidu.tieba.im.model.ak akVar;
        com.baidu.tieba.im.model.ak akVar2;
        com.baidu.tieba.im.model.ak akVar3;
        com.baidu.tieba.im.model.ak akVar4;
        switch (i) {
            case 0:
                if (address != null) {
                    this.a.b = address.getLatitude();
                    this.a.a = address.getLongitude();
                    akVar = this.a.c;
                    akVar.b(String.valueOf(address.getLatitude()));
                    akVar2 = this.a.c;
                    akVar2.a(String.valueOf(address.getLongitude()));
                    akVar3 = this.a.c;
                    akVar3.a(0);
                    akVar4 = this.a.c;
                    akVar4.a();
                    return;
                }
                return;
            case 1:
            case 2:
            case 3:
                aeVar2 = this.a.d;
                aeVar2.b();
                return;
            case 4:
            case 5:
                aeVar = this.a.d;
                aeVar.a();
                return;
            default:
                return;
        }
    }
}
