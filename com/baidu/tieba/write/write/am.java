package com.baidu.tieba.write.write;

import android.app.TimePickerDialog;
import android.widget.TextView;
import android.widget.TimePicker;
import com.baidu.tbadk.coreExtra.data.WriteData;
import java.util.Date;
/* loaded from: classes.dex */
class am implements TimePickerDialog.OnTimeSetListener {
    final /* synthetic */ WriteActivity dqi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(WriteActivity writeActivity) {
        this.dqi = writeActivity;
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
        writeData = this.dqi.dbx;
        if (writeData.getLiveCardData() != null) {
            Date date = new Date();
            Date date2 = new Date(date.getYear(), date.getMonth(), date.getDate(), i, i2);
            writeData2 = this.dqi.dbx;
            long startTime = writeData2.getLiveCardData().getStartTime();
            writeData3 = this.dqi.dbx;
            writeData3.getLiveCardData().setStartTime(date2.getTime() / 1000);
            writeData4 = this.dqi.dbx;
            if (startTime / 60 != writeData4.getLiveCardData().getStartTime() / 60) {
                writeData6 = this.dqi.dbx;
                writeData6.getLiveCardData().setModifyTime(true);
            }
            textView = this.dqi.dpL;
            writeData5 = this.dqi.dbx;
            textView.setText(com.baidu.tbadk.core.util.as.n(writeData5.getLiveCardData().getStartTime() * 1000));
        }
    }
}
