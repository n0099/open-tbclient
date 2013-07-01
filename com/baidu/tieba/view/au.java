package com.baidu.tieba.view;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class au extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WaterFallView f1516a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(WaterFallView waterFallView) {
        this.f1516a = waterFallView;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        aw awVar;
        aw awVar2;
        super.handleMessage(message);
        if (message.what == 101) {
            awVar = this.f1516a.o;
            if (awVar != null) {
                awVar2 = this.f1516a.o;
                awVar2.d();
            }
        }
    }
}
