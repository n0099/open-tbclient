package com.baidu.tieba.tbadkCore.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class q extends s {
    private volatile HashMap<String, Long> fxD;

    static {
        MessageManager.getInstance().registerListener(new r(CmdConfigCustom.METHOD_ACCOUNT_CHANGE));
    }

    public q(int i) {
        super(i);
        this.fxD = new HashMap<>();
    }

    public void bW(String str, String str2) {
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str2));
            synchronized (this) {
                if (this.fxD.size() >= this.fxF) {
                    aXk();
                }
                this.fxD.put(str, valueOf);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public long rs(String str) {
        long longValue;
        try {
            synchronized (this) {
                longValue = this.fxD.get(str) != null ? this.fxD.get(str).longValue() : 0L;
            }
            return longValue;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return 0L;
        }
    }

    public void bX(String str, String str2) {
        String key;
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str2));
            synchronized (this) {
                Iterator<Map.Entry<String, Long>> it = this.fxD.entrySet().iterator();
                if (it.hasNext() && (key = it.next().getKey()) != null && key.equals(str)) {
                    this.fxD.remove(key);
                }
                this.fxD.put(str, valueOf);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    @Override // com.baidu.tieba.tbadkCore.util.s
    public void bkN() {
        synchronized (this) {
            this.fxG.clear();
            this.fxD.clear();
        }
    }
}
