package com.baidu.tieba.util;

import android.app.Activity;
import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class at implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ Activity f1791a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(Activity activity) {
        this.f1791a = activity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f1791a.finish();
    }
}
