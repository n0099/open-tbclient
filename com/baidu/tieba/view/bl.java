package com.baidu.tieba.view;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bl extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WaterFallView f1994a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bl(WaterFallView waterFallView) {
        this.f1994a = waterFallView;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        bn bnVar;
        bn bnVar2;
        super.handleMessage(message);
        if (message.what == 101) {
            bnVar = this.f1994a.o;
            if (bnVar != null) {
                bnVar2 = this.f1994a.o;
                bnVar2.d();
            }
        }
    }
}
