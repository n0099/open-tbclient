package com.baidu.tieba.util;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class ar {
    private static ArrayList<as> b = new ArrayList<>();

    /* renamed from: a  reason: collision with root package name */
    public static AtomicInteger f2428a = new AtomicInteger(0);

    public static int a(int i) {
        return f2428a.getAndSet(i);
    }

    public static int b(int i) {
        return f2428a.addAndGet(i);
    }

    public static synchronized void a(as asVar) {
        synchronized (ar.class) {
            if (asVar != null) {
                if (b.size() <= 20) {
                    b.add(asVar);
                }
            }
        }
    }

    public static synchronized as a() {
        as remove;
        synchronized (ar.class) {
            int size = b.size();
            remove = size > 0 ? b.remove(size - 1) : null;
        }
        return remove;
    }
}
