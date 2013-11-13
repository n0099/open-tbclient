package com.baidu.tieba.write;

import android.content.DialogInterface;
import com.baidu.tieba.data.WriteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WriteActivity f2683a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(WriteActivity writeActivity) {
        this.f2683a = writeActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        WriteData writeData;
        WriteData writeData2;
        if (i == 0) {
            bc.a(this.f2683a);
            writeData2 = this.f2683a.b;
            writeData2.setPicType(2);
        } else if (i == 1) {
            bc.b(this.f2683a);
            writeData = this.f2683a.b;
            writeData.setPicType(1);
        }
    }
}
