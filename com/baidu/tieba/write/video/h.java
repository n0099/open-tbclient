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
import com.baidu.tbadk.coreExtra.data.q;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes.dex */
class h implements NewWriteModel.d {
    final /* synthetic */ WriteVideoActivity gir;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(WriteVideoActivity writeVideoActivity) {
        this.gir = writeVideoActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
    public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, q qVar, WriteData writeData, AntiData antiData) {
        WriteData writeData2;
        WriteData writeData3;
        WriteData writeData4;
        WriteData writeData5;
        this.gir.closeLoadingDialog();
        if (postWriteCallBackData != null) {
            writeData2 = this.gir.mData;
            if (writeData2 != null) {
                boolean z2 = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(MotuVideoConfig.IS_SINGLE_GOD_USER, false);
                writeData3 = this.gir.mData;
                if (writeData3 != null) {
                    writeData4 = this.gir.mData;
                    if (writeData4.getVideoInfo() != null && writeData != null) {
                        if (!z2) {
                            writeData5 = this.gir.mData;
                            if (writeData5.getVideoInfo().getVideoDuration() > 8) {
                                writeData.setVideoReviewType(1);
                            }
                        }
                        writeData.setVideoReviewType(2);
                    }
                }
                if (!z) {
                    if ((qVar != null && writeData != null && qVar.getVcode_pic_url() != null && !AntiHelper.h(antiData)) || postWriteCallBackData == null || postWriteCallBackData.getErrorCode() == 227001) {
                        if (qVar != null && writeData != null && qVar.getVcode_pic_url() != null) {
                            writeData.setVcodeMD5(qVar.getVcode_md5());
                            writeData.setVcodeUrl(qVar.getVcode_pic_url());
                            writeData.setVcodeExtra(qVar.yf());
                            if (com.baidu.tbadk.o.a.gN(qVar.ye())) {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(this.gir.getPageContext().getPageActivity(), 12006, writeData, false, qVar.ye())));
                                return;
                            } else {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(this.gir.getPageContext().getPageActivity(), writeData, 12006)));
                                return;
                            }
                        } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(this.gir.getActivity(), 12006, writeData, postWriteCallBackData.getAccessState())));
                            return;
                        } else {
                            return;
                        }
                    }
                    this.gir.a(false, postWriteCallBackData);
                    return;
                }
                this.gir.bta();
                this.gir.a(true, postWriteCallBackData);
                this.gir.b(postWriteCallBackData);
            }
        }
    }
}
