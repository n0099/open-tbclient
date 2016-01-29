package com.baidu.tieba.tbadkCore;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.tbadkCore.aa;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab extends Handler {
    final /* synthetic */ aa dVH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(aa aaVar) {
        this.dVH = aaVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i;
        aa.a aVar;
        aa.a aVar2;
        if (message.what == 2) {
            this.dVH.count = 0;
            this.dVH.cJP = 0L;
            this.dVH.cJQ = 0L;
        } else if (message.what == 1) {
            i = this.dVH.count;
            if (i == 1) {
                aVar = this.dVH.dVG;
                if (aVar != null) {
                    aVar2 = this.dVH.dVG;
                    aVar2.Qs();
                }
                this.dVH.count = 0;
                this.dVH.cJP = 0L;
                this.dVH.cJQ = 0L;
            }
        }
    }
}
