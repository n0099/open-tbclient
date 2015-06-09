package com.baidu.tieba.write.shareSDK;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* loaded from: classes.dex */
class k implements com.baidu.tieba.tbadkCore.writeModel.d {
    final /* synthetic */ WriteShareActivity cAu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(WriteShareActivity writeShareActivity) {
        this.cAu = writeShareActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.d
    public void a(boolean z, String str, com.baidu.tbadk.coreExtra.data.l lVar, WriteData writeData, AntiData antiData) {
        com.baidu.tieba.write.view.f fVar;
        com.baidu.tieba.write.view.f fVar2;
        com.baidu.tieba.write.view.f fVar3;
        com.baidu.tieba.write.view.f fVar4;
        this.cAu.closeLoadingDialog();
        if (!z) {
            if (lVar != null && writeData != null && lVar.getVcode_pic_url() != null) {
                writeData.setVcodeMD5(lVar.getVcode_md5());
                writeData.setVcodeUrl(lVar.getVcode_pic_url());
                this.cAu.cAh = true;
                if (lVar.vv().equals("4")) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(this.cAu.getPageContext().getPageActivity(), 12006, writeData, false)));
                    return;
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(this.cAu.getPageContext().getPageActivity(), writeData, 12006)));
                    return;
                }
            }
            this.cAu.asx();
            fVar = this.cAu.cAk;
            if (fVar != null) {
                this.cAu.cAi = false;
                fVar2 = this.cAu.cAk;
                fVar2.asQ();
                return;
            }
            return;
        }
        this.cAu.asw();
        fVar3 = this.cAu.cAj;
        if (fVar3 != null) {
            this.cAu.cAi = true;
            this.cAu.setResult(-1);
            fVar4 = this.cAu.cAj;
            fVar4.asQ();
        }
    }
}
