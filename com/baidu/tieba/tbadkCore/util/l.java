package com.baidu.tieba.tbadkCore.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class l {
    private volatile int bZQ;
    private volatile HashMap<Long, Integer> cuf = new HashMap<>();
    private volatile int cue = 0;

    public l(int i) {
        this.bZQ = i;
    }

    public void jK(String str) {
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                if (this.cuf.size() >= this.bZQ) {
                    apC();
                }
                this.cue++;
                this.cuf.put(valueOf, Integer.valueOf(this.cue));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void apC() {
        synchronized (this) {
            int i = 134217727;
            Long l = null;
            for (Map.Entry<Long, Integer> entry : this.cuf.entrySet()) {
                if (entry.getValue().intValue() < i) {
                    i = entry.getValue().intValue();
                    l = entry.getKey();
                }
            }
            if (l != null) {
                this.cuf.remove(l);
            } else {
                this.cuf.clear();
            }
        }
    }

    public boolean jL(String str) {
        boolean z = false;
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                if (this.cuf.get(valueOf) != null) {
                    z = true;
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        return z;
    }
}
