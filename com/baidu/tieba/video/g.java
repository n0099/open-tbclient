package com.baidu.tieba.video;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.tieba.R;
import com.baidu.tieba.model.VideoHolyCardModel;
/* loaded from: classes.dex */
public class g {
    private static g kxb;
    private VideoHolyCardModel.a iru = new VideoHolyCardModel.a() { // from class: com.baidu.tieba.video.g.2
        @Override // com.baidu.tieba.model.VideoHolyCardModel.a
        public void onResult(boolean z) {
            g.this.kxd = z;
        }
    };
    private VideoHolyCardModel kxc;
    private boolean kxd;
    private boolean kxe;

    public static g cPC() {
        if (kxb == null) {
            synchronized (g.class) {
                if (kxb == null) {
                    kxb = new g();
                }
            }
        }
        return kxb;
    }

    public boolean cPD() {
        return this.kxd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cPE() {
        if (this.kxc == null) {
            this.kxc = new VideoHolyCardModel();
            this.kxc.a(this.iru);
        }
        this.kxc.cgR();
    }

    public void fx(Context context) {
        if (this.kxd && !this.kxe) {
            l.showToast(context, (int) R.string.free_data_tips);
            this.kxe = true;
        }
    }

    private g() {
        cPF();
        cPE();
    }

    private void cPF() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.video.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (j.isMobileNet()) {
                    g.this.cPE();
                }
            }
        });
    }
}
