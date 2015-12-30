package com.baidu.tieba.tbadkCore;
/* loaded from: classes.dex */
class c implements Runnable {
    final /* synthetic */ ChildViewPager dEr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ChildViewPager childViewPager) {
        this.dEr = childViewPager;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        z = this.dEr.dEq;
        if (z) {
            this.dEr.setPressed(true);
        }
    }
}
