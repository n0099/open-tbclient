package com.baidu.tieba.write;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.util.AntiHelper;
/* loaded from: classes.dex */
class an implements com.baidu.tieba.model.as {
    final /* synthetic */ WriteActivity bUm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(WriteActivity writeActivity) {
        this.bUm = writeActivity;
    }

    @Override // com.baidu.tieba.model.as
    public void a(boolean z, String str, com.baidu.tbadk.coreExtra.data.g gVar, WriteData writeData, AntiData antiData) {
        WriteData writeData2;
        WriteData writeData3;
        WriteData writeData4;
        WriteData writeData5;
        WriteData writeData6;
        WriteData writeData7;
        WriteData writeData8;
        WriteData writeData9;
        this.bUm.EC();
        this.bUm.closeLoadingDialog();
        if (!z) {
            if (gVar != null && writeData != null && gVar.getVcode_pic_url() != null) {
                if (!AntiHelper.e(antiData)) {
                    writeData.setVcodeMD5(gVar.getVcode_md5());
                    writeData.setVcodeUrl(gVar.getVcode_pic_url());
                    if (gVar.oC().equals("4")) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(this.bUm, 12006, writeData, false)));
                        return;
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(this.bUm, writeData, 12006)));
                        return;
                    }
                }
                this.bUm.a(false, antiData, str);
                return;
            }
            this.bUm.a(false, antiData, str);
            return;
        }
        this.bUm.a(true, antiData, str);
        writeData2 = this.bUm.bpJ;
        if (writeData2.getType() == 0) {
            writeData7 = this.bUm.bpJ;
            if (writeData7.getLiveCardData() == null) {
                writeData9 = this.bUm.bpJ;
                com.baidu.tieba.util.l.a(writeData9.getForumId(), (WriteData) null);
            } else {
                writeData8 = this.bUm.bpJ;
                com.baidu.tieba.util.l.a(writeData8.getLiveCardData().getGroupId(), (WriteData) null);
            }
        } else {
            writeData3 = this.bUm.bpJ;
            if (writeData3.getType() == 1) {
                writeData4 = this.bUm.bpJ;
                com.baidu.tieba.util.l.b(writeData4.getThreadId(), (WriteData) null);
            }
        }
        writeData5 = this.bUm.bpJ;
        if (writeData5.getLiveCardData() != null) {
            WriteActivity writeActivity = this.bUm;
            FrsActivityConfig frsActivityConfig = new FrsActivityConfig(this.bUm);
            writeData6 = this.bUm.bpJ;
            writeActivity.sendMessage(new CustomMessage(2003001, frsActivityConfig.createRefreshCfgShowContent(writeData6.getForumName(), "post live's thread")));
        }
        this.bUm.setResult(-1);
        this.bUm.finish();
    }
}
