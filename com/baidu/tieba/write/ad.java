package com.baidu.tieba.write;

import android.content.DialogInterface;
import com.baidu.tieba.c.bp;
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
        bp bpVar;
        bpVar = this.a.c;
        com.baidu.tieba.d.k.a(bpVar);
        this.a.finish();
    }
}
