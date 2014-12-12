package com.baidu.tieba.service;

import android.os.Handler;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import java.io.File;
/* loaded from: classes.dex */
class d extends Thread {
    final /* synthetic */ ClearTempService bNj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ClearTempService clearTempService) {
        this.bNj = clearTempService;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Handler handler;
        Handler handler2;
        super.run();
        try {
            File file = new File(com.baidu.tbadk.core.util.s.mG + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_PIC_DIR_NAME);
            File file2 = new File(com.baidu.tbadk.core.util.s.mG + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_SHARE_DIR_NAME);
            File file3 = new File(com.baidu.tbadk.core.util.s.mG + "/" + TbConfig.getTempDirName() + "/voice");
            this.bNj.deleteCache(file, false);
            this.bNj.deleteDir(file2);
            this.bNj.deleteDir(file3);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        handler = this.bNj.handler;
        handler2 = this.bNj.handler;
        handler.sendMessage(handler2.obtainMessage());
    }
}
