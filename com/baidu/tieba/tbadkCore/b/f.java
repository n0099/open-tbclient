package com.baidu.tieba.tbadkCore.b;

import com.baidu.tbadk.BaseActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {
    private final /* synthetic */ BaseActivity bda;
    private final /* synthetic */ boolean cny;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(BaseActivity baseActivity, boolean z) {
        this.bda = baseActivity;
        this.cny = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        a.a(this.bda.getPageContext().getPageActivity(), this.cny);
    }
}
