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
    private static g mcn;
    private VideoHolyCardModel.a jRE = new VideoHolyCardModel.a() { // from class: com.baidu.tieba.video.g.2
        @Override // com.baidu.tieba.model.VideoHolyCardModel.a
        public void onResult(boolean z) {
            g.this.mcp = z;
        }
    };
    private VideoHolyCardModel mco;
    private boolean mcp;
    private boolean mcq;

    public static g dpz() {
        if (mcn == null) {
            synchronized (g.class) {
                if (mcn == null) {
                    mcn = new g();
                }
            }
        }
        return mcn;
    }

    public boolean dpA() {
        return this.mcp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dpB() {
        if (this.mco == null) {
            this.mco = new VideoHolyCardModel();
            this.mco.a(this.jRE);
        }
        this.mco.cGl();
    }

    public void fv(Context context) {
        if (this.mcp && !this.mcq) {
            l.showToast(context, R.string.free_data_tips);
            this.mcq = true;
        }
    }

    private g() {
        dpC();
        dpB();
    }

    private void dpC() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.video.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (j.isMobileNet()) {
                    g.this.dpB();
                }
            }
        });
    }
}
