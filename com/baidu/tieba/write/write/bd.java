package com.baidu.tieba.write.write;
/* loaded from: classes.dex */
class bd implements Runnable {
    final /* synthetic */ WriteActivity gaR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(WriteActivity writeActivity) {
        this.gaR = writeActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.adp.lib.util.k.b(this.gaR.getActivity(), this.gaR.getCurrentFocus());
    }
}
