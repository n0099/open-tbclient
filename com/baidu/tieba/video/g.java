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
/* loaded from: classes2.dex */
public class g {
    private static g mua;
    private VideoHolyCardModel.a khc = new VideoHolyCardModel.a() { // from class: com.baidu.tieba.video.g.2
        @Override // com.baidu.tieba.model.VideoHolyCardModel.a
        public void onResult(boolean z) {
            g.this.muc = z;
        }
    };
    private VideoHolyCardModel mub;
    private boolean muc;
    private boolean mud;

    public static g dAV() {
        if (mua == null) {
            synchronized (g.class) {
                if (mua == null) {
                    mua = new g();
                }
            }
        }
        return mua;
    }

    public boolean dAW() {
        return this.muc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dAX() {
        if (this.mub == null) {
            this.mub = new VideoHolyCardModel();
            this.mub.a(this.khc);
        }
        this.mub.cRa();
    }

    public void fI(Context context) {
        if (this.muc && !this.mud) {
            l.showToast(context, R.string.free_data_tips);
            this.mud = true;
        }
    }

    private g() {
        dAY();
        dAX();
    }

    private void dAY() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.video.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (j.isMobileNet()) {
                    g.this.dAX();
                }
            }
        });
    }
}
