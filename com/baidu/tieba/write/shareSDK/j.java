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
    final /* synthetic */ WriteShareActivity epq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(WriteShareActivity writeShareActivity) {
        this.epq = writeShareActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.a.c
    public void a(boolean z, String str, com.baidu.tbadk.coreExtra.data.n nVar, WriteData writeData, AntiData antiData) {
        com.baidu.tieba.write.view.e eVar;
        com.baidu.tieba.write.view.e eVar2;
        com.baidu.tieba.write.view.e eVar3;
        com.baidu.tieba.write.view.e eVar4;
        this.epq.closeLoadingDialog();
        if (!z) {
            if (nVar != null && writeData != null && nVar.getVcode_pic_url() != null) {
                writeData.setVcodeMD5(nVar.getVcode_md5());
                writeData.setVcodeUrl(nVar.getVcode_pic_url());
                this.epq.epc = true;
                if (nVar.yl().equals("4")) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(this.epq.getPageContext().getPageActivity(), 12006, writeData, false)));
                    return;
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(this.epq.getPageContext().getPageActivity(), writeData, 12006)));
                    return;
                }
            }
            this.epq.aTo();
            eVar = this.epq.epf;
            if (eVar != null) {
                this.epq.epd = false;
                eVar2 = this.epq.epf;
                eVar2.aTS();
                return;
            }
            return;
        }
        this.epq.aTn();
        eVar3 = this.epq.epe;
        if (eVar3 != null) {
            this.epq.epd = true;
            this.epq.setResult(-1);
            eVar4 = this.epq.epe;
            eVar4.aTS();
        }
    }
}
