package com.baidu.tieba.tbadkCore.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class r {
    protected volatile int fwA;
    protected volatile HashMap<Long, Integer> fwB = new HashMap<>();
    private volatile int fwz = 0;

    public r(int i) {
        this.fwA = i;
    }

    public void pW(String str) {
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                if (this.fwB.size() >= this.fwA) {
                    aUD();
                }
                this.fwz++;
                this.fwB.put(valueOf, Integer.valueOf(this.fwz));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void aUD() {
        synchronized (this) {
            int i = 134217727;
            Long l = null;
            for (Map.Entry<Long, Integer> entry : this.fwB.entrySet()) {
                if (entry.getValue().intValue() < i) {
                    i = entry.getValue().intValue();
                    l = entry.getKey();
                }
            }
            if (l != null) {
                this.fwB.remove(l);
            } else {
                this.fwB.clear();
            }
        }
    }

    public boolean pX(String str) {
        boolean z = false;
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                if (this.fwB.get(valueOf) != null) {
                    z = true;
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        return z;
    }

    public boolean pY(String str) {
        try {
            return this.fwB.containsKey(Long.valueOf(Long.parseLong(str)));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void biy() {
        synchronized (this) {
            this.fwB.clear();
        }
    }
}
