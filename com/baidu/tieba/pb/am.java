package com.baidu.tieba.pb;

import com.baidu.tieba.data.WriteData;
import com.baidu.tieba.write.NewVcodeActivity;
import com.baidu.tieba.write.VcodeActivity;
import java.util.Iterator;
/* loaded from: classes.dex */
class am implements com.baidu.tieba.model.bi {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f1489a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(NewPbActivity newPbActivity) {
        this.f1489a = newPbActivity;
    }

    @Override // com.baidu.tieba.model.bi
    public void a(boolean z, String str, com.baidu.tieba.data.bj bjVar, WriteData writeData) {
        bo boVar;
        bo boVar2;
        bo boVar3;
        com.baidu.tieba.model.bh bhVar;
        com.baidu.tieba.model.bh bhVar2;
        com.baidu.tieba.model.bh bhVar3;
        com.baidu.tieba.model.bb bbVar;
        bo boVar4;
        com.baidu.tieba.model.bb bbVar2;
        bo boVar5;
        com.baidu.tieba.model.be beVar;
        com.baidu.tieba.model.bb bbVar3;
        bo boVar6;
        boVar = this.f1489a.q;
        boVar.a(z);
        if (z) {
            boVar3 = this.f1489a.q;
            boVar3.P();
            bhVar = this.f1489a.m;
            WriteData a2 = bhVar.a();
            bhVar2 = this.f1489a.m;
            bhVar2.a((WriteData) null);
            bhVar3 = this.f1489a.m;
            bhVar3.a(false);
            bbVar = this.f1489a.k;
            bbVar.u();
            boVar4 = this.f1489a.q;
            boVar4.d(str);
            if (a2 != null) {
                String floor = a2.getFloor();
                if (a2 == null || a2.getType() != 2) {
                    bbVar2 = this.f1489a.k;
                    if (bbVar2.m()) {
                        boVar5 = this.f1489a.q;
                        boVar5.n();
                        return;
                    }
                    return;
                }
                beVar = this.f1489a.o;
                beVar.f();
                if (floor != null) {
                    bbVar3 = this.f1489a.k;
                    com.baidu.tieba.data.ao k = bbVar3.k();
                    Iterator it = k.d().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        com.baidu.tieba.data.as asVar = (com.baidu.tieba.data.as) it.next();
                        if (floor.equals(asVar.d())) {
                            asVar.b();
                            break;
                        }
                    }
                    boVar6 = this.f1489a.q;
                    boVar6.a(k);
                }
            }
        } else if (bjVar == null || writeData == null || bjVar.b() == null) {
            boVar2 = this.f1489a.q;
            boVar2.d(str);
        } else {
            writeData.setVcodeMD5(bjVar.a());
            writeData.setVcodeUrl(bjVar.b());
            if (bjVar.c().equals("4")) {
                NewVcodeActivity.a(this.f1489a, writeData, 12006);
            } else {
                VcodeActivity.a(this.f1489a, writeData, 12006);
            }
        }
    }
}
