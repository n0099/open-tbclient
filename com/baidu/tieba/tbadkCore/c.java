package com.baidu.tieba.tbadkCore;
/* loaded from: classes.dex */
class c implements Runnable {
    final /* synthetic */ ChildViewPager cYn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ChildViewPager childViewPager) {
        this.cYn = childViewPager;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        z = this.cYn.cYm;
        if (z) {
            this.cYn.setPressed(true);
        }
    }
}
