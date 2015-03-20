package com.baidu.tieba.service;

import android.os.Handler;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import java.io.File;
/* loaded from: classes.dex */
class d extends Thread {
    final /* synthetic */ ClearTempService bYY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ClearTempService clearTempService) {
        this.bYY = clearTempService;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Handler handler;
        Handler handler2;
        super.run();
        try {
            File file = new File(com.baidu.tbadk.core.util.o.yl + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_PIC_DIR_NAME);
            File file2 = new File(com.baidu.tbadk.core.util.o.yl + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_SHARE_DIR_NAME);
            File file3 = new File(com.baidu.tbadk.core.util.o.yl + "/" + TbConfig.getTempDirName() + "/voice");
            this.bYY.deleteCache(file, false);
            this.bYY.deleteDir(file2);
            this.bYY.deleteDir(file3);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        handler = this.bYY.handler;
        handler2 = this.bYY.handler;
        handler.sendMessage(handler2.obtainMessage());
    }
}
