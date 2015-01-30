package com.baidu.tieba.write;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.view.View;
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
        View view;
        View view2;
        this.this$0.releaseResouce();
        if (intent.getBooleanExtra("result", false)) {
            this.this$0.initData();
            return;
        }
        this.this$0.showToast(intent.getStringExtra("error"));
        view = this.this$0.cha;
        if (view != null) {
            view2 = this.this$0.cha;
            view2.setEnabled(false);
        }
    }
}
