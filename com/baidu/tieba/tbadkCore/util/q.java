package com.baidu.tieba.tbadkCore.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class q extends s {
    private volatile HashMap<String, Long> fuW;

    static {
        MessageManager.getInstance().registerListener(new r(CmdConfigCustom.METHOD_ACCOUNT_CHANGE));
    }

    public q(int i) {
        super(i);
        this.fuW = new HashMap<>();
    }

    public void bV(String str, String str2) {
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str2));
            synchronized (this) {
                if (this.fuW.size() >= this.fuY) {
                    aWM();
                }
                this.fuW.put(str, valueOf);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public long rd(String str) {
        long longValue;
        try {
            synchronized (this) {
                longValue = this.fuW.get(str) != null ? this.fuW.get(str).longValue() : 0L;
            }
            return longValue;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return 0L;
        }
    }

    public void bW(String str, String str2) {
        String key;
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str2));
            synchronized (this) {
                Iterator<Map.Entry<String, Long>> it = this.fuW.entrySet().iterator();
                if (it.hasNext() && (key = it.next().getKey()) != null && key.equals(str)) {
                    this.fuW.remove(key);
                }
                this.fuW.put(str, valueOf);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    @Override // com.baidu.tieba.tbadkCore.util.s
    public void bkb() {
        synchronized (this) {
            this.fuZ.clear();
            this.fuW.clear();
        }
    }
}
