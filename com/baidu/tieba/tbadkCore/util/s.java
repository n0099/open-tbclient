package com.baidu.tieba.tbadkCore.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class s {
    protected volatile int fuY;
    protected volatile HashMap<Long, Integer> fuZ = new HashMap<>();
    private volatile int fuX = 0;

    public s(int i) {
        this.fuY = i;
    }

    public void re(String str) {
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                if (this.fuZ.size() >= this.fuY) {
                    aWM();
                }
                this.fuX++;
                this.fuZ.put(valueOf, Integer.valueOf(this.fuX));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void aWM() {
        synchronized (this) {
            int i = 134217727;
            Long l = null;
            for (Map.Entry<Long, Integer> entry : this.fuZ.entrySet()) {
                if (entry.getValue().intValue() < i) {
                    i = entry.getValue().intValue();
                    l = entry.getKey();
                }
            }
            if (l != null) {
                this.fuZ.remove(l);
            } else {
                this.fuZ.clear();
            }
        }
    }

    public boolean rf(String str) {
        boolean z = false;
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                if (this.fuZ.get(valueOf) != null) {
                    z = true;
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        return z;
    }

    public boolean rg(String str) {
        try {
            return this.fuZ.containsKey(Long.valueOf(Long.parseLong(str)));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void bkb() {
        synchronized (this) {
            this.fuZ.clear();
        }
    }
}
