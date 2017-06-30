package com.baidu.tieba.screenlocknotify;

import android.view.View;
import android.widget.AdapterView;
/* loaded from: classes2.dex */
class c implements AdapterView.OnItemClickListener {
    final /* synthetic */ ScreenLockActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ScreenLockActivity screenLockActivity) {
        this.this$0 = screenLockActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.this$0.fwd = this.this$0.fwc.getItem(i);
        this.this$0.b(this.this$0.fwd);
    }
}
