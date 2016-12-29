package com.baidu.tieba.tbadkCore.b;

import com.baidu.tbadk.BaseActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {
    private final /* synthetic */ BaseActivity bDq;
    private final /* synthetic */ boolean ffD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(BaseActivity baseActivity, boolean z) {
        this.bDq = baseActivity;
        this.ffD = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        a.b(this.bDq.getPageContext().getPageActivity(), this.ffD);
    }
}
