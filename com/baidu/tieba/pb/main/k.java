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
        bk bkVar;
        bk bkVar2;
        WriteImagesInfo writeImagesInfo;
        bk bkVar3;
        com.baidu.tieba.model.ar arVar;
        com.baidu.tieba.model.ar arVar2;
        com.baidu.tieba.model.ar arVar3;
        bd bdVar;
        bd bdVar2;
        bd bdVar3;
        bk bkVar4;
        com.baidu.tieba.pb.sub.f fVar2;
        bd bdVar4;
        bk bkVar5;
        bd bdVar5;
        this.a.v();
        bkVar = this.a.D;
        bkVar.a(z);
        bkVar2 = this.a.D;
        writeImagesInfo = this.a.n;
        bkVar2.a(writeImagesInfo, true);
        if (z) {
            bkVar3 = this.a.D;
            bkVar3.ab();
            arVar = this.a.z;
            WriteData a = arVar.a();
            arVar2 = this.a.z;
            arVar2.a((WriteData) null);
            arVar3 = this.a.z;
            arVar3.a(false);
            bdVar = this.a.x;
            bdVar.y();
            PbActivity.a(this.a, antiData, str);
            bdVar2 = this.a.x;
            if (!bdVar2.m()) {
                bdVar5 = this.a.x;
                com.baidu.tieba.util.m.b(bdVar5.f(), (WriteData) null);
            }
            if (a != null) {
                String floor = a.getFloor();
                if (a == null || a.getType() != 2) {
                    bdVar3 = this.a.x;
                    if (bdVar3.r()) {
                        bkVar4 = this.a.D;
                        bkVar4.t();
                        return;
                    }
                    return;
                }
                fVar2 = this.a.B;
                fVar2.i();
                if (floor != null) {
                    bdVar4 = this.a.x;
                    com.baidu.tieba.data.ae p = bdVar4.p();
                    bkVar5 = this.a.D;
                    bkVar5.a(p);
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
