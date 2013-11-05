package com.baidu.tieba.write;

import android.content.DialogInterface;
import com.baidu.tieba.data.WriteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WriteActivity f2639a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(WriteActivity writeActivity) {
        this.f2639a = writeActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        WriteData writeData;
        WriteData writeData2;
        if (i == 0) {
            bg.a(this.f2639a);
            writeData2 = this.f2639a.f2619a;
            writeData2.setPicType(2);
        } else if (i == 1) {
            bg.b(this.f2639a);
            writeData = this.f2639a.f2619a;
            writeData.setPicType(1);
        }
    }
}
