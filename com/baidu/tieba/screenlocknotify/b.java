package com.baidu.tieba.screenlocknotify;

import android.view.View;
import android.widget.AdapterView;
/* loaded from: classes.dex */
class b implements AdapterView.OnItemClickListener {
    final /* synthetic */ ScreenLockActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ScreenLockActivity screenLockActivity) {
        this.this$0 = screenLockActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.this$0.ecL = (p) this.this$0.ecK.getItem(i);
        this.this$0.a(this.this$0.ecL);
    }
}
