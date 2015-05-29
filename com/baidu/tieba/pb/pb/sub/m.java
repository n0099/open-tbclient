package com.baidu.tieba.pb.pb.sub;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements com.baidu.tieba.tbadkCore.writeModel.e {
    final /* synthetic */ NewSubPbActivity bPw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(NewSubPbActivity newSubPbActivity) {
        this.bPw = newSubPbActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.e
    public void a(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.l lVar, WriteData writeData, AntiData antiData) {
        s sVar;
        s sVar2;
        s sVar3;
        com.baidu.tieba.tbadkCore.writeModel.a aVar;
        com.baidu.tieba.tbadkCore.writeModel.a aVar2;
        com.baidu.tieba.tbadkCore.writeModel.a aVar3;
        ak akVar;
        s sVar4;
        s sVar5;
        sVar = this.bPw.bPq;
        sVar.adm();
        if (z) {
            sVar5 = this.bPw.bPq;
            sVar5.clearContent();
            this.bPw.acY();
        }
        String str = "";
        if (postWriteCallBackData != null) {
            str = postWriteCallBackData.getErrorString();
        }
        if (z) {
            sVar2 = this.bPw.bPq;
            sVar2.acw();
            sVar3 = this.bPw.bPq;
            if (sVar3.Ki() != null) {
                sVar4 = this.bPw.bPq;
                sVar4.Ki().setVisibility(8);
            }
            aVar = this.bPw.aJT;
            WriteData JS = aVar.JS();
            aVar2 = this.bPw.aJT;
            aVar2.c((WriteData) null);
            aVar3 = this.bPw.aJT;
            aVar3.fj(false);
            if (JS != null && JS != null && JS.getType() == 2) {
                akVar = this.bPw.bPn;
                akVar.adF();
            }
        } else if (lVar == null || writeData == null || lVar.getVcode_pic_url() == null) {
            this.bPw.a(antiData, str);
        } else if (AntiHelper.e(antiData)) {
            this.bPw.a(antiData, str);
        } else {
            writeData.setVcodeMD5(lVar.getVcode_md5());
            writeData.setVcodeUrl(lVar.getVcode_pic_url());
            if (lVar.vv().equals("4")) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(this.bPw.getPageContext().getPageActivity(), 12006, writeData, false)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(this.bPw.getPageContext().getPageActivity(), writeData, 12006)));
            }
        }
    }
}
