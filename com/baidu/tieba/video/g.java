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
    private static g jvk;
    private VideoHolyCardModel.a hwh = new VideoHolyCardModel.a() { // from class: com.baidu.tieba.video.g.2
        @Override // com.baidu.tieba.model.VideoHolyCardModel.a
        public void bE(boolean z) {
            g.this.jvm = z;
        }
    };
    private VideoHolyCardModel jvl;
    private boolean jvm;
    private boolean jvn;

    public static g cua() {
        if (jvk == null) {
            synchronized (g.class) {
                if (jvk == null) {
                    jvk = new g();
                }
            }
        }
        return jvk;
    }

    public boolean cub() {
        return this.jvm;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cuc() {
        if (this.jvl == null) {
            this.jvl = new VideoHolyCardModel();
            this.jvl.a(this.hwh);
        }
        this.jvl.bOK();
    }

    public void ep(Context context) {
        if (this.jvm && !this.jvn) {
            l.showToast(context, (int) R.string.free_data_tips);
            this.jvn = true;
        }
    }

    private g() {
        cud();
        cuc();
    }

    private void cud() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2000994) { // from class: com.baidu.tieba.video.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (j.ke()) {
                    g.this.cuc();
                }
            }
        });
    }
}
