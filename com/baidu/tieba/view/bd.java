package com.baidu.tieba.view;

import android.os.Handler;
import android.os.Message;
import java.util.Timer;
/* loaded from: classes.dex */
class bd implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ShakeCutDownView f2521a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(ShakeCutDownView shakeCutDownView) {
        this.f2521a = shakeCutDownView;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        bf bfVar;
        bf bfVar2;
        int i;
        int i2;
        Timer timer;
        switch (message.what) {
            case 0:
                ShakeCutDownView.a(this.f2521a);
                ShakeCutDownView shakeCutDownView = this.f2521a;
                i = this.f2521a.e;
                shakeCutDownView.a(i);
                i2 = this.f2521a.e;
                if (i2 <= 0) {
                    timer = this.f2521a.d;
                    timer.cancel();
                    return false;
                }
                return false;
            case 1:
                bfVar = this.f2521a.b;
                if (bfVar != null) {
                    bfVar2 = this.f2521a.b;
                    bfVar2.a();
                    return false;
                }
                return false;
            default:
                return false;
        }
    }
}
