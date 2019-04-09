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
    private static g iUU;
    private VideoHolyCardModel.a gXI = new VideoHolyCardModel.a() { // from class: com.baidu.tieba.video.g.2
        @Override // com.baidu.tieba.model.VideoHolyCardModel.a
        public void bt(boolean z) {
            g.this.iUW = z;
        }
    };
    private VideoHolyCardModel iUV;
    private boolean iUW;
    private boolean iUX;

    public static g ciN() {
        if (iUU == null) {
            synchronized (g.class) {
                if (iUU == null) {
                    iUU = new g();
                }
            }
        }
        return iUU;
    }

    public boolean ciO() {
        return this.iUW;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ciP() {
        if (this.iUV == null) {
            this.iUV = new VideoHolyCardModel();
            this.iUV.a(this.gXI);
        }
        this.iUV.bDZ();
    }

    public void ex(Context context) {
        if (this.iUW && !this.iUX) {
            l.showToast(context, d.j.free_data_tips);
            this.iUX = true;
        }
    }

    private g() {
        ciQ();
        ciP();
    }

    private void ciQ() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2000994) { // from class: com.baidu.tieba.video.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (j.la()) {
                    g.this.ciP();
                }
            }
        });
    }
}
