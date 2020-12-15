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
    private static g nBz;
    private VideoHolyCardModel.a llb = new VideoHolyCardModel.a() { // from class: com.baidu.tieba.video.g.2
        @Override // com.baidu.tieba.model.VideoHolyCardModel.a
        public void onResult(boolean z) {
            g.this.nBB = z;
        }
    };
    private VideoHolyCardModel nBA;
    private boolean nBB;
    private boolean nBC;

    public static g dTM() {
        if (nBz == null) {
            synchronized (g.class) {
                if (nBz == null) {
                    nBz = new g();
                }
            }
        }
        return nBz;
    }

    public boolean dTN() {
        return this.nBB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dTO() {
        if (this.nBA == null) {
            this.nBA = new VideoHolyCardModel();
            this.nBA.a(this.llb);
        }
        this.nBA.diJ();
    }

    public void gG(Context context) {
        if (this.nBB && !this.nBC) {
            l.showToast(context, R.string.free_data_tips);
            this.nBC = true;
        }
    }

    private g() {
        dTP();
        dTO();
    }

    private void dTP() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.video.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (j.isMobileNet()) {
                    g.this.dTO();
                }
            }
        });
    }
}
