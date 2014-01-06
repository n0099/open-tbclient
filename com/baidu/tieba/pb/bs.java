package com.baidu.tieba.pb;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
class bs implements Handler.Callback {
    final /* synthetic */ NewPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bs(NewPbActivity newPbActivity) {
        this.a = newPbActivity;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        com.baidu.tieba.model.bm bmVar;
        cs csVar;
        cs csVar2;
        switch (message.what) {
            case 0:
                csVar2 = this.a.z;
                csVar2.ac();
                return false;
            case 1:
                csVar = this.a.z;
                csVar.ab();
                return false;
            case 2:
                bmVar = this.a.t;
                if (bmVar.t()) {
                    this.a.t();
                    return false;
                }
                return false;
            default:
                return false;
        }
    }
}
