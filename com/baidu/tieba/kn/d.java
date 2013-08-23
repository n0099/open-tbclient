package com.baidu.tieba.kn;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends Handler {

    /* renamed from: a  reason: collision with root package name */
    private WeakReference f1206a;

    public d(TimerTextView timerTextView) {
        this.f1206a = new WeakReference(timerTextView);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        TimerTextView timerTextView;
        b bVar;
        b bVar2;
        if (message.what != 65536 || (timerTextView = (TimerTextView) this.f1206a.get()) == null) {
            return;
        }
        bVar = timerTextView.b;
        if (bVar.a()) {
            sendEmptyMessageDelayed(65536, 1000L);
        }
        bVar2 = timerTextView.b;
        timerTextView.setText(bVar2.toString());
    }
}
