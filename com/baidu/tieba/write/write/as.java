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
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.b;
import java.util.List;
/* loaded from: classes.dex */
class as implements b.d {
    final /* synthetic */ WriteActivity fDQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(WriteActivity writeActivity) {
        this.fDQ = writeActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.b.d
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
        this.fDQ.WD();
        this.fDQ.closeLoadingDialog();
        if (postWriteCallBackData != null) {
            writeData2 = this.fDQ.eWm;
            if (writeData2 != null) {
                if (!z) {
                    if ((qVar != null && writeData != null && qVar.getVcode_pic_url() != null && !AntiHelper.h(antiData)) || postWriteCallBackData == null || postWriteCallBackData.getErrorCode() == 227001) {
                        if (qVar != null && writeData != null && qVar.getVcode_pic_url() != null) {
                            writeData.setVcodeMD5(qVar.getVcode_md5());
                            writeData.setVcodeUrl(qVar.getVcode_pic_url());
                            writeData.setVcodeExtra(qVar.xR());
                            if (com.baidu.tbadk.j.a.gB(qVar.xQ())) {
                                NewVcodeActivityConfig newVcodeActivityConfig = new NewVcodeActivityConfig(this.fDQ.getPageContext().getPageActivity(), 12006, writeData, false, qVar.xQ());
                                z2 = this.fDQ.fCH;
                                if (z2) {
                                    newVcodeActivityConfig.setHideFeedBackButton();
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, newVcodeActivityConfig));
                                return;
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(this.fDQ.getPageContext().getPageActivity(), writeData, 12006)));
                            return;
                        } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(this.fDQ.getActivity(), 12006, writeData, postWriteCallBackData.getAccessState())));
                            return;
                        } else {
                            return;
                        }
                    }
                    this.fDQ.a(false, postWriteCallBackData);
                    return;
                }
                this.fDQ.bJ(z);
                this.fDQ.a(true, postWriteCallBackData);
                writeData3 = this.fDQ.eWm;
                if (writeData3.getType() != 0) {
                    writeData4 = this.fDQ.eWm;
                    if (writeData4.getType() == 1) {
                        writeData9 = this.fDQ.eWm;
                        com.baidu.tieba.tbadkCore.ac.c(writeData9.getThreadId(), (WriteData) null);
                    } else {
                        writeData5 = this.fDQ.eWm;
                        if (writeData5.getType() == 4) {
                            writeData8 = this.fDQ.eWm;
                            com.baidu.tieba.tbadkCore.ac.b(String.valueOf(writeData8.getForumId()) + "photolive", (WriteData) null);
                            if (postWriteCallBackData != null) {
                                this.fDQ.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig(this.fDQ.getPageContext().getPageActivity()).createNormalCfg(postWriteCallBackData.getThreadId(), postWriteCallBackData.getPostId(), null, PhotoLiveActivityConfig.KEY_FROM_WRITE, 18003)));
                            }
                        } else {
                            writeData6 = this.fDQ.eWm;
                            if (writeData6.getType() == 5) {
                                writeData7 = this.fDQ.eWm;
                                com.baidu.tieba.tbadkCore.ac.c(String.valueOf(writeData7.getThreadId()) + "updatephotolive", (WriteData) null);
                            }
                        }
                    }
                } else {
                    if (this.fDQ.getIntent().getBooleanExtra(WriteActivityConfig.IS_SAVE_DRAFTE, true)) {
                        writeData10 = this.fDQ.eWm;
                        com.baidu.tieba.tbadkCore.ac.b(writeData10.getForumId(), (WriteData) null);
                        if (postWriteCallBackData.getIsCopyTWZhibo() == 3) {
                            this.fDQ.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig(this.fDQ.getPageContext().getPageActivity()).createNormalCfg(postWriteCallBackData.getThreadId(), postWriteCallBackData.getPostId(), null, PhotoLiveActivityConfig.KEY_FROM_WRITE_TARGET, 18003)));
                        }
                    }
                    list = this.fDQ.mList;
                    if (!com.baidu.tbadk.core.util.x.t(list)) {
                        str = this.fDQ.fDF;
                        if (!StringUtils.isNull(str)) {
                            com.baidu.tbadk.core.util.at atVar = new com.baidu.tbadk.core.util.at("c11731");
                            str2 = this.fDQ.fDF;
                            TiebaStatic.log(atVar.ab("obj_id", str2));
                        }
                    }
                }
                this.fDQ.c(postWriteCallBackData);
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                intent.putExtras(bundle);
                this.fDQ.setResult(-1, intent);
                this.fDQ.finish();
            }
        }
    }
}
