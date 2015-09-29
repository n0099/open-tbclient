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
    final /* synthetic */ WriteVoteActivity dnv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(WriteVoteActivity writeVoteActivity) {
        this.dnv = writeVoteActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.a.d
    public void a(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.l lVar, WriteData writeData, AntiData antiData) {
        this.dnv.closeLoadingDialog();
        if (postWriteCallBackData != null) {
            if (!z) {
                if (lVar != null && writeData != null && lVar.getVcode_pic_url() != null) {
                    if (!AntiHelper.g(antiData)) {
                        writeData.setVcodeMD5(lVar.getVcode_md5());
                        writeData.setVcodeUrl(lVar.getVcode_pic_url());
                        if (lVar.ws().equals("4")) {
                            this.dnv.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(this.dnv.getPageContext().getPageActivity(), 12006, writeData, false)));
                            return;
                        } else {
                            this.dnv.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(this.dnv.getPageContext().getPageActivity(), writeData, 12006)));
                            return;
                        }
                    }
                    this.dnv.a(true, postWriteCallBackData);
                    return;
                }
                this.dnv.a(true, postWriteCallBackData);
                return;
            }
            this.dnv.a(true, postWriteCallBackData);
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
            intent.putExtras(bundle);
            this.dnv.setResult(-1, intent);
            this.dnv.finish();
        }
    }
}
