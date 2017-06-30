package com.baidu.tieba.pb.pb.main.emotion.model;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.q;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements NewWriteModel.d {
    final /* synthetic */ a eFk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.eFk = aVar;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
    public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, q qVar, WriteData writeData, AntiData antiData) {
        WriteData writeData2;
        BaseActivity baseActivity;
        BaseActivity baseActivity2;
        BaseActivity baseActivity3;
        NewWriteModel.d dVar;
        NewWriteModel.d dVar2;
        NewWriteModel newWriteModel;
        if (writeData == null) {
            newWriteModel = this.eFk.aBE;
            writeData2 = newWriteModel.getWriteData();
        } else {
            writeData2 = writeData;
        }
        if (!z) {
            if (writeData2 != null && qVar != null && !TextUtils.isEmpty(qVar.ye())) {
                writeData2.setVcodeMD5(qVar.getVcode_md5());
                writeData2.setVcodeUrl(qVar.getVcode_pic_url());
                writeData2.setVcodeExtra(qVar.yf());
                if (com.baidu.tbadk.o.a.gN(qVar.ye())) {
                    MessageManager messageManager = MessageManager.getInstance();
                    baseActivity3 = this.eFk.bhX;
                    messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(baseActivity3.getPageContext().getPageActivity(), 25017, writeData2, false, qVar.ye())));
                } else {
                    MessageManager messageManager2 = MessageManager.getInstance();
                    baseActivity2 = this.eFk.bhX;
                    messageManager2.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(baseActivity2.getPageContext().getPageActivity(), writeData2, 25017)));
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                MessageManager messageManager3 = MessageManager.getInstance();
                baseActivity = this.eFk.bhX;
                messageManager3.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(baseActivity.getPageContext().getPageActivity(), 25017, writeData2, postWriteCallBackData.getAccessState())));
            }
        } else {
            this.eFk.resetData();
        }
        dVar = this.eFk.eFf;
        if (dVar != null) {
            dVar2 = this.eFk.eFf;
            dVar2.callback(z, postWriteCallBackData, qVar, writeData2, antiData);
        }
    }
}
