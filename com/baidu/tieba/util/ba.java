package com.baidu.tieba.util;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class ba {
    private static ArrayList<bb> b = new ArrayList<>();

    /* renamed from: a  reason: collision with root package name */
    public static AtomicInteger f2479a = new AtomicInteger(0);

    public static int a(int i) {
        return f2479a.getAndSet(i);
    }

    public static int b(int i) {
        return f2479a.addAndGet(i);
    }

    public static synchronized void a(bb bbVar) {
        synchronized (ba.class) {
            if (bbVar != null) {
                if (b.size() <= 20) {
                    b.add(bbVar);
                }
            }
        }
    }

    public static synchronized bb a() {
        bb remove;
        synchronized (ba.class) {
            int size = b.size();
            remove = size > 0 ? b.remove(size - 1) : null;
        }
        return remove;
    }
}
