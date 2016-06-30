package com.baidu.tieba.write.video;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
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
    final /* synthetic */ WriteVideoActivity fGf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(WriteVideoActivity writeVideoActivity) {
        this.fGf = writeVideoActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.a.d
    public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, p pVar, WriteData writeData, AntiData antiData) {
        WriteData writeData2;
        WriteData writeData3;
        WriteData writeData4;
        WriteData writeData5;
        this.fGf.closeLoadingDialog();
        if (postWriteCallBackData != null) {
            writeData2 = this.fGf.fau;
            if (writeData2 != null) {
                boolean z2 = com.baidu.tbadk.core.sharedPref.b.sO().getBoolean(MotuVideoConfig.IS_SINGLE_GOD_USER, false);
                writeData3 = this.fGf.fau;
                if (writeData3 != null) {
                    writeData4 = this.fGf.fau;
                    if (writeData4.getVideoInfo() != null && writeData != null) {
                        if (!z2) {
                            writeData5 = this.fGf.fau;
                            if (writeData5.getVideoInfo().getVideoDuration() > 8) {
                                writeData.setVideoReviewType(1);
                            }
                        }
                        writeData.setVideoReviewType(2);
                    }
                }
                if (!z) {
                    if (pVar != null && writeData != null && pVar.getVcode_pic_url() != null) {
                        if (!AntiHelper.g(antiData)) {
                            writeData.setVcodeMD5(pVar.getVcode_md5());
                            writeData.setVcodeUrl(pVar.getVcode_pic_url());
                            writeData.setVcodeExtra(pVar.wK());
                            if (com.baidu.tbadk.k.a.gA(pVar.wJ())) {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(this.fGf.getPageContext().getPageActivity(), 12006, writeData, false, pVar.wJ())));
                                return;
                            } else {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(this.fGf.getPageContext().getPageActivity(), writeData, 12006)));
                                return;
                            }
                        }
                        this.fGf.a(false, postWriteCallBackData);
                        return;
                    }
                    this.fGf.a(false, postWriteCallBackData);
                    return;
                }
                this.fGf.bkY();
                if (writeData != null) {
                    if (writeData.getVideoReviewType() == 1) {
                        postWriteCallBackData.setErrorString(this.fGf.getPageContext().getPageActivity().getString(u.j.video_send_success_under_review));
                    } else {
                        postWriteCallBackData.setErrorString(this.fGf.getPageContext().getPageActivity().getString(u.j.video_send_success));
                    }
                }
                this.fGf.a(true, postWriteCallBackData);
                this.fGf.b(postWriteCallBackData);
            }
        }
    }
}
