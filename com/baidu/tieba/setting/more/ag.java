package com.baidu.tieba.setting.more;

import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
/* loaded from: classes.dex */
class ag implements Runnable {
    private final /* synthetic */ boolean aWV;
    final /* synthetic */ ae cbr;
    private final /* synthetic */ BdSwitchView cbs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(ae aeVar, boolean z, BdSwitchView bdSwitchView) {
        this.cbr = aeVar;
        this.aWV = z;
        this.cbs = bdSwitchView;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.aWV) {
            this.cbs.lZ();
        } else {
            this.cbs.lY();
        }
    }
}
