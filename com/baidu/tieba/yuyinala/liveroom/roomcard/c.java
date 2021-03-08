package com.baidu.tieba.yuyinala.liveroom.roomcard;

import android.app.Activity;
import android.content.Context;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes10.dex */
public class c {
    public static c oAV;
    private a oAW;
    private CustomMessageListener oAX = new CustomMessageListener(2501061) { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501061) {
                if (c.this.oAW != null) {
                    c.this.oAW.zV(true);
                }
                MessageManager.getInstance().unRegisterListener(c.this.oAX);
            }
        }
    };

    /* loaded from: classes10.dex */
    public interface a {
        void zV(boolean z);
    }

    public static c ebY() {
        if (oAV == null) {
            oAV = new c();
        }
        return oAV;
    }

    public void a(Context context, Activity activity, a aVar) {
        if (i.a(context, activity)) {
            if (aVar != null) {
                aVar.zV(true);
                return;
            }
            return;
        }
        this.oAW = aVar;
        MessageManager.getInstance().registerListener(this.oAX);
    }
}
