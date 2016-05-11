package com.baidu.tieba.write.shareSDK;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.writeModel.a;
/* loaded from: classes.dex */
class j implements a.c {
    final /* synthetic */ WriteShareActivity fad;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(WriteShareActivity writeShareActivity) {
        this.fad = writeShareActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.a.c
    public void a(boolean z, String str, com.baidu.tbadk.coreExtra.data.o oVar, WriteData writeData, AntiData antiData) {
        com.baidu.tieba.write.view.e eVar;
        com.baidu.tieba.write.view.e eVar2;
        com.baidu.tieba.write.view.e eVar3;
        com.baidu.tieba.write.view.e eVar4;
        this.fad.closeLoadingDialog();
        if (!z) {
            if (oVar != null && writeData != null && oVar.getVcode_pic_url() != null) {
                writeData.setVcodeMD5(oVar.getVcode_md5());
                writeData.setVcodeUrl(oVar.getVcode_pic_url());
                this.fad.eZP = true;
                if (oVar.wF().equals("4")) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(this.fad.getPageContext().getPageActivity(), 12006, writeData, false)));
                    return;
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(this.fad.getPageContext().getPageActivity(), writeData, 12006)));
                    return;
                }
            }
            this.fad.bca();
            eVar = this.fad.eZS;
            if (eVar != null) {
                this.fad.eZQ = false;
                eVar2 = this.fad.eZS;
                eVar2.bcF();
                return;
            }
            return;
        }
        this.fad.bbZ();
        eVar3 = this.fad.eZR;
        if (eVar3 != null) {
            this.fad.eZQ = true;
            this.fad.setResult(-1);
            eVar4 = this.fad.eZR;
            eVar4.bcF();
        }
    }
}
