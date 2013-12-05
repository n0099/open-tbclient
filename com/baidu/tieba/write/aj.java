package com.baidu.tieba.write;

import android.content.DialogInterface;
import com.baidu.tieba.data.WriteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WriteActivity f2784a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(WriteActivity writeActivity) {
        this.f2784a = writeActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        WriteData writeData;
        WriteData writeData2;
        if (i == 0) {
            bd.a(this.f2784a);
            writeData2 = this.f2784a.b;
            writeData2.setPicType(2);
        } else if (i == 1) {
            bd.b(this.f2784a);
            writeData = this.f2784a.b;
            writeData.setPicType(1);
        }
    }
}
