package com.baidu.tieba.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
class g implements com.baidu.tieba.tbadkCore.f.c {
    final /* synthetic */ PbActivity bAS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(PbActivity pbActivity) {
        this.bAS = pbActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.f.c
    public void a(boolean z, com.baidu.tieba.tbadkCore.f.f fVar, com.baidu.tbadk.coreExtra.data.j jVar, WriteData writeData, AntiData antiData) {
        bz bzVar;
        bz bzVar2;
        WriteImagesInfo writeImagesInfo;
        bz bzVar3;
        bz bzVar4;
        com.baidu.tieba.tbadkCore.f.a aVar;
        com.baidu.tieba.tbadkCore.f.a aVar2;
        com.baidu.tieba.tbadkCore.f.a aVar3;
        bq bqVar;
        bq bqVar2;
        bq bqVar3;
        bz bzVar5;
        com.baidu.tieba.pb.sub.e eVar;
        bq bqVar4;
        bz bzVar6;
        bq bqVar5;
        WriteImagesInfo writeImagesInfo2;
        WriteData writeData2;
        this.bAS.stopVoice();
        bzVar = this.bAS.bAw;
        bzVar.bG(z);
        bzVar2 = this.bAS.bAw;
        writeImagesInfo = this.bAS.writeImagesInfo;
        bzVar2.a(writeImagesInfo, true);
        String str = "";
        if (fVar != null) {
            str = fVar.getErrorString();
        }
        if (z) {
            bzVar3 = this.bAS.bAw;
            bzVar3.Ze();
            bzVar4 = this.bAS.bAw;
            bzVar4.Yh();
            aVar = this.bAS.aBJ;
            WriteData Fn = aVar.Fn();
            aVar2 = this.bAS.aBJ;
            aVar2.c((WriteData) null);
            aVar3 = this.bAS.aBJ;
            aVar3.eF(false);
            bqVar = this.bAS.bAr;
            bqVar.XS();
            this.bAS.a(antiData, fVar);
            bqVar2 = this.bAS.bAr;
            if (!bqVar2.XJ()) {
                bqVar5 = this.bAS.bAr;
                com.baidu.tieba.tbadkCore.al.b(bqVar5.XF(), (WriteData) null);
                writeImagesInfo2 = this.bAS.baobaoImagesInfo;
                writeImagesInfo2.clear();
                writeData2 = this.bAS.aDp;
                writeData2.setIsBaobao(false);
            }
            if (Fn != null) {
                String floor = Fn.getFloor();
                if (Fn == null || Fn.getType() != 2) {
                    bqVar3 = this.bAS.bAr;
                    if (bqVar3.XM()) {
                        bzVar5 = this.bAS.bAw;
                        bzVar5.YA();
                        return;
                    }
                    return;
                }
                eVar = this.bAS.bAu;
                eVar.ZK();
                if (floor != null) {
                    bqVar4 = this.bAS.bAr;
                    com.baidu.tieba.tbadkCore.b.i pbData = bqVar4.getPbData();
                    bzVar6 = this.bAS.bAw;
                    bzVar6.e(pbData);
                }
                com.baidu.tieba.tbadkCore.al.a(Fn.getThreadId(), (com.baidu.tieba.tbadkCore.am) this.bAS.getPageContext().getOrignalPage());
            }
        } else if (jVar == null || writeData == null || jVar.getVcode_pic_url() == null) {
            this.bAS.a(antiData, str);
        } else if (AntiHelper.e(antiData)) {
            this.bAS.a(antiData, str);
        } else {
            writeData.setVcodeMD5(jVar.getVcode_md5());
            writeData.setVcodeUrl(jVar.getVcode_pic_url());
            if (jVar.rK().equals("4")) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(this.bAS.getPageContext().getPageActivity(), 12006, writeData, false)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(this.bAS.getPageContext().getPageActivity(), writeData, 12006)));
            }
        }
    }
}
