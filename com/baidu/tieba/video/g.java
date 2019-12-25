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
    private static g kqE;
    private VideoHolyCardModel.a ika = new VideoHolyCardModel.a() { // from class: com.baidu.tieba.video.g.2
        @Override // com.baidu.tieba.model.VideoHolyCardModel.a
        public void onResult(boolean z) {
            g.this.kqG = z;
        }
    };
    private VideoHolyCardModel kqF;
    private boolean kqG;
    private boolean kqH;

    public static g cMD() {
        if (kqE == null) {
            synchronized (g.class) {
                if (kqE == null) {
                    kqE = new g();
                }
            }
        }
        return kqE;
    }

    public boolean cME() {
        return this.kqG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cMF() {
        if (this.kqF == null) {
            this.kqF = new VideoHolyCardModel();
            this.kqF.a(this.ika);
        }
        this.kqF.cdH();
    }

    public void fx(Context context) {
        if (this.kqG && !this.kqH) {
            l.showToast(context, (int) R.string.free_data_tips);
            this.kqH = true;
        }
    }

    private g() {
        cMG();
        cMF();
    }

    private void cMG() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.video.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (j.isMobileNet()) {
                    g.this.cMF();
                }
            }
        });
    }
}
