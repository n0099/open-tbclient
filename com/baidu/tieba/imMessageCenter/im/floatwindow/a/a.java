package com.baidu.tieba.imMessageCenter.im.floatwindow.a;

import android.os.Looper;
import android.os.Message;
/* loaded from: classes.dex */
public class a {
    private static a btF;
    private final b btG = new b(this, Looper.getMainLooper());

    private a() {
    }

    public static a Wh() {
        if (btF == null) {
            btF = new a();
        }
        return btF;
    }

    public void a(c cVar) {
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.obj = cVar;
        this.btG.sendMessage(obtain);
    }
}
