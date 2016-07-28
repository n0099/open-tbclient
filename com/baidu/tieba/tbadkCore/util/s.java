package com.baidu.tieba.tbadkCore.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class s {
    protected volatile int fne;
    protected volatile HashMap<Long, Integer> fnf = new HashMap<>();
    private volatile int fnd = 0;

    public s(int i) {
        this.fne = i;
    }

    public void qu(String str) {
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                if (this.fnf.size() >= this.fne) {
                    aTz();
                }
                this.fnd++;
                this.fnf.put(valueOf, Integer.valueOf(this.fnd));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void aTz() {
        synchronized (this) {
            int i = 134217727;
            Long l = null;
            for (Map.Entry<Long, Integer> entry : this.fnf.entrySet()) {
                if (entry.getValue().intValue() < i) {
                    i = entry.getValue().intValue();
                    l = entry.getKey();
                }
            }
            if (l != null) {
                this.fnf.remove(l);
            } else {
                this.fnf.clear();
            }
        }
    }

    public boolean qv(String str) {
        boolean z = false;
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                if (this.fnf.get(valueOf) != null) {
                    z = true;
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        return z;
    }

    public boolean qw(String str) {
        try {
            return this.fnf.containsKey(Long.valueOf(Long.parseLong(str)));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void bgA() {
        synchronized (this) {
            this.fnf.clear();
        }
    }
}
