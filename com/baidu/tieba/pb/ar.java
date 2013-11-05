package com.baidu.tieba.pb;

import com.baidu.tieba.data.WriteData;
import com.baidu.tieba.write.NewVcodeActivity;
import com.baidu.tieba.write.VcodeActivity;
import java.util.Iterator;
/* loaded from: classes.dex */
class ar implements com.baidu.tieba.model.bs {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f2054a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(NewPbActivity newPbActivity) {
        this.f2054a = newPbActivity;
    }

    @Override // com.baidu.tieba.model.bs
    public void a(boolean z, String str, com.baidu.tieba.data.bh bhVar, WriteData writeData) {
        bt btVar;
        bt btVar2;
        bt btVar3;
        com.baidu.tieba.model.br brVar;
        com.baidu.tieba.model.br brVar2;
        com.baidu.tieba.model.br brVar3;
        com.baidu.tieba.model.bl blVar;
        bt btVar4;
        com.baidu.tieba.model.bl blVar2;
        bt btVar5;
        com.baidu.tieba.model.bo boVar;
        com.baidu.tieba.model.bl blVar3;
        bt btVar6;
        this.f2054a.w();
        btVar = this.f2054a.u;
        btVar.a(z);
        if (z) {
            btVar3 = this.f2054a.u;
            btVar3.ac();
            brVar = this.f2054a.q;
            WriteData a2 = brVar.a();
            brVar2 = this.f2054a.q;
            brVar2.a((WriteData) null);
            brVar3 = this.f2054a.q;
            brVar3.a(false);
            blVar = this.f2054a.o;
            blVar.u();
            btVar4 = this.f2054a.u;
            btVar4.d(str);
            if (a2 != null) {
                String floor = a2.getFloor();
                if (a2 == null || a2.getType() != 2) {
                    blVar2 = this.f2054a.o;
                    if (blVar2.m()) {
                        btVar5 = this.f2054a.u;
                        btVar5.x();
                        return;
                    }
                    return;
                }
                boVar = this.f2054a.s;
                boVar.f();
                if (floor != null) {
                    blVar3 = this.f2054a.o;
                    com.baidu.tieba.data.ao k = blVar3.k();
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
                    btVar6 = this.f2054a.u;
                    btVar6.a(k);
                }
            }
        } else if (bhVar == null || writeData == null || bhVar.b() == null) {
            btVar2 = this.f2054a.u;
            btVar2.d(str);
        } else {
            writeData.setVcodeMD5(bhVar.a());
            writeData.setVcodeUrl(bhVar.b());
            if (bhVar.c().equals("4")) {
                NewVcodeActivity.a(this.f2054a, writeData, 12006);
            } else {
                VcodeActivity.a(this.f2054a, writeData, 12006);
            }
        }
    }
}
