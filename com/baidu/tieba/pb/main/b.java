package com.baidu.tieba.pb.main;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
class b implements Handler.Callback {
    final /* synthetic */ PbActivity bzj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(PbActivity pbActivity) {
        this.bzj = pbActivity;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        bq bqVar;
        bq bqVar2;
        switch (message.what) {
            case 2:
                bqVar = this.bzj.byJ;
                if (bqVar != null) {
                    bqVar2 = this.bzj.byJ;
                    if (bqVar2.li()) {
                        this.bzj.WM();
                        break;
                    }
                }
                break;
        }
        return false;
    }
}
