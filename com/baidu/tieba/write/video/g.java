package com.baidu.tieba.write.video;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.a;
import java.io.File;
/* loaded from: classes.dex */
class g implements a.d {
    final /* synthetic */ WriteVideoActivity epR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(WriteVideoActivity writeVideoActivity) {
        this.epR = writeVideoActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.a.d
    public void a(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.n nVar, WriteData writeData, AntiData antiData) {
        WriteData writeData2;
        WriteData writeData3;
        WriteData writeData4;
        WriteData writeData5;
        WriteData writeData6;
        this.epR.closeLoadingDialog();
        if (postWriteCallBackData != null) {
            writeData2 = this.epR.dZC;
            if (writeData2 != null) {
                if (z) {
                    writeData3 = this.epR.dZC;
                    if (writeData3 != null) {
                        writeData4 = this.epR.dZC;
                        if (writeData4.getVideoInfo() != null) {
                            writeData5 = this.epR.dZC;
                            VideoInfo videoInfo = writeData5.getVideoInfo();
                            if (videoInfo.getVideoType() == 2 && videoInfo.isCompressedVideo()) {
                                writeData6 = this.epR.dZC;
                                File file = new File(writeData6.getVideoInfo().getVideoPath());
                                if (file.exists() && file.isFile()) {
                                    file.delete();
                                }
                            }
                        }
                    }
                    this.epR.a(true, postWriteCallBackData);
                    this.epR.b(postWriteCallBackData);
                } else if (nVar != null && writeData != null && nVar.getVcode_pic_url() != null) {
                    if (!AntiHelper.h(antiData)) {
                        writeData.setVcodeMD5(nVar.getVcode_md5());
                        writeData.setVcodeUrl(nVar.getVcode_pic_url());
                        if ("4".equals(nVar.yl())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(this.epR.getPageContext().getPageActivity(), 12006, writeData, false)));
                            return;
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(this.epR.getPageContext().getPageActivity(), writeData, 12006)));
                            return;
                        }
                    }
                    this.epR.a(false, postWriteCallBackData);
                } else {
                    this.epR.a(false, postWriteCallBackData);
                }
            }
        }
    }
}
