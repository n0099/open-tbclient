package com.baidu.tieba.tbadkCore.b;

import com.baidu.tbadk.BaseActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {
    private final /* synthetic */ BaseActivity bdq;
    private final /* synthetic */ boolean cnO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(BaseActivity baseActivity, boolean z) {
        this.bdq = baseActivity;
        this.cnO = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        a.a(this.bdq.getPageContext().getPageActivity(), this.cnO);
    }
}
