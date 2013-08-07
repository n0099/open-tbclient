package com.baidu.tieba.view;

import android.os.Handler;
import android.os.Message;
import java.util.Timer;
/* loaded from: classes.dex */
class bc implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ShakeCutDownView f1829a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(ShakeCutDownView shakeCutDownView) {
        this.f1829a = shakeCutDownView;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        be beVar;
        be beVar2;
        int i;
        int i2;
        int i3;
        Timer timer;
        switch (message.what) {
            case 0:
                ShakeCutDownView shakeCutDownView = this.f1829a;
                i = shakeCutDownView.e;
                shakeCutDownView.e = i - 1;
                ShakeCutDownView shakeCutDownView2 = this.f1829a;
                i2 = this.f1829a.e;
                shakeCutDownView2.a(i2);
                i3 = this.f1829a.e;
                if (i3 <= 0) {
                    timer = this.f1829a.d;
                    timer.cancel();
                    return false;
                }
                return false;
            case 1:
                beVar = this.f1829a.b;
                if (beVar != null) {
                    beVar2 = this.f1829a.b;
                    beVar2.a();
                    return false;
                }
                return false;
            default:
                return false;
        }
    }
}
