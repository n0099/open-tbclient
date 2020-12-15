package com.baidu.tieba.yuyinala.liveroom.roomcard;

import android.app.Activity;
import android.content.Context;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes4.dex */
public class c {
    public static c opQ;
    private a opR;
    private CustomMessageListener opS = new CustomMessageListener(2501061) { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501061) {
                if (c.this.opR != null) {
                    c.this.opR.zE(true);
                }
                MessageManager.getInstance().unRegisterListener(c.this.opS);
            }
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
        void zE(boolean z);
    }

    public static c edU() {
        if (opQ == null) {
            opQ = new c();
        }
        return opQ;
    }

    public void a(Context context, Activity activity, a aVar) {
        if (i.a(context, activity)) {
            if (aVar != null) {
                aVar.zE(true);
                return;
            }
            return;
        }
        this.opR = aVar;
        MessageManager.getInstance().registerListener(this.opS);
    }
}
