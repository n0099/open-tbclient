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
    private static g jwH;
    private VideoHolyCardModel.a hvY = new VideoHolyCardModel.a() { // from class: com.baidu.tieba.video.g.2
        @Override // com.baidu.tieba.model.VideoHolyCardModel.a
        public void onResult(boolean z) {
            g.this.jwJ = z;
        }
    };
    private VideoHolyCardModel jwI;
    private boolean jwJ;
    private boolean jwK;

    public static g csB() {
        if (jwH == null) {
            synchronized (g.class) {
                if (jwH == null) {
                    jwH = new g();
                }
            }
        }
        return jwH;
    }

    public boolean csC() {
        return this.jwJ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csD() {
        if (this.jwI == null) {
            this.jwI = new VideoHolyCardModel();
            this.jwI.a(this.hvY);
        }
        this.jwI.bMv();
    }

    public void ef(Context context) {
        if (this.jwJ && !this.jwK) {
            l.showToast(context, (int) R.string.free_data_tips);
            this.jwK = true;
        }
    }

    private g() {
        csE();
        csD();
    }

    private void csE() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.video.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (j.isMobileNet()) {
                    g.this.csD();
                }
            }
        });
    }
}
