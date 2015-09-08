package com.baidu.tieba.tbadkCore;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.tbadkCore.aa;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab extends Handler {
    final /* synthetic */ aa cQo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(aa aaVar) {
        this.cQo = aaVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i;
        aa.a aVar;
        aa.a aVar2;
        if (message.what == 2) {
            this.cQo.count = 0;
            this.cQo.cbm = 0L;
            this.cQo.cbn = 0L;
        } else if (message.what == 1) {
            i = this.cQo.count;
            if (i == 1) {
                aVar = this.cQo.cQn;
                if (aVar != null) {
                    aVar2 = this.cQo.cQn;
                    aVar2.Mj();
                }
                this.cQo.count = 0;
                this.cQo.cbm = 0L;
                this.cQo.cbn = 0L;
            }
        }
    }
}
