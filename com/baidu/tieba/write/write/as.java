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
import com.baidu.tieba.tbadkCore.writeModel.a;
/* loaded from: classes.dex */
class as implements a.d {
    final /* synthetic */ WriteActivity fVn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(WriteActivity writeActivity) {
        this.fVn = writeActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.a.d
    public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.p pVar, WriteData writeData, AntiData antiData) {
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
        this.fVn.VR();
        this.fVn.closeLoadingDialog();
        if (postWriteCallBackData != null) {
            writeData2 = this.fVn.faq;
            if (writeData2 != null) {
                if (!z) {
                    if ((pVar != null && writeData != null && pVar.getVcode_pic_url() != null && !AntiHelper.g(antiData)) || postWriteCallBackData == null || postWriteCallBackData.getErrorCode() == 227001) {
                        if (pVar != null && writeData != null && pVar.getVcode_pic_url() != null) {
                            writeData.setVcodeMD5(pVar.getVcode_md5());
                            writeData.setVcodeUrl(pVar.getVcode_pic_url());
                            writeData.setVcodeExtra(pVar.wK());
                            if (com.baidu.tbadk.k.a.gz(pVar.wJ())) {
                                NewVcodeActivityConfig newVcodeActivityConfig = new NewVcodeActivityConfig(this.fVn.getPageContext().getPageActivity(), 12006, writeData, false, pVar.wJ());
                                z2 = this.fVn.fUk;
                                if (z2) {
                                    newVcodeActivityConfig.setHideFeedBackButton();
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, newVcodeActivityConfig));
                                return;
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(this.fVn.getPageContext().getPageActivity(), writeData, 12006)));
                            return;
                        } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(this.fVn.getActivity(), 12006, writeData, postWriteCallBackData.getAccessState())));
                            return;
                        } else {
                            return;
                        }
                    }
                    this.fVn.a(false, postWriteCallBackData);
                    return;
                }
                this.fVn.bE(z);
                this.fVn.a(true, postWriteCallBackData);
                writeData3 = this.fVn.faq;
                if (writeData3.getType() != 0) {
                    writeData4 = this.fVn.faq;
                    if (writeData4.getType() == 1) {
                        writeData11 = this.fVn.faq;
                        com.baidu.tieba.tbadkCore.af.c(writeData11.getThreadId(), (WriteData) null);
                    } else {
                        writeData5 = this.fVn.faq;
                        if (writeData5.getType() == 4) {
                            writeData10 = this.fVn.faq;
                            com.baidu.tieba.tbadkCore.af.b(String.valueOf(writeData10.getForumId()) + "photolive", (WriteData) null);
                            if (postWriteCallBackData != null) {
                                this.fVn.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig(this.fVn.getPageContext().getPageActivity()).createNormalCfg(postWriteCallBackData.getThreadId(), postWriteCallBackData.getPostId(), null, PhotoLiveActivityConfig.KEY_FROM_WRITE, 18003)));
                            }
                        } else {
                            writeData6 = this.fVn.faq;
                            if (writeData6.getType() == 5) {
                                writeData9 = this.fVn.faq;
                                com.baidu.tieba.tbadkCore.af.c(String.valueOf(writeData9.getThreadId()) + "updatephotolive", (WriteData) null);
                            } else {
                                writeData7 = this.fVn.faq;
                                if (writeData7.getType() == 7) {
                                    writeData8 = this.fVn.faq;
                                    com.baidu.tieba.tbadkCore.af.b(writeData8.getForumId(), (WriteData) null);
                                }
                            }
                        }
                    }
                } else if (this.fVn.getIntent().getBooleanExtra(WriteActivityConfig.IS_SAVE_DRAFTE, true)) {
                    writeData12 = this.fVn.faq;
                    com.baidu.tieba.tbadkCore.af.b(writeData12.getForumId(), (WriteData) null);
                    if (postWriteCallBackData.getIsCopyTWZhibo() == 3) {
                        this.fVn.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig(this.fVn.getPageContext().getPageActivity()).createNormalCfg(postWriteCallBackData.getThreadId(), postWriteCallBackData.getPostId(), null, PhotoLiveActivityConfig.KEY_FROM_WRITE_TARGET, 18003)));
                    }
                }
                this.fVn.c(postWriteCallBackData);
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                intent.putExtras(bundle);
                this.fVn.setResult(-1, intent);
                this.fVn.finish();
            }
        }
    }
}
