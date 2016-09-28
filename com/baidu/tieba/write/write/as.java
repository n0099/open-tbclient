package com.baidu.tieba.write.write;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.b;
/* loaded from: classes.dex */
class as implements b.d {
    final /* synthetic */ WriteActivity ghD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(WriteActivity writeActivity) {
        this.ghD = writeActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.b.d
    public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.s sVar, WriteData writeData, AntiData antiData) {
        WriteData writeData2;
        boolean z2;
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
        this.ghD.abb();
        this.ghD.closeLoadingDialog();
        if (postWriteCallBackData != null) {
            writeData2 = this.ghD.flk;
            if (writeData2 != null) {
                if (!z) {
                    if ((sVar != null && writeData != null && sVar.getVcode_pic_url() != null && !AntiHelper.g(antiData)) || postWriteCallBackData == null || postWriteCallBackData.getErrorCode() == 227001) {
                        if (sVar != null && writeData != null && sVar.getVcode_pic_url() != null) {
                            writeData.setVcodeMD5(sVar.getVcode_md5());
                            writeData.setVcodeUrl(sVar.getVcode_pic_url());
                            writeData.setVcodeExtra(sVar.xX());
                            if (com.baidu.tbadk.j.a.gG(sVar.xW())) {
                                NewVcodeActivityConfig newVcodeActivityConfig = new NewVcodeActivityConfig(this.ghD.getPageContext().getPageActivity(), 12006, writeData, false, sVar.xW());
                                z2 = this.ghD.ggA;
                                if (z2) {
                                    newVcodeActivityConfig.setHideFeedBackButton();
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, newVcodeActivityConfig));
                                return;
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(this.ghD.getPageContext().getPageActivity(), writeData, 12006)));
                            return;
                        } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(this.ghD.getActivity(), 12006, writeData, postWriteCallBackData.getAccessState())));
                            return;
                        } else {
                            return;
                        }
                    }
                    this.ghD.a(false, postWriteCallBackData);
                    return;
                }
                this.ghD.bF(z);
                this.ghD.a(true, postWriteCallBackData);
                writeData3 = this.ghD.flk;
                if (writeData3.getType() != 0) {
                    writeData4 = this.ghD.flk;
                    if (writeData4.getType() == 1) {
                        writeData11 = this.ghD.flk;
                        com.baidu.tieba.tbadkCore.ae.c(writeData11.getThreadId(), (WriteData) null);
                    } else {
                        writeData5 = this.ghD.flk;
                        if (writeData5.getType() == 4) {
                            writeData10 = this.ghD.flk;
                            com.baidu.tieba.tbadkCore.ae.b(String.valueOf(writeData10.getForumId()) + "photolive", (WriteData) null);
                            if (postWriteCallBackData != null) {
                                this.ghD.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig(this.ghD.getPageContext().getPageActivity()).createNormalCfg(postWriteCallBackData.getThreadId(), postWriteCallBackData.getPostId(), null, PhotoLiveActivityConfig.KEY_FROM_WRITE, 18003)));
                            }
                        } else {
                            writeData6 = this.ghD.flk;
                            if (writeData6.getType() == 5) {
                                writeData9 = this.ghD.flk;
                                com.baidu.tieba.tbadkCore.ae.c(String.valueOf(writeData9.getThreadId()) + "updatephotolive", (WriteData) null);
                            } else {
                                writeData7 = this.ghD.flk;
                                if (writeData7.getType() == 7) {
                                    writeData8 = this.ghD.flk;
                                    com.baidu.tieba.tbadkCore.ae.b(writeData8.getForumId(), (WriteData) null);
                                }
                            }
                        }
                    }
                } else if (this.ghD.getIntent().getBooleanExtra(WriteActivityConfig.IS_SAVE_DRAFTE, true)) {
                    writeData12 = this.ghD.flk;
                    com.baidu.tieba.tbadkCore.ae.b(writeData12.getForumId(), (WriteData) null);
                    if (postWriteCallBackData.getIsCopyTWZhibo() == 3) {
                        this.ghD.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig(this.ghD.getPageContext().getPageActivity()).createNormalCfg(postWriteCallBackData.getThreadId(), postWriteCallBackData.getPostId(), null, PhotoLiveActivityConfig.KEY_FROM_WRITE_TARGET, 18003)));
                    }
                }
                this.ghD.c(postWriteCallBackData);
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                intent.putExtras(bundle);
                this.ghD.setResult(-1, intent);
                this.ghD.finish();
            }
        }
    }
}
