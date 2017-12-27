package com.baidu.tieba.tbadkCore.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class e {
    protected volatile int hlo;
    protected volatile HashMap<Long, Integer> hlp = new HashMap<>();
    private volatile int hln = 0;

    public e(int i) {
        this.hlo = i;
    }

    public void tm(String str) {
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                if (this.hlp.size() >= this.hlo) {
                    bnk();
                }
                this.hln++;
                this.hlp.put(valueOf, Integer.valueOf(this.hln));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void bnk() {
        int i;
        Long l;
        synchronized (this) {
            Long l2 = null;
            int i2 = 134217727;
            for (Map.Entry<Long, Integer> entry : this.hlp.entrySet()) {
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
                this.hlp.remove(l2);
            } else {
                this.hlp.clear();
            }
        }
    }

    public boolean tn(String str) {
        boolean z;
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                z = this.hlp.get(valueOf) != null;
            }
            return z;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public boolean to(String str) {
        try {
            return this.hlp.containsKey(Long.valueOf(Long.parseLong(str)));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void bDi() {
        synchronized (this) {
            this.hlp.clear();
        }
    }
}
