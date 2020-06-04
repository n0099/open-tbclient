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
    private static g lBo;
    private VideoHolyCardModel.a jrJ = new VideoHolyCardModel.a() { // from class: com.baidu.tieba.video.g.2
        @Override // com.baidu.tieba.model.VideoHolyCardModel.a
        public void onResult(boolean z) {
            g.this.lBq = z;
        }
    };
    private VideoHolyCardModel lBp;
    private boolean lBq;
    private boolean lBr;

    public static g dhZ() {
        if (lBo == null) {
            synchronized (g.class) {
                if (lBo == null) {
                    lBo = new g();
                }
            }
        }
        return lBo;
    }

    public boolean dia() {
        return this.lBq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dib() {
        if (this.lBp == null) {
            this.lBp = new VideoHolyCardModel();
            this.lBp.a(this.jrJ);
        }
        this.lBp.cyq();
    }

    public void fs(Context context) {
        if (this.lBq && !this.lBr) {
            l.showToast(context, (int) R.string.free_data_tips);
            this.lBr = true;
        }
    }

    private g() {
        dic();
        dib();
    }

    private void dic() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.video.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (j.isMobileNet()) {
                    g.this.dib();
                }
            }
        });
    }
}
