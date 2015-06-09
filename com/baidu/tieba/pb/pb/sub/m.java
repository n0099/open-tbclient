package com.baidu.tieba.pb.pb.sub;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements com.baidu.tieba.tbadkCore.writeModel.e {
    final /* synthetic */ NewSubPbActivity bPx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(NewSubPbActivity newSubPbActivity) {
        this.bPx = newSubPbActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.e
    public void a(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.l lVar, WriteData writeData, AntiData antiData) {
        s sVar;
        s sVar2;
        s sVar3;
        com.baidu.tieba.tbadkCore.writeModel.a aVar;
        com.baidu.tieba.tbadkCore.writeModel.a aVar2;
        com.baidu.tieba.tbadkCore.writeModel.a aVar3;
        ak akVar;
        s sVar4;
        s sVar5;
        sVar = this.bPx.bPr;
        sVar.adn();
        if (z) {
            sVar5 = this.bPx.bPr;
            sVar5.clearContent();
            this.bPx.acZ();
        }
        String str = "";
        if (postWriteCallBackData != null) {
            str = postWriteCallBackData.getErrorString();
        }
        if (z) {
            sVar2 = this.bPx.bPr;
            sVar2.acx();
            sVar3 = this.bPx.bPr;
            if (sVar3.Kj() != null) {
                sVar4 = this.bPx.bPr;
                sVar4.Kj().setVisibility(8);
            }
            aVar = this.bPx.aJU;
            WriteData JT = aVar.JT();
            aVar2 = this.bPx.aJU;
            aVar2.c((WriteData) null);
            aVar3 = this.bPx.aJU;
            aVar3.fj(false);
            if (JT != null && JT != null && JT.getType() == 2) {
                akVar = this.bPx.bPo;
                akVar.adG();
            }
        } else if (lVar == null || writeData == null || lVar.getVcode_pic_url() == null) {
            this.bPx.a(antiData, str);
        } else if (AntiHelper.e(antiData)) {
            this.bPx.a(antiData, str);
        } else {
            writeData.setVcodeMD5(lVar.getVcode_md5());
            writeData.setVcodeUrl(lVar.getVcode_pic_url());
            if (lVar.vv().equals("4")) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(this.bPx.getPageContext().getPageActivity(), 12006, writeData, false)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(this.bPx.getPageContext().getPageActivity(), writeData, 12006)));
            }
        }
    }
}
