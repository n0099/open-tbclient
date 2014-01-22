package com.baidu.tieba.util;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class bm {
    private static ArrayList<bn> b = new ArrayList<>();
    public static AtomicInteger a = new AtomicInteger(0);

    public static int a(int i) {
        return a.getAndSet(i);
    }

    public static int b(int i) {
        return a.addAndGet(i);
    }

    public static synchronized void a(bn bnVar) {
        synchronized (bm.class) {
            if (bnVar != null) {
                if (b.size() <= 20) {
                    b.add(bnVar);
                }
            }
        }
    }

    public static synchronized bn a() {
        bn remove;
        synchronized (bm.class) {
            int size = b.size();
            remove = size > 0 ? b.remove(size - 1) : null;
        }
        return remove;
    }
}
