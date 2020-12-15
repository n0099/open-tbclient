package com.baidu.tieba.tbadkCore.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class d {
    protected volatile int eXb;
    protected volatile HashMap<Long, Integer> npc = new HashMap<>();
    private volatile int mWeight = 0;

    public d(int i) {
        this.eXb = i;
    }

    public void Ua(String str) {
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                if (this.npc.size() >= this.eXb) {
                    dQu();
                }
                this.mWeight++;
                this.npc.put(valueOf, Integer.valueOf(this.mWeight));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void dQu() {
        int i;
        Long l;
        synchronized (this) {
            Long l2 = null;
            int i2 = 134217727;
            for (Map.Entry<Long, Integer> entry : this.npc.entrySet()) {
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
                this.npc.remove(l2);
            } else {
                this.npc.clear();
            }
        }
    }

    public boolean Ub(String str) {
        boolean z;
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                z = this.npc.get(valueOf) != null;
            }
            return z;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public boolean Uc(String str) {
        try {
            return this.npc.containsKey(Long.valueOf(Long.parseLong(str)));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void dQt() {
        synchronized (this) {
            this.npc.clear();
        }
    }
}
