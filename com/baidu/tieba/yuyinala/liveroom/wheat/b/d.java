package com.baidu.tieba.yuyinala.liveroom.wheat.b;

import android.app.Activity;
import android.content.Context;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes4.dex */
public class d {
    public static d nWn;
    private a nWo;
    private CustomMessageListener nWp = new CustomMessageListener(2501046) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.b.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501046) {
                if (d.this.nWo != null) {
                    d.this.nWo.yR(true);
                }
                MessageManager.getInstance().unRegisterListener(d.this.nWp);
            }
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
        void yR(boolean z);
    }

    public static d dWl() {
        if (nWn == null) {
            nWn = new d();
        }
        return nWn;
    }

    public void a(Context context, Activity activity, a aVar) {
        if (com.baidu.tieba.yuyinala.liveroom.wheat.d.f.a(context, activity)) {
            if (aVar != null) {
                aVar.yR(true);
                return;
            }
            return;
        }
        this.nWo = aVar;
        MessageManager.getInstance().registerListener(this.nWp);
    }
}
