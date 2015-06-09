package com.baidu.tieba.person;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r extends BroadcastReceiver {
    final /* synthetic */ EditHeadActivity this$0;

    private r(EditHeadActivity editHeadActivity) {
        this.this$0 = editHeadActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ r(EditHeadActivity editHeadActivity, r rVar) {
        this(editHeadActivity);
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
        view = this.this$0.bRa;
        if (view != null) {
            view2 = this.this$0.bRa;
            view2.setEnabled(false);
        }
    }
}
