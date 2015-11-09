package com.baidu.tieba.write.write;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.a;
/* loaded from: classes.dex */
class aj implements a.d {
    final /* synthetic */ WriteActivity dsa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(WriteActivity writeActivity) {
        this.dsa = writeActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.a.d
    public void a(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.l lVar, WriteData writeData, AntiData antiData) {
        WriteData writeData2;
        WriteData writeData3;
        WriteData writeData4;
        WriteData writeData5;
        WriteData writeData6;
        WriteData writeData7;
        WriteData writeData8;
        WriteData writeData9;
        WriteData writeData10;
        WriteData writeData11;
        WriteData writeData12;
        WriteData writeData13;
        this.dsa.stopVoice();
        this.dsa.closeLoadingDialog();
        if (postWriteCallBackData != null) {
            if (!z) {
                if (lVar != null && writeData != null && lVar.getVcode_pic_url() != null) {
                    if (!AntiHelper.g(antiData)) {
                        writeData.setVcodeMD5(lVar.getVcode_md5());
                        writeData.setVcodeUrl(lVar.getVcode_pic_url());
                        if (lVar.wu().equals("4")) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(this.dsa.getPageContext().getPageActivity(), 12006, writeData, false)));
                            return;
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(this.dsa.getPageContext().getPageActivity(), writeData, 12006)));
                            return;
                        }
                    }
                    this.dsa.a(false, postWriteCallBackData);
                    return;
                }
                this.dsa.a(false, postWriteCallBackData);
                return;
            }
            this.dsa.bj(z);
            this.dsa.a(true, postWriteCallBackData);
            if (writeData != null && writeData.getVideoInfo() != null && postWriteCallBackData != null) {
                XiaoyingUtil.reportEvent(postWriteCallBackData.getThreadId(), postWriteCallBackData.getPostId(), writeData.getForumId(), writeData.getVideoInfo().getVideoUrl(), writeData.getForumName());
            }
            writeData2 = this.dsa.ddI;
            if (writeData2.getType() == 0) {
                writeData11 = this.dsa.ddI;
                if (writeData11.getLiveCardData() == null) {
                    writeData13 = this.dsa.ddI;
                    com.baidu.tieba.tbadkCore.ad.b(writeData13.getForumId(), (WriteData) null);
                } else {
                    writeData12 = this.dsa.ddI;
                    com.baidu.tieba.tbadkCore.ad.a(writeData12.getLiveCardData().getGroupId(), (WriteData) null);
                }
            } else {
                writeData3 = this.dsa.ddI;
                if (writeData3.getType() == 1) {
                    writeData8 = this.dsa.ddI;
                    com.baidu.tieba.tbadkCore.ad.c(writeData8.getThreadId(), (WriteData) null);
                } else {
                    writeData4 = this.dsa.ddI;
                    if (writeData4.getType() == 4) {
                        writeData7 = this.dsa.ddI;
                        com.baidu.tieba.tbadkCore.ad.b(String.valueOf(writeData7.getForumId()) + "photolive", (WriteData) null);
                        if (postWriteCallBackData != null) {
                            this.dsa.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig(this.dsa.getPageContext().getPageActivity()).createNormalCfg(postWriteCallBackData.getThreadId(), postWriteCallBackData.getPostId(), null, PhotoLiveActivityConfig.KEY_FROM_WRITE, 18003)));
                        }
                    } else {
                        writeData5 = this.dsa.ddI;
                        if (writeData5.getType() == 5) {
                            writeData6 = this.dsa.ddI;
                            com.baidu.tieba.tbadkCore.ad.c(String.valueOf(writeData6.getThreadId()) + "updatephotolive", (WriteData) null);
                        }
                    }
                }
            }
            writeData9 = this.dsa.ddI;
            if (writeData9.getLiveCardData() != null) {
                WriteActivity writeActivity = this.dsa;
                FrsActivityConfig frsActivityConfig = new FrsActivityConfig(this.dsa.getPageContext().getPageActivity());
                writeData10 = this.dsa.ddI;
                writeActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_REFRESH, frsActivityConfig.createRefreshCfgShowContent(writeData10.getForumName(), "post live's thread")));
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
            intent.putExtras(bundle);
            this.dsa.setResult(-1, intent);
            this.dsa.finish();
        }
    }
}
