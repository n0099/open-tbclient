package com.baidu.tieba.launcherGuide.tblauncher;

import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
class f implements Runnable {
    final /* synthetic */ GuideActivity bTf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(GuideActivity guideActivity) {
        this.bTf = guideActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        TbadkApplication.getInst().setUsed();
    }
}
