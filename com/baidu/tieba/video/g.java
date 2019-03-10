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
    private static g iVn;
    private VideoHolyCardModel.a gXV = new VideoHolyCardModel.a() { // from class: com.baidu.tieba.video.g.2
        @Override // com.baidu.tieba.model.VideoHolyCardModel.a
        public void bt(boolean z) {
            g.this.iVp = z;
        }
    };
    private VideoHolyCardModel iVo;
    private boolean iVp;
    private boolean iVq;

    public static g ciM() {
        if (iVn == null) {
            synchronized (g.class) {
                if (iVn == null) {
                    iVn = new g();
                }
            }
        }
        return iVn;
    }

    public boolean ciN() {
        return this.iVp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ciO() {
        if (this.iVo == null) {
            this.iVo = new VideoHolyCardModel();
            this.iVo.a(this.gXV);
        }
        this.iVo.bEd();
    }

    public void ey(Context context) {
        if (this.iVp && !this.iVq) {
            l.showToast(context, d.j.free_data_tips);
            this.iVq = true;
        }
    }

    private g() {
        ciP();
        ciO();
    }

    private void ciP() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2000994) { // from class: com.baidu.tieba.video.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (j.la()) {
                    g.this.ciO();
                }
            }
        });
    }
}
