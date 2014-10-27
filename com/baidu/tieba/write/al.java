package com.baidu.tieba.write;

import android.app.TimePickerDialog;
import android.widget.TextView;
import android.widget.TimePicker;
import com.baidu.tbadk.coreExtra.data.WriteData;
import java.util.Date;
/* loaded from: classes.dex */
class al implements TimePickerDialog.OnTimeSetListener {
    final /* synthetic */ WriteActivity bTX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(WriteActivity writeActivity) {
        this.bTX = writeActivity;
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
        writeData = this.bTX.bpv;
        if (writeData.getLiveCardData() != null) {
            Date date = new Date();
            Date date2 = new Date(date.getYear(), date.getMonth(), date.getDate(), i, i2);
            writeData2 = this.bTX.bpv;
            long startTime = writeData2.getLiveCardData().getStartTime();
            writeData3 = this.bTX.bpv;
            writeData3.getLiveCardData().setStartTime(date2.getTime() / 1000);
            writeData4 = this.bTX.bpv;
            if (startTime / 60 != writeData4.getLiveCardData().getStartTime() / 60) {
                writeData6 = this.bTX.bpv;
                writeData6.getLiveCardData().setModifyTime(true);
            }
            textView = this.bTX.bTO;
            writeData5 = this.bTX.bpv;
            textView.setText(com.baidu.tbadk.core.util.ay.k(writeData5.getLiveCardData().getStartTime() * 1000));
        }
    }
}
