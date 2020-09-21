package com.baidu.tieba.tbadkCore.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.HashMap;
/* loaded from: classes.dex */
public class c extends d {
    private volatile HashMap<String, Long> mrF;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.tbadkCore.util.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (TbadkCoreApplication.getInst().getPhotoLiveReadThreadHistory() != null) {
                    TbadkCoreApplication.getInst().getPhotoLiveReadThreadHistory().dBF();
                }
            }
        });
    }

    public c(int i) {
        super(i);
        this.mrF = new HashMap<>();
    }

    public long Rv(String str) {
        long longValue;
        try {
            synchronized (this) {
                longValue = this.mrF.get(str) != null ? this.mrF.get(str).longValue() : 0L;
            }
            return longValue;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return 0L;
        }
    }

    @Override // com.baidu.tieba.tbadkCore.util.d
    public void dBF() {
        synchronized (this) {
            this.mrG.clear();
            this.mrF.clear();
        }
    }
}
