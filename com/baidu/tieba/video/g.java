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
    private static g jxy;
    private VideoHolyCardModel.a hwP = new VideoHolyCardModel.a() { // from class: com.baidu.tieba.video.g.2
        @Override // com.baidu.tieba.model.VideoHolyCardModel.a
        public void onResult(boolean z) {
            g.this.jxA = z;
        }
    };
    private boolean jxA;
    private boolean jxB;
    private VideoHolyCardModel jxz;

    public static g csD() {
        if (jxy == null) {
            synchronized (g.class) {
                if (jxy == null) {
                    jxy = new g();
                }
            }
        }
        return jxy;
    }

    public boolean csE() {
        return this.jxA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csF() {
        if (this.jxz == null) {
            this.jxz = new VideoHolyCardModel();
            this.jxz.a(this.hwP);
        }
        this.jxz.bMx();
    }

    public void ef(Context context) {
        if (this.jxA && !this.jxB) {
            l.showToast(context, (int) R.string.free_data_tips);
            this.jxB = true;
        }
    }

    private g() {
        csG();
        csF();
    }

    private void csG() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.video.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (j.isMobileNet()) {
                    g.this.csF();
                }
            }
        });
    }
}
