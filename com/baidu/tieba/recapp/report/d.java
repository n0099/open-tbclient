package com.baidu.tieba.recapp.report;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.j;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.tbadk.switchs.AdUploadSwitch;
/* loaded from: classes.dex */
public class d {
    private static d mzk;
    private CustomMessageListener mzm = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.recapp.report.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2000994 && j.isNetWorkAvailable() && d.this.mzl != null) {
                d.this.mzl.dAV();
            }
        }
    };
    private e mzl = new h();

    public static d dAT() {
        if (mzk == null) {
            synchronized (d.class) {
                if (mzk == null) {
                    mzk = new d();
                }
            }
        }
        return mzk;
    }

    private boolean dAU() {
        return SwitchManager.getInstance().findType(AdUploadSwitch.KEY) != 0;
    }

    private d() {
        MessageManager.getInstance().registerListener(this.mzm);
    }

    public void a(c cVar) {
        if (dAU() && cVar != null && this.mzl != null) {
            if (j.isNetWorkAvailable()) {
                this.mzl.b(cVar);
            } else {
                this.mzl.c(cVar);
            }
        }
    }
}
