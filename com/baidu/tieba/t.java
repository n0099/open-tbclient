package com.baidu.tieba;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
class t extends BroadcastReceiver {
    final /* synthetic */ MainTabActivity a;

    private t(MainTabActivity mainTabActivity) {
        this.a = mainTabActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ t(MainTabActivity mainTabActivity, t tVar) {
        this(mainTabActivity);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action.equals("com.baidu.tieba.broadcast.notify")) {
            MainTabActivity.a(this.a, intent.getLongExtra("relay", 0L));
            MainTabActivity.b(this.a, intent.getLongExtra("at_me", 0L));
            MainTabActivity.c(this.a, intent.getLongExtra("fans", 0L));
            MainTabActivity.a(this.a);
        } else if (action.equals("com.baidu.tieba.broadcast.newversion")) {
            MainTabActivity.b(this.a);
        }
    }
}
