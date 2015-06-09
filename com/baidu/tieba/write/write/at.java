package com.baidu.tieba.write.write;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes.dex */
class at implements com.baidu.tieba.tbadkCore.writeModel.e {
    final /* synthetic */ WriteActivity cCQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(WriteActivity writeActivity) {
        this.cCQ = writeActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.e
    public void a(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.l lVar, WriteData writeData, AntiData antiData) {
        WriteData writeData2;
        WriteData writeData3;
        WriteData writeData4;
        WriteData writeData5;
        WriteData writeData6;
        WriteData writeData7;
        WriteData writeData8;
        WriteData writeData9;
        this.cCQ.stopVoice();
        this.cCQ.closeLoadingDialog();
        String str = "";
        if (postWriteCallBackData != null) {
            str = postWriteCallBackData.getErrorString();
        }
        if (!z) {
            if (lVar != null && writeData != null && lVar.getVcode_pic_url() != null) {
                if (!AntiHelper.e(antiData)) {
                    writeData.setVcodeMD5(lVar.getVcode_md5());
                    writeData.setVcodeUrl(lVar.getVcode_pic_url());
                    if (lVar.vv().equals("4")) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(this.cCQ.getPageContext().getPageActivity(), 12006, writeData, false)));
                        return;
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(this.cCQ.getPageContext().getPageActivity(), writeData, 12006)));
                        return;
                    }
                }
                this.cCQ.a(false, antiData, str);
                return;
            }
            this.cCQ.a(false, antiData, str);
            return;
        }
        this.cCQ.a(true, antiData, postWriteCallBackData);
        writeData2 = this.cCQ.cup;
        if (writeData2.getType() == 0) {
            writeData7 = this.cCQ.cup;
            if (writeData7.getLiveCardData() == null) {
                writeData9 = this.cCQ.cup;
                com.baidu.tieba.tbadkCore.ao.a(writeData9.getForumId(), (WriteData) null);
            } else {
                writeData8 = this.cCQ.cup;
                com.baidu.tieba.tbadkCore.ao.a(writeData8.getLiveCardData().getGroupId(), (WriteData) null);
            }
        } else {
            writeData3 = this.cCQ.cup;
            if (writeData3.getType() == 1) {
                writeData4 = this.cCQ.cup;
                com.baidu.tieba.tbadkCore.ao.b(writeData4.getThreadId(), (WriteData) null);
            }
        }
        writeData5 = this.cCQ.cup;
        if (writeData5.getLiveCardData() != null) {
            WriteActivity writeActivity = this.cCQ;
            FrsActivityConfig frsActivityConfig = new FrsActivityConfig(this.cCQ.getPageContext().getPageActivity());
            writeData6 = this.cCQ.cup;
            writeActivity.sendMessage(new CustomMessage(2003001, frsActivityConfig.createRefreshCfgShowContent(writeData6.getForumName(), "post live's thread")));
        }
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
        intent.putExtras(bundle);
        this.cCQ.setResult(-1, intent);
        this.cCQ.finish();
    }
}
