package com.baidu.tieba.pb;

import com.baidu.tieba.data.AntiData;
import com.baidu.tieba.data.WriteData;
import com.baidu.tieba.img.WriteImagesInfo;
import com.baidu.tieba.util.AntiHelper;
import com.baidu.tieba.write.NewVcodeActivity;
import com.baidu.tieba.write.VcodeActivity;
import java.util.Iterator;
/* loaded from: classes.dex */
class ar implements com.baidu.tieba.model.bl {
    final /* synthetic */ NewPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(NewPbActivity newPbActivity) {
        this.a = newPbActivity;
    }

    @Override // com.baidu.tieba.model.bl
    public void a(boolean z, String str, com.baidu.tieba.data.bd bdVar, WriteData writeData, AntiData antiData) {
        cu cuVar;
        cu cuVar2;
        WriteImagesInfo writeImagesInfo;
        cu cuVar3;
        com.baidu.tieba.model.bk bkVar;
        com.baidu.tieba.model.bk bkVar2;
        com.baidu.tieba.model.bk bkVar3;
        com.baidu.tieba.model.bb bbVar;
        com.baidu.tieba.model.bb bbVar2;
        com.baidu.tieba.model.bb bbVar3;
        cu cuVar4;
        com.baidu.tieba.model.be beVar;
        com.baidu.tieba.model.bb bbVar4;
        cu cuVar5;
        com.baidu.tieba.model.bb bbVar5;
        this.a.z();
        cuVar = this.a.C;
        cuVar.a(z);
        cuVar2 = this.a.C;
        writeImagesInfo = this.a.m;
        cuVar2.a(writeImagesInfo, true);
        if (z) {
            cuVar3 = this.a.C;
            cuVar3.Y();
            bkVar = this.a.y;
            WriteData a = bkVar.a();
            bkVar2 = this.a.y;
            bkVar2.a((WriteData) null);
            bkVar3 = this.a.y;
            bkVar3.a(false);
            bbVar = this.a.w;
            bbVar.w();
            this.a.a(antiData, str);
            bbVar2 = this.a.w;
            if (!bbVar2.j()) {
                bbVar5 = this.a.w;
                com.baidu.tieba.write.af.b(bbVar5.c(), (WriteData) null);
            }
            if (a != null) {
                String floor = a.getFloor();
                if (a == null || a.getType() != 2) {
                    bbVar3 = this.a.w;
                    if (bbVar3.o()) {
                        cuVar4 = this.a.C;
                        cuVar4.q();
                        return;
                    }
                    return;
                }
                beVar = this.a.A;
                beVar.i();
                if (floor != null) {
                    bbVar4 = this.a.w;
                    com.baidu.tieba.data.am m = bbVar4.m();
                    Iterator<com.baidu.tieba.data.aq> it = m.e().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        com.baidu.tieba.data.aq next = it.next();
                        if (floor.equals(next.d())) {
                            next.b();
                            break;
                        }
                    }
                    cuVar5 = this.a.C;
                    cuVar5.a(m);
                }
                com.baidu.tieba.write.af.a(a.getThreadId(), this.a);
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
