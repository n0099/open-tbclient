package com.baidu.tieba.util;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class bk {
    private static ArrayList<bl> b = new ArrayList<>();
    public static AtomicInteger a = new AtomicInteger(0);

    public static int a(int i) {
        return a.getAndSet(i);
    }

    public static int b(int i) {
        return a.addAndGet(i);
    }

    public static synchronized void a(bl blVar) {
        synchronized (bk.class) {
            if (blVar != null) {
                if (b.size() <= 20) {
                    b.add(blVar);
                }
            }
        }
    }

    public static synchronized bl a() {
        bl remove;
        synchronized (bk.class) {
            int size = b.size();
            remove = size > 0 ? b.remove(size - 1) : null;
        }
        return remove;
    }
}
