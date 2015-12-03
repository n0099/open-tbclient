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
    final /* synthetic */ WriteShareActivity dNm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(WriteShareActivity writeShareActivity) {
        this.dNm = writeShareActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.a.c
    public void a(boolean z, String str, com.baidu.tbadk.coreExtra.data.n nVar, WriteData writeData, AntiData antiData) {
        com.baidu.tieba.write.view.e eVar;
        com.baidu.tieba.write.view.e eVar2;
        com.baidu.tieba.write.view.e eVar3;
        com.baidu.tieba.write.view.e eVar4;
        this.dNm.closeLoadingDialog();
        if (!z) {
            if (nVar != null && writeData != null && nVar.getVcode_pic_url() != null) {
                writeData.setVcodeMD5(nVar.getVcode_md5());
                writeData.setVcodeUrl(nVar.getVcode_pic_url());
                this.dNm.dMY = true;
                if (nVar.xp().equals("4")) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(this.dNm.getPageContext().getPageActivity(), 12006, writeData, false)));
                    return;
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(this.dNm.getPageContext().getPageActivity(), writeData, 12006)));
                    return;
                }
            }
            this.dNm.aIj();
            eVar = this.dNm.dNb;
            if (eVar != null) {
                this.dNm.dMZ = false;
                eVar2 = this.dNm.dNb;
                eVar2.aIC();
                return;
            }
            return;
        }
        this.dNm.aIi();
        eVar3 = this.dNm.dNa;
        if (eVar3 != null) {
            this.dNm.dMZ = true;
            this.dNm.setResult(-1);
            eVar4 = this.dNm.dNa;
            eVar4.aIC();
        }
    }
}
