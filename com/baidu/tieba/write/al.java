package com.baidu.tieba.write;

import android.content.DialogInterface;
import com.baidu.tieba.model.WriteModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements DialogInterface.OnClickListener {
    final /* synthetic */ WriteActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(WriteActivity writeActivity) {
        this.a = writeActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        WriteModel writeModel;
        WriteModel writeModel2;
        if (i == 0) {
            bb.a(this.a);
            writeModel2 = this.a.a;
            writeModel2.setPicType(2);
        } else if (i == 1) {
            bb.b(this.a);
            writeModel = this.a.a;
            writeModel.setPicType(1);
        }
    }
}
