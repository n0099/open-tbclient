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
class ak implements a.d {
    final /* synthetic */ WriteActivity fea;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(WriteActivity writeActivity) {
        this.fea = writeActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.a.d
    public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.o oVar, WriteData writeData, AntiData antiData) {
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
        this.fea.Pm();
        this.fea.closeLoadingDialog();
        if (postWriteCallBackData != null) {
            writeData2 = this.fea.evE;
            if (writeData2 != null) {
                if (!z) {
                    if (oVar != null && writeData != null && oVar.getVcode_pic_url() != null) {
                        if (!AntiHelper.g(antiData)) {
                            writeData.setVcodeMD5(oVar.getVcode_md5());
                            writeData.setVcodeUrl(oVar.getVcode_pic_url());
                            if (oVar.wG().equals("4")) {
                                NewVcodeActivityConfig newVcodeActivityConfig = new NewVcodeActivityConfig(this.fea.getPageContext().getPageActivity(), 12006, writeData, false);
                                z2 = this.fea.fcZ;
                                if (z2) {
                                    newVcodeActivityConfig.setHideFeedBackButton();
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, newVcodeActivityConfig));
                                return;
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(this.fea.getPageContext().getPageActivity(), writeData, 12006)));
                            return;
                        }
                        this.fea.a(false, postWriteCallBackData);
                        return;
                    }
                    this.fea.a(false, postWriteCallBackData);
                    return;
                }
                this.fea.bC(z);
                this.fea.a(true, postWriteCallBackData);
                writeData3 = this.fea.evE;
                if (writeData3.getType() == 0) {
                    writeData10 = this.fea.evE;
                    com.baidu.tieba.tbadkCore.ae.b(writeData10.getForumId(), (WriteData) null);
                    if (postWriteCallBackData.getIsCopyTWZhibo() == 3) {
                        this.fea.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig(this.fea.getPageContext().getPageActivity()).createNormalCfg(postWriteCallBackData.getThreadId(), postWriteCallBackData.getPostId(), null, PhotoLiveActivityConfig.KEY_FROM_WRITE_TARGET, 18003)));
                    }
                } else {
                    writeData4 = this.fea.evE;
                    if (writeData4.getType() == 1) {
                        writeData9 = this.fea.evE;
                        com.baidu.tieba.tbadkCore.ae.c(writeData9.getThreadId(), (WriteData) null);
                    } else {
                        writeData5 = this.fea.evE;
                        if (writeData5.getType() == 4) {
                            writeData8 = this.fea.evE;
                            com.baidu.tieba.tbadkCore.ae.b(String.valueOf(writeData8.getForumId()) + "photolive", (WriteData) null);
                            if (postWriteCallBackData != null) {
                                this.fea.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig(this.fea.getPageContext().getPageActivity()).createNormalCfg(postWriteCallBackData.getThreadId(), postWriteCallBackData.getPostId(), null, PhotoLiveActivityConfig.KEY_FROM_WRITE, 18003)));
                            }
                        } else {
                            writeData6 = this.fea.evE;
                            if (writeData6.getType() == 5) {
                                writeData7 = this.fea.evE;
                                com.baidu.tieba.tbadkCore.ae.c(String.valueOf(writeData7.getThreadId()) + "updatephotolive", (WriteData) null);
                            }
                        }
                    }
                }
                this.fea.c(postWriteCallBackData);
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                intent.putExtras(bundle);
                this.fea.setResult(-1, intent);
                this.fea.finish();
            }
        }
    }
}
