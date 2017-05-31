package com.baidu.tieba.tbadkCore.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class r {
    protected volatile int fEB;
    protected volatile HashMap<Long, Integer> fEC = new HashMap<>();
    private volatile int fEA = 0;

    public r(int i) {
        this.fEB = i;
    }

    public void qv(String str) {
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                if (this.fEC.size() >= this.fEB) {
                    aUD();
                }
                this.fEA++;
                this.fEC.put(valueOf, Integer.valueOf(this.fEA));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void aUD() {
        synchronized (this) {
            int i = 134217727;
            Long l = null;
            for (Map.Entry<Long, Integer> entry : this.fEC.entrySet()) {
                if (entry.getValue().intValue() < i) {
                    i = entry.getValue().intValue();
                    l = entry.getKey();
                }
            }
            if (l != null) {
                this.fEC.remove(l);
            } else {
                this.fEC.clear();
            }
        }
    }

    public boolean qw(String str) {
        boolean z = false;
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                if (this.fEC.get(valueOf) != null) {
                    z = true;
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        return z;
    }

    public boolean qx(String str) {
        try {
            return this.fEC.containsKey(Long.valueOf(Long.parseLong(str)));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void bjb() {
        synchronized (this) {
            this.fEC.clear();
        }
    }
}
