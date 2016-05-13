package com.baidu.tieba.write.video;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.MotuVideoConfig;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.a;
/* loaded from: classes.dex */
class g implements a.d {
    final /* synthetic */ WriteVideoActivity faD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(WriteVideoActivity writeVideoActivity) {
        this.faD = writeVideoActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.a.d
    public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.o oVar, WriteData writeData, AntiData antiData) {
        WriteData writeData2;
        WriteData writeData3;
        WriteData writeData4;
        WriteData writeData5;
        this.faD.closeLoadingDialog();
        if (postWriteCallBackData != null) {
            writeData2 = this.faD.evE;
            if (writeData2 != null) {
                boolean z2 = com.baidu.tbadk.core.sharedPref.b.sR().getBoolean(MotuVideoConfig.IS_SINGLE_GOD_USER, false);
                writeData3 = this.faD.evE;
                if (writeData3 != null) {
                    writeData4 = this.faD.evE;
                    if (writeData4.getVideoInfo() != null && writeData != null) {
                        if (!z2) {
                            writeData5 = this.faD.evE;
                            if (writeData5.getVideoInfo().getVideoDuration() > 8) {
                                writeData.setVideoReviewType(1);
                            }
                        }
                        writeData.setVideoReviewType(2);
                    }
                }
                if (!z) {
                    if (oVar != null && writeData != null && oVar.getVcode_pic_url() != null) {
                        if (!AntiHelper.g(antiData)) {
                            writeData.setVcodeMD5(oVar.getVcode_md5());
                            writeData.setVcodeUrl(oVar.getVcode_pic_url());
                            if ("4".equals(oVar.wG())) {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(this.faD.getPageContext().getPageActivity(), 12006, writeData, false)));
                                return;
                            } else {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(this.faD.getPageContext().getPageActivity(), writeData, 12006)));
                                return;
                            }
                        }
                        this.faD.a(false, postWriteCallBackData);
                        return;
                    }
                    this.faD.a(false, postWriteCallBackData);
                    return;
                }
                this.faD.bcA();
                if (writeData != null) {
                    if (writeData.getVideoReviewType() == 1) {
                        postWriteCallBackData.setErrorString(this.faD.getPageContext().getPageActivity().getString(t.j.video_send_success_under_review));
                    } else {
                        postWriteCallBackData.setErrorString(this.faD.getPageContext().getPageActivity().getString(t.j.video_send_success));
                    }
                }
                this.faD.a(true, postWriteCallBackData);
                this.faD.b(postWriteCallBackData);
            }
        }
    }
}
