package com.baidu.tieba.imMessageCenter.im.floatwindow.a;

import android.os.Looper;
import android.os.Message;
/* loaded from: classes.dex */
public class a {
    private static a bqV;
    private final b bqW = new b(this, Looper.getMainLooper());

    private a() {
    }

    public static a UQ() {
        if (bqV == null) {
            bqV = new a();
        }
        return bqV;
    }

    public void a(c cVar) {
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.obj = cVar;
        this.bqW.sendMessage(obtain);
    }
}
