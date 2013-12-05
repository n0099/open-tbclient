package com.baidu.tieba.view;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class by extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WaterFallView f2684a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public by(WaterFallView waterFallView) {
        this.f2684a = waterFallView;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        ca caVar;
        ca caVar2;
        super.handleMessage(message);
        if (message.what == 101) {
            caVar = this.f2684a.o;
            if (caVar != null) {
                caVar2 = this.f2684a.o;
                caVar2.d();
            }
        }
    }
}
