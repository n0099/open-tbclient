package com.baidu.tieba.write.write;
/* loaded from: classes.dex */
class ay implements Runnable {
    final /* synthetic */ WriteActivity fUM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(WriteActivity writeActivity) {
        this.fUM = writeActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.adp.lib.util.k.b(this.fUM.getActivity(), this.fUM.getCurrentFocus());
    }
}
