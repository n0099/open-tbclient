package com.baidu.tieba.more;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MoreActivity f1974a;

    private ag(MoreActivity moreActivity) {
        this.f1974a = moreActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ag(MoreActivity moreActivity, ad adVar) {
        this(moreActivity);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        ah ahVar;
        ahVar = this.f1974a.f1960a;
        ahVar.i();
    }
}
