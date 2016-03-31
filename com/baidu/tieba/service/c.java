package com.baidu.tieba.service;

import android.os.Handler;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.m;
import java.io.File;
/* loaded from: classes.dex */
class c extends Thread {
    final /* synthetic */ ClearTempService eaq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ClearTempService clearTempService) {
        this.eaq = clearTempService;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Handler handler;
        Handler handler2;
        super.run();
        try {
            File file = new File(m.yB + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_PIC_DIR_NAME);
            File file2 = new File(m.yB + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_SHARE_DIR_NAME);
            File file3 = new File(m.yB + "/" + TbConfig.getTempDirName() + "/voice");
            this.eaq.deleteCache(file, false);
            this.eaq.deleteDir(file2);
            this.eaq.deleteDir(file3);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        handler = this.eaq.handler;
        handler2 = this.eaq.handler;
        handler.sendMessage(handler2.obtainMessage());
    }
}
