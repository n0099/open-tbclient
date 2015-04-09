package com.baidu.tieba.write.shareSDK;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* loaded from: classes.dex */
class k implements com.baidu.tieba.tbadkCore.writeModel.d {
    final /* synthetic */ WriteShareActivity cwd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(WriteShareActivity writeShareActivity) {
        this.cwd = writeShareActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.d
    public void a(boolean z, String str, com.baidu.tbadk.coreExtra.data.l lVar, WriteData writeData, AntiData antiData) {
        com.baidu.tieba.write.view.f fVar;
        com.baidu.tieba.write.view.f fVar2;
        com.baidu.tieba.write.view.f fVar3;
        com.baidu.tieba.write.view.f fVar4;
        this.cwd.closeLoadingDialog();
        if (!z) {
            if (lVar != null && writeData != null && lVar.getVcode_pic_url() != null) {
                writeData.setVcodeMD5(lVar.getVcode_md5());
                writeData.setVcodeUrl(lVar.getVcode_pic_url());
                this.cwd.cvQ = true;
                if (lVar.uL().equals("4")) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(this.cwd.getPageContext().getPageActivity(), 12006, writeData, false)));
                    return;
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(this.cwd.getPageContext().getPageActivity(), writeData, 12006)));
                    return;
                }
            }
            this.cwd.aqG();
            fVar = this.cwd.cvT;
            if (fVar != null) {
                this.cwd.cvR = false;
                fVar2 = this.cwd.cvT;
                fVar2.aqZ();
                return;
            }
            return;
        }
        this.cwd.aqF();
        fVar3 = this.cwd.cvS;
        if (fVar3 != null) {
            this.cwd.cvR = true;
            this.cwd.setResult(-1);
            fVar4 = this.cwd.cvS;
            fVar4.aqZ();
        }
    }
}
