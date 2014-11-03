package com.baidu.tieba.more;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
class c extends BroadcastReceiver {
    final /* synthetic */ AboutActivity this$0;

    private c(AboutActivity aboutActivity) {
        this.this$0 = aboutActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ c(AboutActivity aboutActivity, c cVar) {
        this(aboutActivity);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (AboutActivity.a(this.this$0) != null) {
            AboutActivity.a(this.this$0).Ug();
        }
    }
}
