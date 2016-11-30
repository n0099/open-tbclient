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
    final /* synthetic */ WriteActivity gpp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(WriteActivity writeActivity) {
        this.gpp = writeActivity;
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
        List list;
        String str;
        String str2;
        WriteData writeData12;
        this.gpp.acp();
        this.gpp.closeLoadingDialog();
        if (postWriteCallBackData != null) {
            writeData2 = this.gpp.fst;
            if (writeData2 != null) {
                if (!z) {
                    if ((sVar != null && writeData != null && sVar.getVcode_pic_url() != null && !AntiHelper.g(antiData)) || postWriteCallBackData == null || postWriteCallBackData.getErrorCode() == 227001) {
                        if (sVar != null && writeData != null && sVar.getVcode_pic_url() != null) {
                            writeData.setVcodeMD5(sVar.getVcode_md5());
                            writeData.setVcodeUrl(sVar.getVcode_pic_url());
                            writeData.setVcodeExtra(sVar.yd());
                            if (com.baidu.tbadk.j.a.gG(sVar.yc())) {
                                NewVcodeActivityConfig newVcodeActivityConfig = new NewVcodeActivityConfig(this.gpp.getPageContext().getPageActivity(), 12006, writeData, false, sVar.yc());
                                z2 = this.gpp.gof;
                                if (z2) {
                                    newVcodeActivityConfig.setHideFeedBackButton();
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, newVcodeActivityConfig));
                                return;
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(this.gpp.getPageContext().getPageActivity(), writeData, 12006)));
                            return;
                        } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(this.gpp.getActivity(), 12006, writeData, postWriteCallBackData.getAccessState())));
                            return;
                        } else {
                            return;
                        }
                    }
                    this.gpp.a(false, postWriteCallBackData);
                    return;
                }
                this.gpp.bJ(z);
                this.gpp.a(true, postWriteCallBackData);
                writeData3 = this.gpp.fst;
                if (writeData3.getType() != 0) {
                    writeData4 = this.gpp.fst;
                    if (writeData4.getType() == 1) {
                        writeData11 = this.gpp.fst;
                        com.baidu.tieba.tbadkCore.ad.c(writeData11.getThreadId(), (WriteData) null);
                    } else {
                        writeData5 = this.gpp.fst;
                        if (writeData5.getType() == 4) {
                            writeData10 = this.gpp.fst;
                            com.baidu.tieba.tbadkCore.ad.b(String.valueOf(writeData10.getForumId()) + "photolive", (WriteData) null);
                            if (postWriteCallBackData != null) {
                                this.gpp.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig(this.gpp.getPageContext().getPageActivity()).createNormalCfg(postWriteCallBackData.getThreadId(), postWriteCallBackData.getPostId(), null, PhotoLiveActivityConfig.KEY_FROM_WRITE, 18003)));
                            }
                        } else {
                            writeData6 = this.gpp.fst;
                            if (writeData6.getType() == 5) {
                                writeData9 = this.gpp.fst;
                                com.baidu.tieba.tbadkCore.ad.c(String.valueOf(writeData9.getThreadId()) + "updatephotolive", (WriteData) null);
                            } else {
                                writeData7 = this.gpp.fst;
                                if (writeData7.getType() == 7) {
                                    writeData8 = this.gpp.fst;
                                    com.baidu.tieba.tbadkCore.ad.b(writeData8.getForumId(), (WriteData) null);
                                }
                            }
                        }
                    }
                } else {
                    if (this.gpp.getIntent().getBooleanExtra(WriteActivityConfig.IS_SAVE_DRAFTE, true)) {
                        writeData12 = this.gpp.fst;
                        com.baidu.tieba.tbadkCore.ad.b(writeData12.getForumId(), (WriteData) null);
                        if (postWriteCallBackData.getIsCopyTWZhibo() == 3) {
                            this.gpp.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig(this.gpp.getPageContext().getPageActivity()).createNormalCfg(postWriteCallBackData.getThreadId(), postWriteCallBackData.getPostId(), null, PhotoLiveActivityConfig.KEY_FROM_WRITE_TARGET, 18003)));
                        }
                    }
                    list = this.gpp.mList;
                    if (!com.baidu.tbadk.core.util.x.t(list)) {
                        str = this.gpp.gpe;
                        if (!StringUtils.isNull(str)) {
                            com.baidu.tbadk.core.util.av avVar = new com.baidu.tbadk.core.util.av("c11731");
                            str2 = this.gpp.gpe;
                            TiebaStatic.log(avVar.ab("obj_id", str2));
                        }
                    }
                }
                this.gpp.c(postWriteCallBackData);
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                intent.putExtras(bundle);
                this.gpp.setResult(-1, intent);
                this.gpp.finish();
            }
        }
    }
}
