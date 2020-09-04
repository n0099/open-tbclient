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
    private static g mus;
    private VideoHolyCardModel.a khj = new VideoHolyCardModel.a() { // from class: com.baidu.tieba.video.g.2
        @Override // com.baidu.tieba.model.VideoHolyCardModel.a
        public void onResult(boolean z) {
            g.this.muu = z;
        }
    };
    private VideoHolyCardModel mut;
    private boolean muu;
    private boolean muv;

    public static g dBe() {
        if (mus == null) {
            synchronized (g.class) {
                if (mus == null) {
                    mus = new g();
                }
            }
        }
        return mus;
    }

    public boolean dBf() {
        return this.muu;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dBg() {
        if (this.mut == null) {
            this.mut = new VideoHolyCardModel();
            this.mut.a(this.khj);
        }
        this.mut.cRb();
    }

    public void fI(Context context) {
        if (this.muu && !this.muv) {
            l.showToast(context, R.string.free_data_tips);
            this.muv = true;
        }
    }

    private g() {
        dBh();
        dBg();
    }

    private void dBh() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.video.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (j.isMobileNet()) {
                    g.this.dBg();
                }
            }
        });
    }
}
