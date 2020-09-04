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
    private static d lHY;
    private CustomMessageListener lIa = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.recapp.report.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2000994 && j.isNetWorkAvailable() && d.this.lHZ != null) {
                d.this.lHZ.don();
            }
        }
    };
    private e lHZ = new h();

    public static d dol() {
        if (lHY == null) {
            synchronized (d.class) {
                if (lHY == null) {
                    lHY = new d();
                }
            }
        }
        return lHY;
    }

    private boolean dom() {
        return SwitchManager.getInstance().findType(AdUploadSwitch.KEY) != 0;
    }

    private d() {
        MessageManager.getInstance().registerListener(this.lIa);
    }

    public void a(c cVar) {
        if (dom() && cVar != null && this.lHZ != null) {
            if (j.isNetWorkAvailable()) {
                this.lHZ.b(cVar);
            } else {
                this.lHZ.c(cVar);
            }
        }
    }
}
