package com.baidu.tieba.tbadkCore;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.tbadkCore.aa;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab extends Handler {
    final /* synthetic */ aa eom;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(aa aaVar) {
        this.eom = aaVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i;
        aa.a aVar;
        aa.a aVar2;
        if (message.what == 2) {
            this.eom.count = 0;
            this.eom.ddg = 0L;
            this.eom.ddh = 0L;
        } else if (message.what == 1) {
            i = this.eom.count;
            if (i == 1) {
                aVar = this.eom.eol;
                if (aVar != null) {
                    aVar2 = this.eom.eol;
                    aVar2.Sl();
                }
                this.eom.count = 0;
                this.eom.ddg = 0L;
                this.eom.ddh = 0L;
            }
        }
    }
}
