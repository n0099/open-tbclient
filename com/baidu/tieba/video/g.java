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
    private static g kuh;
    private VideoHolyCardModel.a inG = new VideoHolyCardModel.a() { // from class: com.baidu.tieba.video.g.2
        @Override // com.baidu.tieba.model.VideoHolyCardModel.a
        public void onResult(boolean z) {
            g.this.kuj = z;
        }
    };
    private VideoHolyCardModel kui;
    private boolean kuj;
    private boolean kuk;

    public static g cNI() {
        if (kuh == null) {
            synchronized (g.class) {
                if (kuh == null) {
                    kuh = new g();
                }
            }
        }
        return kuh;
    }

    public boolean cNJ() {
        return this.kuj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cNK() {
        if (this.kui == null) {
            this.kui = new VideoHolyCardModel();
            this.kui.a(this.inG);
        }
        this.kui.ceQ();
    }

    public void fy(Context context) {
        if (this.kuj && !this.kuk) {
            l.showToast(context, (int) R.string.free_data_tips);
            this.kuk = true;
        }
    }

    private g() {
        cNL();
        cNK();
    }

    private void cNL() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.video.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (j.isMobileNet()) {
                    g.this.cNK();
                }
            }
        });
    }
}
