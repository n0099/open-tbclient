package com.baidu.tieba.tbadkCore.c;

import com.baidu.tbadk.BaseActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {
    private final /* synthetic */ BaseActivity bur;
    private final /* synthetic */ boolean cQN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(BaseActivity baseActivity, boolean z) {
        this.bur = baseActivity;
        this.cQN = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        a.c(this.bur.getPageContext().getPageActivity(), this.cQN);
    }
}
