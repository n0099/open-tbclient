package com.baidu.tieba.tbadkCore.bubble;

import com.baidu.tbadk.BaseActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements Runnable {
    private final /* synthetic */ boolean bXQ;
    private final /* synthetic */ BaseActivity baY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(BaseActivity baseActivity, boolean z) {
        this.baY = baseActivity;
        this.bXQ = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        m.a(this.baY.getPageContext().getPageActivity(), this.bXQ);
    }
}
