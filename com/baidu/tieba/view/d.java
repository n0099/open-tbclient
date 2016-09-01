package com.baidu.tieba.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ CommonTipView fVO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(CommonTipView commonTipView) {
        this.fVO = commonTipView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.fVO.hideTip();
    }
}
