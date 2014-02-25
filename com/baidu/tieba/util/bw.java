package com.baidu.tieba.util;
/* loaded from: classes.dex */
class bw implements Runnable {
    final /* synthetic */ TbWebViewActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bw(TbWebViewActivity tbWebViewActivity) {
        this.a = tbWebViewActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.a();
    }
}
