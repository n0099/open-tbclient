package com.baidu.tieba.util;

import android.app.Activity;
import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ Activity f1756a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(Activity activity) {
        this.f1756a = activity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f1756a.finish();
    }
}
