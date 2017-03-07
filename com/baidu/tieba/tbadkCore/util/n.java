package com.baidu.tieba.tbadkCore.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class n extends r {
    private volatile HashMap<Long, com.baidu.tieba.myCollection.baseHistory.a> fwx;

    public n(int i) {
        super(i);
        this.fwx = new HashMap<>();
    }

    public void a(String str, com.baidu.tieba.myCollection.baseHistory.a aVar) {
        pW(str);
        try {
            Long valueOf = Long.valueOf(com.baidu.adp.lib.g.b.c(str, -1L));
            synchronized (this) {
                this.fwx.put(valueOf, aVar);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public com.baidu.tieba.myCollection.baseHistory.a pU(String str) {
        com.baidu.tieba.myCollection.baseHistory.a aVar;
        try {
            Long valueOf = Long.valueOf(com.baidu.adp.lib.g.b.c(str, -1L));
            synchronized (this) {
                aVar = this.fwx.get(valueOf) != null ? this.fwx.get(valueOf) : null;
            }
            return aVar;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    @Override // com.baidu.tieba.tbadkCore.util.r
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
                this.fwx.remove(l);
            } else {
                this.fwB.clear();
                this.fwx.clear();
            }
        }
    }
}
