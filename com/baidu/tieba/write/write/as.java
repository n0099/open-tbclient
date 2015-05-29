package com.baidu.tieba.write.write;

import android.app.TimePickerDialog;
import android.widget.TextView;
import android.widget.TimePicker;
import com.baidu.tbadk.coreExtra.data.WriteData;
import java.util.Date;
/* loaded from: classes.dex */
class as implements TimePickerDialog.OnTimeSetListener {
    final /* synthetic */ WriteActivity cCP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(WriteActivity writeActivity) {
        this.cCP = writeActivity;
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
        writeData = this.cCP.cuo;
        if (writeData.getLiveCardData() != null) {
            Date date = new Date();
            Date date2 = new Date(date.getYear(), date.getMonth(), date.getDate(), i, i2);
            writeData2 = this.cCP.cuo;
            long startTime = writeData2.getLiveCardData().getStartTime();
            writeData3 = this.cCP.cuo;
            writeData3.getLiveCardData().setStartTime(date2.getTime() / 1000);
            writeData4 = this.cCP.cuo;
            if (startTime / 60 != writeData4.getLiveCardData().getStartTime() / 60) {
                writeData6 = this.cCP.cuo;
                writeData6.getLiveCardData().setModifyTime(true);
            }
            textView = this.cCP.cCG;
            writeData5 = this.cCP.cuo;
            textView.setText(com.baidu.tbadk.core.util.bb.p(writeData5.getLiveCardData().getStartTime() * 1000));
        }
    }
}
