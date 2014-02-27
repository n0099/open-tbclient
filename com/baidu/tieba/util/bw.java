package com.baidu.tieba.util;
/* loaded from: classes.dex */
final class bw implements Runnable {
    final /* synthetic */ TbWebViewActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bw(TbWebViewActivity tbWebViewActivity) {
        this.a = tbWebViewActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.a();
    }
}
