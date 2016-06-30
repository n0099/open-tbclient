package com.baidu.tieba.wxapi;
/* loaded from: classes.dex */
class a implements Runnable {
    final /* synthetic */ WXEntryActivity fKn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(WXEntryActivity wXEntryActivity) {
        this.fKn = wXEntryActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.fKn.closeActivity();
    }
}
