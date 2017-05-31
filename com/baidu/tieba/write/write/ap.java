package com.baidu.tieba.write.write;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
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
    final /* synthetic */ WriteActivity gaR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(WriteActivity writeActivity) {
        this.gaR = writeActivity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x003a, code lost:
        if (r0.isUserFeedback() != false) goto L47;
     */
    @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
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
        WriteData writeData11;
        WriteData writeData12;
        WriteData writeData13;
        List list;
        String str;
        String str2;
        WriteData writeData14;
        WriteData writeData15;
        this.gaR.aas();
        this.gaR.closeLoadingDialog();
        if (postWriteCallBackData != null) {
            writeData2 = this.gaR.mData;
            if (writeData2 != null) {
                if (!z) {
                    if ((qVar != null && writeData != null && qVar.getVcode_pic_url() != null && !AntiHelper.h(antiData)) || postWriteCallBackData == null || postWriteCallBackData.getErrorCode() == 227001) {
                        if (qVar != null && writeData != null && qVar.getVcode_pic_url() != null) {
                            writeData.setVcodeMD5(qVar.getVcode_md5());
                            writeData.setVcodeUrl(qVar.getVcode_pic_url());
                            writeData.setVcodeExtra(qVar.xO());
                            if (com.baidu.tbadk.o.a.gq(qVar.xN())) {
                                NewVcodeActivityConfig newVcodeActivityConfig = new NewVcodeActivityConfig(this.gaR.getPageContext().getPageActivity(), 12006, writeData, false, qVar.xN());
                                z2 = this.gaR.fZB;
                                if (z2) {
                                    newVcodeActivityConfig.setHideFeedBackButton();
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, newVcodeActivityConfig));
                                return;
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(this.gaR.getPageContext().getPageActivity(), writeData, 12006)));
                            return;
                        } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(this.gaR.getActivity(), 12006, writeData, postWriteCallBackData.getAccessState())));
                            return;
                        } else {
                            return;
                        }
                    }
                    this.gaR.a(false, postWriteCallBackData);
                    return;
                }
                this.gaR.bI(z);
                writeData3 = this.gaR.mData;
                if (writeData3.getType() == 0) {
                    writeData15 = this.gaR.mData;
                }
                this.gaR.a(true, postWriteCallBackData);
                writeData4 = this.gaR.mData;
                if (writeData4.getType() != 0) {
                    writeData5 = this.gaR.mData;
                    if (writeData5.getType() != 7) {
                        writeData6 = this.gaR.mData;
                        if (writeData6.getType() == 1) {
                            writeData11 = this.gaR.mData;
                            com.baidu.tieba.tbadkCore.x.c(writeData11.getThreadId(), (WriteData) null);
                        } else {
                            writeData7 = this.gaR.mData;
                            if (writeData7.getType() == 4) {
                                writeData10 = this.gaR.mData;
                                com.baidu.tieba.tbadkCore.x.b(String.valueOf(writeData10.getForumId()) + "photolive", (WriteData) null);
                                if (postWriteCallBackData != null) {
                                    this.gaR.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig(this.gaR.getPageContext().getPageActivity()).createNormalCfg(postWriteCallBackData.getThreadId(), postWriteCallBackData.getPostId(), null, PhotoLiveActivityConfig.KEY_FROM_WRITE, 18003)));
                                }
                            } else {
                                writeData8 = this.gaR.mData;
                                if (writeData8.getType() == 5) {
                                    writeData9 = this.gaR.mData;
                                    com.baidu.tieba.tbadkCore.x.c(String.valueOf(writeData9.getThreadId()) + "updatephotolive", (WriteData) null);
                                }
                            }
                        }
                    } else if (this.gaR.getIntent().getBooleanExtra(WriteActivityConfig.IS_SAVE_DRAFTE, true)) {
                        com.baidu.tieba.tbadkCore.x.b("24591571", (WriteData) null);
                    }
                } else {
                    if (this.gaR.getIntent().getBooleanExtra(WriteActivityConfig.IS_SAVE_DRAFTE, true)) {
                        writeData14 = this.gaR.mData;
                        com.baidu.tieba.tbadkCore.x.b(writeData14.getForumId(), (WriteData) null);
                        if (postWriteCallBackData.getIsCopyTWZhibo() == 3) {
                            this.gaR.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig(this.gaR.getPageContext().getPageActivity()).createNormalCfg(postWriteCallBackData.getThreadId(), postWriteCallBackData.getPostId(), null, PhotoLiveActivityConfig.KEY_FROM_WRITE_TARGET, 18003)));
                        }
                    }
                    list = this.gaR.mList;
                    if (!com.baidu.tbadk.core.util.x.r(list)) {
                        str = this.gaR.gaF;
                        if (!StringUtils.isNull(str)) {
                            com.baidu.tbadk.core.util.as asVar = new com.baidu.tbadk.core.util.as("c11731");
                            str2 = this.gaR.gaF;
                            TiebaStatic.log(asVar.Z("obj_id", str2));
                        }
                    }
                }
                this.gaR.c(postWriteCallBackData);
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                intent.putExtras(bundle);
                this.gaR.setResult(-1, intent);
                this.gaR.finish();
                writeData12 = this.gaR.mData;
                if (writeData12.getType() == 0) {
                    writeData13 = this.gaR.mData;
                    if (!writeData13.isUserFeedback()) {
                        PbActivityConfig createNormalCfg = new PbActivityConfig(TbadkCoreApplication.m9getInst().getContext()).createNormalCfg(postWriteCallBackData.getThreadId(), null, null);
                        createNormalCfg.setNeedRepostRecommendForum(true);
                        createNormalCfg.setPostThreadTip(postWriteCallBackData.getErrorString());
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                    }
                }
            }
        }
    }
}
