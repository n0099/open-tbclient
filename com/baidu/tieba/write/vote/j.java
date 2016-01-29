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
    final /* synthetic */ WriteVoteActivity erf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(WriteVoteActivity writeVoteActivity) {
        this.erf = writeVoteActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.a.d
    public void a(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.n nVar, WriteData writeData, AntiData antiData) {
        this.erf.closeLoadingDialog();
        if (postWriteCallBackData != null) {
            if (!z) {
                if (nVar != null && writeData != null && nVar.getVcode_pic_url() != null) {
                    if (!AntiHelper.h(antiData)) {
                        writeData.setVcodeMD5(nVar.getVcode_md5());
                        writeData.setVcodeUrl(nVar.getVcode_pic_url());
                        if (nVar.yl().equals("4")) {
                            this.erf.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(this.erf.getPageContext().getPageActivity(), 12006, writeData, false)));
                            return;
                        } else {
                            this.erf.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(this.erf.getPageContext().getPageActivity(), writeData, 12006)));
                            return;
                        }
                    }
                    this.erf.a(true, postWriteCallBackData);
                    return;
                }
                this.erf.a(true, postWriteCallBackData);
                return;
            }
            this.erf.a(true, postWriteCallBackData);
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
            intent.putExtras(bundle);
            this.erf.setResult(-1, intent);
            this.erf.finish();
        }
    }
}
