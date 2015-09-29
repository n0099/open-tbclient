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
    final /* synthetic */ WriteShareActivity dlY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(WriteShareActivity writeShareActivity) {
        this.dlY = writeShareActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.a.c
    public void a(boolean z, String str, com.baidu.tbadk.coreExtra.data.l lVar, WriteData writeData, AntiData antiData) {
        com.baidu.tieba.write.view.e eVar;
        com.baidu.tieba.write.view.e eVar2;
        com.baidu.tieba.write.view.e eVar3;
        com.baidu.tieba.write.view.e eVar4;
        this.dlY.closeLoadingDialog();
        if (!z) {
            if (lVar != null && writeData != null && lVar.getVcode_pic_url() != null) {
                writeData.setVcodeMD5(lVar.getVcode_md5());
                writeData.setVcodeUrl(lVar.getVcode_pic_url());
                this.dlY.dlK = true;
                if (lVar.ws().equals("4")) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(this.dlY.getPageContext().getPageActivity(), 12006, writeData, false)));
                    return;
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(this.dlY.getPageContext().getPageActivity(), writeData, 12006)));
                    return;
                }
            }
            this.dlY.aBQ();
            eVar = this.dlY.dlN;
            if (eVar != null) {
                this.dlY.dlL = false;
                eVar2 = this.dlY.dlN;
                eVar2.aCj();
                return;
            }
            return;
        }
        this.dlY.aBP();
        eVar3 = this.dlY.dlM;
        if (eVar3 != null) {
            this.dlY.dlL = true;
            this.dlY.setResult(-1);
            eVar4 = this.dlY.dlM;
            eVar4.aCj();
        }
    }
}
