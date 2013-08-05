package com.baidu.tieba.pb;

import com.baidu.tieba.data.WriteData;
import com.baidu.tieba.write.NewVcodeActivity;
import com.baidu.tieba.write.VcodeActivity;
import java.util.Iterator;
/* loaded from: classes.dex */
class am implements com.baidu.tieba.model.bj {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f1454a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(NewPbActivity newPbActivity) {
        this.f1454a = newPbActivity;
    }

    @Override // com.baidu.tieba.model.bj
    public void a(boolean z, String str, com.baidu.tieba.data.bq bqVar, WriteData writeData) {
        bn bnVar;
        bn bnVar2;
        bn bnVar3;
        com.baidu.tieba.model.bi biVar;
        com.baidu.tieba.model.bi biVar2;
        com.baidu.tieba.model.bi biVar3;
        bn bnVar4;
        com.baidu.tieba.model.bc bcVar;
        bn bnVar5;
        com.baidu.tieba.model.bf bfVar;
        com.baidu.tieba.model.bc bcVar2;
        bn bnVar6;
        bnVar = this.f1454a.p;
        bnVar.a(z);
        if (z) {
            bnVar3 = this.f1454a.p;
            bnVar3.O();
            biVar = this.f1454a.l;
            WriteData a2 = biVar.a();
            biVar2 = this.f1454a.l;
            biVar2.a((WriteData) null);
            biVar3 = this.f1454a.l;
            biVar3.a(false);
            bnVar4 = this.f1454a.p;
            bnVar4.d(str);
            if (a2 != null) {
                String floor = a2.getFloor();
                if (a2 == null || a2.getType() != 2) {
                    bcVar = this.f1454a.j;
                    if (bcVar.l()) {
                        bnVar5 = this.f1454a.p;
                        bnVar5.m();
                        return;
                    }
                    return;
                }
                bfVar = this.f1454a.n;
                bfVar.f();
                if (floor != null) {
                    bcVar2 = this.f1454a.j;
                    com.baidu.tieba.data.as j = bcVar2.j();
                    Iterator it = j.c().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        com.baidu.tieba.data.aw awVar = (com.baidu.tieba.data.aw) it.next();
                        if (floor.equals(awVar.d())) {
                            awVar.b();
                            break;
                        }
                    }
                    bnVar6 = this.f1454a.p;
                    bnVar6.a(j);
                }
            }
        } else if (bqVar == null || writeData == null || bqVar.b() == null) {
            bnVar2 = this.f1454a.p;
            bnVar2.d(str);
        } else {
            writeData.setVcodeMD5(bqVar.a());
            writeData.setVcodeUrl(bqVar.b());
            if (bqVar.c().equals("4")) {
                NewVcodeActivity.a(this.f1454a, writeData, 12006);
            } else {
                VcodeActivity.a(this.f1454a, writeData, 12006);
            }
        }
    }
}
