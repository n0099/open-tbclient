package com.baidu.tieba.tbadkCore.b;

import com.baidu.tbadk.BaseActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {
    private final /* synthetic */ BaseActivity bQN;
    private final /* synthetic */ boolean dGj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(BaseActivity baseActivity, boolean z) {
        this.bQN = baseActivity;
        this.dGj = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        a.b(this.bQN.getPageContext().getPageActivity(), this.dGj);
    }
}
