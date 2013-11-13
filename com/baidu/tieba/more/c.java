package com.baidu.tieba.more;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AboutActivity f1996a;

    private c(AboutActivity aboutActivity) {
        this.f1996a = aboutActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ c(AboutActivity aboutActivity, a aVar) {
        this(aboutActivity);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        d dVar;
        d dVar2;
        dVar = this.f1996a.f1956a;
        if (dVar != null) {
            dVar2 = this.f1996a.f1956a;
            dVar2.f();
        }
    }
}
