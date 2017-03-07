package com.baidu.tieba.tbadkCore.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class p extends r {
    private volatile HashMap<String, Long> fwy;

    static {
        MessageManager.getInstance().registerListener(new q(CmdConfigCustom.METHOD_ACCOUNT_CHANGE));
    }

    public p(int i) {
        super(i);
        this.fwy = new HashMap<>();
    }

    public void ce(String str, String str2) {
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str2));
            synchronized (this) {
                if (this.fwy.size() >= this.fwA) {
                    aUD();
                }
                this.fwy.put(str, valueOf);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public long pV(String str) {
        long longValue;
        try {
            synchronized (this) {
                longValue = this.fwy.get(str) != null ? this.fwy.get(str).longValue() : 0L;
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
                Iterator<Map.Entry<String, Long>> it = this.fwy.entrySet().iterator();
                if (it.hasNext() && (key = it.next().getKey()) != null && key.equals(str)) {
                    this.fwy.remove(key);
                }
                this.fwy.put(str, valueOf);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    @Override // com.baidu.tieba.tbadkCore.util.r
    public void biy() {
        synchronized (this) {
            this.fwB.clear();
            this.fwy.clear();
        }
    }
}
