package com.baidu.tieba.pb;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
class bf implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f1552a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(NewPbActivity newPbActivity) {
        this.f1552a = newPbActivity;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        com.baidu.tieba.model.bd bdVar;
        br brVar;
        br brVar2;
        switch (message.what) {
            case 0:
                brVar2 = this.f1552a.t;
                brVar2.af();
                return false;
            case 1:
                brVar = this.f1552a.t;
                brVar.ae();
                return false;
            case 2:
                bdVar = this.f1552a.n;
                if (!bdVar.s()) {
                    return false;
                }
                this.f1552a.t();
                return false;
            default:
                return false;
        }
    }
}
