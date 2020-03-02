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
    private static g kvl;
    private VideoHolyCardModel.a ipI = new VideoHolyCardModel.a() { // from class: com.baidu.tieba.video.g.2
        @Override // com.baidu.tieba.model.VideoHolyCardModel.a
        public void onResult(boolean z) {
            g.this.kvn = z;
        }
    };
    private VideoHolyCardModel kvm;
    private boolean kvn;
    private boolean kvo;

    public static g cPh() {
        if (kvl == null) {
            synchronized (g.class) {
                if (kvl == null) {
                    kvl = new g();
                }
            }
        }
        return kvl;
    }

    public boolean cPi() {
        return this.kvn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cPj() {
        if (this.kvm == null) {
            this.kvm = new VideoHolyCardModel();
            this.kvm.a(this.ipI);
        }
        this.kvm.cgw();
    }

    public void fy(Context context) {
        if (this.kvn && !this.kvo) {
            l.showToast(context, (int) R.string.free_data_tips);
            this.kvo = true;
        }
    }

    private g() {
        cPk();
        cPj();
    }

    private void cPk() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.video.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (j.isMobileNet()) {
                    g.this.cPj();
                }
            }
        });
    }
}
