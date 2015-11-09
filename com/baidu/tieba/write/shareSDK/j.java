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
    final /* synthetic */ WriteShareActivity dog;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(WriteShareActivity writeShareActivity) {
        this.dog = writeShareActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.a.c
    public void a(boolean z, String str, com.baidu.tbadk.coreExtra.data.l lVar, WriteData writeData, AntiData antiData) {
        com.baidu.tieba.write.view.e eVar;
        com.baidu.tieba.write.view.e eVar2;
        com.baidu.tieba.write.view.e eVar3;
        com.baidu.tieba.write.view.e eVar4;
        this.dog.closeLoadingDialog();
        if (!z) {
            if (lVar != null && writeData != null && lVar.getVcode_pic_url() != null) {
                writeData.setVcodeMD5(lVar.getVcode_md5());
                writeData.setVcodeUrl(lVar.getVcode_pic_url());
                this.dog.dnS = true;
                if (lVar.wu().equals("4")) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(this.dog.getPageContext().getPageActivity(), 12006, writeData, false)));
                    return;
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(this.dog.getPageContext().getPageActivity(), writeData, 12006)));
                    return;
                }
            }
            this.dog.aCM();
            eVar = this.dog.dnV;
            if (eVar != null) {
                this.dog.dnT = false;
                eVar2 = this.dog.dnV;
                eVar2.aDf();
                return;
            }
            return;
        }
        this.dog.aCL();
        eVar3 = this.dog.dnU;
        if (eVar3 != null) {
            this.dog.dnT = true;
            this.dog.setResult(-1);
            eVar4 = this.dog.dnU;
            eVar4.aDf();
        }
    }
}
