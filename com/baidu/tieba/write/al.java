package com.baidu.tieba.write;

import android.content.DialogInterface;
import com.baidu.tieba.model.WriteModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WriteActivity f1564a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(WriteActivity writeActivity) {
        this.f1564a = writeActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        WriteModel writeModel;
        WriteModel writeModel2;
        if (i == 0) {
            bb.a(this.f1564a);
            writeModel2 = this.f1564a.f1550a;
            writeModel2.setPicType(2);
        } else if (i == 1) {
            bb.b(this.f1564a);
            writeModel = this.f1564a.f1550a;
            writeModel.setPicType(1);
        }
    }
}
