package com.baidu.tieba.wxapi;
/* loaded from: classes.dex */
class a implements Runnable {
    final /* synthetic */ WXEntryActivity fTG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(WXEntryActivity wXEntryActivity) {
        this.fTG = wXEntryActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.fTG.closeActivity();
    }
}
