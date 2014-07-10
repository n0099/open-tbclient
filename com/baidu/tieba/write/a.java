package com.baidu.tieba.write;
/* loaded from: classes.dex */
class a implements Runnable {
    final /* synthetic */ AtListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AtListActivity atListActivity) {
        this.a = atListActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.c();
    }
}
