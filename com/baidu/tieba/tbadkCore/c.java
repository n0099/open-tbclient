package com.baidu.tieba.tbadkCore;
/* loaded from: classes.dex */
class c implements Runnable {
    final /* synthetic */ ChildViewPager dwR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ChildViewPager childViewPager) {
        this.dwR = childViewPager;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        z = this.dwR.dwQ;
        if (z) {
            this.dwR.setPressed(true);
        }
    }
}
