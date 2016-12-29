package com.baidu.tieba.write.write;
/* loaded from: classes.dex */
class ba implements Runnable {
    final /* synthetic */ WriteActivity fDQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(WriteActivity writeActivity) {
        this.fDQ = writeActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.adp.lib.util.k.b(this.fDQ.getActivity(), this.fDQ.getCurrentFocus());
    }
}
