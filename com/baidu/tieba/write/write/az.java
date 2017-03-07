package com.baidu.tieba.write.write;
/* loaded from: classes.dex */
class az implements Runnable {
    final /* synthetic */ WriteActivity fQG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(WriteActivity writeActivity) {
        this.fQG = writeActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.adp.lib.util.k.b(this.fQG.getActivity(), this.fQG.getCurrentFocus());
    }
}
