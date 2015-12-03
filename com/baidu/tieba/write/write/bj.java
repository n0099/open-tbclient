package com.baidu.tieba.write.write;

import com.baidu.tbadk.coreExtra.data.WriteData;
import java.util.Date;
/* loaded from: classes.dex */
class bj implements Runnable {
    final /* synthetic */ WriteActivity dRf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(WriteActivity writeActivity) {
        this.dRf = writeActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tieba.view.a aVar;
        WriteData writeData;
        WriteData writeData2;
        WriteData writeData3;
        com.baidu.tieba.view.a aVar2;
        aVar = this.dRf.dRe;
        if (aVar != null) {
            writeData = this.dRf.dBW;
            if (writeData != null) {
                writeData2 = this.dRf.dBW;
                if (writeData2.getLiveCardData() != null) {
                    writeData3 = this.dRf.dBW;
                    Date date = new Date(writeData3.getLiveCardData().getStartTime() * 1000);
                    aVar2 = this.dRf.dRe;
                    aVar2.updateTime(date.getHours(), date.getMinutes());
                }
            }
        }
    }
}
