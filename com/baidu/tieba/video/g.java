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
    private static g iUT;
    private VideoHolyCardModel.a gXU = new VideoHolyCardModel.a() { // from class: com.baidu.tieba.video.g.2
        @Override // com.baidu.tieba.model.VideoHolyCardModel.a
        public void bt(boolean z) {
            g.this.iUV = z;
        }
    };
    private VideoHolyCardModel iUU;
    private boolean iUV;
    private boolean iUW;

    public static g ciC() {
        if (iUT == null) {
            synchronized (g.class) {
                if (iUT == null) {
                    iUT = new g();
                }
            }
        }
        return iUT;
    }

    public boolean ciD() {
        return this.iUV;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ciE() {
        if (this.iUU == null) {
            this.iUU = new VideoHolyCardModel();
            this.iUU.a(this.gXU);
        }
        this.iUU.bEc();
    }

    public void ey(Context context) {
        if (this.iUV && !this.iUW) {
            l.showToast(context, d.j.free_data_tips);
            this.iUW = true;
        }
    }

    private g() {
        ciF();
        ciE();
    }

    private void ciF() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2000994) { // from class: com.baidu.tieba.video.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (j.la()) {
                    g.this.ciE();
                }
            }
        });
    }
}
