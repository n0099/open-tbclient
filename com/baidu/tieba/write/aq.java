package com.baidu.tieba.write;

import android.content.DialogInterface;
import com.baidu.tieba.data.WriteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq implements DialogInterface.OnClickListener {
    final /* synthetic */ WriteActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(WriteActivity writeActivity) {
        this.a = writeActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        WriteData writeData;
        writeData = this.a.b;
        af.a(writeData.getForumId(), (WriteData) null);
        this.a.finish();
    }
}
