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
    private static d mNv;
    private CustomMessageListener mNx = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.recapp.report.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2000994 && j.isNetWorkAvailable() && d.this.mNw != null) {
                d.this.mNw.dGh();
            }
        }
    };
    private e mNw = new h();

    public static d dGf() {
        if (mNv == null) {
            synchronized (d.class) {
                if (mNv == null) {
                    mNv = new d();
                }
            }
        }
        return mNv;
    }

    private boolean dGg() {
        return SwitchManager.getInstance().findType(AdUploadSwitch.KEY) != 0;
    }

    private d() {
        MessageManager.getInstance().registerListener(this.mNx);
    }

    public void a(c cVar) {
        if (dGg() && cVar != null && this.mNw != null) {
            if (j.isNetWorkAvailable()) {
                this.mNw.b(cVar);
            } else {
                this.mNw.c(cVar);
            }
        }
    }
}
