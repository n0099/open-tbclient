package com.baidu.tieba.write;

import android.content.DialogInterface;
import com.baidu.tieba.data.WriteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements DialogInterface.OnClickListener {
    final /* synthetic */ WriteActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(WriteActivity writeActivity) {
        this.a = writeActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        WriteData writeData;
        WriteData writeData2;
        if (i == 0) {
            bd.a(this.a);
            writeData2 = this.a.b;
            writeData2.setPicType(2);
        } else if (i == 1) {
            bd.b(this.a);
            writeData = this.a.b;
            writeData.setPicType(1);
        }
    }
}
