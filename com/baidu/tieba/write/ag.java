package com.baidu.tieba.write;

import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.util.AntiHelper;
/* loaded from: classes.dex */
final class ag implements com.baidu.tieba.model.as {
    final /* synthetic */ WriteActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(WriteActivity writeActivity) {
        this.a = writeActivity;
    }

    @Override // com.baidu.tieba.model.as
    public final void a(boolean z, String str, com.baidu.tbadk.coreExtra.data.f fVar, WriteData writeData, AntiData antiData) {
        WriteData writeData2;
        WriteData writeData3;
        WriteData writeData4;
        WriteData writeData5;
        WriteActivity.a(this.a);
        this.a.closeLoadingDialog();
        if (z) {
            WriteActivity.a(this.a, antiData, str);
            writeData2 = this.a.a;
            if (writeData2.getType() == 0) {
                writeData5 = this.a.a;
                com.baidu.tieba.util.m.a(writeData5.getForumId(), (WriteData) null);
            } else {
                writeData3 = this.a.a;
                if (writeData3.getType() == 1) {
                    writeData4 = this.a.a;
                    com.baidu.tieba.util.m.b(writeData4.getThreadId(), (WriteData) null);
                }
            }
            this.a.setResult(-1);
            this.a.finish();
        } else if (fVar == null || writeData == null || fVar.b() == null) {
            WriteActivity.a(this.a, antiData, str);
        } else if (AntiHelper.c(antiData)) {
            WriteActivity.a(this.a, antiData, str);
        } else {
            writeData.setVcodeMD5(fVar.a());
            writeData.setVcodeUrl(fVar.b());
            if (fVar.c().equals("4")) {
                com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001001, new com.baidu.tbadk.core.b.ac(this.a, 12006, writeData, false)));
            } else {
                com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001001, new com.baidu.tbadk.core.b.au(this.a, writeData, 12006)));
            }
        }
    }
}
