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
    private static g kum;
    private VideoHolyCardModel.a inG = new VideoHolyCardModel.a() { // from class: com.baidu.tieba.video.g.2
        @Override // com.baidu.tieba.model.VideoHolyCardModel.a
        public void onResult(boolean z) {
            g.this.kuo = z;
        }
    };
    private VideoHolyCardModel kun;
    private boolean kuo;
    private boolean kup;

    public static g cNK() {
        if (kum == null) {
            synchronized (g.class) {
                if (kum == null) {
                    kum = new g();
                }
            }
        }
        return kum;
    }

    public boolean cNL() {
        return this.kuo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cNM() {
        if (this.kun == null) {
            this.kun = new VideoHolyCardModel();
            this.kun.a(this.inG);
        }
        this.kun.ceQ();
    }

    public void fy(Context context) {
        if (this.kuo && !this.kup) {
            l.showToast(context, (int) R.string.free_data_tips);
            this.kup = true;
        }
    }

    private g() {
        cNN();
        cNM();
    }

    private void cNN() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.video.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (j.isMobileNet()) {
                    g.this.cNM();
                }
            }
        });
    }
}
