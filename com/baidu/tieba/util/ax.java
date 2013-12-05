package com.baidu.tieba.util;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class ax {
    private static ArrayList<ay> b = new ArrayList<>();

    /* renamed from: a  reason: collision with root package name */
    public static AtomicInteger f2592a = new AtomicInteger(0);

    public static int a(int i) {
        return f2592a.getAndSet(i);
    }

    public static int b(int i) {
        return f2592a.addAndGet(i);
    }

    public static synchronized void a(ay ayVar) {
        synchronized (ax.class) {
            if (ayVar != null) {
                if (b.size() <= 20) {
                    b.add(ayVar);
                }
            }
        }
    }

    public static synchronized ay a() {
        ay remove;
        synchronized (ax.class) {
            int size = b.size();
            remove = size > 0 ? b.remove(size - 1) : null;
        }
        return remove;
    }
}
