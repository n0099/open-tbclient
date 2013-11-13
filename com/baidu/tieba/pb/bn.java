package com.baidu.tieba.pb;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
class bn implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f2098a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bn(NewPbActivity newPbActivity) {
        this.f2098a = newPbActivity;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        com.baidu.tieba.model.bm bmVar;
        cp cpVar;
        cp cpVar2;
        switch (message.what) {
            case 0:
                cpVar2 = this.f2098a.y;
                cpVar2.ac();
                return false;
            case 1:
                cpVar = this.f2098a.y;
                cpVar.ab();
                return false;
            case 2:
                bmVar = this.f2098a.s;
                if (bmVar.t()) {
                    this.f2098a.r();
                    return false;
                }
                return false;
            default:
                return false;
        }
    }
}
