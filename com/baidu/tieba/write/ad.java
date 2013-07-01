package com.baidu.tieba.write;

import android.content.DialogInterface;
import com.baidu.tieba.model.WriteModel;
import com.baidu.tieba.util.DatabaseService;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WriteActivity f1556a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(WriteActivity writeActivity) {
        this.f1556a = writeActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        WriteModel writeModel;
        writeModel = this.f1556a.f1550a;
        DatabaseService.a(writeModel);
        this.f1556a.finish();
    }
}
