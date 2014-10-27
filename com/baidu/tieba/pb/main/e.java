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
    final /* synthetic */ PbActivity bvg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(PbActivity pbActivity) {
        this.bvg = pbActivity;
    }

    @Override // com.baidu.tieba.model.as
    public void a(boolean z, String str, com.baidu.tbadk.coreExtra.data.f fVar, WriteData writeData, AntiData antiData) {
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
        this.bvg.EA();
        bvVar = this.bvg.buL;
        bvVar.bQ(z);
        bvVar2 = this.bvg.buL;
        writeImagesInfo = this.bvg.writeImagesInfo;
        bvVar2.a(writeImagesInfo, true);
        if (z) {
            bvVar3 = this.bvg.buL;
            bvVar3.Yd();
            bvVar4 = this.bvg.buL;
            bvVar4.Xh();
            arVar = this.bvg.ayz;
            WriteData EC = arVar.EC();
            arVar2 = this.bvg.ayz;
            arVar2.b((WriteData) null);
            arVar3 = this.bvg.ayz;
            arVar3.dI(false);
            bnVar = this.bvg.buG;
            bnVar.WS();
            this.bvg.a(antiData, str);
            bnVar2 = this.bvg.buG;
            if (!bnVar2.WJ()) {
                bnVar5 = this.bvg.buG;
                com.baidu.tieba.util.l.b(bnVar5.WF(), (WriteData) null);
                writeImagesInfo2 = this.bvg.baobaoImagesInfo;
                writeImagesInfo2.clear();
                writeData2 = this.bvg.aAM;
                writeData2.setIsBaobao(false);
            }
            if (EC != null) {
                String floor = EC.getFloor();
                if (EC == null || EC.getType() != 2) {
                    bnVar3 = this.bvg.buG;
                    if (bnVar3.WM()) {
                        bvVar5 = this.bvg.buL;
                        bvVar5.XA();
                        return;
                    }
                    return;
                }
                eVar = this.bvg.buJ;
                eVar.YN();
                if (floor != null) {
                    bnVar4 = this.bvg.buG;
                    com.baidu.tieba.data.ah pbData = bnVar4.getPbData();
                    bvVar6 = this.bvg.buL;
                    bvVar6.e(pbData);
                }
                com.baidu.tieba.util.l.a(EC.getThreadId(), this.bvg);
            }
        } else if (fVar == null || writeData == null || fVar.getVcode_pic_url() == null) {
            this.bvg.a(antiData, str);
        } else if (AntiHelper.e(antiData)) {
            this.bvg.a(antiData, str);
        } else {
            writeData.setVcodeMD5(fVar.getVcode_md5());
            writeData.setVcodeUrl(fVar.getVcode_pic_url());
            if (fVar.oA().equals("4")) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(this.bvg, 12006, writeData, false)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(this.bvg, writeData, 12006)));
            }
        }
    }
}
