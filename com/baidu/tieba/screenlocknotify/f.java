package com.baidu.tieba.screenlocknotify;
/* loaded from: classes.dex */
class f implements Runnable {
    final /* synthetic */ e cur;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.cur = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ScreenLockActivity screenLockActivity;
        screenLockActivity = this.cur.this$0;
        screenLockActivity.finish();
    }
}
