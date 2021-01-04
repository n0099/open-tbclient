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
    private static e mSG;
    private CustomMessageListener mSI = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.recapp.report.e.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2000994 && j.isNetWorkAvailable() && e.this.mSH != null) {
                e.this.mSH.dFX();
            }
        }
    };
    private f mSH = new i();

    public static e dFV() {
        if (mSG == null) {
            synchronized (e.class) {
                if (mSG == null) {
                    mSG = new e();
                }
            }
        }
        return mSG;
    }

    private boolean dFW() {
        return SwitchManager.getInstance().findType(AdUploadSwitch.KEY) != 0;
    }

    private e() {
        MessageManager.getInstance().registerListener(this.mSI);
    }

    public void a(c cVar) {
        if (dFW() && cVar != null && this.mSH != null) {
            if (j.isNetWorkAvailable()) {
                this.mSH.b(cVar);
            } else {
                this.mSH.c(cVar);
            }
        }
    }
}
