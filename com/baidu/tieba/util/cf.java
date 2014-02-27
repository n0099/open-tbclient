package com.baidu.tieba.util;

import android.app.Activity;
import android.content.DialogInterface;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.pb.cs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class cf implements DialogInterface.OnClickListener {
    private final /* synthetic */ Activity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cf(Activity activity) {
        this.a = activity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        TiebaApplication.g().at();
        com.baidu.tieba.log.a.b();
        TiebaApplication.g().bk();
        cs.a().f();
        this.a.finish();
    }
}
