package com.baidu.tieba.yuyinala.liveroom.wheat.c;

import android.app.Activity;
import android.content.Context;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes11.dex */
public class d {
    public static d oFQ;
    private a oFR;
    private CustomMessageListener oFS = new CustomMessageListener(2501046) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501046) {
                if (d.this.oFR != null) {
                    d.this.oFR.Ab(true);
                }
                MessageManager.getInstance().unRegisterListener(d.this.oFS);
            }
        }
    };

    /* loaded from: classes11.dex */
    public interface a {
        void Ab(boolean z);
    }

    public static d edh() {
        if (oFQ == null) {
            oFQ = new d();
        }
        return oFQ;
    }

    public void a(Context context, Activity activity, a aVar) {
        if (com.baidu.tieba.yuyinala.liveroom.wheat.e.f.a(context, activity)) {
            if (aVar != null) {
                aVar.Ab(true);
                return;
            }
            return;
        }
        this.oFR = aVar;
        MessageManager.getInstance().registerListener(this.oFS);
    }
}
