package com.baidu.tieba.setting.more;

import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
/* loaded from: classes.dex */
class af implements Runnable {
    private final /* synthetic */ boolean bKx;
    final /* synthetic */ ac dva;
    private final /* synthetic */ BdSwitchView dvc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(ac acVar, boolean z, BdSwitchView bdSwitchView) {
        this.dva = acVar;
        this.bKx = z;
        this.dvc = bdSwitchView;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.bKx) {
            this.dvc.md();
        } else {
            this.dvc.mc();
        }
    }
}
