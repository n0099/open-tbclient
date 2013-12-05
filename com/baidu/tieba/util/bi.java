package com.baidu.tieba.util;

import android.app.Activity;
import android.content.DialogInterface;
import com.baidu.tieba.TiebaApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class bi implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Activity f2600a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(Activity activity) {
        this.f2600a = activity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        TiebaApplication.h().aD();
        com.baidu.tieba.log.a.b();
        this.f2600a.finish();
    }
}
