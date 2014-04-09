package com.baidu.tieba.pb.main;

import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.util.AntiHelper;
/* loaded from: classes.dex */
final class k implements com.baidu.tieba.model.as {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // com.baidu.tieba.model.as
    public final void a(boolean z, String str, com.baidu.tbadk.coreExtra.data.f fVar, WriteData writeData, AntiData antiData) {
        bm bmVar;
        bm bmVar2;
        WriteImagesInfo writeImagesInfo;
        bm bmVar3;
        com.baidu.tieba.model.ar arVar;
        com.baidu.tieba.model.ar arVar2;
        com.baidu.tieba.model.ar arVar3;
        bf bfVar;
        bf bfVar2;
        bf bfVar3;
        bm bmVar4;
        com.baidu.tieba.pb.sub.f fVar2;
        bf bfVar4;
        bm bmVar5;
        bf bfVar5;
        this.a.v();
        bmVar = this.a.D;
        bmVar.a(z);
        bmVar2 = this.a.D;
        writeImagesInfo = this.a.n;
        bmVar2.a(writeImagesInfo, true);
        if (z) {
            bmVar3 = this.a.D;
            bmVar3.ab();
            arVar = this.a.z;
            WriteData a = arVar.a();
            arVar2 = this.a.z;
            arVar2.a((WriteData) null);
            arVar3 = this.a.z;
            arVar3.a(false);
            bfVar = this.a.x;
            bfVar.y();
            PbActivity.a(this.a, antiData, str);
            bfVar2 = this.a.x;
            if (!bfVar2.m()) {
                bfVar5 = this.a.x;
                com.baidu.tieba.util.m.b(bfVar5.f(), (WriteData) null);
            }
            if (a != null) {
                String floor = a.getFloor();
                if (a == null || a.getType() != 2) {
                    bfVar3 = this.a.x;
                    if (bfVar3.r()) {
                        bmVar4 = this.a.D;
                        bmVar4.t();
                        return;
                    }
                    return;
                }
                fVar2 = this.a.B;
                fVar2.i();
                if (floor != null) {
                    bfVar4 = this.a.x;
                    com.baidu.tieba.data.ae p = bfVar4.p();
                    bmVar5 = this.a.D;
                    bmVar5.a(p);
                }
                com.baidu.tieba.util.m.a(a.getThreadId(), this.a);
            }
        } else if (fVar == null || writeData == null || fVar.b() == null) {
            PbActivity.a(this.a, antiData, str);
        } else if (AntiHelper.c(antiData)) {
            PbActivity.a(this.a, antiData, str);
        } else {
            writeData.setVcodeMD5(fVar.a());
            writeData.setVcodeUrl(fVar.b());
            if (fVar.c().equals("4")) {
                com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001001, new com.baidu.tbadk.core.b.ac(this.a, 12006, writeData, false)));
            } else {
                com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001001, new com.baidu.tbadk.core.b.au(this.a, writeData, 12006)));
            }
        }
    }
}
