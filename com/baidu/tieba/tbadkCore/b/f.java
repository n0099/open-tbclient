package com.baidu.tieba.tbadkCore.b;

import com.baidu.tbadk.BaseActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {
    private final /* synthetic */ BaseActivity cVH;
    private final /* synthetic */ boolean fBp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(BaseActivity baseActivity, boolean z) {
        this.cVH = baseActivity;
        this.fBp = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        a.b(this.cVH.getPageContext().getPageActivity(), this.fBp);
    }
}
