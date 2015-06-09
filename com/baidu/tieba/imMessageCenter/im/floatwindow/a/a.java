package com.baidu.tieba.imMessageCenter.im.floatwindow.a;

import android.os.Looper;
import android.os.Message;
/* loaded from: classes.dex */
public class a {
    private static a btG;
    private final b btH = new b(this, Looper.getMainLooper());

    private a() {
    }

    public static a Wi() {
        if (btG == null) {
            btG = new a();
        }
        return btG;
    }

    public void a(c cVar) {
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.obj = cVar;
        this.btH.sendMessage(obtain);
    }
}
