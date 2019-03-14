package com.baidu.tieba.video;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.tieba.d;
import com.baidu.tieba.model.VideoHolyCardModel;
/* loaded from: classes.dex */
public class g {
    private static g iVf;
    private VideoHolyCardModel.a gXU = new VideoHolyCardModel.a() { // from class: com.baidu.tieba.video.g.2
        @Override // com.baidu.tieba.model.VideoHolyCardModel.a
        public void bt(boolean z) {
            g.this.iVh = z;
        }
    };
    private VideoHolyCardModel iVg;
    private boolean iVh;
    private boolean iVi;

    public static g ciP() {
        if (iVf == null) {
            synchronized (g.class) {
                if (iVf == null) {
                    iVf = new g();
                }
            }
        }
        return iVf;
    }

    public boolean ciQ() {
        return this.iVh;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ciR() {
        if (this.iVg == null) {
            this.iVg = new VideoHolyCardModel();
            this.iVg.a(this.gXU);
        }
        this.iVg.bEc();
    }

    public void ex(Context context) {
        if (this.iVh && !this.iVi) {
            l.showToast(context, d.j.free_data_tips);
            this.iVi = true;
        }
    }

    private g() {
        ciS();
        ciR();
    }

    private void ciS() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2000994) { // from class: com.baidu.tieba.video.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (j.la()) {
                    g.this.ciR();
                }
            }
        });
    }
}
