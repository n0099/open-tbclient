package com.baidu.tieba.util;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class ae {
    private static ArrayList b = new ArrayList();

    /* renamed from: a  reason: collision with root package name */
    public static AtomicInteger f1779a = new AtomicInteger(0);

    public static int a(int i) {
        return f1779a.getAndSet(i);
    }

    public static int b(int i) {
        return f1779a.addAndGet(i);
    }

    public static synchronized void a(af afVar) {
        synchronized (ae.class) {
            if (afVar != null) {
                if (b.size() <= 20) {
                    b.add(afVar);
                }
            }
        }
    }

    public static synchronized af a() {
        af afVar;
        synchronized (ae.class) {
            int size = b.size();
            afVar = size > 0 ? (af) b.remove(size - 1) : null;
        }
        return afVar;
    }
}
