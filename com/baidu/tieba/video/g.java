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
    private static g mEd;
    private VideoHolyCardModel.a kpJ = new VideoHolyCardModel.a() { // from class: com.baidu.tieba.video.g.2
        @Override // com.baidu.tieba.model.VideoHolyCardModel.a
        public void onResult(boolean z) {
            g.this.mEf = z;
        }
    };
    private VideoHolyCardModel mEe;
    private boolean mEf;
    private boolean mEg;

    public static g dEY() {
        if (mEd == null) {
            synchronized (g.class) {
                if (mEd == null) {
                    mEd = new g();
                }
            }
        }
        return mEd;
    }

    public boolean dEZ() {
        return this.mEf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dFa() {
        if (this.mEe == null) {
            this.mEe = new VideoHolyCardModel();
            this.mEe.a(this.kpJ);
        }
        this.mEe.cUH();
    }

    public void fO(Context context) {
        if (this.mEf && !this.mEg) {
            l.showToast(context, R.string.free_data_tips);
            this.mEg = true;
        }
    }

    private g() {
        dFb();
        dFa();
    }

    private void dFb() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.video.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (j.isMobileNet()) {
                    g.this.dFa();
                }
            }
        });
    }
}
