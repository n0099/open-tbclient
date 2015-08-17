package com.baidu.tieba.tbadkCore.c;

import com.baidu.tbadk.BaseActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {
    private final /* synthetic */ BaseActivity btL;
    private final /* synthetic */ boolean cIn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(BaseActivity baseActivity, boolean z) {
        this.btL = baseActivity;
        this.cIn = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        a.c(this.btL.getPageContext().getPageActivity(), this.cIn);
    }
}
