package com.baidu.tieba.yuyinala.liveroom.roomcard;

import android.app.Activity;
import android.content.Context;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes4.dex */
public class c {
    public static c nRX;
    private a nRY;
    private CustomMessageListener nRZ = new CustomMessageListener(2501061) { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501061) {
                if (c.this.nRY != null) {
                    c.this.nRY.yK(true);
                }
                MessageManager.getInstance().unRegisterListener(c.this.nRZ);
            }
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
        void yK(boolean z);
    }

    public static c dVB() {
        if (nRX == null) {
            nRX = new c();
        }
        return nRX;
    }

    public void a(Context context, Activity activity, a aVar) {
        if (i.a(context, activity)) {
            if (aVar != null) {
                aVar.yK(true);
                return;
            }
            return;
        }
        this.nRY = aVar;
        MessageManager.getInstance().registerListener(this.nRZ);
    }
}
