package com.baidu.tieba.tbadkCore.c;

import com.baidu.tbadk.BaseActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {
    private final /* synthetic */ BaseActivity bfV;
    private final /* synthetic */ boolean crN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(BaseActivity baseActivity, boolean z) {
        this.bfV = baseActivity;
        this.crN = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        a.a(this.bfV.getPageContext().getPageActivity(), this.crN);
    }
}
