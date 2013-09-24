package com.baidu.tieba.view;

import android.os.Handler;
import android.os.Message;
import java.util.Timer;
/* loaded from: classes.dex */
class bd implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ShakeCutDownView f1988a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(ShakeCutDownView shakeCutDownView) {
        this.f1988a = shakeCutDownView;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        bf bfVar;
        bf bfVar2;
        int i;
        int i2;
        int i3;
        Timer timer;
        switch (message.what) {
            case 0:
                ShakeCutDownView shakeCutDownView = this.f1988a;
                i = shakeCutDownView.e;
                shakeCutDownView.e = i - 1;
                ShakeCutDownView shakeCutDownView2 = this.f1988a;
                i2 = this.f1988a.e;
                shakeCutDownView2.a(i2);
                i3 = this.f1988a.e;
                if (i3 <= 0) {
                    timer = this.f1988a.d;
                    timer.cancel();
                    return false;
                }
                return false;
            case 1:
                bfVar = this.f1988a.b;
                if (bfVar != null) {
                    bfVar2 = this.f1988a.b;
                    bfVar2.a();
                    return false;
                }
                return false;
            default:
                return false;
        }
    }
}
