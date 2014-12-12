package com.baidu.tieba.write;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
class an implements com.baidu.tieba.tbadkCore.f.c {
    final /* synthetic */ WriteActivity cft;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(WriteActivity writeActivity) {
        this.cft = writeActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.f.c
    public void a(boolean z, com.baidu.tieba.tbadkCore.f.f fVar, com.baidu.tbadk.coreExtra.data.j jVar, WriteData writeData, AntiData antiData) {
        WriteData writeData2;
        WriteData writeData3;
        WriteData writeData4;
        WriteData writeData5;
        WriteData writeData6;
        WriteData writeData7;
        WriteData writeData8;
        WriteData writeData9;
        this.cft.stopVoice();
        this.cft.closeLoadingDialog();
        String str = "";
        if (fVar != null) {
            str = fVar.getErrorString();
        }
        if (!z) {
            if (jVar != null && writeData != null && jVar.getVcode_pic_url() != null) {
                if (!AntiHelper.e(antiData)) {
                    writeData.setVcodeMD5(jVar.getVcode_md5());
                    writeData.setVcodeUrl(jVar.getVcode_pic_url());
                    if (jVar.rD().equals("4")) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(this.cft.getPageContext().getPageActivity(), 12006, writeData, false)));
                        return;
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(this.cft.getPageContext().getPageActivity(), writeData, 12006)));
                        return;
                    }
                }
                this.cft.a(false, antiData, str);
                return;
            }
            this.cft.a(false, antiData, str);
            return;
        }
        this.cft.a(true, antiData, fVar);
        writeData2 = this.cft.bNF;
        if (writeData2.getType() == 0) {
            writeData7 = this.cft.bNF;
            if (writeData7.getLiveCardData() == null) {
                writeData9 = this.cft.bNF;
                com.baidu.tieba.tbadkCore.al.a(writeData9.getForumId(), (WriteData) null);
            } else {
                writeData8 = this.cft.bNF;
                com.baidu.tieba.tbadkCore.al.a(writeData8.getLiveCardData().getGroupId(), (WriteData) null);
            }
        } else {
            writeData3 = this.cft.bNF;
            if (writeData3.getType() == 1) {
                writeData4 = this.cft.bNF;
                com.baidu.tieba.tbadkCore.al.b(writeData4.getThreadId(), (WriteData) null);
            }
        }
        writeData5 = this.cft.bNF;
        if (writeData5.getLiveCardData() != null) {
            WriteActivity writeActivity = this.cft;
            FrsActivityConfig frsActivityConfig = new FrsActivityConfig(this.cft.getPageContext().getPageActivity());
            writeData6 = this.cft.bNF;
            writeActivity.sendMessage(new CustomMessage(2003001, frsActivityConfig.createRefreshCfgShowContent(writeData6.getForumName(), "post live's thread")));
        }
        this.cft.setResult(-1);
        this.cft.finish();
    }
}
