package com.baidu.tieba.tbadkCore;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.tbadkCore.aa;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab extends Handler {
    final /* synthetic */ aa ffl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(aa aaVar) {
        this.ffl = aaVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i;
        aa.a aVar;
        aa.a aVar2;
        if (message.what == 2) {
            this.ffl.count = 0;
            this.ffl.dXe = 0L;
            this.ffl.dXf = 0L;
        } else if (message.what == 1) {
            i = this.ffl.count;
            if (i == 1) {
                aVar = this.ffl.ffk;
                if (aVar != null) {
                    aVar2 = this.ffl.ffk;
                    aVar2.XO();
                }
                this.ffl.count = 0;
                this.ffl.dXe = 0L;
                this.ffl.dXf = 0L;
            }
        }
    }
}
