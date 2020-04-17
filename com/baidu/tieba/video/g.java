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
    private static g lhq;
    private VideoHolyCardModel.a jbw = new VideoHolyCardModel.a() { // from class: com.baidu.tieba.video.g.2
        @Override // com.baidu.tieba.model.VideoHolyCardModel.a
        public void onResult(boolean z) {
            g.this.lhs = z;
        }
    };
    private VideoHolyCardModel lhr;
    private boolean lhs;
    private boolean lht;

    public static g day() {
        if (lhq == null) {
            synchronized (g.class) {
                if (lhq == null) {
                    lhq = new g();
                }
            }
        }
        return lhq;
    }

    public boolean daz() {
        return this.lhs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void daA() {
        if (this.lhr == null) {
            this.lhr = new VideoHolyCardModel();
            this.lhr.a(this.jbw);
        }
        this.lhr.cry();
    }

    public void fp(Context context) {
        if (this.lhs && !this.lht) {
            l.showToast(context, (int) R.string.free_data_tips);
            this.lht = true;
        }
    }

    private g() {
        daB();
        daA();
    }

    private void daB() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.video.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (j.isMobileNet()) {
                    g.this.daA();
                }
            }
        });
    }
}
