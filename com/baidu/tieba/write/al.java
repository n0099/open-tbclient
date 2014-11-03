package com.baidu.tieba.write;

import android.app.TimePickerDialog;
import android.widget.TextView;
import android.widget.TimePicker;
import com.baidu.tbadk.coreExtra.data.WriteData;
import java.util.Date;
/* loaded from: classes.dex */
class al implements TimePickerDialog.OnTimeSetListener {
    final /* synthetic */ WriteActivity bUm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(WriteActivity writeActivity) {
        this.bUm = writeActivity;
    }

    @Override // android.app.TimePickerDialog.OnTimeSetListener
    public void onTimeSet(TimePicker timePicker, int i, int i2) {
        WriteData writeData;
        WriteData writeData2;
        WriteData writeData3;
        WriteData writeData4;
        TextView textView;
        WriteData writeData5;
        WriteData writeData6;
        writeData = this.bUm.bpJ;
        if (writeData.getLiveCardData() != null) {
            Date date = new Date();
            Date date2 = new Date(date.getYear(), date.getMonth(), date.getDate(), i, i2);
            writeData2 = this.bUm.bpJ;
            long startTime = writeData2.getLiveCardData().getStartTime();
            writeData3 = this.bUm.bpJ;
            writeData3.getLiveCardData().setStartTime(date2.getTime() / 1000);
            writeData4 = this.bUm.bpJ;
            if (startTime / 60 != writeData4.getLiveCardData().getStartTime() / 60) {
                writeData6 = this.bUm.bpJ;
                writeData6.getLiveCardData().setModifyTime(true);
            }
            textView = this.bUm.bUd;
            writeData5 = this.bUm.bpJ;
            textView.setText(com.baidu.tbadk.core.util.az.k(writeData5.getLiveCardData().getStartTime() * 1000));
        }
    }
}
