package com.baidu.tieba.tbadkCore.b;

import com.baidu.tbadk.BaseActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {
    private final /* synthetic */ BaseActivity bQX;
    private final /* synthetic */ boolean ful;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(BaseActivity baseActivity, boolean z) {
        this.bQX = baseActivity;
        this.ful = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        a.b(this.bQX.getPageContext().getPageActivity(), this.ful);
    }
}
