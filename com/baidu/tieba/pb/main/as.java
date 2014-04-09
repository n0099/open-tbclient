package com.baidu.tieba.pb.main;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
final class as implements Handler.Callback {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        bf bfVar;
        bm bmVar;
        bm bmVar2;
        switch (message.what) {
            case 0:
                bmVar2 = this.a.D;
                bmVar2.ae();
                return false;
            case 1:
                bmVar = this.a.D;
                bmVar.ad();
                return false;
            case 2:
                bfVar = this.a.x;
                if (bfVar.w()) {
                    PbActivity.c(this.a);
                    return false;
                }
                return false;
            default:
                return false;
        }
    }
}
