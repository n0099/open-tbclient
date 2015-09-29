package com.baidu.tieba.tbadkCore.c;

import com.baidu.tbadk.BaseActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {
    private final /* synthetic */ BaseActivity bxt;
    private final /* synthetic */ boolean cYe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(BaseActivity baseActivity, boolean z) {
        this.bxt = baseActivity;
        this.cYe = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        a.c(this.bxt.getPageContext().getPageActivity(), this.cYe);
    }
}
