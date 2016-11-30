package com.baidu.tieba.write.write;
/* loaded from: classes.dex */
class ba implements Runnable {
    final /* synthetic */ WriteActivity gpp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(WriteActivity writeActivity) {
        this.gpp = writeActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.adp.lib.util.k.b(this.gpp.getActivity(), this.gpp.getCurrentFocus());
    }
}
