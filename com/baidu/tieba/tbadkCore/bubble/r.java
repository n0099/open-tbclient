package com.baidu.tieba.tbadkCore.bubble;

import com.baidu.tbadk.BaseActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements Runnable {
    private final /* synthetic */ BaseActivity aZC;
    private final /* synthetic */ boolean bVZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(BaseActivity baseActivity, boolean z) {
        this.aZC = baseActivity;
        this.bVZ = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        m.a(this.aZC.getPageContext().getPageActivity(), this.bVZ);
    }
}
