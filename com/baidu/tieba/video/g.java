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
    private static g ngr;
    private VideoHolyCardModel.a kRs = new VideoHolyCardModel.a() { // from class: com.baidu.tieba.video.g.2
        @Override // com.baidu.tieba.model.VideoHolyCardModel.a
        public void onResult(boolean z) {
            g.this.ngt = z;
        }
    };
    private VideoHolyCardModel ngs;
    private boolean ngt;
    private boolean ngu;

    public static g dLS() {
        if (ngr == null) {
            synchronized (g.class) {
                if (ngr == null) {
                    ngr = new g();
                }
            }
        }
        return ngr;
    }

    public boolean dLT() {
        return this.ngt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dLU() {
        if (this.ngs == null) {
            this.ngs = new VideoHolyCardModel();
            this.ngs.a(this.kRs);
        }
        this.ngs.dby();
    }

    public void fW(Context context) {
        if (this.ngt && !this.ngu) {
            l.showToast(context, R.string.free_data_tips);
            this.ngu = true;
        }
    }

    private g() {
        dLV();
        dLU();
    }

    private void dLV() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.video.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (j.isMobileNet()) {
                    g.this.dLU();
                }
            }
        });
    }
}
