package com.baidu.tieba.tbadkCore.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class d {
    protected volatile int bUX;
    protected volatile HashMap<Long, Integer> jbx = new HashMap<>();
    private volatile int mWeight = 0;

    public d(int i) {
        this.bUX = i;
    }

    public void Ej(String str) {
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                if (this.jbx.size() >= this.bUX) {
                    cnt();
                }
                this.mWeight++;
                this.jbx.put(valueOf, Integer.valueOf(this.mWeight));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void cnt() {
        int i;
        Long l;
        synchronized (this) {
            Long l2 = null;
            int i2 = 134217727;
            for (Map.Entry<Long, Integer> entry : this.jbx.entrySet()) {
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
                this.jbx.remove(l2);
            } else {
                this.jbx.clear();
            }
        }
    }

    public boolean Ek(String str) {
        boolean z;
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                z = this.jbx.get(valueOf) != null;
            }
            return z;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public boolean El(String str) {
        try {
            return this.jbx.containsKey(Long.valueOf(Long.parseLong(str)));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void cns() {
        synchronized (this) {
            this.jbx.clear();
        }
    }
}
