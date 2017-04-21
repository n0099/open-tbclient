package com.baidu.tieba.write.write;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.util.List;
/* loaded from: classes.dex */
class aq implements NewWriteModel.d {
    final /* synthetic */ WriteActivity fUM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(WriteActivity writeActivity) {
        this.fUM = writeActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
    public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.q qVar, WriteData writeData, AntiData antiData) {
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
        List list;
        String str;
        String str2;
        WriteData writeData11;
        this.fUM.aaq();
        this.fUM.closeLoadingDialog();
        if (postWriteCallBackData != null) {
            writeData2 = this.fUM.mData;
            if (writeData2 != null) {
                if (!z) {
                    if ((qVar != null && writeData != null && qVar.getVcode_pic_url() != null && !AntiHelper.h(antiData)) || postWriteCallBackData == null || postWriteCallBackData.getErrorCode() == 227001) {
                        if (qVar != null && writeData != null && qVar.getVcode_pic_url() != null) {
                            writeData.setVcodeMD5(qVar.getVcode_md5());
                            writeData.setVcodeUrl(qVar.getVcode_pic_url());
                            writeData.setVcodeExtra(qVar.yH());
                            if (com.baidu.tbadk.o.a.gt(qVar.yG())) {
                                NewVcodeActivityConfig newVcodeActivityConfig = new NewVcodeActivityConfig(this.fUM.getPageContext().getPageActivity(), 12006, writeData, false, qVar.yG());
                                z2 = this.fUM.fTB;
                                if (z2) {
                                    newVcodeActivityConfig.setHideFeedBackButton();
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, newVcodeActivityConfig));
                                return;
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(this.fUM.getPageContext().getPageActivity(), writeData, 12006)));
                            return;
                        } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(this.fUM.getActivity(), 12006, writeData, postWriteCallBackData.getAccessState())));
                            return;
                        } else {
                            return;
                        }
                    }
                    this.fUM.a(false, postWriteCallBackData);
                    return;
                }
                this.fUM.bK(z);
                this.fUM.a(true, postWriteCallBackData);
                writeData3 = this.fUM.mData;
                if (writeData3.getType() != 0) {
                    writeData4 = this.fUM.mData;
                    if (writeData4.getType() != 7) {
                        writeData5 = this.fUM.mData;
                        if (writeData5.getType() == 1) {
                            writeData10 = this.fUM.mData;
                            com.baidu.tieba.tbadkCore.z.c(writeData10.getThreadId(), (WriteData) null);
                        } else {
                            writeData6 = this.fUM.mData;
                            if (writeData6.getType() == 4) {
                                writeData9 = this.fUM.mData;
                                com.baidu.tieba.tbadkCore.z.b(String.valueOf(writeData9.getForumId()) + "photolive", (WriteData) null);
                                if (postWriteCallBackData != null) {
                                    this.fUM.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig(this.fUM.getPageContext().getPageActivity()).createNormalCfg(postWriteCallBackData.getThreadId(), postWriteCallBackData.getPostId(), null, PhotoLiveActivityConfig.KEY_FROM_WRITE, 18003)));
                                }
                            } else {
                                writeData7 = this.fUM.mData;
                                if (writeData7.getType() == 5) {
                                    writeData8 = this.fUM.mData;
                                    com.baidu.tieba.tbadkCore.z.c(String.valueOf(writeData8.getThreadId()) + "updatephotolive", (WriteData) null);
                                }
                            }
                        }
                    } else if (this.fUM.getIntent().getBooleanExtra(WriteActivityConfig.IS_SAVE_DRAFTE, true)) {
                        com.baidu.tieba.tbadkCore.z.b("24591571", (WriteData) null);
                    }
                } else {
                    if (this.fUM.getIntent().getBooleanExtra(WriteActivityConfig.IS_SAVE_DRAFTE, true)) {
                        writeData11 = this.fUM.mData;
                        com.baidu.tieba.tbadkCore.z.b(writeData11.getForumId(), (WriteData) null);
                        if (postWriteCallBackData.getIsCopyTWZhibo() == 3) {
                            this.fUM.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig(this.fUM.getPageContext().getPageActivity()).createNormalCfg(postWriteCallBackData.getThreadId(), postWriteCallBackData.getPostId(), null, PhotoLiveActivityConfig.KEY_FROM_WRITE_TARGET, 18003)));
                        }
                    }
                    list = this.fUM.mList;
                    if (!com.baidu.tbadk.core.util.x.q(list)) {
                        str = this.fUM.fUB;
                        if (!StringUtils.isNull(str)) {
                            com.baidu.tbadk.core.util.as asVar = new com.baidu.tbadk.core.util.as("c11731");
                            str2 = this.fUM.fUB;
                            TiebaStatic.log(asVar.aa("obj_id", str2));
                        }
                    }
                }
                this.fUM.c(postWriteCallBackData);
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                intent.putExtras(bundle);
                this.fUM.setResult(-1, intent);
                this.fUM.finish();
            }
        }
    }
}
