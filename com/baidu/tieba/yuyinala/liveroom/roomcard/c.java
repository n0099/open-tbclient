package com.baidu.tieba.yuyinala.liveroom.roomcard;

import android.app.Activity;
import android.content.Context;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes10.dex */
public class c {
    public static c ooA;
    private a ooB;
    private CustomMessageListener ooC = new CustomMessageListener(2501061) { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501061) {
                if (c.this.ooB != null) {
                    c.this.ooB.zA(true);
                }
                MessageManager.getInstance().unRegisterListener(c.this.ooC);
            }
        }
    };

    /* loaded from: classes10.dex */
    public interface a {
        void zA(boolean z);
    }

    public static c dZv() {
        if (ooA == null) {
            ooA = new c();
        }
        return ooA;
    }

    public void a(Context context, Activity activity, a aVar) {
        if (i.a(context, activity)) {
            if (aVar != null) {
                aVar.zA(true);
                return;
            }
            return;
        }
        this.ooB = aVar;
        MessageManager.getInstance().registerListener(this.ooC);
    }
}
