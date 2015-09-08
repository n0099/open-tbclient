package com.baidu.tieba.tbadkCore;
/* loaded from: classes.dex */
class c implements Runnable {
    final /* synthetic */ ChildViewPager cPb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ChildViewPager childViewPager) {
        this.cPb = childViewPager;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        z = this.cPb.cPa;
        if (z) {
            this.cPb.setPressed(true);
        }
    }
}
