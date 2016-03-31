package com.baidu.tieba.tbadkCore.b;

import com.baidu.tbadk.BaseActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {
    private final /* synthetic */ BaseActivity bnD;
    private final /* synthetic */ boolean eoL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(BaseActivity baseActivity, boolean z) {
        this.bnD = baseActivity;
        this.eoL = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        a.b(this.bnD.getPageContext().getPageActivity(), this.eoL);
    }
}
