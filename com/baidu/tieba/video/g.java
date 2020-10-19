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
    private static g mTQ;
    private VideoHolyCardModel.a kEV = new VideoHolyCardModel.a() { // from class: com.baidu.tieba.video.g.2
        @Override // com.baidu.tieba.model.VideoHolyCardModel.a
        public void onResult(boolean z) {
            g.this.mTS = z;
        }
    };
    private VideoHolyCardModel mTR;
    private boolean mTS;
    private boolean mTT;

    public static g dIK() {
        if (mTQ == null) {
            synchronized (g.class) {
                if (mTQ == null) {
                    mTQ = new g();
                }
            }
        }
        return mTQ;
    }

    public boolean dIL() {
        return this.mTS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dIM() {
        if (this.mTR == null) {
            this.mTR = new VideoHolyCardModel();
            this.mTR.a(this.kEV);
        }
        this.mTR.cYq();
    }

    public void fV(Context context) {
        if (this.mTS && !this.mTT) {
            l.showToast(context, R.string.free_data_tips);
            this.mTT = true;
        }
    }

    private g() {
        dIN();
        dIM();
    }

    private void dIN() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.video.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (j.isMobileNet()) {
                    g.this.dIM();
                }
            }
        });
    }
}
