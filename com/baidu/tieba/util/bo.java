package com.baidu.tieba.util;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class bo {
    private volatile int b;
    private volatile HashMap<Long, Integer> c = new HashMap<>();
    private volatile int a = 0;

    public bo(int i) {
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
            com.baidu.adp.lib.util.f.b(getClass().getName(), "addThread", e.getMessage());
        }
    }

    public void a() {
        synchronized (this) {
            int i = 134217727;
            Long l = null;
            for (Map.Entry<Long, Integer> entry : this.c.entrySet()) {
                if (entry.getValue().intValue() < i) {
                    i = entry.getValue().intValue();
                    l = entry.getKey();
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
            com.baidu.adp.lib.util.f.b(getClass().getName(), "getThread", e.getMessage());
        }
        return z;
    }
}
