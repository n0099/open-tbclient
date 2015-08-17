package com.baidu.tieba.write.write;
/* loaded from: classes.dex */
class aq implements Runnable {
    final /* synthetic */ ap cUO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(ap apVar) {
        this.cUO = apVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        WriteActivity writeActivity;
        writeActivity = this.cUO.cUM;
        writeActivity.finish();
    }
}
