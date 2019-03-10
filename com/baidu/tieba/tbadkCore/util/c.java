package com.baidu.tieba.tbadkCore.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.HashMap;
/* loaded from: classes.dex */
public class c extends d {
    private volatile HashMap<String, Long> iIT;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2005016) { // from class: com.baidu.tieba.tbadkCore.util.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (TbadkCoreApplication.getInst().getPhotoLiveReadThreadHistory() != null) {
                    TbadkCoreApplication.getInst().getPhotoLiveReadThreadHistory().cfn();
                }
            }
        });
    }

    public c(int i) {
        super(i);
        this.iIT = new HashMap<>();
    }

    public long CN(String str) {
        long longValue;
        try {
            synchronized (this) {
                longValue = this.iIT.get(str) != null ? this.iIT.get(str).longValue() : 0L;
            }
            return longValue;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return 0L;
        }
    }

    @Override // com.baidu.tieba.tbadkCore.util.d
    public void cfn() {
        synchronized (this) {
            this.iIU.clear();
            this.iIT.clear();
        }
    }
}
