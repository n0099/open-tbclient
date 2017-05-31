package com.baidu.tieba.write.write;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cr implements NewWriteModel.d {
    final /* synthetic */ cm gbK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cr(cm cmVar) {
        this.gbK = cmVar;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
    public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.q qVar, WriteData writeData, AntiData antiData) {
        cs csVar;
        cs csVar2;
        TbPageContext tbPageContext;
        TbPageContext tbPageContext2;
        TbPageContext tbPageContext3;
        TbPageContext tbPageContext4;
        csVar = this.gbK.gbH;
        csVar.closeLoadingDialog();
        if (postWriteCallBackData != null) {
            if (z) {
                tbPageContext4 = this.gbK.aas;
                tbPageContext4.getPageActivity().finish();
                PbActivityConfig createNormalCfg = new PbActivityConfig(TbadkCoreApplication.m9getInst().getContext()).createNormalCfg(postWriteCallBackData.getThreadId(), null, null);
                createNormalCfg.setNeedRepostRecommendForum(true);
                createNormalCfg.setPostThreadTip(postWriteCallBackData.getErrorString());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
            } else if ((qVar == null || writeData == null || qVar.getVcode_pic_url() == null || AntiHelper.h(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                csVar2 = this.gbK.gbH;
                csVar2.d(postWriteCallBackData);
            } else if (qVar != null && writeData != null && qVar.getVcode_pic_url() != null) {
                writeData.setVcodeMD5(qVar.getVcode_md5());
                writeData.setVcodeUrl(qVar.getVcode_pic_url());
                writeData.setVcodeExtra(qVar.xO());
                if (com.baidu.tbadk.o.a.gq(qVar.xN())) {
                    tbPageContext3 = this.gbK.aas;
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(tbPageContext3.getPageActivity(), 12006, writeData, false, qVar.xN())));
                    return;
                }
                MessageManager messageManager = MessageManager.getInstance();
                tbPageContext2 = this.gbK.aas;
                messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(tbPageContext2.getPageActivity(), writeData, 12006)));
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                MessageManager messageManager2 = MessageManager.getInstance();
                tbPageContext = this.gbK.aas;
                messageManager2.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(tbPageContext.getPageActivity(), 12006, writeData, postWriteCallBackData.getAccessState())));
            }
        }
    }
}
