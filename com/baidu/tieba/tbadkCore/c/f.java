package com.baidu.tieba.tbadkCore.c;

import com.baidu.tbadk.BaseActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {
    private final /* synthetic */ BaseActivity byb;
    private final /* synthetic */ boolean dab;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(BaseActivity baseActivity, boolean z) {
        this.byb = baseActivity;
        this.dab = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        a.c(this.byb.getPageContext().getPageActivity(), this.dab);
    }
}
