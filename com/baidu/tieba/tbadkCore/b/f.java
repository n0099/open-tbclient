package com.baidu.tieba.tbadkCore.b;

import com.baidu.tbadk.BaseActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {
    private final /* synthetic */ BaseActivity cQj;
    private final /* synthetic */ boolean fty;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(BaseActivity baseActivity, boolean z) {
        this.cQj = baseActivity;
        this.fty = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        a.b(this.cQj.getPageContext().getPageActivity(), this.fty);
    }
}
