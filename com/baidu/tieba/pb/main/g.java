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
    final /* synthetic */ PbActivity bAT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(PbActivity pbActivity) {
        this.bAT = pbActivity;
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
        this.bAT.stopVoice();
        bzVar = this.bAT.bAx;
        bzVar.bG(z);
        bzVar2 = this.bAT.bAx;
        writeImagesInfo = this.bAT.writeImagesInfo;
        bzVar2.a(writeImagesInfo, true);
        String str = "";
        if (fVar != null) {
            str = fVar.getErrorString();
        }
        if (z) {
            bzVar3 = this.bAT.bAx;
            bzVar3.Zj();
            bzVar4 = this.bAT.bAx;
            bzVar4.Ym();
            aVar = this.bAT.aBM;
            WriteData Ft = aVar.Ft();
            aVar2 = this.bAT.aBM;
            aVar2.c((WriteData) null);
            aVar3 = this.bAT.aBM;
            aVar3.eF(false);
            bqVar = this.bAT.bAs;
            bqVar.XX();
            this.bAT.a(antiData, fVar);
            bqVar2 = this.bAT.bAs;
            if (!bqVar2.XO()) {
                bqVar5 = this.bAT.bAs;
                com.baidu.tieba.tbadkCore.al.b(bqVar5.XK(), (WriteData) null);
                writeImagesInfo2 = this.bAT.baobaoImagesInfo;
                writeImagesInfo2.clear();
                writeData2 = this.bAT.aDs;
                writeData2.setIsBaobao(false);
            }
            if (Ft != null) {
                String floor = Ft.getFloor();
                if (Ft == null || Ft.getType() != 2) {
                    bqVar3 = this.bAT.bAs;
                    if (bqVar3.XR()) {
                        bzVar5 = this.bAT.bAx;
                        bzVar5.YF();
                        return;
                    }
                    return;
                }
                eVar = this.bAT.bAv;
                eVar.ZP();
                if (floor != null) {
                    bqVar4 = this.bAT.bAs;
                    com.baidu.tieba.tbadkCore.b.i pbData = bqVar4.getPbData();
                    bzVar6 = this.bAT.bAx;
                    bzVar6.e(pbData);
                }
                com.baidu.tieba.tbadkCore.al.a(Ft.getThreadId(), (com.baidu.tieba.tbadkCore.am) this.bAT.getPageContext().getOrignalPage());
            }
        } else if (jVar == null || writeData == null || jVar.getVcode_pic_url() == null) {
            this.bAT.a(antiData, str);
        } else if (AntiHelper.e(antiData)) {
            this.bAT.a(antiData, str);
        } else {
            writeData.setVcodeMD5(jVar.getVcode_md5());
            writeData.setVcodeUrl(jVar.getVcode_pic_url());
            if (jVar.rQ().equals("4")) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(this.bAT.getPageContext().getPageActivity(), 12006, writeData, false)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(this.bAT.getPageContext().getPageActivity(), writeData, 12006)));
            }
        }
    }
}
