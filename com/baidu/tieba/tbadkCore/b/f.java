package com.baidu.tieba.tbadkCore.b;

import com.baidu.tbadk.BaseActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {
    private final /* synthetic */ BaseActivity bFW;
    private final /* synthetic */ boolean fjL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(BaseActivity baseActivity, boolean z) {
        this.bFW = baseActivity;
        this.fjL = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        a.b(this.bFW.getPageContext().getPageActivity(), this.fjL);
    }
}
