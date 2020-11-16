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
    private static g nnu;
    private VideoHolyCardModel.a kXG = new VideoHolyCardModel.a() { // from class: com.baidu.tieba.video.g.2
        @Override // com.baidu.tieba.model.VideoHolyCardModel.a
        public void onResult(boolean z) {
            g.this.nnw = z;
        }
    };
    private VideoHolyCardModel nnv;
    private boolean nnw;
    private boolean nnx;

    public static g dOt() {
        if (nnu == null) {
            synchronized (g.class) {
                if (nnu == null) {
                    nnu = new g();
                }
            }
        }
        return nnu;
    }

    public boolean dOu() {
        return this.nnw;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dOv() {
        if (this.nnv == null) {
            this.nnv = new VideoHolyCardModel();
            this.nnv.a(this.kXG);
        }
        this.nnv.ddx();
    }

    public void fV(Context context) {
        if (this.nnw && !this.nnx) {
            l.showToast(context, R.string.free_data_tips);
            this.nnx = true;
        }
    }

    private g() {
        dOw();
        dOv();
    }

    private void dOw() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.video.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (j.isMobileNet()) {
                    g.this.dOv();
                }
            }
        });
    }
}
