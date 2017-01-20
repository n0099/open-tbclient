package com.baidu.tieba.tbadkCore.b;

import com.baidu.tbadk.BaseActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {
    private final /* synthetic */ BaseActivity bUo;
    private final /* synthetic */ boolean foY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(BaseActivity baseActivity, boolean z) {
        this.bUo = baseActivity;
        this.foY = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        a.b(this.bUo.getPageContext().getPageActivity(), this.foY);
    }
}
