package com.baidu.tieba.service;

import android.os.Handler;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.n;
import java.io.File;
/* loaded from: classes.dex */
class c extends Thread {
    final /* synthetic */ ClearTempService cMt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ClearTempService clearTempService) {
        this.cMt = clearTempService;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Handler handler;
        Handler handler2;
        super.run();
        try {
            File file = new File(n.xU + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_PIC_DIR_NAME);
            File file2 = new File(n.xU + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_SHARE_DIR_NAME);
            File file3 = new File(n.xU + "/" + TbConfig.getTempDirName() + "/voice");
            this.cMt.deleteCache(file, false);
            this.cMt.deleteDir(file2);
            this.cMt.deleteDir(file3);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        handler = this.cMt.handler;
        handler2 = this.cMt.handler;
        handler.sendMessage(handler2.obtainMessage());
    }
}
