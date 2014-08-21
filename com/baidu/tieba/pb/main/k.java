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
    public void a(boolean z, String str, com.baidu.tbadk.coreExtra.data.e eVar, WriteData writeData, AntiData antiData) {
        bs bsVar;
        bs bsVar2;
        WriteImagesInfo writeImagesInfo;
        bs bsVar3;
        com.baidu.tieba.model.ar arVar;
        com.baidu.tieba.model.ar arVar2;
        com.baidu.tieba.model.ar arVar3;
        bl blVar;
        bl blVar2;
        bl blVar3;
        bs bsVar4;
        com.baidu.tieba.pb.sub.e eVar2;
        bl blVar4;
        bs bsVar5;
        bl blVar5;
        WriteImagesInfo writeImagesInfo2;
        WriteData writeData2;
        this.a.G();
        bsVar = this.a.E;
        bsVar.a(z);
        bsVar2 = this.a.E;
        writeImagesInfo = this.a.m;
        bsVar2.a(writeImagesInfo, true);
        if (z) {
            bsVar3 = this.a.E;
            bsVar3.ad();
            arVar = this.a.A;
            WriteData a = arVar.a();
            arVar2 = this.a.A;
            arVar2.a((WriteData) null);
            arVar3 = this.a.A;
            arVar3.a(false);
            blVar = this.a.y;
            blVar.D();
            this.a.a(antiData, str);
            blVar2 = this.a.y;
            if (!blVar2.o()) {
                blVar5 = this.a.y;
                com.baidu.tieba.util.m.b(blVar5.g(), (WriteData) null);
                writeImagesInfo2 = this.a.n;
                writeImagesInfo2.clear();
                writeData2 = this.a.o;
                writeData2.setIsBaobao(false);
            }
            if (a != null) {
                String floor = a.getFloor();
                if (a == null || a.getType() != 2) {
                    blVar3 = this.a.y;
                    if (blVar3.t()) {
                        bsVar4 = this.a.E;
                        bsVar4.u();
                        return;
                    }
                    return;
                }
                eVar2 = this.a.C;
                eVar2.k();
                if (floor != null) {
                    blVar4 = this.a.y;
                    com.baidu.tieba.data.aj r = blVar4.r();
                    bsVar5 = this.a.E;
                    bsVar5.a(r);
                }
                com.baidu.tieba.util.m.a(a.getThreadId(), this.a);
            }
        } else if (eVar == null || writeData == null || eVar.b() == null) {
            this.a.a(antiData, str);
        } else if (AntiHelper.c(antiData)) {
            this.a.a(antiData, str);
        } else {
            writeData.setVcodeMD5(eVar.a());
            writeData.setVcodeUrl(eVar.b());
            if (eVar.c().equals("4")) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.az(this.a, 12006, writeData, false)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.ce(this.a, writeData, 12006)));
            }
        }
    }
}
