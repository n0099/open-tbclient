package com.baidu.tieba.tbadkCore;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.tbadkCore.aa;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab extends Handler {
    final /* synthetic */ aa cYh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(aa aaVar) {
        this.cYh = aaVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i;
        aa.a aVar;
        aa.a aVar2;
        if (message.what == 2) {
            this.cYh.count = 0;
            this.cYh.cgC = 0L;
            this.cYh.cgD = 0L;
        } else if (message.what == 1) {
            i = this.cYh.count;
            if (i == 1) {
                aVar = this.cYh.cYg;
                if (aVar != null) {
                    aVar2 = this.cYh.cYg;
                    aVar2.Mi();
                }
                this.cYh.count = 0;
                this.cYh.cgC = 0L;
                this.cYh.cgD = 0L;
            }
        }
    }
}
