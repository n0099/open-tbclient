package com.baidu.tieba.wxapi;
/* loaded from: classes.dex */
class a implements Runnable {
    final /* synthetic */ WXEntryActivity gng;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(WXEntryActivity wXEntryActivity) {
        this.gng = wXEntryActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.gng.closeActivity();
    }
}
