package com.baidu.tieba.setting.more;

import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
/* loaded from: classes.dex */
class ah implements Runnable {
    private final /* synthetic */ boolean aWV;
    final /* synthetic */ ae cbr;
    private final /* synthetic */ BdSwitchView cbt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(ae aeVar, boolean z, BdSwitchView bdSwitchView) {
        this.cbr = aeVar;
        this.aWV = z;
        this.cbt = bdSwitchView;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.aWV) {
            this.cbt.lZ();
        } else {
            this.cbt.lY();
        }
    }
}
