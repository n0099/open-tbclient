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
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.a;
/* loaded from: classes.dex */
class aj implements a.d {
    final /* synthetic */ WriteActivity dYD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(WriteActivity writeActivity) {
        this.dYD = writeActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.a.d
    public void a(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.n nVar, WriteData writeData, AntiData antiData) {
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
        WriteData writeData14;
        this.dYD.stopVoice();
        this.dYD.closeLoadingDialog();
        if (postWriteCallBackData != null) {
            writeData2 = this.dYD.dJy;
            if (writeData2 != null) {
                if (!z) {
                    if (nVar != null && writeData != null && nVar.getVcode_pic_url() != null) {
                        if (!AntiHelper.f(antiData)) {
                            writeData.setVcodeMD5(nVar.getVcode_md5());
                            writeData.setVcodeUrl(nVar.getVcode_pic_url());
                            if (nVar.wY().equals("4")) {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(this.dYD.getPageContext().getPageActivity(), 12006, writeData, false)));
                                return;
                            } else {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(this.dYD.getPageContext().getPageActivity(), writeData, 12006)));
                                return;
                            }
                        }
                        this.dYD.a(false, postWriteCallBackData);
                        return;
                    }
                    this.dYD.a(false, postWriteCallBackData);
                    return;
                }
                this.dYD.bp(z);
                this.dYD.a(true, postWriteCallBackData);
                writeData3 = this.dYD.dJy;
                if (writeData3.getType() == 0) {
                    writeData12 = this.dYD.dJy;
                    if (writeData12.getLiveCardData() == null) {
                        writeData14 = this.dYD.dJy;
                        com.baidu.tieba.tbadkCore.ae.b(writeData14.getForumId(), (WriteData) null);
                    } else {
                        writeData13 = this.dYD.dJy;
                        com.baidu.tieba.tbadkCore.ae.a(writeData13.getLiveCardData().getGroupId(), (WriteData) null);
                    }
                    if (postWriteCallBackData != null && postWriteCallBackData.getIsCopyTWZhibo() == 3) {
                        this.dYD.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig(this.dYD.getPageContext().getPageActivity()).createNormalCfg(postWriteCallBackData.getThreadId(), postWriteCallBackData.getPostId(), null, PhotoLiveActivityConfig.KEY_FROM_WRITE_TARGET, 18003)));
                    }
                } else {
                    writeData4 = this.dYD.dJy;
                    if (writeData4.getType() == 1) {
                        writeData9 = this.dYD.dJy;
                        com.baidu.tieba.tbadkCore.ae.c(writeData9.getThreadId(), (WriteData) null);
                    } else {
                        writeData5 = this.dYD.dJy;
                        if (writeData5.getType() == 4) {
                            writeData8 = this.dYD.dJy;
                            com.baidu.tieba.tbadkCore.ae.b(String.valueOf(writeData8.getForumId()) + "photolive", (WriteData) null);
                            if (postWriteCallBackData != null) {
                                this.dYD.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig(this.dYD.getPageContext().getPageActivity()).createNormalCfg(postWriteCallBackData.getThreadId(), postWriteCallBackData.getPostId(), null, PhotoLiveActivityConfig.KEY_FROM_WRITE, 18003)));
                            }
                        } else {
                            writeData6 = this.dYD.dJy;
                            if (writeData6.getType() == 5) {
                                writeData7 = this.dYD.dJy;
                                com.baidu.tieba.tbadkCore.ae.c(String.valueOf(writeData7.getThreadId()) + "updatephotolive", (WriteData) null);
                            }
                        }
                    }
                }
                writeData10 = this.dYD.dJy;
                if (writeData10.getLiveCardData() != null) {
                    WriteActivity writeActivity = this.dYD;
                    FrsActivityConfig frsActivityConfig = new FrsActivityConfig(this.dYD.getPageContext().getPageActivity());
                    writeData11 = this.dYD.dJy;
                    writeActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_REFRESH, frsActivityConfig.createRefreshCfgShowContent(writeData11.getForumName(), "post live's thread")));
                }
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                intent.putExtras(bundle);
                this.dYD.setResult(-1, intent);
                this.dYD.finish();
            }
        }
    }
}
