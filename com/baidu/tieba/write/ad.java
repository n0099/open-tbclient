package com.baidu.tieba.write;

import android.content.DialogInterface;
import com.baidu.tieba.model.WriteModel;
import com.baidu.tieba.util.DatabaseService;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements DialogInterface.OnClickListener {
    final /* synthetic */ WriteActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(WriteActivity writeActivity) {
        this.a = writeActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        WriteModel writeModel;
        writeModel = this.a.a;
        DatabaseService.a(writeModel);
        this.a.finish();
    }
}
