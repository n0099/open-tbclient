package com.baidu.tieba.write.write;
/* loaded from: classes.dex */
class az implements Runnable {
    final /* synthetic */ WriteActivity gfs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(WriteActivity writeActivity) {
        this.gfs = writeActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.adp.lib.util.k.b(this.gfs.getActivity(), this.gfs.getCurrentFocus());
    }
}
