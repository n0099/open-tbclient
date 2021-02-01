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
    private static f nKL;
    private VideoHolyCardModel.a lui = new VideoHolyCardModel.a() { // from class: com.baidu.tieba.video.f.2
        @Override // com.baidu.tieba.model.VideoHolyCardModel.a
        public void onResult(boolean z) {
            f.this.nKN = z;
        }
    };
    private VideoHolyCardModel nKM;
    private boolean nKN;
    private boolean nKO;

    public static f dRX() {
        if (nKL == null) {
            synchronized (f.class) {
                if (nKL == null) {
                    nKL = new f();
                }
            }
        }
        return nKL;
    }

    public boolean dRY() {
        return this.nKN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dRZ() {
        if (this.nKM == null) {
            this.nKM = new VideoHolyCardModel();
            this.nKM.a(this.lui);
        }
        this.nKM.dgG();
    }

    public void gZ(Context context) {
        if (this.nKN && !this.nKO) {
            l.showToast(context, R.string.free_data_tips);
            this.nKO = true;
        }
    }

    private f() {
        dSa();
        dRZ();
    }

    private void dSa() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.video.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (j.isMobileNet()) {
                    f.this.dRZ();
                }
            }
        });
    }
}
