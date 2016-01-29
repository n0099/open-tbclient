package com.baidu.tieba.tbadkCore.b;

import com.baidu.tbadk.BaseActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {
    private final /* synthetic */ BaseActivity biS;
    private final /* synthetic */ boolean dWe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(BaseActivity baseActivity, boolean z) {
        this.biS = baseActivity;
        this.dWe = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        a.b(this.biS.getPageContext().getPageActivity(), this.dWe);
    }
}
