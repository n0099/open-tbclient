package com.baidu.tieba.write.write;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cp implements NewWriteModel.d {
    final /* synthetic */ ck gmI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cp(ck ckVar) {
        this.gmI = ckVar;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
    public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.q qVar, WriteData writeData, AntiData antiData) {
        cq cqVar;
        cq cqVar2;
        TbPageContext tbPageContext;
        TbPageContext tbPageContext2;
        TbPageContext tbPageContext3;
        TbPageContext tbPageContext4;
        TbPageContext tbPageContext5;
        TbPageContext tbPageContext6;
        cqVar = this.gmI.gmF;
        cqVar.closeLoadingDialog();
        if (postWriteCallBackData != null) {
            if (z) {
                String errorString = postWriteCallBackData.getErrorString();
                String preMsg = postWriteCallBackData.getPreMsg();
                String colorMsg = postWriteCallBackData.getColorMsg();
                tbPageContext4 = this.gmI.aat;
                com.baidu.tieba.tbadkCore.writeModel.e.c(tbPageContext4.getPageActivity(), errorString, preMsg, colorMsg);
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putSerializable(WriteActivityConfig.POST_WRITE_CALLBACK_DATA, postWriteCallBackData);
                intent.putExtras(bundle);
                tbPageContext5 = this.gmI.aat;
                tbPageContext5.getPageActivity().setResult(-1, intent);
                tbPageContext6 = this.gmI.aat;
                tbPageContext6.getPageActivity().finish();
            } else if ((qVar == null || writeData == null || qVar.getVcode_pic_url() == null || AntiHelper.h(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                cqVar2 = this.gmI.gmF;
                cqVar2.d(postWriteCallBackData);
            } else if (qVar != null && writeData != null && qVar.getVcode_pic_url() != null) {
                writeData.setVcodeMD5(qVar.getVcode_md5());
                writeData.setVcodeUrl(qVar.getVcode_pic_url());
                writeData.setVcodeExtra(qVar.yf());
                if (com.baidu.tbadk.o.a.gN(qVar.ye())) {
                    tbPageContext3 = this.gmI.aat;
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(tbPageContext3.getPageActivity(), 12006, writeData, false, qVar.ye())));
                    return;
                }
                MessageManager messageManager = MessageManager.getInstance();
                tbPageContext2 = this.gmI.aat;
                messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(tbPageContext2.getPageActivity(), writeData, 12006)));
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                MessageManager messageManager2 = MessageManager.getInstance();
                tbPageContext = this.gmI.aat;
                messageManager2.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(tbPageContext.getPageActivity(), 12006, writeData, postWriteCallBackData.getAccessState())));
            }
        }
    }
}
