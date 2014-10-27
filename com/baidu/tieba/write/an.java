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
    final /* synthetic */ WriteActivity bTX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(WriteActivity writeActivity) {
        this.bTX = writeActivity;
    }

    @Override // com.baidu.tieba.model.as
    public void a(boolean z, String str, com.baidu.tbadk.coreExtra.data.f fVar, WriteData writeData, AntiData antiData) {
        WriteData writeData2;
        WriteData writeData3;
        WriteData writeData4;
        WriteData writeData5;
        WriteData writeData6;
        WriteData writeData7;
        WriteData writeData8;
        WriteData writeData9;
        this.bTX.EA();
        this.bTX.closeLoadingDialog();
        if (!z) {
            if (fVar != null && writeData != null && fVar.getVcode_pic_url() != null) {
                if (!AntiHelper.e(antiData)) {
                    writeData.setVcodeMD5(fVar.getVcode_md5());
                    writeData.setVcodeUrl(fVar.getVcode_pic_url());
                    if (fVar.oA().equals("4")) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(this.bTX, 12006, writeData, false)));
                        return;
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(this.bTX, writeData, 12006)));
                        return;
                    }
                }
                this.bTX.b(antiData, str);
                return;
            }
            this.bTX.b(antiData, str);
            return;
        }
        this.bTX.b(antiData, str);
        writeData2 = this.bTX.bpv;
        if (writeData2.getType() == 0) {
            writeData7 = this.bTX.bpv;
            if (writeData7.getLiveCardData() == null) {
                writeData9 = this.bTX.bpv;
                com.baidu.tieba.util.l.a(writeData9.getForumId(), (WriteData) null);
            } else {
                writeData8 = this.bTX.bpv;
                com.baidu.tieba.util.l.a(writeData8.getLiveCardData().getGroupId(), (WriteData) null);
            }
        } else {
            writeData3 = this.bTX.bpv;
            if (writeData3.getType() == 1) {
                writeData4 = this.bTX.bpv;
                com.baidu.tieba.util.l.b(writeData4.getThreadId(), (WriteData) null);
            }
        }
        writeData5 = this.bTX.bpv;
        if (writeData5.getLiveCardData() != null) {
            WriteActivity writeActivity = this.bTX;
            FrsActivityConfig frsActivityConfig = new FrsActivityConfig(this.bTX);
            writeData6 = this.bTX.bpv;
            writeActivity.sendMessage(new CustomMessage(2003001, frsActivityConfig.createRefreshCfgShowContent(writeData6.getForumName(), "post live's thread")));
        }
        this.bTX.setResult(-1);
        this.bTX.finish();
    }
}
