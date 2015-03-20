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
    final /* synthetic */ PbActivity bIv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(PbActivity pbActivity) {
        this.bIv = pbActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.e
    public void a(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.k kVar, WriteData writeData, AntiData antiData) {
        ci ciVar;
        ci ciVar2;
        WriteImagesInfo writeImagesInfo;
        ci ciVar3;
        ci ciVar4;
        com.baidu.tieba.tbadkCore.writeModel.a aVar;
        com.baidu.tieba.tbadkCore.writeModel.a aVar2;
        com.baidu.tieba.tbadkCore.writeModel.a aVar3;
        bq bqVar;
        bq bqVar2;
        bq bqVar3;
        bq bqVar4;
        ci ciVar5;
        bq bqVar5;
        String userId;
        bq bqVar6;
        ci ciVar6;
        com.baidu.tieba.pb.pb.sub.e eVar;
        bq bqVar7;
        ci ciVar7;
        bq bqVar8;
        WriteImagesInfo writeImagesInfo2;
        WriteData writeData2;
        this.bIv.stopVoice();
        ciVar = this.bIv.bHY;
        ciVar.bK(z);
        ciVar2 = this.bIv.bHY;
        writeImagesInfo = this.bIv.writeImagesInfo;
        ciVar2.a(writeImagesInfo, true);
        String str = "";
        if (postWriteCallBackData != null) {
            str = postWriteCallBackData.getErrorString();
        }
        if (z) {
            ciVar3 = this.bIv.bHY;
            ciVar3.abo();
            ciVar4 = this.bIv.bHY;
            ciVar4.aas();
            aVar = this.bIv.aHC;
            WriteData IM = aVar.IM();
            aVar2 = this.bIv.aHC;
            aVar2.c((WriteData) null);
            aVar3 = this.bIv.aHC;
            aVar3.eS(false);
            bqVar = this.bIv.bHT;
            bqVar.aab();
            this.bIv.a(antiData, postWriteCallBackData);
            bqVar2 = this.bIv.bHT;
            if (!bqVar2.ZR()) {
                bqVar8 = this.bIv.bHT;
                com.baidu.tieba.tbadkCore.ao.b(bqVar8.ZN(), (WriteData) null);
                writeImagesInfo2 = this.bIv.baobaoImagesInfo;
                writeImagesInfo2.clear();
                writeData2 = this.bIv.bHP;
                writeData2.setIsBaobao(false);
            }
            if (IM != null) {
                String floor = IM.getFloor();
                if (IM == null || IM.getType() != 2) {
                    bqVar3 = this.bIv.bHT;
                    if (bqVar3.getHostMode()) {
                        bqVar5 = this.bIv.bHT;
                        com.baidu.tieba.pb.a.b pbData = bqVar5.getPbData();
                        if (pbData != null && pbData.YP() != null && pbData.YP().getAuthor() != null && (userId = pbData.YP().getAuthor().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                            bqVar6 = this.bIv.bHT;
                            if (bqVar6.ZU()) {
                                ciVar6 = this.bIv.bHY;
                                ciVar6.aaK();
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    bqVar4 = this.bIv.bHT;
                    if (bqVar4.ZU()) {
                        ciVar5 = this.bIv.bHY;
                        ciVar5.aaK();
                        return;
                    }
                    return;
                }
                eVar = this.bIv.bHW;
                eVar.abT();
                if (floor != null) {
                    bqVar7 = this.bIv.bHT;
                    com.baidu.tieba.pb.a.b pbData2 = bqVar7.getPbData();
                    ciVar7 = this.bIv.bHY;
                    ciVar7.e(pbData2);
                }
                com.baidu.tieba.tbadkCore.ao.a(IM.getThreadId(), (com.baidu.tieba.tbadkCore.ap) this.bIv.getPageContext().getOrignalPage());
            }
        } else if (kVar == null || writeData == null || kVar.getVcode_pic_url() == null) {
            this.bIv.a(antiData, str);
        } else if (AntiHelper.e(antiData)) {
            this.bIv.a(antiData, str);
        } else {
            writeData.setVcodeMD5(kVar.getVcode_md5());
            writeData.setVcodeUrl(kVar.getVcode_pic_url());
            if (kVar.uI().equals("4")) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(this.bIv.getPageContext().getPageActivity(), 12006, writeData, false)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(this.bIv.getPageContext().getPageActivity(), writeData, 12006)));
            }
        }
    }
}
