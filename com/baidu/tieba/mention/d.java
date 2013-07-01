package com.baidu.tieba.mention;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
class d extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MentionActivity f982a;

    private d(MentionActivity mentionActivity) {
        this.f982a = mentionActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ d(MentionActivity mentionActivity, d dVar) {
        this(mentionActivity);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        MentionActivity.a(this.f982a, intent.getLongExtra("relay", 0L), intent.getLongExtra("at_me", 0L));
    }
}
