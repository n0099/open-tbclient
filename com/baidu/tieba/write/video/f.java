package com.baidu.tieba.write.video;

import android.content.Intent;
import com.baidu.tbadk.core.atomData.MotuVideoConfig;
/* loaded from: classes.dex */
class f implements Runnable {
    final /* synthetic */ WriteVideoActivity fGf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(WriteVideoActivity writeVideoActivity) {
        this.fGf = writeVideoActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.fGf.getPageContext().getPageActivity().sendBroadcast(new Intent(MotuVideoConfig.ACTION_FINISH_VIDEO_ALL_ACTIVITY));
    }
}
