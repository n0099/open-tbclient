package com.baidu.tieba.tbadkCore.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class p extends r {
    private volatile HashMap<String, Long> fEz;

    static {
        MessageManager.getInstance().registerListener(new q(CmdConfigCustom.METHOD_ACCOUNT_CHANGE));
    }

    public p(int i) {
        super(i);
        this.fEz = new HashMap<>();
    }

    public void ce(String str, String str2) {
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str2));
            synchronized (this) {
                if (this.fEz.size() >= this.fEB) {
                    aUD();
                }
                this.fEz.put(str, valueOf);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public long qu(String str) {
        long longValue;
        try {
            synchronized (this) {
                longValue = this.fEz.get(str) != null ? this.fEz.get(str).longValue() : 0L;
            }
            return longValue;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return 0L;
        }
    }

    public void cf(String str, String str2) {
        String key;
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str2));
            synchronized (this) {
                Iterator<Map.Entry<String, Long>> it = this.fEz.entrySet().iterator();
                if (it.hasNext() && (key = it.next().getKey()) != null && key.equals(str)) {
                    this.fEz.remove(key);
                }
                this.fEz.put(str, valueOf);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    @Override // com.baidu.tieba.tbadkCore.util.r
    public void bjb() {
        synchronized (this) {
            this.fEC.clear();
            this.fEz.clear();
        }
    }
}
