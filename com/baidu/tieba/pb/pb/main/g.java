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
class g implements com.baidu.tieba.tbadkCore.writeModel.e {
    final /* synthetic */ PbActivity bIJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(PbActivity pbActivity) {
        this.bIJ = pbActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.e
    public void a(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.l lVar, WriteData writeData, AntiData antiData) {
        cj cjVar;
        cj cjVar2;
        WriteImagesInfo writeImagesInfo;
        cj cjVar3;
        cj cjVar4;
        com.baidu.tieba.tbadkCore.writeModel.a aVar;
        com.baidu.tieba.tbadkCore.writeModel.a aVar2;
        com.baidu.tieba.tbadkCore.writeModel.a aVar3;
        br brVar;
        br brVar2;
        br brVar3;
        br brVar4;
        cj cjVar5;
        br brVar5;
        String userId;
        br brVar6;
        cj cjVar6;
        com.baidu.tieba.pb.pb.sub.e eVar;
        br brVar7;
        cj cjVar7;
        br brVar8;
        WriteImagesInfo writeImagesInfo2;
        WriteData writeData2;
        this.bIJ.stopVoice();
        cjVar = this.bIJ.bIl;
        cjVar.bK(z);
        cjVar2 = this.bIJ.bIl;
        writeImagesInfo = this.bIJ.writeImagesInfo;
        cjVar2.a(writeImagesInfo, true);
        String str = "";
        if (postWriteCallBackData != null) {
            str = postWriteCallBackData.getErrorString();
        }
        if (z) {
            cjVar3 = this.bIJ.bIl;
            cjVar3.abC();
            cjVar4 = this.bIJ.bIl;
            cjVar4.aaF();
            aVar = this.bIJ.aHK;
            WriteData IS = aVar.IS();
            aVar2 = this.bIJ.aHK;
            aVar2.c((WriteData) null);
            aVar3 = this.bIJ.aHK;
            aVar3.eQ(false);
            brVar = this.bIJ.bIg;
            brVar.aao();
            this.bIJ.a(antiData, postWriteCallBackData);
            brVar2 = this.bIJ.bIg;
            if (!brVar2.aae()) {
                brVar8 = this.bIJ.bIg;
                com.baidu.tieba.tbadkCore.ao.b(brVar8.aaa(), (WriteData) null);
                writeImagesInfo2 = this.bIJ.baobaoImagesInfo;
                writeImagesInfo2.clear();
                writeData2 = this.bIJ.bIc;
                writeData2.setIsBaobao(false);
            }
            if (IS != null) {
                String floor = IS.getFloor();
                if (IS == null || IS.getType() != 2) {
                    brVar3 = this.bIJ.bIg;
                    if (brVar3.getHostMode()) {
                        brVar5 = this.bIJ.bIg;
                        com.baidu.tieba.pb.a.b pbData = brVar5.getPbData();
                        if (pbData != null && pbData.Zb() != null && pbData.Zb().getAuthor() != null && (userId = pbData.Zb().getAuthor().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                            brVar6 = this.bIJ.bIg;
                            if (brVar6.aah()) {
                                cjVar6 = this.bIJ.bIl;
                                cjVar6.aaX();
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    brVar4 = this.bIJ.bIg;
                    if (brVar4.aah()) {
                        cjVar5 = this.bIJ.bIl;
                        cjVar5.aaX();
                        return;
                    }
                    return;
                }
                eVar = this.bIJ.bIj;
                eVar.aci();
                if (floor != null) {
                    brVar7 = this.bIJ.bIg;
                    com.baidu.tieba.pb.a.b pbData2 = brVar7.getPbData();
                    cjVar7 = this.bIJ.bIl;
                    cjVar7.e(pbData2);
                }
                com.baidu.tieba.tbadkCore.ao.a(IS.getThreadId(), (com.baidu.tieba.tbadkCore.ap) this.bIJ.getPageContext().getOrignalPage());
            }
        } else if (lVar == null || writeData == null || lVar.getVcode_pic_url() == null) {
            this.bIJ.a(antiData, str);
        } else if (AntiHelper.e(antiData)) {
            this.bIJ.a(antiData, str);
        } else {
            writeData.setVcodeMD5(lVar.getVcode_md5());
            writeData.setVcodeUrl(lVar.getVcode_pic_url());
            if (lVar.uL().equals("4")) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(this.bIJ.getPageContext().getPageActivity(), 12006, writeData, false)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(this.bIJ.getPageContext().getPageActivity(), writeData, 12006)));
            }
        }
    }
}
