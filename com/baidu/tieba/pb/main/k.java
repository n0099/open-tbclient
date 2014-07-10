package com.baidu.tieba.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.util.AntiHelper;
/* loaded from: classes.dex */
class k implements com.baidu.tieba.model.ar {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // com.baidu.tieba.model.ar
    public void a(boolean z, String str, com.baidu.tbadk.coreExtra.data.f fVar, WriteData writeData, AntiData antiData) {
        bt btVar;
        bt btVar2;
        WriteImagesInfo writeImagesInfo;
        bt btVar3;
        com.baidu.tieba.model.aq aqVar;
        com.baidu.tieba.model.aq aqVar2;
        com.baidu.tieba.model.aq aqVar3;
        bm bmVar;
        bm bmVar2;
        bm bmVar3;
        bt btVar4;
        com.baidu.tieba.pb.sub.f fVar2;
        bm bmVar4;
        bt btVar5;
        bm bmVar5;
        WriteImagesInfo writeImagesInfo2;
        WriteData writeData2;
        this.a.D();
        btVar = this.a.D;
        btVar.a(z);
        btVar2 = this.a.D;
        writeImagesInfo = this.a.l;
        btVar2.a(writeImagesInfo, true);
        if (z) {
            btVar3 = this.a.D;
            btVar3.ad();
            aqVar = this.a.z;
            WriteData a = aqVar.a();
            aqVar2 = this.a.z;
            aqVar2.a((WriteData) null);
            aqVar3 = this.a.z;
            aqVar3.a(false);
            bmVar = this.a.x;
            bmVar.D();
            this.a.a(antiData, str);
            bmVar2 = this.a.x;
            if (!bmVar2.o()) {
                bmVar5 = this.a.x;
                com.baidu.tieba.util.m.b(bmVar5.g(), (WriteData) null);
                writeImagesInfo2 = this.a.m;
                writeImagesInfo2.clear();
                writeData2 = this.a.n;
                writeData2.setIsBaobao(false);
            }
            if (a != null) {
                String floor = a.getFloor();
                if (a == null || a.getType() != 2) {
                    bmVar3 = this.a.x;
                    if (bmVar3.t()) {
                        btVar4 = this.a.D;
                        btVar4.u();
                        return;
                    }
                    return;
                }
                fVar2 = this.a.B;
                fVar2.j();
                if (floor != null) {
                    bmVar4 = this.a.x;
                    com.baidu.tieba.data.ai r = bmVar4.r();
                    btVar5 = this.a.D;
                    btVar5.a(r);
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
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.at(this.a, 12006, writeData, false)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.bu(this.a, writeData, 12006)));
            }
        }
    }
}
