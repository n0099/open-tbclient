package com.baidu.tieba.view;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bv extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WaterFallView f2567a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bv(WaterFallView waterFallView) {
        this.f2567a = waterFallView;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        bx bxVar;
        bx bxVar2;
        super.handleMessage(message);
        if (message.what == 101) {
            bxVar = this.f2567a.o;
            if (bxVar != null) {
                bxVar2 = this.f2567a.o;
                bxVar2.d();
            }
        }
    }
}
