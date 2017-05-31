package com.baidu.tieba.screenlocknotify;

import android.view.View;
/* loaded from: classes2.dex */
class d implements View.OnClickListener {
    final /* synthetic */ ScreenLockActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ScreenLockActivity screenLockActivity) {
        this.this$0 = screenLockActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.screenlocknotify.a.a aVar;
        com.baidu.tieba.screenlocknotify.a.a aVar2;
        aVar = this.this$0.flT;
        if (aVar != null) {
            ScreenLockActivity screenLockActivity = this.this$0;
            aVar2 = this.this$0.flT;
            screenLockActivity.flP = aVar2.getData();
            this.this$0.b(this.this$0.flP);
        }
    }
}
