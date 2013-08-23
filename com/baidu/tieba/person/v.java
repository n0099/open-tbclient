package com.baidu.tieba.person;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ EditHeadActivity f1662a;

    private v(EditHeadActivity editHeadActivity) {
        this.f1662a = editHeadActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ v(EditHeadActivity editHeadActivity, v vVar) {
        this(editHeadActivity);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        this.f1662a.a_();
        if (intent.getBooleanExtra("result", false)) {
            this.f1662a.d();
        } else {
            this.f1662a.a(intent.getStringExtra("error"));
        }
    }
}
