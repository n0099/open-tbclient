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
    private static d myF;
    private CustomMessageListener myH = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.recapp.report.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2000994 && j.isNetWorkAvailable() && d.this.myG != null) {
                d.this.myG.dBr();
            }
        }
    };
    private e myG = new h();

    public static d dBp() {
        if (myF == null) {
            synchronized (d.class) {
                if (myF == null) {
                    myF = new d();
                }
            }
        }
        return myF;
    }

    private boolean dBq() {
        return SwitchManager.getInstance().findType(AdUploadSwitch.KEY) != 0;
    }

    private d() {
        MessageManager.getInstance().registerListener(this.myH);
    }

    public void a(c cVar) {
        if (dBq() && cVar != null && this.myG != null) {
            if (j.isNetWorkAvailable()) {
                this.myG.b(cVar);
            } else {
                this.myG.c(cVar);
            }
        }
    }
}
