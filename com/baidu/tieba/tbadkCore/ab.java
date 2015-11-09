package com.baidu.tieba.tbadkCore;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.tbadkCore.aa;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab extends Handler {
    final /* synthetic */ aa cZE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(aa aaVar) {
        this.cZE = aaVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i;
        aa.a aVar;
        aa.a aVar2;
        if (message.what == 2) {
            this.cZE.count = 0;
            this.cZE.chh = 0L;
            this.cZE.chi = 0L;
        } else if (message.what == 1) {
            i = this.cZE.count;
            if (i == 1) {
                aVar = this.cZE.cZD;
                if (aVar != null) {
                    aVar2 = this.cZE.cZD;
                    aVar2.Mu();
                }
                this.cZE.count = 0;
                this.cZE.chh = 0L;
                this.cZE.chi = 0L;
            }
        }
    }
}
