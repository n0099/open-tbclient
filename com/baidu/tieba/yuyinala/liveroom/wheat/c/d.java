package com.baidu.tieba.yuyinala.liveroom.wheat.c;

import android.app.Activity;
import android.content.Context;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes4.dex */
public class d {
    public static d odP;
    private a odQ;
    private CustomMessageListener odR = new CustomMessageListener(2501046) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.c.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501046) {
                if (d.this.odQ != null) {
                    d.this.odQ.yZ(true);
                }
                MessageManager.getInstance().unRegisterListener(d.this.odR);
            }
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
        void yZ(boolean z);
    }

    public static d dZj() {
        if (odP == null) {
            odP = new d();
        }
        return odP;
    }

    public void a(Context context, Activity activity, a aVar) {
        if (com.baidu.tieba.yuyinala.liveroom.wheat.e.f.a(context, activity)) {
            if (aVar != null) {
                aVar.yZ(true);
                return;
            }
            return;
        }
        this.odQ = aVar;
        MessageManager.getInstance().registerListener(this.odR);
    }
}
