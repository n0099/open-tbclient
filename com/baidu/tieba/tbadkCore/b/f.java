package com.baidu.tieba.tbadkCore.b;

import com.baidu.tbadk.BaseActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {
    private final /* synthetic */ BaseActivity bNh;
    private final /* synthetic */ boolean dyP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(BaseActivity baseActivity, boolean z) {
        this.bNh = baseActivity;
        this.dyP = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        a.c(this.bNh.getPageContext().getPageActivity(), this.dyP);
    }
}
