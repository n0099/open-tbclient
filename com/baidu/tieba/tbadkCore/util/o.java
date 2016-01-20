package com.baidu.tieba.tbadkCore.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class o extends q {
    private volatile HashMap<String, Long> dJk;

    static {
        MessageManager.getInstance().registerListener(new p(CmdConfigCustom.METHOD_ACCOUNT_CHANGE));
    }

    public o(int i) {
        super(i);
        this.dJk = new HashMap<>();
    }

    public void bf(String str, String str2) {
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str2));
            synchronized (this) {
                if (this.dJk.size() >= this.dlR) {
                    atf();
                }
                this.dJk.put(str, valueOf);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public long mB(String str) {
        long longValue;
        try {
            synchronized (this) {
                longValue = this.dJk.get(str) != null ? this.dJk.get(str).longValue() : 0L;
            }
            return longValue;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return 0L;
        }
    }

    public void bg(String str, String str2) {
        String key;
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str2));
            synchronized (this) {
                Iterator<Map.Entry<String, Long>> it = this.dJk.entrySet().iterator();
                if (it.hasNext() && (key = it.next().getKey()) != null && key.equals(str)) {
                    this.dJk.remove(key);
                }
                this.dJk.put(str, valueOf);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    @Override // com.baidu.tieba.tbadkCore.util.q
    public void aGq() {
        synchronized (this) {
            this.dJm.clear();
            this.dJk.clear();
        }
    }
}
