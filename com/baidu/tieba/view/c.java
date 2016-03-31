package com.baidu.tieba.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Runnable {
    final /* synthetic */ CommonTipView eFv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(CommonTipView commonTipView) {
        this.eFv = commonTipView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.eFv.hideTip();
    }
}
