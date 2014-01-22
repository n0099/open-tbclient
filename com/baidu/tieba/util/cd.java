package com.baidu.tieba.util;

import android.app.Activity;
import android.content.DialogInterface;
import com.baidu.tieba.TiebaApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class cd implements DialogInterface.OnClickListener {
    final /* synthetic */ Activity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cd(Activity activity) {
        this.a = activity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        TiebaApplication.h().aB();
        com.baidu.tieba.log.a.b();
        this.a.finish();
    }
}
