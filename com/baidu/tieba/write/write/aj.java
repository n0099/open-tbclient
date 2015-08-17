package com.baidu.tieba.write.write;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PhotoLiveCoverData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.a;
/* loaded from: classes.dex */
class aj implements a.d {
    final /* synthetic */ WriteActivity cUM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(WriteActivity writeActivity) {
        this.cUM = writeActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.a.d
    public void a(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.l lVar, WriteData writeData, AntiData antiData) {
        WriteData writeData2;
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
        WriteData writeData14;
        WriteData writeData15;
        WriteData writeData16;
        WriteData writeData17;
        WriteData writeData18;
        this.cUM.stopVoice();
        this.cUM.closeLoadingDialog();
        String str = "";
        if (postWriteCallBackData != null) {
            str = postWriteCallBackData.getErrorString();
        }
        if (!z) {
            if (lVar != null && writeData != null && lVar.getVcode_pic_url() != null) {
                if (!AntiHelper.f(antiData)) {
                    writeData.setVcodeMD5(lVar.getVcode_md5());
                    writeData.setVcodeUrl(lVar.getVcode_pic_url());
                    if (lVar.wC().equals("4")) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(this.cUM.getPageContext().getPageActivity(), 12006, writeData, false)));
                        return;
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(this.cUM.getPageContext().getPageActivity(), writeData, 12006)));
                        return;
                    }
                }
                this.cUM.a(false, antiData, str);
                return;
            }
            this.cUM.a(false, antiData, str);
            return;
        }
        this.cUM.bb(z);
        this.cUM.a(true, antiData, postWriteCallBackData);
        if (writeData != null && writeData.getVideoInfo() != null && postWriteCallBackData != null) {
            XiaoyingUtil.reportEvent(postWriteCallBackData.getThreadId(), postWriteCallBackData.getPostId(), writeData.getForumId(), writeData.getVideoInfo().getVideoUrl(), writeData.getForumName());
        }
        writeData2 = this.cUM.cKS;
        if (writeData2.getType() == 0) {
            writeData16 = this.cUM.cKS;
            if (writeData16.getLiveCardData() == null) {
                writeData18 = this.cUM.cKS;
                com.baidu.tieba.tbadkCore.ac.b(writeData18.getForumId(), (WriteData) null);
            } else {
                writeData17 = this.cUM.cKS;
                com.baidu.tieba.tbadkCore.ac.a(writeData17.getLiveCardData().getGroupId(), (WriteData) null);
            }
        } else {
            writeData3 = this.cUM.cKS;
            if (writeData3.getType() == 1) {
                writeData13 = this.cUM.cKS;
                com.baidu.tieba.tbadkCore.ac.c(writeData13.getThreadId(), (WriteData) null);
            } else {
                writeData4 = this.cUM.cKS;
                if (writeData4.getType() == 4) {
                    writeData7 = this.cUM.cKS;
                    com.baidu.tieba.tbadkCore.ac.b(String.valueOf(writeData7.getForumId()) + "photolive", (WriteData) null);
                    PhotoLiveCoverData photoLiveCoverData = new PhotoLiveCoverData();
                    AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                    if (currentAccountObj != null) {
                        writeData8 = this.cUM.cKS;
                        if (writeData8 != null) {
                            MetaData metaData = new MetaData();
                            metaData.setUserName(currentAccountObj.getAccount());
                            metaData.setPortrait(currentAccountObj.getPortrait());
                            metaData.setUserId(currentAccountObj.getID());
                            photoLiveCoverData.setAuthor(metaData);
                            writeData9 = this.cUM.cKS;
                            photoLiveCoverData.setForumName(writeData9.getForumName());
                            writeData10 = this.cUM.cKS;
                            photoLiveCoverData.setThreadTitle(writeData10.getTitle());
                            photoLiveCoverData.setThreadID(postWriteCallBackData.getThreadId());
                            writeData11 = this.cUM.cKS;
                            if (writeData11.getPhotoLiveCoverUlrData() != null) {
                                writeData12 = this.cUM.cKS;
                                photoLiveCoverData.setPhotoLiveCover(writeData12.getPhotoLiveCoverUlrData().getBigurl());
                            }
                        }
                    }
                    this.cUM.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig(this.cUM.getPageContext().getPageActivity()).createNormalCfg(postWriteCallBackData.getThreadId(), postWriteCallBackData.getPostId(), null, PhotoLiveActivityConfig.KEY_FROM_WRITE, 18003, photoLiveCoverData)));
                } else {
                    writeData5 = this.cUM.cKS;
                    if (writeData5.getType() == 5) {
                        writeData6 = this.cUM.cKS;
                        com.baidu.tieba.tbadkCore.ac.c(String.valueOf(writeData6.getThreadId()) + "updatephotolive", (WriteData) null);
                    }
                }
            }
        }
        writeData14 = this.cUM.cKS;
        if (writeData14.getLiveCardData() != null) {
            WriteActivity writeActivity = this.cUM;
            FrsActivityConfig frsActivityConfig = new FrsActivityConfig(this.cUM.getPageContext().getPageActivity());
            writeData15 = this.cUM.cKS;
            writeActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_REFRESH, frsActivityConfig.createRefreshCfgShowContent(writeData15.getForumName(), "post live's thread")));
        }
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
        intent.putExtras(bundle);
        this.cUM.setResult(-1, intent);
        this.cUM.finish();
    }
}
