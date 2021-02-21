package com.baidu.tieba.yuyinala.liveroom.roomcard;

import android.app.Activity;
import android.content.Context;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes11.dex */
public class c {
    public static c oyQ;
    private a oyR;
    private CustomMessageListener oyS = new CustomMessageListener(2501061) { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501061) {
                if (c.this.oyR != null) {
                    c.this.oyR.zW(true);
                }
                MessageManager.getInstance().unRegisterListener(c.this.oyS);
            }
        }
    };

    /* loaded from: classes11.dex */
    public interface a {
        void zW(boolean z);
    }

    public static c ebQ() {
        if (oyQ == null) {
            oyQ = new c();
        }
        return oyQ;
    }

    public void a(Context context, Activity activity, a aVar) {
        if (i.a(context, activity)) {
            if (aVar != null) {
                aVar.zW(true);
                return;
            }
            return;
        }
        this.oyR = aVar;
        MessageManager.getInstance().registerListener(this.oyS);
    }
}
