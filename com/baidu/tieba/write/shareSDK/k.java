package com.baidu.tieba.write.shareSDK;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* loaded from: classes.dex */
class k implements com.baidu.tieba.tbadkCore.writeModel.d {
    final /* synthetic */ WriteShareActivity cvN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(WriteShareActivity writeShareActivity) {
        this.cvN = writeShareActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.d
    public void a(boolean z, String str, com.baidu.tbadk.coreExtra.data.k kVar, WriteData writeData, AntiData antiData) {
        com.baidu.tieba.write.view.f fVar;
        com.baidu.tieba.write.view.f fVar2;
        com.baidu.tieba.write.view.f fVar3;
        com.baidu.tieba.write.view.f fVar4;
        this.cvN.closeLoadingDialog();
        if (!z) {
            if (kVar != null && writeData != null && kVar.getVcode_pic_url() != null) {
                writeData.setVcodeMD5(kVar.getVcode_md5());
                writeData.setVcodeUrl(kVar.getVcode_pic_url());
                this.cvN.cvA = true;
                if (kVar.uI().equals("4")) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(this.cvN.getPageContext().getPageActivity(), 12006, writeData, false)));
                    return;
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(this.cvN.getPageContext().getPageActivity(), writeData, 12006)));
                    return;
                }
            }
            this.cvN.aqr();
            fVar = this.cvN.cvD;
            if (fVar != null) {
                this.cvN.cvB = false;
                fVar2 = this.cvN.cvD;
                fVar2.aqK();
                return;
            }
            return;
        }
        this.cvN.aqq();
        fVar3 = this.cvN.cvC;
        if (fVar3 != null) {
            this.cvN.cvB = true;
            this.cvN.setResult(-1);
            fVar4 = this.cvN.cvC;
            fVar4.aqK();
        }
    }
}
