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
public class f {
    private static f nLl;
    private VideoHolyCardModel.a luw = new VideoHolyCardModel.a() { // from class: com.baidu.tieba.video.f.2
        @Override // com.baidu.tieba.model.VideoHolyCardModel.a
        public void onResult(boolean z) {
            f.this.nLn = z;
        }
    };
    private VideoHolyCardModel nLm;
    private boolean nLn;
    private boolean nLo;

    public static f dSf() {
        if (nLl == null) {
            synchronized (f.class) {
                if (nLl == null) {
                    nLl = new f();
                }
            }
        }
        return nLl;
    }

    public boolean dSg() {
        return this.nLn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dSh() {
        if (this.nLm == null) {
            this.nLm = new VideoHolyCardModel();
            this.nLm.a(this.luw);
        }
        this.nLm.dgN();
    }

    public void gZ(Context context) {
        if (this.nLn && !this.nLo) {
            l.showToast(context, R.string.free_data_tips);
            this.nLo = true;
        }
    }

    private f() {
        dSi();
        dSh();
    }

    private void dSi() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.video.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (j.isMobileNet()) {
                    f.this.dSh();
                }
            }
        });
    }
}
