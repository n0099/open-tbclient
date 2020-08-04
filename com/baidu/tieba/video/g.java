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
    private static g mcp;
    private VideoHolyCardModel.a jRG = new VideoHolyCardModel.a() { // from class: com.baidu.tieba.video.g.2
        @Override // com.baidu.tieba.model.VideoHolyCardModel.a
        public void onResult(boolean z) {
            g.this.mcr = z;
        }
    };
    private VideoHolyCardModel mcq;
    private boolean mcr;
    private boolean mcs;

    public static g dpA() {
        if (mcp == null) {
            synchronized (g.class) {
                if (mcp == null) {
                    mcp = new g();
                }
            }
        }
        return mcp;
    }

    public boolean dpB() {
        return this.mcr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dpC() {
        if (this.mcq == null) {
            this.mcq = new VideoHolyCardModel();
            this.mcq.a(this.jRG);
        }
        this.mcq.cGl();
    }

    public void fv(Context context) {
        if (this.mcr && !this.mcs) {
            l.showToast(context, R.string.free_data_tips);
            this.mcs = true;
        }
    }

    private g() {
        dpD();
        dpC();
    }

    private void dpD() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.video.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (j.isMobileNet()) {
                    g.this.dpC();
                }
            }
        });
    }
}
