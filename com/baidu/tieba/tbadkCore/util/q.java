package com.baidu.tieba.tbadkCore.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class q {
    protected volatile int dlR;
    protected volatile HashMap<Long, Integer> dJm = new HashMap<>();
    private volatile int dJl = 0;

    public q(int i) {
        this.dlR = i;
    }

    public void mC(String str) {
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                if (this.dJm.size() >= this.dlR) {
                    atf();
                }
                this.dJl++;
                this.dJm.put(valueOf, Integer.valueOf(this.dJl));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void atf() {
        synchronized (this) {
            int i = 134217727;
            Long l = null;
            for (Map.Entry<Long, Integer> entry : this.dJm.entrySet()) {
                if (entry.getValue().intValue() < i) {
                    i = entry.getValue().intValue();
                    l = entry.getKey();
                }
            }
            if (l != null) {
                this.dJm.remove(l);
            } else {
                this.dJm.clear();
            }
        }
    }

    public boolean mD(String str) {
        boolean z = false;
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                if (this.dJm.get(valueOf) != null) {
                    z = true;
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        return z;
    }

    public void aGq() {
        synchronized (this) {
            this.dJm.clear();
        }
    }
}
