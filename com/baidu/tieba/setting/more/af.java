package com.baidu.tieba.setting.more;

import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
/* loaded from: classes.dex */
class af implements Runnable {
    private final /* synthetic */ boolean bYC;
    final /* synthetic */ ae edB;
    private final /* synthetic */ BdSwitchView edC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(ae aeVar, boolean z, BdSwitchView bdSwitchView) {
        this.edB = aeVar;
        this.bYC = z;
        this.edC = bdSwitchView;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.bYC) {
            this.edC.mi();
        } else {
            this.edC.mj();
        }
    }
}
