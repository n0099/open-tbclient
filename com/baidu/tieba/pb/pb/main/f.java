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
    final /* synthetic */ PbActivity bKU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(PbActivity pbActivity) {
        this.bKU = pbActivity;
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
        this.bKU.stopVoice();
        chVar = this.bKU.bKA;
        chVar.bT(z);
        chVar2 = this.bKU.bKA;
        writeImagesInfo = this.bKU.writeImagesInfo;
        chVar2.a(writeImagesInfo, true);
        String str = "";
        if (postWriteCallBackData != null) {
            str = postWriteCallBackData.getErrorString();
        }
        if (z) {
            chVar3 = this.bKU.bKA;
            chVar3.aca();
            chVar4 = this.bKU.bKA;
            chVar4.acx();
            chVar5 = this.bKU.bKA;
            chVar5.abU();
            aVar = this.bKU.aJU;
            WriteData JT = aVar.JT();
            aVar2 = this.bKU.aJU;
            aVar2.c((WriteData) null);
            aVar3 = this.bKU.aJU;
            aVar3.fj(false);
            boVar = this.bKU.bKw;
            boVar.abD();
            this.bKU.a(antiData, postWriteCallBackData);
            boVar2 = this.bKU.bKw;
            if (!boVar2.abt()) {
                boVar8 = this.bKU.bKw;
                com.baidu.tieba.tbadkCore.ao.b(boVar8.abp(), (WriteData) null);
                writeImagesInfo2 = this.bKU.baobaoImagesInfo;
                writeImagesInfo2.clear();
                writeData2 = this.bKU.bKs;
                writeData2.setIsBaobao(false);
            }
            if (JT != null) {
                String floor = JT.getFloor();
                if (JT == null || JT.getType() != 2) {
                    boVar3 = this.bKU.bKw;
                    if (boVar3.getHostMode()) {
                        boVar5 = this.bKU.bKw;
                        com.baidu.tieba.pb.a.b pbData = boVar5.getPbData();
                        if (pbData != null && pbData.aat() != null && pbData.aat().getAuthor() != null && (userId = pbData.aat().getAuthor().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                            boVar6 = this.bKU.bKw;
                            if (boVar6.abw()) {
                                chVar7 = this.bKU.bKA;
                                chVar7.acg();
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    boVar4 = this.bKU.bKw;
                    if (boVar4.abw()) {
                        chVar6 = this.bKU.bKA;
                        chVar6.acg();
                        return;
                    }
                    return;
                }
                if (floor != null) {
                    boVar7 = this.bKU.bKw;
                    com.baidu.tieba.pb.a.b pbData2 = boVar7.getPbData();
                    chVar8 = this.bKU.bKA;
                    chVar8.e(pbData2);
                }
                com.baidu.tieba.tbadkCore.ao.a(JT.getThreadId(), (com.baidu.tieba.tbadkCore.ap) this.bKU.getPageContext().getOrignalPage());
            }
        } else if (lVar == null || writeData == null || lVar.getVcode_pic_url() == null) {
            this.bKU.a(antiData, str);
        } else if (AntiHelper.e(antiData)) {
            this.bKU.a(antiData, str);
        } else {
            writeData.setVcodeMD5(lVar.getVcode_md5());
            writeData.setVcodeUrl(lVar.getVcode_pic_url());
            if (lVar.vv().equals("4")) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(this.bKU.getPageContext().getPageActivity(), 12006, writeData, false)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(this.bKU.getPageContext().getPageActivity(), writeData, 12006)));
            }
        }
    }
}
