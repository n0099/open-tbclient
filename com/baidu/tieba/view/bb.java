package com.baidu.tieba.view;

import android.os.Handler;
import android.os.Message;
import java.util.Timer;
/* loaded from: classes.dex */
class bb implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ShakeCutDownView f1860a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(ShakeCutDownView shakeCutDownView) {
        this.f1860a = shakeCutDownView;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        bd bdVar;
        bd bdVar2;
        int i;
        int i2;
        int i3;
        Timer timer;
        switch (message.what) {
            case 0:
                ShakeCutDownView shakeCutDownView = this.f1860a;
                i = shakeCutDownView.e;
                shakeCutDownView.e = i - 1;
                ShakeCutDownView shakeCutDownView2 = this.f1860a;
                i2 = this.f1860a.e;
                shakeCutDownView2.a(i2);
                i3 = this.f1860a.e;
                if (i3 <= 0) {
                    timer = this.f1860a.d;
                    timer.cancel();
                    return false;
                }
                return false;
            case 1:
                bdVar = this.f1860a.b;
                if (bdVar != null) {
                    bdVar2 = this.f1860a.b;
                    bdVar2.a();
                    return false;
                }
                return false;
            default:
                return false;
        }
    }
}
