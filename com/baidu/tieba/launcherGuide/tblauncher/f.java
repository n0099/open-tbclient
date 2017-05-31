package com.baidu.tieba.launcherGuide.tblauncher;

import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes2.dex */
class f implements Runnable {
    final /* synthetic */ GuideActivity dsp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(GuideActivity guideActivity) {
        this.dsp = guideActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        TbadkApplication.getInst().setUsed();
    }
}
