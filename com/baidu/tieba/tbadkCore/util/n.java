package com.baidu.tieba.tbadkCore.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class n extends r {
    private volatile HashMap<Long, com.baidu.tieba.myCollection.baseHistory.a> fAx;

    public n(int i) {
        super(i);
        this.fAx = new HashMap<>();
    }

    public void a(String str, com.baidu.tieba.myCollection.baseHistory.a aVar) {
        qo(str);
        try {
            Long valueOf = Long.valueOf(com.baidu.adp.lib.g.b.c(str, -1L));
            synchronized (this) {
                this.fAx.put(valueOf, aVar);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public com.baidu.tieba.myCollection.baseHistory.a qm(String str) {
        com.baidu.tieba.myCollection.baseHistory.a aVar;
        try {
            Long valueOf = Long.valueOf(com.baidu.adp.lib.g.b.c(str, -1L));
            synchronized (this) {
                aVar = this.fAx.get(valueOf) != null ? this.fAx.get(valueOf) : null;
            }
            return aVar;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    @Override // com.baidu.tieba.tbadkCore.util.r
    public void aVN() {
        synchronized (this) {
            int i = 134217727;
            Long l = null;
            for (Map.Entry<Long, Integer> entry : this.fAB.entrySet()) {
                if (entry.getValue().intValue() < i) {
                    i = entry.getValue().intValue();
                    l = entry.getKey();
                }
            }
            if (l != null) {
                this.fAB.remove(l);
                this.fAx.remove(l);
            } else {
                this.fAB.clear();
                this.fAx.clear();
            }
        }
    }
}
