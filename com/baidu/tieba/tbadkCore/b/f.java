package com.baidu.tieba.tbadkCore.b;

import com.baidu.tbadk.BaseActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {
    private final /* synthetic */ BaseActivity bjg;
    private final /* synthetic */ boolean erV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(BaseActivity baseActivity, boolean z) {
        this.bjg = baseActivity;
        this.erV = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        a.b(this.bjg.getPageContext().getPageActivity(), this.erV);
    }
}
