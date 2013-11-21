package com.baidu.tieba.pb;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
class bp implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f2083a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bp(NewPbActivity newPbActivity) {
        this.f2083a = newPbActivity;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        com.baidu.tieba.model.bm bmVar;
        cr crVar;
        cr crVar2;
        switch (message.what) {
            case 0:
                crVar2 = this.f2083a.y;
                crVar2.ac();
                return false;
            case 1:
                crVar = this.f2083a.y;
                crVar.ab();
                return false;
            case 2:
                bmVar = this.f2083a.s;
                if (bmVar.t()) {
                    this.f2083a.r();
                    return false;
                }
                return false;
            default:
                return false;
        }
    }
}
