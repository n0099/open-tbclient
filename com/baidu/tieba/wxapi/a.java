package com.baidu.tieba.wxapi;
/* loaded from: classes.dex */
class a implements Runnable {
    final /* synthetic */ WXEntryActivity fWe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(WXEntryActivity wXEntryActivity) {
        this.fWe = wXEntryActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.fWe.closeActivity();
    }
}
