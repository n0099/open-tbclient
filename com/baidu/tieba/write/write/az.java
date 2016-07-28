package com.baidu.tieba.write.write;
/* loaded from: classes.dex */
class az implements Runnable {
    final /* synthetic */ WriteActivity fVn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(WriteActivity writeActivity) {
        this.fVn = writeActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.adp.lib.util.k.b(this.fVn.getActivity(), this.fVn.getCurrentFocus());
    }
}
