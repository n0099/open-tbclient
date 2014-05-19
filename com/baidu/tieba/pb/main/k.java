package com.baidu.tieba.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.util.AntiHelper;
/* loaded from: classes.dex */
class k implements com.baidu.tieba.model.as {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // com.baidu.tieba.model.as
    public void a(boolean z, String str, com.baidu.tbadk.coreExtra.data.f fVar, WriteData writeData, AntiData antiData) {
        bj bjVar;
        bj bjVar2;
        WriteImagesInfo writeImagesInfo;
        bj bjVar3;
        com.baidu.tieba.model.ar arVar;
        com.baidu.tieba.model.ar arVar2;
        com.baidu.tieba.model.ar arVar3;
        bc bcVar;
        bc bcVar2;
        bc bcVar3;
        bj bjVar4;
        com.baidu.tieba.pb.sub.f fVar2;
        bc bcVar4;
        bj bjVar5;
        bc bcVar5;
        this.a.C();
        bjVar = this.a.E;
        bjVar.a(z);
        bjVar2 = this.a.E;
        writeImagesInfo = this.a.n;
        bjVar2.a(writeImagesInfo, true);
        if (z) {
            bjVar3 = this.a.E;
            bjVar3.ac();
            arVar = this.a.A;
            WriteData a = arVar.a();
            arVar2 = this.a.A;
            arVar2.a((WriteData) null);
            arVar3 = this.a.A;
            arVar3.a(false);
            bcVar = this.a.y;
            bcVar.z();
            this.a.a(antiData, str);
            bcVar2 = this.a.y;
            if (!bcVar2.m()) {
                bcVar5 = this.a.y;
                com.baidu.tieba.util.m.b(bcVar5.f(), (WriteData) null);
            }
            if (a != null) {
                String floor = a.getFloor();
                if (a == null || a.getType() != 2) {
                    bcVar3 = this.a.y;
                    if (bcVar3.r()) {
                        bjVar4 = this.a.E;
                        bjVar4.t();
                        return;
                    }
                    return;
                }
                fVar2 = this.a.C;
                fVar2.i();
                if (floor != null) {
                    bcVar4 = this.a.y;
                    com.baidu.tieba.data.ae p = bcVar4.p();
                    bjVar5 = this.a.E;
                    bjVar5.a(p);
                }
                com.baidu.tieba.util.m.a(a.getThreadId(), this.a);
            }
        } else if (fVar == null || writeData == null || fVar.b() == null) {
            this.a.a(antiData, str);
        } else if (AntiHelper.c(antiData)) {
            this.a.a(antiData, str);
        } else {
            writeData.setVcodeMD5(fVar.a());
            writeData.setVcodeUrl(fVar.b());
            if (fVar.c().equals("4")) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003001, new com.baidu.tbadk.core.atomData.ap(this.a, 12006, writeData, false)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003001, new com.baidu.tbadk.core.atomData.bg(this.a, writeData, 12006)));
            }
        }
    }
}
