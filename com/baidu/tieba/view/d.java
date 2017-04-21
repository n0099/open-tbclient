package com.baidu.tieba.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ CommonTipView fLK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(CommonTipView commonTipView) {
        this.fLK = commonTipView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.fLK.hideTip();
    }
}
