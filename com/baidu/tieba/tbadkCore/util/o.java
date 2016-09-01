package com.baidu.tieba.tbadkCore.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class o extends s {
    private volatile HashMap<Long, com.baidu.tieba.myCollection.baseHistory.b> fuV;

    public o(int i) {
        super(i);
        this.fuV = new HashMap<>();
    }

    public void a(String str, com.baidu.tieba.myCollection.baseHistory.b bVar) {
        re(str);
        try {
            Long valueOf = Long.valueOf(com.baidu.adp.lib.h.b.c(str, -1L));
            synchronized (this) {
                this.fuV.put(valueOf, bVar);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public com.baidu.tieba.myCollection.baseHistory.b rc(String str) {
        com.baidu.tieba.myCollection.baseHistory.b bVar;
        try {
            Long valueOf = Long.valueOf(com.baidu.adp.lib.h.b.c(str, -1L));
            synchronized (this) {
                bVar = this.fuV.get(valueOf) != null ? this.fuV.get(valueOf) : null;
            }
            return bVar;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    @Override // com.baidu.tieba.tbadkCore.util.s
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
                this.fuV.remove(l);
            } else {
                this.fuZ.clear();
                this.fuV.clear();
            }
        }
    }
}
