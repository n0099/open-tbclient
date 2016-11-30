package com.baidu.tieba.tbadkCore.b;

import com.baidu.tbadk.BaseActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {
    private final /* synthetic */ BaseActivity bXg;
    private final /* synthetic */ boolean fBy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(BaseActivity baseActivity, boolean z) {
        this.bXg = baseActivity;
        this.fBy = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        a.b(this.bXg.getPageContext().getPageActivity(), this.fBy);
    }
}
