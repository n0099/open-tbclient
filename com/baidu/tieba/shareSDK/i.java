package com.baidu.tieba.shareSDK;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.model.as;
/* loaded from: classes.dex */
class i implements as {
    final /* synthetic */ WriteShareActivity bJF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(WriteShareActivity writeShareActivity) {
        this.bJF = writeShareActivity;
    }

    @Override // com.baidu.tieba.model.as
    public void a(boolean z, String str, com.baidu.tbadk.coreExtra.data.g gVar, WriteData writeData, AntiData antiData) {
        com.baidu.tbadk.core.dialog.e eVar;
        com.baidu.tbadk.core.dialog.e eVar2;
        com.baidu.tbadk.core.dialog.e eVar3;
        com.baidu.tbadk.core.dialog.e eVar4;
        this.bJF.closeLoadingDialog();
        if (!z) {
            if (gVar != null && writeData != null && gVar.getVcode_pic_url() != null) {
                writeData.setVcodeMD5(gVar.getVcode_md5());
                writeData.setVcodeUrl(gVar.getVcode_pic_url());
                this.bJF.bJu = true;
                if (gVar.oC().equals("4")) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(this.bJF, 12006, writeData, false)));
                    return;
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(this.bJF, writeData, 12006)));
                    return;
                }
            }
            this.bJF.acc();
            eVar = this.bJF.bJw;
            if (eVar != null) {
                eVar2 = this.bJF.bJw;
                eVar2.kY();
                return;
            }
            return;
        }
        this.bJF.acb();
        eVar3 = this.bJF.bJv;
        if (eVar3 != null) {
            eVar4 = this.bJF.bJv;
            eVar4.kY();
        }
    }
}
