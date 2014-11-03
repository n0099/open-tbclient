package com.baidu.tieba.write;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cd extends BroadcastReceiver {
    final /* synthetic */ WriteImageActivity this$0;

    private cd(WriteImageActivity writeImageActivity) {
        this.this$0 = writeImageActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ cd(WriteImageActivity writeImageActivity, cd cdVar) {
        this(writeImageActivity);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        TextView textView;
        TextView textView2;
        this.this$0.releaseResouce();
        if (intent.getBooleanExtra("result", false)) {
            this.this$0.initData();
            return;
        }
        this.this$0.showToast(intent.getStringExtra("error"));
        textView = this.this$0.bSH;
        if (textView != null) {
            textView2 = this.this$0.bSH;
            textView2.setEnabled(false);
        }
    }
}
