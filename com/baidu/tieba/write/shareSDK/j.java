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
    final /* synthetic */ WriteShareActivity fac;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(WriteShareActivity writeShareActivity) {
        this.fac = writeShareActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.a.c
    public void a(boolean z, String str, com.baidu.tbadk.coreExtra.data.o oVar, WriteData writeData, AntiData antiData) {
        com.baidu.tieba.write.view.e eVar;
        com.baidu.tieba.write.view.e eVar2;
        com.baidu.tieba.write.view.e eVar3;
        com.baidu.tieba.write.view.e eVar4;
        this.fac.closeLoadingDialog();
        if (!z) {
            if (oVar != null && writeData != null && oVar.getVcode_pic_url() != null) {
                writeData.setVcodeMD5(oVar.getVcode_md5());
                writeData.setVcodeUrl(oVar.getVcode_pic_url());
                this.fac.eZO = true;
                if (oVar.wG().equals("4")) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(this.fac.getPageContext().getPageActivity(), 12006, writeData, false)));
                    return;
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(this.fac.getPageContext().getPageActivity(), writeData, 12006)));
                    return;
                }
            }
            this.fac.bch();
            eVar = this.fac.eZR;
            if (eVar != null) {
                this.fac.eZP = false;
                eVar2 = this.fac.eZR;
                eVar2.bcM();
                return;
            }
            return;
        }
        this.fac.bcg();
        eVar3 = this.fac.eZQ;
        if (eVar3 != null) {
            this.fac.eZP = true;
            this.fac.setResult(-1);
            eVar4 = this.fac.eZQ;
            eVar4.bcM();
        }
    }
}
