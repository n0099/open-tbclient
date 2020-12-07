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
    private static g nBx;
    private VideoHolyCardModel.a lkZ = new VideoHolyCardModel.a() { // from class: com.baidu.tieba.video.g.2
        @Override // com.baidu.tieba.model.VideoHolyCardModel.a
        public void onResult(boolean z) {
            g.this.nBz = z;
        }
    };
    private boolean nBA;
    private VideoHolyCardModel nBy;
    private boolean nBz;

    public static g dTL() {
        if (nBx == null) {
            synchronized (g.class) {
                if (nBx == null) {
                    nBx = new g();
                }
            }
        }
        return nBx;
    }

    public boolean dTM() {
        return this.nBz;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dTN() {
        if (this.nBy == null) {
            this.nBy = new VideoHolyCardModel();
            this.nBy.a(this.lkZ);
        }
        this.nBy.diI();
    }

    public void gG(Context context) {
        if (this.nBz && !this.nBA) {
            l.showToast(context, R.string.free_data_tips);
            this.nBA = true;
        }
    }

    private g() {
        dTO();
        dTN();
    }

    private void dTO() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.video.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (j.isMobileNet()) {
                    g.this.dTN();
                }
            }
        });
    }
}
