package com.baidu.tieba.util;

import android.app.Activity;
import android.content.DialogInterface;
import com.baidu.tieba.TiebaApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class bk implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Activity f2504a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(Activity activity) {
        this.f2504a = activity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        TiebaApplication.g().aC();
        y.b();
        this.f2504a.finish();
    }
}
