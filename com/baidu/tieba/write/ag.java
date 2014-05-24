package com.baidu.tieba.write;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.util.AntiHelper;
/* loaded from: classes.dex */
class ag implements com.baidu.tieba.model.as {
    final /* synthetic */ WriteActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(WriteActivity writeActivity) {
        this.a = writeActivity;
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
        this.a.C();
        this.a.closeLoadingDialog();
        if (!z) {
            if (fVar != null && writeData != null && fVar.b() != null) {
                if (!AntiHelper.c(antiData)) {
                    writeData.setVcodeMD5(fVar.a());
                    writeData.setVcodeUrl(fVar.b());
                    if (fVar.c().equals("4")) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003001, new com.baidu.tbadk.core.atomData.ap(this.a, 12006, writeData, false)));
                        return;
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003001, new com.baidu.tbadk.core.atomData.bh(this.a, writeData, 12006)));
                        return;
                    }
                }
                this.a.a(antiData, str);
                return;
            }
            this.a.a(antiData, str);
            return;
        }
        this.a.a(antiData, str);
        writeData2 = this.a.a;
        if (writeData2.getType() == 0) {
            writeData7 = this.a.a;
            if (writeData7.getLiveCardData() == null) {
                writeData9 = this.a.a;
                com.baidu.tieba.util.m.a(writeData9.getForumId(), (WriteData) null);
            } else {
                writeData8 = this.a.a;
                com.baidu.tieba.util.m.a(writeData8.getLiveCardData().getGroupId(), (WriteData) null);
            }
        } else {
            writeData3 = this.a.a;
            if (writeData3.getType() == 1) {
                writeData4 = this.a.a;
                com.baidu.tieba.util.m.b(writeData4.getThreadId(), (WriteData) null);
            }
        }
        writeData5 = this.a.a;
        if (writeData5.getLiveCardData() != null) {
            WriteActivity writeActivity = this.a;
            com.baidu.tbadk.core.atomData.m mVar = new com.baidu.tbadk.core.atomData.m(this.a);
            writeData6 = this.a.a;
            writeActivity.sendMessage(new CustomMessage(2005001, mVar.c(writeData6.getForumName(), "post live's thread")));
        }
        this.a.setResult(-1);
        this.a.finish();
    }
}
