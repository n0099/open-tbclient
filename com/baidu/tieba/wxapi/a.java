package com.baidu.tieba.wxapi;
/* loaded from: classes.dex */
class a implements Runnable {
    final /* synthetic */ WXEntryActivity fTb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(WXEntryActivity wXEntryActivity) {
        this.fTb = wXEntryActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.fTb.closeActivity();
    }
}
