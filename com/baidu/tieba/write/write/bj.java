package com.baidu.tieba.write.write;

import com.baidu.tbadk.coreExtra.data.WriteData;
import java.util.Date;
/* loaded from: classes.dex */
class bj implements Runnable {
    final /* synthetic */ WriteActivity dYD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(WriteActivity writeActivity) {
        this.dYD = writeActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tieba.view.a aVar;
        WriteData writeData;
        WriteData writeData2;
        WriteData writeData3;
        com.baidu.tieba.view.a aVar2;
        aVar = this.dYD.dYC;
        if (aVar != null) {
            writeData = this.dYD.dJy;
            if (writeData != null) {
                writeData2 = this.dYD.dJy;
                if (writeData2.getLiveCardData() != null) {
                    writeData3 = this.dYD.dJy;
                    Date date = new Date(writeData3.getLiveCardData().getStartTime() * 1000);
                    aVar2 = this.dYD.dYC;
                    aVar2.updateTime(date.getHours(), date.getMinutes());
                }
            }
        }
    }
}
