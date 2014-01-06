package com.baidu.tieba.util;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class bk {
    private volatile int b;
    private volatile HashMap<Long, Integer> c = new HashMap<>();
    private volatile int a = 0;

    public bk(int i) {
        this.b = i;
    }

    public void a(String str) {
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                if (this.c.size() >= this.b) {
                    a();
                }
                this.a++;
                this.c.put(valueOf, Integer.valueOf(this.a));
            }
        } catch (Exception e) {
            bo.b(getClass().getName(), "addThread", e.getMessage());
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
            bo.b(getClass().getName(), "getThread", e.getMessage());
            return false;
        }
    }
}
