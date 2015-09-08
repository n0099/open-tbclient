package com.baidu.tieba.tbadkCore.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class m {
    private volatile int czh;
    private volatile HashMap<Long, Integer> cTi = new HashMap<>();
    private volatile int cTh = 0;

    public m(int i) {
        this.czh = i;
    }

    public void li(String str) {
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                if (this.cTi.size() >= this.czh) {
                    avl();
                }
                this.cTh++;
                this.cTi.put(valueOf, Integer.valueOf(this.cTh));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void avl() {
        synchronized (this) {
            int i = 134217727;
            Long l = null;
            for (Map.Entry<Long, Integer> entry : this.cTi.entrySet()) {
                if (entry.getValue().intValue() < i) {
                    i = entry.getValue().intValue();
                    l = entry.getKey();
                }
            }
            if (l != null) {
                this.cTi.remove(l);
            } else {
                this.cTi.clear();
            }
        }
    }

    public boolean lj(String str) {
        boolean z = false;
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                if (this.cTi.get(valueOf) != null) {
                    z = true;
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        return z;
    }
}
