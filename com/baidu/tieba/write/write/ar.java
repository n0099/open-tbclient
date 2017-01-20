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
class ar implements NewWriteModel.d {
    final /* synthetic */ WriteActivity fMl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(WriteActivity writeActivity) {
        this.fMl = writeActivity;
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
        List list;
        String str;
        String str2;
        WriteData writeData10;
        this.fMl.XU();
        this.fMl.closeLoadingDialog();
        if (postWriteCallBackData != null) {
            writeData2 = this.fMl.mData;
            if (writeData2 != null) {
                if (!z) {
                    if ((qVar != null && writeData != null && qVar.getVcode_pic_url() != null && !AntiHelper.h(antiData)) || postWriteCallBackData == null || postWriteCallBackData.getErrorCode() == 227001) {
                        if (qVar != null && writeData != null && qVar.getVcode_pic_url() != null) {
                            writeData.setVcodeMD5(qVar.getVcode_md5());
                            writeData.setVcodeUrl(qVar.getVcode_pic_url());
                            writeData.setVcodeExtra(qVar.xN());
                            if (com.baidu.tbadk.j.a.gy(qVar.xM())) {
                                NewVcodeActivityConfig newVcodeActivityConfig = new NewVcodeActivityConfig(this.fMl.getPageContext().getPageActivity(), 12006, writeData, false, qVar.xM());
                                z2 = this.fMl.fLc;
                                if (z2) {
                                    newVcodeActivityConfig.setHideFeedBackButton();
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, newVcodeActivityConfig));
                                return;
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(this.fMl.getPageContext().getPageActivity(), writeData, 12006)));
                            return;
                        } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(this.fMl.getActivity(), 12006, writeData, postWriteCallBackData.getAccessState())));
                            return;
                        } else {
                            return;
                        }
                    }
                    this.fMl.a(false, postWriteCallBackData);
                    return;
                }
                this.fMl.bJ(z);
                this.fMl.a(true, postWriteCallBackData);
                writeData3 = this.fMl.mData;
                if (writeData3.getType() != 0) {
                    writeData4 = this.fMl.mData;
                    if (writeData4.getType() == 1) {
                        writeData9 = this.fMl.mData;
                        com.baidu.tieba.tbadkCore.aa.c(writeData9.getThreadId(), (WriteData) null);
                    } else {
                        writeData5 = this.fMl.mData;
                        if (writeData5.getType() == 4) {
                            writeData8 = this.fMl.mData;
                            com.baidu.tieba.tbadkCore.aa.b(String.valueOf(writeData8.getForumId()) + "photolive", (WriteData) null);
                            if (postWriteCallBackData != null) {
                                this.fMl.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig(this.fMl.getPageContext().getPageActivity()).createNormalCfg(postWriteCallBackData.getThreadId(), postWriteCallBackData.getPostId(), null, PhotoLiveActivityConfig.KEY_FROM_WRITE, 18003)));
                            }
                        } else {
                            writeData6 = this.fMl.mData;
                            if (writeData6.getType() == 5) {
                                writeData7 = this.fMl.mData;
                                com.baidu.tieba.tbadkCore.aa.c(String.valueOf(writeData7.getThreadId()) + "updatephotolive", (WriteData) null);
                            }
                        }
                    }
                } else {
                    if (this.fMl.getIntent().getBooleanExtra(WriteActivityConfig.IS_SAVE_DRAFTE, true)) {
                        writeData10 = this.fMl.mData;
                        com.baidu.tieba.tbadkCore.aa.b(writeData10.getForumId(), (WriteData) null);
                        if (postWriteCallBackData.getIsCopyTWZhibo() == 3) {
                            this.fMl.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig(this.fMl.getPageContext().getPageActivity()).createNormalCfg(postWriteCallBackData.getThreadId(), postWriteCallBackData.getPostId(), null, PhotoLiveActivityConfig.KEY_FROM_WRITE_TARGET, 18003)));
                        }
                    }
                    list = this.fMl.mList;
                    if (!com.baidu.tbadk.core.util.w.s(list)) {
                        str = this.fMl.fMa;
                        if (!StringUtils.isNull(str)) {
                            com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c11731");
                            str2 = this.fMl.fMa;
                            TiebaStatic.log(arVar.ab("obj_id", str2));
                        }
                    }
                }
                this.fMl.c(postWriteCallBackData);
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                intent.putExtras(bundle);
                this.fMl.setResult(-1, intent);
                this.fMl.finish();
            }
        }
    }
}
