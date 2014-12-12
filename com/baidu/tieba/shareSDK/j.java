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
    final /* synthetic */ WriteShareActivity bNV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(WriteShareActivity writeShareActivity) {
        this.bNV = writeShareActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.f.b
    public void a(boolean z, String str, com.baidu.tbadk.coreExtra.data.j jVar, WriteData writeData, AntiData antiData) {
        com.baidu.tbadk.core.dialog.e eVar;
        com.baidu.tbadk.core.dialog.e eVar2;
        com.baidu.tbadk.core.dialog.e eVar3;
        com.baidu.tbadk.core.dialog.e eVar4;
        this.bNV.closeLoadingDialog();
        if (!z) {
            if (jVar != null && writeData != null && jVar.getVcode_pic_url() != null) {
                writeData.setVcodeMD5(jVar.getVcode_md5());
                writeData.setVcodeUrl(jVar.getVcode_pic_url());
                this.bNV.bNJ = true;
                if (jVar.rD().equals("4")) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(this.bNV.getPageContext().getPageActivity(), 12006, writeData, false)));
                    return;
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(this.bNV.getPageContext().getPageActivity(), writeData, 12006)));
                    return;
                }
            }
            this.bNV.acx();
            eVar = this.bNV.bNM;
            if (eVar != null) {
                this.bNV.bNK = false;
                eVar2 = this.bNV.bNM;
                eVar2.nV();
                return;
            }
            return;
        }
        this.bNV.acw();
        eVar3 = this.bNV.bNL;
        if (eVar3 != null) {
            this.bNV.bNK = true;
            eVar4 = this.bNV.bNL;
            eVar4.nV();
            MessageManager.getInstance().dispatchResponsedMessage(new ShareSDKResultMessage(true));
        }
    }
}
