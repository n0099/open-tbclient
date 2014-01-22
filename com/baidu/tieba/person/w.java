package com.baidu.tieba.person;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w extends BroadcastReceiver {
    final /* synthetic */ EditHeadActivity a;

    private w(EditHeadActivity editHeadActivity) {
        this.a = editHeadActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ w(EditHeadActivity editHeadActivity, l lVar) {
        this(editHeadActivity);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        TextView textView;
        TextView textView2;
        this.a.releaseResouce();
        if (intent.getBooleanExtra("result", false)) {
            this.a.c();
            return;
        }
        this.a.showToast(intent.getStringExtra("error"));
        textView = this.a.j;
        if (textView != null) {
            textView2 = this.a.j;
            textView2.setEnabled(false);
        }
    }
}
