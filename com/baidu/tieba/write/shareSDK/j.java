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
    final /* synthetic */ WriteShareActivity fFg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(WriteShareActivity writeShareActivity) {
        this.fFg = writeShareActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.a.c
    public void a(boolean z, String str, com.baidu.tbadk.coreExtra.data.p pVar, WriteData writeData, AntiData antiData) {
        com.baidu.tieba.write.view.e eVar;
        com.baidu.tieba.write.view.e eVar2;
        com.baidu.tieba.write.view.e eVar3;
        com.baidu.tieba.write.view.e eVar4;
        this.fFg.closeLoadingDialog();
        if (!z) {
            if (pVar != null && writeData != null && pVar.getVcode_pic_url() != null) {
                writeData.setVcodeMD5(pVar.getVcode_md5());
                writeData.setVcodeUrl(pVar.getVcode_pic_url());
                writeData.setVcodeExtra(pVar.wK());
                this.fFg.fES = true;
                if (com.baidu.tbadk.k.a.gA(pVar.wJ())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(this.fFg.getPageContext().getPageActivity(), 12006, writeData, false, pVar.wJ())));
                    return;
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(this.fFg.getPageContext().getPageActivity(), writeData, 12006)));
                    return;
                }
            }
            this.fFg.bkC();
            eVar = this.fFg.fEV;
            if (eVar != null) {
                this.fFg.fET = false;
                eVar2 = this.fFg.fEV;
                eVar2.bli();
                return;
            }
            return;
        }
        this.fFg.bkB();
        eVar3 = this.fFg.fEU;
        if (eVar3 != null) {
            this.fFg.fET = true;
            this.fFg.setResult(-1);
            eVar4 = this.fFg.fEU;
            eVar4.bli();
        }
    }
}
