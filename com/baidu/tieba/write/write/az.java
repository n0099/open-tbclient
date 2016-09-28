package com.baidu.tieba.write.write;
/* loaded from: classes.dex */
class az implements Runnable {
    final /* synthetic */ WriteActivity ghD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(WriteActivity writeActivity) {
        this.ghD = writeActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.adp.lib.util.k.b(this.ghD.getActivity(), this.ghD.getCurrentFocus());
    }
}
