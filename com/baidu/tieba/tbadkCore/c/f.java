package com.baidu.tieba.tbadkCore.c;

import com.baidu.tbadk.BaseActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {
    private final /* synthetic */ BaseActivity bxE;
    private final /* synthetic */ boolean cYE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(BaseActivity baseActivity, boolean z) {
        this.bxE = baseActivity;
        this.cYE = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        a.c(this.bxE.getPageContext().getPageActivity(), this.cYE);
    }
}
