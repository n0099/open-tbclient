package com.baidu.tieba.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ CommonTipView fNU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(CommonTipView commonTipView) {
        this.fNU = commonTipView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.fNU.hideTip();
    }
}
