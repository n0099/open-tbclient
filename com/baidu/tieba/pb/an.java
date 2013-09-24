package com.baidu.tieba.pb;

import com.baidu.tieba.data.WriteData;
import com.baidu.tieba.write.NewVcodeActivity;
import com.baidu.tieba.write.VcodeActivity;
import java.util.Iterator;
/* loaded from: classes.dex */
class an implements com.baidu.tieba.model.bk {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f1533a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(NewPbActivity newPbActivity) {
        this.f1533a = newPbActivity;
    }

    @Override // com.baidu.tieba.model.bk
    public void a(boolean z, String str, com.baidu.tieba.data.bj bjVar, WriteData writeData) {
        br brVar;
        br brVar2;
        br brVar3;
        com.baidu.tieba.model.bj bjVar2;
        com.baidu.tieba.model.bj bjVar3;
        com.baidu.tieba.model.bj bjVar4;
        com.baidu.tieba.model.bd bdVar;
        br brVar4;
        com.baidu.tieba.model.bd bdVar2;
        br brVar5;
        com.baidu.tieba.model.bg bgVar;
        com.baidu.tieba.model.bd bdVar3;
        br brVar6;
        this.f1533a.v();
        brVar = this.f1533a.t;
        brVar.a(z);
        if (z) {
            brVar3 = this.f1533a.t;
            brVar3.ac();
            bjVar2 = this.f1533a.p;
            WriteData a2 = bjVar2.a();
            bjVar3 = this.f1533a.p;
            bjVar3.a((WriteData) null);
            bjVar4 = this.f1533a.p;
            bjVar4.a(false);
            bdVar = this.f1533a.n;
            bdVar.u();
            brVar4 = this.f1533a.t;
            brVar4.d(str);
            if (a2 != null) {
                String floor = a2.getFloor();
                if (a2 == null || a2.getType() != 2) {
                    bdVar2 = this.f1533a.n;
                    if (bdVar2.m()) {
                        brVar5 = this.f1533a.t;
                        brVar5.x();
                        return;
                    }
                    return;
                }
                bgVar = this.f1533a.r;
                bgVar.f();
                if (floor != null) {
                    bdVar3 = this.f1533a.n;
                    com.baidu.tieba.data.ao k = bdVar3.k();
                    Iterator<com.baidu.tieba.data.as> it = k.d().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        com.baidu.tieba.data.as next = it.next();
                        if (floor.equals(next.d())) {
                            next.b();
                            break;
                        }
                    }
                    brVar6 = this.f1533a.t;
                    brVar6.a(k);
                }
            }
        } else if (bjVar == null || writeData == null || bjVar.b() == null) {
            brVar2 = this.f1533a.t;
            brVar2.d(str);
        } else {
            writeData.setVcodeMD5(bjVar.a());
            writeData.setVcodeUrl(bjVar.b());
            if (bjVar.c().equals("4")) {
                NewVcodeActivity.a(this.f1533a, writeData, 12006);
            } else {
                VcodeActivity.a(this.f1533a, writeData, 12006);
            }
        }
    }
}
