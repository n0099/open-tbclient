package com.baidu.tieba.pb.main;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
final class aq implements Handler.Callback {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        bd bdVar;
        bk bkVar;
        bk bkVar2;
        switch (message.what) {
            case 0:
                bkVar2 = this.a.D;
                bkVar2.ae();
                return false;
            case 1:
                bkVar = this.a.D;
                bkVar.ad();
                return false;
            case 2:
                bdVar = this.a.x;
                if (bdVar.w()) {
                    PbActivity.c(this.a);
                    return false;
                }
                return false;
            default:
                return false;
        }
    }
}
