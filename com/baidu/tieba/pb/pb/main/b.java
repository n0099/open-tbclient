package com.baidu.tieba.pb.pb.main;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
class b implements Handler.Callback {
    final /* synthetic */ PbActivity bIv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(PbActivity pbActivity) {
        this.bIv = pbActivity;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        bq bqVar;
        bq bqVar2;
        switch (message.what) {
            case 2:
                bqVar = this.bIv.bHT;
                if (bqVar != null) {
                    bqVar2 = this.bIv.bHT;
                    if (bqVar2.oQ()) {
                        this.bIv.Zs();
                        break;
                    }
                }
                break;
        }
        return false;
    }
}
