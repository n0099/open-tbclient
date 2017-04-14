package com.baidu.tieba.tbadkCore.b;

import com.baidu.tbadk.BaseActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {
    private final /* synthetic */ BaseActivity cab;
    private final /* synthetic */ boolean fvd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(BaseActivity baseActivity, boolean z) {
        this.cab = baseActivity;
        this.fvd = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        a.b(this.cab.getPageContext().getPageActivity(), this.fvd);
    }
}
