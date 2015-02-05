package com.baidu.tieba.shareSDK;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.message.ShareSDKResultMessage;
/* loaded from: classes.dex */
class j implements com.baidu.tieba.tbadkCore.f.b {
    final /* synthetic */ WriteShareActivity bPE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(WriteShareActivity writeShareActivity) {
        this.bPE = writeShareActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.f.b
    public void a(boolean z, String str, com.baidu.tbadk.coreExtra.data.j jVar, WriteData writeData, AntiData antiData) {
        com.baidu.tbadk.core.dialog.e eVar;
        com.baidu.tbadk.core.dialog.e eVar2;
        com.baidu.tbadk.core.dialog.e eVar3;
        com.baidu.tbadk.core.dialog.e eVar4;
        this.bPE.closeLoadingDialog();
        if (!z) {
            if (jVar != null && writeData != null && jVar.getVcode_pic_url() != null) {
                writeData.setVcodeMD5(jVar.getVcode_md5());
                writeData.setVcodeUrl(jVar.getVcode_pic_url());
                this.bPE.bPs = true;
                if (jVar.rK().equals("4")) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(this.bPE.getPageContext().getPageActivity(), 12006, writeData, false)));
                    return;
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(this.bPE.getPageContext().getPageActivity(), writeData, 12006)));
                    return;
                }
            }
            this.bPE.acW();
            eVar = this.bPE.bPv;
            if (eVar != null) {
                this.bPE.bPt = false;
                eVar2 = this.bPE.bPv;
                eVar2.nR();
                return;
            }
            return;
        }
        this.bPE.acV();
        eVar3 = this.bPE.bPu;
        if (eVar3 != null) {
            this.bPE.bPt = true;
            eVar4 = this.bPE.bPu;
            eVar4.nR();
            MessageManager.getInstance().dispatchResponsedMessage(new ShareSDKResultMessage(true));
        }
    }
}
