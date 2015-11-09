package com.baidu.tieba.tbadkCore.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class o extends p {
    private volatile HashMap<String, Long> ddw;

    public o(int i) {
        super(i);
        this.ddw = new HashMap<>();
    }

    public void bg(String str, String str2) {
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str2));
            synchronized (this) {
                if (this.ddw.size() >= this.cHC) {
                    ayN();
                }
                this.ddw.put(str, valueOf);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public long lP(String str) {
        long longValue;
        try {
            synchronized (this) {
                longValue = this.ddw.get(str) != null ? this.ddw.get(str).longValue() : 0L;
            }
            return longValue;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return 0L;
        }
    }

    public void bh(String str, String str2) {
        String key;
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str2));
            synchronized (this) {
                Iterator<Map.Entry<String, Long>> it = this.ddw.entrySet().iterator();
                if (it.hasNext() && (key = it.next().getKey()) != null && key.equals(str)) {
                    this.ddw.remove(key);
                }
                this.ddw.put(str, valueOf);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
