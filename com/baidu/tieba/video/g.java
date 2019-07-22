package com.baidu.tieba.video;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.tieba.R;
import com.baidu.tieba.model.VideoHolyCardModel;
/* loaded from: classes.dex */
public class g {
    private static g jud;
    private VideoHolyCardModel.a hvp = new VideoHolyCardModel.a() { // from class: com.baidu.tieba.video.g.2
        @Override // com.baidu.tieba.model.VideoHolyCardModel.a
        public void bE(boolean z) {
            g.this.juf = z;
        }
    };
    private VideoHolyCardModel jue;
    private boolean juf;
    private boolean jug;

    public static g ctE() {
        if (jud == null) {
            synchronized (g.class) {
                if (jud == null) {
                    jud = new g();
                }
            }
        }
        return jud;
    }

    public boolean ctF() {
        return this.juf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ctG() {
        if (this.jue == null) {
            this.jue = new VideoHolyCardModel();
            this.jue.a(this.hvp);
        }
        this.jue.bOw();
    }

    public void eo(Context context) {
        if (this.juf && !this.jug) {
            l.showToast(context, (int) R.string.free_data_tips);
            this.jug = true;
        }
    }

    private g() {
        ctH();
        ctG();
    }

    private void ctH() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2000994) { // from class: com.baidu.tieba.video.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (j.ke()) {
                    g.this.ctG();
                }
            }
        });
    }
}
