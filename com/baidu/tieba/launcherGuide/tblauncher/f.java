package com.baidu.tieba.launcherGuide.tblauncher;

import com.baidu.tbadk.TbadkApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class f implements Runnable {
    final /* synthetic */ GuideActivity dmV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(GuideActivity guideActivity) {
        this.dmV = guideActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        TbadkApplication.getInst().setUsed();
    }
}
