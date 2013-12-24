package com.baidu.tieba.pb;

import com.baidu.tieba.data.AntiData;
import com.baidu.tieba.data.WriteData;
import com.baidu.tieba.util.AntiHelper;
import com.baidu.tieba.write.NewVcodeActivity;
import com.baidu.tieba.write.VcodeActivity;
import java.util.Iterator;
/* loaded from: classes.dex */
class av implements com.baidu.tieba.model.bt {
    final /* synthetic */ NewPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(NewPbActivity newPbActivity) {
        this.a = newPbActivity;
    }

    @Override // com.baidu.tieba.model.bt
    public void a(boolean z, String str, com.baidu.tieba.data.bd bdVar, WriteData writeData, AntiData antiData) {
        cr crVar;
        cr crVar2;
        com.baidu.tieba.model.bs bsVar;
        com.baidu.tieba.model.bs bsVar2;
        com.baidu.tieba.model.bs bsVar3;
        com.baidu.tieba.model.bm bmVar;
        com.baidu.tieba.model.bm bmVar2;
        com.baidu.tieba.model.bm bmVar3;
        cr crVar3;
        com.baidu.tieba.model.bp bpVar;
        com.baidu.tieba.model.bm bmVar4;
        cr crVar4;
        com.baidu.tieba.model.bm bmVar5;
        this.a.u();
        crVar = this.a.x;
        crVar.a(z);
        if (z) {
            crVar2 = this.a.x;
            crVar2.Z();
            bsVar = this.a.t;
            WriteData a = bsVar.a();
            bsVar2 = this.a.t;
            bsVar2.a((WriteData) null);
            bsVar3 = this.a.t;
            bsVar3.a(false);
            bmVar = this.a.r;
            bmVar.v();
            this.a.a(antiData, str);
            bmVar2 = this.a.r;
            if (!bmVar2.i()) {
                bmVar5 = this.a.r;
                PbEditorCacheModel.a(bmVar5.b(), "", null);
            }
            if (a != null) {
                String floor = a.getFloor();
                if (a == null || a.getType() != 2) {
                    bmVar3 = this.a.r;
                    if (bmVar3.n()) {
                        crVar3 = this.a.x;
                        crVar3.o();
                        return;
                    }
                    return;
                }
                bpVar = this.a.v;
                bpVar.i();
                if (floor != null) {
                    bmVar4 = this.a.r;
                    com.baidu.tieba.data.an l = bmVar4.l();
                    Iterator<com.baidu.tieba.data.ar> it = l.e().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        com.baidu.tieba.data.ar next = it.next();
                        if (floor.equals(next.d())) {
                            next.b();
                            break;
                        }
                    }
                    crVar4 = this.a.x;
                    crVar4.a(l);
                }
            }
        } else if (bdVar == null || writeData == null || bdVar.b() == null) {
            this.a.a(antiData, str);
        } else if (AntiHelper.c(antiData)) {
            this.a.a(antiData, str);
        } else {
            writeData.setVcodeMD5(bdVar.a());
            writeData.setVcodeUrl(bdVar.b());
            if (bdVar.c().equals("4")) {
                NewVcodeActivity.a(this.a, writeData, 12006);
            } else {
                VcodeActivity.a(this.a, writeData, 12006);
            }
        }
    }
}
