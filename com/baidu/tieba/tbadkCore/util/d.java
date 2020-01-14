package com.baidu.tieba.tbadkCore.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class d {
    protected volatile int cYR;
    protected volatile HashMap<Long, Integer> kip = new HashMap<>();
    private volatile int mWeight = 0;

    public d(int i) {
        this.cYR = i;
    }

    public void Ja(String str) {
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                if (this.kip.size() >= this.cYR) {
                    cKz();
                }
                this.mWeight++;
                this.kip.put(valueOf, Integer.valueOf(this.mWeight));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void cKz() {
        int i;
        Long l;
        synchronized (this) {
            Long l2 = null;
            int i2 = 134217727;
            for (Map.Entry<Long, Integer> entry : this.kip.entrySet()) {
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
                this.kip.remove(l2);
            } else {
                this.kip.clear();
            }
        }
    }

    public boolean Jb(String str) {
        boolean z;
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                z = this.kip.get(valueOf) != null;
            }
            return z;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public boolean Jc(String str) {
        try {
            return this.kip.containsKey(Long.valueOf(Long.parseLong(str)));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void cKy() {
        synchronized (this) {
            this.kip.clear();
        }
    }
}
