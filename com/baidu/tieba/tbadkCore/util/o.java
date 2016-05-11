package com.baidu.tieba.tbadkCore.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class o extends s {
    private volatile HashMap<Long, com.baidu.tieba.myCollection.baseHistory.b> evi;

    public o(int i) {
        super(i);
        this.evi = new HashMap<>();
    }

    public void a(String str, com.baidu.tieba.myCollection.baseHistory.b bVar) {
        oc(str);
        try {
            Long valueOf = Long.valueOf(com.baidu.adp.lib.h.b.c(str, -1L));
            synchronized (this) {
                this.evi.put(valueOf, bVar);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public com.baidu.tieba.myCollection.baseHistory.b oa(String str) {
        com.baidu.tieba.myCollection.baseHistory.b bVar;
        try {
            Long valueOf = Long.valueOf(com.baidu.adp.lib.h.b.c(str, -1L));
            synchronized (this) {
                bVar = this.evi.get(valueOf) != null ? this.evi.get(valueOf) : null;
            }
            return bVar;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    @Override // com.baidu.tieba.tbadkCore.util.s
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
                this.evi.remove(l);
            } else {
                this.evm.clear();
                this.evi.clear();
            }
        }
    }
}
