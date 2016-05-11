package com.baidu.tieba.tbadkCore.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class s {
    protected volatile int evl;
    protected volatile HashMap<Long, Integer> evm = new HashMap<>();
    private volatile int evk = 0;

    public s(int i) {
        this.evl = i;
    }

    public void oc(String str) {
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                if (this.evm.size() >= this.evl) {
                    aHz();
                }
                this.evk++;
                this.evm.put(valueOf, Integer.valueOf(this.evk));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void aHz() {
        synchronized (this) {
            int i = 134217727;
            Long l = null;
            for (Map.Entry<Long, Integer> entry : this.evm.entrySet()) {
                if (entry.getValue().intValue() < i) {
                    i = entry.getValue().intValue();
                    l = entry.getKey();
                }
            }
            if (l != null) {
                this.evm.remove(l);
            } else {
                this.evm.clear();
            }
        }
    }

    public boolean od(String str) {
        boolean z = false;
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            synchronized (this) {
                if (this.evm.get(valueOf) != null) {
                    z = true;
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        return z;
    }

    public boolean oe(String str) {
        try {
            return this.evm.containsKey(Long.valueOf(Long.parseLong(str)));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void aUR() {
        synchronized (this) {
            this.evm.clear();
        }
    }
}
