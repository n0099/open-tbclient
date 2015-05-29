package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes.dex */
class f implements com.baidu.tieba.tbadkCore.writeModel.e {
    final /* synthetic */ PbActivity bKT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(PbActivity pbActivity) {
        this.bKT = pbActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.e
    public void a(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.l lVar, WriteData writeData, AntiData antiData) {
        ch chVar;
        ch chVar2;
        WriteImagesInfo writeImagesInfo;
        ch chVar3;
        ch chVar4;
        ch chVar5;
        com.baidu.tieba.tbadkCore.writeModel.a aVar;
        com.baidu.tieba.tbadkCore.writeModel.a aVar2;
        com.baidu.tieba.tbadkCore.writeModel.a aVar3;
        bo boVar;
        bo boVar2;
        bo boVar3;
        bo boVar4;
        ch chVar6;
        bo boVar5;
        String userId;
        bo boVar6;
        ch chVar7;
        bo boVar7;
        ch chVar8;
        bo boVar8;
        WriteImagesInfo writeImagesInfo2;
        WriteData writeData2;
        this.bKT.stopVoice();
        chVar = this.bKT.bKz;
        chVar.bT(z);
        chVar2 = this.bKT.bKz;
        writeImagesInfo = this.bKT.writeImagesInfo;
        chVar2.a(writeImagesInfo, true);
        String str = "";
        if (postWriteCallBackData != null) {
            str = postWriteCallBackData.getErrorString();
        }
        if (z) {
            chVar3 = this.bKT.bKz;
            chVar3.abZ();
            chVar4 = this.bKT.bKz;
            chVar4.acw();
            chVar5 = this.bKT.bKz;
            chVar5.abT();
            aVar = this.bKT.aJT;
            WriteData JS = aVar.JS();
            aVar2 = this.bKT.aJT;
            aVar2.c((WriteData) null);
            aVar3 = this.bKT.aJT;
            aVar3.fj(false);
            boVar = this.bKT.bKv;
            boVar.abC();
            this.bKT.a(antiData, postWriteCallBackData);
            boVar2 = this.bKT.bKv;
            if (!boVar2.abs()) {
                boVar8 = this.bKT.bKv;
                com.baidu.tieba.tbadkCore.ao.b(boVar8.abo(), (WriteData) null);
                writeImagesInfo2 = this.bKT.baobaoImagesInfo;
                writeImagesInfo2.clear();
                writeData2 = this.bKT.bKr;
                writeData2.setIsBaobao(false);
            }
            if (JS != null) {
                String floor = JS.getFloor();
                if (JS == null || JS.getType() != 2) {
                    boVar3 = this.bKT.bKv;
                    if (boVar3.getHostMode()) {
                        boVar5 = this.bKT.bKv;
                        com.baidu.tieba.pb.a.b pbData = boVar5.getPbData();
                        if (pbData != null && pbData.aas() != null && pbData.aas().getAuthor() != null && (userId = pbData.aas().getAuthor().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                            boVar6 = this.bKT.bKv;
                            if (boVar6.abv()) {
                                chVar7 = this.bKT.bKz;
                                chVar7.acf();
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    boVar4 = this.bKT.bKv;
                    if (boVar4.abv()) {
                        chVar6 = this.bKT.bKz;
                        chVar6.acf();
                        return;
                    }
                    return;
                }
                if (floor != null) {
                    boVar7 = this.bKT.bKv;
                    com.baidu.tieba.pb.a.b pbData2 = boVar7.getPbData();
                    chVar8 = this.bKT.bKz;
                    chVar8.e(pbData2);
                }
                com.baidu.tieba.tbadkCore.ao.a(JS.getThreadId(), (com.baidu.tieba.tbadkCore.ap) this.bKT.getPageContext().getOrignalPage());
            }
        } else if (lVar == null || writeData == null || lVar.getVcode_pic_url() == null) {
            this.bKT.a(antiData, str);
        } else if (AntiHelper.e(antiData)) {
            this.bKT.a(antiData, str);
        } else {
            writeData.setVcodeMD5(lVar.getVcode_md5());
            writeData.setVcodeUrl(lVar.getVcode_pic_url());
            if (lVar.vv().equals("4")) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(this.bKT.getPageContext().getPageActivity(), 12006, writeData, false)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(this.bKT.getPageContext().getPageActivity(), writeData, 12006)));
            }
        }
    }
}
