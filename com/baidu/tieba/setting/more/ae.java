package com.baidu.tieba.setting.more;

import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
/* loaded from: classes.dex */
class ae implements Runnable {
    private final /* synthetic */ boolean bOk;
    final /* synthetic */ ac dLe;
    private final /* synthetic */ BdSwitchView dLf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ac acVar, boolean z, BdSwitchView bdSwitchView) {
        this.dLe = acVar;
        this.bOk = z;
        this.dLf = bdSwitchView;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.bOk) {
            this.dLf.mr();
        } else {
            this.dLf.mq();
        }
    }
}
