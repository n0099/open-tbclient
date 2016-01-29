package com.baidu.tieba.write.write;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
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
    final /* synthetic */ WriteActivity ets;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(WriteActivity writeActivity) {
        this.ets = writeActivity;
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
        this.ets.Oy();
        this.ets.closeLoadingDialog();
        if (postWriteCallBackData != null) {
            writeData2 = this.ets.dZC;
            if (writeData2 != null) {
                if (!z) {
                    if (nVar != null && writeData != null && nVar.getVcode_pic_url() != null) {
                        if (!AntiHelper.h(antiData)) {
                            writeData.setVcodeMD5(nVar.getVcode_md5());
                            writeData.setVcodeUrl(nVar.getVcode_pic_url());
                            if (nVar.yl().equals("4")) {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(this.ets.getPageContext().getPageActivity(), 12006, writeData, false)));
                                return;
                            } else {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(this.ets.getPageContext().getPageActivity(), writeData, 12006)));
                                return;
                            }
                        }
                        this.ets.a(false, postWriteCallBackData);
                        return;
                    }
                    this.ets.a(false, postWriteCallBackData);
                    return;
                }
                this.ets.br(z);
                this.ets.a(true, postWriteCallBackData);
                writeData3 = this.ets.dZC;
                if (writeData3.getType() == 0) {
                    writeData10 = this.ets.dZC;
                    com.baidu.tieba.tbadkCore.ad.b(writeData10.getForumId(), (WriteData) null);
                    if (postWriteCallBackData != null && postWriteCallBackData.getIsCopyTWZhibo() == 3) {
                        this.ets.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig(this.ets.getPageContext().getPageActivity()).createNormalCfg(postWriteCallBackData.getThreadId(), postWriteCallBackData.getPostId(), null, PhotoLiveActivityConfig.KEY_FROM_WRITE_TARGET, 18003)));
                    }
                } else {
                    writeData4 = this.ets.dZC;
                    if (writeData4.getType() == 1) {
                        writeData9 = this.ets.dZC;
                        com.baidu.tieba.tbadkCore.ad.c(writeData9.getThreadId(), (WriteData) null);
                    } else {
                        writeData5 = this.ets.dZC;
                        if (writeData5.getType() == 4) {
                            writeData8 = this.ets.dZC;
                            com.baidu.tieba.tbadkCore.ad.b(String.valueOf(writeData8.getForumId()) + "photolive", (WriteData) null);
                            if (postWriteCallBackData != null) {
                                this.ets.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig(this.ets.getPageContext().getPageActivity()).createNormalCfg(postWriteCallBackData.getThreadId(), postWriteCallBackData.getPostId(), null, PhotoLiveActivityConfig.KEY_FROM_WRITE, 18003)));
                            }
                        } else {
                            writeData6 = this.ets.dZC;
                            if (writeData6.getType() == 5) {
                                writeData7 = this.ets.dZC;
                                com.baidu.tieba.tbadkCore.ad.c(String.valueOf(writeData7.getThreadId()) + "updatephotolive", (WriteData) null);
                            }
                        }
                    }
                }
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                intent.putExtras(bundle);
                this.ets.setResult(-1, intent);
                this.ets.finish();
            }
        }
    }
}
