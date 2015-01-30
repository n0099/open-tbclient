package com.baidu.tieba.tbadkCore.bubble;

import com.baidu.tbadk.BaseActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements Runnable {
    private final /* synthetic */ boolean bXR;
    private final /* synthetic */ BaseActivity baZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(BaseActivity baseActivity, boolean z) {
        this.baZ = baseActivity;
        this.bXR = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        m.a(this.baZ.getPageContext().getPageActivity(), this.bXR);
    }
}
