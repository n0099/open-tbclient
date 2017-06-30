package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.z;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ee implements Runnable {
    final /* synthetic */ dy exY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ee(dy dyVar) {
        this.exY = dyVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        z.a aVar;
        z.a aVar2;
        z.a aVar3;
        z.a aVar4;
        try {
            aVar = this.exY.viewholder;
            if (aVar != null) {
                aVar2 = this.exY.viewholder;
                if (((ef) aVar2).eye != null) {
                    aVar3 = this.exY.viewholder;
                    ((ef) aVar3).eye.destroy();
                    aVar4 = this.exY.viewholder;
                    ((ef) aVar4).eye = null;
                }
            }
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }
}
