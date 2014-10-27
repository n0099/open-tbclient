package com.baidu.tieba.shareSDK;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.model.as;
/* loaded from: classes.dex */
class h implements as {
    final /* synthetic */ WriteShareActivity bJq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(WriteShareActivity writeShareActivity) {
        this.bJq = writeShareActivity;
    }

    @Override // com.baidu.tieba.model.as
    public void a(boolean z, String str, com.baidu.tbadk.coreExtra.data.f fVar, WriteData writeData, AntiData antiData) {
        com.baidu.tbadk.core.dialog.e eVar;
        com.baidu.tbadk.core.dialog.e eVar2;
        com.baidu.tbadk.core.dialog.e eVar3;
        com.baidu.tbadk.core.dialog.e eVar4;
        this.bJq.closeLoadingDialog();
        if (!z) {
            if (fVar != null && writeData != null && fVar.getVcode_pic_url() != null) {
                writeData.setVcodeMD5(fVar.getVcode_md5());
                writeData.setVcodeUrl(fVar.getVcode_pic_url());
                this.bJq.bJg = true;
                if (fVar.oA().equals("4")) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(this.bJq, 12006, writeData, false)));
                    return;
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(this.bJq, writeData, 12006)));
                    return;
                }
            }
            this.bJq.abZ();
            eVar = this.bJq.bJi;
            if (eVar != null) {
                eVar2 = this.bJq.bJi;
                eVar2.kY();
                return;
            }
            return;
        }
        this.bJq.abY();
        eVar3 = this.bJq.bJh;
        if (eVar3 != null) {
            eVar4 = this.bJq.bJh;
            eVar4.kY();
        }
    }
}
