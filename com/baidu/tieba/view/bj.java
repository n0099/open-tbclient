package com.baidu.tieba.view;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bj extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WaterFallView f1866a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(WaterFallView waterFallView) {
        this.f1866a = waterFallView;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        bl blVar;
        bl blVar2;
        super.handleMessage(message);
        if (message.what == 101) {
            blVar = this.f1866a.o;
            if (blVar != null) {
                blVar2 = this.f1866a.o;
                blVar2.d();
            }
        }
    }
}
