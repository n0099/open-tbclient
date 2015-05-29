package com.baidu.tieba.tbadkCore.c;

import com.baidu.tbadk.BaseActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {
    private final /* synthetic */ BaseActivity bfU;
    private final /* synthetic */ boolean crM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(BaseActivity baseActivity, boolean z) {
        this.bfU = baseActivity;
        this.crM = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        a.a(this.bfU.getPageContext().getPageActivity(), this.crM);
    }
}
