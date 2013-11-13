package com.baidu.tieba.pb;

import com.baidu.tieba.data.AntiData;
import com.baidu.tieba.data.WriteData;
import com.baidu.tieba.util.AntiHelper;
import com.baidu.tieba.write.NewVcodeActivity;
import com.baidu.tieba.write.VcodeActivity;
import java.util.Iterator;
/* loaded from: classes.dex */
class av implements com.baidu.tieba.model.bt {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f2079a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(NewPbActivity newPbActivity) {
        this.f2079a = newPbActivity;
    }

    @Override // com.baidu.tieba.model.bt
    public void a(boolean z, String str, com.baidu.tieba.data.be beVar, WriteData writeData, AntiData antiData) {
        cp cpVar;
        cp cpVar2;
        com.baidu.tieba.model.bs bsVar;
        com.baidu.tieba.model.bs bsVar2;
        com.baidu.tieba.model.bs bsVar3;
        com.baidu.tieba.model.bm bmVar;
        com.baidu.tieba.model.bm bmVar2;
        com.baidu.tieba.model.bm bmVar3;
        cp cpVar3;
        com.baidu.tieba.model.bp bpVar;
        com.baidu.tieba.model.bm bmVar4;
        cp cpVar4;
        com.baidu.tieba.model.bm bmVar5;
        this.f2079a.t();
        cpVar = this.f2079a.y;
        cpVar.a(z);
        if (z) {
            cpVar2 = this.f2079a.y;
            cpVar2.Z();
            bsVar = this.f2079a.u;
            WriteData a2 = bsVar.a();
            bsVar2 = this.f2079a.u;
            bsVar2.a((WriteData) null);
            bsVar3 = this.f2079a.u;
            bsVar3.a(false);
            bmVar = this.f2079a.s;
            bmVar.v();
            this.f2079a.a(antiData, str);
            bmVar2 = this.f2079a.s;
            if (!bmVar2.i()) {
                bmVar5 = this.f2079a.s;
                PbEditorCacheModel.a(bmVar5.b(), "", null);
            }
            if (a2 != null) {
                String floor = a2.getFloor();
                if (a2 == null || a2.getType() != 2) {
                    bmVar3 = this.f2079a.s;
                    if (bmVar3.n()) {
                        cpVar3 = this.f2079a.y;
                        cpVar3.o();
                        return;
                    }
                    return;
                }
                bpVar = this.f2079a.w;
                bpVar.i();
                if (floor != null) {
                    bmVar4 = this.f2079a.s;
                    com.baidu.tieba.data.ao l = bmVar4.l();
                    Iterator<com.baidu.tieba.data.as> it = l.e().iterator();
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
                    cpVar4 = this.f2079a.y;
                    cpVar4.a(l);
                }
            }
        } else if (beVar == null || writeData == null || beVar.b() == null) {
            this.f2079a.a(antiData, str);
        } else if (AntiHelper.c(antiData)) {
            this.f2079a.a(antiData, str);
        } else {
            writeData.setVcodeMD5(beVar.a());
            writeData.setVcodeUrl(beVar.b());
            if (beVar.c().equals("4")) {
                NewVcodeActivity.a(this.f2079a, writeData, 12006);
            } else {
                VcodeActivity.a(this.f2079a, writeData, 12006);
            }
        }
    }
}
