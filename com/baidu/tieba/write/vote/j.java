package com.baidu.tieba.write.vote;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.a;
/* loaded from: classes.dex */
class j implements a.d {
    final /* synthetic */ WriteVoteActivity dWm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(WriteVoteActivity writeVoteActivity) {
        this.dWm = writeVoteActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.a.d
    public void a(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.n nVar, WriteData writeData, AntiData antiData) {
        this.dWm.closeLoadingDialog();
        if (postWriteCallBackData != null) {
            if (!z) {
                if (nVar != null && writeData != null && nVar.getVcode_pic_url() != null) {
                    if (!AntiHelper.f(antiData)) {
                        writeData.setVcodeMD5(nVar.getVcode_md5());
                        writeData.setVcodeUrl(nVar.getVcode_pic_url());
                        if (nVar.wY().equals("4")) {
                            this.dWm.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(this.dWm.getPageContext().getPageActivity(), 12006, writeData, false)));
                            return;
                        } else {
                            this.dWm.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(this.dWm.getPageContext().getPageActivity(), writeData, 12006)));
                            return;
                        }
                    }
                    this.dWm.a(true, postWriteCallBackData);
                    return;
                }
                this.dWm.a(true, postWriteCallBackData);
                return;
            }
            this.dWm.a(true, postWriteCallBackData);
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
            intent.putExtras(bundle);
            this.dWm.setResult(-1, intent);
            this.dWm.finish();
        }
    }
}
