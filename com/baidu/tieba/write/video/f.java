package com.baidu.tieba.write.video;

import android.content.Intent;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MotuVideoConfig;
/* loaded from: classes.dex */
class f implements Runnable {
    final /* synthetic */ WriteVideoActivity fAB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(WriteVideoActivity writeVideoActivity) {
        this.fAB = writeVideoActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        Intent intent = new Intent(MotuVideoConfig.ACTION_FINISH_VIDEO_ALL_ACTIVITY);
        intent.setPackage(TbadkCoreApplication.m9getInst().getPackageName());
        this.fAB.getPageContext().getPageActivity().sendBroadcast(intent);
    }
}
