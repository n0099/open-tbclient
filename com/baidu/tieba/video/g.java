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
    private static g lAf;
    private VideoHolyCardModel.a jqD = new VideoHolyCardModel.a() { // from class: com.baidu.tieba.video.g.2
        @Override // com.baidu.tieba.model.VideoHolyCardModel.a
        public void onResult(boolean z) {
            g.this.lAh = z;
        }
    };
    private VideoHolyCardModel lAg;
    private boolean lAh;
    private boolean lAi;

    public static g dhK() {
        if (lAf == null) {
            synchronized (g.class) {
                if (lAf == null) {
                    lAf = new g();
                }
            }
        }
        return lAf;
    }

    public boolean dhL() {
        return this.lAh;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dhM() {
        if (this.lAg == null) {
            this.lAg = new VideoHolyCardModel();
            this.lAg.a(this.jqD);
        }
        this.lAg.cxZ();
    }

    public void fs(Context context) {
        if (this.lAh && !this.lAi) {
            l.showToast(context, (int) R.string.free_data_tips);
            this.lAi = true;
        }
    }

    private g() {
        dhN();
        dhM();
    }

    private void dhN() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.video.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (j.isMobileNet()) {
                    g.this.dhM();
                }
            }
        });
    }
}
