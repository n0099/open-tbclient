package com.baidu.tieba.mention;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MentionActivity f1858a;

    private e(MentionActivity mentionActivity) {
        this.f1858a = mentionActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ e(MentionActivity mentionActivity, b bVar) {
        this(mentionActivity);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        long longExtra = intent.getLongExtra("relay", 0L);
        long longExtra2 = intent.getLongExtra("at_me", 0L);
        this.f1858a.a(new long[]{intent.getLongExtra("pletter", 0L), longExtra, longExtra2});
    }
}
