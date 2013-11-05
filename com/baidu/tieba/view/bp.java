package com.baidu.tieba.view;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bp extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WaterFallView f2529a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bp(WaterFallView waterFallView) {
        this.f2529a = waterFallView;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        br brVar;
        br brVar2;
        super.handleMessage(message);
        if (message.what == 101) {
            brVar = this.f2529a.o;
            if (brVar != null) {
                brVar2 = this.f2529a.o;
                brVar2.d();
            }
        }
    }
}
