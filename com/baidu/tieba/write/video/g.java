package com.baidu.tieba.write.video;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.MotuVideoConfig;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.p;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.a;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class g implements a.d {
    final /* synthetic */ WriteVideoActivity fSg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(WriteVideoActivity writeVideoActivity) {
        this.fSg = writeVideoActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.a.d
    public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, p pVar, WriteData writeData, AntiData antiData) {
        WriteData writeData2;
        WriteData writeData3;
        WriteData writeData4;
        WriteData writeData5;
        this.fSg.closeLoadingDialog();
        if (postWriteCallBackData != null) {
            writeData2 = this.fSg.faq;
            if (writeData2 != null) {
                boolean z2 = com.baidu.tbadk.core.sharedPref.b.sN().getBoolean(MotuVideoConfig.IS_SINGLE_GOD_USER, false);
                writeData3 = this.fSg.faq;
                if (writeData3 != null) {
                    writeData4 = this.fSg.faq;
                    if (writeData4.getVideoInfo() != null && writeData != null) {
                        if (!z2) {
                            writeData5 = this.fSg.faq;
                            if (writeData5.getVideoInfo().getVideoDuration() > 8) {
                                writeData.setVideoReviewType(1);
                            }
                        }
                        writeData.setVideoReviewType(2);
                    }
                }
                if (!z) {
                    if ((pVar != null && writeData != null && pVar.getVcode_pic_url() != null && !AntiHelper.g(antiData)) || postWriteCallBackData == null || postWriteCallBackData.getErrorCode() == 227001) {
                        if (pVar != null && writeData != null && pVar.getVcode_pic_url() != null) {
                            writeData.setVcodeMD5(pVar.getVcode_md5());
                            writeData.setVcodeUrl(pVar.getVcode_pic_url());
                            writeData.setVcodeExtra(pVar.wK());
                            if (com.baidu.tbadk.k.a.gz(pVar.wJ())) {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(this.fSg.getPageContext().getPageActivity(), 12006, writeData, false, pVar.wJ())));
                                return;
                            } else {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(this.fSg.getPageContext().getPageActivity(), writeData, 12006)));
                                return;
                            }
                        } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(this.fSg.getActivity(), 12006, writeData, postWriteCallBackData.getAccessState())));
                            return;
                        } else {
                            return;
                        }
                    }
                    this.fSg.a(false, postWriteCallBackData);
                    return;
                }
                this.fSg.bnU();
                if (writeData != null) {
                    if (writeData.getVideoReviewType() == 1) {
                        postWriteCallBackData.setErrorString(this.fSg.getPageContext().getPageActivity().getString(u.j.video_send_success_under_review));
                    } else {
                        postWriteCallBackData.setErrorString(this.fSg.getPageContext().getPageActivity().getString(u.j.video_send_success));
                    }
                }
                this.fSg.a(true, postWriteCallBackData);
                this.fSg.b(postWriteCallBackData);
            }
        }
    }
}
