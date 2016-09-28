package com.baidu.tieba.wxapi;
/* loaded from: classes.dex */
class a implements Runnable {
    final /* synthetic */ WXEntryActivity giu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(WXEntryActivity wXEntryActivity) {
        this.giu = wXEntryActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.giu.closeActivity();
    }
}
