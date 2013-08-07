package com.baidu.tieba.write;

import android.content.DialogInterface;
import com.baidu.tieba.data.WriteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WriteActivity f1879a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(WriteActivity writeActivity) {
        this.f1879a = writeActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        WriteData writeData;
        WriteData writeData2;
        if (i == 0) {
            ba.a(this.f1879a);
            writeData2 = this.f1879a.f1866a;
            writeData2.setPicType(2);
        } else if (i == 1) {
            ba.b(this.f1879a);
            writeData = this.f1879a.f1866a;
            writeData.setPicType(1);
        }
    }
}
