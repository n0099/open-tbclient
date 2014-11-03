package com.baidu.tieba.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.util.AntiHelper;
/* loaded from: classes.dex */
class e implements com.baidu.tieba.model.as {
    final /* synthetic */ PbActivity bvu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(PbActivity pbActivity) {
        this.bvu = pbActivity;
    }

    @Override // com.baidu.tieba.model.as
    public void a(boolean z, String str, com.baidu.tbadk.coreExtra.data.g gVar, WriteData writeData, AntiData antiData) {
        bv bvVar;
        bv bvVar2;
        WriteImagesInfo writeImagesInfo;
        bv bvVar3;
        bv bvVar4;
        com.baidu.tieba.model.ar arVar;
        com.baidu.tieba.model.ar arVar2;
        com.baidu.tieba.model.ar arVar3;
        bn bnVar;
        bn bnVar2;
        bn bnVar3;
        bv bvVar5;
        com.baidu.tieba.pb.sub.e eVar;
        bn bnVar4;
        bv bvVar6;
        bn bnVar5;
        WriteImagesInfo writeImagesInfo2;
        WriteData writeData2;
        this.bvu.EC();
        bvVar = this.bvu.buZ;
        bvVar.bQ(z);
        bvVar2 = this.bvu.buZ;
        writeImagesInfo = this.bvu.writeImagesInfo;
        bvVar2.a(writeImagesInfo, true);
        if (z) {
            bvVar3 = this.bvu.buZ;
            bvVar3.Yg();
            bvVar4 = this.bvu.buZ;
            bvVar4.Xk();
            arVar = this.bvu.ayI;
            WriteData EE = arVar.EE();
            arVar2 = this.bvu.ayI;
            arVar2.b((WriteData) null);
            arVar3 = this.bvu.ayI;
            arVar3.dI(false);
            bnVar = this.bvu.buU;
            bnVar.WV();
            this.bvu.a(antiData, str);
            bnVar2 = this.bvu.buU;
            if (!bnVar2.WM()) {
                bnVar5 = this.bvu.buU;
                com.baidu.tieba.util.l.b(bnVar5.WI(), (WriteData) null);
                writeImagesInfo2 = this.bvu.baobaoImagesInfo;
                writeImagesInfo2.clear();
                writeData2 = this.bvu.aAW;
                writeData2.setIsBaobao(false);
            }
            if (EE != null) {
                String floor = EE.getFloor();
                if (EE == null || EE.getType() != 2) {
                    bnVar3 = this.bvu.buU;
                    if (bnVar3.WP()) {
                        bvVar5 = this.bvu.buZ;
                        bvVar5.XD();
                        return;
                    }
                    return;
                }
                eVar = this.bvu.buX;
                eVar.YQ();
                if (floor != null) {
                    bnVar4 = this.bvu.buU;
                    com.baidu.tieba.data.ah pbData = bnVar4.getPbData();
                    bvVar6 = this.bvu.buZ;
                    bvVar6.e(pbData);
                }
                com.baidu.tieba.util.l.a(EE.getThreadId(), this.bvu);
            }
        } else if (gVar == null || writeData == null || gVar.getVcode_pic_url() == null) {
            this.bvu.a(antiData, str);
        } else if (AntiHelper.e(antiData)) {
            this.bvu.a(antiData, str);
        } else {
            writeData.setVcodeMD5(gVar.getVcode_md5());
            writeData.setVcodeUrl(gVar.getVcode_pic_url());
            if (gVar.oC().equals("4")) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(this.bvu, 12006, writeData, false)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(this.bvu, writeData, 12006)));
            }
        }
    }
}
