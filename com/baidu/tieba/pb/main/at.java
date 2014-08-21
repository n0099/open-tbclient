package com.baidu.tieba.pb.main;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
class at implements Handler.Callback {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        bl blVar;
        bl blVar2;
        switch (message.what) {
            case 2:
                blVar = this.a.y;
                if (blVar != null) {
                    blVar2 = this.a.y;
                    if (blVar2.B()) {
                        this.a.D();
                        break;
                    }
                }
                break;
        }
        return false;
    }
}
