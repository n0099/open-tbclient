package com.baidu.tieba.write;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax extends BroadcastReceiver {
    final /* synthetic */ WriteImageActivity a;

    private ax(WriteImageActivity writeImageActivity) {
        this.a = writeImageActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ax(WriteImageActivity writeImageActivity, an anVar) {
        this(writeImageActivity);
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
        textView = this.a.d;
        if (textView != null) {
            textView2 = this.a.d;
            textView2.setEnabled(false);
        }
    }
}
