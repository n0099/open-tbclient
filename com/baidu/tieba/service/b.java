package com.baidu.tieba.service;

import android.os.Handler;
import com.baidu.tieba.switchs.SwitchKey;
import com.baidu.tieba.util.af;
import com.baidu.tieba.util.bg;
import java.io.File;
/* loaded from: classes.dex */
class b extends Thread {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ClearTempService f2339a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ClearTempService clearTempService) {
        this.f2339a = clearTempService;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Handler handler;
        Handler handler2;
        super.run();
        try {
            File file = new File(af.f2480a + "/tieba/image");
            File file2 = new File(af.f2480a + "/tieba/share");
            File file3 = new File(af.f2480a + "/tieba/" + SwitchKey.VOICE);
            this.f2339a.a(file);
            this.f2339a.a(file2);
            this.f2339a.a(file3);
        } catch (Exception e) {
            bg.b(getClass().getName(), "run", e.getMessage());
        }
        handler = this.f2339a.c;
        handler2 = this.f2339a.c;
        handler.sendMessage(handler2.obtainMessage());
    }
}
