package com.baidu.tieba.write.write;
/* loaded from: classes.dex */
class ba implements Runnable {
    final /* synthetic */ WriteActivity glP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(WriteActivity writeActivity) {
        this.glP = writeActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.adp.lib.util.k.b(this.glP.getActivity(), this.glP.getCurrentFocus());
    }
}
