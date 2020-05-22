package com.baidu.tieba.write.b.a;
/* loaded from: classes7.dex */
public class e {
    private static volatile d lTw;

    public static synchronized d dnd() {
        d dVar;
        synchronized (e.class) {
            if (lTw == null) {
                lTw = new d();
            }
            dVar = lTw;
        }
        return dVar;
    }
}
