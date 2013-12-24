package com.baidu.tieba.more;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag extends BroadcastReceiver {
    final /* synthetic */ MoreActivity a;

    private ag(MoreActivity moreActivity) {
        this.a = moreActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ag(MoreActivity moreActivity, ad adVar) {
        this(moreActivity);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        ah ahVar;
        ahVar = this.a.a;
        ahVar.i();
    }
}
