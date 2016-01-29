package com.baidu.tieba.setting.more;

import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
/* loaded from: classes.dex */
class af implements Runnable {
    private final /* synthetic */ boolean bOk;
    final /* synthetic */ ac dLe;
    private final /* synthetic */ BdSwitchView dLg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(ac acVar, boolean z, BdSwitchView bdSwitchView) {
        this.dLe = acVar;
        this.bOk = z;
        this.dLg = bdSwitchView;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.bOk) {
            this.dLg.mr();
        } else {
            this.dLg.mq();
        }
    }
}
