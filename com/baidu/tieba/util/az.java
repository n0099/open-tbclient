package com.baidu.tieba.util;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class az {
    private volatile int b;
    private volatile HashMap<Long, Integer> c = new HashMap<>();

    /* renamed from: a  reason: collision with root package name */
    private volatile int f2594a = 0;

    public az(int i) {
        this.b = i;
    }

    public void a(String str) {
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                if (this.c.size() >= this.b) {
                    a();
                }
                this.f2594a++;
                this.c.put(valueOf, Integer.valueOf(this.f2594a));
            }
        } catch (Exception e) {
            bd.b(getClass().getName(), "addThread", e.getMessage());
        }
    }

    public void a() {
        int i;
        Long l;
        synchronized (this) {
            Long l2 = null;
            int i2 = 134217727;
            for (Map.Entry<Long, Integer> entry : this.c.entrySet()) {
                if (entry.getValue().intValue() < i2) {
                    int intValue = entry.getValue().intValue();
                    l = entry.getKey();
                    i = intValue;
                } else {
                    i = i2;
                    l = l2;
                }
                i2 = i;
                l2 = l;
            }
            if (l2 != null) {
                this.c.remove(l2);
            } else {
                this.c.clear();
            }
        }
    }

    public boolean b(String str) {
        boolean z;
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                z = this.c.get(valueOf) != null;
            }
            return z;
        } catch (Exception e) {
            bd.b(getClass().getName(), "getThread", e.getMessage());
            return false;
        }
    }
}
