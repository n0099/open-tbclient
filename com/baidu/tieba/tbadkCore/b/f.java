package com.baidu.tieba.tbadkCore.b;

import com.baidu.tbadk.BaseActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {
    private final /* synthetic */ BaseActivity cbA;
    private final /* synthetic */ boolean ftu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(BaseActivity baseActivity, boolean z) {
        this.cbA = baseActivity;
        this.ftu = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        a.b(this.cbA.getPageContext().getPageActivity(), this.ftu);
    }
}
