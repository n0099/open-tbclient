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
class ap implements NewWriteModel.d {
    final /* synthetic */ WriteActivity glP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(WriteActivity writeActivity) {
        this.glP = writeActivity;
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
        this.glP.aei();
        this.glP.closeLoadingDialog();
        if (postWriteCallBackData != null) {
            writeData2 = this.glP.mData;
            if (writeData2 != null) {
                if (!z) {
                    if ((qVar != null && writeData != null && qVar.getVcode_pic_url() != null && !AntiHelper.h(antiData)) || postWriteCallBackData == null || postWriteCallBackData.getErrorCode() == 227001) {
                        if (qVar != null && writeData != null && qVar.getVcode_pic_url() != null) {
                            if (writeData.isCanNoForum()) {
                                writeData.setForumName("");
                                writeData.setForumId("0");
                            }
                            writeData.setVcodeMD5(qVar.getVcode_md5());
                            writeData.setVcodeUrl(qVar.getVcode_pic_url());
                            writeData.setVcodeExtra(qVar.yf());
                            if (com.baidu.tbadk.o.a.gN(qVar.ye())) {
                                NewVcodeActivityConfig newVcodeActivityConfig = new NewVcodeActivityConfig(this.glP.getPageContext().getPageActivity(), 12006, writeData, false, qVar.ye());
                                z2 = this.glP.gkA;
                                if (z2) {
                                    newVcodeActivityConfig.setHideFeedBackButton();
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, newVcodeActivityConfig));
                                return;
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(this.glP.getPageContext().getPageActivity(), writeData, 12006)));
                            return;
                        } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(this.glP.getActivity(), 12006, writeData, postWriteCallBackData.getAccessState())));
                            return;
                        } else {
                            return;
                        }
                    }
                    this.glP.a(false, postWriteCallBackData);
                    return;
                }
                this.glP.bK(z);
                this.glP.a(true, postWriteCallBackData);
                writeData3 = this.glP.mData;
                if (writeData3.getType() != 0) {
                    writeData4 = this.glP.mData;
                    if (writeData4.getType() != 7) {
                        writeData5 = this.glP.mData;
                        if (writeData5.getType() == 1) {
                            writeData10 = this.glP.mData;
                            com.baidu.tieba.tbadkCore.x.c(writeData10.getThreadId(), (WriteData) null);
                        } else {
                            writeData6 = this.glP.mData;
                            if (writeData6.getType() == 4) {
                                writeData9 = this.glP.mData;
                                com.baidu.tieba.tbadkCore.x.b(String.valueOf(writeData9.getForumId()) + "photolive", (WriteData) null);
                                if (postWriteCallBackData != null) {
                                    this.glP.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig(this.glP.getPageContext().getPageActivity()).createNormalCfg(postWriteCallBackData.getThreadId(), postWriteCallBackData.getPostId(), null, PhotoLiveActivityConfig.KEY_FROM_WRITE, 18003)));
                                }
                            } else {
                                writeData7 = this.glP.mData;
                                if (writeData7.getType() == 5) {
                                    writeData8 = this.glP.mData;
                                    com.baidu.tieba.tbadkCore.x.c(String.valueOf(writeData8.getThreadId()) + "updatephotolive", (WriteData) null);
                                }
                            }
                        }
                    } else if (this.glP.getIntent().getBooleanExtra(WriteActivityConfig.IS_SAVE_DRAFTE, true)) {
                        com.baidu.tieba.tbadkCore.x.b("24591571", (WriteData) null);
                    }
                } else {
                    if (this.glP.getIntent().getBooleanExtra(WriteActivityConfig.IS_SAVE_DRAFTE, true)) {
                        writeData11 = this.glP.mData;
                        com.baidu.tieba.tbadkCore.x.b(writeData11.getForumId(), (WriteData) null);
                        if (postWriteCallBackData.getIsCopyTWZhibo() == 3) {
                            this.glP.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig(this.glP.getPageContext().getPageActivity()).createNormalCfg(postWriteCallBackData.getThreadId(), postWriteCallBackData.getPostId(), null, PhotoLiveActivityConfig.KEY_FROM_WRITE_TARGET, 18003)));
                        }
                    }
                    list = this.glP.mList;
                    if (!com.baidu.tbadk.core.util.z.t(list)) {
                        str = this.glP.glD;
                        if (!StringUtils.isNull(str)) {
                            com.baidu.tbadk.core.util.au auVar = new com.baidu.tbadk.core.util.au("c11731");
                            str2 = this.glP.glD;
                            TiebaStatic.log(auVar.Z("obj_id", str2));
                        }
                    }
                }
                this.glP.c(postWriteCallBackData);
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putSerializable(WriteActivityConfig.POST_WRITE_CALLBACK_DATA, postWriteCallBackData);
                intent.putExtras(bundle);
                this.glP.setResult(-1, intent);
                this.glP.finish();
            }
        }
    }
}
