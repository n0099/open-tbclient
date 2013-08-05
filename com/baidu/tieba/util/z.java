package com.baidu.tieba.util;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class z {
    private volatile int b;
    private volatile HashMap c = new HashMap();

    /* renamed from: a  reason: collision with root package name */
    private volatile int f1779a = 0;

    public z(int i) {
        this.b = i;
    }

    public void a(String str) {
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                if (this.c.size() >= this.b) {
                    a();
                }
                this.f1779a++;
                this.c.put(valueOf, Integer.valueOf(this.f1779a));
            }
        } catch (Exception e) {
            aj.b(getClass().getName(), "addThread", e.getMessage());
        }
    }

    public void a() {
        synchronized (this) {
            int i = 134217727;
            Long l = null;
            for (Map.Entry entry : this.c.entrySet()) {
                if (((Integer) entry.getValue()).intValue() < i) {
                    i = ((Integer) entry.getValue()).intValue();
                    l = (Long) entry.getKey();
                }
            }
            if (l != null) {
                this.c.remove(l);
            } else {
                this.c.clear();
            }
        }
    }

    public boolean b(String str) {
        boolean z = false;
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                if (this.c.get(valueOf) != null) {
                    z = true;
                }
            }
        } catch (Exception e) {
            aj.b(getClass().getName(), "getThread", e.getMessage());
        }
        return z;
    }
}
