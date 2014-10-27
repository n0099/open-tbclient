package com.baidu.tieba.service;

import android.os.Handler;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import java.io.File;
/* loaded from: classes.dex */
class d extends Thread {
    final /* synthetic */ ClearTempService bII;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ClearTempService clearTempService) {
        this.bII = clearTempService;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Handler handler;
        Handler handler2;
        super.run();
        try {
            File file = new File(com.baidu.tbadk.core.util.s.mI + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_PIC_DIR_NAME);
            File file2 = new File(com.baidu.tbadk.core.util.s.mI + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_SHARE_DIR_NAME);
            File file3 = new File(com.baidu.tbadk.core.util.s.mI + "/" + TbConfig.getTempDirName() + "/voice");
            this.bII.deleteCache(file, false);
            this.bII.deleteDir(file2);
            this.bII.deleteDir(file3);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        handler = this.bII.handler;
        handler2 = this.bII.handler;
        handler.sendMessage(handler2.obtainMessage());
    }
}
