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
        bq bqVar;
        bq bqVar2;
        WriteImagesInfo writeImagesInfo;
        bq bqVar3;
        com.baidu.tieba.model.ar arVar;
        com.baidu.tieba.model.ar arVar2;
        com.baidu.tieba.model.ar arVar3;
        bj bjVar;
        bj bjVar2;
        bj bjVar3;
        bq bqVar4;
        com.baidu.tieba.pb.sub.f fVar2;
        bj bjVar4;
        bq bqVar5;
        bj bjVar5;
        this.a.D();
        bqVar = this.a.D;
        bqVar.a(z);
        bqVar2 = this.a.D;
        writeImagesInfo = this.a.n;
        bqVar2.a(writeImagesInfo, true);
        if (z) {
            bqVar3 = this.a.D;
            bqVar3.ac();
            arVar = this.a.z;
            WriteData a = arVar.a();
            arVar2 = this.a.z;
            arVar2.a((WriteData) null);
            arVar3 = this.a.z;
            arVar3.a(false);
            bjVar = this.a.x;
            bjVar.A();
            this.a.a(antiData, str);
            bjVar2 = this.a.x;
            if (!bjVar2.n()) {
                bjVar5 = this.a.x;
                com.baidu.tieba.util.m.b(bjVar5.g(), (WriteData) null);
            }
            if (a != null) {
                String floor = a.getFloor();
                if (a == null || a.getType() != 2) {
                    bjVar3 = this.a.x;
                    if (bjVar3.s()) {
                        bqVar4 = this.a.D;
                        bqVar4.t();
                        return;
                    }
                    return;
                }
                fVar2 = this.a.B;
                fVar2.i();
                if (floor != null) {
                    bjVar4 = this.a.x;
                    com.baidu.tieba.data.af q = bjVar4.q();
                    bqVar5 = this.a.D;
                    bqVar5.a(q);
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
                MessageManager.getInstance().sendMessage(new CustomMessage(2003001, new com.baidu.tbadk.core.atomData.ao(this.a, 12006, writeData, false)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003001, new com.baidu.tbadk.core.atomData.bg(this.a, writeData, 12006)));
            }
        }
    }
}
