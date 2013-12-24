package com.baidu.tieba.util;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class ay {
    private static ArrayList<az> b = new ArrayList<>();
    public static AtomicInteger a = new AtomicInteger(0);

    public static int a(int i) {
        return a.getAndSet(i);
    }

    public static int b(int i) {
        return a.addAndGet(i);
    }

    public static synchronized void a(az azVar) {
        synchronized (ay.class) {
            if (azVar != null) {
                if (b.size() <= 20) {
                    b.add(azVar);
                }
            }
        }
    }

    public static synchronized az a() {
        az remove;
        synchronized (ay.class) {
            int size = b.size();
            remove = size > 0 ? b.remove(size - 1) : null;
        }
        return remove;
    }
}
