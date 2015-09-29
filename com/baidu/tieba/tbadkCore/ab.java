package com.baidu.tieba.tbadkCore;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.tbadkCore.aa;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab extends Handler {
    final /* synthetic */ aa cXH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(aa aaVar) {
        this.cXH = aaVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i;
        aa.a aVar;
        aa.a aVar2;
        if (message.what == 2) {
            this.cXH.count = 0;
            this.cXH.cgr = 0L;
            this.cXH.cgs = 0L;
        } else if (message.what == 1) {
            i = this.cXH.count;
            if (i == 1) {
                aVar = this.cXH.cXG;
                if (aVar != null) {
                    aVar2 = this.cXH.cXG;
                    aVar2.Mi();
                }
                this.cXH.count = 0;
                this.cXH.cgr = 0L;
                this.cXH.cgs = 0L;
            }
        }
    }
}
