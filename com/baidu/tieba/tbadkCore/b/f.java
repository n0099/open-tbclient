package com.baidu.tieba.tbadkCore.b;

import com.baidu.tbadk.BaseActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {
    private final /* synthetic */ BaseActivity bRe;
    private final /* synthetic */ boolean frE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(BaseActivity baseActivity, boolean z) {
        this.bRe = baseActivity;
        this.frE = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        a.b(this.bRe.getPageContext().getPageActivity(), this.frE);
    }
}
