package com.baidu.tieba.tbadkCore.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class d extends e {
    private volatile HashMap<String, Long> giZ;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.tbadkCore.util.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (TbadkCoreApplication.getInst().getPhotoLiveReadThreadHistory() != null) {
                    TbadkCoreApplication.getInst().getPhotoLiveReadThreadHistory().bsl();
                }
            }
        });
    }

    public d(int i) {
        super(i);
        this.giZ = new HashMap<>();
    }

    public void cg(String str, String str2) {
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str2));
            synchronized (this) {
                if (this.giZ.size() >= this.gjb) {
                    baS();
                }
                this.giZ.put(str, valueOf);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public long rW(String str) {
        long longValue;
        try {
            synchronized (this) {
                longValue = this.giZ.get(str) != null ? this.giZ.get(str).longValue() : 0L;
            }
            return longValue;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return 0L;
        }
    }

    public void ch(String str, String str2) {
        String key;
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str2));
            synchronized (this) {
                Iterator<Map.Entry<String, Long>> it = this.giZ.entrySet().iterator();
                if (it.hasNext() && (key = it.next().getKey()) != null && key.equals(str)) {
                    this.giZ.remove(key);
                }
                this.giZ.put(str, valueOf);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    @Override // com.baidu.tieba.tbadkCore.util.e
    public void bsl() {
        synchronized (this) {
            this.gjc.clear();
            this.giZ.clear();
        }
    }
}
