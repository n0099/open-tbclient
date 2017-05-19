package com.baidu.tieba.write.write;
/* loaded from: classes.dex */
class bd implements Runnable {
    final /* synthetic */ WriteActivity fSV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(WriteActivity writeActivity) {
        this.fSV = writeActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.adp.lib.util.k.b(this.fSV.getActivity(), this.fSV.getCurrentFocus());
    }
}
