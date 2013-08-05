package com.baidu.tieba.view;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bk extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WaterFallView f1837a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(WaterFallView waterFallView) {
        this.f1837a = waterFallView;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        bm bmVar;
        bm bmVar2;
        super.handleMessage(message);
        if (message.what == 101) {
            bmVar = this.f1837a.o;
            if (bmVar != null) {
                bmVar2 = this.f1837a.o;
                bmVar2.d();
            }
        }
    }
}
