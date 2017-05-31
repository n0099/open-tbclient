package com.baidu.tieba.wxapi;
/* loaded from: classes.dex */
class a implements Runnable {
    final /* synthetic */ WXEntryActivity gci;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(WXEntryActivity wXEntryActivity) {
        this.gci = wXEntryActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.gci.closeActivity();
    }
}
