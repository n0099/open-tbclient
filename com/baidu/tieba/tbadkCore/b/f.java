package com.baidu.tieba.tbadkCore.b;

import com.baidu.tbadk.BaseActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {
    private final /* synthetic */ BaseActivity ddE;
    private final /* synthetic */ boolean fLt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(BaseActivity baseActivity, boolean z) {
        this.ddE = baseActivity;
        this.fLt = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        a.b(this.ddE.getPageContext().getPageActivity(), this.fLt);
    }
}
