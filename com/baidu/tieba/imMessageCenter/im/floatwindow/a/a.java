package com.baidu.tieba.imMessageCenter.im.floatwindow.a;

import android.os.Looper;
import android.os.Message;
/* loaded from: classes.dex */
public class a {
    private static a bqF;
    private final b bqG = new b(this, Looper.getMainLooper());

    private a() {
    }

    public static a UD() {
        if (bqF == null) {
            bqF = new a();
        }
        return bqF;
    }

    public void a(c cVar) {
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.obj = cVar;
        this.bqG.sendMessage(obtain);
    }
}
