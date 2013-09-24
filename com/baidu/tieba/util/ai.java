package com.baidu.tieba.util;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class ai {
    private static ArrayList<aj> b = new ArrayList<>();

    /* renamed from: a  reason: collision with root package name */
    public static AtomicInteger f1898a = new AtomicInteger(0);

    public static int a(int i) {
        return f1898a.getAndSet(i);
    }

    public static int b(int i) {
        return f1898a.addAndGet(i);
    }

    public static synchronized void a(aj ajVar) {
        synchronized (ai.class) {
            if (ajVar != null) {
                if (b.size() <= 20) {
                    b.add(ajVar);
                }
            }
        }
    }

    public static synchronized aj a() {
        aj remove;
        synchronized (ai.class) {
            int size = b.size();
            remove = size > 0 ? b.remove(size - 1) : null;
        }
        return remove;
    }
}
