package com.baidu.tieba.tbadkCore;
/* loaded from: classes.dex */
class c implements Runnable {
    final /* synthetic */ ChildViewPager cWR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ChildViewPager childViewPager) {
        this.cWR = childViewPager;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        z = this.cWR.cWQ;
        if (z) {
            this.cWR.setPressed(true);
        }
    }
}
