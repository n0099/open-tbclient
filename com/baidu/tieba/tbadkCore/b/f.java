package com.baidu.tieba.tbadkCore.b;

import com.baidu.tbadk.BaseActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {
    private final /* synthetic */ BaseActivity bEJ;
    private final /* synthetic */ boolean eWJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(BaseActivity baseActivity, boolean z) {
        this.bEJ = baseActivity;
        this.eWJ = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        a.b(this.bEJ.getPageContext().getPageActivity(), this.eWJ);
    }
}
