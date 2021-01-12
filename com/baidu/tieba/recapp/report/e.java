package com.baidu.tieba.recapp.report;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.j;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.tbadk.switchs.AdUploadSwitch;
/* loaded from: classes.dex */
public class e {
    private static e mNY;
    private CustomMessageListener mOa = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.recapp.report.e.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2000994 && j.isNetWorkAvailable() && e.this.mNZ != null) {
                e.this.mNZ.dCg();
            }
        }
    };
    private f mNZ = new i();

    public static e dCe() {
        if (mNY == null) {
            synchronized (e.class) {
                if (mNY == null) {
                    mNY = new e();
                }
            }
        }
        return mNY;
    }

    private boolean dCf() {
        return SwitchManager.getInstance().findType(AdUploadSwitch.KEY) != 0;
    }

    private e() {
        MessageManager.getInstance().registerListener(this.mOa);
    }

    public void a(c cVar) {
        if (dCf() && cVar != null && this.mNZ != null) {
            if (j.isNetWorkAvailable()) {
                this.mNZ.b(cVar);
            } else {
                this.mNZ.c(cVar);
            }
        }
    }
}
